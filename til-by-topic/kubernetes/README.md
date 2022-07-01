
## 강의별 정리 

[1. 초보를 위한 쿠버네티스 안내서](./1.초보를-위한-쿠버네티스-안내서/README.md)  
[2. 클라우드 네이티브를 위한 쿠버네티스 실전 프로젝트](./2.클라우드%20네이티브를%20위한%20쿠버네티스%20실전%20프로젝트/README.md)  
[3. Kubernetes와 Docker로 한 번에 끝내는 컨테이너 기반 MSA](./3.Kubernetes%EC%99%80-Docker%EB%A1%9C-%ED%95%9C-%EB%B2%88%EC%97%90-%EB%81%9D%EB%82%B4%EB%8A%94-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88-%EA%B8%B0%EB%B0%98-MSA/)


## 목록 
- [1. 설치 명령어](#1-설치-명령어)
- [2. 기본 개념](#2-기본-개념)
- [3. 기본 명령어](#3-기본-명령어)
- [4. 로컬 개발 환경 세팅](#4-로컬-개발-환경-세팅)
- [5. pod 살펴보기](#5-pod-살펴보기)


## 1. 설치 명령어 

### Kubectl 설치 명령어 (Mac OS)

```
brew install kubectl 
```

### Kustomize 설치 명령어 (Mac OS)

```
brew install kustomize
```

### Minikube 설치 명령어 (Mac OS)

```
brew install minikube
```

## 2. 기본 개념

### 쿠버네티스가 왜 필요한가 
- 배포해야 할 마이크로서비스가 수백 개인 경우 사람이 처리하기 어렵다.
- 수많은 마이크로서비스를 여러 서버에 효율적으로 배치하는것이 어렵다. 
- 여러 서버와 마이크로서비스 배포 조합 수를 사람이 계산할 수 없다 
  - 충분한 리소스를 할당한다면? 리소스 낭비, 비용 발생 
- 간단한 재시작만으로 해결되는 경우에도 복구 시간이 오래 걸린다
  - 어떤 서버에 어떤 서비스가 실행되고 있었는지를 찾기가 쉽지 않다. 

### 쿠버네티스의 기능 
- 자동화된 빈 패킹(bin packing)
  - 컨테이너화된 작업을 실행하는데 사용할 수 있는 쿠버네티스 클러스터 노드를 제공한다.
  - 각 컨테이너가 필요로 하는 CPU와 메모리(RAN)을 쿠버네티스에게 지시한다.
  - 쿠버네티스는 컨테이너를 노드에 맞추어서 리소스를 가장 잘 사용할 수 있도록 해준다.
- 자동화된 복구 
  - 쿠버네티스는 실패한 컨테이너를 다시 시작하고, 컨테이너를 교체한다.
  - '사용자 정의 상태 검사'에 응답하지 않는 컨테이너를 죽이고, 서비스 준비가 끝날 때 까지 그러한 과정을 클라이언트에 보여주지 않는다. 
- 자동화된 롤아웃과 롤백
  - 쿠버네티스를 사용하여 배포된 컨테이너의 원하는 상태를 서술할 수 있다.
  - 현재 상태를 원하는 상태로 설정한 속도에 따라 변경할 수 있다. 
  - 예) 쿠버네티스를 자동화해서 배포용 새 컨테이너를 만들고, 기존 컨테이너를 제거하고, 모든 리소스를 새 컨테이너에 적용할 수 있다. 

### Borg
- Google에서 개발한 최초의 통합 컨테이너 관리 시스템
- 자원 요구사항을 예측하여 리소스 활용도를 높이고 비용을 줄이는 방법을 제공한다.
- Configuration 파일을 실행 중인 서비스에 동적으로 반영 
- 서비스 디스커버리, 로드 밸런싱, 자동 크기 조정 등의 기능을 제공 

### Omega
- Borg에서 몇가지 기능 개선을 해서 만듬 
- 클러스터 상태의 일관성을 부여하기 위해 클러스터 상태를 저장 기능을 추가 - 영구 저장소 
- 낙관적 동시성 제어 방법을 이용하여 리소스 충돌을 해결한다. 

### Kubernetes
- Borg, Omega와 달리 오픈 소스이다.
- 구글 퍼블릭 클라우드 인프라 사업을 성장시키기 위해 설계하고 개발
- Omega처럼 리소스 변경 사항을 저장하기 위한 공유 영구 저장소가 있다
- Omega는 영구 저장소를 신뢰할 수 있는 구성요소들이 직접 접근할 수 있도록 개방 했지만, 쿠버네티스는 더 높은 수준의 추상화를 위해 REST API를 통해서만 접근할 수 있도록 변경하였다.
- 클러스터에서 실행되는 애플리케이션을 개발하는 개발자의 경험에 더 중점을 두고 개발했다.
- 주요 설계 목표 -> 컨테이너로 향상된 리소스 활용의 이점을 누리면서도 복잡한 분산 시스템을 쉽게 배포하고 관리할 수 있도록 하는것

### 쿠버네티스란 
- 여러개의 컨테이너화된 애플리케이션을 여러 서버(쿠버네티스 클러스터)에 자동으로 배포, 스케일링 및 관리해주는 오픈소스 시스템

### 쿠버네티스 클러스터란 
- 클러스터: 여러 개의 서버를 하나로 묶은 집합, 하나의 서버처럼 동작
- 쿠버네티스 클러스터: 애플리케이션 컨테이너를 배포하기 위한 서버 집합 
- 쿠버네티스 클러스터 안에는 Master node와 Worker node가 있다.
- Master node: worker node들의 대장 역할 
- Worker node: 컨테이너를 실행시키는 노드 

### Master 노드의 역할 
- 클러스터의 상태를 저장하고 관리 
- 4가지 구성 요소 
  - etcd(key-value data store): 클러스터에 배포된 애플리케이션 실행 정보를 저장 
  - API Server: 클러스터 상태 조회, 변경을 위한 API 인터페이스 제공 
  - Scheduler: 노드를 선택하기 위한 스케쥴링을 담당 
  - Controller Managers: 실제로 사용자가 요청한 컨테이너의 개수나 상태들이 잘 운영되고 있는 지를 감시하고, 일치하지 않으면 API Server에 추가적인 리소스를 요청하는 역할을 함 

### 마스터노드 - etcd
- 모든 상태와 데이터를 저장
- 분산 시스템으로 구성하여 안전성을 높임 (고가용성)
- 가볍고 빠르면서 정확하게 설계 (일관성)
- Key(directory)-Value 형태로 데이터 저장
- TTL(time to live), watch같은 부가 기능 제공
- 백업은 필수! 

### 마스터노드 - API server
- 상태를 바꾸거나 조회
- etcd와 유일하게 통신하는 모듈
- REST API 형태로 제공
- 권한을 체크하여 적절한 권한이 없을 경우 요청을 차단
- 관리자 요청 뿐 아니라 다양한 내부 모듈과 통신
- 수평으로 확장되도록 디자인 

### 마스터노드 - Scheduler
- 새로 생성된 Pod을 감지하고 실행할 노드를 선택
- 노드의 현재 상태와 Pod의 요구사항을 체크
  - 노드에 라벨을 부여
  - ex) a-zone, b-zone 또는 gpu-enabled, ...
  
### 마스터노드 - Controller
- 논리적으로 다양한 컨트롤러가 존재
  - 복제 컨트롤러
  - 노드 컨트롤러
  - 엔드포인트 컨트롤러...
- 끊임 없이 상태를 체크하고 원하는 상태를 유지
- 복잡성을 낮추기 위해 하나의 프로세스로 실행

### Worker 노드 
- 컨테이너 실행을 담당
- Kubelet, Container Runtime (Docker, ...) 등이 담겨져 있다. 
- kube-proxy: 워커 노드들로 들어오는 트래픽을 pod로 전달하기 위해서 kube-proxy 프로세스도 실행되고 있다. 

### "쿠버네티스에 애플리케이션 컨테이너를 배포한다"란
- 쿠버네티스 오브젝트 Manifest 파일을 작성해서, 마스터 노드에 있는 API Server에게 요청을 보내는 행위 

### Manifest 파일이란 
- 쿠버네티스 오브젝트를 생성하기 위한 필수 정보 
- "일을 시키기 위한 지시서"

### API Server를 통한 협력
![image](https://user-images.githubusercontent.com/28394879/175504639-514f7628-aa59-44a4-a39b-b9405d37e09a.png)

1. 사용자가 kubectl을 통해서 API Server에 HTTP POST request를 요청함
2. 요청을 받은 API Server는 etcd에 상태를 저장한다. 
3. Controller Managers가 신규 리소스 Event를 받아, 추가 리소스를 생성하는 요청을 API Server로 보낸다.
4. API가 pod 생성 요청을 받게 되고, pod에 대한 설정 정보를 etcd에 저장한다.
5. Scheduler가 노드에 배포 되지 않은 pod를 읽어오고, 노드의 상태를 보고 pod가 배포될 때 필요한 리소스를 보고 그 리소스에 적합한 최적의 노드를 하나 선택하여 노드 정보를 pod정보에 추가해서 API Server로 전송한다.
6. API Server는 그 정보를 etcd에 기록한다.
7. Kubelet 프로세스가 내가 실행 중인 A노드에 배포 해야 할 pod가 있구나에 대한 event를 받아, docker에게 컨테이너 실행 명령을 보내고 docker가 컨테이너 생성 및 실행한다. 

- Kubelet은 지속적으로 도커 컨테이너에 헬스체크를 하고, 컨테이너가 정상적이지 않다면 API서버에 보고를하고 API Server는 etcd에 저장한다. 
- Kubelet은 만약 도커 컨테이너의 상태가 좋지 않으면 재시작하기도 한다.

### kube-proxy와 iptables를 이용한 통신 방법 
![image](https://user-images.githubusercontent.com/28394879/175507376-082c444d-343d-4b13-b3de-d4d2b5cf07a2.png)

엔드포인트 추가 시나리오 
1. API Server를 통해서 엔드포인트가 추가가 됨 
2. 어떤 pod의 ip들이 할당이 되기 위해서 kube-proxy가 감시를 해서 자신의 worker node에 있는 iptable을 업데이트 한다.

클라이언트 요청 시나리오
1. kube-proxy가 워커노드로 새로운 트래픽이 들어 왔을 때 iptables를 보고 클라이언트 요청을 목적지로 연결을 지원한다.


### 쿠버네티스 오브젝트란 무엇인가 
- 쿠버네티스 클러스터를 이용해 애플리케이션을 배포하고 운영하기 위해 필요한 모든 쿠버네티스 리소스 
- 사용자 의도를 정의하는 방법 
- 표현 방식: YAML 
- 전달 방식: REST API
- 오브젝트 종류에 따라 정의할 수 있는 속성이 달라진다. 
- 쿠버네티스 오브젝트는 클러스터 상태를 결정한다.
- 사용자가 어떻게 쿠버네티스 오브젝트를 정의하느냐에 따라 쿠버네티스 상태가 결정된다.
- 쿠버네티스 오브젝트를 이용해서 개발팀의 구조, 배포 정책, 프로세스를 표현할 수 있다.

### 쿠버네티스 오브젝트가 될 수 있는 것 (클러스터의 상태를 표현하는 개체들)
- Pod: 어떤 애플리케이션을
- ReplicaSet: 얼마나
- Node, Namespace: 어디에
- Deployment: 어떤 방식으로 배포할 것인가
- Service, Endpoints: 트래픽을 어떻게 로드밸런싱 할 것인가 

### 쿠버네티스 오브젝트 표현 방법 
- 오브젝트 기본 정보 (필수 값)
  - apiVersion: 오브젝트를 생성할 때 사용하는 API 버전
  - kind: 생성하고자 하는 오브젝트 종류
  - metadata: 오브젝트를 구분 지을 수 있는 정보 (name, resourceVersion, labels, namespace, ...)
  - spec: 사용자가 원하는  오브젝트 상태 (선언할 수 있는 속성은 오브젝트 종류마다 다르다.)
- status
  - 오브젝트가 쿠버네티스 클러스터에 생성되면, 쿠버네티스는 오브젝트 정보에 status 필드를 추가한다.
  - 현재 실행 중인 오브젝트의 상태 정보를 나타낸다.

### spec vs status 필드
1. 사용자가 쿠버네티스 오브젝트 YAML 파일을 작성 (spec 작성)
2. 쿠버네티스 API를 이용해서 쿠버네티스 생성을 요청
3. 쿠버네티스 API Server가 오브젝트 파일의 spec 파일을 읽고 오브젝트를 생성
4. 쿠버네티스 ControllerManager가 spec과 status를 비교하면서 계속 조정하고 상태를 업데이트 한다.  

## 3. 기본 명령어

### minikube 클러스터 설정 (docker)

```
minikube start --driver docker 
```

### 쿠버네티스 클러스터에서 사용할 수 있는 오브젝트 목록 조회
```
kubectl api-resources
```

### 쿠버네티스 오브젝트의 설명과 1레벨 속성들의 설명 
```
kubectl explain <type> 
kubectl explain deployment

(apiVersion, kind, metadata, spec, status)
```

### 쿠버네티스 오브젝트의 속성들의 구체적인 설명
```
kubectl explain <type>.<fieldName>[.<fieldName>]
kubectl explain pods.spec.containers
```

### 쿠버네티스 클러스터에서 속한 노드 목록 조회
```
kubectl get nodes
```

### 쿠버네티스 오브젝트 생성/변경
```
kubectl apply -f <object-file-name>
kubectl apply -f deployment.yaml
```

### 실행 중인 Pod(컨테이너) 목록 조회 
```
kubectl get pods
```

### 애플리케이션 배포 개수 조정 
```
kubectl scale -f <object-file-name> --replicas=#
kubectl scale -f deployment.yaml --replicas=3
```

### 실행 중인 오브젝트 설정과 입력한 파일의 차이점 분석
```
kubectl diff -f <object-file-name>
kubectl diff -f deployment.yaml
```

### 쿠버네티스 오브젝트의 spec을 editor로 편집
```
kubectl edit <type>/<name>
kubectl edit deployment/nginx-deployment -> replicas를 4로 변경 
```

### 로컬에서 포트포워딩 
```
kubectl port-forward <type>/<name> <local-port>:<container-port>
kubectl port-forward pod/nginx-deployment-74bfc88f4d-fkfjc 8080:80
```

### 실행중인 컨테이너 프로세스에 접속해서 로그 확인
```
kubectl attach <type>/<name> -c <container-name>
kubectl attach deployment/nginx-deployment -c nginx
```

### 실행중인 컨테이너 프로세스에 모든 로그 출력 
```
kubectl logs <type>/<name> -c <container-name> -f
kubectl logs deployment/nginx-deployment -c nginx -f
```



## 4. 로컬 개발 환경 세팅

### local 환경 클러스터 구성 (m1 mac)
```
brew install google-cloud-sdk
gcloud init
gcloud container clusters get-credentials <프로젝트 명> --zone us-central1-c --project <..>
```

### 쿠버네티스 오브젝트 yaml 작성 시 도움 되는 플러그인 
```
vscode 패키지 -> Kubernetes 설치 
```



## 5. pod 살펴보기

### Pod 개념
- Pod은 여러 컨테이너를 감싸고 있는 콩껍질과 유사하다.
- 노드에서 컨테이너를 실행하기 위한 가장 기본적인 배포 단위 
- 여러 노드에 1개 이상의 Pod를 분산 배포/실행 가능 (Pod Replicas)

### Pod 특징
- Pod를 생성할 때 노드에서 유일한 IP를 할당 (서버 분리 효과)
- Pod 내부 컨테이너 간에 localhost로 통신 가능 (포트 충돌을 주의 해야 한다)
- Pod 안에서 네트워크와 볼륨 등 자원을 공유 


### Pod 특징 - PodIP는 클러스터 안에서만 접근할 수 있다.
- 클러스터 외부 트래픽을 받기 위해서는 Service 혹은 Ingress 오브젝트가 필요하다.

### Pod 특징 - Replica
- 단 하나의 명령어로 원하는 수만큼 Pod 생성 
```
kubectl scal deployment orderapp --replicas=3 
``` 


### Pod와 컨테이너 설계시 고려 할 점 
- Pod:Container = 1:1 or 1:N 결정 => pod은 생성과 종료가 빈번하게 일어나서, 서로 다른 컨테이너를 하나의 pod로 구성하기보다는 1:1로 구성하는게 좋다.
1. 컨테이너들의 라이프사이클이 같은가?
   - Pod 라이프 사이클 = 컨테이너들의 라이프 사이클
   - 컨테이너 A가 종료 되었을 때 컨테이너 B 실행이 의미가 있는가
2. 스케일링 요구사항이 같은가?
   - 웹 서버 vs 데이터베이스와 같이 "트래픽이 많은 vs 그렇지 않은" 과 같이 요구사항이 다르면 좋지 않다.
3. 인프라 활용도가 더 높아지는 방향으로  
   - 쿠버네티스가 노드 리소스 등 여러 상태를 고려하여 Pod를 스케쥴링  


### pod가 노드에 배포되는 과정
Master Node: API Server, Replication Controller, Scheduler
Worker Node: kubelet, docker
1. API Server: 사용자로부터 pod 배포 요청을 수락한다
2. Replication Controller: Api Server로 부터 요청 받은 수 만큼 Pod Replica를 생성 한다 (pod desired state == current state)
3. Scheduler: Api Server로 부터 전달 받은 요청으로 Pod를 배포할 적절한 노드를 선택한다 (nodeselector)
4. Kublet: Api Server로 부터 전달 받은 요청으로 docker에게 이미지 다운로드를 명령하고 Pod 실행을 준비한다. Pod 상태를 업데이트 한다
5. Docker: kublet로 부터 전달 받은 요청으로 이미지를 다운로드하고 컨테이너를 실행한다. 

### Pod 오브젝트 표현 방법
```
apiVersion: V1 # Kubernetes API 버전
kind: Pod # 오브젝트 타입
metadata: # 오브젝트를 유일하게 식별하기 위한 정보 
  name: kube-basic # 오브젝트 이름
  labels: # 오브젝트 집합을 구할 때 사용할 이름표 
    app: kube-basic
    project: test-project
spec: # 사용자가 원하는 오브젝트의 바람직한 상태
  nodeSelector: # Pod를 배포할 노드
  containers: # Pod 안에서 실행할 컨테이너 목록
  volumes: # 컨테이너가 사용할 수 있는 볼륨 목록 
```

### Pod 오브젝트 표현 방법 - nodeSelector
```
spec:
  nodeSelector: # Pod 배포를 위한 노드 선택
    gpu: "true" # 노드 집합을 구하기 위한 식별자 (key: value) 

# 위 구문의 해석: gpu 가 true인 노드에만 배포를 하라.
```

### Pod 오브젝트 표현 방법 - containers
```
spec:
  containers:
  - name: kube-basic  # 컨테이너 이름 
  image: kube-basic: 1.0 # 도커 이미지 주소 
  imagePullPolicy: "Always" # 도커 이미지 다운로드 정책 (Always/IfNotPresent/Never)
  ports:
  - containerPort: 80 # 통신에 사용할 컨테이너 포트  
```

### Pod 오브젝트 표현 방법 - containers 환경 변수 env
```
spec:
  containers:
  - name:kube-basic
  image: kube-basic:1.0
    env: # 컨테이너에 설정할 환경변수 목록 
    - name: PROFILE # 환경 변수 이름 
    value: production # 환경 변수 값 
    - name: LOG_DIRECTORY
    value: /logs
    - name: MESSAGE
    value: This application is running on $(PROFILE) # 다른 환경변수 참조
```

### Pod 오브젝트 표현 방법 - containers valumeMounts
```
spec:
  containers:
  - name: kube-basic
  image: kube-basic:1.0 
    volumeMounts: # 컨테이너에서 사용할 Pod 볼륨 목록 
    - name: html # Pod 볼륨 이름 
    mountPath: /var/html # 마운트할 컨테이너 경로
  - name: web-server
    image: nginx
    volumeMounts: 
    - name: html
      mountPath: /usr/share/nginx/html  # 같은 Pod 볼륨을 다른 경로로 마운트
      readOnly: true
```


### Pod 오브젝트 표현 방법 - spec volumes 
```
spec:
  containers:
  volumes: # 컨테이너가 사용할 수 있는 볼륨 목록 
    name: host-volume # 볼륨 이름 
    hostPath: # 볼륨 타입 , 노드에 있는 파일이나 디렉토리를 마운트하고자 할 때 
      path: /data/mysql
```
- Pod 볼륨 라이프사이클 = Pod 라이프사이클
- Container에서 볼륨 마운트 방법: volumeMounts 속성
- 목적에 맞는 볼륨 선택 (hostPath, gitRepo, ConfigMap, Secret, ...)


### Pod의 한계점 
1. Pod이 나도 모르는 사이에 종료된다면? 
  - 자가 치유 능력(Self-Healing)이 없다. Pod이나 노드 이상으로 종료되면 끝
  - "사용자가 선언한 수만큼 Pod을 유지" 해주는 Replicaset 오브젝트 도입 필요
2. Pod IP는 외부에서 접근할 수 없다. 그리고 생성할 때 마다 IP가 변경된다.
  - 클러스터 "외부에서 접근"할 수 있는 "고정적인 단일 엔드포인트"가 필요
  - Pod의 집합을 클러스터 외부로 노출하기 위한 Service 오브젝트 도입 필요 

### Pod 핵심 정리 
Pod 생성과 배포 
- Pod는 여러 개의 컨테이너를 포함할 수 있고 하나의 노드에 배포 될 수 있다.
- Pod를 YAML 파일로 정의 해두면 필요 할 때 원하는 수 만큼 노드에 배포할 수 있다.
- Pod와 컨테이너를 1:1로 기본 설계하고 특별한 사유가 있을 때 1:N 구조를 고민하자.

Pod IP
- 쿠버네티스는 Pod를 생성할 때 클러스터 내부에서만 접근할 수 있는 IP를 할당한다.
- Pod IP는 컨테이너와 공유되기 때문에 컨테이너간 포트 충돌을 주의해야 한다.
- 하나의 Pod에 속한 컨테이너들은 localhost로 통신할 수 있다.
- 다른 Pod(컨테이너)와 통신은 Pod IP를 이용한다.

### Pod 배포 및 확인 실습 방법

![image](https://user-images.githubusercontent.com/28394879/175968049-1d11c434-36bb-4752-842e-ef68562f0859.png)



### Pod 이름, 컨테이너 이름과 이미지, 포트 설정 
```
apiVersion: v1
kind: Pod
metadata:
  name: hello-app
spec:
  containers:
  - name: hello-app
    image: devchloe/hello-app:1.0
    ports:
    - containerPort: 3000
  - env:
```

### 컨테이너 환경변수 키와 값 설정 
```
spec:
  containers:
  - env: hello-app
    - name: STUDENT_NAME # 환경변수 키 선언
      value: 신경덕 # 환경변수 값 선언 
    - name: GREETING
      value: 하이 $(STUDENT_NAME)님 
```

### Pod 오브젝트 값을 환경변수 값으로 설정 
```
spec:
  containers:
  - env: hello-app
    - name: NODE_NAME
      valueFrom: # k8s 오브젝트로부터 환경변수 값을 얻는다.
        fieldRef: # Pod spec, status의 field를 환경변수 값으로 참조 
          fieldPath: spec.nodeName # 참조할 field의 경로 선택 
    - name: NODE_IP
      valueFrom:
        fieldRef:
          fieldPath: status.hostIP
```


### Pod이름, 컨테이너 이름과 이미지, 포트, 환경변수 등 설정
```
# 요구사항!
# Pod API 버전: v1
# Pod 이름: hello-app
# Pod 네임스페이스: default
# 컨테이너 이름/포트: hello-app(80)
# 도커 이미지: yoonjeong/hello-app:1.0
# 환경변수:
# -- POD_NAME(metadata.name), POD_IP(status.podIP)
# -- NAMESPACE_NAME(metadata.namespace)
# -- NODE_NAME(spec.nodeName), NODE_IP(status.hostIP)
# -- STUDENT_NAME(본인이름), GREETING(STUDENT_NAME을 참조한 인삿말)

apiVersion: v1
kind: Pod
metadata:
  name: hello-app
spec:
  containers:
  - name: hello-app
    image: nginx:latest
    ports:
    - containerPort: 80
    env:
    - name: POD_NAME
      valueFrom:
        fieldRef:
          fieldPath: metadata.name
    - name: POD_IP
      valueFrom:
        fieldRef:
          fieldPath: status.podIP
    - name: NAMESPACE_NAME
      valueFrom:
        fieldRef:
          fieldPath: metadata.namespace
    - name: NODE_NAME
      valueFrom:
        fieldRef:
          fieldPath: spec.nodeName
    - name: NODE_IP
      valueFrom:
        fieldRef:
          fieldPath: status.hostIP
    - name: STUDENT_NAME
      value: 신경덕
    - name: GREETING
      value: 쿠버네티스 입문 강의에 오신 것을 환영합니다. $(STUDENT_NAME)님!
    resources:
      limits:
        memory: "128Mi"
        cpu: "100m"
```

배포, 확인, 삭제 명령어  
```
# 배포 
kubectl apply -f til-by-topic/kubernetes/3.Kubernetes와-Docker로-한-번에-끝내는-컨테이너-기반-MSA/ch2/hello-app.yaml

# Pod 실행 및 IP 확인
kubectl get pod -o wide 

# 컨테이너 환경변수 확인
kubectl exec hello-app -- env 

# 컨테이너 IP 확인
kubectl exec hello-app -- ifconfig eth0 

# 컨테이너 host 확인 
kubectl exec hello-app -- cat /etc/hosts

# 컨테이너 리스닝 포트 확인 
kubectl exec hello-app -- netstat -an

# 포트 포워딩 
kubectl port-forward hello-app 5000:80

# or kubectl delete pod <pod-name> -> Pod 종료 
kubectl delete pod --all 
```


### 컨테이너 간 localhost 통신, 다른 Pod의 Pod IP 통신 예제 

![image](https://user-images.githubusercontent.com/28394879/176452247-a166bec9-8718-46d9-a26c-ff6870f733fa.png)

```
# blue, green 배포 
kubectl apply -f til-by-topic/kubernetes/3.Kubernetes와-Docker로-한-번에-끝내는-컨테이너-기반-MSA/ch3/blue-green-app.yaml

# red 배포 
kubectl apply -f til-by-topic/kubernetes/3.Kubernetes와-Docker로-한-번에-끝내는-컨테이너-기반-MSA/ch3/red-app.yaml 

# blue log 확인 
kubectl logs blue-green-app -c blue-app

# 환경변수(POD_IP, NAMESPACE, NODE_NAME) 조회 
kubectl exec blue-green-app -c blue-app -- printenv POD_IP NAMESPACE NODE_NAME

# blue-app 컨테이너 -> green-app 컨테이너 /tree, /hello 요청 실행 
kubectl exec blue-green-app -c blue-app -- curl -vs localhost:8081/tree
kubectl exec blue-green-app -c blue-app -- curl -vs localhost:8081/hello

# green-app 컨테이너 -> blue-app 컨테이너 /sky, /hello 요청 실행 
kubectl exec blue-green-app -c green-app -- curl -vs localhost:8080/sky
kubectl exec blue-green-app -c green-app -- curl -vs localhost:8080/hello

# red-app ip 조회 
kubectl get pod/red-app -o jsonpath="{.status.podIP}"

# red_pod_ip 환경변수 설정 
export RED_POD_IP=$(kubectl get pod/red-app -o jsonpath="{.status.podIP}")

# blue-app 컨테이너 -> red-app 컨테이너 /rose, /hello 요청 실행 
kubectl exec blue-green-app -c blue-app -- curl -vs $RED_POD_IP:8080/rose

# 포트포워딩 
kubectl port-forward blue-green-app 8080:8080
kubectl port-forward blue-green-app 8081:8081
kubectl port-forward red-app 8082:8080

# pod 종료 
kubectl delete pod --all 
```


### Label과 Selector 란 
- Label: 쿠버네티스 오브젝트를 식별하기 위한 key/value 쌍의 메타정보
  - 쿠버네티스를 논리적인 그룹으로 나누기 위해 붙이는 이름표 
- Selector: Label을 이용해 쿠버네티스 리소스를 필터링하고 원하는 리소스 집합을 구하기 위한 label query
  - Label를 이용해 쿠버네티스 리소스를 선택하는 방법 


### Label과 Selector가 필요한 상황
![image](https://user-images.githubusercontent.com/28394879/176677076-3f67dc4c-769c-46d6-8555-a6a55ff692c6.png)
- 예) 클러스터에서 서로 다른 팀의 수백개 Pod이 동시에 실행되고 있는 상황에서 주문 트래픽을 주문 Pod으로, 배달 트래픽을 배달 Pod으로 라우팅 해야 할 때   
- 예) 배달 트래픽이 증가되는 상황에서 클러스터에서 실행 중인 배달 관련 Pod들을 수평 확장 해야 할 때 
- 우리가 어떤 리소스를 선택해서 명령을 실행하고자 할 때

### Label 예시 
```
apiVersion: v1
kind: Pod
metadata:
  name: my-pod
  labels:
    app: backend
    version: v1
    env: prod
```

### Label 조회 명령어 
```
kubectl get pod my-pod --show-labels
```

### Label 추가 명령어 
```
kubectl label pod my-pod app=backend
```

### Label 변경 명령어
```
kubectl label pod my-pod version=v1 # 생성 
kubectl label pod my-pod version=v2 --overwrite # 변경 
```

### Label 선택 조회 명령어 
```
kubectl get pod/my-pod --label-columns app,env
kubectl get pod/my-pod -L app,env
```

### Label 삭제 명령어 
```
kubectl label pod/my-pod app-
```

### selector 문법
```
kubectl get <오브젝트 타입> --selector <label query 1, ..., label query N>
kubectl get <오브젝트 타입> -l <label query 1, ..., label query N>
label query: key=value
```


### label query 연산자 =, !=
- `=` : 같다 
- `!=` : 같지 않다  
```
kubectl get pod --selector env=prod
kubectl get pod --selector env!=prod
kubectl get pod --selector app=backend,env=prod
kubectl get pod --selector app!=backend,env=prod
```

### label query 연산자 in, notin
- `in`: 속해 있다, 키가 존재한다
- `notin`: 속해 있지 않다, 키가 존재하지 않는다. 
```
kubectl get pod --selector 'env in (dev,stage,prod)' # env에 dev,stage,prod 셋 중 하나라도 포함되면 출력  
kubectl get pod --selector 'env notin (dev,stage,prod)' # env에 dev,stage,prod 셋다 아닌것을 출력 
```

### label query 연산자 키값 조회 
```
kubectl get pod --selector env # env 키값을 가지고 있는 것을 모두 출력 
kubectl get pod --selector !env # env 키값을 가지고 있지 않는 것을 모두 출력 
```


### label query (selector) 예시
```
# -- group=nature 레이블을 가진 모든 파드 조회
kubectl get pod --selector group=nature -L group,concept,element,position,version
# -- concept가 flower이거나 earth인 모든 파드 조회 
kubectl get pod --selector 'concept in (flower,earth)' -L group,concept,element,position,version
# -- concept 레이블이 없는 모든 파드 조회 (! 이용)
kubectl get pod --selector '!concept' -L group,concept,element,position,version
# -- concept 레이블이 없는 모든 파드 조회 (notin 이용)
kubectl get pod --selector 'concept notin (earth, flower)' -L group,concept,element,position,version
# -- 물을 주어야 하는 group=nature 레이블을 가진 모드 파드 조회 (position=bottom)
kubectl get pod --selector group=nature,position=bottom -L group,concept,element,position,version
# -- 손이 닿지 않는 group=nature 레이블을 가진 파드의 IP 조회 (position=top)
kubectl get pod --selector group=nature,position=top -L group,concept,element,position,version
kubectl get pod --selector group=nature,position!=bottom -L group,concept,element,position,version
```


### nodeSelector를 활용하여 배포하기
![image](https://user-images.githubusercontent.com/28394879/176914009-009b605b-b404-4473-8ab1-ef6ac117d52d.png)

```
kubectl get nodes --show-labels # 노드 조회 -> 기본으로 설정된 node 3개가 나옴. 
kubectl get nodes # 레이블 없이 조회 

# 첫번째 세번째 노드에 레이블 추가 
kubectl label node gke-my-cluster-default-pool-3b91989a-56s9 gke-my-cluster-default-pool-3b91989a-xv16 soil=moist 

# 두번째 노드에 레이블 추가 
kubectl label node gke-my-cluster-default-pool-3b91989a-bx9c soil=dry

# 반영된 label 조회
kubectl get node -L soil 


# Pod 생성 (kubectl run <pod-name> --labels="" --image= --port= --overrides='{"key": {"key": {"key": "value"}}}')
# apiVersion: v1
# kind: Pod
# metadata:
#   name: tree-app-1
#   labels:
#     element: tree
# spec:
#   nodeSelector:
#     soil: moist
#   containers:
#   - name: tree-app
#     image: yoonjeong/green-app:1.0
#     ports:
#     - containerPort: 8081

# pod 5개 배포 
for i in {1..5}; 
do kubectl run tree-app-$i \
--labels="element=tree" \
--image=yoonjeong/green-app:1.0 \
--port=8081 \
--overrides='{ "spec": { "nodeSelector": {"soil": "moist"} } }';
done


# 배포된 pod 확인 -> moist에만 배포됐는지 확인.
kubectl get pod -o wide

# 생성한 pod 제거 
kubectl delete pod -l element=tree
```