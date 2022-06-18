
## 강의별 정리
[1. 초보를 위한 도커 안내서](./초보를-위한-도커-안내서/README.md)  
[2. Kubernetes와 Docker로 한 번에 끝내는 컨테이너 기반 MSA](./Kubernetes와-Docker로-한-번에-끝내는-컨테이너-기반-MSA/README.md)

## 목록 
- [1. 설치 명령어](#1-설치-명령어)
- [2. 기본 개념](#2-기본-개념)
- [3. 기본 명령어](#3-기본-명령어)
- [4. 포트 관련 명령어](#4-포트-관련-명령어)
- [5. 네트워크 관련 명령어](#5-네트워크-관련-명령어)
- [6. 볼륨 관련 명령어](#6-볼륨-관련-명령어)
- [7. 로그 관련 명령어](#7-로그-관련-명령어)
- [8. 이미지 빌드 명령어](#8-이미지-빌드-명령어)
- [9. 도커파일 문법](#9-도커파일-문법)
- [10. 이미지 압축파일 저장 명령어](#10-이미지-압축파일-저장-명령어)
- [11. 도커 허브 명령어](#11-도커-허브-명령어)
- [12. AWS ECR 저장소 명령어](#12-AWS-ECR-저장소-명령어)
- [13. 이미지 경량화 전략](#13-이미지-경량화-전략)
- [14. 도커 데몬 디버깅](#14-도커-데몬-디버깅)
- [15. 도커 컴포즈 명령어](#15-도커-컴포즈-명령어)
- [16. 도커 컴포즈 활용 예시](#16-도커-컴포즈-활용-예시)

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

### 도커 네트워크 구조 
![image](https://user-images.githubusercontent.com/28394879/172395969-10afa311-c63a-454f-b671-c0b3df0faa87.png)
- docker0: 도커 엔진에 의해 기본 생성되는 브릿지 네트워크 (veth와 eth 간 다리 역할)
- veth: 컨테이너당 하나씩 대응되는 가상 eth이다. 

### 도커 네트워크 드라이버 
![image](https://user-images.githubusercontent.com/28394879/173072332-472ff060-a189-49f9-ae5c-5d5695140c5c.png)
- none: 네트워크 설정이 필요 없을 경우 혹은 커스텀 네트워크를 사용할 때 사용 -> ubuntu를 띄운다고 가정했을 때 apt update했을 시 실패한다 (네트워크 설정이 없기 떄문) 
- host: 도커가 제공해주는 가상 네트워크를 사용하는 것이 아닌, 직접 host네트워크에 붙어서 사용 -> 직접 host에 붙기 때문에 port binding이 필요 없다. 


### 도커 로그 드라이버 
![image](https://user-images.githubusercontent.com/28394879/173167899-54ead741-9b2b-4270-82c0-53d601c5eb7e.png)
- 기본: json-file (in-line json타입의 file로 저장됨)

### 도커 이미지 구조
![image](https://user-images.githubusercontent.com/28394879/173233112-8074c39a-a301-4c06-8d14-13b1270b3d5b.png)
- 위 그림은 ubuntu image에 nginx 변경사항이 추가되고, 그 위에 web app 변경 사항이 반영된 이미지에 대한 그림이다.
- 도커 이미지는 변경사항이 있을 때 마다 하나의 layer씩 추가되는 형식으로 되어 있다.

### 도커 컴포즈 개념 
- 단일 서버에서 여러 컨테이너를 프로젝트 단위로 묶어서 관리
- docker-compose.yml 파일을 통해 명시적 관리 
- 프로젝트 단위로 도커 네트워크와 볼륨 관리
- 프로젝트 내 서비스 간 의존성 정의 가능
- 프로젝트 내 서비스 디스커버리 자동화
- 손 쉬운 컨테이너 수평 확장

### 도커 컴포즈 - 프로젝트
- 도커 컴포즈에서 다루는 워크스페이스 단위
- 함께 관리하는 서비스 컨테이너의 묶음
- 프로젝트 단위로 기본 도커 네트워크가 생성 됨

### 도커 컴포즈 - 서비스
- 도커 컴포즈에서 컨테이너를 관리하기 위한 단위
- scale을 통해 서비스 컨테이너의 수 확장 가능

### 도커 컴포즈 - 컨테이너
- 서비스를 통해 컨테이너 관리 

### 도커 컴포즈 - 주요 사용 목적
- 로컬 개발 환경 구성
  - 특정 프로젝트의 로컬 개발 환경 구성 목적으로 사용
  - 프로젝트의 의존성(Redis,Mysql 등)을 쉽게 띄울 수 있음
- 자동화된 테스트 환경 구성
  - CI/CD 파이프라인 중 쉽게 격리된 테스트 환경을 구성하여 테스트 수행 가능
- 단일 호스트 내 컨테이너를 선언적 관리
  - 단일 서버에서 컨테이너를 관리할 때 YAML 파일을 통해 선언적으로 관리 가능 




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

### 환경 변수 

- -e: 환경변수 직접 입력
- --env-file: 환경변수 파일 입력
```
docker run -it -e MY_HOST=kyoungdeok.sin ubuntu:facal env
docker run -it --env-file ./sample.env ubuntu:facal env
```


### 실행중인 컨테이너에 명령어를 실행 
```
docker exec [container] [command]
docker exec -it my-nginx bash
docker exec my-nginx env 
```

## 4. 포트 관련 명령어

### 컨테이너 포트 노출 
```
docker run -p [HOST IP:PORT] : [CONTAINER PORT] [container]

# nginx 컨테이너의 80번 포트를 호스트 모든 IP의 80번 포트와 연결하여 실행
docker run -d -p 80:80 nginx

# nginx 컨테이너의 80번 포트를 호스트 127.0.0.1 IP의 80번 포트와 연결하여 실행
docker run -d -p 127.0.0.1:80:80 nginx

# nginx 컨테이너의 80번 포트를 호스트의 사용 가능한 포트와 연결하여 실행 
docker run -d -p 80 nginx 
```

### expose
- 문서화 용도의 옵션이다. 
```
docker run -d --expose 80 nginx
```

## 5. 네트워크 관련 명령어 

### network none 
```
docker run -it --net none ubuntu:focal
```

### network host
```
docker run -d --net host grafana/grafana
```

### bridge network 생성 

- `--net-alias` 옵션으로 도메인을 설정할 수 있다. 
```
docker network create --driver=bridge sinkyoungdeok
```

## 6. 볼륨 관련 명령어 

### 호스트 볼륨 
- 호스트의 디렉토리를 컨테이너의 특정 경로에 마운트 한다.
```
# 호스트의 /opt/html 디렉토리를 Nginx의 웹 루트 디렉토리로 마운트
docker run -d \
--name nginx \
-v /opt/html:/usr/share/nginx/html \
nginx

docker run -d \
--name nginx \
-v $(pwd)/html:/usr/share/nginx/html \
nginx
```


### 볼륨 컨테이너 
- 특정 컨테이너의 볼륨 마운트를 공유 할 수 있다. 
```
docker run -d \
--name my-volume \
-it \
-v /opt/html:/usr/share/nginx/
html \
ubuntu:focal

# my-volume 컨테이너의 볼륨을 공유 
docker run -d \
--name nginx \
--volumes-from my-volume \
nginx 
```

### 도커 볼륨 
- 도커가 제공하는 볼륨 관리 기능을 활용해서 데이터를 보존한다.
- 기존적으로 /var/lib/docker/volumes/${volume-name}/_data 에 데이터가 저장 된다.
```
# web-volume 도커 볼륨 생성
docker volume create --name db

# 도커의 web-volume 볼륨을 Nginx의 웹 루트 디렉토리로 마운트 
docker run -d \
--name skd-mysql \
-v db:/var/lib/mysql \
-p 3306:3306 \
mysql:5.7
```

### 읽기전용 볼륨 연결 
- 볼륨 연결 설정에 :ro 옵션을 통해 읽기 전용 마운트 옵션을 설정할 수 있다. 
```
# 도커의 web-volume 볼륨을 Nginx의 웹 루트 디렉토리로 읽기 전용 마운트
docker run -d \
--name nginx \
-v web-volume:/usr/share/nginx/html:ro \
nginx 
```





## 7. 로그 관련 명령어 


### 로그 확인하기 
```
# 전체 로그 확인
docker logs [container]

# 마지막 로그 10줄 확인
docker logs --tail 10 [container]

# 실시간 로그 스트림 확인
docker logs -f [container]

# 로그마다 타임스탬프 표시
docker logs -f -t [container]
```


### 호스트 운영체제의 로그 저장 경로
```
# log driver 를 json-file로 했을 때만 유효하다.
cat /var/lib/docker/containers/${CONTAINER_ID}/${CONTAINER_ID}-json.log 
```

### 로그 용량 제한 
- 컨테이너 단위로 로그 용량 제한을 할 수 있지만, 도커 엔진에서 기본 설정을 진행할수도 있다. (운영환경에서 필수 설정)
```
# 한 로그 파일 당 최대 크기를 3MB로 제한하고, 최대 로그 파일을 3개로 로테이팅
docker run \
-d \
--log-driver=json-file \
--log-opt max-size=3m \
--log-opt max-file=5 \
nginx
```





## 8. 이미지 빌드 명령어

### Dockerfile 없이 이미지 생성 
```
# 기존 컨테이너에서 변경사항을 기반으로 새 이미지를 생성하는 방법이다. 
# docker commit [OPTIONS] CONTAINER [REPOSITORY[:TAG]]
# ubuntu 컨테이너의 현재 상태를 my_ubuntu:v1 이미지로 생성
docker commit -a sinkyoungdeok -m "First Commit" ubuntu my_ubuntu:v1
```


### DockerFile 이용하여 이미지 생성 
```
# Dockerfile 
FROM node:12-alpine
RUN apk add --no-cache python3 g++ make
WORKDIR /app
COPY . .
RUN yaun install --production
CMD ["node", "src/index.js"]

# docker build [OPTIONS] PATH
# ./ 디렉토리를 빌드 컨텍스트로 my_app:v1 이미지 빌드 (Dockerfile 이용)
docker build -t my_app:v1 ./

# ./ 디렉토리를 빌드 컨텍스트로 my_app:v1 이미지 빌드 (example/MyDockerfile 이용)
docker build -t my_app:v1 -f example/MyDockerfile ./
```

### Dockerignore
- .gitignore와 동일한 문법
- 특정 디렉토리 혹은 파일 목록을 빌드 컨텍스트에서 제외하기 위한 목적이다.
```
# comment
*/temp*
*/*/temp*
temp?

*.md
!README.md
```



## 9. 도커파일 문법

### From
- 베이스 이미지 사용 
```
FROM node:16
```

### Label
- 이미지의 메타데이터
```
LABEL description="Simple server with Node.js"
```

### ENV
- 컨테이너의 환경변수 
```
FROM busybox
ENV FOO=/bar
WORKDIR ${FOO}
ADD . $FOO
```

### ARG
- 도커이미지 상에서 인자값 사용 
```
FROM busybox
ARG user1
ARG buildno=1
```

### WORKDIR
- working directory를 설정한다.
- 우분투에서 cd를 통해서 디렉토리 이동하는것과 유사하다.
```
# 이미지 상의 경로를 /app으로 이동해라.
WORKDIR /app
```

### COPY
- COPY SRC(호스트 OS) DEST(이미지상에서 경로)
```
# 호스트OS의 package*.json을 이미지 경로인 ./에 복사해라. 
COPY package*.json ./
```

### RUN
- 도커이미지 상에서 해당 명령어를 실행할 때 사용 
```
# npm install을 실행해라 
RUN npm install 
```

### EXPOSE
- **(예 8080) 포트를 사용한다고 문서화 할 때 사용
```
EXPOSE 8080
``` 

### CMD
- 컨테이너를 실행할 때 어떤 명령어를 수행할 것인지를 나타낼 때 사용 
```
CMD ["node", "server.js" ]
CMD "node server.js"
```

### ENTRYPOINT
- CMD에 앞서서 시작 프로그램을 지정할 때 사용 
```
ENTRYPOINT ["EXECUTABLE", "param1", "param2"]
ENTRYPOINT command param1 param2
``` 

```
FROM ubuntu
ENTRYPOINT ["top", "-b"]
CMD ["-c"]
```

### USER
- 컨테이너가 사용하게 될 기본 사용자 및 그룹
```
USER <user>[:<group>]
```



## 10. 이미지 압축파일 저장 명령어

### 이미지 tar 압축파일로 저장
```
# docker save -o [OUTPUT-FILE] IMAGE
# ubuntu:focal 이미지를 ubuntu_focal.tar 압축 파일로 저장
docker save -o ubuntu_focal.tar ubuntu:focal
```

### 이미지 압축에서 불러오기 
```
# docker load -i [INPUT-FILE]
# ubuntu_focal.tar 압축 파일에서 ubuntu:focal 이미지 불러오기 
docker load -i ubuntu_focal.tar
```


## 11. 도커 허브 명령어

### 허브 로그인 
```
docker login -u sinkyoungdeok
```

### 도커 허브 repository에 push 
```
# 이전에 도커 허브에서 repository를 만들어야됨.
docker tag nginx:latest sinkyoungdeok/my-nginx:v1.0.0
docker push sinkyoungdeok/my-nginx:v1.0.0
```


## 12. AWS ECR 저장소 명령어

### AWS ECR push
```
# 이전에 AWS ECR에서 repository를 만들어야됨
export AWS_PROFILE=sinkyoungdeok
aws sts get-caller-identity
aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin 797373241119.dkr.ecr.ap-northeast-2.amazonaws.com

docker tag nginx:latest 797373241119.dkr.ecr.ap-northeast-2.amazonaws.com/my-nginx:v1.0.0

docker push 797373241119.dkr.ecr.ap-northeast-2.amazonaws.com/my-nginx:v1.0.0
```




## 13. 이미지 경량화 전략

### 꼭 필요한 패키지 및 파일만 추가

### 컨테이너 레이어 수 줄이기
- RUN 명령어의 개수를 줄인다. ( && 를 활용하자 )

### 경량 베이스 이미지 선택
- 경량 베이스 이미지 종류
  - debian slim 
  - alpine
  - stretch

### 멀티 스테이지 빌드 사용 
- 빌드 의존성은 빌드 스테이지에서 진행
- 빌드결과물만 릴리즈 스테이지에 복사해서 진행

```
FROM node:16-alpine AS base
LABEL maintainer="Kyoungdeok Sin <tkagmd1@naver.com>"
LABEL description="Simple server with Node.js"

WORKDIR /app

COPY package*.json ./

FROM base AS build # base이미지가 변경되지 않는 이상 이부분은 동일한 레이어로 동작
RUN npm install

FROM base AS release
COPY --from=build /app/node_modules ./node_modules
COPY . .

EXPOSE 8080
CMD [ "node", "server.js" ]
``` 


## 14. 도커 데몬 디버깅

### 도커 데몬의 이벤트 보기
```
docker system events
```

### 도커 시스크 사용량 보기
```
docker df 
docker df -v
```

### 도커 저장된 공간 확보
```
docker system prune
```

### 컨테이너별 cpu 메모리 네트워크io사용률 등 보기 
```
docker stats
```




## 15. 도커 컴포즈 명령어

### version 
- 2021년 11월 기준 버전 3.9가 최신
- 가능한 최신 버전 사용 권장
- 도커 엔진 및 도커 컴포즈 버전에 따른 호환성 매트릭스 참조해야 함. 
- version3부터 Docker Swarm과 호환
  - Swarm 서비스를 docker-compose.yml로 정의 가능 

### 도커 스왐 (Docker Swarm)
- 여러 서버를 기반으로 스왐 클러스터를 형성하여 컨테이너를 관리하는 컨테이너 오케스트레이션 시스템
- 쿠버네티스와 동일 목적으로 만들어졌지만 인기를 끌지 못했다. 

### services
- 프로젝트 내에 구성되는 여러 서비스들을 관리 

### networks
- 프로젝트마다 독립된 네트워크로 구성됨
- 프로젝트내에 기본적으로 default 네트워크(브릿지)로 설정됨 

### volumes
- 프로젝트마다 독립된 볼륨으로 구성됨 

### 프로젝트 목록 확인
```
# 실행중인 프로젝트 목록 확인
docker-compose ls

# 전체 프로젝트 목록 확인
docker-compose ls -a
```

### 도커 컴포즈 파일 예시 
```
version: "3.9"
services:
    web:
        build: . # 현재 디렉토리를 컴파일해서 빌드
        ports:
        - "5000"
    redis:
        image: "redis:alpine"
```

### 도커 컴포즈 실행 
```
docker-compose up
```

<details><summary> 명령어 옵션 </summary>

- -p: 프로젝트명 변경
- -d: 백그라운드 실행

</details>

</br></br>

### 프로젝트 내 컨테이너 및 네트워크 종료 및 제거
```
docker-compose down 
```

### 프로젝트 내 컨테이너, 네트워크 및 볼륨 종료 및 제거 
```
docker-compose down -v 
```

### docker-compose 서비스 확장
- docker-compose 파일내에 포트바인딩을 호스트포트를 지정하게되면, 확장이 불가능하다. (예: ports: - "5000:5000")
- docker-compose 파일내에 컨테이너 네임을 지정하게되면, 확장이 불가능하다. (예: container_name: "web")
```
# web 서비스를 3개로 확장
docker-compose up --scale web=3
```

### 프로젝트 내 서비스 로그 확인
```
docker-compose logs
```

### 프로젝트 내 컨테이너 이벤트 확인
```
docker-compose events
```

### 프로젝트 내 이미지 목록
```
docker-compose images
```

### 프로젝트 내 컨테이너 목록
```
docker-compose ps
```

### 프로젝트 내 실행중인 프로세스 목록
```
docker-compose top
```

### 도커 컴포즈 파일 내 옵션들
```
services:
    db:
        image: mysql:5.7 # 사용할 이미지 선택 
        volumes: # 볼륨 설정
        - db:/var/lib/mysql
        restart: always # 재시작 전략 설정
        environment: # 배열을 통한 환경변수 전달 
        - MYSQL_ROOT_PASSWORD=wordpress
        networks: # 네트워크 설정 
        - wordpress
    wordpress:
        depends_on: # 컨테이너 실행 되는 순서 지정
        - db # db서비스가 실행된 후에 wordpress가 실행되도록 설정
        ports: # 포트 바인딩 설정
        - "8000:80"
        environment: # 오브젝트 형식을 통한 환경변수 전달
            WORDPRESS_DB_HOST: db:3306
            WORDPRESS_DB_USER: wordpress
```





## 16. 도커 컴포즈 활용 예시

### 1. Grafana 구성하기
요구사항
- Grafana의 3000번 포트는 호스트의 3000번 포트와 바인딩
- Grafana의 설정 파일인 grafana.ini는 호스트에서 주입 가능하도록 구성하고 읽기전용 설정
- Grafana의 로컬 데이터 저장 경로를 확인하여 도커 볼륨 마운트
- Grafana의 플러그인 추가 설치를 위한 환경변수 설정
- 로그 드라이버 옵션을 통해 로그 로테이팅 

```
version: '3.9'

services:
    grafana:
        image: grafana/grafana:8.2.2
        restart: unless-stopped
        environment:
            GF_INSTALL_PLUGINS: grafana-clock-panel
        ports:
        - 3000:3000
        volumes:
        - ./files/grafana.ini:/etc/grafana/grafana.ini:ro
        - grafana-data:/var/lib/grafana
        logging:
            driver: "json-file"
            options:
                max-size: "8m"
                max-file: "10"
volumes:
    grafana-data: {}
```

### 2. Grafana + Mysql 구성하기
요구사항
- 1단계 요구사항 포함
- grafana.ini를 통해 database 설정을 sqlite에서 MySQL로 변경
- MySQL 컨테이너를 docker-compose에 db 서비스로 추가
- grafana 서비스가 db 서비스를 database로 연결하도록 구성
- MySQL의 로컬 데이터 저장 경로 확인하여 도커 볼륨 마운트 

```
version: '3.9'

services:
    db:
      image: mysql:5.7
      restart: unless-stopped
      environment:
          MYSQL_ROOT_PASSWORD: grafana
          MYSQL_DATABASE: grafana
          MYSQL_USER: grafana
          MYSQL_PASSWORD: grafana
      volumes:
      - mysql-data:/var/lib/mysql
      logging:
          driver: "json-file"
          options: 
              max-size: "8m"
              max-file: "10"
    grafana:
        depends_on:
        - db
        image: grafana/grafana:8.2.2
        restart: unless-stopped
        environment:
            GF_INSTALL_PLUGINS: grafana-clock-panel
        ports:
        - 3000:3000
        volumes:
        - ./files/grafana.ini:/etc/grafana/grafana.ini:ro
        - grafana-data:/var/lib/grafana
        logging:
            driver: "json-file"
            options:
                max-size: "8m"
                max-file: "10"
                
volumes:
    mysql-data: {}
    grafana-data: {}
```
