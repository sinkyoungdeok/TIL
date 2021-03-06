
# 1. 도메인 주도 설계란 무엇인가?

## 소프트웨어와 도메인의 관계
> 소프트웨어란 도메인으로부터 시작되고 뗄 수 없는 관계이다.  
> 사소한 경우를 제외하면, 단순히 앉자마자 코드를 작성할 수 없다.    
> 소프트웨어 프로젝트를 시작 할 때, 대상 도메인과 조화가 중요하다.  
> 도메인과 조화를 이루는 소프트웨어는 은행 업무를 모르는 사람도 코드를 읽어 보는 것만으로 은행 업무에 대해 많은 것을 배울 수 있을정도로 도메인에 깊이 뿌리내려야 한다.

## 도메인 모델
> 전문가의 머리에 들어 있는 지식자체가 도메인 모델이 아니라, 그 지식에서 선택적으로 추상화하여 엄격하게 조직화 한 것이다.  
> 대상 도메인에 대한 내부적 표현으로서 설계와 개발 프로세스 내내 반드시 필요하다.  
> 때로는 하나의 도메인이 인간의 머리속으로 한 번에 다룰 수 없으므로 정보를 조직화, 체계화하고, 작은부분으로 나누어 논리적 모듈로 그룹화하여 하나씩 다루어야 한다.  
> 때로는 도메인의 특정 부분들을 제외해 버리기도 한다.  
> 머릿속에 있는 도메인 모델을 바깥으로 끄집어내어 도메인 전문가, 설계자와 개발자 들과 의사소통해야한다.  

## 코드 설계
> 도메인 모델로 코드 설계를 시작할 수 있다.  
> 코드설계는 세부사항에 관한 작업이고, 소프트웨어 설계는 큰그림을 다루는 작업이다.  
> 세부사항에 관한 작업이지만, 최종 제품은 좋은 코드 설계 없이는 불가능한 만큼 중요한 작업이다.
> 좋은 코드 설계를 위해 편리하게 쓰이는 여러 디자인 패턴들이 있으며 적절하게 적용해야 한다.

## 소프트웨어 설계 방법  
> 폭포수 설계 방법은 한 방향으로만 흐르는 결함과 한계를 지닌 방법이다.  
> 폭포수 설계 방법과는 반대인 애자일 방법론이 있다.  비
> 폭포수 방식은 모든 요구사항을 프로젝트 초기에 확정하려고 하는 반면에,  
> 애자일 방식은 구현을 변경에 대해 유연성을 확보하고 비즈니스 이해관계자의 지속적인 참여와 수많은 리팩터링 작업을 한다.  
> 애자일 방식에서 개발팀은 고객의 도메인에 대해 점점 더 많이 이해하고 고객의 요구를 만족시키는 소프트웨어를 더 잘 만들 수 있게 한다.  

## 도메인 지식 쌓기
> 도메인 전문가로부터 수많은 정보안에서 규칙을 찾아내야 한다.   
> 규칙을 찾아내기 위해서 도메인 전문가와의 커뮤니케이션(지식 교환)을 통해 필수 도메인 개념들을 다이어그램 등 과 같은 방법으로 추상화 해야 한다.  
> 도메인 전문가로부터 소프트웨어 아키텍트 혹은 개발자는 한 방향으로만 이루어지는 것이 아니다.  
> 즉 도메인 모델은 소프트웨어 전문가와 도메인 전문가의 두 전문 영역이 만나는 장소가 된다. 

# 2. 유비쿼터스 언어

## 공통 언어의 필요성 
> 도메인 전문가는 개발지식을 모르는데, 개발자는 개발지식으로 말하려는 습관이 있다.  
> 개발자는 도메인 전문영역을 모르는데, 도메인 전문가는 외부인들이 이해하기 어려운 전문용어로 말하려는 습관이 있다.  
> 이러한 의사소통 방식의 차이를 극복하려면 모델에 관련된 정보들로 이루어진 공통언어를 사용해야 한다. 이것을 유비쿼터스 언어라고 한다.   
> 유비쿼터스 언어는 모든 의사소통의 형식에 사용되어야 한다.    

## 유비쿼터스 언어 만들기
> 개발자만의 용어는 사용을 자제하고, 유비쿼터스 언어로 의사소통을 해야 한다.  
> 개발자는 도메인 전문가와의 커뮤니케이션을 토대로 알아낸 모델의 주요 개념을 코드로 구현해 나가야 한다.

## 유비쿼터스 언어 활용 
> 1차적으로는 유비쿼터스 언어를 사용한 다이어그램으로 커뮤니케이션을 진행한다.  
> 요소의 수가 적을 때는 URL 다이어그램이 매우 유용하다.  
> 요소의 수가 많아 질수록, UML 다이어그램은 표현된 개념들의 의미와 개념에서 파생되는 객체들이 무슨일을 하는지에 대한 중요한 정보를 전달할 수 없다.  
> 그러므로 요소의 수가 많다면 문서를 사용하거나, 모델의 작은 부분의 다이어그램으로 구성, 훌륭하게 쓰인 코드 등도 좋은 의사소통 방법이다.  

## 문서 작성 주의점
> 문서에는 모델과 동일한 내용이어야 한다.  
> 잘못된 언어를 사용하고 모델을 반영하지 못하는 오래된 문서가 되지 않도록 한다.  




## 궁긍한점 
1. 개발자의 코드는 유비쿼터스 언어로만 구현해야 하는지? 

# 3. 모델 주도 설계

## 모델과 코드
> 도메인 모델을 만들고 나면, 모델을 코드로 구현하는 작업을 수행하는데 이 단계도 매우 중요하다.  
> 좋은 모델을 만들었음에도 불구하고, 코드로 적절하게 바꾸지 못하면 결국 좋지 않은 소프트웨어가 만들어진다.  

## 코드로 구현할 때의 주의점
> 모델을 보고 코드로 구현될 수 없는 개념이나 관계를 발견 할 땐, 기존 모델을 차용한 고유한 설계를 만드는 것이 아니라 모델을 수정해야 한다.  
> 분석적으로 정확한 모델을 가지고 있다는 것이 코드로 바로 변환할 수 있음을 의미하지는 않는다.  
> 분석적으로 정확한 모델이 때로는 소프트웨어 설계 원칙을 꺠뜨리는 좋지 않은 상황이 발생한다.  

## 분석 모델 
> 코드 설계에서 분석을 분리하고, 분석과 코드 설계를 보통 서로 다른 사람이 작업하도록 한다.  
> 분석 모델은 비즈니스 도메인 붓거의 결과물일 뿐이고, 소프트웨어 구현은 염두에 두지 않는다.  
> 분석 모델은 도메인을 이해하기 위해서만 사용한다.  
> 분석 모델이 완성되면 설계를 담당할 개발자에게 전달되고, 코딩이 시작되면 폐기한다.  
> 도메인에 충실한 모델이 객체의 영속성에 대해 심각한 문제를 지녔거나 수용 불가능한 수준이라는 것을 나중에 알 수 있게될 수 있으므로 좋은 방법은 아니다.

## 도메인 모델링과 설계를 밀접하게 관련시키기
> 분석 모델과 코드 설계를 분리하는 것 보다 좀 더 나은 접근 방식이다.

# 4. 깊은 통찰을 향한 리팩터링

# 5. 모델 무결성 보존

# 6. 오늘날 DDD는 중요하다 