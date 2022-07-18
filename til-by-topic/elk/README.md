
# 1. 데이터 과학 소개 및 환경 구축 

<details> <summary> 1. ELK 설치</summary>

## 1. ELK 설치

### 설치
```
brew install elastic/tap/kibana-full
brew install elastic/tap/elasticsearch-full
brew install elastic/tap/filebeat-full
brew install elastic/tap/logstash-full
```

### 서비스 실행
```
brew services start elastic/tap/kibana-full
brew services start elastic/tap/elasticsearch-full
brew services start elastic/tap/filebeat-full
brew services start elastic/tap/logstash-full
```

### ElasticSearch 실행 확인
- localhost:9200 접속


</details>

# 2. 엘라스틱 서치 (ElasticSearch)

<details> <summary> 1. 엘라스틱서치 기본 개념 정리 </summary>

## 1. 엘라스틱서치 기본 개념 정리

![image](https://user-images.githubusercontent.com/28394879/142723353-96101d05-1892-4c90-bb43-22ef28343a5b.png)

- 왼쪽 데이터 형태로 들어왔을 때 엘라스틱 서치는 오른쪽 테이블 형태로 저장을 한다. 

### elastic search vs relational DB

![image](https://user-images.githubusercontent.com/28394879/142723405-0155e63a-e55a-44fc-ac53-b98643e9c6e2.png)

- 구글링을 할때 Text단위로 검색하는 것을 가정했을때 Elastic search를 사용했을 경우 훨씬 빠르게 데이터를 가져올 수 있다. 

### elastic search data structure 

![image](https://user-images.githubusercontent.com/28394879/142723499-fd98d73e-79f5-4796-b762-d4635af2481e.png)

- index 안에 type을 갖는다.
- type안에 여러개의 document를 갖는다.
- document들은 같은 property를 갖고 있는다. 

### elastic search vs relational DB 용어 차이
![image](https://user-images.githubusercontent.com/28394879/142723564-1c4b324b-dee6-48aa-9370-3f4fd14cbbd2.png)

![image](https://user-images.githubusercontent.com/28394879/142723595-7490990d-7de9-4a85-9c40-a1be17a5e750.png)
- Elastic Search는 REST API를 사용한다. 

![image](https://user-images.githubusercontent.com/28394879/142723609-be8f9292-c04c-4b0a-b7a7-41cebd693b77.png)

</details>

<details> <summary> 2. 엘라스틱서치 데이터 입력 조회 삭제 (GET, POST, PUT, DELETE) </summary>

## 2. 엘라스틱서치 데이터 입력 조회 삭제 (GET, POST, PUT, DELETE)

1. classes index가 있는지 조회 (아직은 생성안해서 조회 안되는게 맞음)
`curl -XGET http://localhost:9200/classes` 
2. 조회할 때 이쁘게 보기 
`curl -XGET http://localhost:9200/classes?pretty`  
3. index가 없다는 것을 확인했으니, 인덱스 생성 해보자.
`curl -XPUT http://localhost:9200/classes`
4. 생성된것을 조회
`curl -XGET http://localhost:9200/classes?pretty`    
```
{
  "classes" : {
    "aliases" : { },
    "mappings" : { },
    "settings" : {
      "index" : {
        "routing" : {
          "allocation" : {
            "include" : {
              "_tier_preference" : "data_content"
            }
          }
        },
        "number_of_shards" : "1",
        "provided_name" : "classes",
        "creation_date" : "1637410676372",
        "number_of_replicas" : "1",
        "uuid" : "sTOr1fWFTIe0JKaThOQ4LQ",
        "version" : {
          "created" : "7150299"
        }
      }
    }
  }
}
```
5. 생성한 index 지우기 
`curl -XDELETE http://localhost:9200/classes`
6. document 생성하기
```
curl -XPOST http://localhost:9200/classes/class/1/ -H 'Content-Type: application/json'  -d '
{"title":"Algorithm", "professor":"John"}'
```
index가 생성된 상태에서 해도 되고, 생성안된 상태에서 해도 된다.  
index를 생성 안된상태에서 하면, 알아서 index 생성까지 해준다.

7. 생성된것을 조회 
`curl -XGET http://localhost:9200/classes?pretty`    
**결과**  
```
{
  "classes" : {
    "aliases" : { },
    "mappings" : {
      "properties" : {
        "professor" : {
          "type" : "text",
          "fields" : {
            "keyword" : {
              "type" : "keyword",
              "ignore_above" : 256
            }
          }
        },
        "title" : {
          "type" : "text",
          "fields" : {
            "keyword" : {
              "type" : "keyword",
              "ignore_above" : 256
            }
          }
        }
      }
    },
    "settings" : {
      "index" : {
        "routing" : {
          "allocation" : {
            "include" : {
              "_tier_preference" : "data_content"
            }
          }
        },
        "number_of_shards" : "1",
        "provided_name" : "classes",
        "creation_date" : "1637411566405",
        "number_of_replicas" : "1",
        "uuid" : "HCTipXo6Stqya6SKmAXlsw",
        "version" : {
          "created" : "7150299"
        }
      }
    }
  }
}
``` 

8. json파일로 document 생성 
`curl -XPOST http://localhost:9200/classes/class/1/ -H 'Content-Type: application/json' -d @oneclass.json` 




</details>

<details> <summary> 3. 엘라스틱서치 데이터 업데이트 (UPDATE) </summary>

## 3. 엘라스틱서치 데이터 업데이트 (UPDATE)

1. 업데이트할 데이터를 위해서 document 생성
```
curl -XPOST http://localhost:9200/classes/class/1/ -H 'Content-Type: application/json' -d '{"title": "Algorithm", "professor": "John"}'
``` 

2. 1학점이라는 필드를 추가
```
curl -XPOST http://localhost:9200/classes/class/1/_update -H 'Content-Type: application/json' -d '{"doc" : {"unit" : 1}}'
``` 

3. 추가 된 것 확인
```
curl -XGET http://localhost:9200/classes/class/1?pretty
``` 

4. 학점을 1에서 2로 수정
```
curl -XPOST http://localhost:9200/classes/class/1/_update -H 'Content-Type: application/json' -d '{"doc" : {"unit" : 2}}'
```

5. 학점에 script로 +5 시키기
```
curl -XPOST http://localhost:9200/classes/class/1/_update -H 'Content-Type: application/json' -d '{"script": "ctx._source.unit += 5"}'
```

</details>

<details> <summary> 4. 엘라스틱서치 - 벌크 (Bulk) </summary>

## 4. 엘라스틱서치 - 벌크 (Bulk)

1. CLASSES.JSON 을 bulk
```
curl -XPOST http://localhost:9200/_bulk --data-binary  @classes.json -H 'Content-Type: application/json'
``` 

2. bulk 확인 
```
curl -XGET http://localhost:9200/classes/class/2?pretty
```

</details>

<details> <summary> 5. 엘라스틱서치 매칭 (Mapping) </summary>

## 5. 엘라스틱서치 매칭 (Mapping)

- 매핑은 데이터베이스의 스키마와 동일하다. 
- 엘라스틱서치는 매핑없이도 insert 할 수 있다. 
- 실제 일할때는 매핑 없이 데이터를 넣는것은 상당히 위험한 일이다. 
  - 매핑이 없다면 날짜를 문자열로 인식할 수 있다. 
  - 매핑이 없다면 숫자를 넣을때도 문자열로 인식할 수 있다. 
  - 그렇다면, 평균을 낼 때도 문자열로 인식되면 잘 안될 수 있다. 
- 데이터를 넣을때에는 매핑을 먼저 추가해야 된다. 


1. 인덱스 생성
```
curl -XPUT 'http://localhost:9200/classes'
``` 
2. 매핑 생성
```
curl -XPUT 'http://localhost:9200/classes/class/_mapping' -H 'Content-Type: application/json' -d @classesRating_mapping.json
``` 
3. CLASSES.JSON 을 bulk
```
curl -XPOST http://localhost:9200/_bulk --data-binary  @classes.json -H 'Content-Type: application/json'
``` 
4. bulk 확인 
```
curl -XGET http://localhost:9200/classes/class/2?pretty
```
- 지금 실습에서는 mapping없이 bulk했을 때와의 차이점은 크게 없는 것 같다. (데이터 형식을 생각보다 알아서 잘 매칭해주는 듯함)
- 하지만, 데이터형식을 언제 다르게 해줄지 모르니, 항상 mapping을 먼저 생성해주는 것이 좋은 것 같다. 

</details>

<details> <summary> 6. 엘라스틱서치 데이터 조회 (Search) </summary>

## 6. 엘라스틱서치 데이터 조회 (Search)

1. 데이터 생성
```
curl -XPOST http://localhost:9200/_bulk --data-binary @simple_basketball.json -H 'Content-Type: application/json'
``` 

2. 데이터 확인
```
curl -XGET http://localhost:9200/basketball/record/_search?pretty
``` 

3. uri옵션으로 데이터 확인
```
curl -XGET http://localhost:9200/basketball/record/_search?q=points:30&pretty
```  

4. REQUEST BODY 로 데이터 확인 
```
curl -XGET http://localhost:9200/basketball/record/_search?pretty -H 'Content-Type: application/json' -d '
{ 
  "query": {
    "term" : {"points": 30}
  }
}'
``` 

</details>

<details> <summary> 7. 엘라스틱서치 메트릭 어그리게이션 (Metric Aggregation) </summary>

## 7. 엘라스틱서치 메트릭 어그리게이션 (Metric Aggregation)

- 평균, 합산 등을 구하는 것이 Metric Aggregation

1. 데이터 생성
```
curl -XPOST http://localhost:9200/_bulk --data-binary @simple_basketball.json -H 'Content-Type: application/json'
``` 

2. average aggregation 
```
curl -XGET http://localhost:9200/_search?pretty --data-binary @avg_points_aggs.json -H 'Content-Type: application/json'
```  

3. max aggregation 
```
curl -XGET http://localhost:9200/_search?pretty --data-binary @max_points_aggs.json -H 'Content-Type: application/json'
```  

4. min aggregation 
```
curl -XGET http://localhost:9200/_search?pretty --data-binary @min_points_aggs.json -H 'Content-Type: application/json'
```  

5. sum aggregation 
```
curl -XGET http://localhost:9200/_search?pretty --data-binary @sum_points_aggs.json -H 'Content-Type: application/json'
```  

6. stats aggregation (지금까지 한 모든 aggregation을 한번에)
```
curl -XGET http://localhost:9200/_search?pretty --data-binary @stats_points_aggs.json -H 'Content-Type: application/json'
```  

</details>

<details> <summary> 8. 엘라스틱서치 버켓 어그리게이션 (Bucket Aggregation) </summary>

## 8. 엘라스틱서치 버켓 어그리게이션 (Bucket Aggregation)

- group by같은 기능을 사용하는것이 Bucket Aggregation 
- Bucket key로 식별되는 여러 Bucket 쿼리 컨텍스트(테이블)에서 정의된 문제의 데이터를 분할하며 Document를 그룹화하는 것이다. 

1. INDEX 생성
```
curl -XPUT localhost:9200/basketball
``` 

2. mapping 적용
```
curl -XPUT 'localhost:9200/basketball/record/_mapping?include_type_name=true&pretty' -H'Content-Type: application/json' -d @basketball_mapping.json
``` 

3. 데이터 삽입(bulk)
```
curl -XPOST http://localhost:9200/_bulk?pretty -H'Content-Type: application/json' --data-binary @twoteam_basketball.json
``` 

4. bucket aggregation
```
curl -XGET http://localhost:9200/_search?pretty --data-binary @terms_aggs.json -H 'Content-Type: application/json'
``` 

5. 팀별로 스코어 통계
```
curl -XGET http://localhost:9200/_search?pretty --data-binary @stats_by_team.json -H 'Content-Type: application/json'
``` 

</details>


# 3. 키바나

<details> <summary> 1. 키바나 설치 확인 </summary>

## 1. 키바나 설치 확인

http://localhost:5601 접속 확인

</details>

<details> <summary> 2. 키바나 매니지먼트 (Kibana management) </summary>

## 2. 키바나 매니지먼트 (Kibana management)

1. 이전에 진행한 index 제거 
```
curl -XDELETE localhost:9200/basketball
``` 

2. 새로 index 생성
```
curl -XPUT localhost:9200/basketball
``` 

3. mapping정보 입력
```
curl -XPUT 'localhost:9200/basketball/record/_mapping?include_type_name=true&pretty' -H'Content-Type: application/json' -d @basketball_mapping.json
```

4. 데이터 삽입(bulk)
```
curl -XPOST http://localhost:9200/_bulk?pretty -H 'Content-Type: application/json' --data-binary @bulk_basketball.json
``` 

5. kibana 접속 후 index패턴 생성
![image](https://user-images.githubusercontent.com/28394879/143597413-f6c18934-791a-4cf8-a1fe-820df28478f3.png)

6. 데이터가 kibana에 잘 인식됐는지 확인
![image](https://user-images.githubusercontent.com/28394879/143597714-28cfc916-7afa-419b-9189-c9a7296ae569.png)




</details>

<details> <summary> 3. 키바나 디스커버(Kibana discover) </summary>

## 3. 키바나 디스커버(Kibana discover)

1. Kibana에서 디스커버 탭으로 들어가서, 2016년까지의 데이터 (2021년기준으론 약 6년전까지로 설정)를 검색
```
http://localhost:5601/app/discover#/?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-8y,to:now))&_a=(columns:!(),filters:!(),index:'3be87030-4ec7-11ec-b89d-c5bc45c36b0c',interval:auto,query:(language:kuery,query:''),sort:!(!(submit_date,desc)))
``` 

2. 2016~2017까지의 데이터 보기 
```
http://localhost:5601/app/discover#/?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:'2015-12-31T15:40:28.184Z',to:'2017-10-31T15:40:53.079Z'))&_a=(columns:!(),filters:!(),index:'3be87030-4ec7-11ec-b89d-c5bc45c36b0c',interval:auto,query:(language:kuery,query:''),sort:!(!(submit_date,desc)))
```
![image](https://user-images.githubusercontent.com/28394879/143604521-1ea36012-c914-48a5-9a47-c63880ed2d66.png)

3. filter로 "Stephen Curry"데이터만 보기
![image](https://user-images.githubusercontent.com/28394879/143604757-18e90696-8f7a-49e2-b7a4-4e410b0eb30e.png)

4. toggle 버튼으로 원하는 필드 위주로 보기
![image](https://user-images.githubusercontent.com/28394879/143604953-7d5ee4fa-5a15-40c5-99b0-a6cb5d14b1d4.png)

5. 정렬 버튼으로 원하는 필드로 정렬 하기 
![image](https://user-images.githubusercontent.com/28394879/143605225-845e7cb7-4f13-4287-9d19-0812c24e3e1c.png)


</details>

<details> <summary> 4. 키바나 비주얼라이즈(Kibana Visualize) - 막대 그래프, 파이차트 </summary>

## 4. 키바나 비주얼라이즈(Kibana Visualize) - 막대 그래프, 파이차트

### 창 들어가는방법
1. Analytics에서 Visualize Library 클릭
2. Create new visualization 클릭
3. Explore options 클릭
4. Vertical Bar(막대그래프) 또는 파이차트 검색 후 클릭

- 막대 그래프
![image](https://user-images.githubusercontent.com/28394879/143665723-6e0898bd-93a8-454e-9ca3-4ee30d1e932f.png)
`http://localhost:5601/app/visualize#/create?type=histogram&indexPattern=3be87030-4ec7-11ec-b89d-c5bc45c36b0c&_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:'2015-01-27T02:05:10.924Z',to:now))&_a=(filters:!(),linked:!f,query:(language:kuery,query:''),uiState:(),vis:(aggs:!((enabled:!t,id:'2',params:(customLabel:avg,field:points),schema:metric,type:avg),(enabled:!t,id:'3',params:(field:name,missingBucket:!f,missingBucketLabel:Missing,order:desc,orderBy:'2',otherBucket:!f,otherBucketLabel:Other,size:5),schema:segment,type:terms)),params:(addLegend:!t,addTimeMarker:!f,addTooltip:!t,categoryAxes:!((id:CategoryAxis-1,labels:(filter:!t,show:!t,truncate:100),position:bottom,scale:(type:linear),show:!t,style:(),title:(),type:category)),detailedTooltip:!t,grid:(categoryLines:!f),labels:(show:!f),legendPosition:right,maxLegendLines:1,palette:(name:default,type:palette),radiusRatio:0,seriesParams:!((circlesRadius:3,data:(id:'2',label:avg),drawLinesBetweenPoints:!t,interpolate:linear,lineWidth:2,mode:stacked,show:!t,showCircles:!t,type:histogram,valueAxis:ValueAxis-1)),thresholdLine:(color:%23E7664C,show:!f,style:full,value:10,width:1),times:!(),truncateLegend:!t,type:histogram,valueAxes:!((id:ValueAxis-1,labels:(filter:!f,rotate:0,show:!t,truncate:100),name:LeftAxis-1,position:left,scale:(mode:normal,type:linear),show:!t,style:(),title:(text:avg),type:value))),title:'',type:histogram))`


- 파이차트
![image](https://user-images.githubusercontent.com/28394879/143665340-4669b0b3-744d-45aa-95d9-719f9636e4a7.png)
`http://localhost:5601/app/visualize#/create?type=pie&indexPattern=3be87030-4ec7-11ec-b89d-c5bc45c36b0c&_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:'2015-01-27T02:05:10.924Z',to:now))&_a=(filters:!(),linked:!f,query:(language:kuery,query:''),uiState:(vis:(legendOpen:!f)),vis:(aggs:!((enabled:!t,id:'1',params:(field:points),schema:metric,type:sum),(enabled:!t,id:'2',params:(field:team,missingBucket:!f,missingBucketLabel:Missing,order:desc,orderBy:'1',otherBucket:!f,otherBucketLabel:Other,size:5),schema:segment,type:terms)),params:(addLegend:!f,addTooltip:!t,distinctColors:!f,isDonut:!t,labels:(last_level:!f,percentDecimals:2,position:default,show:!t,truncate:100,values:!t,valuesFormat:percent),legendPosition:right,maxLegendLines:1,nestedLegend:!f,palette:(name:default,type:palette),truncateLegend:!t,type:pie),title:'',type:pie))`


</details>

<details> <summary> 5. 키바나 비주얼라이즈(Kibana Visualize) - 타일 맵, 지포에 표시 </summary>

## 5. 키바나 비주얼라이즈(Kibana Visualize) - 타일 맵, 지포에 표시

1. classes index생성 
```
curl -XPUT http://localhost:9200/classes
``` 

2. mapping 정보 등록(매핑을 통해서 단순 스트링이아닌, 지도에 표시할 수 있는 값임을 나타내주어야 함)
```
curl -XPUT http://localhost:9200/classes/class/_mapping?include_type_name=true&pretty -H 'Content-Type: application/json' -d @classesRating_mapping.json
``` 

3. bulk insert
```
curl -XPOST http://localhost:9200/_bulk?pretty -H 'Content-Type: application/json' --data-binary @classes.json
```

4. 데이터 확인
```
curl -XGET http://localhost:9200/classes/class/1/?pretty
```

5. kibana에서 Management의 StackManagement 클릭
6. Index Pattern 클릭
7. Create index Pattern 클릭 
8. classes* index 생성
9. Visualize에서 Maps 클릭
10. Add layer -> Clusters and grids
11. index pattern를 classes로 적용

![image](https://user-images.githubusercontent.com/28394879/143666574-1cf00a7c-0e66-4fea-9263-dea73cbc1380.png)


</details>


<details> <summary> 6. 키바나 대시보드(Dashboard) </summary>

## 6. 키바나 대시보드(Dashboard)

- 대시보드에 여태까지 만든 visualize들을 원하는 위치, 원하는 크기만큼으로 지정해서 만들어 놓을수 있다.

![image](https://user-images.githubusercontent.com/28394879/143666737-aa40003f-eacd-4ab7-831b-1d50b92df3b8.png)

</details>


# 4. 로그스테시 (Logstash)

<details> <summary> 1. 로그스태시 인스톨 셋업(logstash install) </summary>

## 1. 로그스태시 인스톨 셋업(logstash install)

### 로그 스테시 
- ELK중에서 인풋을 담당
- 로그스테시에서 받은 인풋은 변환되어서 elasticsearch로 들어간다.
- 로그스태시에서 받은 인풋은 원하는 형태로 데이터 형태를 변환한다. (ex: csv -> 수치로 변경) / 변환된 데이터는 elasticsearch로 들어간다. 

![image](https://user-images.githubusercontent.com/28394879/143667031-9a842232-1619-4c3e-b447-6629bb370f66.png)


1. cd /usr/local/bin
2. vi logstash-simple.conf 에 ch04/logstash-simple.conf 내용입력
3. ./logstash -f logstash-simple.conf

입력한 데이터들이 화면에 뿌려지는것을 확인
![image](https://user-images.githubusercontent.com/28394879/143667379-83002be3-1078-4cc2-9707-08e415963fee.png)


</details>

# 5. 실전 ELK 활용한 실데이터 분석

<details> <summary> 1. 실전 인구 분석 </summary>

## 1. 실전 인구 분석

1. logstash 실행 
```
./logstash -f /Users/singyeongdeog/Documents/github_code/ELK/1.elk-stack-data-analysis/ch05/logstash.conf
```

2. kibana 에서 "population" index pattern 등록

3. Discover에서 한국의 1980 ~ 2010년 인구 검색 
![image](https://user-images.githubusercontent.com/28394879/143670077-8ac09097-3e56-45cb-85ab-ca311d545b13.png)

4. Visualize Library의 Vertical bar 에서 1980년도의 각 나라별 인구수 비교 
![image](https://user-images.githubusercontent.com/28394879/143670587-5ecd1ff1-2e59-46bd-a149-2eff7b396ee8.png)

5. Visualize Library의 Pie를 활용하여 나라별 인구수 비교
![image](https://user-images.githubusercontent.com/28394879/143670687-6d580f34-6766-490f-a56a-759cc2dc6a10.png)

</details>

<details> <summary> 2. 실전 주식 분석 </summary>

## 2. 실전 주식 분석

- conf파일의 start_position
  - end: 데이터가 스트리밍형식으로 계속해서 들어올경우 사용가능, 끝에서부터 데이터를 읽음
  - begining: 데이터를 처음부터 읽어야할 경우 사용가능, csv파일 등에서 읽을때 사용, 앞에서부터 읽음

1. logstash 실행 
```
sudo /usr/local/bin/logstash -f /Users/singyeongdeog/Documents/github_code/ELK/1.elk-stack-data-analysis/ch05/logstash_stock.conf
```

2. kibana 에서 "stock" index pattern 등록

3. Discover에서 오픈시간과 클로즈 시간의 주식 가격 검색 
![image](https://user-images.githubusercontent.com/28394879/143672478-600420c6-7e49-4362-8b90-ede3a98871ba.png)

4. Visualize Library의 Line을 활용한 주식 가격 변동 보기
![image](https://user-images.githubusercontent.com/28394879/143672756-95bd9e9c-6d76-43df-abd9-bb3e14d18df6.png)

5. Visualize Library의 Metric을 활용한 주식의 데이터 갯수(Document 개수) 보기
![image](https://user-images.githubusercontent.com/28394879/143672806-4c28d4f3-dcef-42dd-9d55-d7ba9975486e.png)

6. 대시보드에 각종 시각화 구성
![image](https://user-images.githubusercontent.com/28394879/143672849-5adacdbe-87c6-4587-a0cc-6cfb6eae5056.png)



</details>

# 6. ELK 클라우드 로그분석 시스템

<details> <summary> 1. ELK 스택 - 클라우드 로그 분석 시스템 아키텍처 </summary>

## 1. ELK 스택 - 클라우드 로그 분석 시스템 아키텍처

### ELK 소개
- ElasticSearch
  - log를 저장하는 데이터베이스로 활요
- Logstash
  - 발생된 로그를 전달받아서 엘라스틱서치에 저장하는 용도
- Kibana
  - ElasticSearch에 저장된 로그를 브라우저에 출력하는 용도(시각화)


### Filebeat
- 각각의 서버에 설치되어서, 로그 파일에 변화가 있을 때 변화된 로그 파일을 Logstash로 전송한다.

![image](https://user-images.githubusercontent.com/28394879/143726721-7692b358-82ea-4cc1-824e-ab29495e4a84.png)


### Curator
- ELK스택을 운영시에 오래된 데이터를 삭제하지않아서, 디스크 공간 문제가 생길 수 있는데, 이것을 해결해주는것이 Curator이다.
- 손쉽게 데이터 보증기간 및 데이터 최대 사용량을 설정해서 ELK스택의 디스크 공간 문제가 없도록 해준다.

### S3 
- 큐레이터로 한달이상된 데이터를 삭제하는데, 한달이상된 데이터를 봐야되는 경우 S3에 로그를 백업및 복원할 수 있다.
![image](https://user-images.githubusercontent.com/28394879/143726778-cd9b0f85-e1f6-4164-8fda-6410aa0f62c7.png)

</details>

<details> <summary> 2. FileBeat으로 분산 서버 로그 ELK 스택에 전달하기 </summary>

## 2. FileBeat으로 분산 서버 로그 ELK 스택에 전달하기

1. tomcat 설치 
```
brew install tomcat
``` 
2. 톰캣 실행 (brew services start로 하면 catalina.out이 안보임)
```
/usr/local/Cellar/tomcat/10.0.13/bin/catalina start
```   
3. catalina.out 확인
```
tail -f /usr/local/Cellar/tomcat/10.0.13/libexec/logs/catalina.out
```
4. logstash 실행 
```
/usr/local/bin/logstash -f /Users/singyeongdeog/Documents/github_code/ELK/1.elk-stack-data-analysis/ch06/logstash.conf
```
5. filebeat yml 설정 (filebeat.prospectors는 최신버전에선 지원 안함)
```
vi /usr/local/etc/filebeat/filebeat.yml
```
6. filebeat 실행
```
/usr/local/bin/filebeat -e
```
7. 


</details>

<details> <summary> 3. 큐레이터로 ELK스택 디스크 공간 자동으로 관리하기 </summary>

## 3. 큐레이터로 ELK스택 디스크 공간 자동으로 관리하기

1. curator 설치
```
wget https://bootstrap.pypa.io/get-pip.py
sudo python get-pip.py
sudo pip install elasticsearch-curator==5.8.4
```

2. curator 30일 기준 데이터삭제 실행
```
/Library/Frameworks/Python.framework/Versions/3.9/bin/curator /Users/singyeongdeog/Documents/github_code/ELK/1.elk-stack-data-analysis/ch06/delete_indices_time_base.yml --config /Users/singyeongdeog/Documents/github_code/ELK/1.elk-stack-data-analysis/ch06/curator.yml
```

3. curator 300기가 용량 기준 데이터 삭제 실행
```
/Library/Frameworks/Python.framework/Versions/3.9/bin/curator /Users/singyeongdeog/Documents/github_code/ELK/1.elk-stack-data-analysis/ch06/delete_indices_size_base.yml --config /Users/singyeongdeog/Documents/github_code/ELK/1.elk-stack-data-analysis/ch06/curator.yml 
```

4. curator를 cron으로 주기적으로 실행하게 설정할 수 있다. 
```
./ch06/curator_cron
```




</details>

<details> <summary> 4. S3를 활용한 ELK 스택 로그 백업 및 복원 </summary>

## 4. S3를 활용한 ELK 스택 로그 백업 및 복원

1. s3 repository plugin 설치
```
cd /usr/local/bin
./elasticsearch-plugin install repository-s3
brew services restart elasticsearch-full
```

2. elasticsearch BACKUP 설정 (curl_backup_config.sh)
```
curl -XPUT 'http://localhost:9200/_snapshot/s3_elk_backup' -H 'Content-Type: application/json' -d '{
    "type": "s3",
    "settings": {
        "access_key": "[YOUR_ACCESS_KEY]",
        "secret_key": "YOUR_SECRET_KEY",
        "bucket": "YOUR_BUCKET",
        "region": "YOUR_REGION",
        "base_path": "elasticsearch",
        "max_retries": 3
    }
}'
```

3. BACKUP 설정 cron (s3_backup_cron)
```
SHELL=/bin/bash
PATH=/sbin:/bin:/usr/sbin:/usr/bin
HOME=/

# daily
0 0 * * * ec2-user /home/ec2-user/daily_elk_backup.sh > /home/ec2-user/log/elk_backup.log 2>&1
```

4. 3번의 cron에서 돌리고있는 daily_elk_backup.sh
```
TODAY=$(date +'%Y.%m.%d')
YESTERDAY=$(date --date="1 days ago" +'%Y.%m.%d')
echo Today is $TODAY
echo Yesterday $YESTERDAY indices will be stored in S3

INDEX_PREFIXES=''
INDEX_PREFIXES+='tomcat- '
#INDEX_PREFIXES+='filebeat- '
#INDEX_PREFIXES+='database- '

for prefix in $INDEX_PREFIXES;
do
	INDEX_NAME=${prefix}$YESTERDAY
	SNAPSHOT_NAME=$INDEX_NAME"-snapshot"
	echo Start Snapshot $INDEX_NAME
	curl -XPUT "http://localhost:9200/_snapshot/s3_elk_backup/$SNAPSHOT_NAME?wait_for_completion=true" -d '{
		"indices": "'"$INDEX_NAME"'",
		"ignore_unavailable": "true",
		"include_global_state": false
	}'
	echo Successfully completed storing "$INDEX_NAME" in S3
done
```

5. backup 설정 확인
```
curl -XGET localhost:9200/_snapshot/s3_elk_backup/_all\?pretty
```

6. backup한 index 삭제
```
curl -XDELETE 'localhost:9200/tomcat-2017.08.06
``` 

7. index 복원하기 (elk_restore.sh)
```
sh elk_restore.sh tomcat-2017.08.06
```







</details>