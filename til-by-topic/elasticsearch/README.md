
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

