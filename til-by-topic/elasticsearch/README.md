

## 목록 
- [1. 설치 명령어](#1-설치-명령어)
- [2. lucene](#2-lucene)
- [3. elasticsearch](#3-elasticsearch)




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


## 3. elasticsearch

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


