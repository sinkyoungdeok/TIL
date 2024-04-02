
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

# 1. Nest JS 소개

## NestJS란?

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

## NestJS CLI 설치하기 
아래 명령어로 새 프로젝트 디렉터리가 생성되고 초기 핵심 Nest 파일 및 지원 모듈로 디렉터리가 채워짐 

```
npm i -g @nestjs/cli
nest new project-name
nest --version
```

# 2. Nest JS 기본 요소

## NestJS 모듈 

**Nest JS 모듈이란?**  
- 모듈은 @Module {} 데코레이터로 주석이 달린 클래스 
- @Module {} 데코레이터는 Nest가 애플리케이션 구조를 구성하는 데 사용하는 메타 데이터를 제공 
- 모듈은 밀접하게 관련된 기능 집합으로 구성 요소를 구성하는 효과적인 방법 
- 같은 기능에 해당하는 것들은 하나의 모듈안에 넣어서 사용 (UserModule = UserController + UserService + UserEntity)
- 모듈은 기본적으로 싱글 톤이므로 여러 모듈간에 쉽게 공급자의 동일한 인스턴스를 공유

## Board Module 생성 
```
nest g module boards
```

## NestJS Contrller란 ?

**Controller 란?**
- 들어오는 요청을 처리하고 클라이언트에 응답을 반환
- @Controller 데코레이터로 클래스를 데코레이터하여 정의 

**Handler 란?**
- @Get, @Post, @Delete 등과 같은 데코레이터로 장식 된 컨트롤러 클래스 내의 단순 메소드 

## Board Controller 생성
```
nest g controller boards --no-spec
```

## NestJS Providers, Service 란?

**Providers 란?**
- Nest의 기본 개념.
- 기본 Nest 클래스는 서비스, 리포지토리, 팩토리, 헬퍼등 프로바이더로 취급될 수 있음 
- 프로바이더의 주요 아이디어는 종속성으로 주입할 수 있다는 것이다.
- 객체의 인스턴스를 연결하는 기능 대부분은 Nest 런타임 시스템에 위임할 수 있다

**Service 란?**
- @Injectable 데코레이터로 감싸져서 모듈에 제공되며, 애플리케이션 전체에서 사용가능
- 서비스는 컨트롤러에서 데이터의 유효성 체크를 하거나 데이터베이스에 아이템을 생성하는 등의 작업을 한다.
- Service를 Controller에서 이용하려면 Dependency Injection을 해야 한다 

## Board Service 만들기 
```
nest g service boards --no-spec
```