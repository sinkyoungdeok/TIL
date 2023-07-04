
- [0. ES 명령어 모음집](#0-es-명령어-모음집)
  - [1. alias 조회](#1-alias-조회)
  - [2. alias 변경](#2-alias-변경)
  - [3. 특정 필드(Array)의 길이가 1 이상인 문서 검색](#3-특정-필드array의-길이가-1-이상인-문서-검색)
- [1. 설치 명령어](#1-설치-명령어)
  - [관련 오픈소스 클론](#관련-오픈소스-클론)
  - [JENV 구성](#jenv-구성)
  - [elastic search 다운로드](#elastic-search-다운로드)
- [2. lucene](#2-lucene)
  - [lucene의 핵심 4가지](#lucene의-핵심-4가지)
  - [lucene이란](#lucene이란)
  - [lucene 기본 개념](#lucene-기본-개념)
  - [역색인 파일](#역색인-파일)
  - [예시](#예시)
  - [index file 란](#index-file-란)
  - [index 란](#index-란)
  - [index 과정](#index-과정)
  - [index searcher 란](#index-searcher-란)
  - [형태소 분석이란](#형태소-분석이란)
  - [입력 문자열에 대한 분석 과정](#입력-문자열에-대한-분석-과정)
- [3. elasticsearch 기본 개념](#3-elasticsearch-기본-개념)
  - [elasticsearch vs DBMS](#elasticsearch-vs-dbms)
  - [elasticsearch 설치](#elasticsearch-설치)
  - [elasticsearch Single Node 구성 - local](#elasticsearch-single-node-구성---local)
  - [elasticsearch Single Node 구성 - docker compose](#elasticsearch-single-node-구성---docker-compose)
  - [elasticsearch Cluster 구성 - local](#elasticsearch-cluster-구성---local)
  - [node roles 종류](#node-roles-종류)
  - [elasticsearch Cluster 구성 - docker compose](#elasticsearch-cluster-구성---docker-compose)
  - [elasticsearch Single node VS Cluster node](#elasticsearch-single-node-vs-cluster-node)
- [4. elk 구성](#4-elk-구성)
  - [kibana 기본 개념](#kibana-기본-개념)
  - [kiana 구성 - local](#kiana-구성---local)
  - [kibana 구성 - docker compose](#kibana-구성---docker-compose)
  - [Logstash 기본 개념](#logstash-기본-개념)
  - [Logstash 구성 - local](#logstash-구성---local)
  - [Filebeat 기본 개념](#filebeat-기본-개념)
  - [Filebeat 구성 - local](#filebeat-구성---local)
- [5. elasticsearch 기본 설정 및 구성](#5-elasticsearch-기본-설정-및-구성)
  - [Directory 구성](#directory-구성)
  - [Configuration](#configuration)
  - [노드의 역할 12가지](#노드의-역할-12가지)
  - [노드의 역할별 특징](#노드의-역할별-특징)
  - [node.roles 설정 및 확인](#noderoles-설정-및-확인)
  - [elasticsearch에서 잦은 오류 중 하나) disk full로 인한 오류](#elasticsearch에서-잦은-오류-중-하나-disk-full로-인한-오류)
  - [Cluster 구성 시 노드 노출](#cluster-구성-시-노드-노출)
  - [Cluster 환경 구성 시 묶어야 하는 노드들을 발견하기 위한 설정](#cluster-환경-구성-시-묶어야-하는-노드들을-발견하기-위한-설정)
  - [Heap 설정](#heap-설정)
  - [HTTP 통신 설정](#http-통신-설정)
  - [Transport 통신 설정](#transport-통신-설정)
  - [Discovery 설정](#discovery-설정)
  - [Gateway 설정](#gateway-설정)
  - [인덱스 생성 및 삭제에 대한 기본 설정](#인덱스-생성-및-삭제에-대한-기본-설정)
  - [x-pack 설정](#x-pack-설정)
  - [각종 설정 샘플](#각종-설정-샘플)
  - [elasticsearch Components](#elasticsearch-components)
  - [elasticsearch Components - Clsuter](#elasticsearch-components---clsuter)
  - [elasticsearch Components - Node](#elasticsearch-components---node)
  - [elasticsearch Components - Index](#elasticsearch-components---index)
  - [elasticsearch Components - Shard](#elasticsearch-components---shard)
- [6. elasticsearch 고급 설정](#6-elasticsearch-고급-설정)
  - [Setting의 우선순위](#setting의-우선순위)
  - [Settings - IndexScope](#settings---indexscope)
  - [Settings - NodeScope](#settings---nodescope)
  - [주요 Settings](#주요-settings)
  - [Circuit Breaker Settings (NodeScope)](#circuit-breaker-settings-nodescope)
  - [Cluster-level shard allocation and routing settings](#cluster-level-shard-allocation-and-routing-settings)
  - [exclude 설정 및 테스트](#exclude-설정-및-테스트)
  - [Cluster level shard allocation settings](#cluster-level-shard-allocation-settings)
  - [Shard rebalancing settings](#shard-rebalancing-settings)
  - [Disk based shard allocation settings](#disk-based-shard-allocation-settings)
  - [Shard allocation awareness](#shard-allocation-awareness)
  - [Shard allocation awareness 실습](#shard-allocation-awareness-실습)
  - [Index Recovery Settings](#index-recovery-settings)
  - [Indexing buffer settings](#indexing-buffer-settings)
  - [Node query cache settings](#node-query-cache-settings)
  - [Search settings](#search-settings)
  - [Thread pools](#thread-pools)
  - [주요 System 설정](#주요-system-설정)
  - [Closed Index 설정 변경](#closed-index-설정-변경)
- [7. Index Modules](#7-index-modules)
  - [Static Index Settings - 1. index.number_of_shards](#static-index-settings---1-indexnumber_of_shards)
  - [Static Index Settings - 2. index.number_of_routing_shards](#static-index-settings---2-indexnumber_of_routing_shards)
  - [Static Index Settings - 3. index.codec](#static-index-settings---3-indexcodec)
  - [Static Index Settings - 4. index.hidden](#static-index-settings---4-indexhidden)
  - [Dynamic Index Settings - 1. index.number_of_replicas](#dynamic-index-settings---1-indexnumber_of_replicas)
  - [Dynamic Index Settings - 2. index.refresh_interval](#dynamic-index-settings---2-indexrefresh_interval)
  - [Dynamic Index Settings - 3. index.max_result_window](#dynamic-index-settings---3-indexmax_result_window)
  - [Elasticsearch에서 검색을 실행하는 방법](#elasticsearch에서-검색을-실행하는-방법)
  - [scroll](#scroll)
  - [search_after 기능](#search_after-기능)
  - [Dynamic Index Settings - 4. index.max_inner_result_window](#dynamic-index-settings---4-indexmax_inner_result_window)
  - [Dynamic Index Settings - 5. index.analyze.max_token_count](#dynamic-index-settings---5-indexanalyzemax_token_count)
  - [Dynamic Index Settings - 6. index.max_terms_count](#dynamic-index-settings---6-indexmax_terms_count)
  - [Dynamic Index Settings - 7. index.routing.allocation.enable](#dynamic-index-settings---7-indexroutingallocationenable)
  - [Dynamic Index Settings - 8. index.routing.rebalance.enable](#dynamic-index-settings---8-indexroutingrebalanceenable)
  - [Scroll 실습](#scroll-실습)
  - [Analysis](#analysis)
  - [Text Analysis](#text-analysis)
  - [Analyzer란](#analyzer란)
  - [Analyzer 종류](#analyzer-종류)
  - [Analyzer의 구성 항목](#analyzer의-구성-항목)
  - [_analyze API 구조](#_analyze-api-구조)
  - [_analyze API Parameters](#_analyze-api-parameters)
  - [nori_tokenizer](#nori_tokenizer)
  - [nori_part_of_speech token filter](#nori_part_of_speech-token-filter)
  - [_analyze API를 이용한 NoriAnalyzer 테스트](#_analyze-api를-이용한-norianalyzer-테스트)
- [실전](#실전)
  - [Unassigned Shard 문제 해결](#unassigned-shard-문제-해결)
  - [Rolling Update 배포로 data 노드 배포 시 latency 생기는 현상 원인 및 해결 방법](#rolling-update-배포로-data-노드-배포-시-latency-생기는-현상-원인-및-해결-방법)
  - [Master, Data Node로만 구성했을 때 배포 시 Latency 튀는 현상 원인 및 해결 방법](#master-data-node로만-구성했을-때-배포-시-latency-튀는-현상-원인-및-해결-방법)
  - [Elasticsearch Warm Up](#elasticsearch-warm-up)
  - [Primary Shard, Replica Shard 성능 튜닝 관련 정리](#primary-shard-replica-shard-성능-튜닝-관련-정리)
  - [node_left.delayed_timeout 설정으로 latency 지연 해결](#node_leftdelayed_timeout-설정으로-latency-지연-해결)
    - [상황](#상황)
    - [배포 시 상황](#배포-시-상황)
    - [해결 방법](#해결-방법)
    - [설정](#설정)
- [data 노드 수와 shard 갯수 조절로 latency 해결](#data-노드-수와-shard-갯수-조절로-latency-해결)
  - [Background](#background)
    - [검색 원리](#검색-원리)
    - [Case1) 샤드 갯수 1, 단일 쿼리](#case1-샤드-갯수-1-단일-쿼리)
    - [Case 2) 샤드 갯수 1, 멀티 쿼리](#case-2-샤드-갯수-1-멀티-쿼리)
    - [Case 3) 샤드 갯수 n, 멀티 쿼리 (n: 코어의 갯수)](#case-3-샤드-갯수-n-멀티-쿼리-n-코어의-갯수)
  - [결론](#결론)
## 0. ES 명령어 모음집 

### 1. alias 조회 
```
GET /_cat/aliases?v
```

### 2. alias 변경
```
POST /_aliases
{
    "actions": [
        {
            "remove" : {
                "index": "commerce_search_2022-12-27t03211672111264",
                "alias": "commerce_search"
            },
            "add": {
              "index": "commerce_search_2022-12-26t20201672086032",
              "alias": "commerce_search"
            }
        }
    ]
}
```

### 3. 특정 필드(Array)의 길이가 1 이상인 문서 검색 
```
GET commerce_search_2022-12-26t09201672046443/_search
{
  "_source": ["admin_category_keywords"],
  "query": {
        "bool": {
            "must": [
                {
                    "range": {
                        "admin_category_keywords": {
                            "gt": 0
                        }
                    }
                }
            ]
        }
    }
}
```


## 1. 설치 명령어 

### 관련 오픈소스 클론
```
git clone https://github.com/apache/lucene.git
git clone https://github.com/elastic/elasticsearch.git
git clone https://github.com/HowookJeong/elasticsearch-analysis-arirang.git
git clone https://github.com/HowookJeong/arirang-analyzer-6.git
git clone https://github.com/HowookJeong/arirang.morph.git
```

### JENV 구성 
```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
brew install jenv
brew tap AdoptOpenJDK/openjdk
```

```
echo 'export PATH="$HOME/.jenv/bin:$PATH"' >> ~/.zshrc
echo 'eval "$(jenv init -)"' >> ~/.zshrc
source ~/.zshrc
```

jdk 설치 
```
brew install --cask adoptopenjdk11
```

jenv 추가 
```
jenv add /Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home
```

```
jenv enable-plugin export 
jenv global 11.0
jenv local 11.0
```


### elastic search 다운로드 
```
wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-8.3.1-darwin-aarch64.tar.gz
wget https://artifacts.elastic.co/downloads/kibana/kibana-8.3.1-darwin-aarch64.tar.gz
wget https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-8.3.1-darwin-aarch64.tar.gz
wget https://artifacts.elastic.co/downloads/logstash/logstash-8.3.1-darwin-x86_64.tar.gz

tar -xvzf elasticsearch-8.3.1-darwin-aarch64.tar.gz
tar -xvzf kibana-8.3.1-darwin-aarch64.tar.gz
tar -xvzf filebeat-8.3.1-darwin-aarch64.tar.gz
tar -xvzf logstash-8.3.1-darwin-x86_64.tar.gz
```


## 2. lucene

### lucene의 핵심 4가지
- 역인덱스 구조  
- 색인과 관련된 인덱스 writer
- 검색과 관련된 인덱스 searcher
- 형태소 분석과 관련이 있는 analyzer

### lucene이란 
- 오픈소스 기반의 검색 라이브러리
- 검색 엔진이 갖춰야 하는 기본 기능인 색인, 검색, 형태소 분석을 제공 
- elasticsearch, solr 는 lucene 기반의 분산 검색 엔진이다.

### lucene 기본 개념 
- 인덱스(Index) - 문서의 집합 
- 문서(Document) - 필드의 집합 
- 필드(Field) - Term의 집합
- 용어(Term)

### 역색인 파일
- Inverted Index Structure
- 인덱스를 색인어 기반의 검색을 생성하기 위해 색인어에 대한 통계를 저장하는 구조
- 즉, 용어에 대해서 문서를 나열하는 구조가 역인덱스라고 하는 인덱스 계열이다. 

### 예시

| Term | Frequency | Document |
| ---- | ---- | ---- |
| 안녕 | 1 | 1 |
| Elasticsearch | 3 | 1,2,3|
| 이용 | 2 | 1,3 |
| 개발 | 3 | 1,3 |
| 검색 | 2 | 1,3 |
| 개발자 | 3 | 1,2 |
| 쥬니어 | 1 | 2,3 |
| 개발시 | 1 | 3 |
| 자 | 1 | 3 |
| 시 | 1 | 3 |

위의 표는 아래 내용을 arirang을 이용해서 형태소 분석을 한 내용 ( es + arirang + kibana )
- 안녕하세요 Elasitcsearch를 이용해서 개발하고 있는 검색 개발자입니다.
- Elasticsearch를 배우고 싶은 쥬니어 개발자입니다.
- 쥬니어 개발자는 검색 개발시 Elasticsearch를 이용하면 좋나요?  

### index file 란
- index file formats은 segment file 이라고도 한다.
- segment file은 여러 index file 유형 중 하나이다.
- index file 에는 문서의 field, field data, term, frequencies, position, deleted documents 등과 같은 정보가 저장되고 색인과 검색 시 활용 된다.


### index 란 
- IndexWriter가 Index File 들을 생성하는 과정이다.
- 수정이 불가능한 immutable type이다.
- 여러개로 생성된 segments 파일들을 merge 라는 작업을 통해 하나의 색인 파일로 만드는 과정이 필요하다.
- 하나의 index는 하나의 indexWriter로 구성 
- IndexWriter -> DocumentWriter -> SegmentMerger -> Directory -> IndexWriter -> Analyzer -> Documents -> Fields

### index 과정 
![image](https://user-images.githubusercontent.com/28394879/179545225-3ebba32d-21d0-4eab-bca5-10423536dbc3.png)
1. 하나의 IndexWriter를 통해서 색인 요청이 들어온다.
2. IndexWriter가 segment file을 생성
3. 그다음 Document Writing 색인하는 과정이 만들어진다.
4. 색인이 완료된 후에 Commit을 통해서 FileWriting이 완료가 된다.
5. 1-4를 통해서 생성된 여러 segment file들을 SegmentMerger 클래스에서 합병하는 작업이 이루어진다.
6. 머지가 완료되면, 그 이전에 생성된 세그먼트 파일들은 삭제가 된다.
7. 그래서 항상 최신의 segment file이 존재한다.

### index searcher 란 
- IndexWriter 색인 후, IndexSearch로 검색하는 과정 
- IndexSearch는 IndexReader를 이용해서 검색 수행을 하게 된다.
- 하나의 Index에는 Segment 별로 N 개의 LeafReader가 존재 한다.
- Directory -> IndexWriter -> IndexReader -> IndexSearcher -> Query & CollectManager -> Sort -> Reduce -> Merge

### 형태소 분석이란
- 입력 받은 문자열에서 검색 가능한 정보 구조로 분석 및 분해 하는 과정 
- 구성 요소 
  - Analyzer
  - CharFilter
  - Tokenizer
  - TokenFilter
- Analyzer: 하나의 Tokenizer와 다수의 TokenFilter로 구성되어 있다.
- CharFilter: 형태소 분석을 하는 과정에서 사전에 먼저 입력된 텍스트에 대해서 불필요한 문자들을 제거하는 역할을 수행한다.
- InputText -> Charater Filter -> Filtered Text -> Tokenizer -> Tokens -> Token Filter -> Filtered Tokens -> Output Tokens
  - Token Filter는 정의 된 순서에 맞춰 적용 되기 때문이 적용 시 순서가 중요 
  - 루씬에서 제공 하고 있는 한글 처리를 위한 Analyzer 는 CJK와 Nori Analyzer가 있다. 


### 입력 문자열에 대한 분석 과정 
![image](https://user-images.githubusercontent.com/28394879/179551568-e49fbf26-7780-4ace-987a-64038976d8ed.png)
- Position 정보는 0부터 시작해서 1씩 증가하는 구조
- Offset은 Token의 Start와 End에 대한 정보를 가짐 
- 추출된 Token, Position, Offset 정보를 포함해서 Term이라고 하고, 이를 이용해서 강조와 동의어에 활용한다.


## 3. elasticsearch 기본 개념

### elasticsearch vs DBMS
| DBMS | Elasticsearch |
| --- | --- |
| DBMS HA 구성(MMM, M/S) | Cluster |
| DBMS Instance | Node | 
| Table | Index |
| Partition | Shared / Routing |
| Row | Document |
| Column | Field |
| Row of columnar data | Serialized JSON document |
| Join | Nested or Parent/Child |
| SQL(DML) | QueryDSL |
| Index | Analyzed |
| Primary Key | _id |
| Configuration | elasticsearch.yaml & Settings |
| Schema | Mappings |

### elasticsearch 설치 

local 에 설치 
```
wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-8.3.1-darwin-aarch64.tar.gz
tar -xvzf elasticsearch-8.3.1-darwin-aarch64.tar.gz
cd elasticsearch-8.3.1
bin/elasticsearch # 일반 실행 
bin/elasticsearch -d -p pid # 백그라운드 실행 

curl http://localhost:9200

pkill -F pid # 종료 
```

docker 에 설치 
```
# m1, intel 둘다 됨 
docker run -d -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.15.0
```

### elasticsearch Single Node 구성 - local
설정 작성 
```
vi config/elasticsearch.yml

# 빈곳에 밑에 내용을 작성 
cluster.name: kdsin
node.name: single-node
discovery.type: single-node
```
실행 
```
bin/elasticsearch -d -p PID
```

로그 확인 
```
curl http://localhost:9200/_cat/nodes\?format\=json\&pretty
```

### elasticsearch Single Node 구성 - docker compose 
```
version: '3.7'
services:
    es-singlenode:
        image: docker.elastic.co/elasticsearch/elasticsearch:7.15.0
        container_name: es-singlenode
        environment:
            - node.name=single-node
            - cluster.name=kdsin
            - discovery.type=single-node
        ports:
            - 9200:9200
            - 9300:9300
        networks:
            - es-bridge
networks:
    es-bridge:
        driver: bridge
```

```
docker-compose -f es-single-node.yml up -d
```

### elasticsearch Cluster 구성 - local 

```
cp -rf elasticsearch-8.3.1 es1
cp -rf elasticsearch-8.3.1 es2
cp -rf elasticsearch-8.3.1 es3

es1/bin/elasticsearch -d -p PID
es2/bin/elasticsearch -d -p PID
es3/bin/elasticsearch -d -p PID

curl localhost:9200/_cat/nodes?v # 실행된 es 3대 확인 

pkill -F es1/pid 
pkill -F es2/pid 
pkill -F es3/pid 
```

```
vi es1/config/elasticsearch.yml 
cluster.name: kdsin
node.name: es1
node.roles: [ "master" ]

vi es2/config/elasticsearch.yml 
cluster.name: kdsin
node.name: es2
node.roles: [ "master", "data"]

vi es3/config/elasticsearch.yml 
cluster.name: kdsin
node.name: es3
node.roles: [ "master", "data"]

es1/bin/elasticsearch -d -p PID
es2/bin/elasticsearch -d -p PID
es3/bin/elasticsearch -d -p PID

curl localhost:9200/_cat/nodes?v # 실행된 es 3대 확인 

pkill -F es1/pid 
pkill -F es2/pid 
pkill -F es3/pid 
```

### node roles 종류
- data(-d): 
- ingest(-i): 
- remote_cluster_client(-r): 각각의 서로 다른 클러스터들 간에 데이터를 함께 조회할 수 있도록 해주는 역할을 함 
- coordinating node only(-): 데이터를 가질 수 없고, 실제 request response 역할을 함 
- 등등 


### elasticsearch Cluster 구성 - docker compose
```
mkdir kdsin-data1
mkdir kdsin-logs1
mkdir kdsin-data2
mkdir kdsin-logs2
mkdir kdsin-data3
mkdir kdsin-logs3

docker-compose -f cluster-node.yml up

curl localhost:9200/_cat/nodes?format=json&pretty
```

분리해서 실행 방법 (위 처럼 한 파일에 쓰는 방법보다 분리하는게 더 좋음)
```
docker-compose -f docker-compose-cluster-node1.yml up -d
docker-compose -f docker-compose-cluster-node2.yml up -d
docker-compose -f docker-compose-cluster-node3.yml up -d
```


### elasticsearch Single node VS Cluster node
- Single Node
  - 별 다른 설정 없이 실행 
  - 테스트로 사용하는 경우에 사용
- Cluster 
  - cluster.name, node.name, discovery.seed_hosts, cluster.initial_master_nodes, node.roles 설정 필요 
  - 운영 환경에서 사용 


## 4. elk 구성

### kibana 기본 개념 
- 저장된 데이터를 조회하고 분석할 수 있도록 기능을 제공하는 도구 
- Elastic사에서는 Kibana를 Elasticsearch의 공식 interface라고 이야기함 
- 초기: Dashboard, Visualization을 제공하기 위한 용도
- 현재: Elastic Stack을 운영하고 모니터링하는 용도까지 확대 
- Kibana는 단독으로 사용할 수 있는 도구가 아니고, elasticsearch 와 함께 사용 해야 한다.
  - elasticsearch 없이, 실행하면 오류 뜬다.

### kiana 구성 - local 
```
# elasticsearch 먼저 실행 
bin/elasticsearch -d -p PID

# kibana 실행 
bin/kibana

curl localhost:5601
```

### kibana 구성 - docker compose
```
docker-compose -f 1-single-node/es-single-node.yml up -d
docker-compose -f 3-elk/docker-compose-kibana.yml up -d
```

``` 
# 볼륨 활용 
docker-compose -f 1-single-node/es-single-node.yml up -d
docker-compose -f 3-elk/docker-compose-kibana-volume.yml up -d
```

### Logstash 기본 개념 
- 다양한 소스 데이터를 가공해서 Elasticsearch로 적재하는 도구 
- 다양한 Input, Filter, Output 의 Pipeline 구조를 가짐
- 이벤트 데이터에 대한 스트림을 필터할 수 있는 다양한 Codec 사용 가능 
- 자원을 무겁게 사용하기 때문에 Agent 로 사용하기 보다는 데이터를 받아 정제/가공 후 적재하는 Ingestor 역할로 활용하는게 더 좋다.
- Pipeline: Input -> Filter -> Output

### Logstash 구성 - local

elasticsearch에서 남긴 log를 logstash에서 input file로 읽고 output으로 elasticsearch로 전송.
```
vi elasticsearch-7.15.0/config/log4j2.properties
# status = error -> status = info 로 변경 / 남기는 로그가 많아지도록 설정 

# elasticsearch 설정 
bin/elasticsearch -d -p PID

bin/logstash -f 3-elk/logstash-eslog.conf
```

### Filebeat 기본 개념 
- Beats라는 플랫폼을 사용하는 Stack 들이 많이 잇다.
- Beats는 Shipper Agent 역할을 한다.
- Official Beats 와 Community Beats 들이 다양하게 존재한다.
- Logstash 보다 리소스를 적게 사용하기 떄문에 Agent로 많이 사용 
- Pipeline: Input -> Module -> Processor -> Output
  - Module: 다양한 Input Source 데이터에 대한 수집, 시각화를 위한 형태로 만들어서 제공하기 위한 유틸성 패키지
  - Processor: 입력 받은 데이터 이벤트의 메시지를 전역으로 처리하기 위해 정의하는 도구 

| Filebeat | Logstash |
| --- | --- |
| Input | Input |
| Module | Codec |
| Processor | Filter |
| Output | Output |


### Filebeat 구성 - local 
```
filebeat-7.15.0-darwin-x86_64/filebeat -e -c 3-elk/filebeat-eslog.yml
```


## 5. elasticsearch 기본 설정 및 구성

### Directory 구성 
- bin: 실행 스크립트
- config: 설정 파일
- data: index
- jdk.app: jdk
- lib: elasticsearch 와 dependency jar
- logs: elasticsearch 실행 로그
- modules: elasticsearch 에서 사용하는 모듈 jar
- plugins: elasticsearch 에서 사용하는 플러그인 jar
- data와 logs는 path.data, path.logs 설정으로 변경 가능
- config는 classpath 기본 위치로 사용 

### Configuration
- Elasticsearch를 구성하기 위한 기본 설정 - elasticsearch.yml
- 단일 노드로 구성 할 경우 기본 값이 어떻게 되는 지 정도는 알고 있으면 유리하다 
- cluster.name 과 node.name은 클러스터와 노드를 잘 운영하기 위해 반드시 설정
- 설정하지 않을 경우 cluster.name은 "elasticsearch"로 지정이 되고 node.name은 hostname으로 설정됨
- cluster.name
  - 모든 노드와 클러스터 이름이 공유 되었을 때 연결 가능
  - 같은 클러스터 이름을 사용하지 않도록 주의해야됨 
- node.name
  - 노드의 용도와 목적을 이해하기 위한 사람이 읽을 수 있는 식별자로 작성 해야 함. 
- 노드의 역할에 대한 설정이 있는데 이 또한 명시적으로 설정하는게 좋다
- 노드명에 역할을 명시적으로 같이 부여를 해서 가독성을 좋게 구성하는 편

### 노드의 역할 12가지
1. master
   - 클러스터의 상태를 변경
   - 클러스터의 상태를 모든 노드에 게시
   - 전역 클러스터 상태를 유지
   - 샤드에 대한 할당과 클러스터 상태 변화 게시 
2. data
   - 문서의 색인 및 저장
   - 문서의 검색 및 분석 
   - 코디네이팅
3. data_content
   - 색인과 검색 요청이 많은 경우     
4. data_hot
   - 색인에 대한 요청이 많으며 자주 검색 요청을 하게 되는 경우
   - time series 데이터 (logs, metrics 등) 
5. data_warm
   - time series 데이터를 유지하고 있는 노드로 업데이트가 거의 없고 드물게 요청하는 경우 
6. data_cold
   - time series 데이터를 유지하고 있는 노드로 업데이트가 되지 않고 거의 요청을 하지 않는 데이터를 보유 
7. data_frozen
   - time series 데이터로 요청도 업데이트도 없는 경우  
8. ingest
   - 클러스터 내 적어도 하나 이상의 ingest 역할을 하는 노드 필요 (ingest pipeline 기능을 사용하기 위해서 필요)
   - master와 data 노드와 같이 사용 하지 않는 것을 추천
   - 색인 전에 데이터에 대한 변환하여 색인 되도록 함 
9. ml
   - xpack 에서 제공 하는 machine learning 기능을 사용하기 위해서는 최소 하나 이상의 노드 역할을 구성 해야함 
10. remote_cluster_client
   - 원격으로 구성된 cluster에 연결 하여 원격 client 노드 역할을 수행     
11. transform
   - 색인된 데이터로부터 데이터에 대한 pivot이나 latest 정보를 별도 데이터로 변환 해서 tranform index로 저장
12. voting_only 
   - 마스터 노드를 선축하기 위한 전용 노드 
   - note.roles: [master, voting_only] 로 선언은 하며 마스터 노드의 역할은 수행 
   - 마스터 노드로 선출은 되지 않는다 (다른 역할을 부여 할 수도 있다)
   - voting_only노드로 사용하기 위해서는 최소 master노드 역할을 부여해야함
- 추가적인 역할로 coordinating node가 있다. node.roles에 아무것도 선언하지 않으면 이것으로 선언됨
- coordinating node는 주로 search request 용도로 사용하거나 bulk indexing request 용도로 사용한다.
- 어떤 노드던간에 기본적으로 coordinating node의 역할은 수행한다.

### 노드의 역할별 특징
- 노드의 역할을 많이 나누어 놓았지만, elasticsearch에서 자동으로 되는건 없다.
- 기본 역할을 제외 하고 보면 Data tier개념이 들어 간 것이다.
- 각 tier 별로 hardware 스펙을 동일하게 해야 된다.
- 각 노드별 표시 
  - master(m)
  - data(d)
  - data_content(s)
  - data_hot(h)
  - data_warm(w)
  - data_cold(c)
  - data_frozen(f)
  - ingest(i)
  - remote_cluster_client(r)
  - ml(l)
  - transform(t)
  - voring_only(v)
- 노드의 역할 정의는 shard allocation awareness에서 사용된다. 설정으로는 아래 내용이 추가가 되었기 때문에 사용이 가능하다.
```
index.routing.allocation.include_tier
            _tier
            Match nodes bythe node's data tier role
``` 


### node.roles 설정 및 확인
- 아무런 설정을 하지 않은 경우 
```
node.master: true
node.data: true
node.ingest: true
node.transform: true
node.ml: false
node.voting_only: false
node.remote_cluster_client: true
``` 

### elasticsearch에서 잦은 오류 중 하나) disk full로 인한 오류
- 오류 막는 방법: 저장 공간이 충분한 경로에 색인 데이터와 로그를 기록하고 저장할 수 있도록 경로를 설정한다
- path.data: 다중 data path 구성이 가능 하다 

```
path: 
  data: /var/lib/elasticsearch
  logs: /var/log/elasticsearch
  path.data: var/lib/elasticsearch
  path.logs: var/log/elasticsearch
```

```
path:
  data:
    - /mnt/elasticsearch_1
    - /mnt/elasticsearch_2
    - /mnt/elasticsearch_3


path.data: ["/mnt/elasticsearch_1","/mnt/elasticsearch_2", "/mnt/elasticsearch_3"]
```

- Data에 대한 tier 구성을 따로 하지 않을 경우 -> Data 노드에 대한 Disk 성능과 기타 다른 리소스의 성능은 동일하게 맞춰서 사용해야 함 
  - 특정 disk는 ssd를 쓰는데, 특정 disk는 hdd를 사용할 경우 색인 질의 포퍼먼스에 대한 차이가 발생해 병목 발생 및 시스템이 죽는 현상이 발생할 수 있다.



### Cluster 구성 시 노드 노출 
- Cluster 구성 시 네트워크 상의 노드들을 노출 시키기 위해 network.host 설정 
  - 인스턴스에 부여된 IP 주소를 작성하면 된다
- Docker로 클러스터 구성시: network.host 와 network.publish_host 설정
  - Single node 구성 시: network.host: "0.0.0.0" 으로 구성 

### Cluster 환경 구성 시 묶어야 하는 노드들을 발견하기 위한 설정 
- `discovery.type`
  - cluster.initial_master_nodes 와 함께 사용할 수 없음
  - 이 설정이 등록 되어 있으면 single-node 라는 값으로 지정이 되고 단일 노드 구성이 이루어짐
- `discovery.seed_hosts`
  - Clustering을 위한 노드 목록 작성
  - 이전 unicast 설정과 유사 
- `cluster.initial_master_nodes`
  - master 역할을 가진 노드 목록 작성
  - master 구성은 최소 3개 이상의 쿼럼 구성을 추천
- 예) data노드를 하나 더 추가해야 하는 경우
  - discovery.seed_hosts에는 추가할 수 없다.
  - 신규 추가하려는 노드는 cluster.initial_master_nodes에 설정하면 자동으로 추가된 노드는 master노드로 ping request 보내게 되고, 
  - 이렇게 추가된 노드는 master노드가 이미 실행중인 다른 노드들에게 broadcast을 해서 통신이 가능하도록 설정을 하게 된다 

### Heap 설정
- `bootstrap.memory_lock: true`
  - 보통 시스템 인스턴스 메모리사이즈의 절반을 사용한다.
  - 최대 31GB이상은 설정하지 않는다.
  - elasticsearch는 JVM 위에서 동작하기 때문에 실행시 heap 설정을 해야됨
  - 이 경우, 시스템 메모리를 전용으로 안정적으로 사용하기 위해 memory_lock을 설정 해야 된다

### HTTP 통신 설정
- HTTP 는 클라이언트간의 통신, Transport는 노드간 통신 설정
- `http.port`
  - 기본 9200 포트로 선언 되며, 지정된 값으로 할당
  - elasticsearch는 HTTP 통신과 Transport 통신 둘다 지원
  - 노드 간 통신은 transport로 이루어지며, 통신을 위한 port 설정과 content 전송에 따른 compression 설정 등이 가능함
- `http.max_content_length`
  - RESTful API 요청 시 실제 저장된 문서의 크기가 클 경우 -> 크기를 적당히 조절
  - 100MB (HTTP Request Body Size)를 넘어가는 경우 -> 크기를 적당히 조절
  - 주의: 네트워크의 bandwidth를 많이 사용하지 않기(네트워크 병목으로 성능 저하)
- `http.max_initial_line_length`
  - HTTP URL의 최대 크기 (기본 값 4KB)
- `http.max_header_size`
  - 허용 하는 최대 Header 크기 (기본 값 8KB)
- `http.compression`
  - 기본 false 이지만 true로 설정하는 것을 추천
  - B2C 형 서비스 인 경우 API Gateway를 별도로 두기 때문에 true로 설정 해서 network 병목을 최소화 할 수 있음
- `http.compression_level`
  - 기본 3 설정, CPU 자원에 대한 소비가 많을 수 있기 떄문에 그대로 사용 권장
  - 최소 1부터 최대 9까지 설정 가능 
- `http.cors.enabled`
  - 기본 false로 설정
  - 이 설정을 통해서 elasticsearch 로의 요청에 대한 origin 점검 가능
  - true로 설정 시 허용할 origin 을 등록한다
- `http.cors.allow-origin`
  - 요청에 대해 허용할 origin 등록 (정규 표현식으로 등록 가능)
  - 요청 시 header에 origin 정보를 담아서 요청해야 함 
  - 위 두 설정은 Reqeust시 Header값으로 `"origin:http://localhost:9200"`을 설정해서 요청에 대한 유효성 검사를 함
  - elasticsearch.yml 에 설정한 값과 client에서 요청시 header에 실어 보내는 값이 같아야 요청이 허용됨 

### Transport 통신 설정 
- `transport.port`: 기본 9300으로 설정이 되며, 노드간 통신에 사용
- `transport.compress`: 기본 false이며, local 통신이 기본이라 false로 설정해서 사용하는 것을 추천 

### Discovery 설정 
- 클러스터 구성 시, 각 노드를 발견하고 합류 시키기 위한 설정 

### Gateway 설정
- `discovery.seed_hosts`, `cluster.initial_master_nodes`와 같이 노드를 발견하는 과정이 있었다면 이번엔 실행 이후 혹은 재시작시 운영에 필요한 설정이다.
- 실행 이후 또는 클러스터 재시작 시 운영 해야 하는 설정 
- `gateway.expected_data_nodes`
  - 클러스터가 재시작 될 때 in-service 전에 확인 하기 위해 활용
  - 기본 값은 0 이지만 in-service를 위해 최소 실행 된 data.node의 수를 지정하여 사용
- `gateway.recover_after_data_nodes`
  - 클러스탁 재시작 될 때 최소 xx개의 data node가 실행 된 후에 recover가 될 수 있도록 하는 설정이다.
  - 재시작 시 문제점: 모든 master, data 노드가 클러스터에 join 되면서 동시에 recovery 작업을 수행 하게 되면 리소스를 많이 사용하게 되면서 hang이 걸릴 수도 있음
  - 최소 규모의 데이터 노드가 실행 된 후에 recovery를 수행 하도록 명시적으로 선언 하는것

### 인덱스 생성 및 삭제에 대한 기본 설정
- `action.auto_create_index`
  - 기본 true이기 떄문에 신경 쓰지 않아도 되지만,
  - 불필요한 index의 생성을 방지하고 싶다면 이 설정을 확인 하고 false로 설정 
- `action.destructive_requires_name`
  - 기본 false이기 때문에 누구나 생성된 index 삭제 가능 
  - wildcard(i)로 삭제 요청 시 전체 index가 삭제 될 수 있음
  - 명시적으로 인덱스 이름으로 삭제 요청을 하도록 하고 싶다면, 이 설정을 확인 하고 true로 설정


### x-pack 설정 
- `xpack.monitoring.collection.enabled`
  - 기본 false로 설정
  - elasticsearch에 대한 모니터링을 하고자 한다면 true로 설정
  - ture로 설정 시 아래와 같은 시스템 index가 설정됨 
  - `monitoring-es-${monitoring.template.version}-{%yyy.MM.dd}


### 각종 설정 샘플
```
./elasticsearch.yml.template
```


### elasticsearch Components
- lucene과 비슷하다.
- Cluster > Node > Index > Shard > Document

### elasticsearch Components - Clsuter
- cluster.name 설정이 가장 중요
- 기본 값은 elasticsearch
- cluster 구성 시 node 역할에 따른 구성 필수
- master node 에 대한 quorum 구성 필수 
  - split brain 에 대한 오류를 예방할 수 있기 때문에
  - 클러스터 구성 시 가장 중요한 설정 

```
cluster.name
discovery.type # 싱글노드를 위한 설정
discovery.seed_hosts # 클러스터를 위한 설정
cluster.initial_master_nodes # 클러스터를 위한 설정

# discovery.type, cluster.initial_master_nodes 는 같이 설정 할 수 없다 
```


### elasticsearch Components - Node
- elasticsearch 인스턴스가 시작 될 때 마다 실행
- 노드들의 모음이 Cluster
- 단일 노드로도 실행가능 (= 단일노드 클러스터)
- 설정 기본: node.name 과 node.roles
- 노드의 이름을 지정하고 역할을 정의 해서 용도와 목적에 따라 운영 
- 가장 많이 사용하는 노드의 역할: master노드, data노드, coordinating 노드 
- master노드
  - 개별 노드와 인덱스에 대한 상태 관리와 메타 관리를 담당
  - 특성에 맞춰 CPU, MEM에 대한 시스템 자원이 충분해야함
- data노드
  - 색인한 문서의 shard가 저장되어 있는 노드
  - 문서에 대한 CRUD와 검색, 집계와 같은 데이터 작업처리
  - Disk I/O, CPU, MEM 등에 대한 자원이 충분해야함
- coordinating 노드
  - 검색 요청이나 대량 색인 요청에 대한 라우팅 역할 (불필요한 요청을 master나 data노드에서 처리할 필요가 없고 부하를 생성할 필요가 없기 떄문)
  - master노드와 유사하게 CPU, MEM에 대한 자원이 충분하면 좋음

### elasticsearch Components - Index
- 분산된 Shard 에 저장된 문서들의 논리적 집합 
- 물리적으로는 Shard 하나가 하나의 독립된 Index로 동작하며, 루씬에서 보면 IndexWriter가 Shard당 하나씩 생성
- Primary shard와 Replica shard로 구성되며, Data Node에만 위치한다
- 데이터 유형에 따라 Hot, Warm, Cold, Frozen 과 같이 분리해서 ILM을 이용해서 용량에 따른 rolling 도 가능
- Lucene기준의 Index를 Elasticsearch 에서는 Shard라고 함

### elasticsearch Components - Shard
- 물리적인 데이터가 저장 되어 있는 단위
- Indexing 요청이 있을 때 분산된 노드에 위치한 shard로 문서를 색인
- Index의 shard는 특정 node의 역할에 맞춰 배치 가능, 이런 기능이 shard allocation awareness 설정으로 적용이 가능하며, index setting 정보를 통해서 사용
- health status 정의는 shard의 상태를 가지고 정의 내림 
- 그린: 모든 샤드가 정상적으로 할당 되었을 때 상태
- 옐로우: Primary shard는 정상적으로 할당이 되었으나 replica shard중 일부라도 할당이 되지 않았을 경우의 상태 (서비스는 정상적으로 동작 O)
- 레드: Primary shard중 하나 이상이 할당 되지 않았을 경우의 상태 (서비스 정상저긍로 동작 X)
- Primary Shard
  - 색인 요청이 들어오면 가장 먼저 생성해서 문서를 저장하게 되는 Shard (=원본 데이터)
  - 이를 기반으로 데이터를 복제하여 활용
  - 색인 성능을 개선하기 위한 포인트로 활용
  - Primary shard가 하나 밖에 없으면, index writer가 하나의 shard에만 계속 색인하기 때문에 분산 검색 엔진의 특징을 제대로 활용할 수 없다. 
  - 그래서, Data 노드의 크기와 CPU 코어 크기를 고려해서 primary shard 크기를 설정
  - 동적으로 크기를 변경할 수 없다, 초기 index 생성시 한번 정의된 설정으로 결정됨
- Replica Shard
  - Primary shard를 기준으로 복제 하는 shard
  - 검색 성능을 개선하기 위한 용도로 활용 
  - 동적으로 크기를 변경할 수 있다. 

## 6. elasticsearch 고급 설정 

### Setting의 우선순위
- 기본 setting 정보를 그대로 사용하는 것도 좋으나, 알아두면 좋은 Setting 정보 

1. Transient
   - 1회성 설정으로 cluster 재시작 시 리셋
2. Persistent
   - 영구 설정으로 cluster 재시작이 되어도 유지
3. elasticsearch.yml
   - 이 설정은 로컬 구성으로만 사용하는 것을 추천
   - dynamic setting을 통해서 클러스터 설정을 관리
   - 각 노드 별 설정이 다르면 문제 발생
4. Default
   - 코드 상에 정의 되어 있음 

- static 설정은 elasticsearch.yml 에 구성하며, 클러스터가 시작 전에 설정 되어야 한다  
- 그리고 모든 Settings 은 Static 이거나 Dynamic 속성을 가진다

### Settings - IndexScope
```
PUT /my-index-000001/_settings
{
  ...
}
```

### Settings - NodeScope
```
PUT _cluster/settings
{
  "transient": {
    ...
  }
}
```

```
PUT _cluster/settings
{
  "persistent": {
    ...
  }
}
```


### 주요 Settings
- Path settings 
  - path.data
  - path.logs
  - 위 설정은 인덱스 데이터와 로그 데이터에 대한 저장소 설정을 하게 된다
- Cluster name setting
- Node name setting
- Network host settings
  - network.host
  - 위 설정은 개발과 테스트 환경에서는 127.0.0.1 과 같은 루프백 주소만 바인딩 되지만
  - 운영 환경에서는 일반적인 네트워크 설정으로 구성 한다.
- Discovery setting
  - discovery.seed_hosts
  - cluster_initial_master_nodes
  - 운영 환경으로 넘어 갈 때 중요 한 설정
  - 클러스터의 노드들을 검색 할 수 있는 정보와 마스터 노드를 선택할 수 있는 정보를 구성한다
- jvm.options settings
  - Heap size setting
    - System 리소스의 50%로 설정
    - 31GB가 넘어가지 않도록 구성
    - 설정은 환경변수로 set을 하거나 jvm.options 파일을 수정 (ES_JAVA_OPTS="-Xms5g-Xmx2g")
  - JVM heap dump path setting
    - Heap OutOfMemory 에러 발생 시 heap dump 로그를 남기기 위한 경로 설정
    - 기본 값을 그대로 사용 하며 수정은 많지 하지 않음
  - GC logging settings
    - 기본 설정은 GC 옵션이 enable되어 있다
    - 기본 값을 그대로 사용하며 수정을 많이 하지 않는다
  - Temporary directory settings
    - JVM에서 사용 하기 위한 tmp 경로 설정
    - ES_TMPDIR환경 변수로 설정 하거나 jvm.options에서 설정
    - 설정 하지 않을 경우 Elasticsearch 내 TempDirectory 클래스를 이용해서 생성
    - 기본 값을 그대로 사용하며 수정을 많이 하지 않는다
- Cluster backups
  - 장애 발생시 데이터 유시실을 예방하기 위한 설정으로 SLM(Snapshot Lifecycle Management)을 통해서 백업



### Circuit Breaker Settings (NodeScope)
- OutOfMemory 에러가 발생 하지 않도록 안전장치를 걸어 두는 것
- 검증된 설정 값이 기본적으로 구성 되어 있지만, 문제 발생 시 설정 튜닝 (메모리 사용량 제한)
- Parent circuit breaker
  - 전체 heap size에 대한 total limit설정
  - indices.breaker.total.use_real_memory (s): 기본 true 이다, 설정이 false 이면 70%로 설정 되고, true이면 95%로 설정 된다
  - indices.breaker.total.limit
- Field data circuit breaker
  - Field data cache (aggregation, sorting에 활용)를 상요 시 과도한 heap memory 사용 방지 목적
  - indices.breaker.fielddata.limit: 기본 JVM Heap size의 40%로 설정
  - indices.breaker.fielddata.overhead 
    - 기본 40%로 설정하지만, 실제 도달하면 heap memory가 부족할 수 있기 떄문에 overhead 설정을 통해서 미리 차단
    - 기본 값은 1.03 (fielddata 크기가 1이면 1.03으로 집계됨)
- Request circuit breaker
  - Aggregation과 같은 요청에서 메모리 사용량 초과 방지
    - indices.breaker.request.limit: 기본 JVM Heap 크기의 60% 로 설정
    - indices.breaker.total.limit: 기본 값은 1 

### Cluster-level shard allocation and routing settings
- shard를 노드에 어떻게 할당 할 것인지에 대해 정의하는 설정
- recovery, replica allocation, rebalancing 등이 클러스터 내 노드가 추가/삭제 될 때 발생
- 마스터 노드는 이와 같이 클러스터를 운영/관리 하기 위해 샤드들을 어떤 노드에 할당하고 이동시킬지를 결정 
- 실제상황 
  - 클러스터에 대한 재시작 시 shard recovery와 rebalancing 때문에 재시작이 되지 못하고 빈번하게 죽거나 재시작 되는 현상이 발생 할 수 있다.
  - 따라서 재시작 할 때는 환경에 맞는 절차를 만들어 놓고 실행하기
  - 이런 문제가 발생하지않도록 할 수 있는것: gateway설정(gateway.expected.nodes )을 하면 예방할 수 있다. 

### exclude 설정 및 테스트 
- shard allocation: 설정을 위한 기능, 장애 발생시 문제가 있는 노드에 shard 할당 되는 것 방지 
- ex) 특정 노드가 장애 발생했을 때, 해당 노드를 exclude시켜 신규 생성 인덱스에 대한 shard 할당 방지
```
PUT _cluster/settings
{
  "transient": {
    "cluster.routing.allocation.exclude._ip": "장애발생노드 IP"
  }
}
```
- Cluster shard limit 설정을 통해 노드 별 shard 수를 제한하고 문제 발생 예방 할 수 있다. 
  - cluster.max_shards_per_node
  - 기본 data 노드 당 1000개의 shard를 가질 수 있다
  - Open된 모든 shard를 포함 한다
- Shard routing allocation 설정은 생성 시 지정된 설정이 우선 하기 때문에 교차 설정 불가능 (상호배타적인 구성X)
- Shard allocation 설정은 4가지 형태로 제공
  - Cluster-level shard allocation settings: 방금 위에서 살펴본 설정
  - Disk-based shard allocation settings: disk 사용에 따라서 shard를 배치시키는 설정
  - Shard allocation awareness and Forced awareness: 노드 자체에 attribute설정을 이용해서 특정 index의 shard들이 배치되도록 하는 설정
  - Cluster-level shard allocation filtering: exclude 설정과 유사


### Cluster level shard allocation settings
- `cluster.routing.allocation.enable`
  - 노드가 재시작 될 때 local primary shard에 대한 recovery에 영향을 주지 않으며, 할당 되지 않은 replica shard에 대한 primary shard를 즉시 recovery 함
  - all(기본설정) / primaries / new_primaries (신규 인덱스의 primary shard) / none
- `cluster.routing.allocation.concurrent_incoming_recovieries: 2` : 동시 incoming recovery가능한 노드 수 
- `cluster.routing.allocation.concurrent_outcoming_recovieries: 2` : 동시 coutcoming recovery가능한 노드 수
- `cluster.routing.allocation.node_concurrent_recoveries`
  - 위 두개의 설정을 한번에 구성
- `cluster.routing.allocation.node_initial_primaries_recoveries: 4`: primary shard의 recovery 설정
- `cluster.routing.allocation.same_shard.host`
  - 하나의 장비에 여러개의 elasticsearch 인스턴스를 구성 할 때 같은 shard 가 위치 할 수 있도록 설정함 
  - (기본 false로 같은 샤드는 배치 불가능)

### Shard rebalancing settings
특정 노드에 인덱스의 샤드가 집중적으로 위치 하지 않도록 하여 균형을 이루게 하는 설정 
- `cluster.routing.rebalance.enable`
  - rebalance 를 적용할 대상 지정
  - all(기본) / primaries / replicas / none
- `cluster.routing.allocation.allow_rebalance`
  - rebalance 에 대한 동작을 허용할 대상을 지정
  - always / indices_primaries_active / indices_all_active (기본)
- `cluster.routing.allocation.cluster_concurrent_rebalance`
  - 클러스터 기준으로 동시에 rebalancing 할 shard의 수를 설정 (기본 2개)
- 위 설정들은 기본 설정으로 해도 하는것을 추천 


### Disk based shard allocation settings
노드에 있는 disk의 용량에 따라 shard를 배치 시키는 설정  
elasticsearch의 경우 가장 많이 경험하는 오류가 disk full에 따른 장애  
elasticsearch애 log를 모니터링 해서 watermark 오류 에러나 경고 발생시 바로 대응하거나, 상시 disk usage를 모니터링해서 예방해야함 
- `cluster.routing.allocation.disk.threshold_enabled`: 기본 true이며, disk allocation decider를 사용 
- `cluster.routing.allocation.disk.watermark.low`
  - 기본 disk usage 85%로 구성
  - 85$가 되면 shard가 더 이상 할당 되지 않지만
  - 이 설정은 새로 만들어지는 primary shard에 대해서는 적용이 되지 않고 replica shard에 대해서만 적용 
  - usage가 아닌 남아 있는 여유 공간 설정으로도 가능 
- `cluster.routing.allocation.disk.watermark.high`
  - 기본 disk usage 90% 이며, 초과 시 노드에 있는 샤드 재배치 시도 
  - usage가 아닌 남아 있는 여유 공간 설정으로도 가능 
- `cluster.routing.allocation.disk.watermark.flood_stage`
  - 기본 95%로 설정 되어 있으며, disk usage가 설정을 넘은 노드가 있으면 
  - 읽기 전용으로 자동 전환 되고, disk usage가 떨어지게 되면 자동으로 해제 
- `cluster.info.update.internal`
  - 30초 간격으로 disk usage를 점검 

### Shard allocation awareness
Elasticsearch는 shard를 할당 할 때 물리적 하드웨어 구성 적용 가능  
같은 rack 에 구성하거나 같은 zone에 구성 되도록 지정 가능   
node.attr.* 설정을 이용해서 적용 

- `rack_id`
  - node.attr.rack_id: rack_onde
  - bin/elasticsearch -Enode.attr.rack_id=rack_one
- `attributes`
  - cluster.routing.allocation.awareness.attributes: rack_id
  - master 역할을 수행 하는 모든 노드의 elasticsearch.yml에 정의하거나 cluster update settings를 이용해서 적용 
- `force`
  - 노드가 사용 가능 할 때 까지 replica shard의 할당이 되지 않도록 설정 가능 
  - `cluster.routing.allocation.awareness.attributes: zone`
  - `cluster.routing.allocation.awareness.force.zone.values: zone1, zone2`



### Shard allocation awareness 실습 
- elasticsearch instance를 두개 준비
- attribute 설정과 data tier 설정 두가지로 진행 


1. es 2개 준비
```
cp -rf elasticsearch-8.3.1 es1
cp -rf elasticsearch-8.3.1 es2
```

2. es1 설정
```
vi es1/config/elasticsearch.yml

cluster.name: kd.sin-data-tier
node.name: data-hot
node.roles: ["master", "data_hot"]
node.attr.tier: hot

# 밑의 설정이 빠지면 에러뜸
xpack.security.enabled: false
xpack.security.enrollment.enabled: false
xpack.security.http.ssl:
  enabled: false
```

3. es2 설정 
```
vi es2/config/elasticsearch.yml

cluster.name: kd.sin-data-tier
node.name: data-cold
node.roles: ["master", "data_cold"]
node.attr.tier: cold 

# 밑의 설정이 빠지면 에러뜸
xpack.security.enabled: false
xpack.security.enrollment.enabled: false
xpack.security.http.ssl:
  enabled: false
```

4. es 실행 
```
es1/bin/elasticsearch -d -p PID
es2/bin/elasticsearch -d -p PID
```

5. es 확인 
```
http://localhost:9200/_cat/nodes?v

# ip        heap.percent ram.percent cpu load_1m load_5m load_15m node.role master name
# 127.0.0.1            2         100   7    2.31                  hm        *      data-hot
# 127.0.0.1            1         100   2    2.31                  cm        -      data-cold
```

6. shard를 특정 노드로 생성
```
PUT http://localhost:9200/shard-allocation-00001
Content-Type: application/json

{
    "settings": {
        "index.number_of_shards":2, # shard 의 갯수
        "index.number_of_replicas": 0, 
        "index.routing.allocation.require.tier": "hot" # hot 노드로 배치
    }
}
```

```
# 생성된 shard 확인 
http://localhost:9200/_cat/shards/shard-allocation-00001?v
```

7. shard를 hot에서 cold로 변경 
```
PUT http://localhost:9200/shard-allocation-00001/_settings
Content-Type: application/json

{
  "index.routing.allocation.require.tier": "cold"
}
```

```
# 변경된 shard 확인 
http://localhost:9200/_cat/shards/shard-allocation-00001?v
```


- 이러한 방법으로 색인 노드와, serving 노드를 분리해서 사용할 수도 있다.
  - 색인 전용 노드는 service request는 들어오지 않도록 하는것.
  - 색인이 완료되면 serving 노드에 shard를 재할당 시켜서 service reqeust를 받을 수 있도록 구성 

### Index Recovery Settings
- 이 설정은 샤드를 다시 생성 하거나 재할당 하는 경우 primary shard를 기준으로 복구하며
- 개별 노드로의 in/out bound 크기의 총량으로 설정한다 
- `indices.recovery.max_bytes_per_sec`
  - 기본 크기는 40 MB/s

### Indexing buffer settings
- 이 설정은 색인 요청 문서를 in-memory로 담아서 빠르게 처리 하기 위해 사용
- memory buffer에 꽉 차면 segment 파일로 내려 씀
- 대량으로 색인 또는 빈번한 색인 요청이 많을 경우 색인 성능이 나오지 않을 때 살펴 보면 도움됨
- 대부분의 색인 성능은 Disk I/O 영향을 가장 많이 받는다.
- `indices.memory.index_buffer_size`
  - 기본 크기는 노드에 할당 된 heap size의 10% 이며 모든 샤드에서 buffer를 공유해서 사용 
  - 너무 buffer size 작게하면, 색인 성능이 작아지고 
  - 너무 buffer size를 크게 잡으면 out of memory에러가 등장할 수 있다.
- 설정을 하면, 모든 shard가 공유해서 사용한다 보면 된다.
- 최소 48MB 설정가능
- 보통 128MB 또는 256MB 사용하는게 좋다.


### Node query cache settings
- 질의시 filter context를 이용해서 질의 결과를 cache 하도록 하는 설정
- 노드 당 하나씩 존재하며, LRU 정책으로 사용 
- cache 설정
  - 세그먼트 당 10000개의 문서 
  - 또는 heap size의 10%를 사용 
  - 세그먼트가 merge 되면 캐시된 결과가 유효하지 않는다
- Elasticsearch에서는
  - Field data cache도 제공
  - field data circuit breaker 설정 영향을 받는다
  - 기본 field data cache 크기 설정은 무제한
- `indices.queries.cache.size`
  - 기본 head size의 10%이다.

### Search settings
- 검색에 대한 전역 설정과 arregation 에 대한 제한을 구성하는 설정 
- `indices.query.bool.max_clause_count`
  - 루씬 기준의 boolean query절에 포함 될 수 있는 최대 절 수
  - 기본 1024 절(매우 높은 수준)
  - 설정이 너무 커지면 CPU, MEM에 대한 자원 소모 증가, 성능 저하
- `search.max_buckets`
  - 단일 응답을 허용하는 최대 aggregation bucekt의 수 (65535개)
- `indices.query.bool.max_nested_depth`
  - bool query에서 사용하는 최대 nested 깊이를 정의 (기본20)

### Thread pools
- 보통은 기본 설정 수정하지 않으나,
- 단일 instance 의 사양이 너무 좋아서 단일 instance에다가 elasticsearch를 여러개 실행 시킬 경우 processor의 크기를 나눠서 설정하는 것을 추천 
```
thread_pool.*
node.processors
  보통은 자동으로 설정 된다 
```

### 주요 System 설정 
- 시스템의 자원 사용 제한 조정 
  - 1회성 설정으로 cluster 재시작 시 리셋
- Virtual memory
  - elasticsearch에서는 mmapfs 구조를 사용하기 때문에
  - shard 색인 정보를 메모리에 저장해서 효과적으로 사용 
  - (vm.max_map_count=262144) 으롤 설정해주면 좋다.
- Disable swapping
  - 설정 해놓으면 좋다
  - heap을 사용하기 때문에 스왑을 사용할 필요가 없음
- Bootstrap Checks
  - Elastic 사에서 가지고 있는 경험을 기반으로
  - 중요한 설정에 대해서 점검을 해주는 기능 

### Closed Index 설정 변경 

- 개별 인덱스에 적용 되는 설정 - static 설정, dynamic 설정 
- static설정: 인덱스 생성 되는 시점에 적용
- dynamic설정: 동작중인 인덱스에 update index settings 를 통해서 적용 
- Closed Index에 설정 변경을 하는 것은 예기치 않은 결과를 유발 할 수 있기 때문에 사용하지 않는다.



1. shard close
```
POST http://localhost:9200/shard-allocation-00001/_close
```

2. shard replica 수 변경
```
PUT http://localhost:9200/shard-allocation-00001/_settings
Content-Type: application/json

{
    "index.number_of_replicas": 1
}
```

3. shard open
```
POST http://localhost:9200/shard-allocation-00001/_open
```

4. 확인 
```
http://localhost:9200/_cat/shards/shard-allocation-00001?v
```

- replicas들은 unassigned되어 있는 것을 확인할 수 있다.
- 왜냐하면, 같은 노드에 같은 인덱스(shard)가 존재할 수 없기 때문에 그렇다.

5. setting 변경
```
PUT http://localhost:9200/shard-allocation-00001/_settings

{
    "index.routing.allocation.require.tier": "", 
    "index.routing.allocation.include.tier": "hot, cold" 
}
```
- `"index.routing.allocation.include.tier": "hot, cold"`: hot 혹은 cold 두 타입에 대한 노드에 할당 되도록 설정

6. unassigned로 되어있던 replicas들 확인 
```
http://localhost:9200/_cat/shards/shard-allocation-00001?v
```

- replicas들이 unassigned에서 data-cold node로 변경된 것을 확인할 수 있다.

## 7. Index Modules 

### Static Index Settings - 1. index.number_of_shards
- 인덱스의 primary shard 에 대한 크기 설정 
- 기본 1로 설정 되어 있으며 인덱스 생성 시점에만 적용이 가능 
- primary shard는 색인 성능에 영향을 주는 요소로, 크기 설정 시 색인에 대한 성능 검토 필수
- 인덱스당 생성 가능한 최대 primary shard의 크기는 1024
  - 논외로 노드당 생성 가능한 최대 shard의 크기는 1000
- 하지만 너무 많은 shard의 생성으로 자원을 낭비 하게 되면 OOM와 같은 오류 발생 가능
- 오류 방지를 위해 클러스터 내 모든 노드에 아래와 같은 설정을 통해서 제한 할 수 있음
  - ES_JAVA_OPTS="-Des.index.max_number_of_shards=128"

### Static Index Settings - 2. index.number_of_routing_shards
- 인덱스 생성 시 정의한 primary shard를 설정한 크기 만큼 늘리는 설정
- 문서가 shard에 분산 저장 되는 즉, routing에 영향을 주기 떄문에 이미 데이터를 가지고 있거나
- 색인 중인 인덱스에 적용하는 것은 추천 하지 않음 

### Static Index Settings - 3. index.codec
- 저장 데이터에 대한 압축 옵션을 지정하는 설정
- 기본 값은 LZ4 이며, 좀 더 좋은 압축 비율로 설정 하고 싶다면 DEFLATE로 설정 
- 저장 성능은 떨어지게 되지만, Disk usage에 대한 utilization은 개선 될 수 있음

### Static Index Settings - 4. index.hidden
- elasticsearch 에서 system 인덱스나 meta 정보를 저장 하기 위한 인덱스로 주로 하는 설정 
  - 기본 False
- wildcard를 이용 시 해당 index는 매칭 되지 않으며, 정확한 index 명으로는 질의 시 매칭 

실습 해보기

1. 인덱스 목록 조회 
```
GET http://localhost:9200/_cat/indices
```

2. 특정 인덱스를 hidden 으로 설정
```
PUT http://localhost:9200/kibana-event-log-7.15.0-000001/_settings

{
  "index.hidden": true
}
```

3. 인덱스 목록 조회 - hidden시킨 인덱스 안보이는 것을 확인
```
GET http://localhost:9200/_cat/indices

# 혹은

GET http://localhost:9200/*/_search
```

4. hidden 되어 있는 index 조회 
```
GET http://localhost:9200/kibana-event-log-7.15.0-000001/_search
```


### Dynamic Index Settings - 1. index.number_of_replicas
- primary shard에 대한 복제 shard의 크기를 설정 (기본 값은 1)
- replica shard는 검색 질의 성능에 영향을 주는 요소이며, 운영 중 복제 샤드의 크기를 동적으로 조정 가능
- 운영 중 조정을 할 경우 트래픽이 적은 시간에 진행 하는 것을 추천하며,
- 늘리거나 줄일 경우 실제 물리적인 복사를 하거나 삭제가 되기 떄문에 서비스 영향도 점검 필요 

### Dynamic Index Settings - 2. index.refresh_interval
- 색인 시 변경 사항을 검색에 표시 하기 위한 작업 주기를 시간으로 설정
- 기본 값은 1초 이며, -1로 설정 시 해당 기능은 disable
- disable 할 때는 bulk 색인 요청 작업을 수행할 때 설정하게 됨
- 주의) 
  - index에 해당하는 meta 정보 즉, mapping, field에 대한 정보 변경 금지 
  - 변경 되면 자동으로 refresh operationdl 발생 -> 의미가 사라짐
- refresh 가 실행 되게 되면 신규 segment file이 생성 되면서 가장 최근까지 색인 작업이 수행 되던 segment info 정보를 업데이트
- 최근 색인 데이터에 대한 IndexWriter에서 IndexReader를 가져오고 이 Reader를 IndexSearcher로 전달 하여 최근 색인 작업된 문서를 조회 

### Dynamic Index Settings - 3. index.max_result_window
- 인덱스 별 검색 질의에 대한 최대 결과 크기를 설정
  - from + size 의 최대 값으로 기본은 10000
  - from 은 offset 정보이며, size는 return 크기 
- 이 설정 값을 크게 잡을 경우 Heap usage가 증가하게 되어 OOM과 같은 오류 발생 가능
  - Deep pagination은 검색 성능이 떨어지는 원인이기도 함 


### Elasticsearch에서 검색을 실행하는 방법 
1. 모든 Shard로 질의 요청이 전달 되고 매칭된 document id가 리턴
2. from, size에 맞는 결과를 정렬 
3. 해당 document id 로 2차 document value를 요청
4. return


### scroll
- slice: 하나의 요청을 slice 수 만큼 나누어서 요청하는 것
  - 모든 slice 요청의 결과를 합치면 하나의 scroll 요청의 결과와 동일하게 된다
- scroll: RDBMS에서 cursor와 유사한 기능
- Sort: Score sort와 Field sort 두 가지 방식 존재
  - field sort 사용 시 default 가 _doc로 정렬을 합니다 (Field sort 방식이 기본 정렬)
  - index order 방식을 사용하면 _shard_doc을 사용한다

### search_after 기능
- from을 사용하지 못하고 현재 페이지의 마지막 문서의 _doc 값을 이용해서 결과 도출
- from 과 같은 offset 지정이 아닌 이전, 다음과 같은 기능 구현에서 사용 추천
- scroll과 같이 현재의 상태를 저장하지 않기 떄문에 변경된 정보에 대해서도 결과 반영 


### Dynamic Index Settings - 4. index.max_inner_result_window
- nested document에 대한 inner hit 크기에 대한 제한 (기본 100개)
- Heap 사용을 많이 하게 되기 떄문에 제한

### Dynamic Index Settings - 5. index.analyze.max_token_count
- 단일 field에 대한 token 추출 시 최대 추출 크기를 제한 (기본 10000개)

### Dynamic Index Settings - 6. index.max_terms_count
- index에 질의 시 terms query에서 사용하는 최대 term 크기를 제한 (기본 65536개)

### Dynamic Index Settings - 7. index.routing.allocation.enable
- index의 shard에 대한 allocation 여부를 설정
  - all, primaries, new_primaries, none

### Dynamic Index Settings - 8. index.routing.rebalance.enable
- index의 shard에 대한 rebalance 여부를 설정
  - all, primaries, replicas, none
- 해당 index에 대한 shard가 특정 노드에 배치 되었을 때, 해당 노드에 디스크 사용량이 높을 때 다시 다른 디스크 사용량이 낮은 노드로 재할당을 할 수 있는데, 그러한 경우에 어떠한 shard들만 재할당 할 것인지 설정


### Scroll 실습 

1. Kibana 대시보드 접속 
2. Try Sample data
3. 3개다 Add data 
4. Dev Tools 접속 

5. 10분동안 유효한 scroll api 조회 
```
POST /kibana_sample_data_logs/_search?scroll=10m
{
  "size": 2000,
  "query": {
    "match_all": {
    }
  }
}
```

6. scrol API를 통한 데이터 2000개씩 가져오기 (조회를 할 때 마다 다음 2000개를 가져옴)
```
POST /_search/scroll
{
  "scroll": "10m",
  "scroll_id": "FGluY2x1ZGVfY29udGV4dF91dWlkDXF1ZXJ5QW5kRmV0Y2gBFlBoVl9uWXl5UWpPYmh1VHYtU0hHcXcAAAAAAAABUBZtbGZtRkI2elJhV2hmdDJnOEcySlJR"
}
```

7. 스크롤 제거 
```
DELETE /_search/scroll
{
  "scroll_id": "FGluY2x1ZGVfY29udGV4dF91dWlkDXF1ZXJ5QW5kRmV0Y2gBFlBoVl9uWXl5UWpPYmh1VHYtU0hHcXcAAAAAAAABUBZtbGZtRkI2elJhV2hmdDJnOEcySlJR"
}
```


### Analysis
- 구조화 되지 않은 텍스트를 검색에 최적화 된 구조의 형식으로 변환 하는 과정 
- 텍스드필드 -> 색인 + 텍스트 분석 


### Text Analysis
- full text 검색을 수행 하게 된다.
- Exact matching이 아니기 때문에 관련된 모든 결과를 반환한다.
- Full text 검색 수해을 위한 분석 과정
  - Tokenization
    -  텍스트를 토큰 이라는 작은 단위로 분할
    -  분할된 토큰은 개별 단어를 의미 
  - Normalization
    - 문자에 대한 변형과 필터를 적용하는 것 (토큰을 표준형식으로 정규화)
    - 대소문자 적용 / 동의어 처리 / 불용어 제거 등의 작업 

### Analyzer란
- Text를 검색엔진에서 검색 가능한 구조화 된 형식으로 만들어 주는 것 
- Analyzer는 하나의 Tokenizer와 다수의 Filter로 구성 하고, Filter 사용을 하지 않더라도 Tokenizer는 무조건 선언이 되어야 함 

### Analyzer 종류 
- Lucene 에서 제공 하는 내장 analyzer
- 사용자가 만들어서 제공하는 custom analyzer


### Analyzer의 구성 항목 
- Characterfilters
  - 원본 텍스트에서 불필요한 문자들을 제거/추가/변경 등 원본 텍스트를
  - 변형해서 Tokenizer로 전달하여 token 추출
- Tokenizers: 토큰 단위로 생성하는 과정
  - 문자 스트림을 수신 해서 개별 토큰으로 나누고 
  - 나눠진 토큰 스트림을 출력 
  - 나눠진 토큰의 순서, position, 단어의 시작과 끝의 문자 offset정보를 기록 
  - (기록된 정보는 term vector 정보로 사용)
- Token Filters: 토큰을 필터하는 과정
  - Tokenizer에서 넘겨 준 토큰 스트림을 받아서 토큰을 제거/추가/변경
  - 토큰을 소문자로 변환, 불용어 제거, 동의어 추가 등의 작업 수행
  - 선언 된 순서대로 적용 되며, 0개 이상 사용 가능 


### _analyze API 구조
```
GET /_analyze
{
  "analyzer": "standard",
  "text": "Quick Brown Foxes!"
}


```
request
- `GET /_analyze`
- `POST /_analyze`
- `GET /<index>/_analyze`
- `POST /<index>/_analyze`

JSON 구조
```
{
  "analyzer": "",
  "char_filter": [""],
  "tokenizer": {...},
  "filter": [{...}],
  "field": "",
  "normalizer": "",
  "text": ["..."],
  "explain": true
}
```

### _analyze API Parameters
- analyzer: built-in analyzer 설정 
- char_filter: tokenizer 로 전달 하기 이전에 입력 된 text를 전처리 하기 위한 filter를 설정 (array)
- explain: 기본 false 이며, 분석 결과에 대한 상세 정보를 포함하도록 함
- field: field에 정의 된 analyzer 를 이용해서 분석하도록 함
- filter: tokenizer 이후에 사용할 filter 설정 (array)
- normalizer: 
  - analyzer와 유사하지만, 단일 토큰으로 분석 결과를 만들어 낸다는 차이점이 있음
  - tokenizer를 사용 하지 않음
  - 모든 filter 적용이 가능 한 것이 아닌 문자 단위로 동작하는 필터만 사용 가능 
- text: 형태소 분석할 대상 text (array or string)
- tokenizer: 사용할 tokenizer 설정 

### nori_tokenizer
- decompound_mode
  - 복잡 토큰에 대한 처리 방법을 설정
  - none: 처리 하지 않음 (가거도항, 가곡역)
  - discard: 복합 토큰을 분해 하고 분석 대상 토큰을 버림 (가곡역 => 가곡, 역)
  - mixed: 분석 대상 토큰을 유지 하면서 복합 토큰을 분해 (가굑역 => 가곡역, 가곡, 역)
- discard_punctuation
  - 기본 true 이며, punctuation character를 제거 
- tokenizer
  - 사용할 tokenizer 설정
- user_dictionary
  - 사용자 정의 사전 파일을 설정 
  - 기본 위치는 $ES_HOME/config/userdict_ko.txt 와 같이 위치 시키며,
  - 사전 파일에 사전은 한 줄에 하나씩 정의
  - (정의 하는 사전은 simple noun, compound noun 을 작성)
- user_dictionary_rules
  - 사전 파일에 작성하는 내용을 설정으로 직정 등록 하는 방식
  - 한 줄로 작성 하는 내용을 배열로 작성

### nori_part_of_speech token filter
- 품사 태그 집합과 일치 하는 토큰을 제거 
- stoptags: 제거 해야 하는 품사 태그를 설정 한다(아래가 기본 설정)

```
"stoptags": [
  "E",
  "IC",
  "J",
  "MAG", "MAJ", "MM",
  "SP","SSC","SSO","SC","SE",
  "XPN","XSA","XSN","XSV",
  "UNA","NA","VSV"
]
```


### _analyze API를 이용한 NoriAnalyzer 테스트 
- analyzer: 한국어 형태소 분석기 (은전한닢 또는 MeCab), 기본 사전 목록은 세종 말뭉치를 사용 
- nori_readingfrom token filter: 한자를 한글로 변환 한다
- nori_number token filter
  - 한국어 숫자를 half-width 문자의 일반 아랍어 십진수로 정규화 한다
  - 이 필터는 숫자 정보에 해당 하는 field에 사용 하면 좋다 



설치 및 제거 
```
bin/elasticsearch-plugin install analysis-nori
bin/elasticsearch-plugin remove analysis-nori
```



## 실전 

### Unassigned Shard 문제 해결 

1. Unassigned Shard 목록 확인 

```
GET _cat/shards?v=true&h=index,shard,prirep,state,node,unassigned.reason&s=state
```

2. Unassigned 원인 확인
```
GET _cluster/allocation/explain
{
  "index": "address_search",     # 인덱스 이름
  "shard": 1,                    # shard 번호 (위 cat API에서 확인가능)
  "primary": false               # primary shard 여부
}
```

3. Unassigned Shard 재할당 
```
POST /_cluster/reroute?explain
{
  "commands": [
    {
      # 할당할 노드를 직접 지정하여 replica shard 할당
      "allocate_replica": {
        "index": "address_search",       # 인덱스 이름
        "shard": 0,                      # shard 번호
        "node": "search-dev-es-master-1" # 재할당 할 노드, GET _cat/nodes 로 노드 확인 가능 
      }
    }
  ],
  "dry_run": false  # true로 설정시 실제 operation은 수행하지 않으면서, 실행 결과를 확인할 수 있음
}
```

### Rolling Update 배포로 data 노드 배포 시 latency 생기는 현상 원인 및 해결 방법 

- 원인
  - data노드가 한대씩 내려갈 때 마다 내려간 data노드가 가지고 있던 primary shard 들이 없어지면서 
  - 다른 data노드에서는 없어진 primary shard들을 복구하기위해 recovery 모드로 전환된다. (기본값은 1m 이라서 1분뒤 recovery 모드가 시작됨)
  - recovery 모드로 진입되면 없어진 primary shard들을 재할당하게 된다. 
  - recovery 모드로 진입되면서 primary shard들을 재할당 하면서 latency가 조금씩 튀는 현상이 생긴것이였음 
- 해결 방법 
```
PUT _all/_settings
{
  "settings": {
    "index.unassigned.node_left.delayed_timeout": "5m"
  }
}
```
  - 위 명령어로 사라진 primary shard들의 복구 시간을 1분에서 5분으로 늘려주면됨.
  - 그러면 5분안에 내려간 data노드가 restart가 된다면 recovery 모드로 진입하지 않는다.
  - eck에서는 pod를 새로띄우는것이 아닌, restart 하는 방식으로 배포를 진행한다.
  - 그래서 restart되고나면 없어졌던 primary shard들을 그대로 갖고 있는 pod가 다시 붙게되면 recovery 할 필요가 없어짐.


### Master, Data Node로만 구성했을 때 배포 시 Latency 튀는 현상 원인 및 해결 방법 

**상황**

<img width="490" alt="image" src="https://github.com/sinkyoungdeok/TIL/assets/28394879/0476162b-18b0-4891-844c-fa1ce3dca991">
- 위는 평소 상황
- 위 상황에서 배포를 시작하면 아래 과정들을 거침 

<img width="480" alt="image" src="https://github.com/sinkyoungdeok/TIL/assets/28394879/ef11ed79-319d-4372-9638-41b79b7c5cd0">
- 배포 시작하면 Pod중 한대를 종료함
- 이 떄 까지는 Latency가 정상임

<img width="473" alt="image" src="https://github.com/sinkyoungdeok/TIL/assets/28394879/0bab9c8b-7284-409a-8203-c4ed0c15ac4e">
- 종료된 pod가 init 상태로 변경됨
- 이 때 latency가 비정상적으로 올라감

<img width="473" alt="image" src="https://github.com/sinkyoungdeok/TIL/assets/28394879/e8971a44-8bc8-4af5-a560-485ee022d513">
- 배포된 pod가 running상태로 변경되고, 다음 pod도 위와 같은 Eng -> init -> Running 상태를 거친다.
- 그럼 다른 pod들도 이미지가 교체(배포)되면서 latency가 비정상저긍로 올라간다.
- 그래서, 배포 할 때 마다 master 노드의 대수 만큼 latency가 비정상적으로 올라가는 현상임.


- 원인 
  - ingress를 master로 구성하게 될텐데, 이러면 coordination 노드의 역할인 Web Server 역할까지도 맡는 것이다.
  - 이렇게 구성하게 되면 Web Server인 Master 노드가 한대 씩 내려갈 때 마다 엄청난 Latency가 튄다 (1대 내려갈 때 마다 5초까지 고정적으로 튀는것을 확인)
- 해결 방법 
  - Coordination 노드를 투입시키고
  - ingress를 master노드에서 coordination노드로 변경한다.
  - 그리고 배포할 때 coordination을 제외한 master, data 노드만 배포되도록 한다.


### Elasticsearch Warm Up
- 두가지의 warm up 을 생각해볼 수 있다.
- 1번째: index warm up
  - 출처: https://www.elastic.co/guide/en/elasticsearch/reference/7.17/indices-warmers.html
  - 과거 elasticsearch 에서는 index를 warm up 을 하기 위해 warmer를 쓸 수 있었는데
  - 7버전부터 warmer가 제거됐다.
  - index warm up을 안해도 될만큼 index의 성능이 개선된 것으로 확인됨.
- 2번째: jvm warm up
  - elasticsearch 도 jvm위에 돌아간다.
  - jvm을 사용하므로 결국 jit compiler를 사용하고 있을텐데, 그럼 배포를 할 때 마다 latency 밀리는 현상이 조금씩은 있을 수 있고 이것을 해결하기 위해선 warm up 이 필요하다.
  - 나는 kubernetes의 startup probe설정과 side car패턴으로 warm up을 하는 앱을 띄워서 해결했다. 
  - warm up 앱에서는 localhost:9200 으로 data노드 갯수 * 250번 만큼 호출하도록 했다.
  - 여기서 warm up 도중에 startup probe 통과를 아직 못한 노드에 unassigned shard들이 할당되는 것을 확인 됐었는데 여기서 잠깐 의문이 들었었다.
  - 알고보니 kubernetes의 startup probe가 service의 ip에 할당할지 말지를 결정하는 거라서 
  - startup probe를 통과하지 못하더라도 ES cluster에는 바로 붙는 것이다.
  - 그래서 결론적으로는 ES node가 한대 재시작 되면
    - warmup 하는 과정을 거치는데
    - 바로 ES cluster에는 붙어서 unassigned shard들을 재할당 받을 수는 있지만
    - warmup 도중에는 startup probe를 통과하지 못하고
    - startup probe를 통과하지 못하면 검색 요청을 못받는 상태에 있다가
    - warmup이 종료되고 startup probe을 통과하고 나면 검색 요청을 받는 것이다.

### Primary Shard, Replica Shard 성능 튜닝 관련 정리
- primary shard 2, replica shard 1 로 세팅하면 총 shard 갯수는 4개이다. (primary 2, replica 2)
- data노드 갯수가 4개일 때
  - primary shard 1로 세팅한다면 
  - 최대 replica shard 갯수는 3개이다. 
  - data노드안에 같은 shard가 배치될순 없는 것 같다. 
- data 노드 갯수가 4개라면
  - 적어도 primary, replica shard 총 갯수가 4개이상은 되어야 한다.
  - 그리고 primary, replica shard 총 갯수가 4의 배수가 적절할 수 있다.
- primary shard 갯수가
  - 너무 많을수록 샤드의 크기가 작아지고 
    - 샤드당 처리속도는 빨라지지만
    - 더 많은 작업을 대기열에 넣고 순서대로 처리해야 하므로, 검색 성능이 떨어질 수 있다.
  - 너무 적다면 샤드의 크기가 커지고
    - 샤드당 처리 속도가 느려서
    - 검색 성능이 떨어질 수 있다.  
- replica shard 갯수가 
  - 많을수록 읽기 성능이 높아지고 색인 성능이 떨어진다.
  - 적을수록 색인 성능이 높아지고 읽기 성능이 떨어진다.
- data 노드 갯수 4개 기준으로 테스트 해보았을 떄 
  - primary shard 4, replica shard 1로 
  - 세팅했을 때가 가장 안정적으로 성능이 나왔다.
  - 안정적이라는게, 색인 + 배포를 동시에 진행하면서 검색했을 때를 말하는 것이다.

### node_left.delayed_timeout 설정으로 latency 지연 해결 

#### 상황
- - elasticsearch 에서는 Fault Detection을 위해 master → nodes, nodes → master 양방향으로 주기적으로 ping을 날림.
- 별도 설정이 없다면 1초마다 ping을 날리고, 30초 동안 응답이 없으면 3번 재시도 후 최종적으로 fault라고 단정짓고 해당 노드를 클러스터에서 제외 시킴.
- 위에 상황이 운영중인 클러스터에선 문제가 심각해 질 수 있음.
  1. 클러스터에서 노드가 한개 빠짐 
  2. 빠진 노드가 갖고 있던 shard들이 unassigned shards로 변경됨
  3. unassigned shards를 기존 노드들이 나눠갖는 shard allocation 발생
  4. 데이터량이 많은 인덱스의 경우 shard allocation 작업이 굉장히 비싼 작업이여서 CPU load 높아짐 
  5. 서비스 지연 발생
- 위 문제가 배포한다면 data노드 갯수만큼 벌어짐. 


#### 배포 시 상황 
- data 노드 3대로 시작.
1. 3대중에 1대 종료
2. 종료된 노드에서 shard들 unassigned shard로 변경됨.
3. unassigned shard 들을 나머지 2대로 allocation 작업 → latency 증가
4. 종료된 노드 재시작 완료
5. 재시작된 노드가 투입되면서 재할당 시작. → latency 증가
- 위 1~5번을 data노드 갯수(3개)만큼 반복

#### 해결 방법 
- unassigned shards의 allocation을 기본 설정은 1분인데, 이것을 5분으로 변경한다.
- 즉, unassigned shards를 5분이 지날때 까지 unassigned 상태로 유지
- 이렇게 하게되면, 종료된 data node가 갖고 있던 shard들을 재시작 됐을 때 그대로 사용 가능.

#### 설정 
- https://www.elastic.co/guide/en/elasticsearch/reference/current/delayed-allocation.html


## data 노드 수와 shard 갯수 조절로 latency 해결

### Background

#### 검색 원리
- es 검색은 1쿼리 1샤드 1스레드를 바탕으로 일어남.
- 쿼리 → 노드1 전달 → 나머지 노드 전달 → 각 노드들이 샤드에게 전달, 이 때 검색스레드가 쿼리를 전달

#### Case1) 샤드 갯수 1, 단일 쿼리
![image](https://github.com/sinkyoungdeok/TIL/assets/28394879/f69d0958-3549-4f1f-af59-9a08cea078a9)
- 검색 원리에 따라
    1. 쿼리를 노드 c에서 받음 
    2. 노드 c가 나머지 노드들에게 전달 
    3. 각 노드들이 자신의 샤드에게 전달
- 검색할 샤드의 수가 1개 이기 때문에 4개의 스레드풀에서 1개의 스레드만 사용.
- 각 노드마다 나머지 3개의 스레드는 낭비되는 비효율적인 상황.


#### Case 2) 샤드 갯수 1, 멀티 쿼리
![image](https://github.com/sinkyoungdeok/TIL/assets/28394879/4c58ae8d-a06d-4f60-9ffe-9e630205bb11)
- 검색 원리에 따라
    1. 쿼리를 노드 c에서 받음
    2. 노드 c가 나머지 노드들에게 전달
    3. 각 노드들이 자신의 샤드에게 전달
- 쿼리가 4개들어오고, 각 노드에 할당된 샤드의 수가 1개이기 때문에 4개의 스레드풀에서 4개의 스레드를 사용
- 각 노드는 쿼리 하나당 스레드를 하나씩 사용하게 돼서 낭비 없이 모든 스레드를 사용


#### Case 3) 샤드 갯수 n, 멀티 쿼리 (n: 코어의 갯수)
![image](https://github.com/sinkyoungdeok/TIL/assets/28394879/d84e3e14-d834-411d-a755-0d4b09d774f6)
- 검색 원리에 따라
    1. 쿼리를 노드 c에서 받음
    2. 노드 c가 나머지 노드들에게 전달
    3. 각 노드들이 자신의 샤드에게 전달
- 노드별로 쿼리를 날려야할 샤드가 4개이므로 쿼리1에 대한 결과를 조회하기 위해 4개의 스레드풀에서 4개의 스레드를 모두 각각 사용
- 그럼 그 뒤에 들어온 2~4번 쿼리는 1쿼리가 완료될 때 까지 실행되지 못하고 스레드큐에 쌓이게 될 수 있다.
- 결국 2~4 쿼리에 대한 응답 결과가 느려지게 되고, 쿼리 간의 응답속도차가 점점 벌어짐


### 결론 
- 현재 오늘의집 검색팀에서는 대부분의 ES의 data노드를 4대 두고 있고, 각 노드별로 스레드 갯수는 10개정도 된다.
- data노드를 한 6~8대 정도까지 늘리고, shard갯수도 그만큼 늘리면 성능 이점을 가져갈 수 있다.
- 추가로
    - 현재 data노드가 4개니까 배포하면 data 노드 3대로 트래픽을 버텨야한다.
    - commerce 같은경우는 data노드 3대로 트래픽을 버티기에는 역부족일 수 있다.
    - 그래서, data 노드 수를 6대로 늘리고 primary shard 갯수도 6개로 늘리면 성능 이점과 배포했을 때 latency 밀리는 현상을 완화할 수 있다.