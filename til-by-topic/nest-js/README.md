
- [1. Nest JS 소개](#1-nest-js-소개)
  - [NestJS란?](#nestjs란)
  - [NestJS CLI 설치하기](#nestjs-cli-설치하기)
- [2. Nest JS 기본 요소](#2-nest-js-기본-요소)
  - [NestJS 모듈](#nestjs-모듈)
  - [Board Module 생성](#board-module-생성)
  - [NestJS Contrller란 ?](#nestjs-contrller란-)
  - [Board Controller 생성](#board-controller-생성)
  - [NestJS Providers, Service 란?](#nestjs-providers-service-란)
  - [Board Service 만들기](#board-service-만들기)
- [3. CRUD 구현](#3-crud-구현)
  - [모든 게시물을 가져오는 Service 만들기](#모든-게시물을-가져오는-service-만들기)
  - [Board Model 정의](#board-model-정의)
  - [Data Transfer Object(DTO)](#data-transfer-objectdto)
- [4. Pipe 이용](#4-pipe-이용)
  - [NestJS Pipes](#nestjs-pipes)
  - [파이프를 이용한 유효성 체크](#파이프를-이용한-유효성-체크)

## 1. Nest JS 소개

### NestJS란?

**Nest JS 란?**
- Nest(NestJS)는 효율적이고 확장 가능한 Node.js 서버측 애플리케이션을 구축하기 위한 프레이뭐크
- 프로그래시브 JS를 사용하고 TS로 빌드되고 완벽하게 지원하며 OOP, FP, FRP 요소를 사용할 수 있게 해줌

**Nest JS 내부 구성**
- 내부적으로 Express와 같은 HTTP 서버 프레임워크를 사용
- 선택적으로 Fastify를 사용 

**Nest JS 의 철학**
- Node를 훌륭한 라이브러리, 도구가 많이 존재하지만 아키텍처의 주요 문제를 효과적으로 해결하지 못한다
- Nest는 개발자와 팀이 고도로 테스트 가능하고 확장 가능하며 느슨하게 결합되고 유지 관리가 쉬운 애플리케이션을 만들 수 있는 즉시 사용 가능한 애플리케이션 아키텍처를 제공 
- 아키텍처는 Angular에서 영감을 받음 

### NestJS CLI 설치하기 
아래 명령어로 새 프로젝트 디렉터리가 생성되고 초기 핵심 Nest 파일 및 지원 모듈로 디렉터리가 채워짐 

```
npm i -g @nestjs/cli
nest new project-name
nest --version
```

## 2. Nest JS 기본 요소

### NestJS 모듈 

**Nest JS 모듈이란?**  
- 모듈은 @Module {} 데코레이터로 주석이 달린 클래스 
- @Module {} 데코레이터는 Nest가 애플리케이션 구조를 구성하는 데 사용하는 메타 데이터를 제공 
- 모듈은 밀접하게 관련된 기능 집합으로 구성 요소를 구성하는 효과적인 방법 
- 같은 기능에 해당하는 것들은 하나의 모듈안에 넣어서 사용 (UserModule = UserController + UserService + UserEntity)
- 모듈은 기본적으로 싱글 톤이므로 여러 모듈간에 쉽게 공급자의 동일한 인스턴스를 공유

### Board Module 생성 
```
nest g module boards
```

### NestJS Contrller란 ?

**Controller 란?**
- 들어오는 요청을 처리하고 클라이언트에 응답을 반환
- @Controller 데코레이터로 클래스를 데코레이터하여 정의 

**Handler 란?**
- @Get, @Post, @Delete 등과 같은 데코레이터로 장식 된 컨트롤러 클래스 내의 단순 메소드 

### Board Controller 생성
```
nest g controller boards --no-spec
```

### NestJS Providers, Service 란?

**Providers 란?**
- Nest의 기본 개념.
- 기본 Nest 클래스는 서비스, 리포지토리, 팩토리, 헬퍼등 프로바이더로 취급될 수 있음 
- 프로바이더의 주요 아이디어는 종속성으로 주입할 수 있다는 것이다.
- 객체의 인스턴스를 연결하는 기능 대부분은 Nest 런타임 시스템에 위임할 수 있다

**Service 란?**
- @Injectable 데코레이터로 감싸져서 모듈에 제공되며, 애플리케이션 전체에서 사용가능
- 서비스는 컨트롤러에서 데이터의 유효성 체크를 하거나 데이터베이스에 아이템을 생성하는 등의 작업을 한다.
- Service를 Controller에서 이용하려면 Dependency Injection을 해야 한다 

### Board Service 만들기 
```
nest g service boards --no-spec
```

## 3. CRUD 구현 

### 모든 게시물을 가져오는 Service 만들기 
1. 클라이언트에서 요청을 보내면 컨트롤러에서 알맞은 요청 경로에 라우팅해서 해당 핸들러로 감 
2. 요청을 처리해주기 위해서 서비스로 들어감
3. 그 요청에 맞는 로직을 서비스에서 처리후 컨트롤러에 리턴값을 보냄
4. 컨트롤러에서 클라에 결과값을 보내줌 

### Board Model 정의 
- 모델은 인터페이스 또는 클래스로 정의 가능 
- 인터페이스: 변수의 타입만 체크
- 클래스: 변수의 타입 체크 + 인스턴스 생성

### Data Transfer Object(DTO)
- 계층간 데이터 교환을 위한 객체
- DB에서 데이터를 얻어 Servcie, Controller 등으로 보낼 때 사용하는 객체
- 데이터가 네트워크를 통해 전송되는 방법을 정의하는 객체 
- interface, class 를 이용할 수 있지만, Nest JS에서는 Class를 추천


## 4. Pipe 이용

### NestJS Pipes
- @Injectable() 데코레이터로 주석이 달린 클래스
- data transformation, data validation 을 위해서 사용 
- 파이프는 컨트롤러 경로 처리기에 의해 처리되는 인수에 대해 작동
- Nest는 메서드가 호출되기 직전에 파이프를 삽입하고 파이프는 메서드로 향하는 인수를 수신하고 이에대해 작동


**Data Transformation**
- 입력 데이터를 원하는 형식으로 변환 (ex. 문자열을 정수로 변환)
- 만약 숫자를 받길 원하는데 문자열 형식으로 오면 파이프에서 자동으로 숫자로 바꿔줌

**Data Validation**
- 입력 데이터를 평가하고 유효한 경우 변경되지 않은 상태로 전달하고, 유효하지 않으면 예외를 발생 시킴
- ex. 이름의 길이가 10자 이하여야 하는데, 10자 이상이면 예외를 발생시킴

**PIPE 사용법(Binding Pipes)**
- 세가지로 나뉜다.
- Handler Level, Parameter Level, Global Level
- Handler Level: 특정한 핸들러에 적용 (모든 파라미터)
- Parameter Level: 특정한 파라미터에만 적용
- Global Level: 애플리케이션 전체 모든 요청에 적용
- Built-in Pipes: Nest JS에 기본적으로 사용할 수 있게 만든 6가지 파이프가 존재
  - ValidationPipe, ParseIntPipe, ParseBoolPipe, ParseArrayPipe, DefaultValuePipe, ParseUUIDPipe

### 파이프를 이용한 유효성 체크 
```
npm install class-validator class-transformer --save
```


## 5. Postgres & TypeORM 연동

### PostgresSQL 설치 
```bin/bash
docker run -p 5432:5432 --name postgres -e POSTGRES_DB=board-app -e POSTGRES_USER=user -e POSTGRES_PASSWORD=test_user -d postgres
```

### TypeORM 소개

**TypeORM 이란?**
- node.js에서 실행되고 TypeScript로 작성된 객체 관계형 매퍼 라이브러리
- MySQL, PostgreSQL, MariaDB, SQLite, MS SQL Server, Oracle, WebSQL 등 여러 DB를 지원


**ORM이란?**
- 객체와 관계형 데이터베이스의 데이터를 자동으로 변형 및 연결하는 작업
- 객체지향의 클래스와 RDB의 테이블 간 불일치 존재하는데 이것을 매핑 시켜준다

**TypeORM 특징과 이점**  
- 모델을 기반으로 DB 테이블 체계를 자동으로 생성 
- DB에서 객체를 쉽게 CRUD 할 수 있음
- 테이블 간의 매핑(일대일, 일대 다 및 다대다)을 만들 수 있음
- 간단한 CLI 명령을 제공
- 간단한 코딩으로 ORM 프레임워크를 사용하기 쉬움
- 다른 모듈과 쉽게 통합됨 

### TypeORM 이용 
```
npm install pg typeorm @nestjs/typeorm --save
```

