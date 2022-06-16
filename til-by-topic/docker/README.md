
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