
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
- [5. spark 기본](#5-spark-기본)
  - [hadoop의 특징](#hadoop의-특징)
  - [spark의 특징](#spark의-특징)
  - [spark Cluster](#spark-cluster)
  - [개인 컴퓨터에서는 spark가 느린 이유](#개인-컴퓨터에서는-spark가-느린-이유)
  - [spark의 핵심 데이터 모델 RDD](#spark의-핵심-데이터-모델-rdd)
  - [Pandas vs Spark](#pandas-vs-spark)
  - [Spark 버전별 특징](#spark-버전별-특징)
  - [Spark 구성](#spark-구성)
  - [RDD란](#rdd란)
  - [RDD 특징 - 1. 데이터 추상화](#rdd-특징---1-데이터-추상화)
  - [RDD 특징 - 2. 탄력적 & 불변](#rdd-특징---2-탄력적--불변)
  - [RDD 특징 - 3. Type-safe](#rdd-특징---3-type-safe)
  - [RDD 특징 - 4. Unstructured / Structured Data](#rdd-특징---4-unstructured--structured-data)
  - [RDD 특징 - 5. Lazy](#rdd-특징---5-lazy)
  - [Spark Operation](#spark-operation)
  - [RDD를 쓰는 이유](#rdd를-쓰는-이유)
  - [우버 트립수 세기](#우버-트립수-세기)
- [6. 병럴처리와 분산처리](#6-병럴처리와-분산처리)
  - [일반 병렬처리](#일반-병렬처리)
  - [분산된 환경에서의 병렬처리](#분산된-환경에서의-병렬처리)
  - [분산처리 문제](#분산처리-문제)
- [7. RDD](#7-rdd)
  - [Key-Value RDD 이란](#key-value-rdd-이란)
  - [Single-Value RDD vs Key-Value RDD](#single-value-rdd-vs-key-value-rdd)
  - [Key-Value RDD 개념](#key-value-rdd-개념)
  - [Key-Value RDD - Reduction](#key-value-rdd---reduction)
  - [Key-Value RDD - Join](#key-value-rdd---join)
  - [Key-Value RDD - Mapping values](#key-value-rdd---mapping-values)
  - [Key-Value RDD - 예시](#key-value-rdd---예시)
  - [RDD Transformations vs Actions](#rdd-transformations-vs-actions)
  - [Transformations](#transformations)
  - [Narrow Transformations](#narrow-transformations)
  - [Wide Transformations](#wide-transformations)
  - [Lazy 연산의 장점](#lazy-연산의-장점)
  - [Storage Level](#storage-level)
  - [Cache & Persist](#cache--persist)
  - [Master Worker Topology](#master-worker-topology)
  - [Spark 동작 과정](#spark-동작-과정)
  - [Reduction Operations](#reduction-operations)
  - [Parallel Reduction](#parallel-reduction)
  - [Reduction Actions](#reduction-actions)
  - [Reduce](#reduce)
  - [Partition](#partition)
  - [Fold](#fold)
  - [Fold & Partition](#fold--partition)
  - [GroupBy](#groupby)
  - [Aggregate](#aggregate)
  - [Key-Value RDD Transformations & Actions](#key-value-rdd-transformations--actions)
  - [Key-Value RDD - GroupByKey](#key-value-rdd---groupbykey)
  - [Key-Value RDD - ReduceByKey](#key-value-rdd---reducebykey)
  - [Key-Value RDD - mapValues](#key-value-rdd---mapvalues)
  - [Key-Value RDD - countByKey](#key-value-rdd---countbykey)
  - [Key-Value RDD - keys()](#key-value-rdd---keys)
  - [Key-Value RDD - Joins](#key-value-rdd---joins)
  - [Shuffling](#shuffling)
  - [Partitioner를 이용한 성능 최적화 (Shuffle 최소화)](#partitioner를-이용한-성능-최적화-shuffle-최소화)
  - [Partition의 목적](#partition의-목적)
  - [Partition 특징](#partition-특징)
  - [Partition의 종류](#partition의-종류)
  - [Hash Partitioning](#hash-partitioning)
  - [Range Partitioning](#range-partitioning)
  - [Memory & Disk Partition](#memory--disk-partition)
  - [Disk Partition](#disk-partition)
  - [Repartition & Coalesce](#repartition--coalesce)
  - [연산 중에 파티션을 만드는 작업들](#연산-중에-파티션을-만드는-작업들)
  - [map vs mapValues](#map-vs-mapvalues)
- [8. Spark SQL](#8-spark-sql)
  - [Structured Data vs Unstructured Data](#structured-data-vs-unstructured-data)
  - [Structured Data vs RDDs](#structured-data-vs-rdds)
  - [Spark SQL](#spark-sql)
  - [Spark SQL의 목적](#spark-sql의-목적)
  - [Spark SQL 소개](#spark-sql-소개)
  - [DataFrame](#dataframe)
  - [SparkSession](#sparksession)
  - [DataFrame 만드는 법](#dataframe-만드는-법)
  - [RDD로부터 DataFrame 만들기](#rdd로부터-dataframe-만들기)
  - [파일로부터 DataFrame 만들기](#파일로부터-dataframe-만들기)
  - [DataFrame을 데이터베이스 테이블처럼 사용하기](#dataframe을-데이터베이스-테이블처럼-사용하기)
  - [Spark에서 사용할 수 있는 SQL문](#spark에서-사용할-수-있는-sql문)
  - [Python에서 Spark SQL 사용하기](#python에서-spark-sql-사용하기)
  - [RDD를 사용안하고 DataFrame을 사용했을 때의 장점](#rdd를-사용안하고-dataframe을-사용했을-때의-장점)
  - [Datasets](#datasets)
  - [SQL 실습](#sql-실습)
  - [DataFrame 특징](#dataframe-특징)
  - [DataFrame의 스키마를 확인하는 법](#dataframe의-스키마를-확인하는-법)
  - [DataFrame Operations](#dataframe-operations)
  - [DataFrame Select](#dataframe-select)
  - [DataFrame Agg](#dataframe-agg)
  - [DataFrame GroupBy](#dataframe-groupby)
  - [DataFrame Join](#dataframe-join)
  - [Spark SQL로 트립 수 세기](#spark-sql로-트립-수-세기)
  - [Spark SQL로 뉴욕의 각 행정구 별 데이터 추출하기](#spark-sql로-뉴욕의-각-행정구-별-데이터-추출하기)
  - [Spark의 두개의 엔진](#spark의-두개의-엔진)
  - [Logical Plan이란](#logical-plan이란)
  - [Physical Plan이란](#physical-plan이란)
  - [Catalyst 란](#catalyst-란)
  - [Catalyst Logical Plan -> Physical Plan 동작 순서](#catalyst-logical-plan---physical-plan-동작-순서)
  - [Catalyst Pipeline](#catalyst-pipeline)
  - [Logical Planning 최적화](#logical-planning-최적화)
  - [Explain](#explain)
  - [Tungsten](#tungsten)
  - [UDF](#udf)
  - [뉴욕 택시 데이터 분석](#뉴욕-택시-데이터-분석)
- [9. MLlib](#9-mllib)
  - [MLlib이란](#mllib이란)
  - [Machine Learning 이란](#machine-learning-이란)
  - [MLlib의 여러 컴포넌트](#mllib의-여러-컴포넌트)
  - [ML 파이프라인 구성](#ml-파이프라인-구성)
  - [MLlib으로 할 수 있는 것들](#mllib으로-할-수-있는-것들)
  - [MLlib은 DataFrame위에서 동작한다.](#mllib은-dataframe위에서-동작한다)
  - [MLlib의 주요 Components](#mllib의-주요-components)
  - [MLlib - Transformer](#mllib---transformer)
  - [MLlib - Estimator](#mllib---estimator)
  - [MLlib - Evaluator](#mllib---evaluator)
  - [MLlib - Pipeline](#mllib---pipeline)
  - [첫 파이프라인 구축](#첫-파이프라인-구축)
  - [ALS 추천 알고리즘](#als-추천-알고리즘)
  - [추천이란](#추천이란)
  - [영화 추천 파이프라인 구축](#영화-추천-파이프라인-구축)
  - [Supervised Leaning](#supervised-leaning)
  - [택시비 예측하기1](#택시비-예측하기1)
  - [택시비 예측하기2](#택시비-예측하기2)
  - [하이퍼 파라미터 최적화](#하이퍼-파라미터-최적화)
  - [모델 저장 & 로딩](#모델-저장--로딩)
- [10. Spark Streaming](#10-spark-streaming)
  - [Spark Streaming이란](#spark-streaming이란)
  - [Streaming Data란](#streaming-data란)
  - [Discretized Streams (DStreams)](#discretized-streams-dstreams)
  - [Window Operations](#window-operations)
  - [Streaming Query: Source](#streaming-query-source)
  - [Streaming Query: Transformation](#streaming-query-transformation)
  - [Streaming Query: Processing Details](#streaming-query-processing-details)
  - [Transformations](#transformations-1)
  - [State 관리](#state-관리)
  - [간단한 스트리밍 구현](#간단한-스트리밍-구현)
- [11. Apache Airflow](#11-apache-airflow)
  - [Apache Airflow란](#apache-airflow란)
  - [워크플로우 관리 문제](#워크플로우-관리-문제)
  - [cron script와 같은 기존 방식의 문제점](#cron-script와-같은-기존-방식의-문제점)
  - [AirFlow란](#airflow란)
  - [Workflow란](#workflow란)
  - [Airflow의 구성요소](#airflow의-구성요소)
  - [Operator](#operator)
  - [작업(Task)](#작업task)
  - [Airflow의 유용성](#airflow의-유용성)
  - [Airflow의 One Node Architecture](#airflow의-one-node-architecture)
  - [Airflow의 Multi Node Architecture](#airflow의-multi-node-architecture)
  - [Airflow 동작 방식](#airflow-동작-방식)
  - [DAG의 생성과 실행](#dag의-생성과-실행)
  - [Airflow 설치](#airflow-설치)
  - [Airflow CLI command](#airflow-cli-command)
  - [Airflow DAGs 대시보드](#airflow-dags-대시보드)
  - [Airflow DAG View](#airflow-dag-view)
  - [NFT 파이프라인 프로젝트 소개](#nft-파이프라인-프로젝트-소개)
  - [NFT 파이프라인 - DAG Skeleton](#nft-파이프라인---dag-skeleton)
  - [Airflow - 내장 Operators](#airflow---내장-operators)
  - [Airflow - Action Operator](#airflow---action-operator)
  - [NFT 파이프 라인 - create table task 추가](#nft-파이프-라인---create-table-task-추가)
  - [NFT 파이프 라인 - Sensor 로 API 확인하기](#nft-파이프-라인---sensor-로-api-확인하기)
  - [NFT 파이프 라인 - OpenSea API 오류 대처법](#nft-파이프-라인---opensea-api-오류-대처법)
  - [NFT 파이프 라인 - HttpOperator로 데이터 불러오기](#nft-파이프-라인---httpoperator로-데이터-불러오기)
  - [NFT 파이프 라인 - process](#nft-파이프-라인---process)
  - [NFT 파이프 라인 - store](#nft-파이프-라인---store)
  - [NFT 파이프 라인 - 테스크간 의존성 만들기](#nft-파이프-라인---테스크간-의존성-만들기)
  - [Backfill](#backfill)
  - [Airflow로 Spark 파이프라인 관리하기 - Airflow와 Spark 환경세팅 및 사용하기](#airflow로-spark-파이프라인-관리하기---airflow와-spark-환경세팅-및-사용하기)
  - [택시비 예측 파이프라인 만들기](#택시비-예측-파이프라인-만들기)
- [12. Kafka](#12-kafka)
  - [전통적인 아키텍쳐](#전통적인-아키텍쳐)
  - [전통적인 아키텍처의 문제점](#전통적인-아키텍처의-문제점)
  - [Kafka 소개 1](#kafka-소개-1)
  - [Kafka 소개 2](#kafka-소개-2)
  - [Kafka를 이용한 아키텍쳐](#kafka를-이용한-아키텍쳐)
  - [Kafka의 장점들](#kafka의-장점들)
  - [Kafka 사용 예](#kafka-사용-예)
  - [Kafka 구성](#kafka-구성)
  - [Kafka를 이용한 아키텍처 - 상세](#kafka를-이용한-아키텍처---상세)
  - [Kafka Topic](#kafka-topic)
  - [Kafka Partition](#kafka-partition)
  - [Kafka Message](#kafka-message)
  - [Kafka Offset](#kafka-offset)
  - [Kafka Broker](#kafka-broker)
  - [Kafka Producer & Consumer](#kafka-producer--consumer)
  - [Kafka Consumer Group](#kafka-consumer-group)
  - [Zookeeper](#zookeeper)



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


## 5. spark 기본

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


### RDD란 
```
lines = sc.textFile("") # lines == RDD 
```
- Resilient Distributed Dataset 

### RDD 특징 - 1. 데이터 추상화  
- 데이터는 클러스터에 흩어져있지만 하나의 파일인것 처럼 사용 가능 

### RDD 특징 - 2. 탄력적 & 불변
- 탄력적이고 불변하는 성질이 있다 (Resilient & Immutable)
- 데이터가 여러군데서 연산을 하다가 여러 노드 중 하나가 망가진다면? (네트워크 장애 | 하드웨어 / 메모리 문제 | 알수없는 갖가지 이유 떄문에)
- 데이터가 불변(Imuutable) 하면 문제가 일어날 때 복원이 가능해진다.
- RDD1이 변환을 거치면, RDD1이 바뀌는게 아니라 새로운 RDD2가 만들어진다. (Imuutable)
- 변환을 거칠 때 마다 연산의 기록이 남는다.
- RDD의 변환 과정은 하나의 비순환 그래프(Acyclic Graph)로 그릴 수 있는데, 이 특징 덕분에 문제가 생길 경우에 쉽게 전 RDD로 돌아갈 수 있다. 
- Node 1이 연산 중 문제가 생기면 다시 복원 후 Node2 에서 연산하면 된다. (Resillient)

### RDD 특징 - 3. Type-safe
- 컴파일시 Type을 판별할 수 있어 문제를 일찍 발견할 수 있다.

### RDD 특징 - 4. Unstructured / Structured Data
- Structured / Unstructured 둘다 담을 수 있다.
- Unstructured Data - 로그 or 자연어 
- Structured Data - RDB or DataFrame

### RDD 특징 - 5. Lazy
- 결과가 필요할 떄 까지 연산을 하지 않는다 
- 두가지 연산이 있는데, T = 변환 A = 액션, 예) RDD1 -> T -> RDD2 -> T -> RDD3 -> A --> RDD4
- 액션을 할 때 까지 변환은 실행되지 않는다.
- Action을 만나면 그때 변환(T) 연산을 진행한다. 

### Spark Operation
- Spark Operation = Transform + Action

### RDD를 쓰는 이유 
- 유연하다
- 짧은 코드로 할 수 있는게 많다
- 개발할 때 무엇보다는 어떻게에 대해 더 생각하게 한다 (how-to)
  - 게으른 연산 덕분에 데이터가 어떻게 변환될지 생각하게 된다
  - 데이터가 지나갈 길을 닦는 느낌 

### 우버 트립수 세기
```
spark-submit count_trips.py # 트립 수 세기 

python3 visualiza_trips_date.py # 차트로 그리기 

jupyter notebook . # 주피터로 count_trips.ipynb 열기 -> 코드에 대한 자세한 설명들 
``` 

## 6. 병럴처리와 분산처리 

### 일반 병렬처리 
```
RDD.map(<task>)
```
1. 데이터를 여러개로 쪼개고
2. 여러 쓰레드에서 각자 task를 적용
3. 각자 만든 결과값을 합치는 과정 

### 분산된 환경에서의 병렬처리
1. 데이터를 여러개로 쪼개서 여러 노드로 보낸다.
2. 여러 노드에서 각자 독립적으로 task를 적용
3. 각자 만든 결과값을 합치는 과정 

- 노드간 통신 같이 신경써야될 것이 늘어난다 
- Spark를 이용하면 분산된 환경에서도 일반적인 병렬처리를 하듯이 코드를 짜는게 가능하다.
- Spark는 분산된 환경에서 데이터 병렬 모델을 구현해서 추상화 시켜주기 때문에 가능한것이다. (RDD)
- 그렇다고 생각 없이 spark 코딩을 하면 성능을 끌어내기는 힘들다. (노드간 통신 속도를 신경써야 함)

### 분산처리 문제 
- 분산처리로 넘어가면서 신경써야될 문제가 많아졌다.
- 부분 실패 - 노드 몇개가 프로그램과 상관 없는 이유로 인해 실패 
- 속도 - 많은 네트워크 통신을 필요로 하는 작업은 속도가 저하 

```python
RDD.map(A).filter(B).reduceByKey(C).take(100) # 1 
RDD.map(A).reduceByKey(C).filter(B).take(100) # 2 

"""
1번이 더 좋은 성능의 코드이다.
reduceByKey는 여러노드에서 데이터를 가져오기 떄문에 통신을 필요로 하는데,
filter를 통해서 데이터양을 줄이고 처리하는것이 효율적이기 때문

메모리 > 디스크 > 네트워크 순으로 빠르기떄문에 메모리에서 최대한 많이 처리하는 것이 좋다.
네트워크는 메모리 연산에 비해 100만배 정도 느리다 
"""
```

## 7. RDD 

### Key-Value RDD 이란
- Structured Data를 Spark와 연계해서 쓸수 있게 해주는 도구 중 하나이다. 
- Key와 Value 쌍을 갖는 Key-Value RDD
- (Key, Value) 쌍을 갖기 때문에 Pairs RDD라도고 불림 
- 간단한 데이터베이스처럼 다룰 수 있다.

### Single-Value RDD vs Key-Value RDD 
- Single-Value RDD: 테스트에 등장하는 단어 수 세기 (날짜) -> 1차원 적인 연산 
- Key-Value RDD: 넷플릭스 드라마가 받은 평균 별점 (날짜, 승객수) -> 고차원 적인 연산 

### Key-Value RDD 개념 
- Key와 Value 쌍을 가진다 
  - 예) 지역 ID 별로 택시 운행수는 어떻게 될까?
    - Key: 지역 ID
    - Value: 운행 수 
  - 다른예) 드라마 별로 별점 수 모아보기, 평균 구하기 
  - 다른예) 이커머스 사이트에서 상품당 별 평점 구하기 
- 코드상으로는 많이 다르지 않다 
```python 
pairs = rdd.map(lambda x: (x,1))

"""
[ 
  지역
  지역
]

[ 
  (지역, 1)
  (지역, 1)
]
"""
``` 

### Key-Value RDD - Reduction
- reduceByKey() - 키 값을 기준으로 테스크 처리
- groupByKey() - 키 값을 기준으로 벨류를 묶는다
- sortByKey() - 키 값을 기준으로 정렬
- keys() - 키 값 추출
- values() - 벨류값 추출 
```python
pairs = rdd.map(lambda x: (x,1))
count = pairs.reduceByKey(lambda a, b,: a+b) 

"""
짜장면 
짜장면
짬뽕
짬뽕 

(짜장면, 1)
(짜장면, 1)
(짬뽕, 1)
(짬뽕, 1)

(짜장면, 2)
(짬뽕, 2)
"""
```

### Key-Value RDD - Join
- join 
- rightOuterJoin
- leftOuterJoin
- subtractByKey

### Key-Value RDD - Mapping values
- key를 바꾸지 않는경우 map()대신 value만 다루는 mapValues() 함수를 쓰는게 좋다 
  - spark 내부에서 파티션을 유지할 수 있어서 더욱 효율적이다.
- mapValues(), flatMapValues() 두개다 Value만 다루는 연산들이고 RDD에서 key는 유지됨 

### Key-Value RDD - 예시 
```
1-spark/category-review-average.ipynb
```

### RDD Transformations vs Actions
- Transformation
  - 결과값으로 새로운 RDD를 반환
  - 지연 실행 - Lazy Execution 
  - map()
  - flatMap()
  - filter()
  - distinct()
  - reduceByKey()
  - groupByKey()
  - mapValues()
  - flatMapValues()
  - sortByKey()
- Actions
  - 결과값을 연산하여 출력하거나 저장 (python object 반환 )
  - 즉시 실행 - Eager Execution
  - collect()
  - count()
  - countByValues()
  - take()
  - top()
  - reduce()
  - fold()
  - foreach()

```
1-spark/rdd_transformations_actions.ipynb
```


### Transformations
- transformations = Narrow + Wide 


### Narrow Transformations
- 1:1 변환 
- filter(), map(), flatMap(), sample(), union()
- 1열을 조작하기 위해 다른 열/파티션의 데이터를 쓸 필요가 없음.

### Wide Transformations
- Shuffling
- Intersection and join, distinct, cartesian, reduceByKey(), groupByKey()
- 아웃풋 RDD의 파티션에 다른 파티션의 데이터가 들어갈 수 있음 
- 성능상 많은 리소스를 요구하게 되고, 최소화하고 최적화가 필요하다.


### Lazy 연산의 장점 
- 메모리를 최대한 활용할 수 있다. (디스크, 네트워크 연산을 최소화 할 수 있다.)
- 데이터를 다루는 task는 반복되는 경우가 많아서(ex 머신러닝 학습), Lazy로 처리하면 비효율적인부분을 효율적으로 처리할 수 있다.
  - Task -> Disk -> Task -> Disk 로 작업을 하면 Disk에 자주들르게 되어서 비효율적이다.
  - Task -> Task 로 넘어갈 때 in-memory로 주고받으면 효율적이다.
  - in-memory로 주고 받으려면 어떤 데이터를 메모리에 남겨야 할 지 알아야 가능하다. 
  - Transformations는 지연 실행 되기 때문에 메모리에 저장해둘 수 있다.

### Storage Level
- MEMORY_ONLY: 메모리에만 저장 
- MEMORY_AND_DISK: 메모리와 디스크 모두 저장, 메모리에 없을경우 디스크까지 보겠다.
- MEMORY_ONLY_SER: 메모리를 아끼기 위해서 serialize (꺼내올 때 deserialize 과정이 추가됨)
- MEMORY_AND_DISK_SER: 메모리와 디스크에 serialize
- DISK_ONLY: 디스크에만

### Cache & Persist
- 데이터를 메모리에 남겨두고 싶을 때 사용할 수 있는 함수
```
categoryReviews = filtered_lines.map(parse)

result1 = categoryReviews.take(10)
result2 = categoryReviews.mapValues(lambda x: (x,1)).collect()

# categoryReviews는 result1과 result2를 만들면서 2번 만들어짐.
# .persist()를 추가하면 메모리에 저장해두고 쓸 수 있음 
# categoryReviews = filtered_lines.map(parse).cache()
``` 

- Cache
  - 디폴트 Storage Level 사용 
  - RDD: MEMORY_ONLY
  - DF: MEMORY_AND_DISK
- Persist
  - Storage Level을 사용자가 원하는대로 지정 가능 


### Master Worker Topology
- spark는 Master Worker Topology로 구성 되어 있다.
- 스파크를 쓰면서 잊지 말아야 할 점
  - 항상 데이터가 여러 곳에 분산되어 있다는 것
  - 같은 연산이어도 여러 노드에 걸쳐서 실행 된다는 점 

### Spark 동작 과정
![image](https://user-images.githubusercontent.com/28394879/181002397-623e80e4-ec6f-4a05-a500-19fcfc1ae51b.png)

1. Driver Program이 Spark Context를 생성해서 어플리케이션을 만든다.
2. Spark Context가 Cluster Manager에 연결을 한다.
3. Cluster Manager가 자원들을 할당한다.
4. Cluster Manager가 클러스터에 있는 노드들의 Executor를 수집한다.
5. Executor들은 연산을 수행하고 데이터를 저장한다.
6. Spark Context가 Executor 들에게 실행할 Task를 전송한다음에 
7. 실행된 Task들이 결과값들을 내뱉는데, 이것을 Driver Program에 보내게 된다.

```python
RDD.foreach(lambda x: print(x)) 
"""
Driver Program에서 위 코드를 실행하면 실행결과가 아무것도 나오지 않는다.
왜냐하면 foreach가 액션이기 때문에, Driver가 아닌 Executor에서 바로 실행 되기 떄문이다.
"""
```

```python
foods = sc.parallelize(["짜장면","마라탕", ...])
three = foods.take(3)

"""
three 결과값은 Driver Program에 저장 된다.
일반적으로 액션은 Driver Pgogram이 Worker Node로부터 데이터를 받는 것 까지 포함 한다.
결국, Executor에게 take 연산을 시행하라고 명령하고, 그결과를 driver node에게 돌려달라고 요청하는 것이다. 
"""
```

### Reduction Operations
- Reduction: 요소들을 모아서 하나로 합치는 작업, 많은 Spark의 연산들이 reduction이다.
- 대부분의 Action은 Reduction이다.
- Reduction: 근접하는 요소들을 모아서 하나의 결과로 만드는 일 
- 파일 저장, collect() 등과 같이 Reduction이 아닌 액션도 있다.

### Parallel Reduction
- 파티션 마다 독립적으로 작업을 처리할 수 있어야 분산된 병렬 처리가 가능하다.
- 파티션이 다른 파티션의 결과에 의존하게 되면, 한 테스크가 전 테스크를 기다려야 되기 때문에 작업을 동시에 처리할 수 없게 되고 병렬 처리가 불가능해지므로 분산에 의미가 없어진다.
 

### Reduction Actions
- 대표적인 Reduction Actions: Reduce, Fold, GroupBy, Aggregate 


### Reduce 
```python
from operator import add
sc.parallelize([1,2,3,4,5]).reduce(add) 
# 15 
```


### Partition
- 파티션이 어떻게 나뉠지 프로그래머가 정확히 알기 어렵다.
- 연산의 순서와 상관 없이 결과 값을 보장하려면 
  - 교환 법칙 (a*b = b*a)
  - 결합 법칙 (a*b)*c = a*(b*c)
```
# 파티션에 따라 결과 값이 달라지게 된다.
# 분산된 파티션들의 연산과 합치는 부분을 나눠서 생각해야 한다. 

>>> sc.parallelize([1,2,3,4]).reduce(lambda x,y: (x*2)+y) # 파티션 지정 X 
26
>>> sc.parallelize([1,2,3,4],1).reduce(lambda x,y: (x*2)+y) # 파티션 1개로 지정
26
>>> sc.parallelize([1,2,3,4],2).reduce(lambda x,y: (x*2)+y) # 파티션 2개로 지정
18
>>> sc.parallelize([1,2,3,4],3).reduce(lambda x,y: (x*2)+y) # 파티션 3개로 지정
18
>>> sc.parallelize([1,2,3,4],4).reduce(lambda x,y: (x*2)+y) # 파티션 4개로 지정
26

"""
(1,2,3,4) -> ((1*2+2)*2+3)*2+4=26 # 파티션 1
(1,2)(3,4) -> ((1*2+2)*2 + (3*2)+4) = 18 # 파티션 2
"""
```

### Fold
- Reduce와 유사하지만, Fold는 시작값을 설정해준다 라는 부분만 다름.
```python
from operator import add
sc.parallelize([1,2,3,4,5]).fold(0, add) 
# 15 
```


### Fold & Partition
```python
rdd = sc.parallelize([2,3,4],4)
rdd.reduce(lambda x, y: x*y) # 24
rdd.fold(1, lambda x, y: x*y) # 24

rdd.reduce(lambda x, y: x+y) # 9 (0+2+3+4 =9)
rdd.fold(1, lambda x, y: x+y) # 14 (1+1) + (1+2) + (1+3) + (1+4) = 14 , 각 파티션의 시작값이 1

```


### GroupBy
```python
rdd = sc.parallelize([1,1,2,3,5,8])
result = rdd.groupBy(lambda x: x % 2).collect()
sorted([(x, sorted(y)) for (x,y) in result])
# [(0, [2,8]), (1, [1,1,3,5])]
```

### Aggregate
- RDD 데이터 타입과 Action 결과 타입이 다를 경우 사용
- 파티션 단위의 연산 결과를 합치는 과정을 거친다
- RDD.aggregate(zeroValue, seqOp, combOp)
  - zeroValue: 각 파티션에서 누적할 시작 값
  - seqOp: 타입 변경 함수
  - combOp: 합치는 함수 
- 많이 쓰이는 reduction action
- 대부분의 데이터 작업은 크고 복잡한 데이터 타입 -> 정제된 데이터 


```
seqOp = (lambda x,y: (x[0] + y, x[1] + 1))
combOp = (lambda x,y: (x[0] + y[0], x[1] + y[1]))

sc.parallelize([1,2,3,4]).aggregate((0,0), seqOp, combOp) # (10,4)
sc.parallelize([]).aggregate((0,0), seqOp, combOp) # (0,0)
```
![image](https://user-images.githubusercontent.com/28394879/181008948-71b5ead0-6178-4b2b-9adf-66d720775aa7.png)

### Key-Value RDD Transformations & Actions
- Transformations
  - groupByKey
  - reduceByKey
  - mapValues
  - keys
  - join (+leftOuterJoin, rightOuterJoin)
- Actions
  - countByKey
- Key-Value RDD에서 Tranformations가 많은 이유: 처리과정에서 나온 결과값이 파티션이 유지가 안되더라도 값이 굉장히 크기 때문에 

### Key-Value RDD - GroupByKey
- groupBy: 함수를 기준으로 Group
```python
rdd = parallelize([1,1,2,3,5,8])
result = rdd.groupBy(lambda x: x % 2).collect()
sorted([(x, sorted(y)) for (x,y) in result()])
# [(0, [2,8]), (1, [1,1,3,5])]
```

- groupByKey: Key를 기준으로 Group
```python
rdd = parallelize([("a", 1), ("b", 1), ("a", 1)])
sorted(rdd.groupByKey().mapValues(len).collect())
# [('a',2), ('b',1)]

sorted(rdd.groupByKey().mapValues(list).collect())
# [('a', [1,1]), ('b', [1])]
```

### Key-Value RDD - ReduceByKey
- reduce: 함수를 기준으로 요소들을 합침 (action)
```python
sc.parallelize([1,2,3,4,5]).reduce(add) 
# 15
```

- reduceBykey: key를 기준으로 그룹을 만들고 합침 (trans)
```python
rdd = sc.parallelize([("a",1), ("b",1), ("a",1)])
sorted(rdd.reduceByKey(add).collect())
# [('a',2), ('b',1)]
```

- 개념적으로는 groupByKey + reduction
- 하지만, groupByKey보다 훨씬 빠르다 

### Key-Value RDD - mapValues
- 함수를 밸류에게만 적용한다
- 파티션과 키는 그대로 납둔다. (파티션과 키를 왔다갔다 하지않아서 네트워크 비용을 줄일 수 있다)
```python
x = sc.parallelize([("a", ["apple","banana","lemon"]), ("b", ["grapes"])])
def f(x): return len(x)
x.mapValues(f).collect()
# [('a',3), ('b',1)]
```

### Key-Value RDD - countByKey
- 각 키가 가진 요소들을 센다
```python
rdd = sc.parallelize([("a",1), ("b",1), ("a",1)])
sorted(rdd.countByKey().items())
# [('a',2), ('b',1)]
``` 


### Key-Value RDD - keys()
- Transformation
- 모든 Key를 가진 RDD를 생성 

```python
m = sc.parallelize([(1,2), (3,4)]).keys()
m.collect()
# [1,3]
``` 

### Key-Value RDD - Joins
- Transformation
- 여러개의 RDD를 합치는데 사용
- 대표적으로 두가지의 join 방식이 존재한다.
  - Inner Join (join)
  - Outer join (left outer, right outer)

```
rdd1 = sc.parallelize([("foo",1), ("bar",2), ("baz",3)])
rdd2 = sc.parallelize([("foo",4), ("bar",5), ("bar", 6), ("zoo", 1)])

rdd1.join(rdd2).collect()
# [('bar',(2,5)), ('bar', (2,6)), ('foo', (1,4))]

rdd1.leftOuterJoin(rdd2).collect()
# [('baz', (3, None)), ('bar', (2,5)), ('bar', (2,6)), ('foo', (1,4))]

rdd1.rightOuterJoin(rdd2).collect()
# [('bar', (2,5)), ('bar', (2,6)), ('zoo', (None,1)), ('foo', (1,4))]
```


### Shuffling
- 그룹핑시 데이터를 한 노드에서 다른노드로 옮길 때 사용
- 성능을 (많이) 저하시킨다
- groupByKey를 할 때도 발생한다.
- 여러 노드에서 데이터를 주고 받게 되서 네트워크 연산의 비용이 높다
- Shuffle을 일으킬 수 있는 작업들
  - Join, leftOuterJoin, rightOuterJoin
  - GroupByKey
  - ReduceByKey
  - ComebineByKey
  - Distinct
  - Intersection
  - Repartition
  - Coalesce
- Shuffle이 발생하는 시점
  - 결과로 나오는 RDD가 원본 RDD의 다른 요소를 참조하거나 다른 RDD를 참조할 때 

### Partitioner를 이용한 성능 최적화 (Shuffle 최소화)
- 미리 파티션을 만들어 두고 캐싱 후 reduceByKey 실행
- 미리 파티션을 만들어 두고 캐싱 후 join 실행
- 둘다 파티션과 캐싱을 조합해서 최대한 로컬 환경에서 연산이 실행되도록 하는 방식 
- 셔플을 최소화하면 10배의 성능 향상이 가능하다.

예시 groupByKey vs reduceByKey
```
# reduceByKey
(textRDD
.flatMap(lambda lin: line.split()) # 동일한 노드에서 실행
.map(lambda work: (word, 1)) # 동일한 노드에서 실행 
.reduceByKey(lambda a, b: a+b)) # 셔플 발생 

# groupByKey
(textRDD
.flatMap(lambda line: line.split())
.map(lambda word: (word,1)) 
.groupByKey() # 셔플 발생
.map(lambda (w, counts): (w, sum(counts)))) 

# 가급적이면, groupByKey대신에 reduceByKey로 대체 가능하니까 reduceByKey를 사용하자.
```

### Partition의 목적
- 데이터를 최대한 균일하게 퍼트리고, 쿼리가 같이 되는 데이터를 최대한 옆에 두어 검색 성능을 향상 

### Partition 특징 
- RDD는 쪼개져서 여러 파티션에 저장됨
- 하나의 파티션은 하나의 노드(서버)에
- 하나의 노드는 여러개의 파티션을 가질 수 있음
- 파티션의 크기와 배치는 자유롭게 설정 가능하며 성능에 큰 영향을 미침
- Key-Value RDD를 사용할 때만 의미가 있다.
- 스파크의 파티셔닝 == 일반 프로그래밍에서 자료구조를 선택하는 것 

### Partition의 종류 
- Hash Partitioning
- Range Partitioning

### Hash Partitioning
- 데이터를 여러 파티션에 균일하게 분배하는 방식
- 딕셔너리와 비슷한 방식으로 분배 
- 잘못된 사용
  - 데이터를 여러 파티션에 균일하게 분배하는 방식인데,
  - [극단적인 예] 2개의 파티션이 있는 상황에서 짝수의 Key만 있는 데이터셋에 Hash 함수가 (x%2)인 경우 (한쪽 파티션만 사용.)

### Range Partitioning
- 순서가 있는, 정렬된 파티셔닝
- 키의 순서에 따라 정렬
- 키의 집합의 순서에 따라 정렬   
- 서비스의 쿼리 패턴이 날짜 위주면 일별 Range Partition 고려 

### Memory & Disk Partition
- Disk에서: partitionBy() (보통 이것을 많이 사용)
- 메모리에서: repartition(), coalesce()

### Disk Partition
- 사용자가 지정한 파티션을 가지는 RDD를 생성하는 함수: partitionBy()
- 파티션을 만든 후엔 persist()를 해야 한다
  - 하지않으면, 다음 연산에 불릴떄 마다 반복하게 된다 (셔플링이 반복적으로 일어난다)
```
pairs = sc.parallelize([1,2,3,4,2,4,1]).map(lambda x: (x,x))
pairs.collect()
# [(1,1),(2,2),(3,3),(4,4),(2,2),(4,4),(1,1)]

pairs.partitionBy(2).glom().collect()
# [[(2,2), (4,4), (2,2), (4,4)], [(1,1), (3,3), (1,1)]]

pairs.partitionBy(2, lambda x: x%2).glom().collect()
# [[(2,2), (4,4), (2,2), (4,4)], [(1,1), (3,3), (1,1)]]

# glom은 파티션정보까지 같이 보는 함수 
```

### Repartition & Coalesce
- 둘다 파티션의 갯수를 조절하는데 사용
- 둘다 shuffling을 동반하여 매우 비싼 작업
- Repartition: 파티션의 크기를 줄이거나 늘리는데 사용
- Coalesce: 파티션의 크기를 줄이는데 사용 (줄일땐 Repartition보다 성능이 좋음 )

### 연산 중에 파티션을 만드는 작업들 
- Join (+ Outer join) 
- groupByKey
- reduceByKey
- foldByKey
- partitionBy
- Sort
- mapValues (parent)
- flatMapValues (parent)
- filter (parent)
- 등
- mapValues, flatMapValues, filter는 parent RDD에서 파티션이 정의되어 있으면 그걸 그대로 사용

### map vs mapValues
- map, flatMap은 왜 파티션을 안만들까? => map, flatMap은 key값이 바뀔 수 있기 때문에 파티션을 해놓은게 의미가 없어질 수 있기 때문
- 그래서 파티션이 잘 정의되어 있다면 mapValues, flatMapValues를 쓰는것이 좋다.


## 8. Spark SQL

join().filter() vs filter().join() 을 비교하면 당연히 filter().join()이 성능이 더 빠르다.  
위와 같은 고민을 스파크가 알아서 해주면 좋겠는데, 어떻게 가능할까?  
데이터가 구조화 되어 있다면 자동으로 최적화가 가능하다.

### Structured Data vs Unstructured Data 
- Unstructured: Free Form 
  - 로그 파일 
  - 이미지
- Semi Structured: 행과 열
  - CSV
  - JSON
  - XML
- Structured: 행과 열 + 데이터 타입 (스키마)
  - 데이터베이스

### Structured Data vs RDDs
- RDD에서는 
  - 데이터의 구조를 모르기 떄문에 데이터를 다루는 것을 개발자에게 의존한다.
  - map, flatMap, filter 등을 통해 유저가 만든 function을 수행
- Structured Data에서는
  - 데이터의 구조를 이미 알고 있으므로 어떤 테스크를 수행할 것인지 정의만 하면 됨
  - 최적화도 자동으로 할 수 있음 

### Spark SQL
- 구조화된 데이터를 다룰 수 있게 해준다.
- 유저가 일일이 function을 정의하는 일 없이 작업을 수행 할 수 있다.
- 자동으로 연산이 최적화 된다 

### Spark SQL의 목적 
- 스파크 프로그래밍 내부에서 관계형 처리를 하기 위해 사용
- 스키마의 정보를 이용해 자동으로 최적화를 하기 위해 사용
- 외부 데이터셋을 사용하기 쉽게 하기 위해 사용 

### Spark SQL 소개 
- 스파크 위에 구현된 하나의 패키지
- 3개의 주요 API
  - SQL
  - DataFrame
  - Datasets
- 2개의 백엔드 컴포넌트
  - Catalyst - 쿼리 최적화 엔진
  - Tungsten - 시리얼라이저(용량 최적화)

### DataFrame
- Spark Core에 RDD가 있다면, Spark SQL에는 DataFrame이 있다.
- DataFrame은 테이블 데이터셋이라고 보면 됨
- 개념적으로는 RDD에 스키마가 적용된 것이라고 보면 됨 

### SparkSession
- Spark Core에 SparkContext가 있다면 Spark SQL에는 SparkSession이 있다.

```python
spark = SparkSession.builder.appName("test-app").getOrCreate()
```

### DataFrame 만드는 법
- RDD에서 스키마를 정의한다음 변형을 하거나
- CSV, JSON등의 데이터를 받아오면 된다


### RDD로부터 DataFrame 만들기 
- Schema를 자동으로 유추해서 DataFrame 만들기
- Schema를 사용자가 정의하기 

```python
# RDD 만들기
lines = sc.textfile("example.csv")
data = lines.map(lambda x: x.split(","))
preprocessed = data.map(lambda x: Row(name=x[0], price=int(x[1])))
 
# Infer (Schema를 유추해서 만들기)
df = spark.createDataFrame(preprocessed)

# Specify (Schema를 사용자가 정의하기)
schema = StructType(
  StructField("name", StringType(), True),
  StructField("price", StringType(), True)
)
spark.createDataFrame(preprocessed, schema).show()
```

### 파일로부터 DataFrame 만들기 
```python
from pyspark.sql import SparkSession
spark = SparkSession.builder.appName("test-app").getOrCreate()

# JSON
dataframe = spark.read.json('dataset/nyt2.json')
# TXT FILE
dataframe_txt = spark.read.text('text_data.txt')
# CSV FILE
dataframe_csv = spark.read.csv('csv_data.csv')
# PARQUET FILE
dataframe_parquet = spark.read.load('parquet.data.parquet')
```

### DataFrame을 데이터베이스 테이블처럼 사용하기 
- createOrReplaceTempView() 함수로 temporary view를 만들어 줘야 함.
```python
data.createOrReplaceTempView("mobility_data")
spark.sql("SELECT pickup_datetime FROM mobility_data LIMIT 5").show()
``` 


### Spark에서 사용할 수 있는 SQL문 
- Hive Query Language와 거의 동일 
- Select
- From
- Where
- Count
- Having
- Group By
- Order By
- Sort By
- Distinct
- Join

### Python에서 Spark SQL 사용하기 
- Spark SQL을 사용하기 위해 사용하는 SparkSession
- SparkSession 으로 불러오는 데이터는 DataFrame
```python
from pyspark.sql import SparkSession
spark = SparkSession.builder.appName("test-app").getOrCreate()

# JSON
dataframe = spark.read.json('dataset/nyt2.json')
# TXT FILE
dataframe_txt = spark.read.text('text_data.txt')
# CSV FILE
dataframe_csv = spark.read.csv('csv_data.csv')
# PARQUET FILE
dataframe_parquet = spark.read.load('parquet.data.parquet')
```

- SQL문을 사용해서 쿼리가 가능하다.
```python
data.createOrReplaceTempView("mobility_data")
spark.sql("SELECT pickup_datetime FROM mobility_data LIMIT 5").show()
```

- 함수를 사용해서 쿼리도 가능하다.
```python
df.select(df['name'], df['age'] + 1).show()

df.filter(df['age'] > 21).show()

df.groupBy("age").count().show()
``` 

- DataFrame을 RDD로 변환해 사용할 수도 있다.
  - `rdd = df.rdd.map(tuple)`
  - (하지만, RDD를 덜 사용하는 쪽이 좋다)

### RDD를 사용안하고 DataFrame을 사용했을 때의 장점 
- MLLib이나 Spark Streaming 같은 다른 스파크 모듈들과 사용하기 편하다.
- 개발하기 편하다.
- 최적화도 알아서 된다.

### Datasets
- Type이 있는 DataFrame
- PySpark에선 크게 신경쓰지 않아도 된다.

### SQL 실습 
```
./1-spark/learn-sql.ipynb
```


### DataFrame 특징
- 관계형 데이터이다.
- 한마디로 관계형 데이터셋 = RDD + Relation
- RDD가 함수형 API를 가졌다면 DataFrame은 선언형 API
- 자동으로 최적화가 가능
- 타입이 없다 
- RDD의 확장판 
  - 지연 실행 (Lazy Execution)
  - 분산 저장
  - Immutable
  - 열(Row) 객체가 있다
  - SQL 쿼리를 실행할 수 있다.
  - 스키마를 가질 수 있고 이를 통해 성능을 더욱 최적화 할 수 있다
  - CSV, JSON, Hive 등으로 읽어오거나 변환이 가능 

### DataFrame의 스키마를 확인하는 법 
- dtypes
- show()
  - 테이블 형태로 데이터를 출력
  - 첫 20개의 열만 보여준다
- printSchema()
  - 스키마를 트리 형태로 볼 수 있다.

### DataFrame Operations
- SQL 과 비슷한 작업이 가능하다.
- Select
- Where
- Limit
- OrderBy
- GroupBy
- Join

### DataFrame Select
- 사용자가 원하는 Column이나 데이터를 추출 하는데 사용 
```python
df.select('*').collect()
df.select('name','age').collect()
df.select(df.name, (df.age+10).alias('age')).collect()
``` 

### DataFrame Agg
- Aggregate의 약자로, 그룹핑 후 데이터를 하나로 합치는 작업 
```python
df.agg({"age",: "max"}).collect() 
# [Row(max(age)=5)]

from pyspark.sql improt functions as F
df.agg(F.min(df.age)).collect()
# [Row(min(age)=2)]
``` 

### DataFrame GroupBy
- 사용자가 지정한 column을 기준으로 데이터를 Grouping하는 작업 
```python
df.groupBy().avg().collect()
# [Row(avg(age)=3.5)]

sorted(df.groupBy('name').agg({'age': 'mean'}).collect())
# [Row(name='Alice', avg(age)=2.0), Row(name='Bob', avg(age)=5.0)]

sorted(df.groupBy(df.name).avg().collect())
# [Row(name='Alice', avg(age)=2.0), Row(name='Bob', avg(age)=5.0)]

sorted(df.groupBy(['name', df.age]).count().collect())
# [Row(name='Alice', age=2, count=1), Row(name='Bob', age=5, count=1)]
``` 

### DataFrame Join
- 다른 DataFrame과 사용자가 지정한 Column을 기준으로 합치는 작업 
```python
df.join(df2, 'name').select(df.name, df2.height).collect()
# [Row(name='Bob', height=85)]
``` 

### Spark SQL로 트립 수 세기 
- 이전에 RDD로 실습해보았는데, 이번엔 Spark SQL로 해보자. 
```
./1-spark/trip_count_sql.ipynb
```

### Spark SQL로 뉴욕의 각 행정구 별 데이터 추출하기
- 두 테이블의 JOIN 실습 
```
./1-spark/trip_count_sql_by_zone-Copy1.ipynb
```

### Spark의 두개의 엔진 
- 스파크는 쿼리를 돌리기 위해 두가지 엔진을 사용한다.
- Catalyst, Tungsten

### Logical Plan이란
- 수행 해야 하는 모든 transformation 단계에 대한 추상화
- 데이터가 어떻게 변해야 하는지 정의하지만,
- 실제 어디서 어떻게 동작 하는지는 정의하지 않음

### Physical Plan이란 
- Logical Plan이 어떻게 클러스터 위에서 실행 될지 정의
- 실행 전략을 만들고 Cost Model에 따라 최적화

### Catalyst 란 
- SQL과 DataFrame이 구조가 있는 데이터를 다룰 수 있게 해주는 모듈 
- Logical Plan을 Physical Plan으로 바꾸는 일을 한다.

### Catalyst Logical Plan -> Physical Plan 동작 순서
1. 분석: DataFrame 객체의 relation을 계산, 칼럼의 타입과 이름 확인 
2. Logical Plan 최적화
   1. 상수로 표현된 표현식을 Compile Time에 계산 (x runtime)
   2. Predicate Pushdown: join & filter -> filter & join
   3. Projection Pruning: 연산에 필요한 칼럼만 가져오기 
3. Physical Plan 만들기: Spark에서 실행 가능한 Plan으로 변환 
4. 코드 제네레이션: 최적화된 Physical Plan을 Java Bytecode로 


### Catalyst Pipeline
![image](https://user-images.githubusercontent.com/28394879/181866781-ef7fdbb0-f0e4-4994-85ac-7625c6235e9b.png)

### Logical Planning 최적화 

```sql
SELECT zone_data.Zone, count(*) AS trips \
  FROM trip_data JOIN zone_data \
  ON trip_data.PULocationID = zone_data.LocationID \
  WHERE trip_data.hvfhs_license_num = 'HV0003' \
  GROUP BY zone_data.Zone order by trips desc
```

기본 순서
1. Scan: 두개의 테이블에서 데이터 추출
2. Join: `join`
3. Filter: `trip_data.hvfhs_license_num = 'HV0003`
4. Project: `count(*) AS trips`
5. Aggregate: `group by`

최적화 
1. Scan: 두개의 테이블에서 데이터 추출
2. Filter: `trip_data.hvfhs_license_num = 'HV0003`
3. Join: `join`
4. Project: `count(*) AS trips`
5. Aggregate: `group by`


### Explain 
```python
spark.sql(query).explain(True)
```

![image](https://user-images.githubusercontent.com/28394879/181867021-4e99de57-a90c-4e1a-ac9a-d8e0ac99b2e5.png)
- explain(True) 명령어를 입력하면 아래의 정보들을 보여준다 
  - Parsed Logical Plan: 사용자가 쓴 코드 그대로 
  - Analyzed Logical Plan: 사용자가 지정한 테이블의 무슨 컬럼이 있는지 확인한다.
  - Optimized Logical Plan: Filtering코드를 더 빨리 하는 등 최적화된 코드를 보여준다 
  - Physical Plan: 디테일한 Plan을 보여줌
- explain(True 없이) 명령어를 입력하면 아래 정보만 나온다.
  - Physical Plan

### Tungsten
- Physical Plan이 선택되고 나면 분산 환경에서 실행될 Bytecode가 만들어진다. (Code Generation)
- 스파크 엔진의 성능 향상이 목적
  - 메모리 관리 최적화
  - 캐시 활용 연산
  - 코드 생성 


### UDF 
- user-defined-functions
- sql 문안에서 쓸 수 있는 function을 만드는것

실습
```
./1-spark/user-defined-functions.ipynb
``` 

### 뉴욕 택시 데이터 분석 
```
./1-spark/taxi-analysis.ipynb
```

## 9. MLlib

### MLlib이란 
- Machine Learning Library
- ML을 쉽고 확장성 있게 적용하기 위해 사용
- 머신러닝 파이프라인 개발을 쉽게 하기 위해 

### Machine Learning 이란 
- 데이터를 이용해 코딩을 하는 일 
- 최적화와 같은 방법을 통해 패턴을 찾는일 

### MLlib의 여러 컴포넌트 
- 알고리즘
  - Classification
  - Regression
  - Clustering
  - Recommendation
- 파이프라인
  - Training
  - Evaluating
  - Tuning
  - Persistence
- Feature Engineering
  - Extraction
  - Transformation
- Utils
  - Linear algebra
  - Statistics

### ML 파이프라인 구성
- 데이터 로딩 -> 전처리 -> 학습 -> 모델 평가
- 파라미터 튜닝 후 위 과정을 다시 시도 

### MLlib으로 할 수 있는 것들
- 피쳐 엔지니어링
- 통계적 연산
- 흔히 쓰이는 ML알고리즘들
  - Regression (Linea, Logistic)
  - Support Vector Machines
  - Naive Bayes
  - Decision Tree
  - K-Means clustering
- 추천 (Alternating Least Squares)

### MLlib은 DataFrame위에서 동작한다.
- 아직 RDD API가 있지만, "maintenance mode"
  - 새로운 API는 개발이 끊김
- DataFrame을 쓰는 MLlib API를 Spark ML이라고도 부름 

### MLlib의 주요 Components
- DataFrame
- Transformer
- Estimator
- Evaluator
- Pipeline
- Parameter

### MLlib - Transformer
- 피쳐 변환과 학습된 모델을 추상화
- 모든 Transformer는 transform() 함수를 갖고 있다
- 데이터를 학습이 가능한 포멧으로 바꾼다
- DF를 받아 새로운 DF를 만드는데, 보통 하나 이상의 column을 더하게 된다
- 예)
  - Data Normalization
  - Tokenization
  - 카테고리컬 데이터를 숫자로 (one-hot encoding)

### MLlib - Estimator
- 모델의 학습 과정을 추상화
- 모든 Estimator는 fit() 함수를 갖고 있다
- fit()은 DataFrame을 받아 Model을 반환
- 모델을 하나의 Transformer
- 예)
  - lr = LinearRegression()
  - model = lr.fit(data) 

### MLlib - Evaluator
- metric을 기반으로 모델의 성능을 평가
  - 예) Root mean squared error (RMSE)
- 모델을 여러개 만들어서, 성능을 평가 후 가장 좋은 모델을 뽑는 방식으로 모델 튜닝을 자동화 할 수 있다.
- 예)
  - BinarClassificationEvaluator
  - CrossValidator

### MLlib - Pipeline
- ML의 워크플로우를 정의할 때 사용
- 여러 stage를 담고 있다
- 저장될 수 있다. (persist)
- 파이프라인 예: 데이터로딩 -> 전처리 -> 학습 -> 모델평가 
- Transformer -> Tranformer -> Estimator -> Evaluator -> Model 

### 첫 파이프라인 구축 
```
./1-spark/logistic-regression.ipynb
./1-spark/pipeline.ipynb
```

### ALS 추천 알고리즘 
- Alternating Least Squares

<img width="410" alt="image" src="https://user-images.githubusercontent.com/28394879/182013892-443abd23-5c92-438d-97ff-0e5cf6d15f87.png">
- 유저 A와 B의 취향이 비슷하다는 것을 알 수 있다.
- 이때, 유저 A에게 Casablanca를 추천하는 알고리즘이다.

### 추천이란 
- 아직 못본 영화들의 평점을 예하고,
- 값을 정렬해서 제일 위에서 부터 유저에게 전달하는 것이 추천이다.

### 영화 추천 파이프라인 구축 
```
./1-spark/movie-recommendation.ipynb
```

### Supervised Leaning 
- 지도 학습
- Regression, Classification 둘다 지도학습이다.
- Regression: 예측된 값이 실수
- Classification: 예측된 값이 클래스(카테고리)

### 택시비 예측하기1
```
./1-spark/taxi-fare-prediction.ipynb
```

### 택시비 예측하기2 
```
./1-spark/taxi-fare-prediction-2.ipynb
```

### 하이퍼 파라미터 최적화 
```
./1-spark/taxi-fare-prediction-hyper.ipynb
```

### 모델 저장 & 로딩 
```
./1-spark/taxi-fare-prediction-hyper.ipynb
```

## 10. Spark Streaming

### Spark Streaming이란 
- SQL 엔진 위에 만들어진 분산 스트림 처리 프로세싱
- 데이터 스트림을 처리할 때 사용
- 시간대 별로 데이터를 합쳐(aggregate) 분석 할 수 있음
- kafka, Amazon Kinesis, HDFS 등과 연결 가능
- 체크포인트를 만들어서 부분적인 결함이 발생해도 다시 돌아가서 데이터를 처리할 수 있다. 

### Streaming Data란 
- 데이터 스트림은 무한한 테이블이다.
- input Data Stream --SparkStreaming--> batches of input data --SparkEngine--> batches of processed data

### Discretized Streams (DStreams)
- Spark Stream의 기본적인 추상화
- 내부적으론 RDD의 연속이고 RDD의 속성을 이어받음 

### Window Operations
- 지금의 데이터를 처리하기 위해 이전 데이터에 대한 정보가 필요할 때  

### Streaming Query: Source
- 데이터를 어디에서 읽어올 지 명시
- 여러 데이터 소스를 사용해 join()이나 union()으로 합쳐 쓸 수 있다
```python
spark.readStream.format("kafka")
  .option("kafka.bootstrap.servers", ...)
  .option("subscribe","topic")
  .load()
```

### Streaming Query: Transformation
```python
spark.readStream.format("kafka")
  .option("kafka.bootstrap.servers", ...)
  .option("subscribe","topic")
  .load()
  .selectExpr("cast(value as string) as json")
  .select(from_json("json", schema).as("data"))
```

### Streaming Query: Processing Details
```python
spark.readStream.format("kafka")
  .option("kafka.bootstrap.servers", ...)
  .option("subscribe","topic")
  .load()
  .selectExpr("cast(value as string) as json")
  .select(from_json("json", schema).as("data"))
  .writeStream.format("parquet")
  .trigger("1 minute") # <-- micro-batch 실행 간격
  .option("checkpointLocation", "...")
  .start()
```

### Transformations
- Map
- FlatMap
- Filter
- ReduceByKey

### State 관리
- 이전 데이터에 대한 정보를 State로 주고 받을 수 있다.
- 예) 카테고리별 (키값 별) 총합 

### 간단한 스트리밍 구현 
```
terminal1) nc -lk 9999 # 소켓 열기 
terminal2) python3 ./1-spark/streaming.py

terminal1) test testa testb
terminal1) test test testa
```


## 11. Apache Airflow

### Apache Airflow란 
- 에어비앤비에서 개발한 워크플로우 스케줄링, 모니터링 플랫폼
- 실제 데이터의 처리가 이루어지는 곳은 아니다.
- 2016년 아파치 재단 incubator program
- 현재 아파치 탑레벨 프로젝트
- Airbnb, Yahoo, Paypal, Intel, Stripe


### 워크플로우 관리 문제 
- 매일 10시에 주기적으로 돌아가는 데이터 파이프라인을 만들려면?
- 기존 방식: cron script로 사용 
- 매일 10시에 주기적으로 돌아가는 데이터 파이프라인 (외부 api로 download -> process(Spark Job) -> store(DB))들을 수십개 만들어야 한다면?


### cron script와 같은 기존 방식의 문제점 
- 실패 복구: 언제 어떻게 다시 실행할 것인가? Backfill
- 모니터링: 잘 돌아가고 있는지 확인하기 힘들다
- 의존성 관리: 데이터 파이프라인간 의존성이 있는 경우 상위 데이터 파이프라인이 잘 돌아가고 있는지 파악이 힘들다
- 확장성: 중앙화 해서 관리하는 툴이 없기 떄문에 분산된 환경에서 파이프라인들을 관리하기 어렵다
- 배포: 새로운 워크플로우를 배포하기 힘들다

### AirFlow란 
- 워크플로우를 작성하고 스케줄링하고 모니터링 하는 작업을 프로그래밍 할 수 있게 해주는 플랫폼 
- 파이썬으로 쉬운 프로그래밍이 가능
- 분산된 환경에서 확장성이 있음
- 웹 대시보드 (UI)
- 커스터마이징이 가능 

### Workflow란
- 의존성으로 연결된 작업(task)들의 집합 == DAG == Directed Acyclic Graph

### Airflow의 구성요소
- 웹 서버 - 웹 대시보드 UI
- 스케줄러 - 워크플로우가 언제 실행되는지 관리
- Metastore - 메타데이터 관리
- Executor - 테스크가 어떻게 실행되는지 정의
- Worker - 테스크를 실행하는 프로세스

### Operator
- 작업을 정의하는데 사용 
- Action Operators: 실제 연산을 수행
- Transfer Operators: 데이터를 옮김
- Sensor Operators: 테스크를 언제 실행시킬 트리거를 기다림

### 작업(Task)
- Operator를 실행시키면 Task가 된다
- Task = Operator Instance

### Airflow의 유용성 
- 여러 데이터 엔지니어링 환경에서 유용하게 쓰일 수 있다
  - 데이터 웨어하우스
  - 머신러닝
  - 분석
  - 실험
  - 데이터 인프라 관리 

### Airflow의 One Node Architecture
![image](https://user-images.githubusercontent.com/28394879/182063274-f9587c59-d6e2-4002-a9b3-340bae1f9d69.png)
- WebServer, Metastore, Scheduler, Executor가 존재
- 동작 과정
  - Metastore에서 dag에 대한 정보를 담고 있어서, Web server와 Scheduler가 그 정보를 읽어 오고 Executor로 이 정보를 보내서 실행을 한다.
  - 이렇게 실행된 Task Instance는 metastore로 보내져서 상태를 업데이트 한다.
  - 이렇게 업데이트된 상태를 다시 Web Server와 Scheduler가 읽어와서 Task가 잘 완료가 되었는지 확인을 한다.
- Executor에 Queue가 존재해서 순서를 정할 수 있게 된다.

### Airflow의 Multi Node Architecture
![image](https://user-images.githubusercontent.com/28394879/182063326-650f9174-2ea7-4487-9925-5c5828bf8bee.png)
- Queue가 Executor 바깥에 존재 한다 (One Node Architecture와의 큰 차이점)
- Celery Broker가 Queue이다.
- 동작 과정
  - MetaStore에서 dag정보를 webserver와 scheduler가 정보를 읽고, celery executor를 통해서 celery broker에 task 순서대로 담는다.
  - 순서대로 담긴 task를 worker들이 하나씨 가져가서 순서대로 실행된다.
  - 이렇게 실행된 dag들은 완료되면 celery executor 그리고 metastore에 보고가 된다.
  - 이렇게 완료된 상태를 UI와 Scheduler가 다시읽어와서 완료되는 것을 확인한다.

### Airflow 동작 방식
1. DAG를 작성하여 Workflow를 만든다. DAG는 Task로 구성되어 있다
2. Task는 Operator가 인스턴스화 된 것
3. DAG를 실행시킬 때 Scheduler가 DagRun 오브젝트를 만든다
4. DagRun 오브젝트는 Task Instance를 만든다
5. Worker가 Task를 수행 후 DagRun 의 상태를 "완료"로 바꿔놓는다.

### DAG의 생성과 실행 
- 유저가 새로운 DAG를 작성 후 Folder DAGs 안에 배치
- Web Server와 Scheduler가 DAG를 파싱
- Scheduler가 Metastore를 통해 DagRun 오브젝트를 생성 
  - DagRun은 사용자가 작성한 DAG의 인스턴스
  - DagRun status: Running
- Scheduler가 Task Instance 오브젝트 (Dag run 오브젝트의 인스턴스 == Task Instance) 를 스케줄링
- Trigger가 상황에 맞으면 Scheduler가 Task Instance를 Executor로 보냄
- Executor가 그 Task를 실행시킨 다음, 완료후 Metastore에 완료했다고 보고한다. (완료된 Task Instance는 Dag Run을 업데이트 한다)
- Scheduler가 Metastore를 통해서 DAG 실행이 완료됐나 확인을 하고 DagRun Status를 Completed로 변경한다.
- Web Server가 Metastore를 통해서 DAG 실행이 완료됐나 확인을 하고 UI 업데이트를 한다.


### Airflow 설치 
```
# m1 에서는 이 방법으로 설치 안됨.
pip --version # anaconda 로 설치된지 확인
pip install apache-airflow

airflow db init 
airflow werbserver -p 8080
airflow users create --role Admin --username admin --email admin --firstname admin --lastname admin --password admin
```

```
# m1 
curl -LfO 'https://airflow.apache.org/docs/apache-airflow/2.1.1/docker-compose.yaml'
docker-compose up airflow-init
docker-compose up -d 

docker exec -it 64bb1d858ab5ad7babfad795a6e3dc60121e27b15a83c37bda4f54a6a /bin/sh # webserver container 접속 
airflow users create --role Admin --username admin --email admin --firstname admin --lastname admin --password admin
```

### Airflow CLI command
- `airflow -h`: 각종 명령어 설명 보기 
- `airflow webserver`: webserver 시작
- `airflow users create ~~`: user 추가 
- `airflow scheduler`: scheduler 시작
- `airflow db init`: db에 기본적인 파이프라인 생성 및 기본 설정 
- `airflow dags list`: 현재 돌아가는 dag들 출력 
- `airflow tasks list example_xcom`: example_xcom 안에 존재하는 task들 조회 
- `airflow dgas trigger -e 2022-01-01 example_xcom`: 특정 dag를 트리거 

### Airflow DAGs 대시보드 
- `Owner`: Dag 관리자
- `Runs`: 실행 중인 DAG의 상태
- `Schedule`: 주기를 나타내는 설정
- `Last Run`: 최근 실행 날짜
- `Next Run`: 다음 실행이 언제될지 나타냄
- `Recent Tasks`: 방금 실행된 Task들을 보여줌
- `Actions`: DAG를 지우거나 실행
- `Links`: 마우스 갖다대면 여러가지 Link들이 보임 

### Airflow DAG View 
![image](https://user-images.githubusercontent.com/28394879/182180245-c3f88701-fef3-4216-9035-53d536fbe7e1.png)
- `Tree`: Task들의 상태를 보기 편함
- `Graph`: Task들의 의존성을 확인할 때 좋음, 각 Task들의 Log 정보 등을 확인하기에도 좋음
- `Calendar`: 날짜별로 실패 없이 잘 돌아갔나 확인 가능 
- `Task Duration`, `Task Tries`, `Landing Times`: 날짜기반으로 뭔가확인인데 설치 직후엔 볼게 없음
- `Gantt`: 각각의 task가 실행하면서 얼만큼의 시간을 소비했나 볼 수 있다.
- `Details`: 여러가지 Metadata 확인
- `Code`: DAG 코드 확인 

### NFT 파이프라인 프로젝트 소개 
- OpenSea 사이트의 NFT데이터를 추출해 테이블에 저장하기
- 테이블 생성 -> API 확인 -> NFT 정보 추출 -> NFT 정보 가공 -> NFT 정보 저장 


### NFT 파이프라인 - DAG Skeleton
```
./2-airflow/01-sqlite.py  # 기본 dag 구성
# 생성 후 dag 대시보드에 등장하는지 확인 
```


### Airflow - 내장 Operators
1. BashOperator
2. PythonOperator
3. EmailOperator

### Airflow - Action Operator
1. Action Operator는 액션을 실행한다 (데이터를 추출, 데이터 프로세싱 등)
2. Transfer Operator는 데이터를 옮길 때 사용
3. Sensors: 조건이 맞을 때 까지 기다린다


### NFT 파이프 라인 - create table task 추가 
- `Airflow 대시보드 -> Admin -> Connections -> 추가 -> connection id =db_sqlite, conneciton Type = Sqlite 로 Save` 


```
./2-airflow/02-create-table.py
```

```
airflow tasks test nft-pipeline creating_table 2021-01-01 # task 실행 
```

### NFT 파이프 라인 - Sensor 로 API 확인하기 
- `Airflow 대시보드 -> Admin -> Connections -> 추가 -> connection id = opensea_api, conneciton Type = http, host: https://api.opensea.io/ 로 Save` 

```
./2-airflow/03-sensor.py
```

```
airflow tasks test nft-pipeline is_api_available 2021-01-01 # task 실행 
```

### NFT 파이프 라인 - OpenSea API 오류 대처법 
출처: https://github.com/keon/data-engineering/tree/main/02-airflow

- `Airflow 대시보드 -> Admin -> Connections -> 추가 -> connection id = githubcontent_api, conneciton Type = http, host: https://raw.githubusercontent.com/ 로 Save`

```
./2-airflow/03-sensor.py
```

```
airflow tasks test nft-pipeline is_api_available 2021-01-01 # task 실행 
```

### NFT 파이프 라인 - HttpOperator로 데이터 불러오기
```
./2-airflow/04-extract-data.py
```

```
airflow tasks test nft-pipeline extract_nft 2021-01-01 # task 실행 
```

### NFT 파이프 라인 - process
```
./2-airflow/05-process.py
```

```
airflow tasks test nft-pipeline process_nft 2021-01-01 # task 실행 

cat /tmp/processed_nft.csv # 결과 확인 
```

### NFT 파이프 라인 - store
```
./2-airflow/06-store.py

airflow tasks test nft-pipeline store_nft 2021-01-01 # task 실행 

# docker에서는 'airflow.db' 가 따로 없는듯. 그래서 해결은 못했음.
```

### NFT 파이프 라인 - 테스크간 의존성 만들기 
```
./2-airflow/07-dependency.py

airflow에서 DAG 활성화 해서 순차적으로 실행되는지 확인.
```

### Backfill
- 매일 주기적으로 돌아가는 파이프라인을 멈췄다가 몇일 뒤 실행시키면 어떻게 될까? 
  - 예를 들어, 하루에 한번씩 돌아가는 DAG가 1월1일에 실행됐다가, 1월2일에 멈췄었고 1월4일에 다시 시작하면 어떻게 될까? 
  - DAG 설정 코드에 `catchup(False)`이면 1월 4일에 다시 시작하면 1월 4일기준으로 돌아간다.
  - DAG 설정 코드에 `catchup(True)`이면 1월 4일에 다시 시작하면 1월 2일기준으로 돌아간다.
- DAG 시작 날짜를 `2021-01-01`로 해두고, 현재 `2022-08-06`에 `catcup(True)`로하면 어떻게 될까?
  - 기존에 이미 실행된게 있으면 돌아가지 않는다. -> 기존 DAG를 지우고, Browse -> DAG Run -> nft-pipeline 제거 
  - 제거하고나면 바로 1월1일부터 거의 1년치가 동시에 돌아가게 된다.


### Airflow로 Spark 파이프라인 관리하기 - Airflow와 Spark 환경세팅 및 사용하기
```
1. webserver docker 접속
2. pip install apache-airflow-providers-apache-spark
3. fhvhv_tripdata_2020-03.csv 파일 webserver로 전송
```

```python
# webserver docker에서 count_trips.py 작성 
# 패키지를 가져오고
from pyspark import SparkConf, SparkContext
import pandas as pd

# Spark 설정
conf = SparkConf().setMaster("local").setAppName("uber-date-trips")
sc = SparkContext(conf=conf)

# 우리가 가져올 데이터가 있는 파일
directory = "/home/airflow/data"
filename = "fhvhv_tripdata_2020-03.csv"

# 데이터 파싱
lines = sc.textFile(f"file:///{directory}/{filename}")
header = lines.first() 
filtered_lines = lines.filter(lambda row:row != header) 

# 필요한 부분만 골라내서 세는 부분
# countByValue로 같은 날짜등장하는 부분을 센다
dates = filtered_lines.map(lambda x: x.split(",")[2].split(" ")[0])
result = dates.countByValue()

# 아래는 Spark코드가 아닌 일반적인 파이썬 코드
# CSV로 결과값 저장 
pd.Series(result, name="trips").to_csv("trips_date.csv")
```

```
Admin -> Connectors -> 추가 
Connect id: spark_local
Connection Type: Spark
Host: local 

Save
```

```
airflow tasks test spark-example submit_job 2021-01-01

./2-airflow/dags/spark-example.py # 코드 위치 
```

### 택시비 예측 파이프라인 만들기
```
./2-airflow/taxi-price.py
```

## 12. Kafka

### 전통적인 아키텍쳐 
![image](https://user-images.githubusercontent.com/28394879/183271665-07a38ad3-5d02-4f8d-abaa-0f4aa36fc772.png)
- SystemA, SystemB 각각 데이터 쌓인 것을 Data Lake로 보내는 파이프라인을 각각 만들어줘야 함.


### 전통적인 아키텍처의 문제점 
![image](https://user-images.githubusercontent.com/28394879/183271727-69bfc548-8064-4298-be33-8144ae8ed022.png)
- 시스템을 더할수록 기하급수적으로 복잡해진다.
- 여러가지 통신 프로토콜을 지원해야 한다 (HTTP, GRPC, TCP, MQ)
- 데이터 포멧도 다르다 (CSV, JSON, XML)
- Point-of-failure 가 많다 
  - 시스템 A,B,C,D,E,F 각각의 신뢰도가 99% 라고 했을 때
  - 시스템 A,B,C,D,E,F를 묶었을 때의 신뢰도 = 99% ^6 = 94.1%
- 각각의 연결고리 어디서 에러가 나고 있는지 모니터링 하기도 힘들다

### Kafka 소개 1 
- LinkedIn에서 개발
- Apache Software로 넘어가 2011년 오픈소스화
- Apple, eBay, Uber, ArBnB, Netflix 등에서 사용중

### Kafka 소개 2
- 분산 스트리밍 플랫폼
- Source 시스템은 Kafka로 메시지를 보내고
- Destination 시스템은 Kafka로 부터 메시지를 받는다
- 확장성이 있고, 장애 허용 (fault tolerant)을 하며, 성능이 좋다.

### Kafka를 이용한 아키텍쳐 
![image](https://user-images.githubusercontent.com/28394879/183271891-7186501d-d580-4198-992a-6f1bf2645288.png)
- 시스템간 의존성을 간접적으로 만든다
- 확장성: 새 시스템을 더할 때 마다 복잡도가 선형적으로 올라간다
- Kafka를 이용해 통신 프로토콜을 통합하기 쉽다 

### Kafka의 장점들
- 확장성: 하루에 1조개의 메시지를 처리할 수 있고, Petabyte의 데이터를 처리 가능
- 메시지 처리 속도: 2MS
- 가용성(availability): 클러스터 환경에서 작동
- 데이터 저장 성능: 분산 처리, 내구성, 장애 허용 (fault tolerant)

### Kafka 사용 예
- 시스템간 메시지 큐
- 로그 수집
- 스트림 프로세싱
- 이벤트 드리븐 기능들 
- Netflix: 실시간 모니터링
- Expedia: 이벤트 드리븐 아키텍처
- Uber: 실시간 가격 조정, 실시간 수요 예측

### Kafka 구성 
- Topic
- Kafka Broker
- Kafka Producer
- Kafka Consumer
- Kafka Partition
- Kafka Message
- Kafka Offset
- Kafka Consumer Group
- Kafka Cluster
- Zookeeper

### Kafka를 이용한 아키텍처 - 상세 
![image](https://user-images.githubusercontent.com/28394879/183272010-59834043-48dc-4b72-b7e7-089ffa52c541.png)


### Kafka Topic 
- Producer 와 Consumer가 소통을 하는 하나의 채널 
- 데이터 스트림이 어디에 Publish 될지 정하는데 쓰임
  - 토픽은 파일 시스템의 폴더의 개념과 유사하다.
- Producer는 토픽을 지정하고 메시지를 게시 (Post)
- Consumer는 토픽으로부터 메시지를 받아옴
- 카프카의 메시지는 디스크에 정렬되어 저장 되며, 새로운 메시지가 도착하면 지속적으로 로그에 기록 

### Kafka Partition
- Kafka Topic이 Partition으로 나뉜다.
- Partition은 디스크에 어떻게 저장이 되는지 가르는 기준이 된다.
- 카프카의 토픽은 파티션의 그룹이라고 할 수 있다.
- 디스크에는 파티션 단위로 저장
- 파티션마다 commit Log 가 쌓이게 된다
- 파티션에 쌓이는 기록들은 정렬이 되어 있고 불변(immutable)하다
- 파티션의 모든 기록들은 Offset이라는 ID를 부여받는다.

### Kafka Message
- 카프카의 메시지는 Byte의 배열
- 흔히 단순 String, JSON이나 Avro 사용 
- 크기에는 제한이 없지만, 성능을 위해서는 작게 유지하는것이 좋다
- 데이터는 사용자가 지정한 시간만큼 저장한다 (Retention Period), topic 별로 지정도 가능
- Consumer가 데이터를 받아가고 나서도 데이터는 저장된다
- Retention Period가 지나면 데이터는 자동으로 삭제 
  - 장애가 있을 경우, Retention Period 기간 안에 해결을 해야 한다.
  - Retention Period 지난 후에 문제가 생겼을 경우, Data Lake 까지 내려가서 데이터를 읽어와서 프로세싱 해야 한다

### Kafka Offset
- 보내는 메시지는 Offset을 가지게된다.
- Offset은 Partition안에 메시지가 순서대로 정렬되는데, 정렬된 순서 및 값을 의미한다.

### Kafka Broker
- 카프카의 서버로도 불린다.
- Topic을 전달하는 역할을 한다.

### Kafka Producer & Consumer
- Producer: 메시지를 전달하는 주체
- Consumer: 메시지를 전달받는 주체 

### Kafka Consumer Group
- Consumer를 묶어서 Consumer Group이라고 한다.
- Consumer 1개가 Consumer Group이 될 수 있고, 여러개가 될 수 도 있다.

### Zookeeper
- 카프카 클러스터의 여러 요소들을 설정하는데 사용됨
- 메타데이터 설정, 토픽 설정, Application Factor들을 조절하는데 사용