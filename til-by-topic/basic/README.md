- [실전](#실전)
  - [timezone 문제 해결](#timezone-문제-해결)
    - [상황](#상황)
    - [문제점 - 등록 및 조회시](#문제점---등록-및-조회시)
    - [문제점 - 수정 혹은 on/off 시](#문제점---수정-혹은-onoff-시)
    - [해결 방법](#해결-방법)
    - [왜 backend에서 kst로 변경하면 문제가 될까?](#왜-backend에서-kst로-변경하면-문제가-될까)


# 실전 


## timezone 문제 해결 

### 상황

![image](https://github.com/sinkyoungdeok/TIL/assets/28394879/0baee68f-e38f-42ff-b044-7b0ee86a73b6)
- 특정 문구를 기간내에 보여주도록 등록하고, 상태를 on/off 할 수 있는 사이트.
- 사용자가 시작날짜와 종료날짜를 입력해서 프론트에서 시작날짜와 종료날짜를 백엔드로 전달하고 DB에 저장했음.
  - DB에는 동일한 시작날짜와 종료날짜로 저장되었고
  - localhost로 서버를 띄웠을 땐: 화면에서 시작날짜와 종료날짜가 정상적으로 보였다.
  - 하지만 ec2 서버에서 동작할 땐: 화면에서 시작날짜와 종료날짜가 DB에 저장된 시간보다 +9 시간 붙어서 보였다.
- 상태를 on/off로 바꾸게되면 
  - localhost로 서버를 띄웠을 땐: 문제 없이 잘 동작했다.
  - 하지만 ec2 서버에서 동작할 땐: on/off 할 때 마다 기존 시간 보다 +09:00 시간이 추가 됐다. 
  - 즉, on/off를 3번정도 누르면 14일이였던 시작날짜, 종료날짜가 15일로 바뀌었다.

### 문제점 - 등록 및 조회시

![image](https://github.com/sinkyoungdeok/TIL/assets/28394879/28564de7-41b8-4700-8794-a2e81bf20579)

**등록**
1. 유저가 6/14 00:00 을 입력하면 frontend에서는 이 값을 utc로 변환해서 6/13 15:00로 backend 로 전달한다.
2. backend에서는 전달받은 시간을 kst(seoul timezone)으로 변경해서 6/14 00:00로 DB에 저장한다.
3. 그러면 DB에는 6/14 00:00가 저장되어 있게 된다. (참고로 DB에는 timezone 정보를 저장하지 않았다.)

**조회 - 여기에서 local, ec2 다른점이 생김**
1. DB에 있던 6/14 00:00값을 backend에서 그대로 가져옴 (여기까진 동일)
2. backend에서 serialize 하면서 kst로 변경함 (여기부터 문제 발생)
   - localhost에서는 korea 기준이므로 6/14 00:00 시간이 korea니까 그대로 6/14 00:00그대로 변경됨
   - ec2에서는 uct 기준이므로 6/14 00:00 시간이 uct니까 korea로 바꾸면서 6/14 09:00로 변경됨
3. 변경된 시간을 front-end에 전달 
   - localhost에서는 문제 없지만
   - ec2에서는 등록했던 시간보다 9시간이 +된 상태에서 보임. 

### 문제점 - 수정 혹은 on/off 시
- 등록과 마찬가지인 문제인데 on/off 할 때 마다 front-end에서 전달받은 시작 날짜와 종료 날짜를 backend로 전달하면서 문제가 생김
  - localhost는 9시간이 안붙은상태에서 보여졌다가 그대로 전달하므로 문제가 없음.
  - ec2에서는 9시간이 붙은 상태에서 front-end에서 저장하고 있다가, 그대로 back-end로 전달하므로 DB에서 꺼낼 때 또 9시간이 붙음.
- 즉, on/off 한번 누를 때 마다 9시간씩 증가하는 문제가 발생.


### 해결 방법

![image](https://github.com/sinkyoungdeok/TIL/assets/28394879/bfdae6f3-b9d9-4b03-ad6f-9fb3411c61d8)

1. 원래는 저장시에 front-end 에서 전달받은 시간값을 back-end에서 kst로 변환하는 작업이 있었는데, 이 로직을 제거함. -> 그래서 DB에 그대로 저장 
2. 원래는 조회시에 DB에서 전달받은 시간값을 back-end에서 kst로 변환하는 작업이 있었는데, 이 로직을 제거함. -> 그래서 FE에 그대로 전달
3. front-end에서 back-end로부터 전달받은 시간값은 uct 기준이므로 이것을 kst로 변환하기 위해 +9시간을 붙여줌 
4. 원래 DB에서 데이터를 땡겨가는 ETL이 있었는데, 여기에도 +9시간을 붙여주는 로직을 추가함

즉
- backend & DB 까지는 utc를 유지하고
- frontend 나 땡겨가는쪽에서 9시간을 붙여줘서 처리하도록 변경했다.

### 왜 backend에서 kst로 변경하면 문제가 될까? 

```py
from datetime import datetime
from pytz import timezone


def convert_to_seoul_time(date_string):
    # 입력된 날짜 문자열을 datetime 객체로 변환
    date = datetime.strptime(date_string, "%Y-%m-%d %H:%M:%S")

    # 서울 시간대로 변환
    seoul_timezone = timezone('Asia/Seoul')
    seoul_date = date.astimezone(seoul_timezone)

    # 변환된 날짜를 원하는 형식으로 출력
    seoul_date_string = seoul_date.strftime("%Y-%m-%d %H:%M:%S")
    return seoul_date_string


# 테스트
date_string = "2023-06-06 15:00:00"
seoul_time = convert_to_seoul_time(date_string)
print(seoul_time)
```

- 위 로직을 local 환경에서 실행해보면 06-06 15:00:00가 나올 것이다.
- 그런데 ec2 환경이나 ideone같은 서버ide에서 실행해보면 06-07 00:00:00가 나온다.
- `2023-06-06T15:00:00.000Z` 값으로 들어오면 local, ec2 모두 같은 결과를 내지만 
- `2023-06-06 15:00:00` 값으로 들어오면 환경에따라서 다른 시간을 보여주게된다.