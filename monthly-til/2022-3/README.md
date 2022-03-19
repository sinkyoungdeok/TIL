

<details> <summary> 2022년 3월 1일 </summary>

## 회사 업무

## 개인 공부
- [개인플젝] order-and-gift-project
  - Order, Gift 프로젝트 
    - (User) 유저 도메인 정의
    - (User) 유저 생성 API 완성 
    - (User) 내정보 조회 API 완성
    - (User) 회원 탈퇴 API 완성
    - (User) 회원 재가입 API 완성 
- [DDD] 도메인 주도 설계란 무엇인가?
  - Chapter1) 도메인 주도 설계 복습 및 정리 (0% -> 100%)

</details>

<details> <summary> 2022년 3월 2일 </summary>

## 회사 업무
- 부릉 로지스틱스 오더 상태 이벤트 비동기 전달
  - 각 오더 상태 이벤트마다 다른 스펙으로 카프카에 전송하는 코드 작성
- 코드리뷰
  - ITSMCHG-6678 비마트 기사위치 알람 제거
  - ITSMCHG-6656 기사 출근시 고용보험 체크를 위한 앱버전 체크로직 제거
  - ITSMCHG-5889 배민1 callback agentlocation
- 메쉬톡데이
- DDD 스터디) 도메인 주도 설계란 무엇인가? - Chapter1

## 개인 공부
- [개인플젝] order-and-gift-project
  - Order, Gift 프로젝트 
    - (User) DB에 저장된 User를 활용하도록 리팩토링

</details>

<details> <summary> 2022년 3월 3일 </summary>

## 회사 업무
- 부릉 로지스틱스 오더 상태 이벤트 비동기 전달
  - 각 오더 상태 이벤트마다 다른 스펙으로 카프카에 전송하는 코드 작성
  - PR작성
  - local 테스트
  - dev1배포 및 테스트
- 코드리뷰
  - ITSMCHG-6716 기사 삭제 시 employmentStatus 업데이트

## 개인 공부
- [개인플젝] order-and-gift-project
  - Order, Gift 프로젝트 
    - (Admin) 어드민 생성 API
- [PS] python
  - dp 1문제 풀이

</details>

<details> <summary> 2022년 3월 4일 </summary>

## 회사 업무
- 부릉 로지스틱스 오더 상태 이벤트 비동기 전달
  - 테스트코드 작성
  - PR리뷰 반영

## 개인 공부
- [개인플젝] order-and-gift-project
  - Order, Gift 프로젝트 
    - (User, Admin) 유저, 어드민 생성시 혹은 조회시 검증한다. 

</details>

<details> <summary> 2022년 3월 5일 </summary>

## 회사 업무

## 개인 공부
- [개인플젝] order-and-gift-project
  - Order, Gift 프로젝트 
    - (User, Admin) 어드민용 다른 유저 정보 조회 API
    - (User, Admin) 어드민용 다른 유저 정보 삭제 API
    - (User, Admin) 어드민용 다른 유저 재가입 API

</details>

<details> <summary> 2022년 3월 6일 </summary>

## 회사 업무

## 개인 공부
- [개인플젝] order-and-gift-project
  - Order, Gift 프로젝트 
    - (Partner) Partner API에서 Auth활용 및 User 도메인과 연동

</details>

<details> <summary> 2022년 3월 7일 </summary>

## 회사 업무
- 부릉 로지스틱스 오더 상태 이벤트 비동기 전달
  - PR피드백 반영
- 위클리 미팅
- 코드리뷰
  - [ITSMCHG-6750] createorder refactoring

## 개인 공부

</details>

<details> <summary> 2022년 3월 8일 </summary>

## 회사 업무
- 부릉 로지스틱스 오더 상태 이벤트 비동기 전달
  - PR피드백 반영
  - dev1배포 및 테스트
- 코드리뷰
  - ITSMCHG-6722 고용보험 이력 업데이트 일자 버그 픽스
  - [ITSMCHG-6750] createorder refactoring
  - [ITSMCHG-6675] 도착지 변경 시 클라이언트에서 ClaimCode 를 선택할 수 있도록 수정

## 개인 공부
- [팀 프로젝트] CherryPick
  - JWT 설정
  - mysql DB 도커 세팅

</details>

<details> <summary> 2022년 3월 9일 </summary>

## 회사 업무

## 개인 공부
- [팀 프로젝트] CherryPick
  - (Auth) Login API 리팩토링
- [DDD] 도메인 지식 탐구를 위한 이벤트 스토밍
  - 강의 보고나서 정리
- [PS] python
  - greedy 1문제 풀이

</details>

<details> <summary> 2022년 3월 10일 </summary>

## 회사 업무
- "라스트마일 온보딩 - 라스트마일 소개" 미팅 참여
- 부릉 로지스틱스 오더 상태 이벤트 비동기 전달
  - PR피드백 반영 
- createOrder ~ cancelOrder 위키 재정리
- 코드리뷰
  -  ITSMCHG-6518-allow-without-uaa-token

## 개인 공부
- [DDD] 도메인 주도 설계란 무엇인가?
  - Chapter2) 2. 유비쿼터스 언어 (0% -> 100%)

</details>

<details> <summary> 2022년 3월 11일 </summary>

## 회사 업무
- createOrder~cancelOrder 위키 재정리
- 태우님 온보딩 
  - createOrder ~ cancelOrder 테스트
- DDD스터디 참여

## 개인 공부
- [개인플젝] order-and-gift-project
  - Order, Gift 프로젝트  
    - (Auth) 유효기간이 만료된 jwt토큰으로 전달된 경우 500에러가 아닌 401에러를 반환한다. - 조사

</details>

<details> <summary> 2022년 3월 12일 </summary>

## 회사 업무

## 개인 공부
- [Kotlin] 새차원의 코틀린 
  - 전체 복습

</details>

<details> <summary> 2022년 3월 13일 </summary>

## 회사 업무

## 개인 공부
- [팀 프로젝트] CherryPick
  - API 설계 회의 - 화면에서 필요한 데이터 협의, json 데이터 형식 협의 (백엔드 + 프론트엔드)

</details>

<details> <summary> 2022년 3월 14일 </summary>

## 회사 업무

## 개인 공부
- [DDD] 도메인 주도 설계란 무엇인가?
  - Chapter3) 3. 모델 주도 설계 복습 (0% -> 20%)

</details>

<details> <summary> 2022년 3월 15일 </summary>

## 회사 업무

## 개인 공부
- [PS] python
  - 구현문제 5문제 풀이

</details>

<details> <summary> 2022년 3월 16일 </summary>

## 회사 업무
- 부릉 로지스틱스 오더 상태 이벤트 비동기 전달
  - PR피드백 반영
- DDD스터디 - 용어집 만들어보기 참여

## 개인 공부

</details>

<details> <summary> 2022년 3월 17일 </summary>

## 회사 업무
- 태우님 createOrder ~ deliverOrder 온보딩 help
- 라스트마일 한방 회의

## 개인 공부

</details>

<details> <summary> 2022년 3월 18일 </summary>

## 회사 업무
- 코드리뷰
  - ITSMCHG-5875 cancelOrder OptimisticLock에러 발생시 응답 변경
  - ITSMCHG-6832 기사 강제 퇴근 API
  - ITSMCHG-5877 선불 오더를 기사의 미납금액 및 M캐시 잔액에 상관없이 기사가 직접 잡을 수 있게 한다.
  - ITSMCHG-6713 오더 할증 내역 조회

## 개인 공부

</details>

<details> <summary> 2022년 3월 19일 </summary>

## 회사 업무

## 개인 공부
- [팀 프로젝트] CherryPick
  - API 설계 회의 - uri, method 회의 (백엔드 + 프론트엔드)

</details>