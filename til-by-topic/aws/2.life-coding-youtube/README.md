# 1. AWS Elastic Beanstalk

<details> <summary> 1. Elastic Beanstalk이란? </summary>

## 1. Elastic Beanstalk이란?
- AWS 인프라를 자동으로 관리해주는 역할을 한다.
- 기능
  - 용량 프로비저닝
  - 로드 밸런싱
  - 조정
  - 애플리케이션 상태 모니터링

</details>

<details> <summary> 2. Elastic Beanstalk 실습 </summary>

## 2. Elastic Beanstalk 실습

1. Elastic Beanstalk 화면에서 새 애플리케이션에서 애플리케이션 이름만 지정하고 생성
2. 애플리케이션을 구체적으로 동작시킬 서버를 생성하는것을 환경생성이라고하는데, 웹서버 환경을 선택
3. 환경이름 지정, 관리형 플랫폼언어 지정, 샘플 애플리케이션으로 해두고 추가옵션 구성 클릭
4. 사전 설정: 단일 인스턴스 / 용량: 편집-> nano로 변경 / 보안: 키페어 지정 / 으로 지정해서 환경 생성
5. index.php 작성후 압축 (php서버로 실습)
6. 생성한 환경에서 업로드 및 배포 클릭해서 zip파일 업로드
![image](https://user-images.githubusercontent.com/28394879/142143339-57e59535-ce6c-4dc4-b485-a637ab82f1ed.png)
7. 업로드가 완료되면 접속해보면 우리가 작성한 것이 잘 띄워진 것을 확인할 수 있다.
8. 애플리케이션 버전으로 들어가면 원하는 버전으로 돌리거나 업그레이드 하는식으로 바로 배포할 수 있다.



</details>


# 2. Route 53 

<details> <summary> 1. Route 53 - 원리 </summary>

## 1. Route 53 - 원리

![image](https://user-images.githubusercontent.com/28394879/142167016-5dbb712c-cfc1-4a47-8822-bd68d4c78513.png)


### 등록 요청
![image](https://user-images.githubusercontent.com/28394879/142167991-53bcaaba-80cd-4376-8241-2e95f0a861a0.png)

- 등록자(Registrant): 도메인을 등록하려고하는 사람
- 등록대행자(Registrar): 도메인을 구매하는것을 대행해주는 업체 (예: 가비아, aws route 53 등)
- 등록소(Registry): com, kr 과 같은 탑레벨 도메인을 관리하는 기관이 각각 다른데 이 기관들을 등록소라고 한다.

1. 34 서버에서 example.com을 사려고 registrar를 찾아가서 요청.
2. registrar가 .com에 해당하는 탑 레벨 도메인을 관리하는 registry에게 등록 요청 
3. registry가 수수료를 받고, registrant에게 사용할수 있는 권리를 줌
 
  
### 도메인에 IP 연결 (여기까지 해야 등록 완료)
![image](https://user-images.githubusercontent.com/28394879/142169451-0badbe13-cda9-4a5c-912c-4665a6d043c9.png)  
1. 어떤 도메인에 ip가 무엇인지를 전세계 사람들한태 서비스를 하려면 domain name server를 하나 가지고 있어야 한다. 
  - 직접 컴퓨터를 장만해서 깔아도 되고, 서비스로써 제공해주는 회사가 제공하는 도메인 네임 서버를 사용해도 됨 
  - Route53에서 도메인 네임 서버를 임대해주는 역할도 한다
2. 도메인 네임 서버에 example.com의 주소는 93.184.216.34 인것을 세팅해준다.
3. Registrar가 Registry에게 example.com을 관리하는 도메인 네임 서버가 a.iana-servers.net에 저장되어있다 라는 것을 알려주어야 한다.
4. Registry가 갖고있는 Domain Name Server에 example.com의 NameServer는 a.iana-servers.net이다 라고 기록한다.


### Client가 접속하는 과정 
![image](https://user-images.githubusercontent.com/28394879/142170474-7bf526ca-276b-4edb-a9f2-e8fd4b5df264.png)  

1. Client에서 인터넷에 연결시 통신 사업자가 이 컴퓨터가 사용할 도메인네임 서버를 자동으로 세팅해줌. (1.1.1.1)
2. Client가 example.com을 요청
3. 1.1.1.1에게 example.com의 아이피를 요청 
4. 1.1.1.1가 Root Name Server인 a.root-servers.net에게 example.com의 아이피를 요청
5. Root name server가 .com이라는 주소를 관리하는 등록소가 어떤 네임 서버를 운영하는지는 알아내서, a.gtld-servers.net을 1.1.1.1에게 응답
6. 1.1.1.1가 a.gtld-servers.net에게 example.com의 아이피를 요청
7. 1.1.1.1에게 a.iana-servers.net에 대한 정보를 응답
8. 1.1.1.1가 a.inan-servers.net에 접속해서 example.com에 대한 아이피를 요청 후 응답 
9. 1.1.1.1가 Client에게 example.com에 대한 아이피를 응답


### Route53의 역할 (핵심 기능)
- 등록대행자(Registrar)
- 도메인 네임 서버 임대

</details>

<details> <summary> 2. Route 53 - Route53으로 도메인 구입 </summary>

## 2. Route 53 - Route53으로 도메인 구입

1. 서비스에서 Route 53으로 이동
2. "등록된 도메인" 탭 클릭 
3. "도메인 등록" 클릭
4. 원하는 도메인 입력후 확인 
5. 정보들을 입력 후 Continue

도메인을 사면 기본적으로 도메인 네임 서버까지 임대 해주고, 세팅까지 되어 있다.
- 확인은 "호스팅 영역" 탭에서 해당하는 도메인 이름을 클릭해보면 볼 수 있다. 



</details>