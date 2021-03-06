
- [1. 모던 데이터 엔지니어링](#1-모던-데이터-엔지니어링)
  - [과거의 데이터 관리 방식](#과거의-데이터-관리-방식)
  - [다양해지는 데이터 형식](#다양해지는-데이터-형식)
  - [저렴해지는 컴퓨팅 파워](#저렴해지는-컴퓨팅-파워)
  - [현재 데이터를 운영하는 방식](#현재-데이터를-운영하는-방식)
  - [데이터 인프라 트랜드](#데이터-인프라-트랜드)
  - [데이터 아키텍쳐 분야를 크게 6가지로](#데이터-아키텍쳐-분야를-크게-6가지로)
  - [데이터 엔지니어링 도구들](#데이터-엔지니어링-도구들)



## 1. 모던 데이터 엔지니어링

### 과거의 데이터 관리 방식 
- ETL 
- E: 추출 Extract
- T: 스미카에 맞게 변환 Transform
- L: 디비에 저장 Load

### 다양해지는 데이터 형식 
- 데이터로 할 수 있는 일이 다양해지고 형태를 예측하기 불가능해지면서 스키마를 정의하기 힘들어 졌다.
  - 실시간성을 요구하는 기능들
  - 빨라지는 기능 추가
  - 실시간 로그
  - 비정형 데이터
  - 서드 파티 데이터 

### 저렴해지는 컴퓨팅 파워
- 최대한 많은 데이터를 미리 저장해두고 많은 양의 프로세싱을 할 수 있게 됐다.
- 컴퓨팅 파워에 대한 비용 최적화보다 비즈니스와 속도를 최적화하는 쪽이 이득이 크게 됐다.

### 현재 데이터를 운영하는 방식 
- ELT
- E: 데이터 추출 Extract
- L: 일단 저장 
- T: 쓰임새에 따라 변환 
- 예 
  - 데이터의 로그를 Spark나 FLink를 통해 어느정도 정리 후 저장 (E&L)
  - 어플리케이션 혹은 분석 툴에서 이용 가능하도록 변환 (T)
- 시스템의 복잡도에 따라 데이터 추출과 적재를 한번에 하기도 한다.

### 데이터 인프라 트랜드
- 클라우드 웨어하우스 - Snowflake, Google Big Query
- Hadoop -> Databricks, Presto 
- 실시간 빅데이터 처리 (Stream Processing)
- ETL -> ELT
- Dataflow 자동화 (Airflow)
- 데이터 분석 팀을 두기 보단 누구나 분석할 수 있도록
- 중앙화 되는 데이터 플랫폼 관리 (access control, data book)

### 데이터 아키텍쳐 분야를 크게 6가지로 
![image](https://user-images.githubusercontent.com/28394879/180475336-cae457dc-00cd-4c79-99dd-673621d891fd.png)
- 소스: 비즈니스와 운영 데이터 생성
- 수집 및 변환: 운영 시스템에서 데이터 추출 -> 추출된 데이터를 저장하고 스키마 관리 -> 데이터를 분석할 수 있도록 변환 
- 저장: 데이터를 쿼리와 처리 시스템이 쓸 수 있도록 저장, 비용과 확장성면으로 최적화
- 과거&예측: 데이터 분석을 위한 인사이트 만들기(Query), 저장된 데이터를 이용해 쿼리를 실행하고 필요시 분산처리(Processing), 과거에 무슨 일이 일어났는지 혹은 미래에 무슨일이 일어날지(ML)
- 출력: 데이터 분석을 내부와 외부 유저에게 제공, 데이터 모델을 운영 시스템에 적용

### 데이터 엔지니어링 도구들 
![image](https://user-images.githubusercontent.com/28394879/180475460-d56e1c21-3107-486e-afe3-50f16517e9a8.png)
- Sources, Storage, Query: 서비스 레벨 보다는 로우 레벨 문제들을 푸는 분야 
- Ingestion & Transformation, Processing: 일반적인 엔지니어링이 집중하는 분야

