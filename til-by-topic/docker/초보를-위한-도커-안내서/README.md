# 목차

1. [도커란 무엇인가?](#1-도커란-무엇인가?)
2. [도커-설치부터 실행까지](#2-도커-설치부터-실행까지)
3. [도커-이미지 만들고 배포하기](#3-도커-이미지-만들고-배포하기)
4. [더보기](#4-더보기)

# 1. 도커란 무엇인가?

<details>
<summary>1. 서버를 관리한다는 것</summary>

## 1. 서버를 관리한다는 것 

### 개요
- 도커는 컨테이너 기반의 오픈소스 가상화 플랫폼
- 다른 도구와 마찬가지로 **어떤 문제**를 해결하기 위해 만들어졌고
그 방법이 많은 사람들에게 인기를 끌면서 널리 사용

</details>



<details>
<summary>2. 도커 컨테이너 생성 데모</summary>

## 2. 도커 컨테이너 생성 데모
</details>


<details>
<summary>3. 서버관리 방식의 변화</summary>

## 3. 서버관리 방식의 변화

### 가상머신 vs 도커
- 도커는 가상머신처럼 독립적으로 실행되지만 <br>
가상머신보다 빠르고<br>
가상머신보다 쉽고<br>
가상머신보다 효율적이다.<br>

</details>



<details>
<summary>4. 도커의 등장</summary>

## 4. 도커의 등장
### 도커의 등장
- 2013년에 DotCloud(현 Docker)에서 첫 공개
- 컨테이너: 격리된 환경에서 작동하는 프로세스
- 리눅스 커널의 여러 기술을 활용
- 하드웨어 가상화 기술보다 가벼움
- 이미지 단위로 프로세스 실행 환경을 구성

</details>

<details>
<summary> 5. 도커란 </summary>

## 5. 도커란
### VM vs Docker
![image](https://user-images.githubusercontent.com/28394879/130361223-3967168c-06b8-4787-843a-90b698b2a21a.png)

### 도커의 특징 - 확장성/이식성
- 도커가 설치되어 있다면 어디서든 컨테이너를 실행할 수 있음
- 특정 회사나 서비스에 종속적이지 않음
- 쉽게 개발서버를 만들 수 있고 테스트서버 생성도 간편함

### 도커의 특징 - 표준성
- 도커를 사용하지 않는 경우 ruby, nodejs, go php로 만든 서비스들의 배포 방식은 제각각 다름
- 컨테이너라는 표준으로 서버를 배포하므로 모든 서비스들의 배포과정이 동일해짐
- capistrano? fabric? ftp? 바이바이 ~

### 도커의 특징 - 이미지
- 이미지에서 컨테이너를 생성하기 떄문에 반드시 이미지를 만드는 과정이 필요
- Dockerfile을 이용하여 이미지를 만들고 처음부터 재현 가능
- 빌드 서버에서 이미지를 만들면 해당 이미지를 이미지 저장소에 저장하고 운영서버에서 이미지를 불러옴

### 도커의 특징 - 설정관리
- 설정은 보통 환경변수로 제어함
- MYSQL_PASS = password 와 같이 컨테이너를 띄울때 환경변수를 같이 지정
- 하나의 이미지가 환경변수에 따라 동적으로 설정파일을 생성하도록 만들어져야함

### 도커의 특징 - 자원관리
- 컨테이너는 삭제 후 새로 만들면 모든 데이터가 초기화 됨
- 업로드 파일을 외부 스토리지와 링크하여 사용하거나 S3같은 별도의 저장소가 필요
- 세션이나 캐시를 memcached나 redis와 같은 외부로 분리

### 도커가 가져온 변화
- 클라우드 이미지보다 관리하기 쉬움
- 다른 프로세스와 격리되어 가상머신처럼 사용하지만 성능저하 (거의)없음
- 복잡한 기술(namespace, cgroups, network, ...)을 몰라도 사용할 수 있음
- 이미지 빌드 기록이 남음
- 코드와 설정으로 관리 > 재현 및 수정 가능
- 오픈 소스 > 특정 회사 기술에 종속적이지 않음

</details>

<details>

<summary> 6. 도커의 미래 </summary>

## 6. 도커의 미래
### 쿠버네티스
- 여러대의 서버와 여러개의 서비스를 관리하기 쉽게 해줌
- 즉, 쿠버네티스 안에 여러개의 도커가 있음.

### 쿠버네티스 - 스케줄링 
- 컨테이너를 적당한 서버에 배포해 주는 작업
- 여러 대의 서버 중 가장 할일 없는 서버에 배포하거나 그냥 차례대로 배포 또는 아예 랜덤하게 배포
- 컨테이너 개수를 여러개로 늘리면 적당히 나눠서 배포하고 서버가 죽으면 실행 중이던 컨테이너를 다른 서버에 띄워줌

### 쿠버네티스 - 클러스터링
- 여러 개의 서버를 하나의 서버처럼 사용
- 작게는 몇 개 안되는 서버부터 많게는 수천 대의 서버를 하나의 클러스터로
- 여기저기 흩어져 있는 컨테이너도 가장 네트워크를 이용하여 마치 같은 서버에 있는 것처럼 쉽게 통신

### 쿠버네티스 - 서비스 디스커버리
- 서비스를 찾아주는 기능
- 클러스터 환경에서 컨테이너는 어느 서버에 생성될지 알 수 없고 다른 서버로 이동 할 수도 있음
- 따라서 컨테이너와 통신을 하기 위해서 어느 서버에서 실행중인지 알아야 하고 컨테이너가 생성되고 중지 될 때 어딘가에 IP와 Port같은 정보를 업데이트 해줘야 함
- 키-벨류 스토리지에 정보를 저장할 수도 있고 내부 DNS 서버를 이용

</details>

# 2. 도커-설치부터 실행까지

<details> <summary> 1. 도커 설치하기 </summary>

## 1. 도커 설치하기

### MacOS or Windows
- 도커는 기본적으로 linux를 지원하기 떄문에 MacOS와 Windows에 설치되는 Docker는 가상머신에 설치됨
- MacOS는 xhyve를 사용하고 Windows는 Hyper-V 사용
    - Windows Pro에서만 설치가 가능했으나 Windows WSL 2를 이용하여 Home 버전도 설치 가능
    - 그 외에 Windows 사용자는 VirtualBox에 ubuntu 리눅스를 설치하여 실


</details>

<details> <summary> 2. 도커 기본 명령어(run) </summary>

## 2. 도커 기본 명령어(run)
### run - 컨테이너 실행
- docker run [OPTIONS] IMAGE:[:TAG|@DIGEST] [COMMAND] [ARG...]
    - -d: detached mode (백그라운드 모드)
    - -p: 호스트와 컨테이너의 포트를 연결
    - -v: 호스트와 컨테이너의 디렉토리를 연결
    - -e: 컨테이너 내에서 사용할 환경변수 설정
    - --name: 컨테이너 이름 설정
    - --rm: 프로세스 종료시 컨테이너 자동 제거
    - -it: -i와 -t를 동시에 사용한 것으로 터미널 입력을 위한 옵션
    - --network: 네트워크 연결 

### ubuntu 20.04 컨테이너 만들기
- ```dokcer run ubuntu:20.04```
    - run 명령어를 사용하면 사용할 이미지가 저장되어 있는지 확인하고 없으면 다운로드(pull) 한 후
    컨테이너를 생성(create)하고 시작(start)합니다.
    - 컨테이너는 정상적으로 실행 됐지만 뭘 하라고 명령어를 전달하지 않았기 때문에 컨테이너는
    생성 되자마자 종료 됩니다. 컨테이너는 프로세스이기 때문에 실행중인
    프로세스가 없으면 컨테이너는 종료 됩니다.
    - 조금 더 자세하게 설명하면 도커 이미지마다 컨테이너가 만들어질때 실행할 명령어를 지정할 수 있고
    ubuntu:20.04는 "/bin/bash"가 지정되어 쉘이 실행되야 하지만, 입력 받을 수 있도록 "-it"
    옵션을 입력하지 않았기 떄문에 바로 실행이 종료 된 것이다.

### bin/sh 실행하기
- ```docker run  --rm -it ubuntu:20.04 /bin/sh```
    - 컨테이너 내부에 들어가기 위해 sh를 실행하고 키보드 입력을 위해 -it옵션을 준다.
    - 추가적으로 프로세스가 종료되면 컨테이너가 자동으로 삭제 되도록 --rm 옵션도 추가 한다.
    - --rm 옵션이 없다면 컨테이너가 종료되더라도 삭제되지 않고 남아 있어 수동으로 삭제 해야 한다.

### CentOS 실행하기
- ```docker run --rm -it centos:8 /bin/sh```
    - 도커는 다양한 리눅스 배포판을 실행할 수 있다. 공통점은 모두 동일한 커널을 사용한다는 점이다.
    - Ubuntu 또는 CentOS에 포함된 다양한 기본기능이 필요 없는 경우, Alpine 이라는 초소형(5MB)이미지를 사용할 수도 있다.

### 웹 어플리케이션 실행하기
- ``` docker run --rm -p 5678:5678 hashicorp/http-echo -text="hello world" ```
    - detached mode(백그라운드 모드)로 실행하기 위해 -d 옵션을 추가하고 -p 옵션을 추가하여 컨테이너 포트를 호스트의 포트로 연결하였다.
    - 브라우저를 열골 localhost:5678에 접속하면 메시지를 볼 수 있다.

### Redis 실행하기
- ```docker run --rm -p 1234:6379 redis```
    - redis라는 메모리기반 데이터베이스를 실행
    ``` 
    $ telnet localhost 1234 # telnet이 설치되어 있으면 접속 가능
    
    set hello world
    +OK
    get hello
    $5
    world
    quit
    ```

### MySQL 실행하기 
```
docker run -d -p 3306:3306 \
  -e MYSQL_ALLOW_EMPTY_PASSWORD=true \
  --name mysql \
  mysql:5.7
```
```
MySQL 데이터베이스를 실행한다.
docker exec -it mysql mysql 
create database wp CHARACTER SET utf8;
grant all privileges on wp.* to wp@'%' identified by 'wp';
flush privileges;
quit
```

### exec 명령어
- exec 명령어는 run 명령어와 달리 실행중인 도커 컨테이너에 접속할 때 사용하며
컨테이너 안에 ssh server등을 설치하지 않고 exec 명령어로 접속한다.
  
### 도커는 다양한 데이터베이스를 손쉽게 생성/삭제할 수 있기 때문에 개발할때도 많이 사용한다.

### 워드프레스 블로그 실행하기
```
docker run -d -p 8080:80 \
  -e WORDPRESS_DB_HOST=host.docker.internal \
  -e WORDPRESS_DB_NAME=wp \
  -e WORDPRESS_DB_USER=wp \
  -e WORDPRESS_DB_PASSWORD=wp \
  wordpress
```
- 앞에서 만든 MySQL을 실행한 상태에서 생성한다.
- 웹브라우저 localhost:8080으로 접속 한다.

</details>

<details> <summary> 3. 도커 기본 명령어(ps, stop, rm, logs, images, ...) </summary>

## 3. 도커 기본 명령어(ps, stop, rm, logs, images, ...)
### ps 명령어
- `docker ps`
  - 실행중인 컨테이너 목록을 확인하는 명령어
- `docker ps -a`
  - 중지된 컨테이너도 확인하려면 -a 옵션을 붙임 
  
### stop 명령어
- `docker stop [OPTIONS] CONTAINER [CONTAINER...]`
  - 실행중인 컨테이너를 중지하는 명령어
  - 실행중인 컨테이너를 하나 또는 여러개(띄어쓰기) 중지할 수 있다.
  
### rm 명령어
- `docker rm [OPTIONS] CONTAINER [CONTAINER...]`
  - 종료된 컨테이너를 완전히 제거하는 명령어

### logs 명령어
- `docker logs [OPTIONS] CONTAINER`
  - 컨테이너가 정상적으로 동작하는지 확인하는 좋은 방법은 로그를 확인하는 것이다.
  - 기본 옵션과 -f, --tail 옵션을 살펴보자. 

### images 명령어
- `docker images [OPTIONS] [REPOSITORY[:TAG]]`
  - 도커가 다운로드한 이미지 목록을 보는 명령어

### pull 명령어
- `docker pull [OPTIONS] NAME[:TAG|@DIGEST]`
  - 이미지를 다운로드하는 명령어
  - ex) `docker pull ubuntu:18.04`

### rmi 명령어
- `docker rmi [OPTIONS] IMAGE [IMAGE...]`
  - 이미지를 삭제하는 방법
  - images 명령어를 통해 얻는 이미지 목록에서 이미지 ID를 입력하면 삭제가 된다.
  단, 컨테이너가 실행중인 이미지는 삭제되지 않는다.

### network create 명령어
- `docker network create [OPTIONS] NETWORK`
  - 도커 컨테이너끼리 이름으로 통신할 수 있는 가상 네트워크를 만든다ㅣ.
- `docker network create app-network`
  - app-network 라는 이름으로 wordpress와 mysql이 통신할 네트워크를 만든다.

### network connect 명령어
- `docker network connect [OPTIONS] NETWORK CONTAINER`
  - 기존에 생성된 컨테이너에 네트워크를 추가한다.
- `docker network connect app-network mysql`
  - mysql 컨테이너에 네트워크를 추가한다.

### network option 명령어
```
  docker run -d -p 8080:80 \
  --network=app-network \
  -e WORDPRESS_DB_HOST=mysql \
  -e WORDPRESS_DB_NAME=wp \
  -e WORDPRESS_DB_USER=wp \
  -e WORDPRESS_DB_PASSWORD=wp \
  wordpress
```
- 워드프레스를 app-network에 속하게 하고 mysql을 이름으로 접근한다.
</details>

<details> <summary> 4. 도커 기본 명령어(volume) </summary>

## 4. 도커 기본 명령어(volume)

### volume mount (-v) 명령어
```
docker stop mysql
docker rm mysql
docker run -d -p 3306:3306 \
  -e MYSQL_ALLOW_EMPTY_PASSWORD=true \
  --network=app-network \
  --name mysql \
  -v /Users/singyeongdeog/mysql:/var/lib/mysql \
  mysql:5.7
```
- mysql을 삭제후에 다시 실행하면 워드프레스 사이트에서 데이터베이스 오류가 발생
- `-v` 옵션으로 내 pc에 데이터를 저장할 위치를 선택 
- `-v` 옵션을 안주게 되면 기본적으로 컨테이너를 삭제하면 저장 데이터들은 삭제됨

</details>



<details> <summary> 5. 도커 컴포즈 (docker compose) 기본 </summary>

## 5. 도커 컴포즈 (docker compose) 기본

- 도커 명령어들이 띄어 쓰기나 명령어들을 조심스럽게 써야 한다는 단점이 존재한다. 이걸 편하게 해주는 프로그램이 docker-compose이다.
- docker-compose는 기본적으로 docker-for-mac, docker-for-window를 설치하면 같이 설치 된다.

### 설치 확인 
```
$ docker-compose version
```
- 리눅스는 다음 명령어로 설치 해야 된다.
```
sudo curl -L "https://github.com/docker/compose/releases/download/1.26.0/
docker-compose-$(uname -s) 
sudo chmod +x /usr/local/bin/docker-compose
```

### docker-compose.yml
```
version: '2'
services:
  db:
    image: mysql:5.7
    volumes:
      - ./mysql:/var/lib/mysql
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: wordpress
      MYSQL_DATABASE: wordpress
      MYSQL_USER: wordpress
      MYSQL_PASSWORD: wordpress
  wordpress:
    image: wordpress:latest
    volumes:
      - ./wp:/var/www/html
    ports:
      - "8080:80"
    restart: always
    environment:
      WORDPRESS_DB_HOST: db:3306 
      WORDPRESS_DB_USER: wordpress
      WORDPRESS_DB_PASSWORD: wordpress
      WORDPRESS_DB_NAME: wordpress
```

### up 명령어
`docker-compose up -d`
- docker compose를 이용하여 mysql과 wordpress를 실행한다.
- docker-compose.yml 파일 위치에 가서 명령어를 입력해야한다.

### down 명령어
`docker-compose down`
- docker compose를 이용하여 mysql과 wordpress를 종료한다.

</details>


<details> <summary> 6. 도커 컴포즈 문법 & 명령어 </summary>

## 6. 도커 컴포즈 문법 & 명령어

## 6-1 도커 컴포즈 문법
### version
`version: '3'`

- docker-compose.yml 파일의 명세 버전
- docker-compose.yml 버전에 따라 지원하는 도커 에진 버전도 다름


### services
```
services:
  postgres:
  ...
  django:
  ...
```
- 실행할 컨테이너 정의
- docker run --name djange와 같다고 생각할 수 있음

### image
```
services:
  django:
    image: django-sample
```
- 컨테이너에 사용할 이미지 이름과 태그
- 태그를 생략하면 latest
- 이미지가 없으면 자동으로 pull

### ports
```
services:
  django:
    ...
    ports:
    -"8000:8000"
```
- 컨테이너와 연결할 포트(들)
- {호스트 포트}:{컨테이너 포트}

### environment
```
services:
  mysql:
    ...
    environment:
      - MYSQL_ROOT_PASSWORD=somewordpress:'3'
```
- 컨테이너에서 사용할 환경변수(들)
- {환경변수 이름}:{값}

### volumes
```
services:
  django:
    ...
    volumes:
      - ./app:/app
```
- 마운트하려는 디렉터리(들)
- {호스트 디렉터리}:{컨테이너 디렉터리}

### restart
```
services:
  django:
    restart: always
```
- 재시작 정책
  - restart: "no"
  - restart: always
  - restart: on-failure
  - restart: unless-stopped

### build
```
django:
  build:
    context: .
    dockerfile: ./compose/django/Dockerfile-dev
```
- 이미지를 자체 빌드 후 사용
- image 속성 대신 사용함
- 여기에 사용할 별도의 도커 파일이 필요함 

## 6-2 도커 컴포즈 명령어 

### up
- docker-compose.yml에 정의된 컨테이너를 실행
- docker-compose up
- docker-compose up -d
  - docker run의 -d 옵션과 동일
- docker-compose up --force-recreate
  - 컨테이너를 새로 만들기
- docker-compose up --build
  - 도커 이미지를 다시 빌드(build로 선언했을 때만)

### start
- 멈춘 컨테이너를 재개
- docker-compose start
- docker-compose start wordpress
  - wordpress 컨테이너만 재개 

### restart
- 컨테이너를 재시작
- docker-compose restart
- docker-compose restart wordpress
  - wordpress 컨테이너만 재시작
  
### stop
- 컨테이너 멈춤 
- docker-compose stop
- docker-compose stop wordpress
  - wordpress 컨테이너만 멈춤
  
### down  
- 컨테이너를 종료하고 삭제
- docker-compose down

### logs
- 컨테이너의 로그 
- docker-compose logs
- docker-compose logs -f
  - 로그 follow
  
### ps
- 컨테이너 목록
- docker-compose ps

### exec
- 실행중인 컨테이너에서 명령어 실행
- docker-compose exec {컨테이너 이름} {명령어}
- docker-compose exec wordpress bash

### build
- 컨테이너 build 부분에 정의된 내용대로 빌드
- build로 선언된 컨테이너만 빌드됨
- docker-compose build
- docker-compose build wordpress
  - wordpress 컨테이너만 build
  
</details>

<details> <summary> 7. [실습] nginx 컨테이너 만들기 </summary>

## 7. [실습] nginx 컨테이너 만들기

- 참고링크
  - https://hub.docker.com/_/nginx/
  
- 실습 정보
  - 이미지: nginx:latest
  - 포트: 80
  - HTML 경로: /usr/share/nginx/html
- 문제 > 다음 조건을 만족하는 컨테이너를 실행
  1. nginx 컨테이너를 50000 포트로 연결하여 실행
  2. 임의의 index.html파일을 만들고 이 파일 내요을 제공하는 nginx 컨테이너 실행 (docker run -v 옵션 활용)
  
[정답](./2.nginx)

</details>




<details> <summary> 8. [실습] php cli 컨테이너 실행하기 </summary>

## 8. [실습] php cli 컨테이너 실행하기

- 참고링크
  - https://hub.docker.com/_/php/

- 실습 정보
  - 이미지: php:7
  - 브라우저 접속이 아닌 CLI 테스트
- 문제 > 다음 조건을 만족하는 컨테이너를 실행
  다음 소스를 hello.php로 저장 
  
  `<?php phpinfo() ?>`
  1. hello.php를 php container로 실행 (-v 옵션으로 hello.php를 연결)
  2. 실행결과(php 설정 정보)를 확인 

[정답](./3.php-cli)

</details>




# 3. 도커-이미지 만들고 배포하기

<details> <summary> 1. 도커 이미지 만들기 - 기본 </summary>

## 1. 도커 이미지 만들기 - 기본

### 이미지란
- 도커는 레이어드 파일 시스템 기반
- AUFS, BTRFS, Overlayfs, ...
- 이미지는 프로세스가 실행되는 파일들의 집합(환경)
- 프로세스는 환경(파일)을 변경할 수 있음
- 이 환경을 저장해서 새로운 이미지를 만듬

### rootfs / Base Image
- 수정할 수 없는 읽기 전용 이미지
- ubuntu, centos, mysql, ...

### 상태변화 
![image](https://user-images.githubusercontent.com/28394879/131294568-26ac9084-16b3-4525-b334-dd7e0c5be0f1.png)

### 예시 - Git 설치
```
$ docker run -it --name git ubuntu:latest bash
root@2f8bfff679f9:/# git
bash: git: command not found
root@2f8bfff679f9:/# apt-get update
root@2f8bfff679f9:/# apt-get install -y git
root@2f8bfff679f9:/# git --version
git version 2.17.1
```

```
$docker images | grep ubuntu
ubuntu  latest    cf0f3ca922e0    5 days ago  64.2MB

$docker commit git ubuntu:git

$docker images | grep ubuntu
ubuntu git        f95008381e22    17 seconds ago 186MB
ubuntu  latest    cf0f3ca922e0    5 days ago  64.2MB
```


### 새로운 상태를 이미지로 저장 
![image](https://user-images.githubusercontent.com/28394879/131295286-bcd3fa4d-6136-4f24-8b2d-c911ed845ae6.png)


### 도커 이미지 이름 규칙
- docker build -t subicura/ubuntu:git01.
- subicura : 이름 공간(유저이름)
- ubuntu : 이미지 이름
- git01 : 태그
- 이름 공간이 없을 경우엔 공식 이미지 이다.


### 이미지를 만드는 자세
- TDD 하듯이 해야 됨.
- 한번에 성공하는 빌드는 없음
- 파란불(빌드 성공)이 뜰 떄까지 많은 빨간불(빌드 실패)를 경험함
- 일단 파란불이 켜져도 리팩토링을 통해 더 최적화된 이미지 생성


### Dockerfile
- FROM: 기본 이미지
- RUN: 쉘 명령어 실행
- CMD: 컨테이너 기본 실행 명령어 (Entrypoint의 인자로 사용)
- EXPOSE: 오픈되는 포트 정보
- ENV: 환경변수 설정
- ADD: 파일 또는 디렉토리 추가. URL/ZIP 사용가능
- COPY: 파일 또는 디렉토리 추가
- ENTRYPOINT: 컨테이너 기본 싫행 명령어
- VOLUME: 외부 마운트 포인트 생성
- USER: RUN, CMD, ENTRYPOINT를 실행하는 사용자
- WORKDIR: 작업 디렉토리 설정
- ARGS: 빌드타임 환경변수 설정
- LABEL: key - value 데이터
- ONBUILD: 다른 빌드의 베이스로 사용될 떄 사용하는 명령어

### 이미지 빌드하기
```
docker build -t {이미지명:이미지태그} {빌드 컨텍스트}
$ docker build -t sample:1 .
```
- 현재 디렉토리의 Dockerfile로 빌드
  - -f <Dockerfile 위치> 옵션을 사용해 다른 위치의 Dockerfile 파일 사용 가능
  - -t 명령어로 도커 이미지 이름을 지정
  - {네임스페이스}/{이미지이름}:{태그} 형식
- 마지막에는 빌드 컨텍스트 위치를 지정
  - 현재 디렉터리를 의미하는 점(.)을 주로 사용
  - 필요한 경우 다른 디렉터리를 지정할 수도 있음
  

### .dockerignore
- .gitignore와 비슷한 역할
- 도커 빌드 컨텍스트에서 지정된 패턴의 파일을 무시
- .git이나 민감한 정보를 제외하는 용도로 주로 사용
- .git이나 에셋 디렉터리만 제외시켜도 빌드 속도 개선
- 이미지 빌드 시에 사용하는 파일은 제외시키면 안 됨

### Git을 설치한 ubuntu 이미지
```
FROM ubuntu:latest
RUN apt-get update
RUN apt-get install -y git
```
- Dockerfile을 만들고 빌드 한다.
```
$ docker build -t ubuntu:git-dockerfile .
$ docker images | grep ubuntu
```
- [Dockerfile](4.git/Dockerfile)

</details>





<details> <summary> 2. 도커 이미지 만들기 - 웹 애플리케이션 (nodejs) </summary>

## 2. 도커 이미지 만들기 - 웹 애플리케이션 (nodejs)

### Nodejs 웹 애플리케이션
```
$ npm init
$ npm i fastify --save
```
- 소스 파일 복사 > COPY 명령어
- node_modules 제외 > .dockerignore
```
# 1. node 설치
FROM ubuntu:20.04
RUN apt-get update
RUN DEBIAN_FRONTEND=noninteractive apt-get install -y nodejs npm

# 2. 소스 복사 (현재 내 디렉토리에 있는 모든 파일을 /usr/src/app에 복사)
COPY . /usr/src/app

# 3. Nodejs 패키지 설치 ( /usr/src/app으로 이동 후 npm install 실행)
WORKDIR /usr/src/app
RUN npm install

# 4. WEB 서버 실행 (Listen 포트 정의)
EXPOSE 3000
CMD node app.js
```

`node_modules/*` - .dockerignore

- 이미지 빌드하기
  - `docker build -t subicura/app .`
- 컨테이너 실행하기
  - `docker run --rm -d -p 3000:3000 subicura/app`

### Nodejs 웹 애플리케이션 node 이미지 사용
```
# 1. node 이미지 사용 / 여기부분을 3줄이였는데 1줄로 변경
FROM node:12
# 2. 소스 복사
COPY . /usr/src/app
# 3. Nodejs 패키지 설치
WORKDIR /usr/src/app
RUN npm install
# 4. WEB 서버 실행 (Listen 포트 정의)
EXPOSE 3000
CMD node app.js
```

### Nodejs 웹 애플리케이션 패키지 우선 복사 최적화
```
# 1. node 이미지 사용
FROM node:12
# 2. 패키지 우선 복사
COPY ./package* /usr/src/app/
WORKDIR /usr/src/app
RUN npm install
# 3. 소스 복사
COPY . /usr/src/app
# 4. WEB 서버 실행 (Listen 포트 정의)
EXPOSE 3000
CMD node app.js
```

### Nodejs 웹 애플리케이션 alpine 사용으로 SIZE 줄이기
```
# 1. node 이미지 사용 (alpine: 사용하지 않는 파일을 다 제거한 버전)
FROM node:12-alpine
# 2. 패키지 우선 복사
COPY ./package* /usr/src/app/
WORKDIR /usr/src/app
RUN npm install
# 3. 소스 복사
COPY . /usr/src/app
# 4. WEB 서버 실행 (Listen 포트 정의)
EXPOSE 3000
CMD node app.js
```

### FROM
`FROM [--platform=<platform>] <image>[:<tag>] [AS <name>]`
- 베이스 이미지 지정
- FROM ubuntu:latest
- FROM node:12
- FROM python:3

### COPY
`COPY [--chown=<user>:<group>] <src>... <dest>`
- 파일 또는 디렉토리 추가
- COPY index.html /var/www/html/
- COPY ./app /usr/src/app

### RUN
`RUN <command>`
- 명령어 실행
- RUN apt-get update
- RUN npm install

### WORKDIR
`WORKDIR /path/to/workdir`
- 작업 디렉토리 변경
- WORKDIR /app

### EXPOSE
`EXPOSE 3000`
- 컨테이너에서 사용하는 포트 정보
- EXPOSE 8000

### CMD
```
CMD ["executable","param1","param2"]
CMD command param1 param2
```
- 테이너 생성시 실행할 명령어
- CMD ["node","app.js"]
- CMD node app.js

  
</details>






<details> <summary> 3. 도커 허브 (docker hub) 이미지 관리  </summary>

## 3. 도커 허브 (docker hub) 이미지 관리

### 이미지 저장 명령어 
- docker login
- docker push {ID}/example
- docker pull {ID}/example

### 이미지 저장 & 불러오기
![image](https://user-images.githubusercontent.com/28394879/131339003-19f27126-bdaf-42b7-8ee6-ca82759156f0.png)



</details>





<details> <summary> 4. 도커 배포 기본 </summary>

## 4. 도커 배포 기본

### 배포하기
`docker run -d -p 3000:3000 subicura/app`
- 컨테이너 실행 = 이미지 pull + 컨테이너 start

</details>






<details> <summary> 5. [실습] Nginx를 이용한 정적 페이지 서버 만들기 </summary>

## 5. [실습] Nginx를 이용한 정적 페이지 서버 만들기

- 참고링크: https://hub.docker.com/_/nginx/
- 실습 정보
  - 이미지: nginx:latest
  - 포트: 80
  - HTML 경로: /usr/share/nginx/html
- 문제 > 다음 조건을 만족하는 이미지를 만들고 컨테이너를 실행 해라.
  1. index.html 을 만들고 빌드할 때 복사 (-v 옵션 사용 아님)
  ```
  <html>
  <head>
    <title>도커 이미지 예제</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  </head>
  <body>
    <h1>Nginx 서버를 도커 이미지로 만들었습니다.</h1>
  </body>
  </html>
  ```
- [정답](6.nginx)

</details>






<details> <summary> 6. [실습] Hellonode 실습 </summary>

## 6. [실습] Hellonode 실습
- node.js 기반의 웹서비스를 빌드한다.
- 빌드한 이미지를 실행한다.
- 설명
  - Hello, World! Hostname: 0340bdc376e5
  - 포트 - 8080
  - 소스파일
    - server.js
    - ```
      const http = require('http');
      const os = require('os');
      
      const port = process.env.PORT || 8080;
      
      process.on('SIGINT', function() {
      console.log('shutting down...');
      process.exit(1);
      });
      
      var handleRequest = function(request, response) {
      console.log(`Received request for URL: ${request.url}`);
      response.writeHead(200);
      response.end(`Hello, World!\nHostname: ${os.hostname()}\n`);
      };
      
      var www = http.createServer(handleRequest);
      www.listen(port, () => {
      console.log(`server listening on port ${port}`);
      });
      ```
- 문제) 다음 조건을 만족하는 이미지를 만들고 컨테이너를 실행해라
  1. hellonode:latest 이미지를 만든다.
  2. 호트스의 60000 포트로 오픈한다.

- [정답](7.hellonode)

</details>


# 4. 더보기

<details> <summary> 1. 더보기 </summary>

## 1. 더보기

### 더보기 
- 이미지를 만들기 위한 다양한 쉘 스크립트 & 환경변수 사용
- CI/CD 자동빌드, 자동배포, blue & green 배포 / 무중단 배포하기
- 모니터링, 로그
- 가상 네트워크
- 보안
- 쿠버네티스 (kubernetes)
- 이스티오 서비스매시 (istio)


</details>





<details> <summary> 2. [실습] ghost 블로그 컨테이너 생성 </summary>

## 2. [실습] ghost 블로그 컨테이너 생성

- Ghost 블로그를 컨테이너로 실행하고 외부에서 접속 가능하게 포트를 노출한다.
- 참고 링크
  - https://hub.docker.com/_/ghost
- 컨테이너 이미지 정보
  - 이미지: ghost:latest
  - 리스닝포트: 2368
  - 데이터저장: /var/lib/ghost/content
- 실습 내용
  1. 60000 포트로 오픈
  2. 업로드 데이터가 유실되지 않게 볼륨을 마운트
  3. 관리자에서 미리보기 페이지가 정상작동하도록 환경변수를 설정
  4. docker-compose.yml 파일로 작성

- [정답](8.ghost)

</details>









<details> <summary> 3. [실습] 방명록 배포하기 </summary>

## 3. [실습] 방명록 배포하기

- Frontend, Backend, Database로 이루어진 웹 서비스를 배포한다.
- 각각의 서비스를 바라보는 endpoint를 환경변수로 지정할 수 있다.
- 호스트 네트워크 방식, 가상 네트워크 방식, docker-compose 방식을 사용한다.

- 실습 설명
![image](https://user-images.githubusercontent.com/28394879/131345641-d2ae5914-a8f7-4cc3-907c-537b2dc7ce7b.png)

- 실행 순서
  1. mongodb
  2. backend (mongodb를 바라봄)
  3. frontend (backend를 바라봄)
  
- frontend
  - 이미지: subicura/guestbook-frontend:latest
  - 포트: PORT 환경변수에 지정한대로 사용함
  - 환경변수
    - PORT: 리스닝 포트로 설정
    - GUESTBOOK_API_ADDR: Backend 서버 주소 ex) backend:8000

- backend
  - 이미지: subicura/guestbook-backend:latest
  - 포트: PORT 환경변수에 지정한대로 사용함
  - 환경변수
    - PORT: 리스닝 포트로 설정
    - GUESTBOOK_DB_ADDR: DB 서버 주소 ex) mongodb: 27017
  
- mongodb
  - 이미지: mongo:4
  - 포트: 27017
  
- 실습내용
  1. 62000 포트로 서버를 오픈
  2. docker-compose.yml 파일로 작성

- [정답](9.guestbook)

</details>









<details> <summary> 4. [실습] 투표 앱 생성 </summary>

## 4. [실습] 투표 앱 생성

- 깃 리파지토리를 clone 후 진행
- 필요한 이미지를 직접 빌드하여 만듬
- 여러개의 마이크로서비스를 연결

- 참고링크: https://gitlab.com/44bits.io/workshop-voting.git
  ![image](https://user-images.githubusercontent.com/28394879/131346205-16d5614e-0307-467a-9f63-73a13c981566.png)
  
- 컨테이너 이미지 정보
  - vote
    - 소스경로: ./vote
    - 포트: 80
    - voting-vote 이미지로 빌드
  - redis
    - 이미지: redis:alpine
    - redis 이름으로 서비스를 생성
  - worker
    - 소스경로: ./worker
    - 포트: 없음
    - voting-worker 이미지로 빌드
  - db
    - 이미지: postgres:9.4
    - db 이름으로 서비스를 생성
  - result
    - 소스경로: ./result
    - 포트: 80
    - voting-result 이미지로 빌드

- 실습 내용
  1. 5개의 서비스를 하나의 docker-compose.yml로 만듭니다. 
  2. vote는 60001로 오픈합니다. 
  3. result는 60002로 오픈합니다. 
  4. docker-compose.yml 파일로 작성합니다.

- [정답](10.vote-app)

</details>






<details> <summary> 5. [실습] 실시간 채팅 앱 생성 </summary>

## 5. [실습] 실시간 채팅 앱 생성

- hasura를 이용하여 채팅 앱을 만듭니다. 
- 처음 듣는 서비스를 문서를 보고 구성하는 방법을 익힙니다. 
- 문서가 오래되었을수도 있고 원하는 버전과 다른 설명이 있을 수 있음을 알아봅니다.

- 참조 링크
  - https://gitlab.com/44bits.io/workshop-chatpp.git
  - https://hasura.io/
  - https://hub.docker.com/r/hasura/graphql-engine
  - https://docs.hasura.io/1.0/graphql/manual/migrations/auto-apply-migrations.html

- 컨테이너 이미지 정보
  - frontend
    - 소스 경로: ./
    - 포트: 8080
    - src/index.js에서 HASURA_GRAPHQL_ENGINE_HOSTNAME을 테스트하는 IP로 변경합니다.
    - chatapp 이미지로 빌드합니다.

  - backend (hasura)
    - 마이그레이션 폴더: ./hasura/migrations
    - 포트: 8080
    - hasura 이미지 중에 마이그레이션을 위한 이미지를 사용합니다.

- 실습내용
1. frontend를 60003 포트로 오픈합니다.
2. backend를 60004 포트로 오픈합니다.
3. 60004로 접속하여 테이블이 잘 생성되었는지 확인합니다.
4. 60003으로 테스트합니다.
5. docker-compose.yml 파일로 작성합니다.

- [정답](11.chatapp)

</details>








<details> <summary> 6. 도커쿡북 </summary>

## 6. 도커쿡북
- [초보를+위한+도커안내서_도커+쿡북](초보를+위한+도커안내서_도커+쿡북.pdf)


</details>

