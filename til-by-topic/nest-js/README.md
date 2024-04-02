
- [1. Nest JS 소개](#1-nest-js-소개)
  - [NestJS란?](#nestjs란)
  - [NestJS CLI 설치하기](#nestjs-cli-설치하기)
- [2. Nest JS 기본 요소](#2-nest-js-기본-요소)

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