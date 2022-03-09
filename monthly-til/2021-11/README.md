# 11월 요약
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter1 ~ END
- [AWS] aws-class-youtube
  - Chapter4 ~ END
- [AWS] aws-생활코딩
  - route53 
- [ELK] ELK 스택으로 데이터 분석
  - Chapter1 ~ END
- [개인 플젝] 맛집 소개 사이트
  - 전국 시, 동, 구 데이터 저장 하는 API 제작
  - Django, Mysql 세팅
- 회사 업무(메쉬코리아) - 온보딩 진행 중
  - 라스트마일 코드 분석
  - B마트 접수 오더가 n건이상 발생시 슬랙알림
    - PR 피드백 반영
    - DBA 쿼리 피드백 검토 및 반영
    - dev1 배포
    - 테스트 코드 작성
    - 요구 사항 변경에 대한 코드 수정 
  - enforceAssignmentConfirm API가 Optimistic Locking 에러 시 null 응답이 전달 되지 않도록 수정
    - 코드 분석
  - JpaSystemException은 sentry 알림이 뜨지 않도록 제외 한다
    - 코드 작성, PR 작성
  - 로컬 환경에서 sentry가 동작 하지 않도록 구성
    - 코드 작성, PR 작성 
  - 지점오더필터링 필터 갯수 상향조정
    - 코드 작성, PR 작성
  - 상용 배포 준비, 상용 배포
  - 코드리뷰
    - [ITSMCHG-5572] OptimisticLocking 예외 발생 시 재시도 애노테이션 추가
    - [ITSMCHG-5793] Mcash 조정정책 재시도 로직 수정
    - [ITSMCHG-5583] 픽업요청시간이 없는 오더 예외처리
    - [ITSMCHG-5711] 불필요한 mcash pubnub event 삭제
  - [기사앱] 기사는 배송이 완료된 이후, 배송 메시지를 확인할 수 없다.
    - 배송 메시지 관련 조사
    - 해당 사항 위키 정리



<details> <summary>2021년 11월 1일</summary>

## 회사 업무
- B마트 접수 오더가 n건이상 발생시 슬랙알림
  - 코드 리뷰 반영
- 에러 리뷰 미팅

## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter1 (0% -> 25%)

</details>

<details> <summary>2021년 11월 2일</summary>

## 회사 업무
- B마트 접수 오더가 n건이상 발생시 슬랙알림
  - DBA 쿼리 피드백 검토 및 반영 
  - PR 피드백 반영
  - dev1 배포
- enforceAssignmentConfirm 이 null 응답이 전달되지 않도록 수정 
  - 검토

## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter1 (25% -> 50%)

</details>



<details> <summary>2021년 11월 3일</summary>

## 회사 업무
- B마트 접수 오더가 n건이상 발생시 슬랙알림
  - 테스트코드 작성
- enforceAssignmentConfirm 이 null 응답이 전달되지 않도록 수정 
  - 검토

## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter1 (50% -> 75%)

</details>

<details> <summary>2021년 11월 4일</summary>

## 회사 업무
- B마트 접수 오더가 n건이상 발생시 슬랙알림
  - 스케줄러 코드 재작성
  - 오더 건수 조회 querydsl 재작성
  - PR피드백 반영
- 라스트마일 개발 TALK

## 개인 공부


</details>

<details> <summary>2021년 11월 5일</summary>

## 회사 업무
- B마트 접수 오더가 n건이상 발생시 슬랙알림
  - 테스트 코드 재작성
  - dev1 배포

## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter1 (75% -> 100%)
  - Chapter2 (0% -> 50%)


</details>

<details> <summary>2021년 11월 6일</summary>

## 회사 업무

## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter2 (50% -> 100%)
  - Chapter3 (0% -> 50%)


</details>

<details> <summary>2021년 11월 7일</summary>

## 회사 업무

## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter3 (50% -> 60%)


</details>

<details> <summary>2021년 11월 8일</summary>

## 회사 업무
- sentry disable in local
  - 코드 작성
  - PR 작성
  - develop 머지
- enforcedAssignmentConfirm API의 OptimisticLocking 에러 응답 수정
  - 코드 분석
 


## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter3 (60% -> 100%)


</details>

<details> <summary>2021년 11월 9일</summary>

## 회사 업무
- enforcedAssignmentConfirm API의 OptimisticLocking 에러 응답을 수정합니다
  - 코드 분석
- B마트 접수오더가 n건이상 발생시 슬랙알림
  - PR피드백 반영
 


## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter4 (0% -> 15%)


</details>

<details> <summary>2021년 11월 10일</summary>

## 회사 업무
- enforcedAssignmentConfirm API의 OptimisticLocking 에러 응답을 수정합니다
  - 코드 분석
- [AWS] aws-class-youtube 
  - Chapter 6 (0% -> 70%)
 


## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter4 (15% -> 90%)


</details>

<details> <summary>2021년 11월 11일</summary>

## 회사 업무
- enforcedAssignmentConfirm API의 OptimisticLocking 에러 응답을 수정합니다
  - 코드 분석
- [AWS] aws-class-youtube 
  - Chapter 6 (70% -> 100%)
  - Chapter 7 (0% -> 100%)
  - Chapter 8 (0% -> 30%)
 


## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter4 (90% -> 100%)
  - Chapter5 (0% -> 100%)


</details>

<details> <summary>2021년 11월 12일</summary>

## 회사 업무
- [AWS] aws-class-youtube 
  - Chapter 8 (30% -> 100%)
  - Chapter 9 (0% -> 100%)
  - Chapter 10 (0% -> 100%)
 


## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter6 (0% -> 100%)


</details>

<details> <summary>2021년 11월 13일</summary>

## 회사 업무


## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter7 (0% -> 33%)


</details>

<details> <summary>2021년 11월 14일</summary>

## 회사 업무


## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter7 (33% -> 100%)
  - Chapter8 (0% -> 100%)
  - Chapter9 (0% -> 60%)


</details>

<details> <summary>2021년 11월 15일</summary>

## 회사 업무
- 주간 weekly 미팅 참여
- 온보딩 체크리스트
  - 전체적으로 검토

## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter9 (60% -> 100%)
  - Chapter10 (0% -> 50%)

</details>

<details> <summary>2021년 11월 16일</summary>

## 회사 업무
- [AWS] aws-class-youtube 
  - Chapter11 (0% -> 100%)
  - Chapter12 (0% -> 100%)

## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter10 (50% -> 100%)
  - Chapter11 (0% -> 25%)

</details>

<details> <summary>2021년 11월 17일</summary>

## 회사 업무
- [AWS] aws-class-youtube 
  - Chapter13 (0% -> 100%)
  - Chapter14 (0% -> 100%)
- 지점오더필터링 필터 갯수 상향조정
  - 코드 작성
  - PR 작성


## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter11 (0% -> 100%)

</details>

<details> <summary>2021년 11월 18일</summary>

## 회사 업무
- aws-생활코딩
  - route53
- 코드리뷰
  - [ITSMCHG-5572] OptimisticLocking 예외 발생 시 재시도 애노테이션 추가
- 라스트마일 개발 TALK 참여

## 개인 공부
- [Spring] 스프링 핵심 원리 - 고급편
  - Chapter12 (0% -> 100%)
  - Chapter13 (0% -> 100%)

</details>

<details> <summary>2021년 11월 19일</summary>

## 회사 업무
- kafka-데브원영
  - 토픽
  - 브로커, 복제, ISR
  - 파티셔너
  - 컨슈머 랙
  - 카프카 버로우
- 메쉬 톡데이 참여
- 코드리뷰
  - [ITSMCHG-5572] OptimisticLocking 예외 발생 시 재시도 애노테이션 추가

## 개인 공부
- [ELK] ELK 스택으로 데이터 분석
  - Chapter1 (0% -> 100%)

</details>

<details> <summary>2021년 11월 20일</summary>

## 회사 업무

## 개인 공부
- [ELK] ELK 스택으로 데이터 분석
  - Chapter2 (0% -> 25%)

</details>

<details> <summary>2021년 11월 21일</summary>

## 회사 업무

## 개인 공부
- [ELK] ELK 스택으로 데이터 분석
  - Chapter2 (25% -> 30%)

</details>

<details> <summary>2021년 11월 22일</summary>

## 회사 업무
- [기사앱] 기사는 배송이 완료된 이후, 배송 메시지를 확인할 수 없다.
  - 배송 메시지 관련 조사
  - 해당 사항 위키 정리

## 개인 공부
- 여태까지 진행한 공모전 정리

</details>

<details> <summary>2021년 11월 23일</summary>

## 회사 업무
- [AWS] aws-생활코딩
  - route53
- 온보딩 체크리스트
  - 빌드/배포 내용들 검토
- 코드리뷰
  - [ITSMCHG-5583] 픽업요청시간이 없는 오더 예외처리
- 상용배포 준비

## 개인 공부

</details>

<details> <summary>2021년 11월 24일</summary>

## 회사 업무
- 상용배포
- "New Relic Webinar" 참석
- "New Relic 교육" 참석
- 온보딩 체크리스트
  - 스프링 내용들 검토

## 개인 공부

</details>

<details> <summary>2021년 11월 25일</summary>

## 회사 업무
- "프라임 데이터베이스 이대로 괜찮은가?" 미팅 참석
- 온보딩 체크리스트
  - 스프링 내용들 검토
- 코드 리뷰
  - ITSMCHG-5734 mcash, cron 에서도 setnry report 하도록 개선

## 개인 공부
- [ELK] ELK 스택으로 데이터 분석
  - Chapter2 (30% -> 75%)


</details>

<details> <summary>2021년 11월 26일</summary>

## 회사 업무
- 온보딩 체크리스트
  - KafKa 내용 검토
  - JPA 내용 검토
- 코드리뷰
  - [ITSMCHG-5711] 불필요한 mcash pubnub event 삭제

## 개인 공부
- [ELK] ELK 스택으로 데이터 분석
  - Chapter2 (75% -> 100%)
  - Chapter3 (0% -> 50%)


</details>

<details> <summary>2021년 11월 27일</summary>

## 회사 업무

## 개인 공부
- [ELK] ELK 스택으로 데이터 분석
  - Chapter3 (50% -> 100%)
  - Chapter4 (0% -> 100%)
  - Chapter5 (0% -> 100%)


</details>

<details> <summary>2021년 11월 28일</summary>

## 회사 업무

## 개인 공부
- [ELK] ELK 스택으로 데이터 분석
  - Chapter6 (0% -> 100%)


</details>

<details> <summary>2021년 11월 29일</summary>

## 회사 업무
- JpaSystemException은 sentry 알림이 뜨지 않도록 제외한다.
  - 코드 작성
  - PR 작성
- 코드 리뷰
  - [ITSMCHG-5793] Mcash 조정정책 재시도 로직 수정
- 위클리 미팅 참여
- 에러관리 리뷰 참여
## 개인 공부
- [개인 플젝] 맛집 소개 사이트
  - 장고 세팅
  - mysql 세팅 
  - orm 세팅
  - 우리나라 "시", "구" 정보 데이터 저장하는 API 추가
 
</details>

<details> <summary>2021년 11월 30일</summary>

## 회사 업무
- enforcedAssignmentConfirm API의 OptimisticLocking 에러 응답을 수정합니다
  - 에러 상황 재현
  - 코드 작성
  - PR 작성
- 코드 리뷰
  - [ITSMCHG-5793] Mcash 조정정책 재시도 로직 수정
- 요금제 동기화 리뷰 미팅


## 개인 공부
- [개인 플젝] 맛집 소개 사이트
  - 우리나라 "동" 정보 데이터 저장하는 API 추가
  - "구"가 없는 세종특별자치시 전용 "동" 모델 추가 및 저장하는 API 추가
 
</details>