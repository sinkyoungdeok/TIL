
## 강의별 정리
[1. 초보를 위한 도커 안내서](./초보를-위한-도커-안내서/README.md)  
[2. Kubernetes와 Docker로 한 번에 끝내는 컨테이너 기반 MSA](./Kubernetes와-Docker로-한-번에-끝내는-컨테이너-기반-MSA/README.md)

## 목록 
- [1. 설치 명령어](#1-설치-명령어)
- [2. 기본 개념](#2-기본-개념)
- [3. 기본 명령어](#3-기본-명령어)

## 1. 설치 명령어 

### Docker 설치 명령어 (Mac OS)

```
brew install --cask docker
```


## 2. 기본 개념 

### 이미지 (Image)
- 컨테이너를 생성할 때 필요한 요소
- 컨테이너의 목적에 맞는 바이너리와 의존성이 설치되어 있다.
- 여러개의 계층으로 된 바이너리 파일로 존재한다.
- create / run 명령어 모두 이미지가 없을 경우 자동으로 pull을 먼저 수행하여 이미지를 다운 받는다.

### 컨테이너 (Container)
- 호스트와 다른 컨테이너로부터 격리된 시스템 자원과 네트워크를 사용하는 프로세스
- 이미지를 읽기 전용으로 사용한다.
- 변경사항은 컨테이너 계층에 저장한다.
-  컨테이너에서 아무리 변경을 해도 이미지에는 영향이 없다. 
- 이미지:컨테이너 == 1:N

### 이미지와 컨테이너의 관계
- DockerFile에서 build를 하면 Image가 된다.
- Image를 Run을 하면 Container가 된다.
- 이미지 <--> 컨테이너 는 프로그램 <--> 프로세스와 같다.
- 이미지 <--> 컨테이너 는 클래스 <--> 인스턴스와 같다. 

### 도커 이미지 이름 구성 
- 저장소 이름/이미지 이름:이미지 태그 
- 예) sinkyoungdeok/nginx:1.21
- 도커 저장소 이름은 생략하면 기본 저장소로 인식한다 (기본저장소 = 도커 허브)
- 도커 이미지 태그를 생략하면 최신 리비전을 가리키는 latest로 인식한다.


### 도커 이미지 저장소
- 도커 이미지를 관리하고 공유하기 위한 서버 어플리케이션 
- Public(공개형) 저장소: QUAY, Dockerhub
- Private(비공개형) 저장소: AWS ECR, Docker Registry

### 도커 구성 요소 
- Docker Registry에서 이미지들을 Pull또는 Run 명령어를 통해 DOCKER_HOST 공간에 저장한다.
- DOCKER_HOST 공간에 저장된 이미지들을 실행함으로써 Docker daemon이 컨테이너를 관리할 수 있게 된다. 

### 도커 컨테이너 라이프사이클 
![image](https://user-images.githubusercontent.com/28394879/172013121-d12ff88c-58bb-4222-9e45-452067f0f440.png)

### 엔트리 포인트 
- 도커 컨테이너가 실행할 때 고정적으로 실행되는 스크립트 혹은 명령어 
- 생략할 수 있으며, 생략될 경우 커맨드에 지정된 명령어로 수행

### 커맨드
- 도커 컨테이너가 실행할 때 수행할 명령어 혹은 엔트리포인트에 지정된 명령어에 대한 인자 값 

## 3. 기본 명령어 

### 컨테이너 생성 
```
docker create [image]
```

### 컨테이너 생성 및 시작
```
docker run [image]
```

<details> <summary> 명령어 옵션 </summary>

- i: 호스트의 표준 입력을 컨테이너와 연결
- t: TTY 할당
- --rm: 컨테이너 실행 종료 후 자동 삭제
- -d: 백그라운드 모드로 실행
- --name: 컨테이너 이름 지정
- -p: 호스트 - 컨테이너 간 포트 바인딩
- -v: 호스트 - 컨테이너 간 볼륨 바인딩

```
docker run \ 
-i \
-t \
--rm \ 
-d \
--name hello-world \
-p 80:80 \
-v /opt/example:/example \
kyoungdeok.sin/hello-world:latest \  # 실행할 이미지
my-command  # 컨테이너 내에서 실행할 명령어 
```
</details> <br/>  

### 컨테이너 시작
```
docker start [container]
```

### 버전 확인 
```
docker -v
```

### 실행 중인 컨테이너 확인
```
docker ps 
```

<details> <summary> 명령어 옵션 </summary>

- a: 전체 컨테이너 확인

</details> <br/>

### 컨테이너 상세 정보 확인
```
docker inspect [container]
```

### 컨테이너 일시 중지
```
docker pause [container]
```

### 컨테이너 재개
```
docker unpause [container]
```

### 컨테이너 종료 (SIGTERM)
```
docker stop [container]
```

### 컨테이너 강제 종료 (SIGKILL)
```
docker kill [container]
```

### 모든 컨테이너 종료 
```
docker stop $(docker ps -a -q)
```

### 컨테이너 삭제
```
docker rm [container]
```

### 컨테이너 강제 종료 후 삭제 (SIGKILL)
```
docker rm -f [container]
```

### 컨테이너 종료 후 자동 삭제
```
docker run --rm ...
```

### 중지된 모든 컨테이너 삭제 
```
docker container prune
```

### 엔트리포인트와 커맨드 
```
docker run --entrypoint sh ubuntu:focal
docker run --entrypoint echo ubuntu:focal hello world
```