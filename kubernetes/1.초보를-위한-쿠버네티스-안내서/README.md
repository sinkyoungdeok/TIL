# 목차

1. [쿠버네티스 시작하기](#1-쿠버네티스-시작하기)
2. [쿠버네티스 알아보기](#2-쿠버네티스-알아보기)
3. [쿠버네티스 실습 준비](#3-쿠버네티스-실습-준비)
4. [쿠버네티스 기본 실습](#4-쿠버네티스-기본-실습)


# 1. 쿠버네티스 시작하기



<details>
<summary>1. 컨테이너 오케스트레이션 1/4(서버를 관리한다는것)</summary>

## 1. 컨테이너 오케스트레이션 1/4(서버를 관리한다는것)

- 처음에는 ppt와 같은 문서로 서버를 관리 했지만, 너무 복잡했었다.
- 그래서 등장한게 CHEF, ANSIBLE, PUPPET 와 같이 문서보다는 코드로 관리하게 되었다.
- 이 설정 관리 도구도 공부를 해야 된다는 문제도 있었고, 서버를 복잡하게 관리하다보면 결국 관리 자체도 쉽지 않았다.
- 그래서 나타난 것이, 가상 머신이다. 서버 하나에 가상머신 여러개! 조금 느리고 관리가 불편하지만 나쁘지 않았다.
- 하지만, 이것도 클라우드에는 적용이 안되고, 특정 벤더에 dependency도 생기고 느리다는 단점 등이 존재 했다.
- 이때, 도커가 등장하게 된다.

</details>





<details>
<summary>2. 컨테이너 오케스트레이션 2/4(도커의 등장)</summary>

## 2. 컨테이너 오케스트레이션 2/4(도커의 등장)

- 모든 실행환경을 컨테이너로!
- 어디서든 동작하고 쉽고 효율적이다.

### 컨테이너의 특징
- 가상 머신과 비교하여 컨테이너 생성이 쉽고 효율적
- 컨테이너 이미지를 이용한 배포와 롤백이 간단
- 언어나 프레임워크에 상관없이 애플리케이션을 동일한 방식으로 관리
- 개발, 테스팅, 운영 환경은 물론 로컬 피시와 클라우드까지 동일한 환경을 구축
- 특정 클라우드 벤더에 종속적이지 않음

![image](https://user-images.githubusercontent.com/28394879/131446052-22870fea-3eb5-4664-a4e0-d83fb3becd25.png)


![image](https://user-images.githubusercontent.com/28394879/131446177-cfc2c567-14a1-4d3c-ad09-50704e9fb7c0.png)
- 과거에는 어떤 언어나 프레임워크를 쓰느냐에 따라서 방법이 달랐었다.
- 도커 등장이후로 동일한 방식으로 배포가 가능하다.
- 하지만, 컨테이너가 많아질수록 관리가 힘들어지는 단점이 존재했었다.


</details>





<details>
<summary>3. 컨테이너 오케스트레이션 3/4(도커 그 이후)</summary>

## 3. 컨테이너 오케스트레이션 3/4(도커 그 이후)

### 1. 배포는 어떻게 할까 ?
- 컨테이너 기술이 좋긴 한데, 배포는 어떻게 해야 좋을까 ?
![image](https://user-images.githubusercontent.com/28394879/131446762-6455070d-ddd8-4e5f-a8da-2d8b4adbb1dd.png)
- 도커만으로는, 위에 사진 처럼 각 서버마다 들어가서 같은 작업을 해주어야 한다. 
- 하나하나 관리하는게 쉽지 않다.

![image](https://user-images.githubusercontent.com/28394879/131446911-08039b1b-9b6f-4a6e-8f0e-b035781ad07c.png)
- 이렇게 많은 도커를 사용하다 보면, 컨테이너가 실행 안되어 있는 서버가 존재한다.
- 어느 서버에 여유가 있는지 보려면, 모니터링 도구를 만들어야 될 수도 있고, 하나하나 접속해서 관리해야 되는 단점이 있다.

![image](https://user-images.githubusercontent.com/28394879/131447236-dd7c5889-fb5d-4241-88ce-5d3ed25af160.png)
- 그리고 또 하나의 문제는, 중앙에서 모든 컨테이너의 버전 업데이트를 하거나 롤백을 할때 일일이 관리하는게 쉽지가 않다.

### 2. 서비스 검색은 어떻게 할까 ?
![image](https://user-images.githubusercontent.com/28394879/131447415-1e76867c-8ccd-4a4c-b128-881fd16d4a3b.png)

### 3. 서비스 노출(Gateway)은 어떻게 할까?
![image](https://user-images.githubusercontent.com/28394879/131447498-35434a6a-6bcc-40c4-bd1c-d8048845bd70.png)
- 이렇게 구성하는게 간단하긴 하지만, 매번 nginx 설정을 해줘야 돼서 귀찮다.
- 이런 설정들을 자동으로 할 수 없을까 ? 

### 4. 서비스 이상, 부하 모니터링은 어떻게 할까?
![image](https://user-images.githubusercontent.com/28394879/131447660-4ea23021-af5a-4908-af3e-a1489d58b152.png)
- 여러개의 컨테이너중에 5개의 컨테이너가 죽었을때 어떻게 할까 ?
- 직접 다 들어가서 확인하기에는 번거롭고 쉽지 않다.


### 컨테이너 오케스트레이션
![image](https://user-images.githubusercontent.com/28394879/131447781-71a2f8c1-7f4c-4efc-b072-92344a9b7f7f.png)
- 컨테이너 기술 자체는 좋은데, 더 많은 컨테이너를 관리하기 위해서 나온 기술이다.

</details>





<details>
<summary>4. 컨테이너 오케스트레이션 4/4(컨테이너 오케스트레이션)</summary>

## 4. 컨테이너 오케스트레이션 4/4(컨테이너 오케스트레이션)

### 컨테이너 오케스트레이션
![image](https://user-images.githubusercontent.com/28394879/131447781-71a2f8c1-7f4c-4efc-b072-92344a9b7f7f.png)
- 서버관리자가 하는 일들을 대신하는 프로그램을 만든 것이다.

### 컨테이너 오케스트레이션 특징
1. CLUSTER 
- 중앙제어 (master-node): 마스터서버를 하나 두고 마스터 서버에 명령을 하면 node에 다 명령이 간다.
- 네트워킹: 노드들끼리의 네트워크 통신이 잘 되어야 함 
- 노드 스케일: 노드의 갯수와 상관없이 잘 돌아야 함

2. STATE
- 상태 관리

3. SCHEDULING
- 배포 관리: 서버를 새로 띄워서 배포하거나, 적절한 서버에 배포를 하는 작업

4. ROLLOUT & ROLLBACK
- 배포 버전관리

5. SERVICE & DISCOVERY
- 서비스 등록 및 조회

6. VOLUME
- 볼륨 스토리지: 각 서버의 적절한 스토리지가 관리 됨 (NFS, AWS EBS, GCE PD, ...)


- 여러 컨테이너 오케스트레이션이 등장했지만, 쿠버네티스가 표준처럼 등장하게 된다.


</details>





<details>
<summary>5. 왜 쿠버네티스인가?</summary>

## 5. 왜 쿠버네티스인가?

### 쿠버네티스 소개
- 컨테이너를 쉽고 빠르게 배포/확장하고 관리를 자동화해주는 오픈소스 플랫폼 
- 1주일에 20억개의 컨테이너를 생성하는 google이 컨테이너 배포 시스템으로 사용하던 borg를 기반으로 만든 오픈소스


### 쿠버네티스 특징
- 오픈소스
- 엄청난 인기
- 무한한 확장성
- 사실상의 표준 (de facto)

### 오픈소스
![image](https://user-images.githubusercontent.com/28394879/131449875-55e3ebe9-16fd-4b6d-8386-bf0ff5a9145c.png)

### 엄청난 인기 
![image](https://user-images.githubusercontent.com/28394879/131449949-36b699f9-2bd6-4370-81ee-32557a3574a3.png)
![image](https://user-images.githubusercontent.com/28394879/131450017-b01531a8-7398-475e-8a45-1c630cdd5bd3.png)

### 무한한 확장성
![image](https://user-images.githubusercontent.com/28394879/131450067-ecd01e07-b979-4386-b71c-99f2edfe4551.png)

### 사실상의 표준 (de facto)
![image](https://user-images.githubusercontent.com/28394879/131450369-4e88e005-2080-4962-8aa6-08e3afa7c524.png)
![image](https://user-images.githubusercontent.com/28394879/131450439-92b09d66-39b9-4ca5-adfe-5f5b9b9a6ed8.png)
![image](https://user-images.githubusercontent.com/28394879/131450482-dfd5f984-ffea-441d-88ed-ad80781ca449.png)
- Cloud Native의 핵심적인 역할을 한다.
- 사실상 표준이기 떄문에, 인프라를 위해서 찾아보면 왠만한 것들은 이미 다 나와 있다.




</details>



<details>
<summary>6. 어떤걸 배울까?</summary>

## 6. 어떤걸 배울까?

![image](https://user-images.githubusercontent.com/28394879/131450946-d9e8fed9-d997-4313-b947-5cb0dcbb5edc.png)
- 도커를 모른다면, 쿠버네티스를 완벽하게 이해할 수 없다.

![image](https://user-images.githubusercontent.com/28394879/131451015-c629fc08-21da-4f66-8eda-fd4745d5576d.png)

### 학습범위
- 도커 컨테이너 실행하기
    - 도커와 도커컴포즈를 이용한 멀티 컨테이너 관리
    
- 쿠버네티스에 컨테이너 배포하기
    - 실습(hands-on) 환경 만들기
    - kubectl 사용법
    - pod, deployment, service 등
    - 기본 리소스 학습
    
- 외부 접속 설정 하기
    - Cluster IP, NodePort, LoadBalancer, Ingress
    - 서비스 타입 학습
    - 서비스 디스커버리 학습 

- 스케일 아웃 하기
    - 부하에 따른 컨테이너 개수 조정
    - 최소 리소스 요청 설정
    - 오토스케일링

- 그외 고급기능 소개
    - HELM 패키지 매니저 소개
    - GitOps, ServiceMesh 소개

### 다루지 않는 범위
- 다양한 환경별 특징 (bare, metal, EKS, ...)
- 쿠버네티스 패턴 (사이드카, 어댑터, ...)
- 관련 생태계 (서비스메시, 서버리스, ...)
- GitOps CI/CD
- 승인제어 등 고급 기능

### 학슴 목표
- 구성요소 이해
- 동작원리 파악
- 기본적인 사용법






</details>






# 2. 쿠버네티스 알아보기

<details>
<summary> 1. 쿠버네티스 소개 </summary>

## 1. 쿠버네티스 소개

### 발음 정리
| 용어 | 발음
|-----|----|
|master|마스터|
|node|노드 (구 minion 미니언)|
|k8s|쿠버네티스, 케이에잇츠, 케이팔에스|
|kubectl|큐브 컨트롤, 큐브 시티엘, 큐브커들|
|etcd|엣지디, 엣시디, 이티시디|
|pod|팟,파드,포드|
|istio|이스티오|
|helm|헬름,핾,햄|
|knative|케이 네이티브|

### 쿠버네티스 소개
- 컨테이너화된 애플리케이션을 자동으로 배포, 스케일링 및 관리
- 컨테이너를 쉽게 관리하고 연결하기 위해 논리적인 단위로 그룹화
- Google에서 15년간 경험을 토대로 최상의 아이디어와 방법들을 적용

### CloudNative 소개
- 클라우드 이전
  - 리소스를 한땀 한땀 직접 관리 
- 클라우드 이후
  - 수많은 리소스를 자유롭게 사용하고 추상적으로 관리
- 클라우드 환경에서 어떻게 애플리케이션을 배포하는게 좋은걸까?  
  - 컨테이너
  - 서미스메시
  - 마이크로 서비스
  - API
  - 인프라 쓰고 버려
  - DevOps
  - 위에 나열된 방법들이 클라우드 스럽다 혹은 CloudNative 하다고 하는것이다.

</details>







<details>
<summary> 2. 쿠버네티스 아키텍처 1/3 (구성/설계) </summary>

## 2. 쿠버네티스 아키텍처 1/3 (구성/설계)

### 쿠버네티스 - 원하는 상태
![image](https://user-images.githubusercontent.com/28394879/131660993-1aafd87b-713b-4a0a-9576-3fd4ae1342e2.png)
- 쿠버네티스가 내부적으로 이런 처리를 반복적으로 한다.

![image](https://user-images.githubusercontent.com/28394879/131661219-04a9f63b-047d-4d1d-851e-dbe0ed3e2308.png)
- 쿠버네티스는 여러개의 Desired State를 가지고 각각을 체크하는 Controller가 있다.


![image](https://user-images.githubusercontent.com/28394879/131661427-0b7f1bca-558e-4f05-983a-ce6004673adc.png)

### 쿠버네티스 마스터 - etcd
- 모든 상태와 데이터를 저장
- 분산 시스템으로 구성하여 안전성을 높임 (고가용성)
- 가볍고 빠르면서 정확하게 설계 (일관성)
- Key(directory)-Value 형태로 데이터 저장
- TTL(time to live), watch같은 부가 기능 제공
- 백업은 필수! 

### 쿠버네티스 마스터 - API server
- 상태를 바꾸거나 조회
- etcd와 유일하게 통신하는 모듈
- REST API 형태로 제공
- 권한을 체크하여 적절한 권한이 없을 경우 요청을 차단
- 관리자 요청 뿐 아니라 다양한 내부 모듈과 통신
- 수평으로 확장되도록 디자인 

### 쿠버네티스 마스터 - Scheduler
- 새로 생성된 Pod을 감지하고 실행할 노드를 선택
- 노드의 현재 상태와 Pod의 요구사항을 체크
  - 노드에 라벨을 부여
  - ex) a-zone, b-zone 또는 gpu-enabled, ...
  
### 쿠버네티스 마스터 - Controller
- 논리적으로 다양한 컨트롤러가 존재
  - 복제 컨트롤러
  - 노드 컨트롤러
  - 엔드포인트 컨트롤러...
- 끊임 없이 상태를 체크하고 원하는 상태를 유지
- 복잡성을 낮추기 위해 하나의 프로세스로 실행

### 쿠버네티스 마스터 - 조회 흐름
![image](https://user-images.githubusercontent.com/28394879/131662283-859beffc-9577-4d48-b555-f24c1a60ab9e.png)
- 컨트롤러는 컨틀롤러가 체크하고 있는 상태를 조회할 때 etcd에 직접 물어보는 것이 아닌, API Server에 물어본다.
![image](https://user-images.githubusercontent.com/28394879/131662303-1a74b598-48fb-4b74-99b5-5a57cb3419b4.png)
- API Server는 저 컨트롤러가 해당하는 리소스를 볼 수 있는지 권한을 체크한다. 
![image](https://user-images.githubusercontent.com/28394879/131662334-87e3be42-cc04-4dd9-911c-9f025664ddfc.png)
- 권한이 있다고 판단이 될 경우에, etcd 정보를 조회 해서 알려주게 된다.
![image](https://user-images.githubusercontent.com/28394879/131662351-08b00d63-3008-4e98-811e-df817608b4d7.png)
- 원하는 상태가 변경이 된다면, API Server에 요청을 한다.
![image](https://user-images.githubusercontent.com/28394879/131662378-1e90105b-b00b-47bf-b278-c1c5cd74a010.png)
- ApI Server에서 Controller한태 원하는 상태가 변경이 되었다고 알려준다.
![image](https://user-images.githubusercontent.com/28394879/131662406-465725b5-8ba9-4ae1-bdae-5ed336cdf7fa.png)
- Controller는 현재상태와 원하는 상태가 바뀌었기 때문에 조치를 해서 리소스 변경한다.
![image](https://user-images.githubusercontent.com/28394879/131662430-d5926bc4-77a0-4fb7-8e1d-f6cb10d8b7b6.png)
- Controller에서 변경한 내용을 API Server 에 전달 한다.
![image](https://user-images.githubusercontent.com/28394879/131662456-4ac1d410-1de4-48af-be47-43f29f13d324.png)
- API Server에서 변경할 수 있는 권한이 있는지 체크 한다.
![image](https://user-images.githubusercontent.com/28394879/131662482-7e7ea563-530f-49ba-9e56-b32e9c429f8a.png)
- 권한이 있다고 판단이 될 경우에, etcd에 정보를 갱신 한다.

### 쿠버네티스 마스터 - API Server 통신
![image](https://user-images.githubusercontent.com/28394879/131662584-3fd76f73-449c-4110-bdf9-cdd48f920ab5.png)


### 쿠버네티스 Node
![image](https://user-images.githubusercontent.com/28394879/131663378-9a13f7fc-4bdc-40bd-b03d-62b8e88d1dc5.png)

### 쿠버네티스 Node - Kubelet
- 각 노드에서 실행
- Pod을 실행/중지하고 상태를 체크
- CRI (Container Runtime Interface)
  - docker
  - Containerd
  - CRI-O
  - ...

### 쿠버네티스 Node - proxy
- 네트워크 프록시와 부하 분산 역할
- 성능상의 이유로 별도의 프록시 프로그램 대신
- iptables 또는 IPVS를 사용 (설정만 관리)


### 쿠버네티스 흐름 - pod이 생성되는 과정
![image](https://user-images.githubusercontent.com/28394879/131664138-51ab90db-e565-4fed-a059-0b33015f999d.png)
1. 관리자가 Pod 하나를 API Server에게 생성 요청 
![image](https://user-images.githubusercontent.com/28394879/131664154-3b959587-078d-4a83-aeb3-a565dfc5b902.png)
2. API Server가 etcd에 그 정보를 넣는다. (pod을 생성하라는 요청이 들어왔다 라는 정보를 넣음)
![image](https://user-images.githubusercontent.com/28394879/131664186-fef73161-303a-49f3-ba62-e03bbeaa3185.png)
3. Controller가 새로 생긴 팟이 있나 계속 체크를 하는데, 새 pod요청을 확인
![image](https://user-images.githubusercontent.com/28394879/131664212-d903d533-4527-4398-bd97-0f9a06981ec9.png)
4. 새 pod요청을 확인하고나서, 실제 pod을 할당하는 API서버에게 요청을 다시한다.
![image](https://user-images.githubusercontent.com/28394879/131664237-270eaef9-bc66-4197-8f13-0f8ff73daa87.png)
5. API Server에서 etcd에 Pod 할당요청 해라 라고 상태를 바꾼다.
![image](https://user-images.githubusercontent.com/28394879/131664261-e34811d6-b62d-40bb-ad49-17387c7e5a22.png)
6. 스케줄러는 계속 Pod 할당요청이 있는지 체크를 하는데, Pod 할당요청 확인
![image](https://user-images.githubusercontent.com/28394879/131664297-c6ceac46-1a50-4c7a-9286-5800672a4605.png)
7. 여러개의 노드중에 어디에 띄울까 고민을 하다가 특정 노드에 Pod을 할당한다. 그러고나서 API Server에 요청
![image](https://user-images.githubusercontent.com/28394879/131664319-f02d09e8-8c67-409d-a905-ec8ebaabaad2.png)
8. API Server에서 할당은 완료 되었고, 실행되기 전 상태라는 것을 etcd에 저장 
![image](https://user-images.githubusercontent.com/28394879/131664347-a9c4f53b-7a31-45cd-858b-b7e5edcacbe7.png)
9. Kubelet이 계속해서 할당은 됐지만 미실행인 Pod이 있는지 계속 체크, 미실행 Pod 확인 
![image](https://user-images.githubusercontent.com/28394879/131664392-4b6a4429-8108-402c-90f8-56b409b304ad.png)
10. 미실행 Pod을 생성 해주고, 그정보를 다시 API Server로 요청 
![image](https://user-images.githubusercontent.com/28394879/131664513-6a9233d8-546a-4435-8a02-74feb8368025.png)
11. API Server가 etcd에 pod이 특정노드에 할당되었고 실행중이다 라는 것을 업데이트 시킨다.
![image](https://user-images.githubusercontent.com/28394879/131664557-4ae10c8a-4168-4d45-b1d7-535814561e48.png)




</details>




<details>
<summary> 3. 쿠버네티스 아키텍처 2/3 (오브젝트) </summary>

## 3. 쿠버네티스 아키텍처 2/3 (오브젝트)

### Pod
![image](https://user-images.githubusercontent.com/28394879/131675731-3f1e7fe9-0bfb-4771-bbad-e6b66e2ad94a.png)
- 가장 작은 배포 단위 

![image](https://user-images.githubusercontent.com/28394879/131675983-d29b3752-9a25-4308-ad4f-4977bb5843c2.png)
- 전체 클러스터에서 고유한 IP를 할당 

![image](https://user-images.githubusercontent.com/28394879/131676101-271f901e-b96d-45e2-95ee-7c36d1de992e.png)
- 여러개의 컨테이너가 하나의 Pod에 속할 수 있음

### ReplicaSet
![image](https://user-images.githubusercontent.com/28394879/131676510-6a146a4a-a0de-4d6a-911a-69f50ae6ac96.png)
- 여러개의 Pod을 관리

![image](https://user-images.githubusercontent.com/28394879/131677224-31f485dc-83d5-4f77-9127-da9702bb8a6c.png)
- 새로운 Pod은 Template을 참고하여 생성

![image](https://user-images.githubusercontent.com/28394879/131677321-75c7c1ee-9031-4b0b-bebb-aae1036ae4a9.png)
- 신규 Pod을 생성하거나 기존 Pod을 제거하여 원하는 수(Replicas)를 유지

### Deployment
![image](https://user-images.githubusercontent.com/28394879/131677421-b279f566-52c5-471d-8efd-885db24069df.png)
- 배포 버전을 관리 

![image](https://user-images.githubusercontent.com/28394879/131677530-50fb9d9c-0f0f-4e7c-a2ee-6c52202c8c87.png)
![image](https://user-images.githubusercontent.com/28394879/131677700-db746234-825c-4132-9385-28152d4263dd.png)
![image](https://user-images.githubusercontent.com/28394879/131677843-18eebcde-4085-465d-8ef2-dd77c1412639.png)
- 내부적으로 ReplicaSet을 이용

### 다양한 Workload
![image](https://user-images.githubusercontent.com/28394879/131677934-3a0f09db-b817-49d7-9b17-aea799463312.png)
- DAEMON SET
  - 모든 노드에 꼭 하나의 POD이 떠있길 원할 때 사용 
  - 로그 수집, 모니터링 등등 
- STATEFUL SETS
  - 순서대로 POD을 실행 하고 싶거나, 같은것을 계속 재활용 하고 싶을때 사용
- JOB
  - 한번 실행 하고 죽는 POD을 원할 때 사용 
  
### Service - ClusterIP
![image](https://user-images.githubusercontent.com/28394879/131678484-de38a8cb-17d2-41ec-98a9-773fa712a3cb.png)
- 클러스터 내부에서 사용하는 프록시 

![image](https://user-images.githubusercontent.com/28394879/131678586-979b3828-c1a4-475f-afe6-aabbfec7ad6f.png)
- Pod은 동적이지만 서비스는 고유 IP를 가짐 

![image](https://user-images.githubusercontent.com/28394879/131678733-4f76684e-ac49-4d09-96db-ffef28e7563c.png)
- 클러스터 내부에서 서비스 연결은 DNS를 이용

### Service - NodePort
![image](https://user-images.githubusercontent.com/28394879/131678937-19b79f7d-050f-4d42-b9fa-519ad012ae91.png)
- 노드(host)에 노출되어 외부에서 접근 가능한 서비스

![image](https://user-images.githubusercontent.com/28394879/131679094-97b3f8bc-f2c8-4515-ac21-c3b71adb4c74.png)
- 모든 노드에 동일한 포트로 생성

### Service - LoadBalancer
![image](https://user-images.githubusercontent.com/28394879/131679198-d2770b83-a1c5-4e15-b7db-ab230cc4fe2e.png)
![image](https://user-images.githubusercontent.com/28394879/131679337-4a36c134-5eaa-49a7-b27f-adf376e74ea2.png)
- 하나의 IP주소를 외부에 노출


### Ingress
![image](https://user-images.githubusercontent.com/28394879/131679475-c131ab93-e69e-4596-893e-d2fed9fbe18e.png)
- 도메인 또는 경로별 라우팅
  - Nginx, HAProxy, ALB, ...


### 일반적인 구성
![image](https://user-images.githubusercontent.com/28394879/131679719-73eaa1a0-b6d7-4b3c-8823-ae22ce32ae06.png)


### 그 외 기본 오브젝트
- Volume - Storage (EBS, NFS, ...)
- Namespace - 논리적인 리소스 구분
- ConfigMap/Secret - 설정
- ServiceAccount - 권한계정
- Role/ClusterRole - 권한설정 (get, list, watch, create, ...)
- ... 


</details>




<details>
<summary> 4. 쿠버네티스 아키텍처 3/3 (API 호출) </summary>

## 4. 쿠버네티스 아키텍처 3/3 (API 호출)

### Object Sepc - YAML
![image](https://user-images.githubusercontent.com/28394879/131784205-8dbf9c90-347d-42f8-b3e2-aacf5d759e5d.png)
![image](https://user-images.githubusercontent.com/28394879/131784283-aea81a87-153b-493f-ad27-5eee72e2b110.png)
![image](https://user-images.githubusercontent.com/28394879/131784346-7be9cf9a-e40d-4357-a10e-d643e7765110.png)

### Object Spec
- apiVersion
  - apps/v1, v1, batch/v1, networking.k8s.io/v1, ...
- kind
  - Pod, Deployment, Service, Ingress, ...
- metadata
  - name, label, namespace, ...
- spec
  - 각종 설정  (https://kubernetes.io/docs/reference/generated/kubernetes-api/v1.18)
- status(read-only)
  - 시스템에서 관리하는 최신 상태

### API 호출하기
- 원하는 상태(desired state)를 다양한 오브젝트(object)로 정의(spec)하고 aPI 서버에 yaml형식으로 전달

### ReplicaSet 생성 과정
![image](https://user-images.githubusercontent.com/28394879/131784818-ce00d7b8-3617-4421-96a0-60349179112f.png)



</details>









# 3. 쿠버네티스 실습 준비


<details>
<summary>1. YAML 문법</summary>

## 1. YAML 문법

### 기본 문법
- 들여 쓰기(indent)
  - 들여쓰기는 기본적으로 2칸 또는 4칸을 지원
  - 추천: 2칸 들여쓰기

- 데이터 정의 (map)
  - 데이터는 key: value 형식으로 정의한다.

- 배열 정의 (array)
  - 배열은 -로 표시한다. 

- 주석 (comment)
  - 주석은 #으로 표시한다.

- 참/거짓, 숫자표현
  - 참거짓: 참/거짓은 true, false 외에 yes, no 를 지원한다. 
  - 숫자: 정수 또는 실수를 따옴표(") 없이 사용하면 숫자로 인식한다.
  
- 줄바꿈 (newline)
  - 여러 줄을 표현하는 방법이다.
  - "|"지시어는 마지막 줄바꿈이 포함
  - "|-" 지시어는 마지막 줄바꿈을 제외
  - ">" 지시어는 중간에 들어간 빈줄을 제외
  
### 주의 사항
- 띄어쓰기
  - key와 value사이에는 반드시 빈칸이 필요하다. 
  - key: value (O)
  - key:value (X)
- 문자열 따옴표
  - 대부분의 문자열을 따옴표 없이 사용할 수 있지만 `:`가 들어간 경우는 반드시 따옴표가 필요하다.
  - windows_drive: c: (X)
  - windows_drive: "c:" (O)
  - windows_drive: 'c:' (O)
  

</details>



<details>
<summary>2. 쿠버네티스 설치 (macOS)</summary>

## 2. 쿠버네티스 설치 (macOS)

### 개발 vs 운영
- 쿠버네티스를 운영환경에 설치하기 위해서는 최소 3대의 마스터 서버와 컨테이너 배포를 위한
  n개의 노드 서버가 필요하다.
  ![image](https://user-images.githubusercontent.com/28394879/131940587-f8ac0de2-94a0-4599-85d1-eb3f0dbb7f3c.png)
- 이러한 설치는 과정이 복잡하고 배포 환경(AWS, Google Cloud, Azure, Bare Metal, ...)
  에 따라 방법이 다르기 때문에 처음 공부할 때 바로 구축하기는 적합하지 않다.
- 여기서 개발 환경을 위해 마스터와 노드를 하나의 서버에 설치하여 손쉽게 관리하는 방법을 사용 한다.
  ![image](https://user-images.githubusercontent.com/28394879/131940742-daaa8e19-fc87-4c54-ab76-89d011de46d6.png)
- 대표적인 개발 환경 구축 방법으로 minikube, k3s, docker for desktop, kind가 있다.
- 대부분의 환경에서 사용할 수 있고 간편하며, 무료인 minikube를 추천하지만 설치할 수 없거나 사양이 낮은 경우엔
  저렴한 비용으로 테스트할 수 있는(1,000원 이하) k3s를 추천 한다.

```
주의
개발환경과 운영환경의 가장 큰 차이점은 개발환경은 단일 노드로 여러 노드에 스케줄링하는 테스트가
어렵고 LoadBalancer와 Persistent Local Storage 또한 가상으로 만들어야 한다.
이러한 실습을 정확하게 하려면 운영환경(멀티노드)에서 진행해야 한다. 
```

### minikube
- 쿠버네티스 클러스터를 실행하려면 최소한 scheduler, controller, api-server, etcd,
  kubelet, kube-proxy를 설치해야 하고 필요에 따라 dns, ingress controller, storage class등을
  설치해야 한다. 쿠버네티스 설치 또한 중요한 과정이지만 처음 공부할 땐 설치보단 실질적인 사용법을 익히는게 중요하다.
- 이러한 설치를 쉽고 빠르게 하기 위한 도구가 minikube 이다. minikube는 windows, macOS,
  linux에서 사용할 수 있고 다양한 가상 환경(Hyperkit, Hyper-V, Docker, VirtualBox등)을 지원하여 대부분의
  환경에서 문제없이 동작한다.

### macOS에서 설치
```
# homebrew를 사용하고 있을떈
brew install minikube

# homebrew를 사용하지 않을땐
curl -Lo minikube https://storage.googleapis.com/minikube/releases/latest/minikube-darwin-amd64
chmod +x minikube
mv ./minikube /usr/local/bin/ 
```

### minikube 기본 명령어
- 버전 확인
  - minikube version
- 가상머신 시작
  - minikube start --driver=hyperkit
- driver 에러가 발생한다면 virtual box를 사용
  - minikube start --driver=virtualbox
- 가상머신 대신 docker (m1에서는 이걸 사용해야 됨)
  - minikube start --driver=docker
- 특정 k8s 버전 실행
  - minikube start --kubernetes-version=v1.20.0
- 상태 확인
  - minikube status
- 정지
  - minikube stop
- 삭제
  - minikube delete
- ssh 접속
  - minikube ssh
- ip 확인
  - minikube ip

</details>





<details>
<summary>3. Kubectl 설치 (macOS)</summary>

## 3. Kubectl 설치 (macOS)

- `kubectl`은 쿠버네티스 CLI 도구이다. 
- 쿠버네티스 클러스터에 명령어를 전달하는 가장 흔한 방법이고 실습을 하면서 수십, 수백번 사용할 예정이다.

### kubectl 설치 (macOS)
```
# homebrew를 사용하고 있다면
brew install kubectl

# homebrew를 사용하지 않는다면, 직접 binary 다운로드
curl -LO https://storage.googleapis.com/kubenetes-release/release/v1.20.0/bin/darwin/amd64/kubectl 
chmod +x kubectl
mv ./kubectl /usr/local/bin/ 

# homebrew를 사용하지 않을떄 (m1)
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/darwin/arm64/kubectl"
chmod +x kubectl
mv ./kubectl /usr/local/bin/ 
```


</details>






<details>
<summary>4. k3s 설치 </summary>

## 4. k3s 설치

### k3s
- minikube를 사용할 수 없거나 네트워크 등 여러가지 이슈로 실습이 어려운 경우,
별도 클라우드 서버에 k3s를 설치하여 원격으로 실습할 수 있다.
- 여기선 AWS Lightsail 에 설치하는 법을 소개하며 한 당 동안 가상머신을 사용했을 때
$20, 하루 동안 실습할 경우 1,000원 이하의 비용이 발생한다.

1. AWS 로그인 후, Lightsail 메뉴를 선택
   ![image](https://user-images.githubusercontent.com/28394879/132096015-16047d1f-0698-422a-a96b-e5ac1a0153b5.png)

2. 새로운 인스턴스 생성 - Create instance 선택
   ![image](https://user-images.githubusercontent.com/28394879/132096037-4f8fefca-1491-4428-afca-b58afa03b2fa.png)
 
3. Linux / Ubuntu 20.04 선택
   ![image](https://user-images.githubusercontent.com/28394879/132096054-afd72803-ce62-4795-a92b-2a7bcf4c22cf.png)
   
4. Add launch script를 선택 후 다음 명령어 입력 
```
sed -i 's/PasswordAuthentication no/PasswordAuthentication yes/' /etc/ssh/sshd_config
echo "ubuntu:1q2w3e4r!!" | chpasswd
service sshd reload
curl -sL https://deb.nodesource.com/setup_14.x | bash -
apt-get -y update
DEBIAN_FRONTEND=noninteractive apt-get -y install nodejs build-essential
npm install -g wetty --unsafe
ln -s /usr/bin/wetty /usr/local/bin/wetty
curl https://gist.githubusercontent.com/subicura/9058671c16e2abd36533fea2798886b0/raw/e5d249612711b14c9c8f44798dea1368395e86a9/wetty.service -o /lib/systemd/system/wetty.service
systemctl start wetty
systemctl enable wetty
```

5. 2 vCPUs / 4 GB 또는 더 나은 사양 선택
   ![image](https://user-images.githubusercontent.com/28394879/132096115-4595bfdb-6c79-4117-a3cb-b4fa0962135e.png)
   
6. 가상 서버 생성이 완료되면 이름 선택
   ![image](https://user-images.githubusercontent.com/28394879/132096134-b80709ca-e0b6-4e45-b847-3baeb065ccf7.png)
   
7. Networking 탭 선택후 방화벽 허용 (4000-65000) SSH(22)는 반드시 제거
   ![image](https://user-images.githubusercontent.com/28394879/132096143-c7d9fd13-6e19-4e2f-96e0-83b8df95e272.png)
   
8. 방화벽 설정 결과
   ![image](https://user-images.githubusercontent.com/28394879/132096154-c32f2a0c-093b-4d62-bc15-e9dfb09e2cbe.png)
   
9. Public IP 주소와 4200 port로 접속 (아이디/패스워드 - ubuntu/1q2w3e4r!!)
  ![image](https://user-images.githubusercontent.com/28394879/132096160-38f11d09-11cc-4e78-9dc9-b70a813ee209.png)

10. k3s 설치
```
curl -sfL https://get.k3s.io | sh -
sudo chown ubuntu:ubuntu /etc/rancher/k3s/k3s.yaml

# 확인
kubectl get nodes

# 설정 복사
cp /etc/rancher/k3s/k3s.yaml ~/.kube/config
```

### 기외 - docker for desktop
- docker for desktop에서 쿠버네티스 클러스터를 활성화 할 수 있다.
  ![image](https://user-images.githubusercontent.com/28394879/132096200-3b1513fe-9dba-45b6-a8e5-a42ee1da5b49.png)
- docker for desktop은 리소스(CPU, 메모리)를 많이 차지하기 떄문에 가급적 실습할 때 껐다 켜기 쉬운 minikube를 추천



</details>










# 4. 쿠버네티스 기본 실습
