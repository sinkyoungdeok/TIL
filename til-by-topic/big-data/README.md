
- [1. 모던 데이터 엔지니어링](#1-모던-데이터-엔지니어링)
  - [과거의 데이터 관리 방식](#과거의-데이터-관리-방식)
  - [다양해지는 데이터 형식](#다양해지는-데이터-형식)
  - [저렴해지는 컴퓨팅 파워](#저렴해지는-컴퓨팅-파워)
  - [현재 데이터를 운영하는 방식](#현재-데이터를-운영하는-방식)
  - [데이터 인프라 트랜드](#데이터-인프라-트랜드)
  - [데이터 아키텍쳐 분야를 크게 6가지로](#데이터-아키텍쳐-분야를-크게-6가지로)
  - [데이터 엔지니어링 도구들](#데이터-엔지니어링-도구들)
- [2. Batch & Stream Processing](#2-batch--stream-processing)
  - [배치 프로세싱 이란](#배치-프로세싱-이란)
  - [배치 프로세싱은 언제 써야될까](#배치-프로세싱은-언제-써야될까)
  - [스트림 프로세싱 이란](#스트림-프로세싱-이란)
  - [배치 vs 스트림 프로세싱](#배치-vs-스트림-프로세싱)
  - [스트림 프로세싱은 언제 써야될까](#스트림-프로세싱은-언제-써야될까)
  - [Batch vs Stream 플로우](#batch-vs-stream-플로우)
  - [마이크로 배치란](#마이크로-배치란)
- [3. Dataflow Orchestration](#3-dataflow-orchestration)
  - [Orchestration 이란](#orchestration-이란)
  - [오케스트레이션이 필요한 이유](#오케스트레이션이-필요한-이유)
  - [오케스트레이션 없이 문제가 생겼다면](#오케스트레이션-없이-문제가-생겼다면)
  - [오케스트레이션이 있을 때 문제가 생겼다면](#오케스트레이션이-있을-때-문제가-생겼다면)
  - [오케스트레이션의 예시](#오케스트레이션의-예시)
- [4. Apache Spark 환경 설정](#4-apache-spark-환경-설정)
  - [필요한 환경 & 패키지](#필요한-환경--패키지)
  - [아나콘다 설치](#아나콘다-설치)
  - [java 설치](#java-설치)
  - [scala 설치](#scala-설치)
  - [spark 설치](#spark-설치)
  - [pyspark 설치](#pyspark-설치)
  - [실습 파일 다운로드](#실습-파일-다운로드)
  - [모빌리티 데이터 다운로드](#모빌리티-데이터-다운로드)
- [5. spark](#5-spark)
  - [우버 트립수 세기](#우버-트립수-세기)
  - [hadoop의 특징](#hadoop의-특징)
  - [spark의 특징](#spark의-특징)
  - [spark Cluster](#spark-cluster)
  - [개인 컴퓨터에서는 spark가 느린 이유](#개인-컴퓨터에서는-spark가-느린-이유)
  - [spark의 핵심 데이터 모델 RDD](#spark의-핵심-데이터-모델-rdd)
  - [Pandas vs Spark](#pandas-vs-spark)
  - [Spark 버전별 특징](#spark-버전별-특징)
  - [Spark 구성](#spark-구성)





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

## 2. Batch & Stream Processing

### 배치 프로세싱 이란
- 배치(Batch) == 일괄
- 배치 프로세싱(Batch Processing) == 일괄처리
- 많은 양의 데이터를 정해진 시간에 한꺼번에 처리하는 것 
  1. 한정된 대량의 데이터
  2. 특정 시간
  3. 일괄 처리 
- 전통적으로 쓰이는 데이터 처리 방법 

### 배치 프로세싱은 언제 써야될까
- 실시간성을 보장하지 않아도 될 때
- 데이터를 한꺼번에 처리할 수 있을 때
- 무거운 처리를 할 때 ex) ML 학습  
- 예시  
  - 매일 다음 14일의 수요와 공급을 예측 
  - 매주 사이트에서 관심을 보인 유저들에게 마케팅 이메일 전송
  - 매주 발행하는 뉴스레터
  - 매주 새로운 데이터로 머신러닝 알고리즘 학습
  - 매일 아침 웹 스크래핑/크롤링
  - 매달 월급 지급 

### 스트림 프로세싱 이란 
- 실시간으로 쏟아지는 데이터를 계속 처리하는 것 
- 이벤트가 생길 때 마다, 데이터가 들어올 때 마다 처리 
- 뷸규칙적으로 데이터가 들어오는 환경일 때 
- 여러개의 이벤트가 한꺼번에 들어올 때
- 오랜 시간 동안 이벤트가 하나도 들어오지 않을 떄 

### 배치 vs 스트림 프로세싱 
불규칙적으로 데이터가 들어올 떄를 가정 
- 배치 프로세싱
  - 배치당 처리하는 데이터 수가 달라지면서 리소스를 비효율적으로 사용하게 된다.
- 스트림 프로세싱
  - 데이터가 생성되어 요청이 들어로 때 마다 처리할 수 있다.

### 스트림 프로세싱은 언제 써야될까 
- 실시간성을 보장해야 될 때 
- 데이터가 여러 소스로부터 들어올 때
- 데이터가 가끔 들어오거나 지속적으로 들어올 때 
- 가벼운 처리를 할 때 (Rule-based)
- 예시
  - 사기 거래 탐지 (Fraud Detection)
  - 이상 탐지 (Anomaly Detection)
  - 실시간 알림
  - 비즈니스 모니터링
  - 실시간 수요/공급 측정 및 가격 책정
  - 실시간 기능이 들어가는 애플리케이션 


### Batch vs Stream 플로우
- 일반적인 배치 플로우 
  1. 데이터를 모아서
  2. 데이터베이스에서 읽어서 처리
  3. 다시 데이터베이스에 담기 
- 일반적인 스트림 처리 플로우
  1. 데이터가 들어올 때 마다(ingest)
  2. 쿼리/처리 후 State를 업데이트
  3. DB에 담기 

### 마이크로 배치란 
- 데이터를 조금씩 모아서 프로세싱하는 방식
- Batch 프로세싱을 잘게 쪼개서 스트리밍을 흉내내는 방식 


## 3. Dataflow Orchestration

### Orchestration 이란 
1. 테스크 스케줄링
2. 분산 실행
3. 테스크간 의존성 관리 

### 오케스트레이션이 필요한 이유 
1. 서비스가 커지면서 데이터 플랫폼의 복잡도가 커짐
2. 데이터가 사용자와 직접 연관되는 경우가 늘어남 (워크플로우가 망가지면 서비스도 망가짐)
3. 테스크 하나하나가 중요해짐
4. 테스크간 의존성도 생김 

### 오케스트레이션 없이 문제가 생겼다면
<img width="423" alt="image" src="https://user-images.githubusercontent.com/28394879/180633490-1c0e6e38-d757-4944-8c13-243aa9a64c08.png">
A: 3시까지 Task 4 결과가 나와야 하는데 아직 못받았어요.
A: Task 4를 보니 아직 전 작업을 기다리는 것 같은데, Task 2,3는 누가 만들었나요?
A: 코드가 어딨는지 모르겠네요
B: 다른 팀에서 만든 것 같은데 한번 보겠습니다.
B: Task2 다시 돌리니까 되네요..?
A & B: ???

### 오케스트레이션이 있을 때 문제가 생겼다면 
<img width="423" alt="image" src="https://user-images.githubusercontent.com/28394879/180633490-1c0e6e38-d757-4944-8c13-243aa9a64c08.png">
1. Task 2 에러 후 로그 남기고 알림
2. 실패 시나리오에 따라 Task 2 다시 실행 후 성공
3. Task 4 실행
4. 성공 

### 오케스트레이션의 예시 
- Apache Airflow

<img width="570" alt="image" src="https://user-images.githubusercontent.com/28394879/180633651-bd9cbf63-f3a3-4611-b37c-7a65f6a98aef.png">

## 4. Apache Spark 환경 설정

### 필요한 환경 & 패키지 
1. python
2. 주피터 노트북 
3. java
4. spark
5. pyspark

### 아나콘다 설치 
- https://www.anaconda.com/products/distribution
- 아나콘다 설치하면 python과 python의 기본 패키지들은 자동으로 설치되고, python과 주피터 노트북을 동시에 쉽게 설치가 가능하다. 

### java 설치 
```
brew install --cask adoptopenjdk8
```

### scala 설치 
```
brew install scala
```

### spark 설치 
```
brew install apache-spark
```

### pyspark 설치 
```
pip --version # 경로가 anaconda 인것을 확인
pip install pyspark

pyspark # spark 터미널이 뜨는지 확인
```

### 실습 파일 다운로드 
```
git clone https://github.com/keon/data-engineering.git
```

### 모빌리티 데이터 다운로드 
- https://www1.nyc.gov/site/tlc/about/tlc-trip-record-data.page
- 2020 March - High Volume For-Hire Vehicle Trip Records 다운로드 
- clone 한 리포에 넣기 
  - data-engineering/01-spark/data/fhvhv_tripdata_2020-03.parquet

| 필드 이름 | 설명 |
| --- | --- |
| hvfhs_license_num | 회사 면허 번호 |
| dispatching_base_num | 지역 라이센스 번호 |
| pickup_datetime | 승차 시간 |
| dropoff_datetime | 하차 시간 |
| PULocationID | 승차 지역 ID |
| DOLocationID | 하차 지역 ID |
| SR_Flag | 합승 여부 Flag | 


## 5. spark

### 우버 트립수 세기
```
spark-submit count_trips.py # 트립 수 세기 

python3 visualiza_trips_date.py # 차트로 그리기 
``` 

### hadoop의 특징 
- HDFS 파일 시스템
- Yarn 리소스 관리 
- Map Reduce 연산 엔진 -> Spark가 이것을 대체한다.

### spark의 특징 
- 빠르다 = 빅데이터의 In-Memory 연산 
- 노드는 필요에 따라 계속 늘릴 수 있다. 
- 수평적 확장이 가능하다. 
- Hadoop MapReduce 보다 빠르다
  - 메모리 상에선 100배
  - 디스크 상에선 10배 
- Lazy Evaluation 
  - 태스크를 정의할 때는 연산을 하지 않다가 결과가 필요할 때 연산한다.
  - 기다리면서 연산 과정을 최적화 할 수 있다. 

### spark Cluster
- Driver Program, Cluster Manager, Worker Node 로 이루어져 있다.
- Driver Program: 우리가 사용하는 컴퓨터, python | java | scala 와 같은 script로 task을 정의한다.
- Cluster Manager: 정의된 task 즉 일거리를 분배 한다. 
  - hadoop에서는 yarn cluster manager을 사용할 수 있다.
  - aws에서는 elastic mapreduce manager을 사용할 수 있다. 
- Worker Node
  - 1CPU코어 당 1Node 배치 
  - 인메모리 연산을 진행한다.

### 개인 컴퓨터에서는 spark가 느린 이유 
- spark는 확장성을 고려해서 설계 했기 때문 

### spark의 핵심 데이터 모델 RDD 
- Resilient Distributed Dataset (RDD)
- 여러 분산 노드에 걸쳐서 저장
- 변경이 불가능
- 여러개의 파티션으로 분리 

### Pandas vs Spark
| Pandas | Spark |
| --- | --- |
| 1개의 노드 | 여러개의 노드 |
| Eager Execution - 코드가 바로 실행 | Lazy Execution - 실행이 필요할 때 까지 기다림 |
| 컴퓨터 하드웨어에 제한을 받음 | 수평적 확장이 가능 |
| In-Memory 연산 | In-Memory 연산 |
| Mutable Data | Immutable Data |


### Spark 버전별 특징 
- Spark 1.0 
  - 2014 년 정식 발표 
  - RDD를 이용한 인메모리 처리 방식
  - DataFrame (V1.3)
  - Project Tungsten - 엔진 업그레이드로 메모리와 CPU 효율 회적화 
- Spark 2.0
  - 2016 년 발표 
  - 단순화 되고 성능 개선
  - Structed Streaming
  - Dataset 이라는 DataFrame의 확장형 자료구조 등장
  -  Catalyst Optimizer 프로젝트 - 언어에 상관없이 동일한 성능을 보장 - Scala, Java, Python, R 
- Spark 3.0
  - 2020 년 발표 
  - Mlib 기능 추가
  - Spark SQL 기능 추가
  - Spark 2.4보다 약 2배 빨라짐 - Adaptive execution, Dynamic partition pruning
  - PySpark 사용성 개선
  - 딥러닝 지원 강화 - GPU노드 지원, 머신러닝 프레임워크와 연계 가능
  - GraphX - 분산 그래프 연산
  - Python2 지원이 끊김
  - 쿠버네티스 지원 강화 
- 새 기능이 추가되고 성능이 좋아지고 있지만, 근본은 바뀌지 않는다.

### Spark 구성 
- Spark Core
- Spark SQL
- Spark Streaming
- MLlib
- GraphX