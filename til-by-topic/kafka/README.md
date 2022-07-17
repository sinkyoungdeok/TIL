
# 1. 아파치 카프카 개요 및 설명 
<details><summary> 자세히보기 </summary>

### 카프카가 없을 땐

1. 소스1 <--> 타겟1 단방향 통신

![image](https://user-images.githubusercontent.com/28394879/144202193-8d8d1314-3035-41f4-9aee-074ff759f4c0.png)

2. 소스N <--> 타겟M 굉장히 많은 단방향, 양방향 통신들

![image](https://user-images.githubusercontent.com/28394879/144202449-5bf61b65-ebb2-4d56-ad8b-324325bd53c5.png)


**1번 구조에서 2번구조로 점점 되가면서 생기는일들**
- 데이터 전송 라인이 많아 짐에 따라, 배포와 장애에 대응하기 어려워졌다.
- 데이터를 전송할 때 프로토콜 포멧의 파편화가 심각해졌다.
- 추후에 데이터의 포멧내부의 변경사항이 있을 때 유지보수가 힘들다


### 카프카 이후
![image](https://user-images.githubusercontent.com/28394879/144202817-6534b6cc-cf27-4156-9984-b1f5d70db790.png)
- 복잡함을 해결하기 위해 링크드인에서 내부적으로 개발
- 현재는 오픈소스로 제공 

### 카프카 특징
![image](https://user-images.githubusercontent.com/28394879/144203176-d15f48d1-7686-4e9d-bcb2-b3b4d7e12792.png)
- 소스 애플리케이션과 타겟 애플리케이션의 커플링을 약하게 해줌
- 소스 애플리케이션은 아파치 카프카에 데이터를 전송하면 된다.
- 타겟 애플리케이션에서는 아파치 카프카에서 데이터를 가져오면 된다.
- 예) 쇼핑몰
  - 소스 애플리케이션 
    - 클릭 로그
    - 결제 로그
  - 타겟 애플리케이션
    - 로그 적재
    - 로그 처리
- 소스 애플리케이션에서 보낼 수 있는 데이터형식은 거의 제한이 없다.


![image](https://user-images.githubusercontent.com/28394879/144203636-a14d31d6-bb2a-4c9f-9702-cd1d7f8a92da.png)
- 토픽
  - 하나의 토픽이 하나의 큐라고 생각하면된다.
- Producer
  - 데이터를 송신
- Consumer
  - 데이터를 수신
 

### 카프카의 장점 
- fault tolerant
  - 고가용성으로 서버가 이슈 생기거나 갑작스럽게 랙(전원이) 내려가는 상황에서도 데이터를 손실 없이 복구할 수 있다.
- 낮은 지연(latency)와 높은 처리량(Throughput)를 통해서 아주 효과적으로 데이터를 많이 처리할 수 있다.
  - 빅데이터 처리에서는 거의 무조건 사용하고 있다.


</details>

# 2. 토픽이란?
<details><summary> 자세히보기 </summary>

### 카프카 토픽 특징
![image](https://user-images.githubusercontent.com/28394879/144206455-f96f3955-b071-48b9-a54b-93db52318b23.png)

- 카프카에서는 토픽을 여러개 생성할 수 있다.
- 토픽은 데이터베이스의 테이블이나 파일시스템의 폴더와 유사한 성질을 가지고 있다.
- Producer가 데이터를 가져가고 Consumer는 데이터를 가져가게 된다.
- 토픽은 이름을 가질 수 있는데 목적에 따라 무슨 데이터를 담는지 명확하게 명시하면 추후 유지보수 시 편리하게 관리할 수 있다.


### 카프카 토픽 내부 (파티션이 1개 일 경우)
![image](https://user-images.githubusercontent.com/28394879/144207010-bc5d1494-663d-4bbf-b814-1ed63504f906.png)

- 하나의 토픽은 여러개의 파티션으로 구성될 수 있다.
- 첫번째 파티션 번호는 0번부터 시작한다.
- 하나의 파티션은 큐와 같이 내부에 데이터가 파티션끝에서부터 차곡차곡 쌓인다.
- 클릭로그 토픽에 카프카 컨슈머가 붙게되면 데이터를 가장 오래된 순서대로 가져간다. (0번부터 6번까지)
- 더이상 데이터가 들어오지 않으면 컨슈머는 또 다른 데이터가 들어올때까지 기다린다.
- 컨슈머가 record들을 가져가도 데이터는 삭제되지 않는다.
- 새로운 컨슈머가 붙었을 때 다시 0번부터 가져가서 사용할 수 있다.
  - 다만 컨슈머 그룹이 달라야 하고, auto.offset.reset=earlieast로 설정되어 있어야 한다.
- 동일데이터를 두번 처리할 수 있는데 이게 카프카를 사용하는 아주 중요한 이유기도 하다.
 

### 카프카 토픽 내부 (파티션이 2개이상 일 경우)
![image](https://user-images.githubusercontent.com/28394879/144208476-7b8e7c66-fd5d-4803-801d-9a556496b147.png)

1. 키가 null 이고, 기본 파티셔너 사용할 경우
   - 라운드 로빈(Round robin)으로 할당
2. 키가 있고, 기본 파티셔너 사용할 경우
   - 키의 해시(hash)값을 구하고, 특정 파티션에 할당

- 파티션을 늘리는것은 조심해야 한다. 
  - 파티션을 늘릴 수는 있지만, 파티션을 다시 줄일 수 없기 떄문이다.
- 파티션의 레코드는 언제 삭제되나? 옵션에 따른다.
  - log.retentions.ms: 최대 record 보존 시간
  - log.retentions.byte: 최대 record 보존 크기(byte)


</details>

# 3. 브로커, 복제, ISR(In-Sync-Replication)
<details><summary> 자세히보기 </summary>

### Kafka broker
- 카프카가 설치되어 있는 서버 단위
- 보통 3개이상의 broker로 구성하여 사용하는 것을 권장

![image](https://user-images.githubusercontent.com/28394879/144804154-d1d4235f-d9f8-4534-9a33-36a5faf63352.png)

### Kafka replication
- replication은 partition의 복제를 뜻한다.

![image](https://user-images.githubusercontent.com/28394879/144804478-8411359a-3492-4929-b69c-57221dd2a0a5.png)
- 만약 파티션이이 1개이고 replication이 1인 topic이 존재하고 브로커가 3대라면, 브로커 3대중 1대에 해당 토픽의 정보(데이터)가 저장된다 


![image](https://user-images.githubusercontent.com/28394879/144804664-4cded1c6-90d6-4ed0-bb51-2f6055d4d6eb.png)
- 만약 파티션이 1개이고 replication이 2인 topic이 존재하고 브로커가 3대라면, 파티션은 원본1개와 복제본 1개로 총2개가 존재한다. 

![image](https://user-images.githubusercontent.com/28394879/144807916-6a839712-5356-45ce-9977-e6ab7d2db273.png)
- 파티션이 1개이고, replication이 3인 topic이 존재하고 브로커가 3대라면, 파티션은 원본1개와 복제본 2개로 총3개가 존재한다. 

브로커개수가 3이면 replication은 4가 될 수 없다. 

![image](https://user-images.githubusercontent.com/28394879/144808241-08c604ae-e582-488d-8f5b-48611faf84ca.png)
- 원본 파티션은 Leader partition이라고 부른다. 
- 나머지 파티션은 Follower partition이라고 부른다. 

### Kafka ISR

![image](https://user-images.githubusercontent.com/28394879/144808313-6d0601c0-aecb-4fd9-bd23-8d5cf09dde99.png)
- Leader partition + Follower partition 을 ISR이라고한다.
- ISR은 In Sync Replica의 줄임말이다. 


### Why replica? (왜 복제를하나?)
- partition의 고가용성을 위해서 사용한다. 
- replication이 1이고 partition 1인 topic이 존재 한다면, 갑자기 브로커가 고장나면 더이상 해당 파티션을 복구할 수 없게된다.
- 만약 replication이 2이면, Follower Partition을 통해서 복구가 가능해지고, Follower Partition이 Leader Partition으로 승계하게 된다.
  
### Replication&ack
- 프로듀서가 토픽의 파티션에 데이터를 전달할 때, 전달 받는 주체가 Leader Partition이다.
- 프로듀서에는 ack라는 상세 옵션이 있다
  - ack를 통해 고가용성을 유지할 수 있다
  - 이 옵션은 partition의 replication과 관련이 있다.
- ack는 0, 1, all 중에 1개를 골라서 설정할 수 있다.

**ack가 0인경우**  
![image](https://user-images.githubusercontent.com/28394879/144809372-6066a815-730c-4306-b229-4612bafa4dda.png)
- 프로듀서가 Leader Partition에 데이터를 전송하고, 응답값을 받지않는다.
- Leader Partition에 데이터가 정상적으로 전송됐는지 그리고 나머지 partition에 정상적으로 복제되었는지 알 수 없고, 보장할 수 없다.
- 속도는 빠르지만 데이터 유실 가능성이 있다.


**ack가 1인경우**  
![image](https://user-images.githubusercontent.com/28394879/144809692-b768e6bf-b8e6-43bf-b0b1-ad77c37b5b7a.png)
- Leader Partition에 데이터를 전송하고, Leader Partition이 데이터를 정상적으로 받았는지 응답값을 받는다.
- 나머지 Partition에 복제되었는지는 알 수 없다.
- Leader Partition이 데이터를 받은 즉시 브로커가 장애가 난다면 나머지 Partition에 데이터가 미처 전송되지 못한 상태이므로 이전에 ack 0옵션과 마찬가지로 데이터 유실 가능성이 있다

**ack all인경우**  
![image](https://user-images.githubusercontent.com/28394879/144810819-049d6a73-42de-4394-811b-6ee6848494fe.png)
- follower partition에 복제가 잘 이루어졌는지 응답값을 전달받는다.
- Leader Partition에 데이터를 보낸후, Follower Partition에도 데이터가 저장되는 것을 확인하는 절차를 거친다.
- 이 경우 데이터 유실은 없다.
- ack 0, 1 에 비해 확인하는 부분이 많기 때문에 속도가 현저히 느리다는 단점이 있다 

### Replication count
![image](https://user-images.githubusercontent.com/28394879/144811637-7bd0c275-017b-4153-9443-de4d182d8c44.png)
- replication 갯수가 많을수록 브로커의 리소스 사용량도 늘어난다.
- 따라서 카프카에 들어오는 데이터량과 retention data즉 저장시간을 잘 생각해서 replication의 개수를 정해야한다.

![image](https://user-images.githubusercontent.com/28394879/144811717-9242e16f-109d-4915-83b2-502154e2c229.png)
- 3개 이상의 브로커를 사용 할 때 replication은 3으로 설정하는 것이 좋다.

</details>

# 4. 파티셔너(Partitioner)란?
<details><summary> 자세히보기 </summary>

### 파티셔너란
![image](https://user-images.githubusercontent.com/28394879/144813124-6cca8429-5e44-4b73-8f7f-867d1683eefb.png)
- 프로듀서가 데이터를 보내면 무조건 파티셔너를 통해서 브로커로 데이터가 전송된다.
- 파티셔너는 데이터를 토픽에 어떤 파티션에 넣을지 결정하는 역할을 한다.
- 레코드에 포함된 메시지 키 또는 메시지 값에 따라서 파티션의 위치가 결정되게 된다.
- 프로듀서를 사용할 때, 파티셔너를 따로 설정하지 않으면 UniformStickyPartitioner로 설정이 된다.
- 메시지 키가 있을 때 없을 때 다르게 동작한다.

### 메시지 키가 있는 경우
![image](https://user-images.githubusercontent.com/28394879/144813498-7380137a-ad23-4197-8962-861858ead3be.png)
- 메시지키를 가진 레코드는 파티셔너에 의해서 특정한 해쉬값이 생성되는데, 이 해쉬값을 기준으로 어느 파티션으로 들어갈지 정해진다.

**토픽에 파티션이 2개인 경우**   
![image](https://user-images.githubusercontent.com/28394879/144813597-4236868f-2f2a-4e6b-b727-4651b01d8483.png)
- 동일한 메시지 키를 가진 레코드는 동일한 해쉬값을 만들기 떄문에, 항상 동일한 파티션에 들어가는 것을 보장한다.
- 이렇게 동일한 메시지 키를 가진 레코드들은 동일한 파티션에 들어가기 떄문에, 순서를 지켜서 데이터를 처리할 수 있다는 장점이 있다 
  - 예) 서울의 온도를 기록하는 레코드를 파티션에 집어넣는다.
  - 메시지키에 "서울"이라는 String값을 넣고 레코드를 지속적으로 보낸다면 항상 동일한 파티션에 데이터가 순서대로 들어가기 떄문에 컨슈머는 서울이라는 레코드를 순서를 지켜서 데이터를 처리할 수 있다.


### 메시지 키가 없는 경우

- 라운드 로빈으로 파티션에 들어간다.
- 전통적인 라운드 로빈 방식과는 조금 다르게 동작 한다.
- UniformStickyPartition는 프로듀서에서 배치로 모을 수 있는 최대한의 레코드들을 모아서 파티션으로 데이터를 보내게 된다.
  - 이렇게 배치단위로 데이터를 보낼 때 파티션에 라운드로빈 방식으로 돌아가면서 넣게 된다.
- 쉽게말해서 메시지키가 없는 레코드들은 파티션에 적절히 분배된다.


기본 파티셔너 뿐만아니라 직접 개발한 파티셔너도 사용할 수 있다.   
카프카에서는 Partitioner 인터페이스를 제공함으로써 직접 개발한 파티셔너를 사용할 수 있게 제공한다. 
- VIP고객을 위해서 10개의 파티션 중에서 8개 파티션에는 VIP고객의 데이터, 2개는 일반 사용자를 위한 파티션으로 구성하여 데이터 처리량을 VIP고객을 위해서 몰아주는 방식으로도 개발할 수 있다. 

</details>

# 5. 컨슈머 랙(Consumer Lag)이란?
<details><summary> 자세히보기 </summary>

### 컨슈머 랙
![image](https://user-images.githubusercontent.com/28394879/144820496-3ca4fa29-f76d-4d57-a81b-636a783917c6.png)
- 카프카 프로듀서는 토픽의 파티션에 데이터를 차곡차곡 넣는다.
- 이 파티션에 데이터가 하나 하나 들어가면, 각 데이터는 오프셋이라고하는 숫자가 1개붙는다.
- 만약 파티션이 1개라면, 0부터 차례대로 숫자가 매겨진다.
- 프로듀서는 계속해서 데이터를 넣게되고, 컨슈머는 계속해서 데이터를 가져간다.
- 만약 프로듀서가 데이터를 넣어주는 속도가 컨슈머가 가져가는 속도보다 빠르면 어떻게 될까? 
  - 1) 프로듀서가 넣은 데이터의 오프셋 
  - 2) 컨슈머가 가져간 데이터의 오프셋
  - 1),2) 두개의 오프셋 간에 차이가 발생한다.
  - 이게 바로 Consumer lag이다.
- Consumer Lag의 숫자를 통해 현재 해당 토픽에 대해 파이프라인으로 연계되어 있는 프로듀서와 컨슈머의 상태에 대해 유추가 가능하다.
  - 주로 컨슈머의 상태에 대해 볼 때 사용한다.
- Consumer Lag은 각 파티션의 오프셋기준으로 프로듀서가 넣은 데이터의 오프셋과 컨슈머가 가져가는 데이터의 오프셋의 차이를 기반으로 한다.

![image](https://user-images.githubusercontent.com/28394879/144821374-ee1d2d80-06d3-49e5-8805-fc1494449cb5.png)
- 위의 그림은 컨슈머 그룹이 1개이고, 파티션이 2개인 토픽에서 데이터를 가져간다면 lag은 2개가 측정될 수 있다.
- 토픽에 여러 파티션이 존재할 경우 Consumer Lag은 여러개가 존재할 수 있다.
- 이렇게 한개의 토픽과 컨슈머 그룹에 대한 lag이 여러개 존재할 수 있을 때 그 중 높은 숫자의 lag을 **records-lag-max**라고 부른다.  
 

</details>

# 6. 컨슈머 랙 모니터링 애플리케이션, 카프카 버로우(Burrow)
<details><summary> 자세히보기 </summary>

</details>
