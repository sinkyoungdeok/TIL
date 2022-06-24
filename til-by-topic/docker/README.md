
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
- [17. jib을 이용한 docker 이미지 빌드 푸시](#17-jib을-이용한-docker-이미지-빌드-푸시)
- [18. jenkins 소개와 설치](#18-jenkins-소개와-설치)
- [19. jenkins를 활용한 docker 빌드](#19-jenkins를-활용한-docker-빌드)
- [20. nexus를 활용한 docker 빌드](#20-nexus를-활용한-docker-빌드)
- [21. sonarqube를 활용한 docker 빌드](#21-sonaqube를-활용한-docker-빌드)
- [22. docker 컨테이너 보안을 위한 clair 활용](#22-docker-컨테이너-보안을-위한-clair-활용)
- [23. docker 컨테이너 빌드 및 푸시 방법 nexus vs aws ecr](#23-docker-컨테이너-빌드-및-푸시-방법-nexus-vs-aws-ecr)

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

### 이미지 모두 삭제 
```
docker rmi $(docker images | grep -v TAG | awk '{print $3}')
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


## 17. jib을 이용한 docker 이미지 빌드 푸시

### 빌드란 무엇인가?
- 소스 코드 파일을 컴퓨터나 휴대폰에서 실행할 수 있는 독립 소프트웨어 아티팩트로 변환하는 과정 혹은 결과물
- 빌드에서 가장 중요한 단계중 하나는 소스 코드 파일이 실행 코드로 변환되는 컴파일 과정이다.
- 빌드하는 과정은 다른 프로그램을 제어하는 프로그램인 빌드 도구에 의해 관리된다.

### 빌드 방식 
- 전체 빌드: 매 빌드 때마다 전체 코드를 포함해 빌드 
- 증분 빌드: 변경된 코드 대상만 분리해 빌드 -> 도커도 이 방식을 채택

### Gradle이란?
- Groovy를 이용한 빌드 자동화 시스템 
- Groovy와 유사한 도메인 언어를 채용
- Java, C/C++, 파이썬 등과 같은 여러가지 언어를 지원한다. 

### Gradle 프로젝트의 구조 
![image](https://user-images.githubusercontent.com/28394879/174432847-32dc332c-3f53-417c-8fe3-125542f97a90.png)
- app/build.gradle: 프로젝트 내 소스코드의 라이브러리 의존성, 플러그인, 라이브러리 저장소 등을 설정할 수 있는 빌드 스크립트 파일 
- gradle/wrapper/.*: gradlew라는 매퍼 파일을 실행하기 위해 필요한 파일들 
- gradlew: 리눅스 또는 맥OS 용 gradle 실행 쉘 스크립트 파일 
- gradlew.bat: 윈도우용 실행 배치 스크립트 파일 
- settings.gradle: 프로젝트의 구성 정보 파일 

### Jib이란
- Docker없이 도커 빌드 및 생성된 이미지를 푸시하는 기능을 제공한다. 
- Docker데몬 없이, Docker권장사항에 대한 깊은 숙달 없이 Java 애플리케이션에 최적화된 Docker및 OCI 이미지를 빌드한다.
- Maven및 Gradle용 플러그인과 자바 라이브러리로 사용할 수 있다. 
- 장점
  - 빠른 도커 이미지 빌드 및 배포가 가능하다.
  - 애플리케이션을 여러 레이어로 분리하여 클래스 종속성을 분리해 변경된 레이어만 배포 가능하다
  - 도커 CLI가 없어도, gradle내에서 도커 이미지를 빌드하고 원하는 이미지 레포지토리로 푸시하는 명령을 구성할 수 있다.
  - 빌드 시 Dockerfile없이 가능하다. 


### Jib과 기존 Dockerfile 기반 빌드 비교 
![image](https://user-images.githubusercontent.com/28394879/174433151-254f15df-dab6-4734-8f75-8927c491a1ba.png)
- Docker 빌드 
  - 애플리케이션을 컨테이너화 할 때에는 gradle을 이용한 애플리케이션 빌드를 통해 패키지를 만드는 과정을 포함해야 한다.
  - 빌드가 성공했다면 빌드의 결과 패키지 파일을 Dockerfile을 통해서 Base 이미지에 넣어주어야 한다.
  - 이러한 gradle빌드와 도커파일 수행과정이 분리되어 있기 떄문에 파이프라인화해서 연결작업을 진행해주어야 한다.
- Jib 빌드 
  - gradle에서 프로젝트를 빌드함과 동시에 컨테이너 이미지를 만들어서 원하는 도커 이미지 레포지토리에 푸시까지 된다.
  - Docker 빌드를 위한 파이프라인 과정이 하나로 통합이 되서 진행된다.


### Jib 설정
![image](https://user-images.githubusercontent.com/28394879/174433980-cf39d4be-4a97-4285-85cc-f124c8ed02ab.png)
- from: Jib 라이브러리가 애플리케이션을 컨테이너 이미지로 만들때 사용하는 Base이미지를 설정
- to: image는 생성될 컨테이너 이미지가 저장될 리포지터리를 의미하고, tag는 이미지의 설정될 태그를 의미한다.
- container: 컨테이너 이미지가 컨테이너화 되서 실행 될 때 필요한 애플리케이션 설정들을 지정한다. 

--- 

### Gradle 설치 
```
brew install gradle
```

### Gradle Project 생성 및 빌드 
Gradle 프로젝트 구성 명령어 
```
gradle init --dsl=groovy --type=java-application \
    --test-framework=junit \
    --package=com.text --project-name=test-docker-spring-boot 
```

Gradle 빌드 명령어 
```
gradle build --info 
```

### Docker 빌드 및 Push 
Jib을 이용한 Docker 빌드 및 Push 명령어 
```
./gradlew jib
```

Docker Pull 및 Run 명령어 
```
docker pull sinkyoungdeok/jib-docker

docker run -d -p 8080:8080 sinkyoungdeok/jib-docker
```

### 실습 파일 
[실습파일 보러 가기](./Kubernetes와-Docker로-한-번에-끝내는-컨테이너-기반-MSA/1.docker&jib/)



## 18. jenkins 소개와 설치

### jenkins 소개 
- 지속적 통합(Continuous Integration = CI) 서비스를 제공하는 툴 
- 다수의 개발자들이 하나의 프로그램을 개발할 때 버전 충돌을 방지하기 위해 git등의 저장소에 업로드함으로써 지속적 통합이 가능하도록 해준다.

### jenkins 특징 
1. 빌드 자동화
2. 자동화 테스트
3. 코드 품질 검사 
4. 빌드 파이프라인 구성
 

### jenkins 플러그인 소개
- credential plugin: aws token, git access token, secret key 등의 정보를 저장할 때 사용
- pipeline plugin: jenkins의 핵심기능인 파이프라인을 관리할 수 있도록 해주는 플러그인 
- docker plugin: jenkins에서 도커를 사용하기 위한 플러그인 

### jenkins 설치 명령어 
Jenkins 컨테이너 실행 명령어 
```
# intel mac 
docker run --name jenkins -d -p 18080:8080 -v ~/jenkins:/var/jenkins_home -u root jenkins/jenkins:latest

# m1 mac 
docker run --name jenkins -d -p 18080:8080 -v ~/jenkins:/var/jenkins_home -u root --platform linux/amd64 --restart=always -e TZ="Asiz/Seoul" jenkins4eval/jenkins
```

Admin Password 확인 명령어 
```
docker exec -it jenkins bash -c "cat /var/jenkins_home/secrets/initialAdminPassword"
```

### jenkins 플러그인 설치 
- Job DSL, Simple Build DSL for Pipeline
- Docker Pipeline, Pipeline: Declarative Agent API, Pipeline Utility Steps, Build Pipeline, SSH Pipeline Steps, Pipeline: AWS Steps, Pipeline: Github
- Git Parameter, Github Integration, Gituhb Authentication
- Docker, Docker Commons, Docker API, docker-build-step, CloudBees Docker Build and Publish, CloudBees Docker Custom Build Environment
- Amazon Web Services SDK :: All, CloudBees AWS Credentials, Amazon ECR, AWS Global Configuration, SSH, SSH Agent

### SSH Key 생성 및 Github 적용 
SSH Key 생성 명령어 
```
ssh-keygen -b 2048 -t rsa
```

SSH Key 설정 경로 
```
github > profile > settings > account settings > SSH and GPG keys > new SSH key > Title: ssh-key / Key: cat ~/.ssh/id_rsa.pub 쳐서 나온 내용 > Add SSH key
``` 

### Jenkins SSH key 추가 
```
Jenkins 관리 > Manage Credentials > Jenkins > Global credentials > Add Credentials > cat ~/.ssh/id_rsa 결과값을 넣기

# Global credentials가 클릭 안될시 해당 링크로 이동: http://localhost:18080/credentials/store/system/domain/_/
```
![image](https://user-images.githubusercontent.com/28394879/174446039-0352e9a9-db8d-4974-ba8b-9deef8c01fb2.png)


### AWS key 추가 
![image](https://user-images.githubusercontent.com/28394879/174446119-468a4f92-753e-40df-83ae-180b48d4d45a.png)

### deploy 서버의 pem키를 jenkins의 deploy ssh key로 추가
![image](https://user-images.githubusercontent.com/28394879/174446243-c7ceece5-5b26-4c10-8a0a-54c266f9251a.png)










## 19. jenkins를 활용한 docker 빌드

### jenkins CI/CD job 수행 및 Docker 빌드/배포 과정 
![image](https://user-images.githubusercontent.com/28394879/174514187-4bf59bd2-fe4e-4c7b-a031-5b457afc88b0.png)


### 파이프라인 구성 
```
젠킨스 대시보드 -> 새로운 Item -> Pipeline -> Github project 설정, Pipeline 설정 -> 저장
```
![image](https://user-images.githubusercontent.com/28394879/174531990-4fdd1dab-a811-4f66-bc03-d3fe9f59637e.png)


### Jenkinsfile 설명 
- Jenkinsfile: https://github.com/sinkyoungdeok/jenkins-test/blob/main/1-jenkins-docker/Jenkinsfile
```
def mainDir="1-jenkins-docker"
def ecrLoginHelper="docker-credential-ecr-login"
def region="ap-northeast-2"
def ecrUrl="651192415160.dkr.ecr.ap-northeast-2.amazonaws.com"
def repository="test"
def deployHost="172.31.51.28"

pipeline {
    agent any 

    stages {
        stage('Pull Codes from Github'){
            steps{
                checkout scm
            }
        }
        stage('Build Codes by Gradle') {
            steps {
                sh """
                cd ${mainDir}
                ./gradlew clean build
                """
            }
        }
        stage('Build Docker Image by Jib & Push to AWS ECR Repository') {
            steps {
                withAWS(region:"${region}", credentials:"aws-key") {
                    ecrLogin()
                    sh """
                        curl -O https://amazon-ecr-credential-helper-releases.s3.us-east-2.amazonaws.com/0.4.0/linux-amd64/${ecrLoginHelper}
                        chmod +x ${ecrLoginHelper}
                        mv ${ecrLoginHelper} /usr/local/bin/
                        cd ${mainDir}
                        ./gradlew jib -Djib.to.image=${ecrUrl}/${repository}:${currentBuild.number} -Djib.console='plain'
                    """
                }
            }
        }
        stage('Deploy to AWS EC2 VM'){
            steps{
                sshagent(credentials : ["deploy-key"]) {
                    sh "ssh -o StrictHostKeyChecking=no ec2-user@${deployHost} \ # ssh 연결
                     'aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${ecrUrl}/${repository}; \ # ecr 연동
                      sleep 3; \
                      docker run -d -p 80:8080 -t ${ecrUrl}/${repository}:${currentBuild.number};'" # 이미지 pull 및 컨테이너 실행
                }
            }
        }
    }
}
```

### 배포할 서버에 aws 인증 
```
# 아래 인증을 안하고 배포 시 no basic auth credentials 에러 발생
aws configure 
```


### 배포 
```
젠킨스 대시보드 -> 생성한 파이프라인 클릭 -> 지금 빌드
```

### jenkins 진행 repository
https://github.com/sinkyoungdeok/jenkins-test







## 20. nexus를 활용한 docker 빌드

### nexus 소개 
- 사내망에 필요한 라이브러리를 다운로드 받을 수 있도록 하는 저장소 
- 별도의 리포지터리(nexus) 를 구축하는 이유 
  - 보안 이슈 
  - 라이브러리 버전 관리 용이 
  - 공유 및 협업 강화 

### nexus 장점 
- main 저장소의 캐시 역할
  - build시 artifact 다운로드를 빨리 할 수 있음
- 자체 artifact 배포를 위한 private repository를 만들 수 있다
  - 외부에 공개하고 싶지 않은 custom artifact를 private repository에 올린다.
- 보안 
  - 외부와 연결이 불가능 한 경우 중앙 레포에 연결이 안되서 빌드가 안되는 문제가 발생하는데, 넥서스 repository만 외부와 연결하게 설정하면 빌드가 가능해진다.

### Nexus 와 Jenkins CI 연동 
![image](https://user-images.githubusercontent.com/28394879/174604090-57fdb04c-3b9c-4e98-81b8-107b30fd6fa2.png)

### Nexus Repository 
- Snapshots: 빌드 등 수시로 릴리즈 되는 아티팩트 리포지터리
- Releases: 정식 릴리즈를 통해서 배포되는 아티팩트 리포지터리
- 3rd Party: 특정 밴더사에서 제공하는 아티팩트 리포지터리
- Proxy Repository: Local Cache 용 
- Virtual Repository: 여러 리포지터리를 그룹화하여 하나의 리포지터리로 참조 가능 

### Nexus Repository Type
- Proxy: 외부망에 있는 리포지터리와 연동해 버전관리
- Hosted: 내부망 내 개발용으로 연동하는 리포지터리
- Virtual: 서로 다른 타입의 리포지터리를 연결
- Group: 위에 명시된 3개 타입을 그룹화


### Nexus Repository 구성 방식 
![image](https://user-images.githubusercontent.com/28394879/174606038-0c378472-c429-44e5-a966-4b18b2b9f127.png)


### Nexus 설치 명령어 
```
# intel mac
docker run --name nexus -d -p 8081:8081 -v ~/nexus-data:/nexus-data -u root sonatype/nexus3

# m1 mac에선 실패.
```

### Nexus Admin Password 확인 명령어
```
docker exec -it nexus bash -c "cat /nexus-data/admin.password"
```


### Blob Store를 S3에 연동 
```
nexus -> Repository -> Blob Stores -> Create Blob Store

Type: S3
Name: test-docker-nexus-repository
Region: ap-northeast-2
Bucket: test-docker-nexus-repository-kd
Prefix: test
Expiration Days: 3
Authentication: Access Key, Secret Key 설정 

Save
```

- S3 접근해보면 생겨있음.


### Proxy 타입의 Repository 생성 
```
nexus -> Repository -> Repositories -> Create repository -> maven2 (proxy) 

Name: test-docker-nexus-repository1
Version policy: Mixed
Layout policy: Permissive
Remote storage: https://repo1.maven.org/maven2/
Auto blocking enabled: 체크표시 제거
Blob store: test-docker-nexus-repository
Strict Content Type Validation: 체크표시 제거 

Create repository
```

### Nexus Artifact를 활용한 Docker 빌드
- gradle 변경 
```
// 기존 gradle 
repositories {
    mavenCentral()
}

// 변경된 build.gradle
repositories {
    maven {
        url "https://<Nexus VM 퍼블릭 주소>:8081/repository/<Nexus에 생성한 Proxy Repository명>"
    }
}
```

- gradle, ecr, docker, 컨테이너 명령어 
```
# gradle 
gradle clean build --info

# aws ecr login 
aws ecr get-login-password --region <리전명> | docker login --username AWS --password-stdin <AWS ECR Repository URL>

# docker build with jib
gradle jib --console=plain

# docker 
docker run -d -p 8080:8080 -t <AWS ECR Repository URL>:태그명
``` 

- 실행시간
  - mavenCentral() : 3분 30초 
  - maven with nexus : 3분 42초 
  - maven with nexus (nexus에 이미 artifact가 저장되고 난 후에 요청 했을 때) : 1분 51초
- 결론 
  - 일반적으로 nexus에 의존성들이 한번 저장되고나서, repository로 다운로드가 되기 때문에 nexus repository의 첫시도는 오래걸릴 수 있다.
  - 하지만, nexus repository에 한번 저장되고나면 그뒤 요청들은 mavenCentral에 접근할 필요가 없으므로 훨씬 더 빠르다. 

### 실습 파일 
[실습파일 보러 가기](./Kubernetes와-Docker로-한-번에-끝내는-컨테이너-기반-MSA/2.nexus&docker)



## 21. sonarqube를 활용한 docker 빌드

### 정적 분석 vs 동적 분석
- 정적 분석 
    - 분석 대상: (실행 되지 않은) 소스코드 or 컴파일 된 바이너리 
    - 테스트 범위: 소스코드의 모든 부분
    - 활용: 코드 상의 문제나 실수를 찾음
- 동적 분석
    - 분석 대상: 프로그램 실행 환경 
    - 테스트 범위: 실행 가능한 경로
    - 활용: 테스트, 모니터링 

### sonarqube 소개 
- project 코드 품질 측정: 프로젝트 코드의 품질 정보 측정, 빌드 및 통합 후 품질 변화 측정
- 폴리그랏 언어별 Rule 지원: Java, Go 등 언어별 Rule 지원, Jacoco 등 분석 플러그인 지원
- Quality Profiles 관리: 분석 Ruleset 정의 및 적용, Ruleset기반 Profile 구성
- Quality Gates 설정: 다수 그룹의 품질 요구사항 설정, 다수 항목별 품질 요구사항 설정 
- devops와의 통합: 다양한 빌드 시스템 ci 도구와 통합되어 devops 방식으로 관리 가능 

### sonarqube 구성 방식 
<img width="1076" alt="image" src="https://user-images.githubusercontent.com/28394879/174729118-85f24521-60ce-4e29-89e5-5e99c5b81a35.png">

1. 소나큐브서버: 개발자가 품질 스냅샷을 검색하고, 소나큐브 인스턴스를 구성하고, UI에서 검색을 지원하고, 코드 분석 보고서를 처리할 수 있다.
2. 소나큐브DB: 보안, 플러그인 설정 등 소나큐브 인스턴스 구성 데이터를 저장하며, 프로젝트 페이지에서 품질 정보를 스냅샷 할 수 있다.
3. 소나큐브 플러그인: 여러가지의 폴리그랏 언어, SCM 연동 및 인증 플러그인을 포함하여 서버에 설치 가능
4. 소나큐브 스캐너: 프로젝트 분석을 위해 gradle이나 젠킨스와 같은 빌드 ci도구에서 실행하는 요소이다.


### sonarqube 기능
- Project 페이지
    - 전체적인 프로젝트의 현황을 빠르게 파악할 수 있게 한다.
    - 품질 요구사항을 만족하지 못하는 프로젝트, 특정 이슈 등의 관련된 프로젝트에 필터링할 수 있다.
- Issue 페이지  
    - 여러 프로젝트에서 발생하는 이슈에 대한 리포팅이 가능하다.
    - 자신에게 할당된 이슈목록을 확인할 수 있다.
- Rules 페이지
    - 소나큐브에 존재하는 모든 룰을 확인할 수 있다.
    - 지원 언어별, 타입별, 태그별, 서드파티 룰 등 모든 룰을 확인할 수 있다.
- Quality Profiles 페이지
    - rules 집합을 정의함으로써 조직이 원하는 코드룰을 요구사항에 정의할 수 있다.
- Quality Gates 페이지
    - application을 릴리즈하기 전에 어플리케이션의 품질 요구사항을 지키고 있는지 확인하는 기준 목록이다.
    - 어플리케이션의 출시 여부를 결정할 수 있다.
- Administration 페이지
    - 어드민 사용자가 전체적인 소나큐브에 대한 관리를 수행할 수 있는 페이지이다.
    - 프로젝트, 계정, 그룹, 보안, 플러그인 등의 관리가 가능하다.

### Sonarqube & Jenkins CI 연동 
<img width="727" alt="image" src="https://user-images.githubusercontent.com/28394879/174731150-be1b443b-6a6c-4ed3-942c-4be7f733ab57.png">

1. 개발자가 ide에 플러그인으로 내장되어 있는 sonarlint를 통해 자체적으로 정적코드를 분석한다.
2. 자체 분석 결과로 통과된 코드는 git등 소스코드 관리 시스템에 커밋된다.
3. 젠킨스는 저장소에서 코드를 checkout하고 자동화된 빌드를 수행하고 단위테스트를 실행한다.
4. 정적 분석 결과를 빌드 및 단위 테스트를 담당하는 gradle을 통해 분석 플러그인을 실행하여 분석 결과를 소나큐드로 전송한다.
5. 전달된 품질 분석 결과는 소나큐브 DB에 저장되어 관리 되고
6. 소나큐브 웹 서버를 통해 개발자는 이슈를 확인하고 새로 개발되는 코드에 대한 품질 향상 활동 및 이슈처리 등을 지속적으로 수행할 수 있다.
7. 품질 활동 결과는 다른 시스템과 api등으로 연동하여 리포팅 할 수 있다. 


### SonarQube 설치 명령어
```
# intel mac 
docker run --name sonarqube -d -p 9000:9000 sonarqube:latest

# m1 mac은 실패
```

### SonarQube 유저 생성 
```
sonarqube 대시보드 -> Administration -> Security -> Users -> Create User 

# 어드민 권한 부여 
sonarqube 대시보드 -> Administration -> Security -> Global Permission
```

### Jacoco란 
- Java Code Coverage
  - 자바 소스파일의 코드 커버리지 제공
  - 테스트케이스에 의한 테스트수 측정
- Instruction Coverage
  - 코드 실행량 측정 커버리지
- Branch Coverage
  - if나 switch 문의 분기 확인
  - 실행된 것과 실행되지 않은 부분 측정
- Cyclomatic complexity
  - function 테스트시 최소 경로 정보 
  - 모든 코드를 커버하기 위한 테스트 수 

### SonarQube & Jacoco 관련 명령어 
```
# 빌드 
./gradlew clean build --info

# Jacoco 코드 커버리지 측정 및 리포트 작성 명령어
./gradlew jacocoTestCoverageVerification --info
./gradlew jacocoTestReport --info
cat /build/reports/jacoco/test/html/index.html

# SonarQube 코드 품질 스캔 결과 연동 명령어 
./gradlew sonarqube --info

# Docker 이미지 빌드 및 push 
./gradlew jib --console=plain
```

### Gradle에서 SonarQube 및 Jacoco 플러그인 설정 
```
// build.gradle

buildscript {
  ext {
      springBootVersion = '1.5.4.RELEASE'
      jacocoVersion = '0.8.7'
  }
  repositories {
      mavenCentral()
      maven {
          url "https://plugins.gradle.org/m2/"
      }
  }
  dependencies {
      classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
      classpath "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:2.7.1"
  }
}

plugins {
	id 'org.springframework.boot' version '2.5.2'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id 'java'
    id 'com.google.cloud.tools.jib' version '3.1.4'
}

apply plugin: 'org.sonarqube'
apply plugin: 'jacoco'
group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

test {
	useJUnitPlatform()
}
jacoco{
  toolVersion = "${jacocoVersion}"
}

jacocoTestReport {
 reports{
  html.enabled=true
  xml.enabled=true
  csv.enabled=true
 }
}

tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}

sonarqube {
  properties {
      property "sonar.projectName","SpringBoot Code Coverage Demo"
      property "sonar.exclusions", "**/generated-*/**/*"
      property "sonar.projectKey", "org.sonarqubeJacocoCodeCoverage"
      property "sonar.reportPath" , "${project.buildDir}/jacoco/test.exec"
      property "sonar.host.url", "http://<SonarQube Private IP>:9000"
      property "sonar.sources", "src/main/java"
      property "sonar.tests", "src/test/java"
      property "sonar.login", "<SonarQube ID>"
      property "sonar.password", "<SonarQube PW>"
  }
}

tasks['sonarqube'].dependsOn test

jib {
    from {
        image = 'adoptopenjdk/openjdk11:alpine-jre'
    }
    to {
        image = '<AWS ECR URL>/<Image Repository Name>'
        tags = ['<Image Tag Name>']
    }
    container {
        entrypoint = ['java', '-Dspring.profiles.active=test', '-jar', 'spring-boot-gradle-demo-0.0.1-SNAPSHOT.jar']
        // mainClass = 'com.test.StartApplication'
        jvmFlags = ['-Xms512m', '-Xmx512m', '-Xdebug', '-XshowSettings:vm', '-XX:+UnlockExperimentalVMOptions', '-XX:+UseContainerSupport']
        ports = ['8080']

        environment = [SPRING_OUTPUT_ANSI_ENABLED: "ALWAYS"]
        labels = [version:project.version, name:project.name, group:project.group]

        creationTime = 'USE_CURRENT_TIMESTAMP'
        format = 'Docker'
    }
    extraDirectories {
        paths {
            path {
                from = file('build/libs')
            }
        }
    }
}
```

### Jacoco 코드 커버리지 측정 및 리포트 결과
![image](https://user-images.githubusercontent.com/28394879/174920294-f4fc3587-88e5-48e3-bd2e-dd5850e9d397.png)
- 어떤식으로 충족이 안됐는지는 확인할 수 있다.
- 하지만, 어떤것을 기준으로 이러한 값이 나왔는지 확인이 불가하므로 소나큐브가 필요하다.




### SonarQube에서 정적코드 품질분석 결과확인 
```
./gradlew sonarqube --info

SonarQube 대시보드 -> Projects -> SpringBoot Code Coverage Demo -> Code Smells 
```

![image](https://user-images.githubusercontent.com/28394879/174921174-afe88f48-b059-40ad-a3ab-b0bf08e81ac3.png)

![image](https://user-images.githubusercontent.com/28394879/174921363-899c4b96-35fc-4d82-9c57-ae758cce623e.png)



### 실습 파일 
[실습파일 보러 가기](./Kubernetes와-Docker로-한-번에-끝내는-컨테이너-기반-MSA/3-sonarqube-docker)






## 22. docker 컨테이너 보안을 위한 clair 활용

### Docker 컨테이너 보안 
![image](https://user-images.githubusercontent.com/28394879/174927936-b1461b70-b9c1-4737-a229-666df2be6dcb.png)

안전한 컨테이너 보안을 위해 취할 수 있는 단계   
1. 정적 코드 분석 (ex: sonarqube)
2. 종속성 확인 (라이브러리 등 확인)
3. 컨테이너 이미지의 보안 취약점 스캔 (ex: Clair)

### Clair 소개 
- 애플리케이션 컨테이너의 취약점에 대한 정적 분석을 위한 오픈소스 프로젝트
- 클라이언트는 Clair API를 사용하여 컨테이너 이미지를 색인화한 다음 알려진 취약점과 대조할 수 있다.
- Clair의 목표는 컨테이너 기반 인프라의 보안을 투명하게 볼 수 있도록 하는 것이다.

### Clair 아키텍처
![image](https://user-images.githubusercontent.com/28394879/174928467-7265baaa-7b36-466e-8f6e-b441adc69ec2.png)
- Clair는 컨텐츠를 검사하고 취약점을 보고하기 위한 엔진으로 ClairCore 라이브러리를 사용한다.
- 높은 수준의 ClairCore 라이브러리에서 제공하는 기능에 대한 Clair 서비스 레포를 전송할 수 있다.
- 레이어 인덱싱과 같은 대부분의 개발은 ClairCore를 통해서 적용이 된다 
- ClairCore 내에는 REST API를 통해 취약성 데이터베이스를 업데이트를 담당하는 업데이터와 데이터 소스 목록을 처리하는 구문을 구현할 수 있다.
- ClairCore 내에는 취약점 데이터베이스 저장 및 업데이트된 도커 이미지 레이어 분석 결과를 출력하는 구문을 구현할 수 있다. 

### Clair 작동 방식 
![image](https://user-images.githubusercontent.com/28394879/174929163-dc1cb0a0-f853-4494-8e13-3b23cb087897.png)
- Clair는 크게 3부분으로 나뉜다.
  1. indexer: 매니페스트를 클레어에 전달한다. clair가 indexing을 수신받으면, 클레어는 컨테이너 이미지에 레이어 정보를 가져오고, 해당 컨텐츠를 스캔하여 index report 라는 중간 데이터를 반환한다. (매니페스트: 컨테이너 이미지에 대한 클레어 명세 내용)
  2. matcher: index report를 가져오고, report가 나타내는 매니페스트에 영향을 미치는 관련 취약점을 연결한다. 클레어는 지속적으로 새로운 보안 데이터를 수집하고 있으며, 매칭 서버에 대한 요청을 통해 항상 인덱스 레포트의 최신 취약점을 분석하고 제공한다.
  3. notifier: 클레어는 notifier를 통해 알람 서비스를 구현한다. 새로운 취약점이 발견되면 알람서비스는 이러한 취약점이 인덱싱된 매니페스트에 영향을 미치는지 확인한다. 관리자는 이러한 알람을 통해 구성에 따라 조치를 취할 수 있다. 

### Clair를 통한 컨테이너 이미지 분석 방식 
![image](https://user-images.githubusercontent.com/28394879/174930470-01d316d4-054b-4290-94b8-1d4769d4223f.png)
- 클레어는 총 4가지 도커 이미지의 보안 취약점을 분석한다.
  1. 특정 이미지 리포지터리에 컨테이너 이미지가 있어야지 접근해서 분석할 수 있다. (pull)
  2. registry에 있는 컨테이너 이미지를 사용해서 해당 레이어에 HTTP URL을 통해 layer의 tar파일을 가져와 분석한다. 
  3. 분석한 이미지 레이어외에 다른 레이어를 분석하기 위해 다른 API 엔드포인트를 통해서 tar파일을 얻는다.
  4. 클레어에게 하나로 통합된 스캔 가능한 레이어로 구성된 도커 이미지를 통합적으로 분석할 수 있도록 진행한다.

### Clairctl를 통한 보안 취약점 스캔 
![image](https://user-images.githubusercontent.com/28394879/174931546-f388b242-8325-4f8a-b469-2653a12ed98f.png)

### Clair & Jenkins CI 연동
![image](https://user-images.githubusercontent.com/28394879/174931635-6d12a198-104c-425b-9a58-0acedbe0b503.png)
- 빨간 박스에서 Clair를 진행한다. 

### Clair 설치 
Clair DB & Clair 서버 컨테이너 실행 
```
# intel mac
docker run -p 5432:5432 -d --name db arminc/clair-db:latest
docker run -p 6060:6060 --link db:postgres -d --name clair arminc/clair-local-scan:latest

# m1 mac 실패
```

Clair-scanner 설치 
```
wget https://github.com/arminc/clair-scanner/releases/download/v12/clair-scanner_linux_amd64
chmod +x clair-scanner_linux_amd64; sudo mv clair-scanner_linux_amd64 /usr/local/bin/clair-scanner
```

### Clair 관련 명령어
```
# Clair 실행 서버 Private IP 확인 멸영어 
export IP=$(ip r | tail -n1 | awk '{print $9}');echo ${IP}

# Gradle 및 AWS-CLI Docker 이미지 스캔 및 결과 확인 명령어 
clair-scanner --ip ${IP} --clair=http://localhost:6060 --log="clair.log" --report="gradle_report.txt" <Gradle 이미지명>
clair-scanner --ip ${IP} --clair=http://localhost:6060 --log="clair.log" --report="aws-cli_report.txt" <AWS-CLI 이미지명>

# Spring Boot 웹 애플리케이션 Docker 이미지 빌드 보안 스캔 명령어 
clair-scanner --ip ${IP} --clair=http://localhost:6060 --log="clair.log" --report="spring-boot-web_report.txt" <예제 Docker 이미지명>
```

### Clair-scanner 기본 보안 설정을 위한 옵션 
- -w: 화이트리스트 파일의 경로 
- -t: 심각도에 해당하는 내용을 출력 (심각도 = Defcon1, Critical, High, Medium, Low, Negligible, Unknown)
- -c: Clair URL
- --ip: private ip address
- -l: 출력 로그파일 
- --all: 전체에 보안취약점에 대해서 출력
- -r: 스캔 결과값에 대해서 output파일 설정 


### Jenkins에서 많이 사용하는 Docker 이미지 스캔 및 결과 확인
```
# gradle 
docker pull gradle:jdk11
# aws-cli
docker pull bitnami/aws-cli:latest

# gradle scan
clair-scanner --ip ${IP} --clair=http://localhost:6060 --log="clair.log" --report="gradle_report.txt" gradle:jdk11
# aws-cli scan
clair-scanner --ip ${IP} --clair=http://localhost:6060 --log="clair.log" --report="aws-cli_report.txt" bitnami/aws-cli:latest
```

### Gradle-Jib 예제 Docker 이미지 빌드 스캔 및 결과 확인
```
aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin 797373241119.dkr.ecr.ap-northeast-2.amazonaws.com

docker pull 797373241119.dkr.ecr.ap-northeast-2.amazonaws.com/test:1.0

clair-scanner --ip ${IP} --clair=http://localhost:6060 --log="clair.log" --report="spring-boot-web_report.txt" 
```


## 23. docker 컨테이너 빌드 및 푸시 방법 nexus vs aws ecr


### Docker 컨테이너 빌드 후 Nexus에 이미지 Push 및 Clair 보안 스캔 수행 
![스크린샷 2022-06-24 오전 11 49 30](https://user-images.githubusercontent.com/28394879/175452426-0b2ee420-4977-4bfe-82ad-2d4821eceb33.png)


### Docker 컨테이너 빌드 후 AWS ECR에 이미지 Push 및 ECR 보안 스캔 수행 
![스크린샷 2022-06-24 오전 11 55 42](https://user-images.githubusercontent.com/28394879/175453075-551b1f64-7c53-4ff5-98d3-ac2f1ced6aaa.png)

### Nexus Docker Registry 설치 및 설정 
- Nexus Registry용 Blob Store 생성
- Nexus Registry용 Repository 생성 

### Nexus Docker 빌드 및 Push&Pull 수행
- Nexus Registry URL 설정 
  - 로컬 Docker 데몬
  - Gradle > Jib
- Docker 빌드 및 Nexus Registry로 Push 수행
- Nexus Registry에서 로컬로 Docker Pull 수행 

### Nexus Docker 명령어 
```
# 로컬 Docker 데몬 내 Nexus Registry 설정 명령어 
vi ~/.docker/daemon.json

# Nexus Registry 로그인 명령어 
docker login -u <Registry 계정명> <Nexus Registry 주소>:5000

# Docker 빌드 후 Nexus Registry로 Push 하기 위한 Gradle - Jib 명령어 
gradle jib -DsendCredentialsOverHttp=true --console=plain

# Nexus Registry에서 로컬로 Pull 하기 위한 명령어 
docker pull <Nexus Registry 주소>:5000/<Repository명>:<Tag명>
```

### AWS ECR Repository 보안 취약점 스캔 연결 설정 
- AWS ECR Repository 보안 취약점 스캔 연결 설정
- ECR Repository 대상 Docker 빌드 및 Push 테스트
- 보안 취약점 스캔 수행 및 결과 확인 

### AWS ECR 명령어 
```
# Nexus Registry 로그아웃 명령어 
docker logout

# AWS ECR Repository 로그인 명령어 
aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin <AWS ECR Repository URL>

# Docker 빌드 및 AWS ECR로 Push 명령어 
gradle jib --conosole=plain
```

### 실습 파일 
[실습파일 보러 가기](./Kubernetes와-Docker로-한-번에-끝내는-컨테이너-기반-MSA/4-nexus-ecr-docker)