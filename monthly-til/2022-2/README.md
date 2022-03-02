# 2월 요약
- [개인 프로젝트] order&gift 프로젝트
  - Gift프로젝트 완성


<details> <summary>2022년 2월 1일</summary>

## 회사 업무

## 개인 공부
- [PS] python
  - 구현 문제 1문제  
- [개인플젝] order-and-gift-project
  - Gift 프로젝트 
    - Gift 서비스 - 선물하기 수락 상태로 변경 API
    - Gift 서비스 - 선물하기 조회 API 
    - Readme 정리 
    - 스프링 카프카와 코루틴 연동이 안되는 현상 정리
 
   
</details>

<details> <summary>2022년 2월 2일</summary>

## 회사 업무

## 개인 공부
- [PS] python
  - 구현 문제 1문제
- [kubernetes] 클라우드 네이티브를 위한 쿠버네티스 실전 프로젝트 
  - Chapter1 (0% -> 100%)
  - Chapter2 (0% -> 50%)


</details>

<details> <summary>2022년 2월 3일</summary>

## 회사 업무
- qa4 환경구축
  - application-qa4.properties 작성 마무리 (DB정보 등 기입 ) 후 검토
  - bamboo - deployment projects 생성
    - api
  - QA4 api 배포 -> 오류생겨서 전체적으로 검토
- 코드리뷰
  - ITSMCHG-6426 refactoring orderAdditionalInfo
  - ITSMCHG-6425 산재보험금 조회 API
  - ITSMCHG-6373 [배민1] 오더에 배정된 기사의 수행중인 오더 수 조회 api 추가
  - ITSMCHG-6125 [배민1] 배달할수있는 지점 찾기 api 추가
  - ITSMCHG-6375 mcash_transfer_subsets 삭제 프로시져 호출 및 일차감 시작 전 validation 추가

## 개인 공부
- [PS] python
  - 구현 문제 1문제
- [Java] 자바 플레이그라운드 with TDD, 클린코드 
  - Chapter1) 숫자야구게임 - 단위테스트 (0% -> 100%)
    


</details>

<details> <summary>2022년 2월 4일</summary>

## 회사 업무
- qa4 환경구축
  - QA4 api 배포 -> 오류생겨서 전체적으로 검토
- 코드리뷰
  - ITSMCHG-6373 [배민1] 오더에 배정된 기사의 수행중인 오더 수 조회 api 추가
  - ITSMCHG-5727 M캐시 대량이체 메인카테고리 오더아이디 추가
  - ITSMCHG-6384 지점 보험/정산 정보 추가

## 개인 공부
- [PS] python
  - dfs 문제 1문제

</details>

<details> <summary>2022년 2월 5일</summary>

## 회사 업무

## 개인 공부
- [PS] python, java 
  - dfs 문제 1문제

</details>

<details> <summary>2022년 2월 6일</summary>

## 회사 업무

## 개인 공부
- [PS] python, java 
  - dfs 문제 4문제

</details>

<details> <summary>2022년 2월 7일</summary>

## 회사 업무
- qa4 환경구축
  - QA4api 배포 -> DB SG inbound 요청
- 코드리뷰
  - [VRR-526] 도착지 변경 #4 - 라스트마일 수정 및 프라임 연동
  - ITSMCHG-6125 [배민1] 배달할수있는 지점 찾기 api 추가

## 개인 공부
- [PS] python 
  - 구현 1문제
- [Java] 자바 플레이그라운드 with TDD, 클린코드 
  - Chapter2) 자동차 경주 - TDD (0% -> 60%)

</details>

<details> <summary>2022년 2월 8일</summary>

## 회사 업무
- 연차

## 개인 공부
- [PS] python 
  - DFS&BFS 1문제
- [Java] 자바 플레이그라운드 with TDD, 클린코드
  - Chapter2) 자동차 경주 - TDD (60% -> 100%)
  - Chapter3) 좌표 계산기 - 상속, 인터페이스 (0% -> 100%)
  - Chapter4) 블랙잭 - 함수형 프로그래밍 (0% -> 25%)

</details>

<details> <summary>2022년 2월 9일</summary>

## 회사 업무
- qa4 환경구축
  - API & DB 연동 실패 - 상진님께 요청 및 대기
- 코드 리뷰
  - [VRR-526] 도착지 변경 #4 - 라스트마일 수정 및 프라임 연동
  - ITSMCHG-6423 곧도착 이벤트 추가
  - ITSMCHG-6384 지점 보험/정산 정보 추가
  - ITSMCHG-6125 [배민1] 배달할수있는 지점 찾기 api 추가

## 개인 공부
- [Java] 자바 플레이그라운드 with TDD, 클린코드
  - Chapter4) 블랙잭 - 함수형 프로그래밍 (25% -> 100%)
- [Spring] 스프링 MVC 2편 - 백엔드 웹 개발 활용 기술
  - Chapter1) 타임리프 - 기본 기능 (0% -> 20%)

</details>

<details> <summary>2022년 2월 10일</summary>

## 회사 업무
- qa4 환경구축
  - API 배포 
  - mysql DB연동 성공
  - redis, kafka 연동 실패 - 원인 분석 및 devops팀에 요청 
- 코드 리뷰
  - ITSMCHG-6423 곧도착 이벤트 추가
- 라스트마일 개발 토크
  - 발표 준비
    - Application Layer에서 사용하는 DTO들 명칭 정의
      - UPDATE, CREATE, DELETE request: ~Command로 사용결정
      - SELECT request: ~Criteria로 사용결정
      - response: ~Info로 사용결정
    - inner class를 적극적으로 사용 하는 것은 어떨까?
      - class 객체안에 class가 들어가야 하는 상황에는 DTO inner클래스로 만들고, req res에서 쓰는것으로 결정 

## 개인 공부

</details>

<details> <summary> 2022년 2월 11일 </summary>

## 회사 업무
- qa4환경구축
  - api, cron, mcash service
    - bamboo script 작성 및 배포
    - redis host 변경
    - redis,kafka 연동 확인
    - point, prime admin계정 추가
    - kibana에 index pattern 등록을 위해 devops팀에  네트워크 설정 요청
    - kibana에 index pattern 등록
  - push service
    - db생성 요청 (postgresql)
## 개인 업무
- [Spring] 스프링 MVC 2편 - 백엔드 웹 개발 활용 기술
  - Chapter1) 타임리프 - 기본 기능 (20% -> 100%) 

</details>

<details> <summary> 2022년 2월 12일 </summary>

## 회사 업무

## 개인 업무
- [PS] python&java
  - sorting 1문제 
- [Spring] 스프링 MVC 2편 - 백엔드 웹 개발 활용 기술
  - Chapter2) 타임리프 - 스프링 통합과 폼 (0% -> 100%)
  - Chapter3) 메시지, 국제화 (0% -> 50%)

</details>

<details> <summary> 2022년 2월 13일 </summary>

## 회사 업무

## 개인 업무
- [PS] python&java
  - sorting 2문제 
- [Spring] 스프링 MVC 2편 - 백엔드 웹 개발 활용 기술
  - Chapter3) 메시지, 국제화 (50% -> 100%)

</details>

<details> <summary> 2022년 2월 14일 </summary>

## 회사 업무
- qa4환경구축
  - push service
    - bamboo script 작성 및 배포
    - kibana에 index pattern 등록
- 위클리 미팅
- 1:1 미팅

## 개인 업무
- [PS] python
  - sorting 1문제
- [Spring] 스프링 MVC 2편 - 백엔드 웹 개발 활용 기술
  - Chapter4) 검증1 - Validation (0% -> 100%)
  - Chapter5) 검증2 - Bean Validation (0% -> 100%)

</details>


<details> <summary> 2022년 2월 15일 </summary>

## 회사 업무
- qa4환경구축
  - Mcash Service
    - RDS SG inbound rule 추가 요청
  - Cron
    - error 로그 확인 후 조치 (AWS KMS권한 에러)
- 코드 리뷰   
  - ITSMCHG-6486 기존 단건배송 오더 정책 수정

## 개인 업무
- [Spring] 스프링 MVC 2편 - 백엔드 웹 개발 활용 기술
  - Chapter6) 로그인 처리1 - 쿠키, 세션 (0% -> 100%)
  - Chapter7) 로그인 처리2 - 필터, 인터셉터 (0% -> 100%)
  - Chapter8) 예외 처리와 오류 페이지 (0% -> 100%)

</details>

<details> <summary> 2022년 2월 16일 </summary>

## 회사 업무
- qa4환경구축
  - API
    - 오류 모니터링
    - 오더 생성 테스트
    - DB 마이그레이션 작업

## 개인 업무
- [Spring] 스프링 MVC 2편 - 백엔드 웹 개발 활용 기술
  - Chapter9) API 예외 처리 (0% -> 100%)
  - Chapter10) 스프링 타입 컨버터 (0% -> 100%)
  - Chapter11) 파일 업로드 (0% -> 100%)

</details>

<details> <summary> 2022년 2월 17일 </summary>

## 회사 업무
- qa4환경구축
  - API
    - 오더 생성 테스트
    - kinesis권한 요청
    - redis read timeout 원인 분석

## 개인 업무

</details>

<details> <summary> 2022년 2월 18일 </summary>

## 회사 업무
- qa4 환경 구축
  - api
    - 오더 생성 테스트
    - redis read timeout 원인 분석
- Workshop

## 개인 업무

</details>

<details> <summary> 2022년 2월 19일 </summary>

## 회사 업무

## 개인 업무
- [PS] python
  - 이진탐색 3문제

</details>

<details> <summary> 2022년 2월 20일 </summary>

## 회사 업무

## 개인 공부
- CTO's Tech Talk 2022 컨퍼런스
  - 0% -> 100%

</details>

<details> <summary> 2022년 2월 21일 </summary>

## 회사 업무
- qa4 환경 구축
  - api
    - 오더 생성 테스트 중 redis read timeout 에러 분석
    - 오더 생성 테스트 중 mcash server에러 분석

## 개인 공부
- [DDD] 도메인 주도 설계란 무엇인가? 
  - Chapter1) 도메인 주도 설계란 무엇인가? (0% -> 100%)

</details>

<details> <summary> 2022년 2월 22일 </summary>

## 회사 업무
- qa4 환경 구축
  - CreateOrder ~ DeliveryOrder 테스트
  - 생성, 조회 테스트
    - 오더, 지점, 기사 
  - 수정, 삭제 테스트 
    - 지점, 기사
    - prime API host가 잘못되었음을 발견 및 변경
  - NICE API 테스트 (산재보험 가입)
  - SK, KT 안심번호 발급 테스트
  - 위키 정리

## 개인 공부
- [DDD] 도메인 주도 설계란 무엇인가? 
  - Chapter2) 유비쿼터스 언어 (0% -> 100%)

</details>

<details> <summary> 2022년 2월 23일 </summary>

## 회사 업무
- qa4 환경 구축
  - 자동 배차 테스트
  - 위키 정리
- 라스트마일 개발톡 참여

## 개인 공부
- [DDD] 도메인 주도 설계란 무엇인가? 
  - Chapter3) 모델 주도 설계 (0% -> 30%)

</details>


<details> <summary> 2022년 2월 24일 </summary>

## 회사 업무
- qa4 환경 구축
  - 위키 정리
- 코드 리뷰 
  - ITSMCHG-6423 곧도착 이벤트 추가

## 개인 공부
- [DDD] 도메인 주도 설계란 무엇인가? 
  - Chapter3) 모델 주도 설계 (30% -> 70%)

</details>


<details> <summary> 2022년 2월 25일 </summary>

## 회사 업무
- 부릉 로지스틱스 오더 상태 이벤트 비동기 전달
  - 진행했던 코드 및 스펙 리마인드
- 코드 리뷰 
  - ITSMCHG-6652 도심물류 기사 암호 재설정 API 구현
  - ITSMCHG-6576 접속기록 30일이상 없는 기사 휴직으로 변경시 날짜 업데이트 누락

## 개인 공부
- [개인플젝] order-and-gift-project
  - Order 프로젝트 
    - Webflux전용 Jwt 토큰 기반 로그인 기능 추가를 위한 조사 

</details>

<details> <summary> 2022년 2월 26일 </summary>

## 회사 업무

## 개인 공부
- [DDD] 도메인 주도 설계란 무엇인가? 
  - Chapter3) 모델 주도 설계 (70% -> 100%)
- [개인플젝] order-and-gift-project
  - Order 프로젝트 
    - Webflux전용 Jwt 토큰 기반 로그인 기능 추가를 위한 조사 


</details>

<details> <summary> 2022년 2월 27일 </summary>

## 회사 업무

## 개인 공부
- [개인플젝] order-and-gift-project
  - Order 프로젝트 
    - (Auth) jwt 토큰 기반 로그인 기능 추가

</details>

<details> <summary> 2022년 2월 28일 </summary>

## 회사 업무
- 부릉 로지스틱스 오더 상태 이벤트 비동기 전달
  - 진행했던 코드 및 스펙 리마인드
  - 각 오더 상태 이벤트마다 다른 스펙으로 카프카에 전송하는 코드 작성
- 1:1 미팅

## 개인 공부
- [개인플젝] order-and-gift-project
  - Gift 프로젝트 
    - (Auth) jwt 토큰 기반 로그인 기능 추가

</details>