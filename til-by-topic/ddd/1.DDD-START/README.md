
# [1.도메인 모델 시작](./1.도메인-모델-시작)

<details> <summary> 1. 도메인 </summary>

## 1. 도메인

- 개발자 입장에서 온라인 서점은 구현해야 할 소프트웨어의 대상이 된다. 온라인 서점 소프트웨어는 온라인으로 책을 판매하는데 필요한
상품 조회, 구매, 결제, 배송추적 등의 기능을 제공해야 한다. 이때 '온라인 서점' 은 소프트웨어로 해결하고자 하는 문제 영역
즉, 도메인(domain)에 해당된다.
- 한 도메인은 다시 하위 도메인으로 나눌 수 있다.
    ![image](https://user-images.githubusercontent.com/28394879/133535540-82934f28-1bd8-4764-b8f8-dd13e502ea58.png)
    - 위 그림은 '온라인서점' 도메인의 하위 도메인이다.
    - 카탈로그 하위 도메인: 고객에게 구매할 수 있는 상품 목록 제공
    - 주문 하위 도메인: 고객의 주문을 처리
    - 혜택 하위 도메인: 쿠폰이나 특별 할인과 같은 서비스 제공
    - 배송 하위 도메인: 고객에게 구매한 상품을 전달하는 일련의 과정을 처리
    - 한 하위 도메인은 다른 하위 도메인과 연동하여 완전한 기능을 제공 (ex) 고객이 물건을 구매하면 주문, 결제, 배송, 혜택 하위 도메인의 기능과 엮임 )

- 특정 도메인을 위한 소프트웨어라고 해서 도메인이 제공해야 할 모든 기능을 구현 하는 것은 아니다.
    - 많은 온라인 쇼핑몰이 자체적으로 배송 시스템을 구축하기보다 외부 배송 업체의 시스템을 사용하고 배송추적에 필요한 기능만 일부 연동한다.
    - ![image](https://user-images.githubusercontent.com/28394879/133536165-37ee1c0a-0873-49b3-b952-a7fb9ac073b4.png)
        - 배송 도메인의 일부 기능은 자체 시스템으로 구현, 일부 기능은 외부 업체의 시스템 사용
        - 결제는 대행 업체 이용해서 처리

- 도메인마다 고정된 하위 도메인이 존재하는 것은 아니다. (소규모 쇼핑몰은 엑셀과 같은 도구를 이용해서 수작업으로 정산을 처리)

- 하위 도메인을 어떻게 구성할지 여부는 상황에 따라 달라진다.
    - 기업 고객을 대상으로 대형 장비를 판매하는곳은 온라인으로 카탈로그를 제공하는 주문서를 받는 정도만 필요 ( 온라인 결제나 배송추적과 같은 기능은 필요 X )
    - 반면에 의류나 액세서리처럼 일반 고객을 대상으로 물건을 판매한다면 카탈로그, 리뷰, 주문, 결제, 배송, 회원 기능이 필요


</details>


<details> <summary> 2. 도메인 모델 </summary>

## 2. 도메인 모델

- 특정 도메인을 개념적으로 표현한 것
- 예) 주문도메인
    - 온라인 쇼핑몰에서 주문을 하려면 상품을 몇개 살지 선택하고 배송지를 입력
    - 선택한 상품 가격을 이용해서 총 지불 금액을 계산하고 금액 지불을 위한 결제 수단 선택
    - 주문한 뒤에도 배송 전이면 배송지 주소를 변경하거나 주문을 취소

### 객체 기반 주문 도메인 모델
![image](https://user-images.githubusercontent.com/28394879/133551841-5d704060-1b00-4638-a99d-ff894e6bab21.png)
- 주문은 주문번호(orderNumber)와 지불할 총금액(totalAmounts)가 있다.
- 배송정보(Shipping)를 변경(changeShipping)할 수 있다.
- 주문을 취소(cancel)할 수 있다.
- 즉, 도메인 모델을 사용하면 여러 관계자들이 동일한 모습으로 도메인을 이해하고 도메인 지식을 공유하는데 도움이 된다.
- 도메인을 이해하려면 도메인이 제공하는 기능과 도메인의 주요 데ㅣ터 구성을 파악해야 하는데, 이런 면에서 기능과 데이터를 함께 보여주는 객체 모델은 도메인을 모델링하기에 적합하다.

### 상태 다이어그램을 이용한 주문 상태 모델링
![image](https://user-images.githubusercontent.com/28394879/133552688-c2d3960b-1e6c-4918-b2d4-6f1438bd2294.png)
- 상품 준비중 상태에서 주문을 취소하면 결제 취소가 함께 이루어진다는 것을 알 수 있다.

- 도메인을 이해하는 데 도움이 된다면 표현 방식이 무엇인지는 중요하지 않다.
    - 도메인 모델을 표현할 때 클래스 다이어그램이나 상태 다이어그램과 같은 UML 표기법만 사용해야 하는 것은 아니다.
    - 관계가 중요한 도메인이라면 그래프를 이용해서 도메인을 모델링 할 수 있다.
    - 계산 규칙이 중요하다면 수학 공식을 활용해서 도메인 모델을 만들수도 있다.

- 도메인 모델은 기본적으로 도메인 자체를 이해하기 위한 개념 모델이다.
- 개념 모델을 이용해서 바로 코드를 작성할 수 있는 것은 아니기에 구현 기술에 맞는 구현 모델이 따로 필요하다.
- 개념 모델과 구현 모델은 서로 다른 것이지만 구현 모델이 개념 모델을 최대한 따르도록 할 수는 있다.
    - 예) 객체 기반 모델을 이용해서 도메인을 표현 했다면 객체 지향 언어를 이용해서 개념 모델에 가깝게 구현할 수 있다.
    - 예) 수학적인 모델을 사용한다면 함수를 이용해서 도메인 모델과 유사한 구현 모델을 만들 수 있다.

### 하위 도메인 모델
- 도메인은 다수의 하위 도메인으로 구성
- 하위 도메인이 다루는 영역은 서로 다르기 떄문에 같은 용어라도 하위 도메인마다 의미가 달라질 수 있다.
    - 예) 카탈로그 도메인의 상품이 상품 가격, 상세 내용을 담고 있는 정보를 의미한다면 배송 도메인의 상품은 고객에게 실제 배송되는 물리적인 상품을 의미한다.
- 도메인에 따라 용어의 의미가 결정되므로, 여러 하위 도메인을 하나의 다이어그램에 모델링하면 안 된다.
    - 카탈로그와 배송 도메인 모델을 구분하지 않고 하나의 다이어그램에 함께 표시 하게 될 경우
        - 다이어그램에 표시한 '상품'은 카탈로그의 상품과 배송의 상품 의미를 함께 제공하기에, 카탈로그 도메인에서의 상품을 제대로 이해하는데 방해가 된다.
- 모델의 각 구성요소는 특정 도메인을 한정할 대 비로소 의미가 완젆해지기 때문에, 각 하위 도메인마다 별도로 모델을 만들어야 한다. (카탈로그 하위 도메인 모델과 배송 하위 도메인 모델을 따로 만들어야 한다)

</details>

<details> <summary> 3. 도메인 모델 패턴 </summary>

## 3. 도메인 모델 패턴

### 일반적인 애플리케이션의 아키텍처
![image](https://user-images.githubusercontent.com/28394879/133555540-2886ce28-8f46-49ab-a204-1d38bce84105.png)

|계층(Layer)|설명|
|------|---|
|사용자 인터페이스(UI) 또는 표현(Presentation)|사용자의 요청을 처리하고 사용자에게 정보를 보여줌. 여기서 사용자는 소프트웨어를 사용하는 사람 뿐만 아니라 외부 시스템도 사용자가 될 수 있다.|
|응용(Application)|사용자가 요청한 기능을 실행한다. 업무 로직을 직접 구현하지 않으며 도메인 계층을 조합해서 기능을 실행|
|도메인| 시스템이 제공할 도메인의 규칙을 구현|
|인프라스트럭처(infrastructure)|데이터베이스나 메시징 시스템과 같은 외부 시스템과의 연동을 처리|

- 도메인 모델은 아키텍처상의 도메인 계층을 객체 지향 기법으로 구현하는 패턴을 말한다.
- 도메인 계층은 도메인의 핵심 규칙을 구현한다.
    - 예) 주문 도메인에서의 도메인 계층
    - '출고 전에 배송지를 변경할 수 있다'는 규칙
    - '주문 취소는 배송 전에만 할 수 있다'는 규칙
- 도메인 규칙을 객체 지향 기법으로 구현하는 패턴이 도메인 모델 패턴이다.

```
public class Order {
    private OrderState state;
    private ShippingInfo shippingInfo;

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        if (!state.isShippingChangeable()) {
            throw new illeagalStateException("can't change shipping in " + state);
        }
        this.shippingInfo = newShippingInfo;
    }
    public void changeShipped() {
        // 로직 검사
        this.state = OrderState.SHIPPED;
    }
    ...
}


public enum OrderState {
    PAYMENT_WAITING {
        public boolean isShippingChangeable() {
            return true;
        }
    },
    PREPARING {
        public boolean isShippingChangeable() {
            return true;
        }
    },
    SHIPPED, DELIVERING, DELIVERY_COMPLETED;

    public boolean isShippingChangeable() {
        return false;
    }
}
```

- 위 코드는 주문 도메인의 일부 기능을 도메인 모델 패턴으로 구현한 것이다.
- 주문 상태를 표현하는 OrderState는 배송지를 변경할 수 있는지 여부를 검사할 수 있는 isShippingChangeable() 메서드를 제공하고 있다.
- 주문 대기 중(PAYMENT_WAITING) 상태와 상품 준비 중(PREPARING) 상태의 isShippingChangeable() 메서즈는 true를 리턴한다.
- 즉, OrderState는 주문 대기 중이거나 상품 준비 중에는 배송지를 변경할 수 있다는 도메인 규칙을 구현하고 있다.
- 실제 배송지 정보를 변경하는 Order 클래스의 changeShippingInfo() 메서드는 OrderState의 isShippingChangeable() 메서드를 이용해서 변경 가능 여부를 확인
한 후 변경 가능한 경우에만 배송지를 변경한다.


```
public class Order {
    private OrderState state;
    private ShippingInfo shippingInfo;

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        if (!state.isShippingChangeable()) {
            throw new illeagalStateException("can't change shipping in " + state);
        }
        this.shippingInfo = newShippingInfo;
    }
    public void changeShipped() {
        return state == OrderState.PAYMENT_WAITING ||
            state == OrderState.PREPARING;
    }
    ...
}


public enum OrderState {
    PAYMENT_WAITING, PREPARING, SHIPPED, DELIVERING, DELIVERY_COMPLETED;
}
```

- Order 클래스에서 changeShipped를 판단하도록 수정한 코드
- 배송지 변경이 가능한지 여부를 판단할 규칙이 주문 상태와 다른 정보를 함께 사용한다면 배송지 변경 가능 여부 판단을 OrderState만으로 할 수 없으므로
로직 구현을 Order에서 해야 할 것이다.
- 배송지 변경 가능 여부를 판단하는 기능이 Order에 있든, OrderState에 있든 중요한 점은 주문과 관련된 중요 업무 규칙을 주문 도메인 모델인 Order, OrderState에서 구현한다는 점이다.
- 핵심 규칙을 구현한 코드는 도메인 모델에만 위치하기 떄문에 규칙이 바뀌거나 규칙을 확장해야 할 때 다른 코드에 영향을 덜 주고 변경 내역을 모델에 반영할 수 있다.

> 노트
> '도메인 모델' 이란 용어는 도메인 자체를 표현하는 개념적인 모델을 의미하지만, 도메인 계층을 구현할 때
> 사용하는 객체 모델을 언급할 때에도 '도메인 모델'이란 용어를 사용한다.
> 여기에서도 도메인 계층의 객체 모델을 표현할 때 도메인 모델이라고 표현하고 있다.

### 개념 모델과 구현 모델
- 개념모델: 순수하게 문제를 분석한 결과물
- 개념모델: 데이터베이스, 트랜잭션 처리, 성능, 구현 기술과 같은 것들을 고려하고 있지 않기 떄문에 실제 코드를 작성할 때 개념 모델을 있는 그대로 사용할 수 없다.
- 그래서 개념 모델을 구현 가능한 형태의 모델로 전환하는 과정을 거치게 된다.
- 개념 모델을 만들 때 처음부터 완벽하게 도메인을 표현하는 모델을 만드는 시도를 할 수 있지만 실제로는 불가능에 가깝다.
- 프로젝트 초기에 완벽한 도메인 모델을 만들더라도 결국 도메인에 대한 새로운 지식이 쌓이면서 모델을 보완하거나 수정하는 일이 발생한다.
- 처음부터 완벽한 개념 모델을 만들기보다는 전반적인 개요를 알 수 있는 수준으로 개념 모델을 작성해야 한다.
- 프로젝트 초기에는 개요 수준의 개념 모델로 도메인에 대한 전체 윤곽을 이해하는 데 집중하고,
구현하는 과정에서 개념 모델을 구현 모델로 점진적으로 발전시켜 나가야 한다.

</details>

<details> <summary> 4. 도메인 모델 도출 </summary>

## 4. 도메인 모델 도출

- 도메인을 모델링 할때 기본이 되는 작업은 모델을 구성하는 핵심 구성요소, 규칙, 기능을 찾는 것이다.
- 이 과정은 요구사항에서 출발한다.

### 주문 도메인 요구사항
- 최소 한 종류 이상의 상품을 주문해야 한다.
- 한 상품을 한 개 이상 주문할 수 있다.
- 총 주문 금액은 각 상품의 구매 가격 합을 모두 더한 금액이다.
- 각 상품의 구매 가격 합은 상품 가격에 구매 개수를 곱한 값이다.
- 주문할 때 배송지 정보를 반드시 지정해야 한다.
- 배송지 정보는 받는 사람 이름, 전화번호, 주소로 구성된다.
- 출고를 하면 배송지 정볼르 변경 할 수 없다.
- 출고 전에 주문을 취소할 수 있다.
- 고객이 결재를 완료하기 전에는 상품을 준비하지 않는다.

### 주문 도메인 요구사항 - 분석
- 주문
    - '출고상태로 변경하기'
    - '배송지 정보 변경하기'
    - '주문 취소하기'
    - '결제완료로 변경하기'

### 주문 도메인 요구사항 - 코드
```
public class Order {
    public void changeShipped() {...}
    public void changeShippingInfo(ShippingInfo newShipping) { ... }
    public void cancel() { ... }
    public void completePayment() { ... }

}
```

### 주문 도메인 요구사항1
- 한 상품을 한 개 이상 주문할 수 있다.
- 각 상품의 구매 가격 합은 상품 가격에 구매 개수를 곱한 값이다.

### 주문 도메인 요구사항1 - 분석
- 주문 항목을 표현하는 OrderLine은 적어도 주문할 상품, 상품의 가격, 구매 개수를 포함 해야 한다.
- 각 구매 항목의 구매 가격도 제공 해야 한다.

### 주문 도메인 요구사항1 - 코드
```
public class OrderLine {
    private Product product;
    private int price;
    private int quantity;
    private int amounts;

    public OrderLine(Product product, int price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private int calculateAmounts() {
        return price * quantity;
    }

    public int getAmounts() { ... }
    ...
}
```
- orderLine은 한 상품(product 필드)을 얼마에(price 필드), 몇 개 살지(count 필드)를 필드에 담고 있고
calculateAmounts 메서드로 구매 가격을 구하는 로직을 구현 하고 있다.

### 주문 도메인 요구사항2
- 최소 한 종류 이상의 상품을 주문해야 한다.
- 총 주문 금액은 각 상품의 구매 가격 합을 모두 더한 금액이다.

### 주문 도메인 요구사항2 - 분석
- 한 종류 이상의 상품을 주문할 수 있으므로 Order는 최소 한 개 이상의 OrderLine을 포함 해야 한다.
- OrderLine으로 부터 총 주문 금액을 구할 수 있다.

### 주문 도메인 요구사항2 - 코드
```
public class Order {
    private List<OrderLine> orderLines;
    private int totalAmounts;

    public Order(List<OrderLine> orderLines) {
        setOrderLines(orderLines);
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new illegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts() {
        this.totalAmounts = new Money(orderLines.stream()
                .mapToInt(x -> x.getAmounts().getValue()).sum();
    }

    ... // 다른 메서드
}
```
- Order는 한 개 이상의 OrderLine을 가질 수 있으므로 Order를 생성할 때 OrderLine 목록을 List로 전달한다.
- 생성자에서 호출하는 setOrderLines() 메서드는 요구사항에 정의한 제약 조건을 검사한다.
- 요구사항에 따르면 최소 한 종류 이상의 상품을 주문해야 하므로 setOrderLines() 메서드는 verifyAtLeastOneOrMoreOrderLines() 메서드를 이용해서
OrderLine이 한 개 이상 존재하는지 검사한다.
- calculateTotalAmounts() 메서드를 이용해서 총 주문 금액을 계산한다.

```
public class ShippingInfo {
    private String receiverName;
    private String receiverPhoneNumber;
    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingZipcode;

    ... 생성자, getter
}
```

### 주문 도메인 요구사항3
- '주문할 때 배송지 정보를 반드시 지정해야 한다'

### 주문 도메인 요구사항3 - 분석
- Order를 생성할 때 OrderLine의 목록뿐만 아니라 ShippingInfo도 함께 전달해야 한다.

### 주문 도메인 요구사항3 - 코드
```
public class Order {
    private List<OrderLine> orderLines;
    private int totalAmounts;
    private ShippingInfo shippingInfo;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo ) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null)
            throw new illegalArgumentException("no ShippingInfo");
        this.shippingInfo = shippingInfo;
    }
    ...
}
```
- 생성자에서 호출하는 setShippingInfo() 메서드는 ShippingInfo가 null이면 익셉션이 발생하는데, 이렇게 함으로써
'배송지 정보 필수'라는 도메인 규칙을 구현

### 주문 도메인 요구사항4
- 출고를 하면 배송지 정보를 변경할 수 없다.
- 출고 전에 주문을 취소할 수 있다.
- 고객이 결제를 완료하기 전에는 상품을 준비하지 않는다.

### 주문 도메인 요구사항4 - 분석
- 출고 상태에 따라 배송지 정보 변경 기능과 주문 취소 기능이 제약을 받는다.
- 주문은 적어도 출고 상태를 표현할 수 있어야 한다.
- 결제 완료 전을 의미하는 상태와 결제 완료 내지 상품 준비 중이라는 상태가 필요하다.

### 주문 도메인 요구사항4 - 코드
```
public enum OrderState {
    PAYMENT_WAITING, PREPARING, SHIPPED, DELIVERING, DELIVERY_COMPLETED, CANCELED;
}
```

```
public class Order {
    private OrderState state;

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo)
    }
    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }
    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING)
            throw new illegalStateException("already shipped");
    }
    ...
}
```
- 배송지 변경이나 주문 취소 기능은 출고 전에만 가능하다는 제약 규칙이 있으므로 changeShippingInfo()와 cancel()
은 verifyNotYetShipped()메서드를 먼저 실행하게 했다.

> 노트
> 앞서 도메인 모델 패턴을 정리할 때에는 isShippingChangeable이라는 이름으로 제약 조건을 검사했는데 지금은
> verifyNotYetShipped라는 이름으로 변경했다. 이름을 바꾼 이유는 그 사이에 도메인을 더 잘 알게 되었기 때문이다.
> 최초에는 배송지 정보 변경에 대한 제약 조건만 파악했기 때문에 '배송지 정보 변경 가능 여부 확인'을 의미하는 isShippingChangeable라는
> 이름을 사용했다. 그런데, 요구사항을 분석하면서 배송지 정보 변경과 주문 취소가 둘다 '출고 전에 가능'하다는 제약 조건을
> 알게 되었고 이를 반영하기 위해 메서드 이름을 verifyNotYetShipped로 변경했다.



</details>

<details> <summary> 5. 엔티티와 밸류 </summary>

## 5. 엔티티와 벨류
- 도출한 모델은 크게 엔티티(Entity)와 벨류(Value)로 구분
- 앞서 요구사항 분석 과정으로 만든 모델 
  - ![image](https://user-images.githubusercontent.com/28394879/133707691-a201753b-7ccd-4d71-8b96-4ef1b810cc4f.png)
  - 크게 엔티티와 벨류로 구분된다. 
- 엔티티와 벨류를 제대로 구분해야 도메인을 올바르게 설계하고 구현할 수 있다.

> 노트
> Value타입은 우리말로 하면 값 타입으로 표현할 수 있지만
> '값'이란 단어를 여러 의미로 사용할 수 있기 때문에 
> 여기에서는 '밸류'를 사용한다.

### 엔티티 
- 큰특징은 식별자를 갖는다.
- 엔티티 객체마다 고유해서 각 엔티티는 서로 다른 식별자를 갖는다.
- 주문에서 배송지 주소가 바뀌거나 상태가 바뀌더라도 주문번호가 바뀌지 않는 것처럼 엔티티의 식별자는 바뀌지 않는다. 
- 엔티티를 생성하고 엔티티의 속성을 바꾸고 엔티티를 삭제할 때까지 식별자는 유지된다.
- 엔티티의 식별자는 바뀌지 않고 고유하기 때문에 두 엔티티 객체의 식별자가 같으면 두 엔티티는 같다고 판단할 수 있다.

### 엔티티의 식별자 생성
- 엔티티의 식별자를 생성하는 시점은 도메인의 특징과 사용한느 기술에 따라 달라진다. 
- 흔히 식별자는 다음 중 한가지의 방식으로 생성한다.
  - 특정 규칙에 따라 생성
    - 주문번호, 운송장번호, 카드번호와 같은 식별자는 특정 규칙에 따라 생성한다. 
    - 이 규칙은 도메인에 따라 다르고, 같은 주문번호라도 회사마다 다르다.
    - 흔히 사용하는 규칙은 현재 시간과 다른 값을 함꼐 조합하는 것이다.
  - UUID 사용
    - 다수의 개발언어가 UUID 생성기를 제공하고 있으므로 마땅한 규칙이 없다면 UUID를 식별자로 사용해도 된다. 
    - 자바의 경우 java.util.UUID 클래스를 사용하면 UUID를 생성할 수 있다.
    - `UUID uuid = UUID.randomUUID(); // 615f2ab9-c374-4b50-9420-2154594af151 `
  - 값을 직접 입력
    - 회원의 아이디나 이메일과 같은 식별자는 값을 직접 입력한다.
    - 사용자가 직접 입력하는 값이기 떄문에 식별자를 중복해서 입력하지 않도록 사전에 방지해야 된다.
  - 일련번호 사용(시퀀스나 DB의 자동 증가 칼럼 사용)
    - 주로 데이터베이스가 제공하는 자동 증가 기능을 사용한다.
    - 오라클을 사용한다면 시퀀스를 이용해서 자동 증가 식별을 구한다.
    - MySQL을 사용한다면 자동 증가 칼럼(auto_increament 칼럼)을 이용해서 일련번호 식별자를 생성한다.
    - 자동 증가 칼럼은 DB테이블에 데이터를 삽입해야 비로소 값을 알 수 있기 떄문에 테이블에 데이터를 추가하기 전에는 식별자를 알 수 없다. (엔티티 객체를 생성 할 때 식별자를 전달할 수 없다)
  - 식별자를 먼저 만들고 엔티티 객체를 생성할 떄 식별자를 전달 
    ```java
        //엔티티를 생성하기 전에 식별자 생성
        String orderNumber = orderRepository.generate();

        Order order = new Order(orderNumber, ...);
        orderRepository.save(order);
    ```

### 밸류 타입
- ShippingInfo 클래스는 받는 사람과 주소에 대한 데이터를 갖고 있다.
  ```java
    public class ShippingInfo {
        private String receiverName; // 받는사람
        private String receiverPhoneNumber; // 받는사람

        private String shippingAddress1; // 주소
        private String shippingAddress2; // 주소
        private String shippingZipcode; //주소
        
        // ... 생성자, getter
    } 
  ```
    - ShippingInfo 클래스의 receiverName 필드와 receiverPhoneNumber 필드는 서로 다른 두 데이터를 담고 있지만 두 필드는 개념적으로 받는 사람을 의미한다. 
    - 즉, 두 필드는 실제로 한 개의 개념을 표현하고 있다.
    - 비슷하게 shippingAddress1 필드, shippingAddress2, shippingZipcode 필드는 주소라는 하나의 개념을 표현한다.
- 밸류 타입을 개념적으로 완전한 하나르 표현할 때 사용한다.
- 예) 받는 사람을 위한 밸류 타입인 Receiver
  ```java

    public class Receiver {
        private String name;
        private String phoneNumber;

        public Receiver(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }
        
        public String getPhoneNumber() {
            return phoneNumber;
        }
    }
  ```
    - Receiver는 '받는 사람' 이라는 도메인 개념을 표현한다.
    - 앞서 ShippingInfo의 receiverName 필드와 receiverPhoneNumber 필드가 필드 이름을 통해서 받는 사람을 위한 데이터라는 것을 유추한다면, Receiver는 그 자체로 받는 사람을 뜻한다.
    - 밸류 타입을 사용함으로써 개념적으로 완전한 하나를 잘 표현할 수 있다.
- 예) 주소르 위한 밸류 타입인 Address
```java
public class Address {
    private String address1;
    private String address2;
    private String zipcode;

    public Address(String address1, String address2, String zipcode) {
        this.address1 = address1;
        this.address2 = address2;
        this.zipcode = zipcode;
    }
}
```
- 밸류 타입을 이용한 ShippingInfo 클래스 
  ```java
  public class ShippingInfo {
      private Receiver receiver;
      private Address address;

      //... 생성자, get 메서드
  }
  ``` 
    - 배송정보가 받는 사람과 주소로 구성된다는 것을 쉽게 알 수 있다.
- 밸류 타입이 꼭 두개 이상의 데이터를 가질 필요는 없다.
- 의미를 명확하게 표현하기 위해 밸류 타입을 사용하는 경우도 있다.
  - 예) OrderLine
    ```java
    public class OrderLine {
        private Product product;
        private int price;
        private int quantity;
        private int amounts;
        //...
    }
    ``` 
    - OrderLine의 price와 amounts는 int 타입의 숫자를 사용하고 있지만 이들이 의미하는 값은 '돈'이다.
    - 따라서, '돈'을 의미하는 Money 타입을 만들어 사용하면 코드를 이해하는데 도움이 된다.
  - 예) OrderLine의 price를 위한 Money
    ```java
    public class Money {
        private int value;

        public Money(int value) {
            this.money = money;
        }
        
        public int getValue() {
            return this.value;
        }
    }
    ``` 
  - 예) Money를 이용한 OrderLine
    ```java
    public class OrderLine {
        private Product product;
        private Money price;
        private int quantity;
        private Money amounts;
    }
    ``` 
- 밸류 타입을 사용할 때의 또 다른 장점은 밸류 타입을 위한 기능을 추가 할 수 있다.
  - 예) Money타입은 돈 계산을 위한 기능을 추가 할 수 있다.
    ```java
    public class Money {
        private int value;

        //... 생성자, getValue()

        public Money add(Money money) {
            return new Money(this.value + money.value);
        }

        public Money multiply(int multiplier) {
            return new Money(value * multiplier);
        }
    }
    ``` 
    - Money를 사요하는 코드는 이제 '정수 타입 연산'이 아니라 '돈 계산' 이라는 의미로 코드를 작성할 수 있다.
- 밸류 객체의 데이터를 변경할 때는 기존 데이터를 변경하기보다는 변경한 데이터를 갖는 새로운 밸류 객체를 생성하는 방식을 선호한다.
  - 예) Money클래스의 add() 메서드
    ```java
    public class Money {
        private int value;

        public Money add(Money money) {
            return new Money(this.value + money.value);
        }

        // value를 변경할 수 잇는 메서드 없음
    }
    ```
- Money처럼 데이터 변경 기능을 제공하지 않는 타입을 불변(immutable)이라고 표현한다.
- 밸류 타입을 불변으로 구현하는 이유는 여러가지가 있지만 가장 중요한 이유는 안전한 코드를 작성할 수 있다는 것이다.
  - 예) OrderLine을 생성하려면 다음 코드 처럼 Money객체를 전달해야 한다.
    ```java
    Money price = ...;
    OrderLine line = new OrderLine(product, price, quantity);
    // 만약 price.setValue(0)로 값을 변경할 수 있다면?
    ``` 
  - 예) Money가 setValue()와 같은 메서드를 제공해서 값을 변경할 수 있다면? (하면안된다)
    ```java
    Money price = new Money(1000);
    OrderLine line = new OrderLine(product, price, 2); // -> [price=1000, quantity=2,amounts=2000]
    price.setValue(2000); // -> [price=2000, quantity=2, amounts=2000]
    ``` 
        - 참조 투명성과 관련된 문제가 생긴다.
  - 이런 문제가 발생하지 않도록 하려면 OrderLine생성자는 다음과 같이 새로운 Money 객체를 생성하도록 코드를 작성해야 한다.
    ```java
    public class OrderLine {
        //...
        private Money price;
        
        public OrderLine(Product product, Money price, int quantity) {
            this.product = product;
            // Money가 불변 객체가 아니라면,
            // price 파라미터가 변경될 때 발생하는 문제를 방지하기 위해
            // 데이터를 복사한 새로운 객체를 생성해야 한다.
            this.price = new Money(price.getValue());
            this.quantity = quantity;
            this.amounts = calculateAmounts();
        }
    }
    ``` 
    - Money가 불변이면 이런 코드를 작성할 필요가 없다.
- 엔티티 타입의 두 객체가 같은지 비교할 때 주로 식발져를 사용한다면 두 밸류 객체가 같은지 비교할 떄는 모든 속성이 같은지 비교해야 한다.
  ```java
  public class Receiver {
      private String name;
      private String phoneNumber;
      
      public boolean equals(Object other) {
          if(other == null) return false;
          if(this == other) return true;
          if(! (other instanceof Receiver) ) return false;
          Receiver that = (Receiver)other;
          return this.name.equals(that.name) && 
                this.phoneNumber.equals(this.phoneNumber);
      }
  }
  ``` 


### 엔티티 식별자 밸류 타입
- 엔티티 식별자의 실제 데이터는 String과 같은 문자열로 구성된 경우가 많다. (신용카드 번호 16자리 문자열, 이메일 주소 문자열 등)
- Money가 단순 숫자가 아닌 도메인의 '돈'을 의미하는 것처럼 이런 식별자는 단순한 문자열이 아니라 도메인에서 특별한 의미를 지니는 경우가 많기 떄문에 식별자를 위한 밸류 타입을 사용해서 의미가 잘 드러나도록 할 수 있다.
  - 예) 주문번호를 표현하기 위해 Order의 식별자 타입을 String대신 OrderNo 밸류타입을 사용
    ```java
    public class Order {
        // OrderNo 타입 자체로 id가 주문번호임을 알 수 있다.
        private OrderNo id;

        //...

        public OrderNo getId() {
            return id;
        }
    }
    ``` 
  - OrderNo 대신에 String 타입을 사용한다면 'id' 라는 이름만으로 해당 필드가 주문번호 인지 여부를 알 수 없다.
  - 필드의 의미가 드러나도록 하려면 'id' 라는 필드 이름 대신 'orderNo' 라는 필드 이름을 사용해야 한다.
  - 반면에, 식별자를 위해 OrderNo 타입을 만들면 타입 자체로 주문번호라는 것을 알 수 있으므로 필드 이름이 'id' 여도 실제 의미를 찾는 것은 어렵지 않다.

### 도메인 모델에 set 메서드 넣지 않기
- 도메인 모델에 get/set 메서드를 무조건 추가하는 것은 좋지 않은 버릇이다. 
- 특히 set메서드는 모데인의 핵심 개념이나 의도를 코드에서 사라지게 한다.
  - 예) Order의 메서드를 set메서드로 변경
    ```java
    public class Order {
        //...
        public void setShippingInfo(ShippingInfo newShipping) {..}
        public void setOrderState(OrderState state) {..}
    }
    ```  
    - 앞서 changeShippingInfo()가 배송지 정보를 새로 변경한다는 의미를 가졌다면 setShippingInfo()메서드는 단순히 배송지 값을 설정한다는 것을 뜻한다.
    - completePayment()는 결제를 완료했다는 의미를 갖는 반면에 setOrderState()는 단순히 주문상태 값을 설정한다는 것을 뜻한다.
    - 구현할 때에도 completePayment()는 결제 완료와 관련된 처리 코드를 함꼐 구현하기 떄문에 결제 완료와 관련된 도메인 지식을 코드로 구현하는 것이 자연스럽다.
    - setOrderState()는 단순히 상태 값만 변경할지 아니면 상태 값에 따른 다른 처리를 위한 코드를 함께 구현할지 애매하다.
    - 습관 적으로 코드를 작성하는 경우라면 필드 값만 변경하고 끝나는 경우가 많기 떄문에 상태 변경과 관련된 도메인 지식이 코드에서 사라지게 된다.
- set 메서드의 또 다른 문제는 도메인 객체를 생성할 때 완전한 상태가 아닐 수도 있다는 것이다.
  - 예) set메서드의 문제점
    ```java
    // set 메서드로 데이터를 전달하도록 구현하면
    // 처음 Order를 생성하는 시점에 order는 완전하지 않다.
    Order order = new Order();

    // set 메서드로 필요한 모든 값을 전달해야 함
    order.setOrdrLine(lines);
    order.setShippingInfo(shippingInfo);

    // 주문자(Orderer)를 설정하지 않은 상태에서 주문 완료 처리
    order.setState(OrderState.PREPARING);
    ``` 
    - 위 코드는 주문자를 설정하는 것을 누락하고 있다.
    - 주문자 정보를 담고 있는 필드인 orderer가 null인 상황에서 order.setState() 메서드로 상품 준비 중 상태로 바꾸는 것이다.
    - orderer가 정상인지 확인하기 위해 orderer가 null인지 검사하는 코드를 setState() 메서드에 위치하는 것도 맞지 않다.
- 도메인 객체가 불완전한 상태로 사용되는 것을 막으려면 생성 시점에 필요한 것을 전달해 주어야 한다. 즉, 생성자를 통해 필요한 데이터를 모두 받아야 한다.
  ```java
  Order order = new Order(orderer, lines, shippingInfo, OrderState.PREPARING);
  ``` 
  - 생성자로 필요한 것을 모두 받으므로 생성자를 호출하는 시점에 필요한 데이터가 올바른지 검사할 수 있다.
  ```java
  public class Order {
      public Order(Orderer orderer, List<OrderLine> orderLines, 
            ShippingInfo shippingInfo, OrderState state) {
                setOrderer(orderer);
                setOrderLines(orderLines);
                // ... 다른 값 설정
            }
      private void setOrderer(Orderer orderer) {
          if (orderer == null) throw new illegalArgumentException("no orderer");
          this.orderer = orderer;
      }  

      private void setOrderLines(List<OrderLine> orderLines) {
          verifyAtLeastOneOrMoreOrderLines(orderlines);
          this.orderLines = orderLines;
          calculateTotalAmounts();
      }
      
      private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
          if (orderLines ==null || orderLines.isEmpty()){
              throw new illegalArgumentException("no OrderLine");
          }
      }

      private void calculateTotalAmounts() {
          this.totalAmounts = orderLines.stream().mapToInt(x -> x.getAmounts()).sum();
      }
  }

  ``` 
    - 이 코드의 set메서드는 앞서 set 메서드와 중요한 차이점이 있는데 접근 범위가 private라는점이다.
    - 이 코드에서 set메서드는 클래스 내부에서 데이터를 변경할 목적으로 사용된다.
    - private이기 떄문에 외부에서 데이터를 변경할 목적으로 set 메서드를 사용할 수 없다.
    - 불변 밸류 타입을 사용하면 자연스럽게 밸류 타입에는 set 메서드를 구현하지 않는다.
    - set 메서드를 구현해야 할 특별한 이유가 없다면 불변 타입의 장점을 살릴 수 있도록 밸류 타입은 불변으로 구현한다.

</details>

<details> <summary> 6. 도메인 용어  </summary>

## 6. 도메인 용어
- 코드를 작성할 때 도메인에서 사용하는 용어는 매우 중요하다.
- 도메인에서 사용하는 용어를 코드에 반영하지 않으면 그 코드는 개발자에게 코드의 의미를 해석해야 하는 부담을 준다.
  - 예) OrderState
    ```java
    public enum OrderState {
        STEP1, STEP2, STEP3, STEP4, STEP5, STEP6
    }
    ```  
    - 실제주문상태는 '결제대기중', '상품준비중', '출고완료됨', '배송중', '배송완료됨', '주문 취소됨' 이다.
    - 이 코드는 개발자가 전체 상태를 6단계로 보고 코드로 표현 한 것 이다.
    - 이 개발자는 Order 코드를 다음과 같이 작성할 가능성이 높다.
    ```java
    public class Order {
        public void changeShippingInfo(ShippingInfo newShippingInfo) {
            veryifyStep10rStep2();
            setShippingInfo(newShippingInfo);
        }
        private void verifyStep10rStep2() {
            if (state != OrderState.STEP1 && state != OrderState.STEP2) 
                throw new illegalStateException("already shipped");
        }
    }
    ``` 
    - 배송지 변경은 '출고 전'에 가능한데 이 코드의 verifyStep10rStep2라는 이름은 도메인의 중요 규칙이 드러나지 않는다.
    - 그저 STEP1과 STEP2인지 검사할 뿐이다. 
    - 실제 이 코드의 의미를 이해하려면 STEP1과 STEP2가 각각 '결제 대기 중' 상태와 '상품 준비중' 상태를 의미한 다는 것을 알아야 한다.
    - 기획자나 온라인 쇼핑 도메인 전문가가 개발자와의 업무 회의에서 '출고 전' 이라는 단어를 상요하면 개발자는 머릿속으로 '출고 전은 STEP1과 STEP2' 라고 도메인 지식을 코드로 해석해야 한다.
    ```java
    public enum OrderState {
        PAYMENT_WAITING, PREPARING, SHIPPED, DELIVERING, DELIVERY_COMPLETED;
    }
    ``` 
    - '출고 전은 STEP1과 STEP2' 같은 불필요한 변환 과정을 하지 않아도 된다.
    - 코드를 도메인 용어로 해석하거나 도메인 용어를 코드로 해석하는 과정이 줄어든다.
    - 코드의 가독성을 높여서 코드를 분석하고 이해하는 시간을 절약한다.
    - 도메인 용어를 사용해서 최대한 도메인 규칙을 코드로 작성하게 되므로 (의미를 변환하는과정에서 발생하는) 버그도 줄어들게 된다.
    - 도메인 용어는 좋은 코드를 만드는데 매우 중요한 요소임에 틀림없지만 국내 개발자는 이 점에 있어 불리한 면이 있다. ( 영어 떄문에 ) -> 도메인 용어를 영어로 해석하는 노력이 필요하다
      - 도메인에서 사용하는 용어의 의미를 명확하게 전달하는 영어 단어를 찾기 힘든 경우도 있고, 반대로 비슷한 의미의 영어 단어가 많으면 각 단어의 뉘앙스나 미세한 차이를 몰라서 선택하기 어려울 떄도 있다.
      - 도메인 용어의 '상태'를 코드로 표현할 때 'state'와 'status'중 어떤 단어를 사용할지 고민해야 한다.
      - '종류'를 표현하기 위해 'kind'와 'type' 중 어떤 단어가 맞는지 고심할 때도 있다.
      - 국내 개발자가 이해하기 쉽게 발음되는대로 'gubun(구분)' 과 같은 이름을 사용하기도 한다.
      - 알맞은 영어 단어를 찾는 것은 쉽지 않은 일이지만 시간을 들여 찾는 노력을 해야 한다.
      - 한영사전을 사용해서 적당한 단어를 찾는 노력을 하지 않고 도메인에 어울리지 않는 단어를 사용하면 코드는 도메인과 점점 멀어지게 된다.
    - 도메인 용어에 알맞은 단어를 찾는 시간을 아까워 하면 안된다. 

</details>

# [2.아키텍처 개요](./2.아키텍처-개요)

<details> <summary> 1. 네 개의 영역 </summary>

## 1. 네 개의 영역
- 아키텍처를 설계할 때 출현하는 전형적인 영역
  - '표현'
  - '응용'
  - '도메인'
  - '인프라스트럭처'

### 표현 영역
- 표현 영역 또는 UI 영역
- 사용자의 요청을 받아 응용 영역에 전달하고 응용 영역의 처리 결과를 다시 사용자에게 보여주는 역할
- 웹 애플리케이션을 개발할 때 많이 사용하는 스프링 MVC 프레임워크가 표현영역을 위한 기술에 해당 
- 웹 애플리케이션에서 표현 영역의 사용자는 웹 브라우저를 사용하는 사람이나, REST API를 호출하는 외부 시스템일 수 있다. 
![image](https://user-images.githubusercontent.com/28394879/134446261-7e0e79d6-73bb-4e9b-a72f-9dd7875e668b.png)
- 웹 애플리케이션에서 표현 영역은 HTTP 요청을 응용 영역이 필요로 하는 형식으로 변환해서 응용 영역에 전달하고, 응용 영역의 응답을 HTTP 응답으로 변환해서 전송한다.
- 예) 표현영역은 웹 브라우저가 HTTP 요청 파라미터로 전송한 데이터를 응용 서비스가 요구하는 형식의 객체 타입으로 변환해서 전달하고, 응용 서비스가 리턴한 결과를 JSON 형식으로 변환해서 HTTP 응답으로 웹 브라우저에 전송한다. 

### 응용 영역
- 표현 영역을 통해 사용자의 요청을 전달 받음
- 시스템이 사용자에게 제공해야 할 기능을 구현 
  - 예) '주문등록', '주문취소', '상품상세조회'
- 기능을 구현하기 위해 도메인 영역의 도메인 모델을 사용
  - 예) 주문 취소 기능을 제공하는 응용 서비스 
    ```java
    public class CancelOrderService {

        @Transactional
        public void cancelOrder(String orderId) {
            Order order = findOrderById(orderId);
            if (order == null) throw new OrderNotFoundException(orderId);
            order.cancel();
        }
        // ...
    }
    ```
  - 응용 서비스는 로직을 직접 수행하기보다는 도메인 모델에 로직 수행을 위임 
  - 위 코드도 주문 취소 로직을 직접 구현하지 않고 Order객체에 취소 처리를 위임 하고 있다. 
![image](https://user-images.githubusercontent.com/28394879/134448391-6ece8aaf-41fb-49f6-845e-87db339824f1.png)

### 도메인 영역
- 도메인 모델을 구현 
- Order, OrderLine, ShippingInfo와 같은 도메인 모델이 이영역에 위치한다. 
- 도메인의 핵심 로직을 구현
  - 예) 주문 도메인의 경우 
  - '배송지 변경'
  - '결제 완료'
  - '주문 총액 계산'

### 인프라스트럭처 영역
- 구현 기술에 대한 것을 다룸
- RDBMS 연동 처리
- 메시징 큐에 메시지를 전송하거나 수신하는 기능을 구현
- 몽고DB나 HBase를 사용해서 데이터베이스 연동을 처리 
- 예) SMTP를 이용한 메일 발송 기능을 구현, HTTP 클라이언트를 이용해서 REST API를 호출
- 논리적인 개념을 표현하기보다는 실제 구현을 다룸
![image](https://user-images.githubusercontent.com/28394879/134452096-ccefbb07-9775-4ba1-9004-06aceedf6af7.png)
- 도메인, 응용, 표현 영역은 구현 기술을 사용한 코드를 직접 만들지 않는 대신 인프라스트럭처 영역에서 제공하는 기능을 사용해서 필요한 기능을 개발한다.
- 예) 응용 영역에서 DB에 보관된 데이터가 필요하면 인프라스트럭처 영역의 DB 모듈을 사용해서 데이터를 읽어 온다.
- 예) 외부에 메일을 발생해야 하면 인프라스트럭처가 제공하는 SMTP 연동 모듈을 이용해서 메일을 발송한다. 

</details>

<details> <summary> 2. 계층 구조 아키텍처 </summary>

## 2. 계층 구조 아키텍처 
![image](https://user-images.githubusercontent.com/28394879/134459209-89490833-6dc8-40ae-9acf-4868470d13e9.png)
- 네 영역을 구성할 때 많이 사용하는 계층 구조이다. 
- 도메인의 복잡도에 따라 응용과 도메인을 분리하기도 하고 한 계층으로 합치기도 하지만 전체적인 아키텍처는 위 그림의 계층 구조를 따른다. 
- 상위 계층에서 하위 계층으로의 의존만 존재하고 하위 계층은 상위 계층에 의존하지 않는다. 
- 예) 표현계층은 응용 계층에 의존하고 응용 계층이 도메인 계층에 의존하지만, 반대로 인프라스트럭처 계층이 도메인에 의존하거나 도메인이 응용 계층에 의존하지 않는다.

**전형적인 계층 구조상의 의존 관계**

![image](https://user-images.githubusercontent.com/28394879/134459868-1ee24106-8de9-4aad-b5a9-6ec7857a65a0.png)
- 구현의 편리함을 위해 계층구조를 유용하게 적용 
- 응용 계층은 바로 아래 계층인 도메인 계층에 의존하지만 외부 시스템과의 연봉을 위해 아래 계층인 인프라스트럭처 계층의 의존하기도 한다. 
- 도메인과 응용계층은 룰 엔진과 DB 연동을 위해 같이 인프라스트럭처 모듈에 의존하게 된다. 
- 응용 영역과 도메인 영역은 DB나 외부 시스템 연동을 위해 인프라스트럭처의 기능을 사용하므로 이런 계층 구조를 사용하는 것은 직관적으로 이해하기 쉽다.
- 하지만, 표현, 응용, 도메인 계층이 상세한 구현 기술을 다루는 인프라스트럭처 계층에 종속된다. 
- 예) 도메인의 가격 계산 규칙 
  - 할인 금액 계산 로직이 복잡해지면 객체 지향으로 로직을 구현하는 것보다 룰 엔진을 사용하는 것이 더 알맞을 때가 있다. 
  - Drools라는 룰 엔진을 사용해서 로직을 수행할 수 있는 인프라스트럭처 영역의 코드 
  - evalutate() 메서드에 값을 주면 별도 파일로 작성한 규칙을 이용해서 연산을 수행하는 코드 정도로만 생각하고 넘어가자.
  ```java
    public class DroolsRuleEngine {
        private KieContainer kContainer;

        public DroolsRuleEngine() {
            KieServices ks = KieServices.Factory.get();
            kContainer = ks.getKieClasspathContainer();
        }

        public void evaluate(String sessionName, List<?> facts) {
            KieSession kSession = kContainer.newKieSession(sessionName);
            try {
                facts.forEach(x -> kSession.insert(x));
                kSession.fireAllRules();
            } finally {
                kSession.dispose();
            }
        }
    }
  ``` 
  - 응용 영역은 가격 계산을 위해 인프라스트럭처 영역의 DroolsRuleEngine을 사용 한다. 
  ```java
  public class CalculateDiscountService {
      private DroolsRuleEngine ruleEngine;

      public CalculateDiscountService() {
          ruleEngine = new DroolsRuleEngine();
      }

      public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
          Customer customer = findCustomer(customerId);

          MutableMoney money = new MutableMoney(0);
          List<?> facts = Arrays.asList(customer, money);
          facts.addAll(orderLines);
          ruleEngine.evalute("discountCalculation", facts);
          return money.toImmutableMoney();
      }
      //...
  }
  ``` 
  - CalculateDiscountService가 동작은 하겠지만 이 코드는 두가지 문제를 안고 있다.
    1.  테스트 어려움 
        -  CalculateDiscountService만 테스트하기 어렵다. 
        -  CalculateDiscountService를 테스트하려면 RuleEngine이 완벽하게 동작해야 한다.
        -  RuleEngine 클래스와 관련 설정 파일을 모두 만든 이후에 비로소 CalculateDiscountService가 올바르게 동작하는지 확인할 수 있다.
    2.  기능 확장의 어려움
        ```java
        public class CalculateDiscountService {
            private DroolsRuleEngine ruleEngine;

            public CalculateDiscountService() {
                ruleEngine = new DroolsRuleEngine();
            }

            public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
                Customer customer = findCustomer(customerId);

                MutableMoney money = new MutableMoney(0); // Drools에 특화된 코드: 연관결과를 받기 위해 추가한 타입
                List<?> facts = Arrays.asList(customer, money); // Drools에 특화된 코드: 룰에 필요한 데이터(지식)
                facts.addAll(orderLines); // Drools에 특화된 코드: 룰에 필요한 데이터(지식)
                ruleEngine.evalute("discountCalculation", facts); // discountCalculation => Drools에 특화된 코드: Drools의 세션 이름 
                return money.toImmutableMoney();
            }
        }
        ```
        -  코드만 보면 Drools가 제공하는 타입을 직접 사용하지 않으므로 CalculateDiscountService가 Drools 자체에 의존하지 않는다고 생각할 수 있다. 
        -  하지만, `discountCalculation` 문자열은 Drools의 세션 이름을 의미한다. 따라서, Drools의 세션 이름을 변경하면 CalculateDiscountService의 코드도 함께 변경해야 한다. 
        -  MutableMoney는 룰 적용 결과값을 보관하기 위해 추가한 타입인데 다른 방식을 사용했다면 필요 없는 타입이다.
 - 이처럼 CalculateDiscountService가 겉으로는 인프라스트럭처의 기술에 직접적인 의존을 하지 않는 것처럼 보여도 실제론느 Drools라는 인프라스트럭처 영역의 기술에 완전하게 의존하고 있다.
 - 이런 상황에서 Drools가 아닌 다른 구현 기술을 사용하려면 코드의 많은 부분을 고쳐야 한다.
 - '테스트 어려움', '기능 확장의 어려움' 을 해소하려면 어떻게 해야 할까? 답은 DIP를 적용하면 된다.  

</details>

<details> <summary> 3. DIP </summary>

## 3. DIP
![image](https://user-images.githubusercontent.com/28394879/134463969-c5c2ac6b-0e5f-4351-846c-7aa64c390442.png)
- 가격 할인 계싼을 하려면 왼쪽과 같이 고객 정보를 구해야 하고, 구한 고객 정보와 주문 정보를 이용해서 룰을 실행해야 한다. 
- 여기서 CalculateDiscountService는 고수준 모듈이다.

### 고수준 모듈 
- 고수준 모듈: 의미 있는 단일 기능을 제공하는 모듈
  - 예) CalculateDiscountService는 '가격 할인 계산' 이라는 기능을 구현
- 고수준 모듈의 기능을 구현하려면 여러 하위 기능이 필요하다.
  - 예) 가격 할인 계산 기능을 구현하려면 고객 정보를 구해야하고 룰을 실행해야하는데 이 두 기능이 하위 기능이다.

### 저수준 모듈 
- 저수준 모듈: 하위 기능을 실제로 구현한 것
  - 예) JPA를 이용해서 고객 정보를 읽어오는 모듈과 Drools로 룰을 실행하는 모듈이 저수준 모듈
- 고수준 모듈이 제대로 동작하려면 저수준 모듈을 사용해야 한다.
- 고수준 모듈이 저수준 모듈을 사용하면 앞서 계층 구조 아키텍처에서 언급했던 두가지 문제(구현 변경과 테스트가 어려움)가 발생한다.

### DIP
- 저수준 모듈이 고수준 모듈에 의존하도록 바꿈으로써 두가지 문제(구현 변경과 테스트가 어려움)을 해결함 
- 고수준 모듈을 구현하려면 저수준 모듈을 사용해야 하는데, 반대로 저수준 모듈이 고수준 모듈에 의존하도록 하려면 어떻게 해야 할까? ==> 추상화한 인터페이스 
- CalculateDiscountService 입장에서 봤을 때 룰 적용을 Drools로 구현했는지, 자바로 직접 구현했는지는 중요하지 않다. 
- 단지, '고객 정보와 구매 정보에 룰을 적용해서 할인 금액을 구한다'는 것이 중요할 뿐이다. 이를 추상화한 인터페이스는 다음과 같다.
```java
public interface RuleDiscounter {
    public Money applyRules(Customer customer, List<OrderLine> orderLines);
}
``` 

- CalculateDiscountService가 RuleDiscounter를 이용한 코드 
```java
public class CalculateDiscountService {
    private RuleDiscounter ruleDiscounter;

    public CalculateDiscountService(RuleDiscounter ruleDiscounter) {
        this.ruleDiscounter = ruleDiscounter;
    }

    public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
        Customer customer = findCustomer(customerId);
        return ruleDiscounter.applyRules(customer, orderLines);
    }
    //...
}
``` 
- CalculateDiscountService는 Drools에 의존하는 코드를 포함하고 있지 않다. 
- 단지, RuleDiscounter가 룰을 적용한다는 것만 안다.
- 실제 RuleDiscounter의 구현 객체는 생성자를 통해서 전달 받는다. 
- 룰 적용을 구현한 클래스는 RuleDiscounter 인터페이스를 상속받아 구현한다. Drools 관ㄹ녀 코드를 이해할 필요는 없고, 상속받아 구현한다는 것만 이해하면 된다.
```java
public class DroolsRuleDiscounter implements RuleDiscounter {
    private KieContainer kContainer;

    public DroolsRuleDiscounter() {
        KieServices ks = KieServices.Factory.get();
        kContainer = ks.getKieClasspathContainer();
    }

    @Override
    public Money applyRule(Customer customer, List<OrderLine> orderLines) {
        KieSession kSession = kContainer.newKieSession("discountSession");
        try {
            //...
            kSession.fireAllRules();
        } finally {
            kSession.displose();
        }
        return money.toImmutableMoney(); 
    }
}
``` 

![image](https://user-images.githubusercontent.com/28394879/134466307-b732fbe8-7e6c-4932-9f4b-8e97cd55889d.png)
- DIP를 적용한 구조
- CalculateDiscountService는 더이상 구현 기술인 Drools에 의존하지 않는다.
- '룰을 이용한 할인 금액 계산'을 추상화한 RuleDiscounter 인터페이스에 의존할 뿐이다. 
- '룰을 이용한 할인 금액 계산'은 고수준 모듈의 개념이므로 RuleDiscounter 인터페이스는 고수준 모듈에 속한다. 
- DroolsRuleDiscounter는 고수준의 하위 기능인 RuleDiscounter를 구현한 것이므로 저수준 모듈에 속한다.    

![image](https://user-images.githubusercontent.com/28394879/134466814-9e554aae-4477-4102-9814-4f4846614335.png)
- 저수준 모듈이 고수준 모듈에 의존(상속은 의존의 다른 형태)
- 고수준 모듈이 저수준 모듈을 사용하려면 고수준 모듈이 저수준 모듈에 의존해야 하는데, 반대로 저수준 모듈이 고수준 모듈에 의존한다고 해서 이를 DIP(dependency Inversion Principle, 의존 역전 원칙) 이라 부른다. 

### 구현 기술 교체 예시 (구현 변경 어려움 해결)
**기존 기술 예시**

```java
// 사용할 저수준 객체 생성
RuleDiscounter ruleDiscounter = new DroolsRuleDiscounter();

// 생성자 방식으로 주입
CalculateDiscountService disService = new CalculateDiscountService(ruleDiscounter);
```
**구현 기술 변경**
```java
// 사용할 저수준 구현 객체 변경 
RuleDiscounter ruleDiscounter = new SimpleRuleDiscounter();

// 사용할 저수준 모듈을 변경해도 고수준 모듈을 수정할 필요가 없다. 
CalculateDiscountService disService = new CalculateDiscountService(ruleDiscounter);
```
- 의존 주입을 지원하는 스프링과 같은 프레임워크를 사용하면 설정 코드를 수정해서 쉽게 구현체를 변경할 수 있다. 


### 테스트 해결 예시 (테스트 어려움 해결)
- 테스트를 언급하기 전에 CalculateDiscounterService가 제대로 동작하려면 Customer를 찾는 기능도 구현해야 한다. 
- 이를 위한 고수준 인터페이스를 CustomerRepository라고 하자.
- CalculateDiscountService는 다음과 같이 두 인터페이스인 CustomerRepository와 RuleDiscounter를 사용해서 기능을 구현하게 된다. 
```java
public class CalculateDiscountService {
    private CustomerRepository customerRepository;
    private RuleDiscounter ruleDiscounter;

    public CalculateDiscountService (
        CustomerRepository customerRepository, RuleDiscounter ruleDiscounter) {
            this.customerRepository = customerRepository;
            this.ruleDiscounter = ruleDiscounter;
        }
    public Money calculateDiscount(OrderLine orderLines, String customerId) {
        Customer customer = findCustomer(customerId);
        return ruleDiscounter.applyRules(customer, orderLines);
    }

    private Customer findCustomer(String customerId) {
        Customer customer = customerRepository.findById(customerId);
        if (customer == null) throw new NoCustomerException();
        return customer;
    }
    //...
}
```

- CalculateDiscountService가 제대로 동작하는지 테스트하려면 CustomerRepository와 RuleDiscounter를 구현한 객체가 필요하다.
- 만약 CalculateDiscountService가 저수준 모듈에 직접 의존했다면 저수준 모듈이 만들어지기 전까지 테스트를 할 수가 없었다. 
- 하지만, CustomerRepository와 RuleDiscounter는 인터페이스이므로 대용 객체를 사용해서 테스트를 진행할 수 있다. 
- 다음은 대용 객체를 사용해서 Customer가 존재하지 않는 경우 익셉션이 발생하는지 검증하는 테스트 코드의 예시 코드이다.
```java
public class CalculateDiscountServiceTest {
    
    @Test(expected = NoCustomerException.class);
    public void noCustomer_thenExceptionShouldBeThrown() {
        // 테스트 목적의 대용 객체
        CustomerRepository stubRepo = mock(CustomerRepository.class);
        when(stubRepo.findById("noCustId")).thenReturn(null);

        RuleDiscounter stubRule = (cust, lines) -> null;

        // 대용 객체를 주입받아 테스트 진행
        CalculateDiscountService calDisSvc = new CalculateDiscountService(stubRepo, stubRule);
        calDisSvc.calculateDiscount(someLines, "noCustId");
    }
}
``` 
- stubRepo와 stubRule은 각각 CustomerRepository와 RuleDiscounter의 대용 객체이다.
- stubRepo는 Mockito라는 Mock 프레임워크를 이용해서 대용 객체를 생성했고, stubRule은 메서드가 한 개여서 람다식을 이용해서 객체를 생성했다.
- 두 대용 객체는 테스트를 수행하는 데 필요한 기능만 수행한다.
- stubRepo의 경우 findById("noCustId")를 실행하면 null을 리턴하는데, calDisSvc를 생성할 때 생성자로 stubRepo를 주입받는다.
- 따라서, calDisSvc.calculateDiscount(someLines, "noCustId") 코드를 실행하면 CalculateDiscountService의 findById() 메서드에서 실행하는 customerRepository.findById(customerId) 코드는 null을 리턴하고 결과적으로 NoCustomerException을 발생시킨다. 
- CustomerRepository와 RuleDiscounter의 실제 구현 클래스가 없어도 CalculateDiscountService를 테스트할 수 있음을 보여준다. 
- 실제 구현 대신 스텁이나 Mock과 같은 테스트 목적의 대용 객체를 사용해서 거의 모든 상황을 테스트할 수 있다. 
- 이렇게 실제 구현 없이 테스트를 할 수 있는 이유는 DIP를 적용해서 고수준 모듈이 저수준 모듈에 의존하지 않도록 했기 때문이다.
- 고수준 모듈인 CalculateDiscountService는 저수준 모듈에 직접 의존하지 않기 떄문에 RDBMS를 이용한 CustomerRepository 구현 클래스와 Drools를 이용한 RuleDiscounter 구현 클래스가 없어도 테스트 대용 객체를 이용해서 거의 모든 기능을 테스트할 수 있는 것이다.

### DIP 주의사항
- DIP를 잘못 생각하면 단순히 인터페이스와 구현 클래스를 분리하는 정도로 받아들일 수 있다.
- DIP의 핵심은 고수준 모듈이 저수준 모듈에 의존하지 않도록 하기 위함이다.

**잘못된 DIP 적용 예시**

![image](https://user-images.githubusercontent.com/28394879/134473367-9ae5ee28-ecfc-4c15-b8ef-6a38b78ad7aa.png)
- DIP를 적용한 결과 구조만 보고 저수준 모듈에서 인터페이스를 추출하는 경우이다.
- 이 구조에서 도메인 영역은 구현 기술을 다루는 인프라스트럭처 영역에 의존하고 있다. 
- 즉, 여전히 고수준 모듈이 저수준 모듈에 의존하고 있는 것이다.
- RuleEngine 인터페이스는 고수준 모듈인 도메인 관점이 아니라 룰 엔진이라는 저수준 모듈 관점에서 도출한 것이다.
- DIP를 적용할 때 하위 기능을 추상화한 인터페이스는 고수준 모듈 관점에서 도출한다.
- CalculateDiscountService 입장에서 봤을 때 할인 금액을 구하기 위해 룰 엔진을 사용하는지, 직접 연산하는지 여부는 중요하지 않다.
- 단지 규칙에 따라 할인 금액을 계산한다는 것이 중요할 뿐이다. 
- 즉, '할인 금액 계산'을 추상화한 인터페이스는 저수준 모듈이 아닌 고수준 모듈에 위치한다. 

**하위 기능을 추상화한 인터페이스가 고수준 모듈에 위치한 제대로된 DIP 적용 예시**

![image](https://user-images.githubusercontent.com/28394879/134473847-7b92d97c-89fb-46f2-b548-f842b5ef423d.png)


### DIP와 아키텍처 
**아키텍처 수준에서 DIP를 적용하면 인프라스트럭처 영역이 응용 영역과 도메인 영역에 의존하는 구조가 된다**

![image](https://user-images.githubusercontent.com/28394879/134475146-8d08e3f7-db8d-4b3c-9caf-16bffc334ad4.png)
- 인프라스트럭처 영역은 구현 기술을 다루는 저수준 모듈이고, 응용 영역과 도메인 영역은 고수준 모듈이다. 
- 인프라스트럭처 계층의 가장 하단에 위치하는 계층형 구조와 달리 아키텍처에 DIP를 적용하면 인프라스트럭처 영역이 응용 영역과 도메인 영역에 의존(상속)하는 구조가 된다. 
- 인프라스트럭처에 위치한 클래스가 도메인이나 응용 영역에 정의한 인터페이스를 상속받아 구현하는 구조가 되므로 도메인과 응용 영역에 대한 영향을 주지 않거나 최소화 하면서 구현 기술을 변경하는 것이 가능하다.

**구현 기술을 변경하는것이 쉬운 DIP 대한 예시** 

![image](https://user-images.githubusercontent.com/28394879/134475925-7cf8e0f6-8b2a-4495-9291-c74e2e9b1341.png)
- 인프라스트럭처 영역의 EmailNotifier 클래스는 응용 영역의 Notifier인터페이스를 상속받고 있다. 
- 주문 시 통지 방식에 SMS를 추가해야 한다는 요구사항이 들어왔을 경우 응용 영역의 OrderService는 변경할 필요가 없다.
  - 두 통지 방식을 함께 제공하는 Notifier 구현 클래스를 인프라스트럭처 영역에 추가하면 된다.
  - 비슷하게 Mybatis 대신 JPA를 구현 기술로 사용하고 싶다면 JPA를 이용한 OrderRepository 구현 클래스를 인프라스트럭처 영역에 추가하면 된다. 

**바로 위의 DIP그림에서 구현체를 변경했을 경우**

![image](https://user-images.githubusercontent.com/28394879/134476389-56d2873a-ead2-4ccd-be83-30d36b3286e9.png)
- DIP를 적용하면 응용 영역과 도메인 영역에 영향을 최소화하면서 구현체를 변경하거나 추가할 수 있다. 

</details>

<details> <summary> 4. 도메인 영역의 주요 구성요소 </summary>

## 4. 도메인 영역의 주요 구성요소 
- 도메인 영역의 모델은 도메인의 주요 개념을 표현하며 핵심이 되는 로직을 구현한다.

**표) 도메인 영역의 주요 구성요소**
|요소|설명|
|---|-------|
|엔티티 ENTITY|고유의 식별자를 갖는 객체로 자신의 라이프사이클을 갖는다. 주문(Order), 회원(Member), 상품(Product)과 같이 도메인의 고유한 개념을 표현한다. 도메인 모델의 데이털르 포함하며 해당 데이터와 관련된 기능을 함께 제공한다.|
|밸류 VALUE|고유의 식별자를 갖지 않는 객체로 주로 개념적으로 하나인 도메인 객체의 속성을 표현할 때 사용된다. 배송지 주소를 표현하기 위한 주소(Address)나 구매 금액을 위한 금액(Money)과 같은 타입이 밸류 타입이다. 엔티티의 속성으로 사용될 뿐만 아니라 다른 밸류 타입의 속성으로도 사용될 수 있다.|
|애그리거트 AGGREGATE|애그리거트는 관련된 엔티티와 뺄류 객체를 개념적으로 하나로 묶은 것이다. 예를 들어, 주문과 관련된 Order엔티티, OrderLine 밸류, Orderer 밸류 객체를 '주문'애그리거트로 묶을 수 있다.|
|리포지터리 REPOSITORY|도메인 모델의 영속성을 처리한다. 예를들어, DBMS 테이블에서 엔티티 객체를 로딩하거나 저장하는 기능을 제공한다.|
|도메인 서비스 DOMAIN SERVICE|특정 엔티티에 속하지 않은 도메인 로직을 제공 한다. '할인 금액 계산'은 상품, 쿠폰, 회원 등급, 구매 금액 등 다양한 조건을 이용해서 구현하게 되는데, 이렇게 도메인 로직이 여러 엔티티와 밸류를 필요로 할 경우 도메인 서비스에서 로직을 구현한다.|

### 엔티티와 밸류
- 도메인 모델의 엔티티와 DB 관계형 모델의 엔티티는 다르다. (같지 않다)
- DB관계형 모델의 엔티티는 데이터만 제공하지만, 도메인 모델의 엔티티는 데이터와 함께 도메인 기능을 함께 제공한다. 
  - 예) 주문을 표현하는 엔티티는 주문과 관련된 데이터뿐만 아니라 배송지 주소 변경을 위한 기능을 함께 제공한다. 

```java
public class Order {
    // 주문 도메인 모델의 데이터
    private OrderNo number;
    private Orderer orderer;
    private ShippingInfo shippingInfo;
    //...

    // 도메인 모델 엔티티는 도메인 기능도 함께 제공
    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        //...
    }
}
```
- 도메인 모델의 엔티티는 단순히 데이터를 담고 있는 데이터 구조라기보다는 데이터와 함께 기능을 제공하는 객체이다. 
- 도메인 모델의 엔티티는 두 개 이상의 데이터가 개념적으로 하나인 경우 밸류 타입을 이용해서 표현할 수 있다. (RDBMS는 밸류 타입을 제대로 표현하기 힘들다)
  - 위 코드에서 주문자를 표현하는 Orderer는 밸류 타입으로 다음과 같이 주문자 이름과 이메일 데이터를 포함할 수 있다.
  ```java
  public class Orderer {
      private String name;
      private String email;
  }
  ```  

**RDBMS는 밸류를 제대로 표현하기 힘들다**
![image](https://user-images.githubusercontent.com/28394879/134623817-c899365e-0834-4756-8f83-444af1aa1d16.png)

- 왼쪽 테이블의 경우 주문자(Orderer)라는 개념이 드러나지 않고 주문자의 개별 데이터만 드러난다.
- 오른쪽 테이블의 경우 주문자 데이터를 별도 테이블에 저장했지만 이는 테이블의 엔티티에 가깝지 밸류 타입의 의미가 드러나지는 않는다.
- 반면 도메인 모델의 Orderer는 주문자라는 개념을 잘 반영하므로 도메인을 보다 잘 이해할 수 있도록 돕는다. 

**밸류 타입 데이터를 변경할 때 객체 자체를 완전히 교체한다**
```java
public class Order {
    private ShippingInfo shippingInfo;
    //...
    // 도메인 모델 엔티티는 도메인 기능도 함께 제공
    public void changeShippingInfo(ShippingInfo shippingInfo) {
        checkShippingInfoChangeable();
        setShippingInfo(newShippingInfo);
    }

    private void setShippingInfo(ShippingInfo newShippingInfo) {
        if(newShippingInfo == null) throw new IllegalArgumentException() ;
        // 밸류타입의 데이털르 변경할 때는 새로운 객체로 교체한다.
        this.ShippingInfo = newShippingInfo;
    }
}
```
- 밸류는 불변으로 구현하는것이 권장사항이다.
- 엔티티의 밸류 타입 데이터를 변경할 때 객체 자체를 완전히 교체 한다. 
- 배송지 정보를 변경하는 코드는 기존 객체의 값을 변경하지 않고 위 코드 같이 새로운 객체를 필드에 할당한다.


### 애그리거트

**애그리거트의 필요성**
- 도메인이 커질수록 개발할 도메인 모델도 커지면서 많은 엔티티와 밸류가 출현한다.
- 엔티티와 밸류 개수가 많아지면 많아 질수록 모델은 점점 더 복잡해진다.
- 도메인 모델이 복잡해지면 개발자가 전체 구조가 아닌 한 개 엔티티와 밸류에만 집중하게 되는 경우가 발생한다.
- 이때 상위 수준에서 모델을 관리하기보다 개발 요소에만 초점을 맞추다 보면 큰 수준에서 모델을 이해하지 못해 큰 틀에서 모델을 관리 할 수 없는 상황에 빠질 수 있다.
- 지도를 볼때 매우 상세하게 나온 대축적 지도를 보면 큰 수준에서 어디에 위치하고 있는지 이해하기 어려우므로 큰 수준에서 보여주는 소축척 지도를 함꼐 봐야 현재 위치를 보다 정확하게 이해할 수 있따.
- 이와 비슷하게 도메인 모델도 개발 객체뿐만 아니라 상위 수준에서 모델을 볼 수 있어야 전체 모델의 관계와 개발 모델을 이해하는데 도움이 된다. 
- 도메인 모델에서 전체 구조를 이해하는데 도움이 되는 것이 바로 애그리거트이다.
  
**애그리 거트**
- 관련 객체를 하나로 묶은 군집이다.
- 예) 주문 도메인 
  - 주문
  - 배송지정보
  - 주문자
  - 주문목록
  - 총 결제 금액 
  - 5개의 하위 모델로 구성되는데 이때 이 하위 개념을 표현한 모델을 하나로 묶어서 '주문'이라는 상위 개념으로 표현할 수 있다.
- 개별 객체가 아닌 관련 객체를 묶어서 객체 군집 단위로 모델을 바라볼 수 있게 된다.
- 개별 객체 간의 관계가 아닌 애그리거트 간의 관계로 도메인 모델을 이해하고 구현할 수 있게 되며, 이를 통해 큰 틀에서 도메인 모델을 관리할 수 있게 된다.
- 애그리거트는 군집에 속한 객체들을 관리하는 루트 엔티티를 갖는다.
- 루트엔티티
  - 애그리거트에 속해 있는 엔티티와 밸류 객체를 이용해서 애그리거트가 구현해야 할 기능을 제공
  - 애그리거트를 사용하는 코드는 애그리거트 루트가 제공하는 기능을 실행하고 애거리거트 루트를 통해서 간접적으로 애그리거트 내의 다른 엔티티나 밸류 객체에 접근하게 된다. 
  - 이는 애그리거트의 내부 구현을 숨겨서 애그리거트 단위로 구현을 캡슐화 할 수 있도록 돕는다.

**애그리거트 루트인 Order가 애그리거트에 속한 객체를 관리한다.**
![image](https://user-images.githubusercontent.com/28394879/134633979-5e762e94-62ff-49f4-b9ee-4b29b367ae31.png)
- 주문 애그리거트
- 애그리거트 루트인 Order는 주문 도메인 로직에 맞게 애그리거트의 상태를 관리한다. 
  - 예) Order의 배송지 정보 변경 기능은 배송지를 변경할 수 있는지 확인한 뒤에 배송지 정보를 변경한다.
  
**예) Order의 배송지 정보 변경 기능은 배송지를 변경할 수 있는지 확인한 뒤에 배송지 정보를 변경한다.**
```java
public class Order {
    //...
    public void changeShippingInfo(ShippingInfo newInfo) {
        checkShippinrgInfoChangeable(); // 배송지 변경 가능 여부 확인
        this.shippingInfo = newInfo;
    }
    
    private void checkShippinginfoChangeable() {
        //... 배송지 정보를 변경할 수 있는지 여부를 확인하는 도메인 규칙 구현 
    }
}
```
- checkShippingInfoChangeable() 메서드는 도메인 규칙에 따라 배송지를 변경할 수 있는지 확인한다.
  - 예) 이미 배송이 시작된 경우 익셉션을 발생하는 식으로 도메인 규칙을 구현 
- 주문 개그리거트는 Order를 통하지 않고 ShippingInfo를 변경할 수 있는 방법을 제공하지 않는다.
- 즉, 배송지를 변경하려면 루트 엔티티인 Order를 사용해야 하므로 배송지 정보를 변경할 떄에는 Order가 구현한 도메인 로직을 항상 따르게 된다.
- 애그리거트를 구현할떄는 고려할 것이 많다.
- 애그리거트를 어떻게 구현하느냐에 따라 구현이 복잡해지기도 하고 트랜잭션 범위가 달라지기도 한다.
- 또한 선택한 기술에 따라 애그리거트 구현에 제약이 생기기도 한다.
- 애그리거트의 구현에 대한 내용은 3장에서 자세히 살펴본다.

### 리포지터리
- 도메인 객체를 지속적으로 사용하려면 RDBMS, NoSQL, 로컬 파일과 같은 물리적인 저장소에 도메인 객체를 보관해야 한다.
- 이를 위한 도메인 모델이 리포지터리(repository)이다.
- 엔티티나 밸류: 요구사항에서 됴출되는 도메인 모델 / 리포지터리: 구현을 위한 도메인 모델
- 리포지터리는 애그리거트 단위로 도메인 객체를 저장하고 조회하는 기능을 정의한다.

**예) 주문 애그리거트를 위한 리포지 터리**

```java
public interface OrderRepository {
    public Order findBynumber(OrderNumber number);
    public void save(Order order);
    public void delete(Order order);
}
``` 
- OrderRepository의 메서드를 보면 대상을 찾고 저장하는 단위가 애그리거트 루트인 Order인 것을 알 수 있다.
- Order는 애그리거트에 속한 모든 객체를 포함하고 있으므로 결과적으로 애그리거트 단위로 저장하고 조회한다.
- 도메인 모델을 사용해야 하는 코드는 리포지터리를 통해서 도메인 객체를 구한 뒤에 도메인 객체의 기능을 실행하게 된다.

**예) 주문 취소 기능을 제공하는 응용 서비스는 OrderRepository를 이용해서 Order 객체를 구하고 해당 기능을 실행**
```java
public class CancelOrderService {
    private OrderRepository orderRepository;

    public void cancel(OrderNumber number) {
        Order order = orderRepository.findByNumber(number);
        if (order == null) throw new NoOrderException(number);
        order.cancel();
    }

    //... DI 등의 방식으로 OrderRepository 객체 전달 
}
```
- 도메인 모델 관점에서 OrderRepository는 도메인 객체를 영속화하는데 필요한 기능을 추상화한 것으로 고수준 모듈에 속한다.
- 기반 기술을 이용해서 OrderRepository를 구현한 클래스는 저수준 모듈로 인프라스트럭처 영역에 속한다. 

**리포지터리 인터페이스는 도메인 모델 영역에 속하며, 실제 구현 클래스는 인프라스트럭처 영역에 속한다.**
![image](https://user-images.githubusercontent.com/28394879/134641093-792e01b7-4417-444e-8500-917665513c8e.png)


- 응용 서비스는 의존 주입과 같은 방식을 사용해서 실제 리포지터리 구현 객체에 접근한다.

**스프링 프레임워크의 의존 주입 방식**
```java
@Configuration
public class OrderServiceConfig { // 응용 서비스 영역 설정
    @Autowired
    private OrderRepository orderRepository;

    @Bean
    public CancelOrderService cancelOrderService() {
        return new CancelOrderService(orderRepository);
    }
}

@Configuration
public class RepositoryConfig { // 인프라스트럭처 영역 설정
    @Bean
    public JpaOrderRepository orderRepository() {
        return new JpaOrderRepository();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean emf() {
        //...
    }

}
``` 
- 응용 서비스와 리포지터리는 밀접한 연관이 있다.
  - 응용 서비스는 필요한 도메인 객체를 구하거나 저장할 떄 리포지터리를 사용한다.
  - 응용 서비스는 트랜잭션을 관리하는데, 트랜잭션 처리는 리포지터리 구현 기술에 영향을 받는다.
- 리포지터리의 사용 주체가 응용 서비스이기 때문에 리포지터리는 응용 서비스가 필요로 하는 메소드를 제공한다. 가장 기본이 되는 메서드는 다음의 두 메서드이다.
  - 에그리거트를 저장하는 메서드
  - 에그리거트 루트 식별자로 에그리거트를 조회하는 메서드 
  - 두 메서드는 다음의 형태를 갖는다.
  ```java
  public interface SomeRepository {
      void save(Some some);
      Some findById(SomeId id);
  }
  ``` 
  - 이 외에 필요에 따라 delete(id)나 counts() 등의 메서드를 제공하기도 한다.
- 리포지터리를 구현하는 방법은 선택한 구현 기술에 따라 달라지는데 리포지터리의 구현에 대한 내용은 4장과 5장에서 살펴보도록 한다. 


</details>

<details> <summary> 5. 요청 처리 흐름 </summary>

## 5. 요청 처리 흐름
- 사용자 입장에서 봤을 때 웹 애플리케이션이나 데스크톱 애플리케이션과 같은 소프트웨어는 기능을 제공한다.
- 사용자가 애플리케이션에 기능 실행을 요청하면 그 요청을 처음 받는 영역은 표현 영역이다.
- 스프링 MVC를 사용해서 웹 애플리케이션을 구현했다면 컨트롤러가 사용자의 요청을 받아 처리하게 된다.
- 표현 영역은 사용자가 전송한 데이터 형식이 올바른지 검사하고 문제가 없다면 데이터를 이용해서 응용 서비스에 기능 실행을 위임한다. 
- 이때 표현 영역은 사용자가 전송한 데이터를 응용 서비스가 요구하는 형식으로 변환해서 전달한다.
- 웹 브라우저를 이용해서 기능 실행을 요청할 경우, 컨트롤러가 HTTP 요청 파라미터를 응용 서비스가 필요로 하는 데이터로 변환해서 응용 서비스를 실행할 때 파라미터로 전달한다.
 
**요청 처리 흐름**
![image](https://user-images.githubusercontent.com/28394879/134645891-ffd75beb-fa46-4cab-9af3-08d527ebe7eb.png)
- 응용 서비스는 도메인 모델을 이용해서 기능을 구현한다.
- 기능 구현에 필요한 도메인 객체를 리포지터리에서 가져와 실행하거나 신규 도메인 객체를 생성해서 리포지터리에 저장한다.
- 두 개 이상의 도메인 객체를 사용해서 구현하기도 한다.

**스프링의 트랜잭션 관리 기능을 이용한 트랜잭션 처리**
```java
public class CancelOrderService {
    private OrderRepository orderRepository;

    @Transaction // 응용 서비스는 트랜잭션을 관리한다.
    public void cancel(OrderNumber number) {
        Order order = orderRepository.findByNumber(number);
        if (order == null) throw new NoOrderException(number);
        order.cancel();
    }
    //...
}
```
- 예매하거나 예매 취소와 같은 기능을 제공하는 응용 서비스는 도메인의 상태를 변경하므로 변경 상태가 물리 저장소에 올바르게 반영되도록 트랜잭션을 관리해야 한다.
- 응용 서비스의 구현에 대해서는 6장에서 자세히 다룬다.

### 인프라스트럭처 개요 
- 인프라스트럭처는 표현 영역, 응용 영역, 도메인 영역을 지원한다. 
- 도메인 객체의 영속성 처리, 트랜잭션, SMTP 클라이언트, REST 클라이언트 등 다른 영역에서 필요로 하는 프레임워크, 구현 기술, 보조 기능을 지원한다.
- DIP에서 언급한 것처럼 도메인 영역과 응용 영역에서 인프라스트럭처의 기능을 직접 사용하는 것보다 이 두 영역에 정의한 인터페이스를 인프라스트럭처 영역에서 구현하는 것이 시스템을 더 유연하고 테스트하기 쉽게 만들어준다. 
- 하지만, 무조건 인프라스트럭처에 대한 의존을 없애는 것이 좋은 것은 아니다.
  - 예) 스프링을 사용할 경우 응용 서비스는 트랜잭션 처리를 위해 스프링이 제공하는 @Transactional을 사용하는 것이 편리하다. 영속성 처리를 위해 JPA를 사용할 경우 @Entity나 @Table과 같은 JPA 전용 애노테이션(Annotation)을 도메인 모델 클래스에 사용하는 것이 XML 매핑 설정을 이용하는 것 보다 편리하다.

**인프라스트럭처에 대한 의존을 일부 도메인에 넣은 코드**
```java
// 구현의 편리함을 위해 인프라스트럭처에 대한 의존을 일부 도메인에 넣은 코드 
// JPA의 @Table 애노테이션을 이용해서 엔티티틀 저장할 테이블 이름을 지정 
// XML 설정을 사용하는 것보다 편리하게 테이블 이름을 지정할 수 있다.
@Entity
@Table(name = "TBL_ORDER")
public class Order {
    //...
}
```
- 구현의 편리함은 DIP가 주는 다른 장점(변경의 유연함, 테스트가 쉬움) 만큼 중요하기 때문에 DIP의 장점을 해치지 않는 범위에서 응용 영역과 도메인 영역에서 구현 기술에 대한 의존을 가져가는 것이 현명하다.
- 응용 영역과 도메인 영역이 인프라스트럭처에 대한 의존을 완전히 갖지 않도록 시도하는 것은 자칫 구현을 더 복잡하고 어렵게 만들 수 있다.
  - 좋은 예) 스프링의 @Transactional 애노테이션
  - @Transactional을 사용하면 한줄로 트랜잭션을 처리할 수 있는데, 코드에서 스프링에 대한 의존을 없애려면 복잡한 스프링 설정을 사용해야 한다.
  - 의존을 없앴지만 특별히 테스트를 더 쉽게 할 수 있다거나 유연함을 증가시켜주지 못한다.
  - 단지 설정만 복잡해지고 개발 시간만 늘어날 뿐이다.
- 표현 영역은 항상 인프라스트럭처 영역과 쌍을 이룬다.
  - 스프링 MVC를 사용해서 웹 요청을 처리하면 스프링이 제공하는 MVC 프레임워크에 맞게 표현 영역을 구현해야 하고, Vert.x를 사용해서 REST API 서버를 구축하려면 Vert.x에 맞게 웹 요청 처리부분을 구현해야 한다.


</details>

<details> <summary> 6. 모듈 구성 </summary>

## 6. 모듈 구성
**영역별로 별도 패키지로 구성한 모듈 구조**

![image](https://user-images.githubusercontent.com/28394879/134653015-94c85889-e4bf-4ff2-9782-d07412ffcf63.png)
- 아키텍처의 각 영역은 별도 패키지에 위치한다.
- 패키지 구성 규칙에 한 개의 정답만 존재하는 것은 아니지만 영역별로 모듈이 위치한 패키지를 구성 할 수 있다.
- 여기서 com.myshop은 예시로 든 패키지이므로 알맞은 패키지로 대체하면 된다.
  
**도메인이 크면 하위 도메인별로 모듈을 나눈다**

![image](https://user-images.githubusercontent.com/28394879/134657605-0013a15d-c32a-443f-9f06-4d40bf1fbb62.png)


**하위 도메인을 하위 패키지로 구성한 모듈 구조**

![image](https://user-images.githubusercontent.com/28394879/134657118-86d15ac3-5917-441a-8061-0aa62639430f.png)

- domain 모듈은 도메인에 속한 애그리거트를 기준으로 다시 패키지를 구성한다.
- 예) 카탈로그 하위 도메인을 위한 도메인은 상품 애그리거트와 카테고리 애그리거트로 구성된다고 할 경우 domain을 두 개의 하위 패키지로 구성할 수 있다.


**etc**

- 각 애그리거트와 모델과 리포지터리는 같은 패키지에 위치시킨다.
  - 예) 주문과 관련된 Order, OrderLine, Orderer, OrderRepository 등은 com.myshop.order.domain 패키지에 위치시킨다.
- 도메인이 복잡하면 도메인 모델과 도메인 서비스를 다음과 같이 별도 패키지에 위치시킬 수도 있다.
  - com.myshop.order.domain.order: 애그리거트 위치
  - com.myshop.order.domain.service: 도메인 서비스 위치
- 응용 서비스도 다음과 같이 도메인 별로 패키지를 구분할 수 있다.
  - com.myshop.catalog.application.proudct
  - com.myshop.catalog.application.category

- 모듈 구조를 얼마나 세분화해야 하는지에 대해 정해진 규칙은 없다.
- 단지, 한 패키지에 너무 많은 타입이 몰려서 코드를 찾을 때 불편한 정도만 아니면 된다.
- 개인적으로는 한 패키지에 가능하면 10개 미만으로 타입 개수를 유지하려고 노력한다.
- 이 개수가 넘어가면 모듈을 분리하는 시도를 해본다. 
  

</details>



# [3. 애그리거트](./3.애그리거트)

<details> <summary> 1. 애그리거트 </summary>

## 1. 애그리거트

**상위 수준에서 모델을 정리하면 복잡한 도메인 모델의 관계를 이해하는데 도움이 된다**

![image](https://user-images.githubusercontent.com/28394879/134831585-7d49ef99-f4b7-458b-8e53-370fc2fbd0f8.png)
- 온라인 쇼핑몰을 위한 시스템을 개발한다면 위 그림과 같이 상위 수준 개념을 이용해서 전체 모델을 정리하면 전반적인 관계를 이해하는데 도움이 된다. 
- 주문은 회원, 상품, 결제와 관련이 있다는것을 쉽게 파악할 수 있다. 


**개별 객체 수준에서 모델을 바라보면 상위 수준에서 관계를 파악하기 어렵다**

![image](https://user-images.githubusercontent.com/28394879/134831864-05a44944-0fc9-43bd-99aa-a20631822c8e.png)
- 상위수준 모델을 개별 객체 단위로 다시 그린 그림이다. 
- 상위모델에 대한 이해 없이 위 그림만 보고 상위 수준에서 개념을 파악하려면 더 오랜 시간이 걸린다. 
- 더 많은 코드를 보고 도메인 전문가와 더 많은 대화를 나눠야 비로소 상위 수준에서 모델 간의 관계가 이해되기 시작한다. 
- 백 개 이상의 테이블을 한장의 ERD에 모두 표시하면 개별 테이블 간의 관계를 파악하느라 큰 틀에서 데이터 구조를 이해하는데 어려움을 겪게 되는 것처럼, 도메인 객체 모델이 복잡해지면 개별 구성요소 위주로 모델을 이해하게 되고 전반적인 구조나 큰 수준에서 도메인 간의 관계를 파악하기 어려워진다. 
  - 주요 도메인 개념 간의 관계를 파악하기 어렵다는 것은 곧 코드를 변경하고 확장하는 것이 어려워진다는 것을 의미한다.
  - 상위 수준에서 모델이 어떻게 엮여 있는지 알아야 전체 모델을 망가뜨리지 않으면서 추가 요구사항을 모델에 반영할 수 있는데 세부적인 모델만 이해한 상태로는 코드를 수정하기가 두렵기 때문에 코드 변경을 최대한 회피하는 쪽으로 요구사항을 협의하게 된다. 
  - 꼼수를 부려 당장 돌아가는 코드를 추가할 수는 있지만 이는 장기적인 관점에서 코드를 더 수정하기 어렵게 만들기도 한다. 


 **애그리거트는 복잡한 모델을 관리하는 기준을 제공한다.**

 ![image](https://user-images.githubusercontent.com/28394879/134832495-e9985c97-adc7-4264-8b2c-78c6d3335c09.png)
 - 복잡한 도메인을 이해하고 관리하기 쉬운 단위로 만들려면 상위 수준에서 모델을 조망할 수 있는 방법이 필요한데, 그 방법이 바로 애그리거트이다. 
   - 애그리거트는 관련된 객체를 하나의 군으로 묶어준다.
   - 수많은 객체를 애그리거트로 묶어서 바라보면 좀 더 상위 수준에서 도메인 모델 간의 관계를 파악할 수 있다.
 - 위 그림은 객체 수준 모델에서 모델을 애그리거트로 묶어서 다시 표현한 것이다.
 - 동일한 모델이지만 애그리거트를 사용함으로써 모델 간의 관계를 개별 모델 수준뿐만 아니라 상위 수준에서도 이해할 수 있게 된다. 
 - 애그리거트는 모델을 이해하는데 도움을 줄 뿐만 아니라 일관성을 관리하는 기준이 된다.
 - 모델을 잘 이해할 수 있고 애그리거트 단위로 일관성을 관리하기 때문에 애그리거트는 복잡한 도메인을 단순한 구조로 만들어준다.
   - 복잡도가 낮아지는 만큼 도메인 기능을 확장하고 변경하는데 필요한 노력(개발시간)도 줄어든다.
 - 애그리거트는 관련된 모델을 하나로 모은 것이기 떄문에 한 애그리거트에 속한 객체는 유사하거나 동일한 라이프사이클을 갖는다. 
   - 주문 애그리거트를 만들렴녀 Order, OrderLine, Orderer와 같은 관련 객체를 함께 생성해야 한다.
   - Order는 생성했는데 ShippingInfo는 만들지 않았거나 ShippingInfo를 생성하면서 Orderer를 생성하지 않는 경우는 없다.
   - 도메인 규칙에 따라 최초 주문 시점에 일부 객체를 만들 필요가 없는 경우도 있지만 애그리거트에 속한 구성요소는 대부분 함께 생성하고 함께 제거한다.
 - 애그리거트는 경계를 갖는다.
   - 한 애그리거트에 속한 객체는 다른 애그리거트에 속하지 않는다.
   - 애그리거트는 독립된 객체 군이며, 각 애그리거트는 자기 자신을 관리할 뿐 다른 애그리거트를 관리하지 않는다.
   - 예) 주문 애그리거트는 배송지를 변경하거나 주문 상품 개수를 변경하는 등 자기자신을 관리하지만, 주문 애그리거트에서 회원읜 비밀번호를 변경하거나 상품의 가격을 변경하지 않는다.
 - 경계를 설정할 때 기본이 되는 것은 도메인 규칙과 요구사항이다.
   - 도메인 규칙에 따라 함께 생성되는 구성요소는 한 애그리거트에 속할 가능성이 높다.
   - 예) 주문할 상품 개수, 배송지 정보, 주문자 정보는 주문 시점에 함께 생성되므로 이들은 한 애그리거트에 속한다. 또한, OrderLine의 주문 상품 개수를 변경하면 도메인 규칙에 따라 Order의 총 주문 금액을 새로 계산해야 한다. 
   - 사용자 요구사항에 따라 주문 상품 개수와 배송지를 함께 변경하기도 한다.
   - 이렇게 함께 변경되는 빈도가 높은 객체는 한 애그리거트에 속할 가능성이 높다. 
 - 흔히 'A가 B를 갖는다' 로 설계할 수 있는 요구사항이 있다면 A와 B를 한 애그리거트로 묶어서 생각하기 쉽다.
   - 주문의 경우 Order가 ShippingInfo와 Orderer를 가지므로 이는 어느 정도 타당해 보인다.
   - 하지만, 'A가 B를 갖는다'로 해석할 수 있는 요구사항이 있다고 하더라도 이것이 반드시 A와 B가 한 애그리거트에 속한다는 것을 의미하는 것은 아니다.
   - 예) 상품과 리뷰
     - 상품 상세 페이지에 들어가면 상품 상세 정보와 함께 리뷰 내용을 보여줘야 한다는 요구사항이 있다면 Product 엔티티와 Review 엔티티가 한 애그리거트에 속한다고 생각할 수 있다.
     - 하지만, Product와 Review는 함께 생성 되지 않고 함께 변경되지도 않는다.
     - 게다가, Product를 변경하는 주체가 상품 담당자라면 Review를 생성하고 변경하는 주체는 고객이다.


**Product가 Review를 갖는 것으로 생각할 수 있지만, 상품과 리뷰는 함께 생성되거나 변경되지 않고 변경 주체도 다르기 떄문에 서로 다른 애그리거트에 속한다.**

![image](https://user-images.githubusercontent.com/28394879/134835112-e53027c7-8f99-4858-bc51-c665b2ca6cdb.png) 
- Review의 변경이 Product에 영향을 주지 않고 반대로 Product의 변경이 Review에 영향을 주지 않기 때문에 이 둘은 한 애그리거트에 속한다기 보다는 서로 다른 애그리거트에 속한다.


<br>

- 처음 도메인 모델을 만들기 시작하면 큰 애그리거트로 보이는 것들이 많지만 도메인에 대한 경험이 생기고 도메인 규격을 제대로 이해할수록 실제 애그리거트의 크기는 줄어들게 된다.
- 애그리거트가 한 개의 엔티티 객체만 갖는 경우가 많으며 두 개 이상의 엔티티로 구성되는 애그리거트는 드물게 존재한다. 


</details>

<details> <summary> 2. 애그리거트 루트 </summary>

## 2. 애그리거트 루트 

- 주문 애그리거트는 다음을 포함한다.
  - 총 금액인 totalAmounts를 갖고 있는 Order 엔티티
  - 개별 구매 상품의 개수인 quantity와 금액인 price를 갖고 있는 OrderLine 밸류
- 구매할 상품의 개수를 변경하면 한 OrderLine의 quantity를 변경하고 더불어 Order의 totalAmounts도 변경해야 한다. 
- 그렇지 않으면 '주문 총 금액은 개별 상품의 주문 개수 X 가격의 합이다.' 라는 도메인 규칙을 어기고 데이터 일관성이 깨진다. 
- 애그리거트는 여러 객체로 구성되기 떄문에 한 객체만 상태가 정상이어서는 안 된다. 
- 도메인 규칙을 지키려면 애그리거트에 속한 모든 객체가 정상 상태를 가져야 한다. 
- 주문 애그리거트의 경우 OrderLine을 변경하면 Order의 totalAmounts도 다시 계산해서 총 금액이 맞아야 한다. 


**주문 애그리거트의 루트는 Order이다** 

![image](https://user-images.githubusercontent.com/28394879/134840374-d2694c1a-a776-4625-91cd-c709fa107a0f.png)

- 애그리거트에 속한 모든 객체가 일관된 상태를 유지하려면 애그리거트 전체를 관리할 주체가 필요한데 이 책임을 지는 것이 바로 애그리거트의 루트 엔티티이다. 
- 애그리거트 루트 엔티티는 애그리거트의 대표 엔티티로 애그리거트에 속한 객체는 애그리거트 루트 엔티티에 직접 또는 간접적으로 속한다.
- 주문 애그리거트에서 루트 역할을 하는 엔티티는 Order이다.
  - OrderLine, ShippingInfo, Orderer 등 주문 애그리거트에 속한 모델은 Order에 직접 또는 간접적으로 속한다.


### 도메인 규칙과 일관성 
- 애그리거트 루트가 단순히 애그리거트에 속한 객체를 포함하는 것으로 끝나는 것은 아니다.
- 애그리거트 루트의 핵심 역할은 애그리거트의 일관성이 깨지지 않도록 하는 것이다.
  - 예) 주문 애그리거트는 배송지 변경, 상품 변경과 같은 기능을 제공하는데 애그리거트 루트인 Order가 이 기능을 구현한 메서드를 제공한다.
- 애그리거트 루트가 제공하는 메서드는 도메인 규칙에 따라 애그리거트에 속한 객체의 일관성이 꺠지지 않도록 구현해야 한다.
  - 예) 배송이 시작되기 전까지만 배송지 정보를 변경할 수 있다는 규칙이 있다면, 애그리거트 루트인 Order의 changeShippingInfo() 메서드는 이 규칙에 따라 배송 시작 여부를 확인하고 변경이 가능한 경우에만 배송지 정보를 변경해야 한다.
  ```java
  public class Order{
      
      // 애그리거트 루트는 도메인 규칙을 구현한 기능을 제공한다.
      public void changeShippingInfo(ShippingInfo newShippingInfo) {
          verifyNotYetShipped();
          setShippingInfo(newShippingInfo);
      }

      private void verifyNotYetShipped() {
          if (state != OrderState.PAYMENT_WAITING && state != OrderState.WAITING) throw new IllegalStateException("already shipped");
      }
  }
  ``` 
- 애그리거트 루트가 아닌 다른 객체가 애그리거트에 속한 객체를 직접 변경하면 안된다.
- 이는 애그리거트 루트가 강제하는 규칙을 적용할 수 없어 모델의 일관성을 꺠지는 원인이 된다. 
  ```java
  ShippingInfo si = order.getShippingInfo();
  si.setAddress(newAddress);
  ``` 
  - 이 코드는 애그리거트 루트인 Order에서 ShippingInfo를 가져와 직접 정보를 변경하고 있다. 
  - 주문 상태에 상관없이 배송지 주소를 변경할 수 있는데, 이는 업무 규칙을 무시하고 DB 테이블에서 직접 데이터를 수정하는 것과 같은 결과를 만든다.
  - 즉, 논리적인 데이터 일관성이 깨지게 되는 것이다.
  - 일관성을 지키기 위해 다음과 같이 상태 확인 로직을 응용 서비스에 구현할 수도 있지만, 이렇게 되면 동일한 검사 로직을 여러 응용 서비스에서 중복해서 구현할 가능성이 높아져 상황을 더 악화시킬 수 있다.
  ```java
  ShippinrgInfo si = order.getShippingInfo();
  
  // 주요 도메인 로직이 중복되는 문제 
  if (state != OrderState.PAYMENT_WAITING && state != OrderState.WAITING) throw new IllegalStateException("already shipped");

  si.setAddress(newAddress);
  ``` 
- 불필요한 중복을 피하고 애그리거트 루트를 통해서만 도멩니 로직을 구현하게 만들려면 도메인 모델에 대해 다음의 두가지를 습관적으로 적용해야 한다.
  - 단순히 필드를 변경하는 set 메서드를 공개(public)범위로 만들지 않는다.
  - 밸류 타입은 불변으로 구현한다.

**set 메서드를 공개(public)범위로 만들지 않는다**

```java
// 도메인 모델에서 공개 set 메서드는 가급적 피해야 한다.
public void setName(String name) {
    this.name = name;
}
```
- 보통 공개 set 메서드는 위와 같이 필드에 값을 할당하는 것으로 끝내는 경우가 많다. 잘해야 null을 검사하는 정도이다.
- 공개 set 메서드는 중요 도메인의 의미나 의도를 표현하지 못하고 도메인 로직이 도메인 객체가 아닌 응용 영역이나 표현 영역으로 분산되게 만드는 원인이 된다. 
- 도메인 로직이 한곳에 응집되어 있지 않게 되므로 코드를 유지보수할 대에도 분석하고 수정하는 데 더 많은 시간을 들이게 된다. 
- 도메인 모델의 엔티티나 밸류에 공개 set 메서드만 넣지 않아도 일관성이 꺠질 가능성이 줄어든다.
- 공개 set 메서드를 사용하지 않게 되면 의미가 드러나는 메서드를 사용해서 구현할 가능성이 높아진다.
  - 예) set형식의 이름을 갖는 공개 메섣르르 사용하지 않으면 자연스럽게 cancel이나 changePassword처럼 의미가 더 잘드러나는 이름을 사용하는 빈도가 높아진다.

**밸류 타입은 불변으로 구현한다**

```java
ShippingInfo si = order.getShippingInfo();
si.setAddress(newAddress); // ShippingInfo 밸류 객체가 불변이면, 이 코든느 컴파일 에러!
```
- 공개 set 메서드를 만들지 않는 것의 연장으로 밸류는 불변 타입으로 구현한다.
- 밸류 객체의 값을 변경할 수 없으면 애그리거트 루트에서 밸류 객체를 구해도 값을 변경할 수 없기 떄문에 애그리거트 외부에서 밸류 객체의 상태를 변경할 수 없게 된다.


**애그리거트 루트가 제공하는 메서드로 새로운 밸류 객체로 변경**

```java
public class Order {
    private ShippingInfo shippingInfo;
    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }
    // set 메서드의 접근 허용 범위는 private이다.
    private void setShippingInfo(ShippingInfo newShippingInfo) {
        // 밸류가 불변이면, 새로운 객체를 할당해서 값을 변경해야 한다. 
        // 불변이므로 this.shippingInfo.setAddress(newShippingInfo.getAddress())와 같은 
        // 코드를 사용할 수 없다.
        this.shippingInfo = newShippingInfo;
    }
}
```
- 애그리거트 외부에서 내부 상태를 함부로 바꾸지 못하므로 애그리거트의 일관성이 꺠질 가능성이 줄어든다.
- 밸류 객체가 불변이면 밸류 객체의 값을 변경하는 방법은 새로운 밸류 객체를 할당하는 것 뿐이다.
- 즉, 위의 코드와 같이 애그리거트 루트가 제공하는 메서드에 새로운 밸류 객체를 전달해서 값을 변경하는 방법밖에 없다.
- 밸류 타입의 내부 상태를 변경하려면 애그리거트 루트를 통해서만 가능하다.
- 그러므로, 애그리거트 루트가 도메인 규칙을 올바르게만 구현하면 애그리거트 전체의 일관성을 올바르게 유지할 수 있다. 

### 애그리거트 루트의 기능 구현 
- 애그리거트 루트는 애그리거트 내부의 다른 객체를 조합해서 기능을 완성한다.
  - 예) Order는 총 주문 금액을 구하기 위해 OrderLine 목록을 사용한다.
  ```java
  public class Order {
      private Money totalAmounts;
      private List<OrderLine> orderLines;

      private void calculateTotalAmounts() {
          int sum = orderLines.stream()
                .mapToInt(ol -> ol.getPrice() * ol.quantity())
                .sum();
        this.totalAmounts = new Money(sum);
      }
  }
  ```
  - 예) 회원을 표현하는 Member 애그리거트 루트는 암호를 변경하기 위해 Password 객체에 암호가 일치하는지 여부를 확인할 수 있다.
  ```java
  public class Member {
      private Password password;

      public void changePassword(String currentPassword, String newPassword) {
          if (!password.match(currentPassword)) {
              throw new PasswordNotMatchException();
          }
          this.password = new Password(newPassword);
      }
  }
  ``` 
- 애그리거트 루트가 구성요소의 상태만 참조하는 것은 아니다. 기능 실행을 위임 하기도 한다.
  - 예) 구현 기술의 제약이나 내부 모델링 규칙 때문에 OrderLine 목록을 별도 클래스로 분리했다고 해보자.
  ```java
  public class OrderLines {
      private List<OrderLine> lines;

      public Money getTotalAmounts() {...구현;}
      public void changeOrderLines(List<OrderLine> newLines) {
          this.lines = newLines;
      }
  }
  ```
  - 이 경우 Order의 changeOrderLines() 메서드는 다음과 같이 내부의 orderLines 필드에 상태 변경을 위임하는 방식으로 기능을 구현한다.
  ```java
  public class Order {
      private OrderLines orderLines;
      
      public void changeOrderLines(List<OrderLine> newLines) {
          orderLines.changeOrderLines(newLines);
          this.totalAmounts = orderLines.getToitalAmounts();
      }
  }
  ```   
  - OrderLines는 changeOrderLines()와 getTotalAmounts() 같은 기능을 제공하고 있다.
  - 만약 Order가 getOrderLines()와 같이 OrderLines를 구할 수 있는 메서드를 제공하면 애그리거트 외부에서 OrderLines의 기능을 실행할 수 있게 된다.  
  ```java
  OrderLines lines = order.getOrderLines();
  // 외부에서 애그리거트 내부 상태 변경!
  // order의 totalAmounts가 값이 OrderLines가 일치하지 않게 됨
  lines.changeOrderLines(newOrderLines);
  ```
  - 이 코드는 주문의 OrderLine 목록이 바뀌는데 총합은 계산하지 않는 버그를 만든다. 
  - 이런 버그가 생기지 않도록 하려면 애초에 애그리거트 외부에서 OrderLine 목록을 변경할 수 없도록 OrderLines를 불변으로 구현하면 된다. 
  - 팀 표준이나 구현 기술의 제약으로 OrderLines를 불변으로 구현할 수 없다면 OrderLines의 변경 기능을 패키지나 protected 범위로 한정해서 외부에서 실행할 수 없도록 제한하는 방법이 있다.
  - 보통 한 애그리거트에 속하는 모델은 한 패키지에 속하기 때문에 패키지나 protected 범위를 사용하면 애그리거트 외부에서 상태 변경 기능을 실행하는 것을 방지할 수 있다. 

### 트랜잭션 범위
- 트랜잭션 범위는 작을수록 좋다.
- DB 테이블을 기준으로 한 트랜잭션이 한 개 테이블을 수정하는 것과 세개의 테이블을 수정하는 것은 성능에서 차이가 발생한다.
  - 한 개 테이블을 수정할 떄에는 트랜잭션 충돌을 막기 위해 잠그는 대상이 한 개 테이블의 한 행으로 한정되지만, 세 개의 테이블을 수정하면 잠금 대상이 더 많아진다. 
  - 잠금 대상이 많아진다는 것은 그만큼 동시에 처리할 수 있는 트랜잭션 개수가 줄어든다는 것을 뜻하고 이는 전체적인 성능(처리량)을 떨어뜨린다. 
- 동일하게 한 트랜잭션에서는 한 개의 애그리거트만 수정해야 한다.
  - 한 트랜잭션에서 두 개 이상의 애그리거트를 수정하면 트랜잭션 충돌이 발생할 가능성이 더 높아지기 떄문에 한번에 수정하는 애그리거트 개수가 많아질수록 전체 처리량이 떨어지게 된다.
- 한 트랜잭션에서 한 애그리거트만 수정한다는 것은 애그리거트에서 다른 애그리거트를 변경하지 않는다는 것을 뜻한다.
  - 한 애그리거트에서 다른 애그리거트를 수정하면 결과적으로 두 개의 애그리거트를 한 트랜잭션에서 수정하게 되므로 한 애그리거트 내부에서 다른 애그리거트의 상태를 변경하는 기능을 실행하면 안 된다.
  - 예) 배송지 정보를 변경하면서 동시에 배송지 정보를 회원의 주소로 설정하는 기능이 있다고 해보자. 
  ```java
  public class Order {
      private Orderer orderer;

      public void shipTo(ShippingInfo newShippingInfo, boolean useNewShippingAddrAsMemberAddr) {
          verifyNotYetShipped();
          setShippingInfo(newShippingInfo);
          if(useNewShippingAddrAsMemberAddr) {
              // 다른 애그리거트의 상태를 변경하면 안 됨!
              orderer.getCustomer().changeAddress(newShippingInfo.getAddress());
          }
      }
  }
  ``` 
  - 이 경우 주문 애그리거트는 회원 애그리거트의 정보를 변경하면 안된다.
  - 이는 애그리거트가 자신의 책임 범위를 넘어 다른 애그리거트의 상태까지 관리하는 꼴이 된다.
  - 애그리거트는 서로 최대한 독립적이어야 하는데 한 애그리거트가 다른 애그리거트의 기능에 의존하기 시작하면 애그리거트 간 결합도가 높아지게 된다.
  - 결합도가 높아지면 높아질수록 향후 수정 비용이 증가하므로 애그리거트에서 다른 애그리거트의 상태를 변경하지 말아야 한다.
  - 만약 부득이하게 한 트랜잭션으로 두 개 이상의 애그리거트를 수정해야 한다면 애그리거트에서 다른 애그리거트를 직접 수정하지 말고 응용 서비스에서 두 애그리거트를 수정하도록 구현해야 한다.
  ```java
  public class ChangeOrderService {
      // 두 개 이상의 애그리거트를 변경해야 하면,
      // 응용 서비스에서 각 애그리거트의 상태를 변경한다.
      @Transactional
      public void changeShippingInfo(OrderId id, ShippingInfo newShippingInfo, boolean useNewShippingAddrAsMemberAddr) {
          Order order = orderRepository.findById(id);
          if (order == null) throw new OrderNotFoundException();
          order.shipTo(newShippingInfo);
          if(useNewShippingAddrAsMemberAddr) {
              order.getOrderer()
                    .getCustomer().changeAddress(newShippingInfo.getADdress());
          }
      }
  }
  ``` 


- 도메인 이벤트를 사용하면 한 트랜잭션에서 한 개의 애그리거트를 수정하면서도 동기나 비동기로 다른 애그리거트의 상태를 변경하는 코드를 작성할 수 있는데, 이에 대한 내용은 10장에서 살펴보자. 
- 한 트랜잭션에서 한 개의 애그리거트를 변경하는 것을 권장하지만 다음의 경우에는 한 트랜잭션에서 두 개 이상의 애그리거트를 변경하는 것을 고려할 수 있다. 
  - 팀 표준: 팀이나 조직의 표준에 따라 사용자 유스케이스와 관련된 응용 서비스의 기능을 한 트랜잭션으로 실행해야 하는 경우가 있다. DB가 다른 경우 글로벌 트랜잭션을 반드시 사용하도록 규칙을 정하는 곳도 있다.
  - 기술 제약: 한 트랜잭션에서 두 개 이상의 애그리거트를 수정하는 대신 도메인 이벤트와 비동기를 사용하는 방식을 사용하는데, 기술적으로 이벤트 방식을 도입할 수 없는 경우 한 트랜잭션에서 다수의 애그리거트를 수정해서 일관성을 처리해야 한다. 
  - UI 구현의 편리: 운영자의 편리함을 위해 주문 목록 화면에서 여러 주문의 상태를 한 번에 변경하고 싶을 것이다. 이 경우 한 트랜잭션에서 여러 주문 애그리거트의 상태를 변경할 수 있을 것이다.


</details>

<details> <summary> 3. 리포지터리와 애그리거트 </summary>

## 3. 리포지터리와 애그리거트

- 애그리거트는 개념상 완전한 한 개의 도메인 모델을 표현하므로 객체의 영속성을 처리하는 리포지터리는 애그리거트 단위로 존재한다. 
  - 예) Order와 OrderLine을 물리적으로 각각 별도의 DB 테이블에 저장한다고 해서 Order와 OrderLine을 위한 리포지터리를 각각 만들지 않는다. 
  - Order가 애그리거트 루트이고 OrderLine는 애그리거트에 속하는 구성요소이므로 Order를 위한 리포지터리만 존재한다. 
- 새로운 애그리거트를 만들면 저장소에 애그리거트를 영속화하고 애그리거트를 사용하려면 저장소에서 애그리거트를 읽어야 하므로 리포지터리는 적어도 다음의 두 메서드를 제공해야 한다.
  - save: 애그리거트 저장
  - findById: ID로 애그리거트를 구함
  - 이 두 메서드 외에 필요에 따라 다양한 조건으로 애그리거트를 검색하는 메서드나 애그리거트를 삭제하는 메서드를 추가할 수 있다. 
- 어떤 기술을 이용해서 리포지터리를 구현하느냐에 따라 애그리거트의 구현도 영향을 받는다.
  - ORM 기술 중의 하나인 JPA/하이버네이트를 사용하면 데이터베이스 관계형 모델에 객체 도메인 모델을 맞춰야 하는 경우도 있다. 
  - 특히 레거시 DB를 사용해야 하거나 팀 내 DB 설계 표준을 따라야 한다면 DB 테이블 구조에 맞게 모델을 변경해야 한다. 
    - 이 경우 밸류 타입인 도메인 모델을 (JPA에서 밸류 타입을 매핑할 때 사용하는) @Component가 아닌 (엔티티를 매핑할 때 사용하는) @Entity를 이용해야 할 수도 있다. 
- 애그리거트는 개념적으로 하나이므로 리포지터리라는 애그리거트 전체를 저장소에 영속화해야 한다.
  - 예) Order 애그리거트와 관련된 테이블이 세 개라면 리포지터리를 통해서 Order 애그리거트를 저장할 때 애그리거트 루트와 매핑되는 테이블뿐만 아니라 애그리거트에 속한 모든 구성요소를 위한 테이블에 데이터를 저장해야 한다. 
  ```java
  // 리포지터리에 애그리거트를 저장하면 애그리거트 전체를 영속화해야 한다.
  orderRepository.save(order);
  ``` 
- 동일하게 애그리거트를 구하는 리포지터리 메서드는 완전한 애그리거트를 제공해야 한다.
  ```java
  // 리포지터리는 완전한 order를 제공해야 한다.
  Order order = orderRepository.findById(orderId); 

  // order가 온전한 애그리거트가 아니면
  // 기능 실행 도중 NullPointerException과 같은 문제가 발생한다.
  order.cancel();
  ```   
  - 위 코드를 실행하면 order 애그리거트는 OrderLine, Orderer등 모든 구성요소를 포함하고 있어야 한다.
  - 리포지터리가 완전한 애그리거트를 제공하지 않으면, 필드나 값이 올바르지 않아 애그리거트의 기능을 실행하는 도중에 NullPointerException과 같은 문제가 발생하게 된다.
- 저장소로 마리아DB나 오라클과 같은 RDBMS뿐만 아니라 몽고DB, HBase 같은 NoSQL도 함께 사용하는 곳이 증가하고 있다. 
- 애그리거트를 영속화할 저장소로 무엇을 사용하든지 간에 애그리거트의 상태가 변경되면 모든 변경을 원자적으로 저장소에 반영해야 한다.
- 애그리거트에서 두 개의 객체를 변경했는데 저장소에는 한 객체에 대한 변경만 반영되면 데이터 일관성이 꺠지므로 문제가 된다.
  - RDBMS을 이용해서 리포지터리를 구현하면 트랜잭션을 이용해서 애그리거트의 변경이 저장소에 반영되는 것을 보장할 수 있다.
  - MongoDB를 사용하면 한 개 애그리거트를 한 개 문서에 저장함으로써 한 애그리거트의 변경을 손실 없이 저장소에 반영할 수 있다.
- RDBMS와 JPA를 이용한 리포지터리와 애그리거트의 구현에 대한 내용은 4장에서 살펴보자.

</details>

<details> <summary> 4. ID를 이용한 애그리거트 참조 </summary>

### 4. ID를 이용한 애그리거트 참조
- 한 객체가 다른 객체를 참조하는 것처럼 애그리거트도 다른 애그리거트를 참조한다.
- 애그리거트의 관리 주체가 애그리거트 루트이므로 애그리거트에서 다른 애그리거트를 참조한다는 것은 애그리거트의 루트를 참조한다는 것과 같다. 
- 애그리거트 간의 참조는 필드를 통해 쉽게 구현할 수 있다.
  - 예) 주문 애그리거트가 속해 있는 Orderer는 주문한 회원을 참조하기 위해 회원 애그리거트 루트인 Member를 필드로 참조할 수 있다. 
  ```java
  public class Order {
      private Orderer orderer;
      //...
  }

  public class Orderer {
      private Member member;
      //...
  }

  public class Member {
      //...
  }
  ``` 
- 필드를 이용해서 다른 애그리거트를 직접 참조하는 것은 개발자에게 구현의 편리함을 제공한다.
  - 예) 주문 정보 조회 화면에서 회원 아이디를 이용해서 링크를 제공해야 할때
  - `order.getOrderer().getMember().getId()` 처럼 Order로 시작해서 회원 아이디를 구할 수 있다.
  - JPA를 사용하면 @ManyToOne, @OneToOne과 같은 애노테이션을 이용해서 연관된 객체를 로딩하는 기능을 제공하고 있으므로 필드를 이용해서 다른 애그리거트를 쉽게 참조할 수 있다.
- ORM 기술 덕에 애그리거트 루트에 대한 참조를 쉽게 구현할 수 있고, 필드(또는 get메서드)를 이용한 애그리거트 참조를 사용하면 다른 애그리거트의 데이터를 객체 탐색을 통해 조회할 수 있다. 
- 하지만, 필드를 이용한 애그리거트 참조는 다음의 문제를 야기할 수 있다.
  - 편한 탐색 오용
  - 성능에 대한 고민
  - 확장 어려움

### 애그리거트 직접 참조 문제점 - 편한 탐색 오용
- 가장 큰 문제이다.
- 한 애그리거트 내부에서 다른 애그리거트 객체에 접근할 수 있으면 다른 애그리거트의 상태를 쉽게 변경할 수 있게 된다.
  - 트랜잭션 범위에서 언급한 것 처럼 한 애그리거트가 관리하는 범위는 자기 자신으로 한정 해야 한다.

**구현의 편리함 때문에 다른 애그리거트를 수정하고자 하는 유혹에 빠지기 쉽다**

```java
public class Order {
    private Orderer orderer;

    public void changeShippingInfo(ShippingInfo newShippingInfo, boolean useNewShippingAddrAsMemberAddr) {
        //...

        if(useNewShippingAddrAsMemberAddr) {
            // 한 애그리거트 내부에서 다른 애그리거트에 접근할 수 있다면,
            // 구현이 쉬워진다는 것 떄문에 다른 애그리거트의 상태를 변경하는 유혹에 빠지기 쉽다.
            orderer.getCustomer().changeAddress(newShippinrgInfo.getAddress());
        }
    }
}
```

- 애그리거트 내부에서 다른 애그리거트 객체에 접근할 수 있으면 위의 코드 처럼 구현의 편리함 때문에 다른 애그리거트를 수정하고자 하는 유혹에 빠지기 쉽다.
- 트랜잭션 범위에서 말한 것 처럼, 한 애그리거트에서 다른 애그리거트의 상태를 변경하는 것은 애그리거트 간의 의존 결합도를 높여서 결과적으로 애그리거트의 변경을 어렵게 만든다. 

### 애그리거트 직접 참조 문제점 - 성능에 대한 고민
- JPA를 사용할 경우 참조한 객체를 지연(lazy) 로딩과 즉시(eager)로딩의 두 가지 방식으로 로딩할 수 있다. 
- 두 로딩 방식 중 무엇을 사용할지 여부는 애그리거트의 어떤 기능을 사용하느냐에 따라 달라진다.
- 단순히 연관된 객체의 데이터를 함께 화면에 보여주어야 하면 즉시 로딩이 조회 성능에 유리하지만, 애그리거트의 상태를 변경하는 기능을 실행하는 경우에는 불필요한 객체를 함께 로딩할 필요가 없으므로 지연 로딩이 유리하다.
- 이런 다양한 경우의 수를 고려해서 연관 매핑과 JPQL/Criteria 쿼리의 로딩 전략을 결정해야 한다.
 

### 애그리거트 직접 참조 문제점 - 확장 어려움  
- 초기에는 단일 서버에 단일 DBMS로 서비스를 제공하는 것이 가능하다.
- 문제는 사용자가 몰리기 시작하면서 발생한다.
- 사용자가 늘고 트래픽이 증가하면서 자연스럽게 부하를 분산하기 위해 하위 도메인별로 시스템을 분리하기 시작한다.
  - 이 과정에서 하위 도메인마다 서로 다른 DBMS를 사용할 가능성이 높아진다.
  - 심지어 하위 도메인마다 다른 종류의 데이터 저장소를 사용하기도 한다.
  - 한 하위 도메인은 마리아DB를 사용하고 다른 하위 도메인은 몽고DB를 사용하는식으로 말이다.
  - 이는 더 이상 다른 애그리거트 루트를 참조하기 위해 JPA와 같은 단일 기술을 사용할 수 없음을 의미한다.


 ### ID를 이용한 애그리거트 참조
 - 위의 세가지 문제를 완화할 때 사용할 수 있는 방법
 ```java
 public class Order {
     private Orderer orderer;
     //...
 }

 public class Orderer {
     private MemberId memberId;
     private String name;
     //...
 }

 public class Member {
     private MemberId id;
 }
 ``` 
 - ID를 이용한 참조는 DB 테이블에서 외래키를 사용해서 참조하는 것과 비슷하게 다른 애그리거트를 참조할 때 ID 참조를 사용한다는 점이다. 
   - 단, 애그리거트 내의 엔티티를 참조할 때는 객체 래퍼런스로 참조한다.
 - ID 참조를 사용하면 모든 객체가 참조로 연결되지 않고 한 애그리거트에 속한 객체들만 참조로 연결된다.
   - 이는 애그리거트의 경계를 명확히 하고 애그리거트 간 물리적인 연결을 제거하기 때문에 모델의 복잡도를 낮춰준다.
   - 또한, 애그리거트 간의 의존을 제거하므로 응집도를 높여주는 효과도 있다.
 - 구현 복잡도가 낮아지는 장점이 있다.
   - 다른 애그리거트를 직접 참조하지 않으므로 애그리거트간 참졸르 지연 로딩으로 할지 즉시 로딩으로 할지 고민하지 않아도 된다. 
   - 참조하는 애그리거트가 필요하면 응용 서비스에서 아이디를 이용해서 로딩하면 된다.
   ```java
   public class ChangeOrderService {
       
       @Transactional
       public void changeShippingInfo(OrderId id, ShippingInfo newShippingInfo, boolean useNewShippingAddrAsMemberAddr) {
           Order order = orderRepository.findById(id);
           if(order == null) throw new OrderNotFoundException();
           order.changeShippingInfo(newShippingInfo);
           if(useNewShippingAddrAsMemberAddr) {
               // ID를 이용해서 참조하는 애그리거트를 구한다.
               Customer customer = customerRepository.findById(
                   order.getOrderer().getCustomerId());
               customer.changeAddress(newShippingInfo.getAddress());
           }
       }
   }
   ```
   - 응용 서비스에서 필요한 애그리거트를 로딩하므로 애그리거트 수준에서 지연 로딩을 하는 것 과 동일한 결과를 만든다.
- ID를 이용한 참조 방식을 사용하면 복잡도를 낮추는 것과 함께 한 애그리거트에서 다른 애그리거트를 수정하는 문제를 원천적으로 방지할 수 있다.
  - 외부 애그리거트를 직접 참조하지 않기 때문에 애초에 애그리거트에서 다른 애그리거트의 상태를 변경할 수 없는 것이다.
- 애그리거트별로 다른 구현 기술을 사용하는 것도 가능해진다.
  - 중요한 데이터인 주문 애그리거트는 RDBMS에 저장하고 조회 성능이 중요한 상품 애그리거트는 NoSQL에 저장할 수 있다. 
  - 또한, 각 도메인을 별도 프로세스로 서비스하도록 구현할 수도 있다.

### ID를 이용한 참조와 조회 성능
- 다른 애그리거트를 ID로 참조하면 참조하는 여러 애그리거트를 읽어야 할 때 조회 속도가 문제될 수 있다.
  - 예) 주문 목록을 보여주려면 상품 애그리거트와 회원 애그리거트를 함께 읽어야 하는데, 이를 처리할 때 다음과 같이 각 주문 마다 상품과 회원 애그리거틀르 읽어온다고 해보자.
  - 한 DBMS에 데이터가 있으면 조인을 이용해서 한 번에 모든 데이터를 가져올 수 있음에도 불구하고 주문마다 상품 정보를 읽어오는 쿼리를 실행하게 된다.
  ```java
  Customer customer = customerRepository.findById(ordererId);
  List<Order> orders = orderRepository.findByOrderer(ordererId);
  List<OrderView> dtos = orders.stream()
        .map(order -> {
            ProductId prodId = order.getOrderLines().get(0).getProductId();
            // 각 주문마다 첫 번째 주문 상품 정보 로딩을 위한 쿼리 실행
            Product product = productRepository.findById(prodId);
            return new OrderView(order, customer, product);
        }).collect(toList());
  ```   
  - 위 코드는 주문 개수가 10개면 주문을 읽어오기 위한 1번의 쿼리와 주문별로 각 상품을 읽어오기 위한 10번의 쿼리를 실행한다.
  - 조회 대상이 N개일 때 N개를 읽어오는 한 번의 쿼리와 연관된 데이터를 읽어오는 쿼리를 N번 실행한다 해서 이를 N + 1 조회 문제라고 부른다.
  - ID를 이용한 애그리거트 참조는 지연 로딩과 같은 효과를 만드는데 지연 로딩과 관련된 대표적인 문제가 N+1 조회 문제이다.
  - N+1 조회 문제는 더 많은 쿼리를 실행해서 전체 조회 속도가 느려지는 원인이 된다.
  - 이 문제가 빨생하지 않도록 하려면 조인을 사용하도록 해야 한다.
  - 조인을 사용하는 가장 쉬운 방법은 ID 참조 방식을 객체 참조 방식으로 바꾸고 즉시 로딩을 사용하도록 매핑 설정을 바꾸는 것이다.
  - 하지만, 이 방식은 애그리거트 간 참조를 ID참조 방식에서 객체 참조 방식으로 다시 되돌리는 것이다.
- ID 참조 방식을 사용하면서 N+1 조회와 같은 문제가 발생하지 않도록 하려면 전용 조회 쿼리를 사용하면 된다.
  - 예) 데이터 조회를 위한 별도 DAO를 만들고 DAO의 조회 메서드나 세타 조인을 이용해서 한 번의 쿼리로 필요한 데이터를 로딩하면 된다. 
  ```java
  @Repository
  public class JpaOrderViewDao implements OrderViewDao {
      @PersistenceContext
      private EntityManager em;

      @Override
      public List<OrderView> selectByOrderer(String ordererId) {
          String selectQuery =
          "select new com.myshop.order.application.dto.OrderView(o,m,p) "+
          "from Order o join o.orderLines ol, Member m, Product p " +
          "where o.orderer.memberId.id = :ordererId "+
          "and o.orderer.memberId = m.id " +
          "and index(ol) = Θ " +
          "and ol.productId = p.id " +
          "order by o.number.number desc";
          TypedQuery<OrderView> query = em.createQuery(selectQuery, OrderView.class);
          query.setParameter("ordererId", ordererId);
          return query.getResultList();
      }
  }
  ``` 
  - 위 코드는 JPA를 이용해서 특정 사용자의 주문 내역을 보여주기 위한 코드이다.
  - 이 코드는 JPQL을 사용하는데, 이 JPQL은 Order 애그리거트와 Member 애그리거트, 그리고 Product 애그리거트를 세타 조인으로 조회해서 한 번의 쿼리로 로딩한다.
  - 즉시 로딩이나 지연로딩과 같은 로딩 전략을 고민할 필요 없이 조회 화면에서 필요한 애그리거트 데이터를 한번의 쿼리로 로딩할 수 있다.
  - 쿼리가 복잡하거나 SQL에 특화된 기능을 사용해야 한다면 조회를 위한 부분만 MyBatis와 같은 기술을 이용해서 실행할 수도 있다. 
- 애그리거트마다 서로 다른 저장소를 사용하는 경우에는 한 번의 쿼리로 관련 애그리거트를 조회할 수 없다.
  - 이런 경우 조회 성능을 높이기 위해 캐시를 적용하거나 조회 전용 저장소를 따로 구성한다.
  - 이 방법은 코드가 복잡해지는 단점이 있지만 시스템의 처리량을 높일 수 있다는 장점이 있다.
  - 특히 한 대의 DB 장비로 대응할 수 없는 수준의 트래픽이 발생하는 경우 캐시나 조회 전용 저장소는 필수로 선택해야 하는 기법이다.
- JPA에서 조회 전용 쿼리를 실행하는 방법은 5장에서 설명한다. 
- 11장에서는 CQRS에 대해 다루는데 이 장에서는 명령 모델과 조회 전용 모델을 분리해서 구현하는 패턴에 대해 살펴본다. 

</details>


<details> <summary> 5. 애그리거트 간 집합 연관 </summary>

## 5. 애그리거트 간 집합 연관


- 애리트거트 간 1:N과 N:M 연관에 대해서 알아보자.
  - 컬렉션을 이용한 연관이다.
  - 예) 카테고리와 상품 간의 연관이 대표적이다.


### 1:N 
- 카테고리 입장에서 한 카테고리에 한 개 이상의 상품이 속할 수 있으니 카테고리와 상품은 1:N 관계이다.
- 한 상품이 한 카테고리에만 속할 수 있다면 상품과 카테고리 관계는 N:1 관계이다.
- 애그리거트 간 1:N 관계는 Set과 같은 컬렉션을 이용해서 표현할 수 있다. 
- 예) Category가 연관된 Product들 값으로 갖는 컬렉션 필드로 정의
```java
public class Category {
  private Set<Product> products; // 다른 애그리거트에 대한 1:N 연관 
}
``` 
- 개념적으로 존재하는 애그리거트 간의 1:N 연관을 실제 구현에 반영하는것이 요구사항을 충족하는 것과 상관없는 경우가 종종 있다.
- 예) 특정 카테고리에 있는 상품 목록을 보여주는 요구사항
- 보통 목록 관련 요구사항은 한 번에 전체 상품을 보여주기보다는 페이징을 이용해서 제품을 나눠서 보여준다.
- 이 기능을 카테고리 입장에서 1:N 연관을 이용해서 구현하면 아래와 같은 코드가 나온다.
```java
public class Category {
  private Set<Product> products;
  
  public List<Product> getProducts(int page, int size) {
    List<Product> sortedProducts = sortById(products);
    return sortedProducts.subList((page - 1) * size, page * size);
  }
}
``` 
- 이 코드를 실제 DBMS와 연동해서 구현하면 Category에 속한 모든 Product를 조회하게 된다.
- Product 개수가 수백에서 수만 개 정도로 많다면 이 코드를 실행할 때마다 실행 속도가 급격히 느려져 성능에 심각한 문제를 일으킬 것이다.
- 개념적으로는 애그리거트 간에 1:N 연관이 있더라도 이런 성능상의 문제 때문에 애그리거트 간의 1:N연관을 실제 구현에 반영하는 경우는 드물다. 
- 카테고리에 속한 상품을 구할 필요가 있다면 상품 입장에서 자신이 속한 카테고리를 N:1로 연관지어 구하면 된다.
- 이를 구현 모델에 반영하면 Product에 다음 코드와 같이 Category로의 연관을 추가하고 그 연관을 이용해서 특정 Category에 속한 Product목록을 구하면 된다.
```java
public class Product {
  //...
  private CategoryId category;
  //...
}
```
- 카테고리에 속한 상품 목록을 제공하는 응용 서비스는 다음과 같이 ProductRepository를 이용해서 categoryId가 지정한 카테고리 식별자인 Product 목록을 구한다. 
    
```java
public class ProductListService {

  public Page<Product> getProductOfCategory(Long categoryId, int page, int size) {
    Category category = categoryRepository.findById(categoryId);
    checkCategory(category);
    List<Product> products = productRepository.findByCategoryId(category.getId(), page, size);
    int totalCount = productRepository.countsByCategoryId(category.getId());
    return new Page(page, size, totalCount, products);
  }
}
```

### M:N
- M:N 연관은 개념적으로 양쪽 애그리거트에 컬렉션으로 연관을 만든다.
  - 예) 상품이 여러 카테고리에 속할 수 있을경우
  - 카테고리:상품 = M:N
- 앞서 1:N 연관 처럼 M:N 연관도 실제 요구사항을 고려해서 M:N 연관을 구현에 포함 시킬지 여부를 결정해야 한다. 
  - 보통 특정 카테고리에 속한 상품 목록을 보여줄 때 목록 화면에서 각 상품이 속한 모든 카테고리를 상품 정보에 표시하지는 않는다.
  - 제품이 속한 모든 카테고리가 필요한 화면은 상품 상세 화면이다.
  - 이 요구사항을 고려할 때 카테고리에서 상품으로의 집합 연관은 필요하지 않다.
  ```java
  public class Product

  private Set<CategoryId> categoryIds;
  ``` 
  - 위와 같이 상품에서 카테고리로의 집합 연관만 존재하면 된다.
  - 즉, 개념적으로 상품과 카테고리의 양방향 M:N 연관이 존재하지만 실제 구현에서는 상품에서 카테고리로의 단방향 M:N 연관만 적용하면 되는 것이다.
- RDBMS를 이용해서 M:N 연관을 구현하려면 조인 테이블을 사용한다.
  ![image](https://user-images.githubusercontent.com/28394879/135053480-e22f47eb-1565-4849-891b-eb553d583f46.png)
  - 상품과 카테고리의 M:N 연관을 위와 같이 조인 테이블을 이용해서 구한다.
- JPA를 이용하면 다음과 같은 매핑 설정을 사용해서 ID 참조를 이용한 M:N 단방향 연관을 구현 할 수 있다.
  ```java
  @Entity
  @Table(name = "product")
  public class Product {
    @EmbeddedId
    private ProductId id;
    
    @ElementCollection
    @CollectionTable(name = "product_category",
      joinColumns = @JoinColumn(name = "product_id"))
    private Set<CategoryId> categoryIds;
  }
  ```
  - 이 매핑은 카테고리 ID 목록을 보관하기 위해 밸류 타입에 대한 컬렉션 매핑을 이용했다.
  - 이 매핑을 사용하면 다음과 같이 JPQL의 member of 연산자를 이용해서 특정 Category에 속한 Product 목록을 구하는 기능을 구현할 수 있다.
  ```java
  @Repository
  public class JpaProductRepository implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findByCategoryId(CategoryId categoryId, int page, int size) {
      TypedQuery<Product> query = entityManager.createQuery(
        "select p from Product p "+
        "where :catId member of p.categoryIds order by p.id.id desc",
        Product.class);
      query.setParameter("catId", categoryId);
      query.setFirstResult((page -1 ) * size);
      query.setMaxResult(size);
      return query.getResultList();
    }
  }
  ```
  - 이 코드에서 ':catId member of p.categoryIds'는 categoryIds 컬렉션에 catId로 지정한 값이 존재하는지 여부를 검사하기 위한 검색 조건이다.
  - 응용 서비스는 이 기능을 사용해서 지정한 카테고리에 속한 Product목록을 구할 수 있다.
  - JPA를 이용한 모델 매핑에 대한 내용과 컬렉션을 사용할 떄의 성능 관련 문제에 대한 내용은 4장에서 더 자세히 살펴볼 것이다.
 


</details>

<details> <summary> 6. 애그리거트를 팩토리로 사용하기 </summary>

## 6. 애그리거트를 팩토리로 사용하기
- 예) 온라인 쇼핑몰에서 고객이 여러 차례 신고를 해서 특정 상점이 더 이상 물건을 등록하지 못하도록 차단한 상태일때

### 응용 서비스에서 도메인 로직 처리
- 상품 등록 기능을 구현한 응용 서비스는 다음과 같이 상점 계정이 차단 상태가 아닌 경우에만 상품을 생성하도록 구현할 수 있다.
```java
public class RegisterProductService {
  
  public ProductId registerNewProduct(NewProductRequest req) {
    Store account = accountRepository.findStoreById(req.getStoreId());
    checkNull(account);
    if (account.isBlobked()) {
      throw new StoreBlockedException();
    }
    ProductId id = productRepository.nextId();
    Product product = new Product(id, account.getId(), ...생략.);
    productRepository.save(product);
    return id;
  }
  //...
}
``` 
- 이 코드는 Product를 생성 가능한지 판단하는 코드와 Product를 생성하는 코드가 분리되어 있다.
- 코드가 나빠 보이지는 않지만 중요한 도메인 로직 처리가 응용 서비스에 노출되었다.
- Store가 Product를 생성할 수 있는지 여부를 판단하고 Product를 생성하는 것은 논리적으로 하나의 도메인 기능인데 이 도메인 기능을 응용 서비스에서 구현하고 있는 것이다.
- 이 도메인 기능을 넣기 위한 별도의 도메인 서비스나 팩토리 클래스를 만들 수도 있지만 이 기능을 구현하기에 더 좋은 장소는 Store 애그리거트이다.
- Product를 생성하는 기능을 Store 애그리거트에 다음과 같이 옮겨보자.

### Store 애그리거트에서 도메인 로직 처리
```java
public class Store extends Member {
  
  public Product createProduct(ProductId newProductId, ...생략) {
    if(isBlocked()) throw new StoreBlockedException();
    return new Product(newProductId, getId(), ...생략);
  }
}
``` 
- Store 애그리거트의 createProduct()는 Product 애그리거트를 생성하는 팩토리 역할을 한다.
- 팩토리 역할을 하면서도 중요한 도메인 로직을 구현하고 있다. 
- 팩토리 기능을 구현했으므로 이제 응용 서비스는 팩토리 기능을 이용해서 Product를 생성하면 된다.
```java
public class RegisterProductService {
  
  public ProductId registerNewProduct(NewProductRequest req) {
    Store account = accountRepository.findStoreById(req.getStoreId());
    checkNull(account);
    ProductId id = productRepository.nextId();
    Product product = account.createProduct(id, ...생략);
    productRepository.save(product);
    return id;
  }
}
``` 
- 응용 서비스에서 도메인 로직 처리한 방법과의 차이점이라면 응용 서비스에서 더 이상 Store의 상태를 확인하지 않는다는 것이다. 
- Store가 Product를 생성할 수 있는지 여부를 확인하는 도메인 로직은 Store에서 구현하고 있다.
- 이제 Product 생성 가능 여부를 확인하는 도메인 로직을 변경해도 도메인 영역의 Store만 변경하면 되고 응용 서비스는 영향을 받지 않는다.
- 도메인의 응집도도 높아졌다.
- 이게 바로 애그리거트를 팩토리로 사용할 때 얻을 수 있는 장점이다.

### 애그리거트 팩토리
- 애그리거트가 갖고 있는 데이터를 이용해서 다른 애그리거트를 생성해야 한다면 애그리거트에 팩토리 메서드를 구현하는 것을 고려해보자.
- Store에 Product를 생성하는 팩토리 메서드를 추가하면 Product를 생성할 때 필요한 데이터의 일부를 직접 제공하면서 동시에 중요한 도메인 로직을 함께 구현할 수 있게 된다.  
  - Product의 경우 제품을 생성한 Store의 식별자를 필요로 한다.
  - 즉, Store의 데이터를 이용해서 Product를 생성한다.
  - 게다가 Product를 생성할 수 있는 조건을 판단할때 Store의 상태를 이용한다.

</details>




# 4. 리포지터리와 모델구현(JPA중심)

<details> <summary> 1. JPA를 이용한 리포지터리 구현 </summary>

## 1. JPA를 이용한 리포지터리 구현

- 애그리거트를 어떤 저장소에 저장하느냐에 따라 리포지터리를 구현하는 방법이 다르기 때문에 모든 구현 기술에 대해 알아볼 수는 없다.
- 도메인 모델과 리포지터리를 구현할 때 선호하는 기술을 꼽으면 JPA이다.
  - 데이터 보관소로 RDBMS를 사용할 때 객체 기반의 도메인 모델과 관계형 데이터 모델 간의 매핑을 처리하는 기술로 ORM 만한 것이 없다.

### 모듈 위치

**DIP에 따라 리포지터리 구현 클래스는 인프라스트럭처 영역에 위치한다.**

![image](https://user-images.githubusercontent.com/28394879/135188186-9fcf66d4-601c-44ce-85fe-94839b3b84ee.png)
- 2장에서 언급한 것처럼 리포지터리 인터페이스는 애그리거트와 같이 도메인 영역에 속하고, 리포지터리를 구현한 클래스는 인프라스트럭처 영역에 속한다.
- 즉, 각 타입의 패키지 구성은 위의 그림과 같다. 
- 팀 표준에 따라 리포지터리 구현 클래스를 domain.impl과 같은 패키지에 위치시키는 경우도 있다. 
  - 이는 리포지터리 인터페이스와 구현체를 분리하기 위한 타협안 같은 것이지 좋은 설계 원칙을 따르는 것은 아니다.
  - 가능하면 리포지터리 구현 클래스를 인프라스트럭처 영역에 위치시켜서 인프라스트럭처에 대한 의존을 낮춰야 한다.

### 리포지터리 기본 기능 구현
- 기본 기능
  - 아이디로 애그리거트 조회
  - 애그리거트 저장
- 기본 기능 인터페이스 
  ```java
  public interface OrderRepository {
    public Order findById(OrderNo no);
    public void save(Order order);
  }
  ```   
- 인터페이스는 애그리거트 루트를 기준으로 작성한다.
  - 주문 애그리거트는 Order 루트 엔티티를 비롯해 OrderLine, Orderer, ShippingInfo 등 다양한 객체를 포함하는데, 이 구성요소 중에서 Order 루트 엔티티를 기준으로 리포지터리 인터페이스를 작성한다.
- 애그리거트를 조회하는 기능의 이름을 지을 때 특별한 규칙은 없지만 널리 사용되는 규칙은 findBy 프로퍼티(프로퍼티 값)의 형식을 사용하는 것이다.
  - 위 인터페이스의 경우 아이디로 애그리거트를 조회하는 메서드의 이름을 findById()로 지정하였다.
  - findById()는 아이디에 해당하는 애그리거트가 존재하면 Order를 리턴하고, 존재하지 않으면 null을 리턴한다.
  - null을 사용하고 싶지 않다면 자바8의 Optional을 이용해서 값을 리턴해도 된다.
- save() 메서드는 전달받은 애그리거트를 저장한다.
  - 이 인터페이스를 구현한 클래스는 JPA의 EntityManager를 이용해서 구현한다. 
  - 스프링 프레임워크에 기반한 리포지터리 구현 클래스는 다음과 같다.
  ```java
  @Repository
  public class JpaOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order findById(OrderNo id) {
      return entityManager.find(Order.class, id);
    }

    @Override
    public void save(Order order) {
      entityManager.persist(order);
    }
  }
  ``` 
- 애그리거트를 수정한 결과를 저장소에 반영하는 메서드를 추가할 필요는 없다. 
  - JPA를 사용하면 트랜잭션 범위에서 변경한 데이터를 자동으로 DB에 반영하기 떄문이다.
  ```java
  public class ChangeOrderService {
    @Transactional
    public void changeShippingInfo(Orderno no, ShippingInfo newShippingInfo) {
      Order order = orderRepository.findById(no);
      if (order == null) throw new OrderNotFoundException();
      order.changeShippingInfo(newShippingInfo);
    }
  }
  ``` 
  - 이 코드에서 changeShippingInfo() 메서드는 스프링 프레임워크의 트랜잭션 관리 기능을 통해 트랜잭션 범위에서 실행된다.
  - 메서드 실행이 끝나면 트랜잭션을 커밋하는데, 이때 JPA는 트랜잭션 범위에서 변경된 객체의 데이터를 DB에 반영하기 위해 UPDATE 쿼리를 실행한다.
  - order.changeShippingInfo() 메서드의 실행 결과로 애그리거트 내부의 객체가 변경되면 JPA는 변경 데이터를 DB에 반영하기 위해 UPDATE쿼리를 실행한다.
- 아이디가 아닌 다른 조건으로 애그리거트를 조회해야 하는 경우 findBy 뒤에 조건 대상이 되는 프러퍼티 이름을 붙인다. 
  - 예) 특정 아이디가 주문한 Order 목록을 구하는 메서드
  ```java
  public interface OrderRepository {
    //...
    public List<Order> findByOrdererId(String ordererId, int startRow, int size);
  }
  ```  
  - findByOrdererId 메서드는 한 개 이상 Order 객체를 리턴할 수 있으므로 컬렉션 타입 중 하나인 List를 리턴 타입으로 사용했다.
  - 아이디 외에 다른 조건으로 애그리거트를 조회할 때에는 JPA의 Criteria나 JPQL을 사용한다.
  - JPQL을 이용한 findByOrdererId() 메서드
  ```java
  @Override
  public List<Order> findByOrdererId(String ordererId, int startRow, int fetchSize) {
    TypedQuery<Order> query = entityManager.createQuery(
      "select o from Order o " +
      "where o.orderer.memberId.id = :ordererId "+
      "order by o.number.number desc",
      Order.class);
      query.setParameter("ordererId", ordererId);
      query.setFirstResult(startRow);
      query.setMaxResults(fetchSize);
      return query.getResultList();
  }
  ```  
- 애그리거트를 삭제하는 기능
  ```java
  public interface OrderRepository {
    //...
    public void delete(Order order);
  }
  ```   
  - 삭제 기능을 위한 메서드는 삭제할 애그리거트 객체를 파라미터로 전달받는다.
  - JPA를 이용한 리포지터리 삭제 기능 구현
  ```java
  public class JpaOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;
    //...
    @Override
    public void remove(Order order) {
      entityManager.remove(order);
    }
  }
  ```  


> 삭제 요구사항이 있더라도 여러 이유로 데이터를 실제로 삭제하는 경우는 많지 않다.
> 관리자 기능에서 삭제한 데이터까지 조회해야 하는 경우도 있고 데이터 원복을 위해 일정 기간 동안 보관해야 할 때도 있기 때문이다.
> 이런 이유로 사용자가 삭제 기능을 실행할 때 데이터를 바로 삭제하기보다는 삭제 플래그를 사용해서 데이터를 화면에 보여줄지 여부를 결정하는 방식으로 구현한다.




  

</details>

<details> <summary> 2. 매핑 구현 </summary>

## 2. 매핑 구현

### 엔티티와 밸류 기본 매핑 구현
- 애그리거트와 JPA 매핑을 위한 기본 규칙
  - 애그리거트 루트는 엔티티이므로 @Entity로 매핑 설정
  - 한 테이블에 엔티티와 밸류 데이터가 같이 있다면
    - 밸류는 @Embeddable로 매핑 설정
    - 밸류 타입 프로퍼티는 @Embedded로 매핑 설정
- 예) 주문 애그리거트
  - ![image](https://user-images.githubusercontent.com/28394879/135196129-f15162a0-9038-41c3-b00e-ba002f6529d0.png)
  - 주문 애그리거트의 루트 엔티티는 Order이고 이 애그리거트에 속한 Orderer와 ShippingInfo는 밸류인데, 이 객체와 ShippingInfo에 포함된 Address 객체와 Receiver객체는 한 테이블에 매핑할 수 있다. 
  - 루트 엔티티와 루트 엔티티에 속한 밸류는 한 테이블에 매핑될 떄가 많다. 
  - 주문 애그리거트의 루트 엔티티인 Order는 JPA의 @Entity로 매핑한다.
  ```java
  @Entity
  @Table(name = "purchase_order")
  public class Order {
    //...
  }
  ``` 
  - Order에 속하는 Orderer는 밸류이므로 @Embeddable로 매핑한다.
  ```java
  @Embeddable
  public class Orderer {
    // MemberId에 정의된 컬럼 이름을 변경하기 위해
    // @AttributeOverride 애노테이션 사용
    @Embedded
    @AttributeOverrides (
      @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;
  }
  ``` 
  - Orderer의 memberId는 Member 애그리거트를 ID로 참조한다.
  - Member의 아이디타입으로 사용되는 MemberId는 다음과 같이 id 프로퍼티와 매핑되는 테이블 칼럼 이름으로 "member_id"를 지정하고 있다.
  ```java
  @Embeddable
  public class MemberId implements Serializable {
    @Column(name= "member_id")
    private String id;                             
  }
  ``` 
  - 예시의 그림에서 Orderer의 memberId 프롶퍼티와 매핑되는 칼럼 이름은 'orderer_id' 이므로 MemberId에 설정된 'member_id' 와 이름을 다르게 했다.
  - @Embeddable 타입에 설정한 칼럼 이름과 실제 칼럼 이름이 다르므로 Orderer의 memberId 프로퍼티를 매핑할 때 @AttributeOverrides 애노테이션을 이용해서 매핑할 칼럼 이름을 변경 했다.
- JPA 2부터 @Embeddable은 중첩을 허용하므로 밸류인 Orderer가 또 다른 밸류인 MemberId를 포함할 수 있다.
  - Orderer와 마찬가지로 ShipppingInfo 밸류도 또 다른 밸류인 Address와 Receiver를 포함한다.
  - Address의 매핑 설정과 다른 칼럼 이름을 위해 @AttributeOverride 애노테이션을 사용한다.
  ```java
  @Embeddable
  public class ShippingInfo {
    @Embedded
    @AttributeOverrides{(
      @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zipcode")),
      @AttributeOverride(name = "address1", column = @Column(name = "shipping_addr1")),
      @AttributeOverride(name = "address2", column = @Column(name = "shipping_addr1"))
    )}
    private Address address;

    @Column(name = "shipping_message")
    private String message;

    @Embedded
    private Receiver receiver;
  }
  ``` 
  - Order 애그리거트 루트 엔티티는 @Embedded를 이용해서 밸류 타입 프로퍼티를 설정한다.
  ```java
  @Entity
  public class Order {
    //...
    @Embedded
    private Orderer orderer;
    
    @Embedded
    private ShippingInfo shippingInfo;
  }
  ``` 


### 기본 생성자 
- 엔티티와 밸류의 생성자는 객체를 생성할 때 필요한 것을 전달 받는다.
- Receiver 밸류 타입의 경우 생성 시점에 수취인 이름과 연락처를 생성자로 파라미터로 전달 받는다.
  ```java
  public class Receiver {
    private String name;
    private String phone;
    
    public Receiver(String name, String phone) {
      this.name = name;
      this.phone = phone;
    }
  }
  //...
  ```  
  - Receiver가 불변타입이면 생성 시점에 필요한 값을 모두 전달받으므로 값을 변경하는 set메서드를 제공하지 않는다.
  - 이는 Receiver 클래스에 (파라미터가 없는) 기본 생성자를 추가할 필요가 없다는 것을 뜻한다.
  - 하지만 JPA의 @Entity와 @Embeddable로 클래스를 매핑하려면 기본 생성자를 제공해야 한다.
  - 하이버네이트와 같은 JPA 프로바이더는 DB에서 데이터를 읽어와 매핑된 객체를 생성할 떄 기본 생성자를 사용해서 객체를 생성한다.
  - 이런 기술적인 제약으로 Receiver와 같은 불변 타입은 기본 생성자가 필요 없음에도 불구하고 기본 생성자를 추가하되, protected로 추가한다.
  ```java
  @Embeddable
  public class Receiver {
    @Column(name = "receiver_name")
    private String name;
    @Column(name = "receiver_phone")
    private String phone;

    protected Receiver() {} // JPA를 적용하기 위해 기본 생성자 추가 

    public Receiver(String name, String phone) {
      this.name = name;
      this.phone = phone;
    }
    ..// get 메서드 생략 
  }
  ``` 
  - 기본 생성자는 JPA 프로바이더가 객체를 생성할 때만 사용한다.
  - 기본 생성자를 다른 코드에서 사용하면 값이 없는 온전하지 못한 객체를 만들게 된다.
  - 이런 이유로 다른 코드에서 기본 생성자를 사용하지 못하도록 protected로 선언한다. 

> 하이버네이트는 클래스를 상속한 프록시 객체를 이용해서 지연 로딩을 구현한다.
> 이 경우 프록시 클래스에서 상위 클래스의 기본 생성자를 호출할 수 있어야 하므로 지연 로딩
> 대상이 되는 @Entity와 @Embeddable의 기본 생성자는 private가 아닌 protected로 지정해야 한다.

### 필드 접근 방식 사용 
- JPA는 필드와 메서드의 두 가지 방식으로 매핑을 처리할 수 있다. 
- 메서드 방식을 사용하려면 다음과 같이 프로퍼티를 위한 get/set 메서드를 구현해야 한다.
```java
@Entity
@Access(AccessType.PROPERTY)
public class Order {
  
  @Column(name = "state")
  @Enumerate(EnumType.STRING) 
  public OrderState getState() {
    return state;
  }

  public void setState(OrderState state) {
    this.state = state;
  }
}
``` 
- 엔티티에 프로퍼티를 위한 공개 get/set 메서드를 추가하면 도메인의 의도가 사라지고 객체가 아닌 데이터 기반으로 엔티티를 구현할 가능성이 높아진다.
  - 특히 set 메서드는 내부 데이터를 외부에서 변경할 수 있는 수단이 되기 떄문에 캡슐화를 깨는 원인이 될 수 있다.

- 엔티티가 객체로서 제 역할을 하려면 외부에 set 메서드 대신 의도가 잘 드러나는 기능을 제공해야 한다.
  - 상태 변경을 위한 setState() 메서드보다 주문 취소를 위한 cancel() 메서드가 도메인을 더 잘 표현하고, setShippingInfo() 메서드보다 배송지를 변경한다는 의미를 갖는 changeShippingInfo()가 도메인을 잘 표현한다.
- 밸류 타입을 불변으로 구현하고 싶은 경우 set 메서드 자체가 필요 없는데 JPA의 구현 방식 때문에 공개 set 메서드를 추가하는 것도 좋지 않다.
- 엔티티를 객체가 제공할 기능 중심으로 구현하도록 유도하려면 JPA 매핑 처리를 프로퍼티 방식이 아닌 필드 방식으로 선택해서 불필요한 get/set 메서드를 구현하지 말아야 한다.
  ```java
  @Entity
  @Access(AccessType.FIELD)
  public class Order {
    @EmbeddedId
    private OrderNo number;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private OrderState state;

    ... // cancel(), changeShippingInfo() 등 도메인 기능 구현
    ... // 필요한 get 메서드 제공 
  }
  ``` 

> JPA 구현체인 하이버네이트는 @Accesss를 이용해서 명시적으로 접근 방식을 지정하지 않으면
> @Id나 @EmbeddedId가 어디에 위치했느냐에 따라 접근 방식을 결정한다.
> @Id나 @EmbeddedId가 필드에 위치하면 필드 접근 방식을 선택하고, get메서드에 위치하면 메서드 접근 방식을 선택한다. 

### AttributeConverter를 이용한 밸류 매핑 처리
- int, long, String, LocalDate와 같은 타입은 DB 테이블의 한 개 칼럼과 매핑된다.
  - 이와 비슷하게 밸류 타입의 프로퍼리르 한 개 칼럼에 매핑해야 할 때도 있다.
  - 예) Length가 길이 값과 단위의 두 프로퍼티를 갖고 있는데 DB 테이블에는 한 개 칼럼에 '1000mm' 와 같은 형식으로 저장할 수 있다.
  ```java
  // 두 프로퍼티로 나누어서 저장 
  public class Length {
    private int value;
    private String unit;
  }

  // 한개 DB 칼럼에 저장 = WIDTH VARCHAR(20)
  ``` 
- 두 개 이상의 프로퍼티를 가진 밸류 타입을 한 개 칼럼에 매핑해야 할 경우 @Embeddable로는 처리할 수 없다.
  - JPA 2.0 버전에서는 이를 처리하기 위해 다음과 같이 칼럼과 매핑하기 위한 프로퍼티를 따로 추가하고 get/set 메서드에서 실제 밸류 타입과 변환 처리를 해야 한다.
  ```java
  public class Product {
    @Column(name = "WIDTH")
    private String width;

    public Length getWidth() {
      return new Width(width); // DB 칼럼 값을 실제 프로퍼티 타입으로 변환
    }

    void setWidth(Length width) {
      this.width = width.toString(); // 실제 프로퍼티 타입을 DB 타입 값으로 변환 
    }
  }
  ``` 

  - JPA 2.1 버전에서는 DB 칼럼과 밸류 사이의 변환 코드를 모델에 구현하지 않아도 된다.
  - 대신 AttributeConverter를 사용해서 변환을 처리할 수 있다.
  - AttributeConverter는 JPA 2.1 에 추가된 인터페이스로 다음과 같이 밸류 타입과 칼럼 데이터 간의 변환 처리를 위한 기능을 정의하고 있다.
  ```java
  package javax.persistence;

  public interface AttributeConverter<X,Y> {
    public Y convertToDatabaseColumn(X attribute);
    public X convertToEntityAttribute(Y dbData);
  }
  ``` 
  - 타입 파라미터 X는 밸류 타입이고, Y는 DB 타입이다. 
  - convertToDatabaseColumn() 메서드는 밸류 타입을 DB 칼럼 값으로 변환하는 기능을 구현하고 convertToEntityAttribute() 메서드는 DB 칼럼 값을 밸류로 변환하는 기능을 구현한다.
  - Money 밸류 타입을 위한 AttributeConverter는 다음과 같이 구현할 수 있다.
  ```java
  @Converter(autoApply = true)
  public class MoneyConverter implements AttributeConverter<Money, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Money money) {
      if (money == null)
        return null;
      else
        return money.getValue();
    }

    @Override
    public Money convertToEntityAttribute(Integer value) {
      if(value == null) return null;
      else return new Money(value);
    }
    
  }
  ``` 
  - AttributeConverter 인터페이스를 구현한 클래스는 @Converter 애노테이션을 적용한다.
  - `@Converter(autoApply = true)`는 모델에 출현하는 모든 Money 타입의 프로퍼티에 대해서 MoneyConverter를 자동으로 적용한다.
  - 예) Order의 totalAmounts 프로퍼티는 Money타입인데 이 프로퍼티를 DB total_amounts 칼럼에 매필할 때 MoneyConverter를 사용한다.
  ```java
  @Entity
  @Table(name = "purchase_order")
  public class Order {
    //...

    @Column(name = "total_amounts")
    private Money totalAmounts; // MoneyConverter를 적용해서 값 반환 
    //...
  }
  ```
  - `@Converter(autoApply = false)`는 기본값인데, 프로퍼티 값을 변환할 때 사용할 컨버터를 직접 지정해야 사용할 수 있다. 
  ```java
  public class Order {
    @Column(name = "total_amounts")
    @Convert(converter = MoneyConverter.class)
    private Money totalAmounts;
  }
  ``` 

### 밸류 컬렉션: 별도 테이블 매핑
- Order 엔티티는 한 개 이상의 OrderLine을 가질 수 있다.
- OrderLine의 순서가 있다면 다음과 같이 List 타입을 이용해서 OrderLine 타입의 컬렉션을 프로퍼티로 갖게된다.
```java
public class Order {
  
  private List<OrderLine> orderLines;
  //...
}
``` 
- 밸류 타입의 컬렉션은 별도 테이블에 보관한다. Order와 OrderLine을 위한 테이블은 다음과 같이 매핑할 수 있다. 
  ![image](https://user-images.githubusercontent.com/28394879/135231195-7dc4888c-ee67-4489-a9a1-9a2c997a1ff9.png)
  - 밸류 컬렉션을 저장하는 ORDER_LINE 테이블은 외부키를 이용해서 엔티티에 해당하는 PURCHASE_ORDER 테이블을 참조한다.
  - 이 외부키는 컬렉션이 속할 엔티티를 의미한다.
  - List 타입의 컬렉션은 인덱스 값이 필요하므로 ORDER_LINE 테이블에는 인덱스 값을 저장하기 위한 칼럼(line_idx)도 존재한다.
- 밸류 컬렉션을 별도 테이블로 매핑할 때는 @ElementCollection과 @CollectionTable을 함께 사용한다. 관련 매핑 코드는 다음과 같다. 
```java
@Entity
@Table(name = "purchase_order")
public class Order {
  //...
  @ElementCollection
  @CollectionTable(name = "order_line", 
    joinColumns = @JoinColumn(name = "order_number"))
  @OrderColumn(name = "line_idx")
  private List<OrderLine> orderLines;
  ...
}

@Embeddable
public class OrderLine {
  @Embedded
  private ProductId productId;
  
  @Column(name = "price")
  private Money price;

  @Column(name = "quantity")
  private int quantity;
  
  @Column(name = "amounts")
  private Money amounts;

  ... 
}
``` 
- OrderLine의 매핑을 함께 표시했는데 OrderLine에는 List의 인덱스 값을 저장하기 위한 프로퍼티가 존재하지 않는다.
  - 그 이유는 List 타입 자체가 인덱스를 갖고 있기 때문이다.
  - JPA는 @OrderColumn 애노테이션을 이용해서 저장한 칼럼에 리스트의 인덱스 값을 저장한다.
- @CollectionTable은 밸류를 저장할 테이블을 지정할 때 사용한다. 
  - name 속성으로 테이블 이름을 지정하고 joinColumns 속성은 외부키로 사용하는 칼럼을 지정한다.
  - 예제 코드에서는 외부키가 한 개인데, 두 개 이상인 경우 @JoinColumn의 배열을 이용해서 외부키 목록을 지정한다.

### 밸류 컬렉션: 한 개 컬럼 매핑
- 밸류 컬렉션을 별도 테이블이 아닌 한 개 컬럼에 저장해야 할 때가 있다.
  - 예) 도메인 모델에는 이메일 주소 목록을 Set으로 보관하고 DB에는 한 개 컬럼에 콤마로 구분해서 저장해야 할 때가 있다. 
  - 이때 AttributeConverter를 사용하면 밸류 컬렉션을 한 개 컬럼에 쉽게 매핑할 수 있다. 
  - 단, AttributeConverter를 사용하려면 밸류 컬렉션을 표현하는 새로운 밸류 타입을 추가해야 한다. 
  - 이메일의 경우 아래 코드 처럼 이메일 집합을 위한 밸류 타입을 추가로 작성해야 한다.
  ```java
  public class EmailSet {
    private Set<Email> emails = new HashSet<>();

    private EmailSet() {}
    private EmailSet(Set<Email> emails) {
      this.email.addAll(emails);
    }

    public set<Email> getEmails() {
      return Collections.unmodifiableSet(emails);
    }
  }
  ``` 
  - 밸류 컬렉션을 위한 타입을 추가했다면 AttributeConverter를 구현한다.
  ```java
  @Converter
  public class EmailSetConverter implements AttributeConverter<EmailSet, String> {
    @Override
    public String convertToDatabaseColumn(EmailSet attribute) {
      if(attribute == null) return null;

      return attribute.getEmails().stream().
          .map(Email::toString)
          .collect(Collector.joining(","));
    }
    @Override
    public EmailSet convertToEntityAttribute(String dbData) {
      if(dbData == null) return null;
      String[] emails = dbData.split(",");
      Set<Email> emailSet = Arrays.stream(emails)
          .amp(value -> new Email(value))
          .collect(toSet());
      return new EmailSet(emailSet);
    }
  }
  ``` 
  - 이제 남은 것은 EmailSet 타입의 프로퍼티가 Converter로 EmailSetConverter를 사용하도록 지정하는 것이다.
  ```java
  @Column(name = "emails")
  @Convert(converter = EmailSetConverter.class)
  private EmailSet emailSet;
  ``` 
  
### 밸류를 이용한 아이디 매핑
- 식벼랒는 최종적으로 문자열이나 숫자와 같은 기본 타입이기 떄문에 다음과 같이 String이나 Long 타입을 이용해서 식별자를 매핑한다.
```java
@Entity
public class Order {
  // 기본 타입을 이용한 식별자 매핑
  @Id
  private String number;
  ...
}

public class Article {
  @Id
  private Long id;
  ... 
}
```

- 기본 타입을 사용하는 것이 나쁘진 않지만 식별자라는 의미를 부각시키기 위해 식별자 자체를 별도 밸류 타입으로 만들 수도 있다.
  - 지금까지 살펴본 예제에서 OrderNo, MemberId 등이 식별자를 표현하기 위해 사용한 밸류 타입이다. 
  - 밸류타입을 식별자로 매핑하면 @Id 대신 @EmbeddedId 애노테이션을 사용한다. 
  ```java
  @Entity
  @Table(name = "purchase_order")
  public class Order{
    @EmbeddedId
    private OrderNo number;
    ...
  }

  @Embeddable
  public class OrderNo implements Serializable {
    @Column(name = "order_number")
    private String number;
    ...
  }
  ``` 
  - JPA에서 식별자 타입은 Serializable 타입이어야 하므로 식별자로 사용될 밸류 타입은 Serializable 인터페이스를 상속 받아야 한다.
- 밸류 타입으로 식별자를 구현할 때 얻을 수 있는 장점은 식별자에 기능을 추가할 수 있다는 점이다.
  - 예) 1세대 시스템의 주문번호와 2세대 시스템의 주문번호를 구분할 때 주문번호의 첫 글자를 이용한다고 해보자.
  - 이 경우 다음과 같이 OrderNo 클래스에 시스템 세대를 구분할 수 있는 기능을 구현할 수 있다.
  ```java
  @Embeddable
  public class OrderNo implements Serializable {
    @Column(name = "order_number")
    private String number;
    
    public boolean is2ndGeneration() {
      return number.startsWith("N");
    }
  }
  ``` 
  - 시스템 세대 구분이 필요한 코드는 OrderNo가 제공하는 기능을 이용해서 구분하면 된다.
  ```java
  if(order.getNumber().is2ndGeneration()) {
    ...
  }
  ``` 
- JPA는 내부적으로 엔티티를 비교할 목적으로 equals() 메서드와 hashcode()값을 사용하므로 식별자로 사용한 벨류 타입은 이 두 메서드를 알맞게 구현해야 한다. 

### 별도 테이블에 저장하는 밸류 매핑
- 애그리거트에서 루트 엔티티를 뺀 나머지 구성요소는 대부분 밸류이다. 
  - 루트 엔티티 외에 또 다른 엔티티가 있다면 진짜 엔티티인지 의심해봐야 한다. 
  - 단지 별도 테이블에 데이터를 저장한다고 해서 엔티티인 것은 아니다. 
  - 주문 애그리거트도 OrderLine을 별도 테이블에 저장하지만 OrderLine 자체는 엔티티가 아니라 밸류이다.
- 밸류가 아니라 엔티티가 확실하다면 다른 애그리거트는 아닌지 확인해야 한다. 
  - 특히 자신만의 독자적인 라이프사이클을 갖는다면 다른 애그리거트일 가능성이 높다.
  - 예) 상품 상세화면을 보면 상품 자체에 대한 정보와 고객의 리뷰를 함께 보여주는데, 이를 보고 상품 애그리거트에 고객 리뷰가 포함된다고 생각할 수 있다.
  - 하지만, Product와 Review는 함께 생성되지 않고, 함께 변경되지도 않는다. 
  - 게다가 변경 주체도 다르다. 
  - Review의 변경이 Product에 영향을 주지 않고 반대로 Product의 변경이 Review에 영향을 주지 않기 때문에 Review는 엔티티는 맞지만 리뷰 애그리거트에 속한 엔티티이지 상품 애그리거트에 속한 엔티티는 아니다. 
- 애그리거트에 속한 객체가 밸류인지 엔티티인지 구분하는 방법은 고유 식별자를 갖는지 여부를 확인하는 것이다.
  - 하지만, 식별자를 찾을 때 매핑되는 테이블의 식별자를 애그리거트 구성요소의 식별자와 동일한 것으로 착각하면 안 된다. 
  - 별도 테이블로 저장되고 테이블에 PK가 있다고 해서 테이블과 매핑되는 애그리거트 구성요소가 고유 식별자를 갖는 것은 아니다. 
  - 예) 게시글 데이터를 ARTICLE 테이블과 ARTICLE_CONTENT 테이블로 나눠서 저장할때 
  - 밸류를 엔티티로 잘못 매핑한 예 
  ![image](https://user-images.githubusercontent.com/28394879/135374950-e169540b-eb28-4f52-8e91-46d2e0a665bf.png)
  - 위의 그림만 보면 ARTICLE_CONTENT 테이블의 ID 칼럼이 식별자이므로 ARTICLE_CONTENT와 매핑되는 ArticleContent를 엔티티로 생각할 수 있는데, 이것 때문에 Article과 ArticleContent를 두 엔티티 간의 일대일 연관으로 매핑하는 실수를 할 수 있다.
- ArticleContent를 엔티티로 생각할 수 있지만 ArticleContent는 Article의 내용을 담고 있는 밸류로 생각하는 것이 맞다. 
  - ARTICLE_CONTENT의 ID는 식별자이기는 하지만 이 식별자를 사용하는 이유는 ARTICLE 테이블의 데이터와 연결하기 위함이지 ARTICLE_CONTENT를 위한 별도 식별자가 필요하기 때문은 아니다.
  - 즉, 이는 게시글의 특정 프로퍼티를 별도 테이블에 보관한 것으로 접근해야 한다.
  - ArticleContent를 밸류로 보고 접근하면 모델은 다음과 같이 바뀐다. 
  ![image](https://user-images.githubusercontent.com/28394879/135376675-5e362787-ba6c-454e-8707-4fd08af09398.png)
- ArticleContent는 밸류이므로 @Embeddable로 매핑한다. 
  - ArticleContent와 매핑되는 테이블은 Article과 매핑되는 테이브로가 다른데, 이때 밸류를 매핑한 테이블을 지정하기 위해 @SecondaryTable과 @AttributeOverride를 사용한다. 
  ```java
  @Entity
  @Table(name = "article")
  @SecondaryTable(
    name = "article_content",
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
  )
  public class Article {
    @Id
    private Long id;
    private String title;
    ...
    @AttributeOverrides({
      @AttributeOverride(name = "content",
        column = @Column(table = "article_content")),
      @AttributeOverride(name = "contentType",
        column = @Column(table = "article_content"))))
    })
    private ArticleContent content;
  }
  ``` 
  - @SecondaryTable의 name 속성은 밸류를 저장할 테이블을 지정한다.
  - pkJoinColumns 속성은 밸류 테이블에서 엔티티 테이블로 조인할 때 사용할 칼럼을 지정한다.
  - content 필드에 @AttributeOverride를 적용했는데 이 애노테이션을 사용해서 해당밸류 데이터가 저장된 테이블 이름을 지정한다.
  - @SecondaryTable을 이용하면 아래 코드를 실행할 때 두 테이블을 조인해서 데이터를 조회한다.
  ```java
  // @SecondaryTable로 매핑된 article_content 테이블을 조인
  Article article = entityManager.find(Article.class, 1L);
  ``` 
  - 게시글 목록을 보여주는 화면은 article 테이블의 데이터만 필요하지, article_content 테이블의 데이터는 필요하지 않다.
  - 그런데, @SecondaryTable을 사용하면 목록 화면에 보여줄 Article을 조회할 때 article_content 테이블까지 조인해서 데이터를 읽어오는데 이는 원하는 결과가 아니다. 
  - 이 문제를 해소하고자 ArticleContent를 엔티티로 매핑하고 Article에서 ArticleContent로의 지연 로딩 방식으로 설정할 수도 있다. 
  - 하지만 이 방식은 엔티티가 아닌 모델을 엔티티로 만드는 것이므로 좋은 방법은 아니다. 
  - 대신 조회 전용 기능을 구현하는 방법을 사용하는 것이 좋다.
  - JPA에서 조회 전용 쿼리를 실행하는 방법은 5장에서 살펴본다.
 
### 밸류 컬렉션을 @Entity로 매핑하기
- 개념적으로 밸류인데 구현 기술의 한계나 팀 표준 때문에 @Entity를 사용해야 할 때도 있다.
  - 예) 제품의 이미지 업로드 방식에 따라 이미지 경로와 썸네일 이미지 제공 여부가 달라질 때
  ![image](https://user-images.githubusercontent.com/28394879/135393333-0e0e8db3-dd51-48b7-863b-c9834bd613bd.png)
  - JPA는 @Embeddable 타입의 클래스 상속 매핑을 지원하지 않는다. 
  - 따라서 상속 구조를 갖는 밸류 타입을 사용하려면 @Embeddable 대신 @Entity를 이용한 상속 매핑으로 처리해야 한다.
  - 밸류 타입을 @Entity로 매핑하므로 식별잘 매핑을 위한 필드도 추가해야 한다.
  - 또한, 구현 클래스를 구분하기 위한 타입 식별(discriminator) 칼럼을 추가해야 한다.
  - 이를 위한 테이블 설계는 다음과 같다. 
  ![image](https://user-images.githubusercontent.com/28394879/135394323-71a1aaa0-62ac-4951-968a-a5c2f24d07be.png) 
  - 한 테이블에 Image 및 하위 클래스를 매핑하므로 Image 클래스에 @Inheritance를 적용하고 strategy 값으로 SINGLE_TABLE을 사용하고, @DiscriminatorColumn을 이용해서 타입을 구분하는 용도로 사용할 칼럼을 지정한다. 
  - Image를 @Entity로 매핑했지만 모델에서 Image는 엔티티가 아니라 밸류이므로 다음과 같이 상태를 변경하는 기능은 추가하지 않는다. 
  ```java
  @Entity
  @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
  @DiscriminatorColumn(name = "image_type")
  @Table(name = "image")
  public abstract class Image {
    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column(name = "image_path")
    private String path;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upload_time")
    private Date uploadTime;

    protected Image() {}
    public Image(String path) {
      this.path = path;
      this.uploadTime = new Date();
    }

    protected String getPath() {
      return path;
    }

    public Date getUploadTime() {
      return uploadTime;
    }

    public abstract String getURL();
    public abstract boolean hasthumbnail();
    public abstract String getThumbnailURL();
  }
  ``` 
  - Image를 상속받은 클래스는 다음과 같이 @Entity와 @Discriminator를 사용해서 매핑을 설정한다.
  ```java
  @Entity
  @DiscriminatorValue("II")
  public class InternalImage extends Image {
    ... 
  }

  @Entity
  @DiscriminatorValue("EI")
  public class ExternalImage extends Image {
    ... 
  }
  ```

  ```java
  @Entity
  @Table(name = "product")
  public class Product {
    @EmbeddedId
    private ProductId id;
    private String name;

    @Convert(converter = MoneyConverter.class)
    private Money price;
    private String detail;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "product_it")
    @OrderColumn(name = "list_idx")
    private List<Image> images = new ArrayList<>();
    ...
    public void changeImages(List<Image> newImages) {
      images.clear();
      images.addAll(newImages);
    }
  }
  ```

  - Image가 @Entity이므로 목록을 담고 있는 Product는 @OneToMany를 이용해서 매핑을 처리 한다. 
  - Image는 밸류이므로 독자적인 라이프사이클을 갖지 않고 Product에 완전히 의존한다.
  - 따라서 cascade 속성을 이용해서 Product를 저장할 때 함께 저장되고, Product를 삭제 할때 함께 삭제되도록 설정한다. 
  - 리스트에서 Image 객체를 제거하면 DB에서 함께 삭제되도록 orphanRemoval 도 true로 설정한다.
  - `changeImages()`: 이미지 교체를 위해 clear() 메서드를 사용한다.
  - @Entity에 대한 @OneToMany 매핑에서 컬렉션의 clear() 메서드를 호출하면 삭제 과정이 효율적이지 않을 수 있다.
  - 예) 하이버네이터의 경우 @Entity를 위한 컬렉션 객체의 clear() 메서드를 호출하면 select 쿼리로 대상 엔티티를 로딩하고, 각 개별 엔티티에 대해 delete 쿼리를 실행한다.
  - 즉, images에 보관되어 있던 Image 개수가 4개면 changeImages를 실행 할때 Image 목록을 가져오기 위한 한 번의 `select * from image where product_id=?` 쿼리(물론, 이미 로딩했으면 select는 생략)와 각 Image를 삭제하기 위한 네 번의 쿼리 `delete image where image_id = ?` 쿼리를 실행한다.
  - 변경 빈도가 낮으면 괜찮지만 빈도가 높으면 전체 서비스 성능에 문제가 될 수 있다.
- 하이버네이트는 @Embeddable 타입에 대한 컬렉션의 clear() 메서드를 호출하면 컬렉션에 속한 객체를 로딩하지 않고 한 번의 delete 쿼리로 삭제 처리를 수행한다.
  - 따라서, 애그리거트의 특성을 유지하면서 이 문제를 해소하려면 결국 상속을 포기하고 @Embeddable로 매핑된 단일 클래스로 구현해야 한다. 
  - 물론, 이 경우 타입에 따라 다른 기능을 구현하려면 다음과 같이 if-else를 써야 하는 단점이 발생한다.
  ```java
  @Embeddable
  public class Image {
    @Column(name = "image_type")
    private String imageType;
    @Column(name = "image_path")
    private String path;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upload_time")
    private Date uploadTime;
    ...

    public boolean hasThumbnail() {
      // 성능을 위해 다형을 포기하고 if-else로 구현 
      if(imageType.equals("II")) {
        return true;
      } else {
        return false;
      }
    }
  }
  ``` 

### ID 참조와 조인 테이블을 이용한 단방향 M:N매핑 
- 앞서 3장에서 애그리거트 간 집합 연관은 성능상의 이유로 피해야 한다고 했다.
  - 그럼에도 불구하고 요구사항을 구현하는 데 집합 연관을 사용하는 것이 유리하다면 ID 참조를 이용한 단방향 집합 연관을 적용해 볼 수 있다.
  - 이미 3장에서 이와 관련 된 매핑 예를 보여준 바 있다.
  ```java
  @Entity
  @Table(name = "product")
  public class Product {
    @EmbeddedId
    private ProductId id;
    
    @ElementCollection
    @CollectionTable(name = "product_catergory",
        joinColumns = @JoinColumn(name = "product_id"))
    private Set<CategoryId> categoryIds;
  }
  ``` 
  - 이 코드는 Product에서 Category로의 단방향 M:N 연관을 ID 참조 방식으로 구현한 것이다.
  - ID 참조를 이용한 애그리거트 간 단방향 M:N 연관은 밸류 컬렉션 매핑과 동일한 방식으로 설정한 것을 알 수 있다.
  - 차이점이 있다면, 집합의 값에 밸류 대신 연관을 맺는 식별자가 온다는 것이다. 
  - @ElementCollection을 이용하기 떄문에 Product를 삭제할 때 매핑에 사용한 조인 테이블의 데이터도 함께 삭제된다.
  - 애그리거트를 직접 참조하는 방식을 사용했다면 영속성 전파나 로딩 전략을 고민해야 하는데 ID 참조 방식을 사용함으로써 이런 고민을 할 필요가 없다. 
 



</details>

<details> <summary> 3. 애그리거트 로딩 전략 </summary>

## 3. 애그리거트 로딩 전략

- JPA 매핑을 설정할 때 항상 기억해야 할 점은 애그리거트에 속한 객체가 모두 모여야 완전한 하나가 된다는 것이다.
  - 즉, 다음과 같이 애그리거트 루트를 로딩하면 루트에 속한 모든 객체가 완전한 상태여야 함을 의미한다.
  ```java
  // product는 완전한 하나여야 한다.
  Product product = productRepository.findById(id);
  ``` 

- 조회 시점에서 애그리거트를 완전한 상태가 되도록 하려면 애그리거트 루트에서 연관 매핑의 조회 방식을 즉시 로딩(FetchType.EAGER)으로 설정하면 된다. 
  - 즉, 다음과 같이 컬렉션이나 @Entity에 대한 매핑의 fetch 속성을 즉시 로딩(FetchType.EAGER)으로 설정하면 EntityManager#find() 메서드로 애그리거트 루트를 구할 떄 연관된 구성요소를 DB에서 함께 읽어온다.
  ```java
  // @Entity 컬렉션에 대한 즉시 로딩 설정 
  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
      orpahnRemoval = true, fetch = FetchType.EAGER)
  @JoinColumn(name = "product_id")
  @OrderColumn(name = "list_idx")
  private List<Image> images = new ArrayList<>();

  // @Embeddable 컬렉션에 대한 즉시 로딩 설정 
  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "order_line",
      joinColumns = @JoinColumn(name = "order_number"))
  @OrderColumn(name = "line_idx")
  private List<OrderLine> orderLines;
  ``` 
- 즉시 로딩 방식으로 설정하면 애그리거트 루트를 로딩하는 시점에 애그리거트에 속한 모든 객체를 함께 로딩할 수 있는 장점이 있지만, 이 장점이 항상 좋은 것은 아니다. 
  - 특히, 컬렉션에 대해 로딩 전략을 FetchType.EAGER로 설정하면 오히려 즉시 로딩 방식이 문제가 될 수 있다.
  - 예) Product 애그리거트 루트가 @Entity로 구현한 Image와 @Embeddable로 구현한 Option 목록을 갖고 있을 때
  ```java
  @Entity
  @Table(name = "product")
  public class Product {
    ...
    @OneToMany(
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
      orphanRemoval = true,
      fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @OrderColumn(name = "list_idx")
    private List<Image> images = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_option",
        joinColumns = @JoinColumn(name = "product_id"))
    @OrderColumn(name = "list_idx")
    private List<Option> options = new ArrayList<>();
  }
  ``` 
  - 이 매핑을 사용할 때 EntityManager#find() 메서드로 Product를 조회하면 하이버네이트는 다음과 같이 Product를 위한 테이블, Image를 위한 테이블, Option을 위한 테이블을 조인한 쿼리를 실행한다.
  ```
  select
    p.product_id, ... image.product_id, img.image_id, img.list_idx, img.image_id, ...,
    opt.product_id, opt.option_title, opt.option_value, opt.list_idx
  from
    product p
    left outer join image img on p.product_id = img.product_id
    left outer join product_option opt on p.product_id = opt.product_id
  where p.product_id=?
  ``` 
  - 이 쿼리는 카타시안 조인을 사용하는데 이는 쿼리 결과에 중복을 발생시킨다.
  - 조회하는 Product의 image가 2개이고 option이 2개이면 위 쿼리 결과로 구해지는 행 개수는 4개이다.
  - 즉, product 테이블의 정보는 4번 중복되고 image와 product_option테이블의 정보는 2번 중복된다.
- 물론, 하이버네이트가 중복된 데이터를 알맞게 제거해서 실제 메모리에는 1개의 Product 객체, 2개의 Image 객체, 2개의 Option 객체로 변환해 주지만 애그리거트가 커지면 문제가 될 수 있다.
  - 만약 한 개 제품에 대한 이미지가 20개 이고, Option이 15개이면 EntityManager#find() 메서드가 실행하는 쿼리는 250행을 리턴한다. 
  - 실제 필요한 행 개수가 36(1+20+15)개인 것에 비하면 250개는 과도하게 많다. 
  - 보통 조회 성능 문제 때문에 즉시 로딩 방식을 사용하지만 이 경우에는 오히려 즉시 로딩 방식 때문에 조회 성능이 나빠지는 문제가 발생한다.
- 애그리거트는 개념적으로 하나여야 한다.
  - 하지만, 루트 엔티티를 로딩하는 시점에 애그리거트에 속한 객체를 모두 로딩해야 하는 것은 아니다.
  - 애그리거트가 완전해야 하는 이유는 두가지 정도로 생각해 볼 수 있다.
  - 첫번째) 상태를 변경하는 기능을 실행할 때 애그리거트 상태가 완전해야 한다
  - 두번째) 표현 영역에서 애그리거트의 상태 정보를 보여줄 때 필요하기 떄문
  - 이 중 두 번째는 별도의 조회 전용 기능을 구현하는 방식을 사용하는 것이 유리할 때가 많기 떄문에 애그리거트의 완전한 로딩과 관련된 문제는 상태 변경과 더 관련이 있다.
  - 상태 변경 기능을 실행하기 위해 조회 시점에 즉시 로딩을 이용해서 애그리거트를 완전한 상태로 로딩할 필요는 없다.
  - JPA는 트랜잭션 범위 내에서 지연 로딩을 허용하기 때문에 다음 코드처럼 실제로 상태를 변경하는 시점에 필요한 구성요소만 로딩해도 문제가 되지 않는다. 
  ```java
  @Transactional
  public void removeOptions(ProductId id, int optIdxToBeDeleted) {
    // Product를 로딩, 컬렉션은 지연 로딩으로 선정했다면, Option은 로딩하지 않음
    Product product = productRepository.findById(id);
    // 트랜잭션 범위이므로 지연 로딩으로 설정한 연관 로딩 가능
    product.removeOption(optIdxToBeDeleted);
  }
  ``` 
  ```java
  @Entity
  public class Product{
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "product_option", 
        joinColumns = @JoinColumn(name = "product_id"))
    @OrderColumn(name = "list_idx")
    private List<Option> options = new ArrayList<>();

    public void removeoption(int optIdx) {
      // 실제 컬렉션에 접근할 때 로딩
      this.options.remove(optIdx);
    }
  }
  ```
  - 게다가 일반적인 애플리케이션은 상태를 변경하는 기능을 실행하는 빈도보다 조회하는 기능을 실행하는 빈도가 훨씬 높다.
  - 그러므로 상태 변경을 위해 지연 로딩을 사용할 때 발생하는 추가 쿼리로 인한 실행 속도 저하는 문제가 되지 않는다.
- 이런 이유로 애그리거트 내의 모든 연관을 즉시 로딩으로 설정할 필요는 없다.
  - 지연 로딩은 동작 방식이 항상 동일하기 때문에 즉시 로딩처럼 경우의 수를 따질 필요가 없는 장점이 있다.(즉시 로딩 설정은 @Entity나 @embeddable에 대해 다르게 동작하고, JPA 프로바이더에 따라 구현 방식이 다를 수 있다).
  - 물론, 지연 로딩은 즉시 로딩보다 쿼리 실행 횟수가 많아질 가능성이 더 높다.
  - 따라서, 무조건 즉시 로딩이나 지연 로딩으로만 설정하기보다는 애그리거트에 맞게 즉시 로딩과 지연 로딩을 선택해야 한다. 

   

</details>

<details> <summary> 4. 애그리거트의 영속성 전파 </summary>

## 4. 애그리거트의 영속성 전파

- 애그리거트가 완전한 상태여야 한다는 것은 애그리거트 루트를 조회할 때뿐만 아니라 저장하고 삭제할 때도 하나로 처리해야 함을 의미한다. 
  - 저장 메서드는 애그리거트 루트만 저장하면 안 되고 애그리거트에 속한 모든 객체를 저장해야 한다. 
  - 삭제 메서드는 애그리거트 루트뿐만 아니라 애그리거트에 속한 모든 객체를 삭제해야 한다.
- @Embeddable 매핑 타입의 경우 함께 저장되고 삭제되므로 cascade 속성을 추가로 설정하지 않아도 된다.
- 반면에 애그리거트에 속한 @Entity 타입에 대한 매핑은 cascade 속성을 사용해서 저장과 삭제 시에 함께 처리되도록 설정해야 한다. 
  - @OneToOne, @OneToMany는 cascade 속성의 기본값이 없으므로 다음 코드 처럼 cascade 속성 값으로 CascadeType.PERSIST, CascadeType.REMOVE를 설정한다.
  ```java
  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
    orphanRemoval = true)
  @JoinColumn(name = "product_id")
  @OrderColumn(name = "list_idx")
  private List<Image> images = new ArrayList<>();
  ``` 


</details>

<details> <summary> 5. 식별자 생성 기능 </summary>

## 5. 식별자 생성 기능

- 식별자는 크게 세 가지 방식 중 하나로 생성한다.
  - 사용자가 직접 생성
  - 도메인 로직으로 생성
  - DB를 이용한 일련번호 사용

### 사용자가 직접 생성 
- 이메일 주소처럼 사용자가 직접 식별자를 입력하는 경우는 식별자 생성 주체가 사용자이기 떄문에 도메인 영역에 식별자 생성 기능을 구현할 필요가 없다.

### 도메인 로직으로 생성
- 식별자 생성 규칙이 있는 경우 엔티티를 생성할 때 이미 생성한 식별자를 전달하므로 엔티티가 식별자 생성 기능을 제공하는 것보다는 별도 서비스로 식별자 생성 기능을 분리해야 한다.
  - 식별자 생성 규칙은 도메인 규칙이므로 도메인 영역에 식별자 생성 기능을 위치 시켜야 한다.
  - 예) 다음과 같은 도메인 서비스를 도메인 영역에 위치시킬 수 있다.
  ```java
  public class ProductIdService {
    public ProductId nextId() {
      ... // 정해진 규칙으로 식별자 생성
    }
  }
  ``` 
  - 응용 서비스는 이 도메인 서비스를 이용해서 식별자를 구하고 엔티티를 생성할 것이다.
  ```java
  public class CreateProductService {
    @Autowired private ProductIdService idService;
    @Autowired private ProductRepository productRepository;

    @Transactional
    public ProductId createProduct(ProductCreationCommand cmd) {
      // 응용 서비스는 도메인 서비스를 이용해서 식별자를 생성
      ProductId id = productIdService.nextId();
      Product product = new Product(id, cmd.getDetail(), cmd.getPrice(), ...);
      productRepository.save(product);
      return id;
    }
  }
  ``` 
- 특정 값의 조합으로 식별자가 생성되는 것 역시 규칙이므로 도메인 서비스를 이용해서 식별자를 생성할 수 있다.
  - 예) 주문번호를 고객 ID와 타임스탬프로 구성한다고 할 경우 다음과 같은 도메인 서비스를 구현할 수 있다.
  ```java
  public class OrderIdService {
    public OrderId createId(UserId userId) {
      if (userId == null)
        throw new IllegalArgumentException("invalid userid: " + userId);

        return new OrderId(userId.toString() + "-" + timestamp());
    }

    private String timeStamp() {
      return Long.toString(System.currentTimeMillis());
    }
  }
  ``` 

### DB를 이용한 일련번호 사용
- 식별자 생성 규칙을 구현하기에 적합한 또 다른 장소는 리포지터리이다.
  - 다음과 같이 리포지터리 인터페이스에 식별자를 생성하는 메서드를 추가하고 리포지터리 구현 클래스에서 알맞게 구현하면 된다.
  ```java
  public interface ProductRepository {
    ... // save() 등 다른 메서드

    // 식별자를 생성하는 메서드
    ProductId nextId();
  }
  ```
  - 식별자 생성으로 DB의 자동 증가 칼럼을 사용할 경우 JPA의 식별자 매핑에서 @GeneratedValue를 사용한다.
  ```java
  @Entity
  @Table(name = "article")
  ...
  public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
      return id;
    }
  }
  ```
- 자동 증가 칼럼은 DB의 insert 쿼리를 실행해야 식별자가 생성되므로 도메인 객체를 리포지터리에 저장할 때 식별자가 생성된다.
  - 이 이야기는 도메인 객체를 생성하는 시점에서 식별자를 알 수 없고 도메인 객체를 저장한 뒤에 식별자를 구할 수 있음을 의미한다.
  ```java
  public class WriteArticleService {
    private ArticleRepository articleRepository;

    public Long write(NewArticleRequest req) {
      Article article = new Article("제목", new ArticleContent("content", "type"));
      articleRepository.save(article); // EntityManager#save()
                                      // 실행 시점에 식별자 생성
      return article.getId();
    }
  }
  ``` 
  - JPA는 저장 시점에 생성한 식별자를 @Id로 매핑한 프로퍼티/필드에 할당한다. 
  - 따라서 위 코드 처럼 저장 이후에 엔티티의 식별자를 사용할 수 있다.
- 자동 증가 칼럼 외에 JPA의 식별자 생성 기능을 사용하는 경우에도 마찬가지로 저장 시점에 식별자를 생성한다. 
    

  


</details>



# 7. 도메인 서비스 

<details> <summary> 1. 도메인 서비스 </summary>

## 1. 도메인 서비스

### 여러 애그리거트가 필요한 기능 
- 도메인 영역의 코드를 작성하다 보면 한 애그리거트로 기능을 구현할 수 없을 때가 있다.
- 대표적인 예) 결제 금액 계산 로직 
- 실제 계산 금액을 계산할 때는 다음과 같은 내용이 필요하다.
  - 상품 애그리거트: 구매하는 상품의 가격이 필요하다. 또한 상품에 따라 배송비가 추가되기도 한다.
  - 주문 애그리거트: 상품별로 구매 개수가 필요하다.
  - 할인쿠폰 애그리거트: 쿠폰별로 지정한 할인 금액이나 비율에 따라 주문 총 금액을 할인한다.
  - 회원 애그리거트: 회원 등급에 따라 추가 할인이 가능하다.
- 이 상황에 실제 결제 금액을 계산해야 하는 주체는 어떤 애그리거트일까? 
  - 총 주문 금액을 계산하는 것은 주문 애그리거트가 할 수 있지만 실제 결제 금액은 이야기가 다르다.
  - 총 주문 금액에서 할인 금액을 계산해야 하는데 이 할인 금액을 구하는 것은 누구 책임일까? 
  - 할인 쿠폰이 할인 규칙을 갖고 있으니 할인 쿠폰 애그리거트가 계산 해야 할까?
  - 그런데, 할인 쿠폰을 두 개 이상 적용할 수 있다면 단일 할인 쿠폰 애그리거트로는 총 결제 금액을 계산할 수 없다.
- 생각해 볼 수 있는 방법은 주문 애그리거트가 필요한 애그리거트나 필요 데이터를 모두 가지도록 한 뒤 할인 금액 계산을 주문 애그리거트에 할당하는 것이다. 
  ```java
  public class Order {
    ...
    private Orderer orderer;
    private List<OrderLine> orderLines;
    private List<Coupon> usedCoupons;

    private Money calculatePayAmounts() {
      Money totalAmounts = calculateTotalAmounts();
      // 쿠폰별로 할인 금액을 구한다. 
      Money discount = coupons.stream()
          .map(coupon -> calculateDiscount(coupon))
          .reduce(Money(0), (v1, v2) -> v1.add(v2));
      
      // 회원에 따른 추가 할인을 구한다.
      Money membershipDiscount = calculateDiscount(orderer.getMember().getGrade());

      // 실제 결제 금액 계산
      return totalAmounts.minus(discount).minus(membershipDiscount);
    }

    private Money calculateDiscount(Coupon coupon) {
      // orderLines의 각 상품에 대해 쿠폰을 적용해서 할인 금액 계산하는 로직,
      // 쿠폰의 적용 조건 등을 확인하는 코드
      // 정채겡 따라 복잡한 if-else와 계산 코드 
      ... 
    }

    private Money calculateDiscount(MemberGrade grade) {
      ...// 등급에 따라 할인 금액 계산 
    }
  }
  ```  

- 여기서 고민거리는 결제 금액 계산 로직이 주문 애그리거트의 책임이 맞느냐에 대한 것이다. 
  - 예) 특별 감사 세일로 전 품목에 대해 한 달간 2% 추가 할인을 하기로 했다.
  - 이 할인 정책은 주문 애그리거트가 갖고 있는 구성요소와는 관련이 없음에도 불구하고 결제 금액 계산 책임이 주문 애그리거트에 있다는 이유로 주문 애그리거트의 코드를 수정해야 한다. 
- 이렇게 한 애그리거트에 넣기에 애매한 도메인 기능을 특정 애그리거트에 억지로 구현하면 안된다. 
  - 이 경우에 애그리거트는 자신의 책임 범위를 넘어서는 기능을 구현하기 떄문에 코드가 길어지고 외부에 대한 의존이 높아지게 된다. 
  - 이는 코드를 복잡하게 만들어 수정을 어렵게 만드는 요인이 된다.
  - 게다가 애그리거트의 범위를 넘어서는 도메인 개념이 애그리거트에 숨어들어서 명시적으로 들어나지 않게 된다.
  - 이런 문제를 해소하는 가장 쉬운 방법이 하나 있는데 그것은 바로 도메인 서비스를 별도로 구현하는 것이다.


### 도메인 서비스
- 할인 금액 규칙 계산처럼 한 애그리거트에 넣기 애매한 도메인 개념을 구현하려면 애그리거트에 억지로 넣기보다는 도메인 서비스를 이용해서 도메인 개념을 명시적으로 드러내면 된다.
  - 응용 영역의 서비스가 응용 로직을 다룬다면 도메인 서비스는 도메인 로직을 다룬다. 
- 도메인 서비스가 도메인 영역의 애그리거트나 밸류와 같은 다른 구성요소와 비굫라 때 다른 점이 있다면 상태 없이 로직만 구현한다는 점이다. 
  - 도메인 서비스를 구현하는데 필요한 상태는 애그리거트나 다른 방법으로 전달받는다.
- 할인 금액 계산 로직을 위한 도메인 서비스는 다음과 같이 도메인의 의미가 드러나는 용어를 타입과 메서드 이름으로 갖는다.
  ```java
  public class DiscountCalculationService {
    
    public Money calculateDiscountAmounts(
      List<OrderLine> orderLines,
      List<Coupon> coupons,
      MemberGrade grade ) {
        Money couponDiscount = coupons.stream()
            .map(coupon -> calculateDiscount(coupon))
            .reduce(Money(0), (v1, v2) -> v1.add(v2));

        Money membershipDiscount = calculateDiscount(orderer.getMember().getGrade());

        return couponDiscount.add(membershipDiscount);
      }

      private Money calculateDiscount(Coupon coupon) {
        ...
      }

      private Money calculdateDiscount(MemberGrade grade) {
        ...
      }
  }
  ``` 

- 할인 계산 서비스를 사용하는 주체는 애그리거트가 될 수도 있고 응용 서비스가 될 수도 있다.
  - DiscountCalculationService를 다음과 같이 애그리거트의 결제 금액 계산 기능에 전달하면 사용 주체는 애그리거트가 된다.
  ```java
  public class Order {
    public void calculateAmounts(
      DiscountCalculationService disCalSvc, MemberGrade grade) {
        Money totalAmounts = getTotalAmounts();
        Money discountAmounts = disCalSvc.calculateDiscountAmounts(this.orderLines, this.coupons, grade);
        this.paymentAmounts = totalAmounts.minus(discountAmounts);
      }
  }
  ...
  ```

- 애그리거트 객체에 도메인 서비스를 전달하는 것은 응용 서비스 책임이다. 
  ```java
  public class OrderService {
    private DiscountCalculationService discountCalculationService;
    
    @Transactional
    public OrderNo placeOrder(OrderRequest orderRequest) {
      OrderNo orderNo = orderRepository.nextId();
      Order order = createOrder(orderNo, orderRequest);
      orderRepository.save(order);
      // 응용 서비스 실행 후 표현 영역에서 필요한 값 리턴 
      return orderNo;
    }

    private Order createOrder(OrderNo orderNo, OrderRequest orderReq) {
      Member member = findMember(orderReq.getOrdererId());
      Order order = new Order(orderNo, orderReq.getOrderLines(), 
          orderReq.getCoupons(), createOrderer(member),
          orderReq.getShippingInfo());
      order.calculateAmounts(this.discountCalculationService, member.getGrade());
      return order;
    }
    ... 
  }
  ``` 
  
**도메인 서비스 객체를 애그리거트에 주입하지 않기**

> 애그리거트의 메서드를 실행할 때 도메인 서비스 객체를 파라미터로 전달한다는 것은 애그리거트가 도메인 서비스에 의존한다는 것을 뜻한다.
> 스프링의 DI와 AOP를 공부하다 보면 애그리거트가 의존하는 도메인 서비스를 의존 주입으로 처리하고 싶어질 수 있다. 
> 관련 기술에 빠져 있으면 특히 그렇다.
> 프레임워크가 제공하는 의존 주입 기능을 사용해서 도메인 서비스를 애그리거트에 주입해야 기술적으로 나은 것 같은 착각도 한다.
> 하지만, 개인적으로 이는 좋은 방법이 아니라고 생각한다.(어디까지나 개인적인 생각이며 의존 자동 주입과 같은 방식을 선호하는 개발자도 물론 있다.) 
> 의존 주입을 하기 위해 애그리거트 루트 앤티티에 도메인 서비스에 대한참조를 필드로 추가했다고 하자.
> ```java
> public class Order{
>   @Autowired
>   Prrivate DiscountCalculationService discountCalculationService;
>   ...
> }
> ``` 
> 도메인 객체는 필드(프로퍼티)로 구성된 데이터와 메서드를 이용한 기능을 이용해서 개념적으로 하나인 모델을 표현한다.
> 모델의 데이터를 담는 필드는 모델에서 중요한 구성요소이다.
> 그런데, discountCalculationService 필드는 데이터 자체와는 관련이 없다. 
> Order 객체를 DB에 보관할 때 다른 필드와는 달리 저장 대상도 아니다.
> 또 Order가 제공하는 모든 기능에서 discountCalculationService를 필요로 하는 것도 아니다.
> 일부 기능만 필요로 한다.
> 일부 기능을 위해 굳이 도메인 서비스 객체를 애그리거트에 의존 주입할 이유는 없다.
> 이는 프레임워크의 기능을 사용하고 싶은 개발자의 욕심을 채우는것에 불과하다.

- 애그리거트 메서드를 실행할 때 도메인 서비스를 인자로 전달하지 않고 반대로 도메인 서비스의 기능을 실행할 때 애그리거트를 전달하기도 한다.
  - 이런식으로 동작하는 것 중 하나가 계좌 이체 기능이다.
  - 계좌 이체의 경우 두 계좌 애그리거트가 관여하는데 한 애그리거트는 금액을 출금하고 한 애그리거트는 금액을 입금한다.
  - 이를 위한 도메인 서비스는 다음과 같이 구현할 수 있다.
  ```java
  public class TransferService {
    public void transfer(Account fromAcc, Account toAcc, Money amounts) {
      fromAcc.withdraw(amounts);
      toAcc.credit(amounts);
    }
  }
  ``` 
  - 응용 서비스는 두 Account 애그리거트를 구한 뒤에 해당 도메인 영역의 TransferService를 이용해서 계좌 이체 도메인 기능을 실행할 것이다.
  - 도메인 서비스는 도메인 로직을 수행하지 응용 로직을 수행하지는 않는다.
  - 트랜잭션 처리와 같은 로직은 응용 로직이므로 도메인 서비스가 아닌 응용 서비스에서 처리해야 한다.

> 특정 기능이 응용 서비스인지 도메인 서비스인지 감을 잡기 어려울 때는 해당 로직이 애그리거트의 상태를 변경하거나 애그리거트의 상태값을 계산하는지 검사해 보면 된다.
> 예를 들어, 계좌 이체 로직은 계좌 애그리거트의 상태를 변경 한다.
> 결제 금액 로직은 주문 애그리거트의 주문 금액을 계산 한다.
> 이 두 로직은 각각 애그리거트를 변경하고 애그리거트의 값을 계산하는 도메인 로직이다.
> 도메인 로직이면서 한 애그리거트에 넣기 적합하지 않으므로 이 두 로직은 도메인 서비스로 구현하게 된다.


### 도메인 서비스의 패키지 위치

- 도메인 서비스는 도메인 로직을 실행하므로 도메인 서비스의 위치는 다른 도메인 구성 요소와 동일한 패키지에 위치한다. 
  - 예) 주문 금액 계산을 위한 도메인 서비스는 다음과 같이 주문 애그리거트와 동일 패키지에 위치한다.
  ![image](https://user-images.githubusercontent.com/28394879/135991798-4ba4bccd-7ec5-462f-8467-7635d4758e73.png)
  - 도메인 서비스의 개수가 많거나 엔티티나 밸류와 같은 다른 구성요소와 명시적으로 구분하고 싶다면 domain 패키지 밑에 domain.model, domain.service, domain.repository와 같이 하위 패키지를 구분해서 위치시켜도 된다. 

### 도메인 서비스의 인터페이스와 클래스
- 도메인 서비스의 로직이 고정되어 있지 않은 경우 도메인 서비스 자체를 인터페이스로 구현하고 이를 구현한 클래스를 둘 수도 있다.
  - 특히 도메인 로직을 외부 시스템이나 별도 엔진을 이용해서 구현해야 할 경우에 인터페이스와 클래스를 분리하게 된다.
  - 예) 할인 금액 계산 로직을 룰 엔진을 이용해서 구현한다면 아래 그림 처럼 도메인 영역에는 도메인 서비스 인터페이스가 위치하고 실제 구현은 인프라스트럭처 영역에 위치시킬 수 있다.
  ![image](https://user-images.githubusercontent.com/28394879/135992851-8b37f500-71eb-47fe-88f2-50d19a0b6447.png)
  - 위와 같이 도메인 서비스의 구현이 특정 구현 기술에 의존적이거나 외부 시스템의 API를 실행한다면 도메인 영역의 도메인 서비스는 인터페이스로 추상화해야 한다.
  - 이를 통해 도메인 영역이 특정 구현에 종속되는 것을 방지할 수 있고 도메인 영역에 대한 테스트가 수월해진다.



</details>





# 8.애그리거트 트랜잭션 관리 

<details> <summary> 1. 애그리거트와 트랜잭션 </summary>

## 1. 애그리거트와 트랜잭션

### 애그리거트와 트랜잭션

![image](https://user-images.githubusercontent.com/28394879/136129284-5c6c1e35-2e8b-4765-99d0-84bc54b2ac72.png)
- 한 주문 애그리거트에 대해 운영자는 배송 상태로 변경할 때 사용자는 배송지 주소를 변경하면 어떻게 될까? 
  - 위 그림은 발생할 수 있는 다양한 경우 중에서 한가지를 시간 순서로 표시한 것이다. 
- 위 그림은 운영자랑 고객이 동시에 한 주문 애그리거트를 수정하는 과정을 보여준다.
  - 메모리 캐시를 사용하지 않을 경우 운영자 스레드와 고객 스레드는 같은 주문 애그리거트를 나타내는 다른 객체를 구하게 된다. (트랜잭션마다 리포지터리는 새로운 애그리거트 객체를 생성한다.)
- 운영자 스레드와 고객 스레드는 개념적으로 동일한 애그리거트이지만 물리적으로 서로 다른 애그리거트 객체를 사용한다. 
  - 때문에 운영자 스레드가 주문 애그리거트 객체를 배송 상태로 변경하더라도 고객 스레드가 사용하는 주문 애그리거트 객체에는 영향을 주지 않는다.
  - 고객 스레드 입장에서 주문 애그리거트 객체는 아직 배송 상태 전이므로 배송지 정보를 변경할 수 있다. 
- 이 상황에서 두 스레드는 각각 트랜잭션을 커밋할 때 수정한 내용을 DBMS에 반영한다.
  - 즉, 배송 상태로 바뀌고 배송지 정보도 바뀌게 된다.
  - 이 순서의 문제점은 운영자는 기존 배송지 정보를 이용해서 배송 상태로 변경했는데 그 사이 고객은 배송지 정보를 변경했다는 점이다.
  - 즉, 애그리거트의 일관성이 깨지는 것이다.
- 이런 문제가 발생하지 않도록 하려면 다음의 두 가지 중 하나를 해야 한다.
  - 운영자가 배송지 정보를 조회하고 상태를 변경하는 동안 고객이 애그리거트를 수정하지 못하게 막는다.
  - 운영자가 배송지 정보를 조회한 이후에 고객이 정보를 변경하면 운영자가 애그리거트를 다시 조회한 뒤 수정하도록 한다. 
- 이 두가지는 애그리거트 자체의 트랜잭션과 관련이 있다.
  - DBMS가 지원하는 트랜잭션과 함께 애그리거트를 위한 추가적인 트랜잭션 처리 기법이 필요하다.
  - 애그리거트에 대해 사용할 수 있는 대표적인 트랜잭션 처리 방식에는 선점(Pessimistic)잠금과 비선점(Optimistic) 잠금의 두 가지 방식이 있다.

</details>

<details> <summary> 2. 선점 잠금 </summary>

## 2. 선점 잠금
- 선점 잠금(Pessimistic Lock)은 먼저 애그리거트를 구한 스레드가 애그리거트 사용이 끝날 때까지 다른 스레드가 해당 애그리거트를 수정하는 것을 막는 방식이다.
   ![image](https://user-images.githubusercontent.com/28394879/136131109-6b47e2c8-b296-4577-949d-aa5845676d11.png)
   - 위 그림은 선점 잠금의 동작 방식을 보여주고 있다.
 - 위 그림에서 선점 방식으로 애그리거트를 구한 뒤 이어서 스레드2가 같은 애그리거트를 구하고 있는데, 이 경우 스레드2는 스레드1이 애그리거트에 대한 잠금을 해제할 때까지 블로킹된다.
 - 스레드1이 애그리거트를 수정하고 트랜잭션을 커밋하면 잠금을 해제한다.
   - 이 순간 대기하고 있던 스레드2가 애그리거트에 접근하게 된다.
   - 스레드1이 트랜잭션을 커밋한 뒤에 스레드2가 애그리거트를 구하게 되므로 스레드2는 스레드1이 수정한 애그리거트의 내용을 보게 된다. 
 - 한 스레드가 애그리거트를 구하고 수정하는 동안 다른 스레드가 수정할 수 없으므로 동시에 애그리거트를 수정할 때 발생하는 데이터 충돌 문제를 해소할 수 있다.
   - 앞서 배송지 정보 수정과 배송 상태 변경을 동시에 하는 문제에 선점 잠금을 적용하면 다음과 같이 동작한다.
   ![image](https://user-images.githubusercontent.com/28394879/136132579-f21739fe-86c8-4c62-afd2-adaa82f55dd0.png)

- 운영자 스레드가 먼저 선점 잠금 방식으로 주문 애그리거트를 구한 경우 운영자 스레드가 잠금을 해제할 때까지 고객 스레드는 대기 상태가 된다.
  - 운영자 스레드가 배송 상태로 변경한 뒤 트랜잭션을 커밋하면 잠금을 해제한다.
  - 잠금이 해제된 시점에 고객 스레드가 구하는 주문 애그리거트는 운영자 스레드가 수정한 배송 상태의 주문 애그리거트이다.
  - 배송 상태이므로 주문 애그리거트는 배송지 변경 시 에러를 발생하고 트랜잭션은 실패하게 된다.
  - 이 시점에 고객은 '이미 배송시 시작되어 배송지를 변경할 수 없습니다' 와 같은 안내 문구를 보게 될 것이다.
- 선점 잠금은 보통 DBMS가 제공하는 행 단위 잠금을 사용해서 구현한다.
  - 오라클을 비롯한 다수 DBMS가 for update와 같은 쿼리를 사용해서 특정 레코드에 한 사용자만 접근할 수 있는 잠금 장치를 제공한다.
- JPA의 EntityManager는 LockModeType을 인자로 받는 find() 메서드를 제공하는데, LockModeType.PESSIMISTIC_WRITE를 값으로 전달하면 해당 엔티티와 매핑된 테이블을 이용해서 선점 잠금 방식을 적용할 수 있다.
  ```java
  Order order = entityManager.find(Order.class, orderNo, LockModeType.PESSMISTIC_WRITE);
  ``` 
- JPA 프로바이더와 DBMS에 따라 잠금 모드의 구현이 다른데, 하이버네이트의 경우 PESSMISTIC_WRITE를 잠금 모드로 사용하면 'for update' 쿼리를 사용해서 선점 잠금을 구현한다.

### 선점 잠금과 교착 상태
- 선점 잠금 기능을 사용할 때는 잠금 순서에 따른 교착 상태(deadlock)가 발생하지 않도록 주의해야 한다.
  - 예) 다음과 같은 순서로 스레드가 잠금 시도를 한다고 해보자.
  - 1. 스레드1: A 애그리거트에 대한 선점 잠금 구함
  - 2. 스레드2: B 애그리거트에 대한 선점 잠금 구함
  - 3. 스레드1: B 애그리거트에 대한 선점 잠금 시도
  - 4. 스레드2: A 애그리거트에 대한 선점 잠금 시도
- 이 순서에 따르면 스레드1은 영원히 B 애그리거트에 대한 선점 잠금을 구할 수 없다. 
  - 왜냐하면 스레드2가 B 애그리거트에 대한 잠금을 구할 수 없다.
  - 두 스레드는 상대방 스레드가 먼저 선점한 잠금을 구할 수 없어 더이상 다음 단계를 진행하지 못하게 된다.
  - 즉, 스레드1과 스레드2는 교착 상태에 빠지게 되는 것이다.
- 선점 잠금에 따른 교착 상태는 상대적으로 사용자 수가 많을 때 발생할 가능성이 높고, 사용자 수가 많아지면 교착 상태에 빠지는 스레드가 더 빠르게 증가하게 된다.
  - 더 많은 스레드가 교착 상태에 빠질수록 시스템은 점점 아무것도 할 수 없는 상황에 이르게 된다.
- 이런 문제가 발생하지 않도록 하려면 잠금을 구할 때 최대 대기 시간을 지정해야 한다.
  - JPA에서 선점 잠금을 시도할 때 최대 대기 시간을 지정하려면 다음과 같이 힌트를 사용하면 된다.
  ```java
  Map<String, Obejct> hints = new HashMap<>();
  hints.put("javax.persistence.lock.timeout", 2000);
  Order order = entityManager.find(Order.class, orderNo, LockModeType.PESSIMISTIC_WRITE, hints);
  ``` 

- JPA의 'javax.persistence.lock.timeout' 힌트는 잠금을 구하는 대기 시간을 밀리초 단위로 지정한다.
  - 지정한 시간 이내에 잠금을 구하지 못하면 익셉션을 발생시킨다.
  - 이 힌트를 사용할 때 주의할 점은 DBMS에 따라 힌트가 적용되지 않는다는 것이다.
  - 이 힌트를 이용할 때에는 사용중인 DBMS가 관련 기능을 지원하는지 확인해야 한다.

> DBMS에 따라 교착 상태에 빠진 커넥션을 처리하는 방식이 다르다.
> 쿼리별로 대기 시간을 지정할 수 있는 DBMS가 있고 커넥션 단위로만 대기 시간을 지정할 수 있는 DBMS도 있다.
> 따라서, 선점 잠금을 사용하려면 사용하는 DBMS에 대해 JPA가 어떤 식으로 대기 시간을 처리하는지 반드시 확인해야 한다.  



</details>

<details> <summary> 3. 비선점 잠금 </summary>

## 3. 비선점 잠금

- 선점 잠금이 강력해 보이긴 하지만 선점 잠금으로 모든 트랜잭션 충돌 문제가 해결되는 것은 아니다. 
  ![image](https://user-images.githubusercontent.com/28394879/136135821-3551cc48-9a9a-4b74-a33e-6ad6c94c19ae.png) 
  - 위 그림은 선점잠금으로 해결할 수 없는 상황이다.
- 위 그림의 실행순서는 다음과 같다.
  1. 운영자는 배송을 위해 주문 정보를 조회한다. 시스템은 정보를 제공한다.
  2. 고객이 배송지 변경을 위해 변경 폼을 요청한다. 시스템은 변경 폼을 제공한다.
  3. 고객이 새로운 배송지를 입력하고 폼을 전송해서 배송지를 변경한다.
  4. 운영자가 1번에서 조회한 주문 정보를 기준으로 배송지를 정하고 배송 상태 변경을 요청한다.

- 여기서 문제는 운영자가 배송지 정보를 조회하고 배송 상태로 변경하는 사이에 고객이 배송지를 변경하는 것이다.
  - 운영자는 고객이 변경하기 전의 배송지 정보를 이용해서 배송 준비를 한 뒤에 배송 상태로 변경하게 된다.
  - 즉, 배송 상태 변경 전에 배송지를 한 번 더 확인하지 않으면 운영자는 다른 배송지로 물건을 발송하게 되고, 고객은 배송지를 변경했음에도 불구하고 엉뚱한 곳으로 주문한 물건을 받는 상황이 발생한다.
- 이 문제는 선점 잠금 방식으로는 해결할 수 없는데, 이때 필요한 것이 비선점 잠금(Optimistic Lock)이다.
  - 비선점 잠금 방식은 잠금을 해서 동시에 접근하는 것을 막는 대신 변경한 데이터를 실제 DBMS에 반영하는 시점에 변경 가능 여부를 확인하는 방식이다.
- 비선점 잠금을 구현하려면 애그리거트에 버전으로 사용할 숫자 타입의 프로퍼티를 추가해야 한다.
  - 애그리거트를 수정할 때 마다 버전으로 사용할 프로퍼티의 값이 1씩 증가하는데, 이때 다음과 같은 쿼리를 사용한다.
  ```
  UPDATE aggtable SET version = version + 1, colx = ?, coly = ? WHERE aggid = ? and version = 현재 버전 
  ``` 
- 이 쿼리는 수정할 애그리거트와 매핑되는 테이블의 버전 값이 현재 애그리거트의 버전과 동일한 경우에만 데이터를 수정한다.
  - 그리고 수정에 성공하면 버전 값을 1 증가시킨다.
  - 따라서, 다른 트랜잭션이 먼저 데이터를 수정해서 버전 값이 바뀌면 데이터 수정에 실패하게 된다.
  - 이를 그림으로 표현하는 아래그림과 같다.
  ![image](https://user-images.githubusercontent.com/28394879/136137351-3b056eb4-152d-43e6-a0eb-da236edb6e4b.png)

- 위의 그림에서 스레드1과 스레드2는 같은 버전을 갖는 애그리거트를 읽어와 수정하고 있다.
  - 두 스레드 중 스레드1이 먼저 커밋을 시도한다.
  - 이 시점에 애그리거트의 버전은 여전히 5이므로 애그리거트 수정에 성공하고 버전은 6이 된다.
  - 스레드1이 트랜잭션을 커밋한 후에 스레드2가 커밋을 시도하는데, 이미 애그리거트 버전이 6이므로 스레드2는 데이터 수정에 실패하게 된다. 
- JPA는 버전을 이용한 비선점 잠금 기능을 지원한다.
  - 다음과 같이 버전으로 사용할 필드에 @Version 애노테이션을 붙이고 매핑되는 테이블에 버전을 저장할 칼럼을 추가하기만 하면 된다.
  ```java
  @Entity
  @Table(name = "purchase_order")
  @Access(AccessType.FIELD)
  public class Order {
    @EmbeddedId
    private OrderNo number;

    @Version
    private long version;
  }
  ```

- JPA는 엔티티가 변경되어 UPDATE 쿼리를 실행할 때 @Version에 명시한 필드를 이용해서 비선점 잠금 쿼리를 실행한다.
  - 즉, 애그리거트 객체의 버전이 10이면 UPDATE 쿼리를 실행할 때 다음과 같이 쿼리를 사용해서 버전이 일치하는 경우에만 데이터를 수정한다.
  ```
  UPDATE purchase_order SET ...생략, version = version +1
  WHERE number = ? and version = 10
  ``` 

- 응용 서비스는 버전에 대해 알 필요가 없다.
  - 리포지터리에서 필요한 애그리거트를 구하고 알맞은 기능만 실행하면 된다.
  - 기능을 실행하는 과정에서 애그리거트의 데이터가 변경되면 JPA는 트랜잭션 종료 시점에 비선점 잠금을 위한 쿼리를 실행한다.



```java
public class ChangeShippingService {
  
  @Transactional
  public void changeShipping(ChangeShippingRequest changeReq) {
    Order order = orderRepository.findById(new OrderNo(changeReq.getNum()));
    checkNoOrder(order);
    order.changeShippingInfo(changeReq.getShippingInfo());
  }
}
``` 
- 비선점 잠금을 위한 쿼리를 실행할 때 쿼리 실행 결과로 수정된 행의 개수가 0이면 이미 누군가 앞서 데이터를 수정한 것이다.
  - 이는 트랜잭션이 충돌한 것이므로 트랜잭션 종료 시점에 익셉션이 발생한다.
  - 위 코드의 경우 스프링의 @Transactional을 이용해서 트랜잭션 범위를 정했으므로 changeShipping() 메서드가 리턴될 때 트랜잭션이 종료되고, 이 시점에 트랜잭션 충돌이 발생하면 OptimisticLockingFailureException을 발생시킨다. 
- 표현 영역의 코드는 이 익셉션의 발생 여부에 따라 트랜잭션 충돌이 일어났는지 확인할 수 있다.
  ```java
  @Controller
  public class OrderController {
    private ChangeShippingService changeShippingService;

    @RequestMapping(value = "/changeShipping", method = RequestMethod.POST) 
    public String changeShipping(ChangeShippingRequest changeReq) {
      try {
        changeShippingService.changeShipping(changeReq);
        return "changeShippingSuccess";
      } catch (OptimisticLockingFailureException ex) {
        // 누군가 먼저 같은 주문 애그리거트를 수정했으므로,
        // 트랜잭션 충돌이 일어났다는 메시지를 보여준다.
        return "changeShippingTxConflict";
      }
    }
  }
  ```  
- 비선점 잠금을 아래 그림의 상황으로 확장해서 적용할 수 있다.
  - 시스템은 사용자에게 수정폼을 제공할 때 애그리거트 버전을 함께 전송하고, 사용자가 폼을 전송할때와 폼을 생성할 때 사용한 애그리거트 버전을 함께 전송하도록 할 수 있다.
  - 시스템을 아래 그림처럼 애그리거트를 수정할 때 사용자가 전송한 버전과 애그리거트 버전이 동일한 경우에만 수정 기능을 수행하도록 함으로써 트랜잭션 충돌 문제를 해소할 수 있다.
  ![image](https://user-images.githubusercontent.com/28394879/136161119-6ec1c587-5892-427f-9ed6-3016cd895c2d.png) 
  - 위 그림은 비선점 잠금을 이용한 트랜잭션 충돌 방지를 여러 트랜잭션으로 확장 한 것이다.
- 위 그림의 과정 2에서 운영자는 배송 상태 변경을 요청할 때 앞서 과정 1을 통해 받은 애그리거트의 버전 값을 함께 전송한다.
  - 시스템은 애그리거트를 읽는데 해당 시점의 버전 값도 함께 읽어온다.
  - 만약 과정 1에서 받은 버전 A와 과정 2.1을 통해 읽은 애그리거트의 버전 B가 다르면, 과정 1과 과정 2사이에 다른 사용자가 해당 애그리거트를 수정한 것이다.
  - 이 경우 시스템은 운영자가 이전 데이터를 기준으로 작업을 요청한 것으로 간주하여 과정 2.1.2과 같이 수정할 수 없다는 에러를 응답으로 전송한다.
- 만약 버전 A와 B가 같다면 과정 1과 과정 2 사이에 누구도 애그리거트를 수정하지 않은 것이다.
  - 이 경우 시스템은 과정 2.1.3과 같이 애그리거트를 수정하고, 과정 2.1.4를 이용해서 변경 내용을 DBMS에 반영한다.
  - 과정 2.1.1과 과정 2.1.4사이에 아무도 애그리거트를 수정하지 않았다면 커밋에 성공하므로 성공 결과를 응답으로 전송한다.
- 반면에 과정 2.1.1과 과정 2.1.4 사이에 누군가 애그리거트를 수정해서 커밋했다면 버전 값이 증가한 상태가 되므로 트랜잭션 커밋에 실패하고, 결과로 에러 응답을 전송한다.
- 위의 그림과 같이 비선점 잠금 방식을 여러 트랜잭션으로 확장하려면 애그리거트 정보를 뷰로 보여줄 때 버전 정보도 함께 사용자 화면에 전달해야 한다.
  - HTML 폼을 생성하는 경우 버전 값을 갖는 hidden 타입 <input> 태그를 생성해서 폼 전송 시 버전 값이 서버에 함께 전달되도록 한다.
  ```html
  <!-- 애그리거트 정보를 보여줄 때 뷰 코드는 버전 값을 함께 전송한다. -->
  <form action="startShipping" method="post">
  <input type="hidden" name="version" value="${orderDto.version}">
  <input type="text" name="orderNumber" value="${orderDto.orderNumber}" readonly>
  ... 
  <input type="submit" value = "배송 상태로 변경하기">
  </form>
  ``` 
- 사용자 요청을 처리하는 응용 서비스를 위한 요청 데이터는 사용자가 전송한 버전 값을 포함한다.
  - 예) 배송 상태 변경을 처리하는 응용 서비스가 전달받는 데이터는 다음과 같이 주문 번호와 함께 해당 주문을 조회한 시점의 버전 값을 포함해야 한다.
  ```java
  public class StartShippingRequest {
    private String orderNumber;
    private long version;

    ...생성자, getter
  }
  ``` 

- 응용 서비스는 전달받은 버전 값을 이용해서 애그리거트의 버전과 일치하는지 확인하고 일치하는 경우에만 요청한 기능을 수행한다.
  ```java
  public class StartShippingService {
    
    @PreAuthoriza("hasRole('ADMIN')")
    @Transactional
    public void startShipping(StartShippingRequest req) {
      Order order = orderRepository.findById(new OrderNo(req.getOrderNumber()));
      checkOrder(order);
      if (!order.matchVersion(req.getVersion()) {
        throw new VersionConflictException();
      }
      order.startShipping();
    }
  }
  ``` 

- Order#matchVersion(long version) 메서드는 현재 애그리거트의 버전과 인자로 전달 받은 버전이 일치하면 true를 리턴하고 그렇지 않으면 false를 리턴하도록 구현한다.
  - matchVersion()의 결과가 true가 아니면 버전이 일치하지 않는 것이므로 사용자가 이전 버전의 애그리거트 정보를 바탕으로 상태 변경을 요청한 것이다.
  - 따라서 응용 서비스는 버전이 충돌했다는 익셉션을 발생시켜 표현 계층에 이를 알린다.
- 표현 계층은 버전 충돌 익셉션이 발생하면 버전 충돌을 사용자에게 알려주고 사용자가 알맞은 후속 처리를 할 수 있도록 한다.

```java
@Controller
public class OrderAdminController {
  private StartShippingService startShippingService;

  @RequestMapping(value = "/startShipping", method = RequestMethod.POST) 
  public String startShipping(StartShippingRequest startReq) {
    try {
      startShippingService.startShipping(startReq);
      return "shippingStarted";
    } catch (OptimisticLockingFailureException | VersionConflictException ex) {
      // 트랜잭션 충돌
      return "startShippingTxConflict";
    }
  }
}
``` 
- 이 코드는 비선점 잠금과 관련해서 발생하는 두 개의 익셉션을 처리하고 있다.
  - 하나는 스프링 프레임워크가 발생시키는 OptimisticLockingFailureException 이고, 다른 하나는 응용 서비스 코드에서 발생시키는 VersionConflictException 이다.
  - 이 두 익셉션은 개발자 입장에서 트랜잭션 충돌이 발생한 시점이 다른 것을 명확하게 해준다.
  - VersionConflictException은 이미 누군가 애그리거트를 수정했다는 것을 의미하고, OptimisticLockingFailureException은 누군가 거의 동시에 애그리거트를 수정했다는 것을 의미한다.
- 버전 충돌 상황에 대한 구분이 명시적으로 필요 없다면 응용 서비스에서 프레임워크용 익셉션을 발생시키도록 구현해도 된다.
  ```java
  public void startShipping(StartShippingRequest req) {
    Order order = orderRepository.findById(new OrderNo(req.getOrderNumber()));
    checkOrder(order);
    if(!order.matchVersion(req.getVersion())) {
      // 프레임워크가 제공하는 비선점 트랜잭션 충돌 관련 익셉션 사용 
      throw new OptimisticLockingFailureException("version conflict");
    }
    order.startShipping();
  }
  ``` 

### 강제 버전 증가
- 애그리거트에 애그리거트 루트 외에 다른 엔티티가 존재하는데 기능 실행 도중 루트가 아닌 다른 엔티티의 값만 변경된다고 하자.
  - 이 경우 JPA는 루트 엔티티의 버전 값을 증가하지 않는다.
  - 연관된 엔티티의 값이 변경된다고 해도 루트 엔티티 자체의 값은 바뀌는 것이 없으므로 루트 엔티티의 버전 값을 갱신하지 않는 것이다. 
- 그런데, 이런 JPA 특징은 애그리거트 관점에서 보면 문제가 된다.
  - 비록 루트 엔티티의 값이 바뀌지 않았더라도 애그리거트의 구성요소 중 일부 값이 바뀌면 논리적으로 그 애그리거트는 바뀐 것이다.
  - 따라서, 애그리거트 내에 어떤 구성요소의 상태가 바뀌면 루트 애그리거트의 버전 값을 증가해야 비선점 잠금이 올바르게 동작한다.
- JPA는 이런 문제를 처리할 수 있도록 EntityManager#find() 메서드로 엔티티를 구할 때 강제로 버전 값을 증가시키는 잠금 모드를 지원하고 있다.
  - 다음은 비선점 강제 버전 증가 잠금 모드를 사용해서 엔티티를 구하는 코드의 작성 예를 보여주고 있다.
  ```java
  @Repository
  public class JpaOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Order findByIdOptimisticLockMode(OrderNo id) {
      return entityManager.find(
        Order.class, id, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
      )
    }
  }
  ``` 
- LockModeType.OPTIMISTIC_FORCE_INCREMENT을 사용하면 해당 엔티티의 상태가 변경되었는지 여부에 상관없이 트랜잭션 종료 시점에 버전 값 증가 처리를 한다.
  - 이 잠금 모드를 사용하면 애그리거트 루트 엔티티가 아닌 다른 엔티티나 밸류가 변경되더라도 버전 값을 증가시킬 수 있으므로 비선점 잠금 기능을 안전하게 적용할 수 있다.
 

</details>

<details> <summary> 4. 오프라인 선점 잠금 </summary>

## 4. 오프라인 선점 잠금

- 지라(Jira)로 유명한 아틀라시안의 컨플루언스 위키는 문서를 편집하려고 할 때, 누군가 먼저 편집을 하는 중이면 다른 사용자가 문서를 수정하고 있다는 안내 문구를 보여준다.
  - 이런 안내를 통해 여러 사용자가 동시에 한 문서를 수정할 때 발생하는 충돌을 사전에 방지할 수 있도록 한다.

- 컨플루언스 위키는 사전에 충돌 여부를 알려주지만 동시에 수정하는 것을 막지는 않는다.
  - 더 엄격하게 데이터 충돌을 막고 싶다면 누군가 수정 화면을 보고 있을 때 수정 화면 자체를 실행하지 못하도록 해야 한다.
  - 한 트랜잭션 범위에서만 적용되는 선점 잠금 방식이나, 나중에 버전 충돌을 확인하는 비선점 잠금 방식으로는 이를 구현할 수 없다.
  - 이때 필요한 것이 오프라인 선점 잠금 방식(Offline Pessimistic Lock) 이다.
- 단일 트랜잭션에서 동시 변경을 막는 선점 잠금 방식과 달리 오프라인 선점 잠금은 여러 트랜잭션에 걸쳐 동시 변경을 막는다.
  - 첫 번째 트랜잭션을 시작할 때 오프라인 잠금을 선점하고, 마지막 트랜잭션에서 잠금을 해제한다. 
  - 잠금을 해제하기 전까지 다른 사용자는 잠금을 구할 수 없다.
- 예) 수정 기능 
  - 보통 수정 기능은 두 개의 트랜잭션으로 구성된다.
  - 첫 번째 트랜잭션은 폼을 보여주고, 두 번째 트랜잭션은 데이터를 수정한다.
  - 오프라인 선점 잠금을 사용하면 아래 사진의 과정 1처럼 폼 요청 과정에서 잠금을 선점하고, 과정 3처럼 수정 과정에서 잠금을 해제한다.
  - 이미 잠금을 선점한 상태에서 다른 사용자가 폼을 요청하면 과정 2처럼 잠금을 구할 수 없어 에러 화면을 보게 된다.
   
  ![image](https://user-images.githubusercontent.com/28394879/136178782-8708598c-b5a8-4766-b659-f33e5f656f94.png) 
- 위의 그림에서 사용자 A가 과정 3의 수정 요청을 수행하지 않고 프로그램을 종료하면 어떻게 될까?
  - 이 경우 잠금을 해제하지 않으므로 다른 사용자는 영원히 잠금을 구할 수 없는 상황이 발생한다.
  - 이런 사태를 방지하기 위해 오프라인 선점 방식은 잠금의 유효 시간을 가져야 한다.
  - 유효 시간이 지나면 자동으로 잠금을 해제해서 다른 사용자가 잠금을 일정 시간 후에 다시 구할 수 있도록 해야 한다.
- 사용자 A가 잠금 유효 시간이 지난 후 1초 뒤에 3번 과정을 수행했다고 가정하자.
  - 잠금을 해제되어 사용자 A는 수정에 실패하게 된다.
  - 이런 상황을 만들지 않으려면 일정 주기로 유효 시간을 증가시키는 방식이 필요하다.
  - 예) 수정 폼에서 1분 단위로 Ajax 호출을 해서 잠금 유효 시간을 1분씩 증가시키는 방법이 있다.

### 오프라인 선점 잠금을 위한 LockManager 인터페이스와 관련 클래스 

- 오프라인 선점 잠금은 크게 잠금 선점 시도, 잠금 확인, 잠금 해제, 락 유효 시간 연장의 네가지 기능을 제공해야 한다.
  - 이 기능을 위한 LockManager 인터페이스는 다음과 같다.
  ```java
  package com.myshop.lock;

  public interface LockManager {
    LockId tryLock(String type, String id) throws LockException;
    void checkLock(LockId lockId) throws LockException;
    void releaseLock(LockId lockId) throws LockException;
    void extendLockExpiration(LockId lockId, long inc) throws LockException;
  }
  ``` 

- tryLock() 메서드는 type과 id를 파라미터로 갖는다.
  - 이 두 파라미터에는 각각 잠글 대상 타입과 식별자를 값으로 잔달하면 된다.
  - 예) 식별자가 10인 Article에 대한 잠금을 구하고 싶다면 tryLock()을 실행할 때 'domain.Article' 을 type값으로 주고 '10'을 id값으로 주면 된다.
  - tryLock()은 LockId를 리턴하는데 LockId는 잠금을 식별할 때 사용한다.
  - 각 락마다 고유 식별자를 갖도록 구현한 것이다.
  - 일단 잠금을 구하면 잠금을 해제하거나, 잠금이 유효한지 검사하거나, 잠금의 유효 시간을 늘릴 때 LockId를 사용한다.
  - LockId의 코드는 다음과 같다.
  ```java
  package com.myshop.lock;

  public class LockId {
    private String value;

    public LockId(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }
  ``` 

- 오프라인 선점 잠금이 필요한 코드는 LockManager#tryLock()을 이용해서 잠금 선점을 시도한다.
  - 잠금 선점에 성공하면 tryLock()은 LockId를 리턴한다.
  - 이 LockId는 다음에 잠금을 해제할 때 사용한다.
  - LockId가 없으면 잠금을 해제할 수 없으므로 LockId를 어딘가에 보관해야 한다.
- 다음은 컨트롤러가 오프라인 선점 잠금 기능을 이용해서 데이터 수정 폼에 동시에 접근하는 것을 제어하는 코드의 예를 보여주고 있다. 
  - 수정 폼에서 데이터를 전송할 때 LockId를 전송할 수 있도록 LockId를 모델에 추가했다.
  ```java
  @RequestMapping("/some/edit/{id}")
  public String editForm(@PathVariable("id") Long id, ModelMap model) {
    // 1. 오프라인 선점 잠금 시도
    LockId lockId = lockManager.tryLock("data",id);

    // 2. 기능 실행
    Data data = someDao.select(id);
    model.addAttribute("data", data);
    
    // 3. 잠금 해제에 사용할 LockId를 모델에 추가
    model.addAttribute("lockId", lockId);

    return "editForm";
  }
  ``` 

- 잠금을 선점하는데 실패하면 LockException이 발생하는데, 이 때는 다른 사용자가 데이터를 수정 중이니 나중에 다시 시도해 보라는 안내 화면을 보여주면 된다.
- 수정 폼은 LockId를 다시 전송해서 잠금을 해제할 수 있도록 한다.
  ```html
  <form action="/some/edit/${data.id}" method="post">
    ...
    <input type="hidden" name="lid" value="${lockId.value}">
    ...
  </form>
  ```  

- 잠금을 해제하는 코드는 다음과 같이 전달받은 LockId를 이용한다.
  ```java
  @RequestMapping(value = "/some/edit/{id}", method = RequestMethod.POST)
  public String edit(@PathVariable("id") Long id, @ModelAttribute("editReq") EditRequest editReq,
  @RequestParam("lid") String lockIdValue) {
    editReq.setId(id);

    // 1. 잠금 선점 확인
    LockId lockId = new LockId(lockIdValue);  
    lockManager.checkLock(lockId);

    // 2. 기능 실행
    someEditService.edit(editReq);
    model.addAttribute("data", data);

    // 3. 잠금 해제
    lockManager.releaseLock(lockId);

    return "editSuccess";
  }
  ``` 

- 위 코드를 보면 LockManager#chekcLock() 메서드를 가장 먼저 실행하는데, 잠금을 선점한 이후에 실행하는 기능은 다음과 같은 상황을 고려해서 반드시 주어진 LockId를 갖는 잠금이 유효한지 검사해야 한다.
  - 잠금의 유효 시간이 지났으면 이미 다른 사용자가 잠금을 선점한다.
  - 잠금을 선점하지 않은 사용자가 기능을 실행했다면 기능 실행을 막아야 한다.


### DB를 이용한 LockManager 구현
- DB를 이용한 LockManager를 구현해보자.
  - 잠금 정보를 저장할 테이블과 인덱스를 다음과 같이 생성한다.
  - 이 쿼리는 MySQL용이므로 다른 DBMS를 사용한다면 해당 DBMS에 맞게 변형해서 사용해야 한다.
  ```sql
  create table locks (
    `type` varchar(255),
    id varchar(255),
    lockid varchar(255),
    expiration_time datetime,
    primary key (`type`, id)
  ) character set utf8;

  create unique index locks_idx ON locks (lockid);
  ``` 
- Order 타입의 1번 식별자를 갖는 애그리거트에 대한 잠금을 구하고 싶다면 다음의 insert 쿼리를 이용해서 locks 테이블에 데이터를 삽입하면 된다.
  `insert into locks values ('Order', '1', '생성한lockid', '2016-03-28 09:10:00');`
- 'type'과 'id' 칼럼을 주요 키로 지정했는데, 이를 통해 동시에 두 사용자가 특정 타입의 데이터에 대한 잠금을 구하는 것을 방지했다. 
  - 각 잠금마다 새로운 LockId를 사용하므로 lockid 필드를 유니크 인덱스로 설정했다. 
  - 잠금의 유효 시간을 보관하기 위해 expiration_time 칼럼을 사용한다.
- locks 테이블의 데이터를 담을 LockData 클래스를 다음과 같이 작성한다.
  ```java
  package com.myshop.lock;
  
  public class LockData {
    private String type;
    private String id;
    private String lockId;
    private long expirationTime;
    
    public LockData(String type, String id, String lockId, long expirationTime) {
      this.type = type;
      this.id = id;
      this.lockId = lockId;
      this.expirationTime = expirationTime;
    }

    public String getType() {
      return type;
    }

    public String getId() {
      return id;
    }

    public String getLockId() {
      return lockId;
    }

    public long getExpirationTime() {
      return expirationTime;
    }

    public boolean isExpired() {
      return expirationTime < System.currenTimeMillis();
    }
  }
  ``` 
- isExpired() 메서드는 유효 시간이 지났는지 여부를 판단할 때 사용한다.
- locks 테이블을 이용해서 LockManager를 구현한 코드는 길이가 다소 길어서 나눠서 표시했다.
  - 먼저 가장 긴 tryLock()부분은 아래 코드와 같다.
  - DB 연동은 스프링이 제공하는 JdbcTemplate을 이용해서 처리 했다.
  ```java
  @Component
  public class SpringLockManager implements LockManager {
    private int lockTimeout = 5 * 60 * 1000;
    private JdbcTemplate jdbcTemplate;

    private RowMapper<LockData> lockDataRowMapper = (rs, rowNum) -> new LockData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4).getTime());

    @Transactional
    @Override
    public LockId tryLock(String type, String id) throws LockException {
      checkAlreadyLocked(type, id);
      LockId lockId = new LockId(UUID.randomUUID().toString());
      locking(type, id, lockId);
      return lockId;
    }

    private void checkAlreadyLocked(String type, String id) {
      List<LockData> locks = jdbcTemplate.query(
            "select * from locks where type = ? and id = ?",
            lockDataRowMapper, type, id);
      Optional<LockData> lockData = handleExpiration(locks);
      if (lockData.isPresent()) throw new AlreadyLockedException();
    }

    private void Optional<LockData> handleExpiration(List<LockData> locks) {
      if(locks.isEmpty()) return Optional.empty();
      LockData lockData = locks.get(0);

      if(lockData.isExpired()) {
        jdbcTemplate.update(
            "delete from locks where type = ? and id = ?",
            lockData.getType(), lockData.getId());
        return Optional.empty();
      } else {
        return Optional.of(lockData);
      }
    }

    private void locking(String type, String id, LockId lockId) {
      try {
        int updatedCount = jdbcTemplate.update(
          "insert into locks values (?,?,?,?)",
          type,id,lockId.getValue(), new Timestamp(getExpirationTime()));
        if (updatedCount ==0) throw new LockingFailException();
      } catch (DuplicateKeyException e) {
        throw new LockingFailException(e);
      }
    }

    private long getExpirationTime() {
      return SYstem.currentTimeMillis() + lockTimeout;
    }
  }
  ``` 

**코드 설명**

- lockDataRowMapper 변수: locks 테이블에서 조회한 데이터를 LockData로 매핑하기 위한 RowMappr이다.
- tryLock() 함수: type과 id에 대한 잠금을 시도 한다.
  - checkAlreadyLocked(type, id) 로 해당 type과 id에 잠금이 존재하는지 검사한다.
  - new LockId()로 새로운 LockId를 생성한다. 매번 새로운 LockId를 생성해야 하는데 여기서는 UUID를 이용했다.
  - locking(..) 으로 잠금을 생성한다.
  - return lockId; 는 LockId를 리턴한다.
- checkAlreadyLocked() 함수: 잠금이 존재하는지 검사한다.
  - jdbcTemplate.query로 locks 테이블에서 type과 id에 대한 데이터를 조회한다.
  - handleExpiration으로 유효 시간이 지난 데이터를 처리한다.
  - isPresent를 활용해 유효 시간이 지나지 않은 LockData가 존재하면 익셉션이 발생한다.
- handleExpiration() 함수
  - 잠금의 유효 시간이 지나면 해당 데이터를 삭제하고 값이 없는 Optional을 리턴한다.
  - 유효 시간이 지나지 않았으면 해당 LockData를 가진 Optional을 리턴한다.
- locking() 함수
  - jdbcTEmplate.update쿼리로 잠금을 위해 locks 테이블에 데이터를 삽입하고 데이터 삽입 결과가 없으면 new LockingFailException 익셉션이 발생한다.
  - 동일한 주요 키나 lockid를 가진 데이터가 이미 존재한다면 DuplicateKeyException이 발생하는데, 이 경우에도 익셉션을 발생시킨다.
- getExpirationTime()
  - 현재 시간 기준으로 lockTimeout 이후 시간을 유효 시간으로 생성한다.
 
 - 코드가 다소 복잡한데 tryLock() 메서드를 기준으로 전체 흐름을 살펴보면 checkAlreadyLocked() 메서드를 이용해서 이미 잠금이 선점됐는지 확인하고 locking() 메서드로 잠금을 선점한다.



 - SpringLockManager의 나머지 구현 코드는 다음과 같다.
   ```java
   @Override
   public void checkLock(LockId lockId) throws LockException {
     Optional<LockData> lockData = getLockData(lockId);
     if (!lockData.isPresent()) throw new NoLockException();
   }
   
   private Optional<LockData> getLockData(LockId lockId) {
     List<LockData> locks = jdbcTemplate.query(
            "select * from locks where lockid = ?",
            lockDataRowMapper, lockId.getValue());
     return handleEpiration(locks);
   }

   @Transactional
   @Override
   public void extendLockExpiration(LockId lockId, long inc) throws LockException {
    Optional<LockData> lockDataOpt = getLockData(lockId);
    LockData lockData = lockDataOpt.orElseThrow(() -> new NoLockException());
    jdbcTemplate.update(
          "update locks set expiration_time = ? where type = ? AND id = ?",
          new Timestamp(lockData.getTimestamp() + inc),
          lockData.getType(), lockData.getId());
   }

   @Transactional
   @Override
   public void releaseLock(LockId lockId) throws LockException {
     jdbcTemplate.update("delete from locks where lockid= ?", lockId.getValue());
   }

   @Autowired
   public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
     this.jdbcTemplate = jdbcTemplate;
   }
   ```  

**코드 설명**

- checkLock() 함수: 잠금이 유효한지 검사한다. 잠금이 존재하지 않으면 익셉션이 발생한다.
- getLockData() 함수: LockId에 해당하는 LockData를 구한다. handleExpiration()를 이용 해서 유효 시간이 지난 LockData를 처리한다. handleExpiration() 메서드는 이전코드를 참고한다.
- extendLockExpiration() 함수: lockId에 해당하는 잠금 유효 시간을 inc만큼 늘린다.
- releaseLock() 함수: LockId에 해당하는 잠금 데이터를 locks 테이블에서 삭제한다.
 

 

</details>




# 9. 도메인 모델과 BOUNDED CONTEXT

<details> <summary> 1. 도메인 모델과 경계 </summary>

## 1. 도메인 모델과 경계
- 처음 도메인 모델을 만들 때 빠지기 쉬운 함정이 도메인을 완벽하게 표현하는 단일 모델을 만드는 시도를 하는 것이다.
  - 그런데 1장에서 정리한 것 처럼 한 도메인은 다시 여러 하위 도메인으로 구분되기 떄문에 한 개의 모델로 여러 하위 도메인을 모두 표현하려고 시도하게 되면 모든 하위 도메인에 맞지 않는 모델을 만들게 된다.
- 예) 상품 모델
  - 카탈로그에서의 상품, 재고 관리에서의 상품, 주문에서의 상품, 배송에서의 상품은 이름만 같지 실제로 의미하는 것이 다르다.
  - 카탈로그에서의 상품은 상품 이미지, 상품명, 상품 가격, 옵션 목록, 상세 설명과 같은 상품 정보가 위주라면, 재고 관리에서의 상품은 실존하는 개별 객체를 추적하기 위한 목적으로 상품을 사용한다.
  - 즉, 카탈로그에서 물리적으로 한 개인 상품이 재고 관리에서는 여러 개 존재 할 수 있다.
- 논리적으로 같은 존재처럼 보이지만 하위 도메인에 따라 다른 용어를 사용하는 경우도 있다.
  - 카탈로그 도메인에서 상품이 검색 도메인에서는 문서로 불리기도 한다.
  - 비슷하게 시스템을 사용하는 사람을 회원 도메인에서는 회원으로 부르지만, 주문 도메인에서는 주문자라고 부르고, 배송 도메인에서는 보내는 사람이라 부르기도 한다.
  
  ![image](https://user-images.githubusercontent.com/28394879/136505922-16d3fb0b-ca21-4d42-8233-c17a0c4c0a24.png)

- 이렇게 하위 도메인마다 같은 용어라도 의미가 다르고 같은 대상이라도 지칭하는 용어가 다를 수 있기 때문에 한 개의 모델로 모든 하위 도메인을 표현하려는 시도는 올바른 방법이 아니며 표현할 수도 없다.
- 하위 도메인마다 사용하는 용어가 다르기 때문에 올바른 도메인 모델을 개발하려면 하위 도메인마다 모델을 만들어야 한다.
  - 각 모델은 명시적으로 구분되는 경계를 가져서 섞이지 않도록 해야 한다.
  - 여러 하위 도메인의 모델이 섞이기 시작하면 모델의 의미가 약해질 뿐만 아니라 여러 도메인의 모델이 서로 얽혀 있기 때문에 각 하위 도메인별로 다르게 발전하는 요구사항을 모델에 반영하기 어려워진다.
- 모델은 특정한 컨텍스트(문맥)하에서 완전한 의미를 갖는다.
  - 같은 제품이라도 카탈로그 컨텍스트와 재고 컨텍스트에서 의미가 서로 다르다.
  - 이렇게 구분되는 경계를 갖는 컨텍스트를 DDD에서는 BOUNDED CONTEXT라고 부른다.


> BOUNDED CONTEXT를 우리말로 번역하면 경계를 갖는 컨텍스트라고 다소 길게 번역할 수 있지만 DDD 용어가 잘 드러나지 않는다.
> 한글로 바운디드 컨텍스트라고 표기하는 것도 어색하기 때문에 여기서는 BOUNDED CONTEXT라는 영문을 그대로 사용했다.

</details>

<details> <summary> 2. BOUNDED CONTEXT </summary>

## 2. BOUNDED CONTEXT
- BOUNDED CONTEXT는 모델의 경계를 결정하며 한 개의 BOUNDED CONTEXT는 논리적으로 한 개의 모델을 갖는다.
  - BOUNDED CONTEXT는 용어를 기준으로 구분한다.
  - 카탈로그 컨텍스트와 재고 컨텍스트는 서로 다른 용어를 사용하므로 이 용어를 기준으로 컨텍스트를 분리할 수 있다.
  - 또한, BOUNDED CONTEXT는 실제로 사용자에게 기능을 제공하는 물리적 시스템으로 도메인 모델은 이 BOUNDED CONTEXT 안에서 도메인을 구현한다.
- 이상적으로 하위 도메인과 BOUNDED CONTEXT가 일대일 관계를 가지면 좋겠지만 현실은 그렇지 않을 때가 많다.
  - BOUNDED CONTEXT가 기업의 팀 조직 구조에 따라 결정되기도 한다.
  - 예) 주문 하위 도메인이라도 주문을 처리하는 팀과 복잡한 결제 금액 계산 로직을 구현하는 팀이 따로 있을떄 
  - 이 경우 주문 하위 도메인에 주문 BOUNDED CONTEXT와 결제 금액 계산 BOUNDED CONTEXT가 존재하게 된다.
  - 아직 용어를 명확하게 하지 못해 두 하위 도메인을 한 BOUNDED CONTEXT에서 구현하기도 한다.
  - 카탈로그와 재고 관리가 아직 명확하게 구분 되지 않은 경우 두 하위 도메인을 한 BOUNDED CONTEXT에서 구현하기도 한다. 
  ![image](https://user-images.githubusercontent.com/28394879/136515034-f8a3da41-caea-44d1-b35b-498da8478e35.png)

- 규모가 작은 기업은 전체 시스템을 한 개 팀에서 구현할 때도 있다.
  - 예) 소규모 쇼핑몰을 운영할 경우 한 개의 웹 애플리케이션으로 온라인 쇼핑을 서비스한다.
  - 이 경우 하나의 시스템에서 회원, 카탈로그, 재고, 구매, 결제와 관련된 기능을 제공한다.
  - 즉, 여러 하위 도메인을 한 개의 BOUNDED CONTEXT에서 구현한다.
- 여러 하위 도메인을 하나의 BOUNDED CONTEXT에서 개발할 때 주의할 점은 하위 도메인의 모델이 뒤섞이지 않도록 하는 것이다.
  - 한 개의 이클립스 프로젝트에 각 하위 도메인의 모델이 위치하면 아무래도 전체 하위 도메인을 위한 단일 모델을 만들고 싶은 유혹에 빠지기 쉽다.
  - 이런 유혹에 걸려들면 결과적으로 도메인 모델이 개별 하위 도메인을 제대로 반영하지 못해서 하위 도메인별 기능 확장이 어렵게 되고 이는 서비스의 경쟁력을 떨어뜨리는 원인이 된다.
  - 따라서, 비록 한 개의 BOUNDED CONTEXT에서 여러 하위 도메인을 포함하더라도 하위 도메인마다 구분되는 패키지를 갖도록 구현해야 하위 도메인을 위한 모델이 서로 뒤섞이지 않아서 하위 도메인마다 BOUNDED CONTEXT를 갖는 효과를 낼 수 있다.
   
  ![image](https://user-images.githubusercontent.com/28394879/136520353-2fc863da-f044-4b7e-a346-893c6c0acaa4.png)
  
- BOUNDED CONTEXT는 도메인 모델을 구분하는 경계가 되기 떄문에 BOUNDED CONTEXT는 구현하는 하위 도메인에 알맞은 모델을 포함한다.
  - 같은 사용자라 하더라도 주문 BOUNDED CONTEXT와 회원 BOUNDED CONTEXT가 갖는 모델이 달라 진다.
  - 또한, 같은 상품이라도 카탈로그 BOUNDED CONTEXT의 Product와 재고 BOUNDED CONTEXT의 Product는 각 컨텍스트에 맞는 모델을 갖는다.
  - 따라서 회원의 Member는 애그리거트 루트이지만 주문의 Orderer는 밸류가 되고 카탈로그의 Product는 상품이 속할 Category와 연관을 갖지만 재고의 Product는 카탈로그의 Category와 연관을 맺지 않는다.
   
  ![image](https://user-images.githubusercontent.com/28394879/136522621-002bf778-ae39-4c97-9b5e-c11fc62c17a2.png)
   

</details>

<details> <summary> 3. BOUNDED CONTEXT의 구현 </summary>

## 3. BOUNDED CONTEXT의 구현
- BOUNDED CONTEXT가 도메인 모델만 포함하는 것은 아니다.
  - BOUNDED CONTEXT는 도메인 모델뿐만 아니라 도메인 기능을 사용자에게 제공하는 데 필요한 표현 영역, 응용 서비스, 인프라 영역 등을 모두 포함한다.
  - 도메인 모델의 데이터 구조가 바뀌면 DB테이블 스키마도 함께 변경해야 하므로 해당 테이블도 BOUNDED CONTEXT에 포함된다. 
  ![image](https://user-images.githubusercontent.com/28394879/136524349-e8ee8942-e166-4120-98dd-d7704deb960f.png)

- 표현 영역은 인간 사용자를 위해 HTML 페이지를 생성할 수도 있고 다른 BOUNDED CONTEXT를 위해 REST API를 제공할 수도 있다.
- 모든 BOUNDED CONTEXT를 반드시 도메인 주도로 개발할 필요는 없다.
  - 상품의 리뷰는 복잡한 도메인 로직을 갖지 않기 때문에 CRUD 방식으로 구현해도 된다.
  - 즉, DAO와 데이터 중심의 밸류 객체를 이용해서 리뷰 기능을 구현해도 기능을 유지보수하는 데 큰 문제가 없다
  ![image](https://user-images.githubusercontent.com/28394879/136525202-7c49707d-a18f-494b-b6dc-a3863ad7c88a.png)
  
- 서비스-DAO 구조를 사용하면 도메인 기능이 서비스에 흩어지게 되지만 도메인 기능 자체가 단순하면 서비스-DAO로 구성된 CRUD 방식을 사용해도 코드를 유지보수하는 데 문제되지 않는다.
- 한 BOUNDED CONTEXT에서 두 방식을 혼합해서 사용할 수도 있다.
  - 대표적인 예가 CQRS 패턴이다.
  - CQRS는 Command Query Reponsibility Segregation의 약자로 상태를 변경하는 명령 기능과 내용을 조회하는 쿼리 기능을 위한 모델을 구분하는 패턴이다.
  - 이 패턴을 단일 BOUNDED CONTEXT에 적용하면 아래 그림과 같이 상태 변경과 관련된 기능은 도메인 모델 기반으로 구현하고 조회 기능은 서비스-DAO를 이용해서 구현할 수 있다.
  ![image](https://user-images.githubusercontent.com/28394879/136526181-98f8052e-3b25-441f-8b17-62518dbc7aa9.png)

- CQRS에 대한 내용은 11장에서 다시 살펴보도록 하자.

- 각 BOUNDED CONTEXT는 서로 다른 구현 기술을 사용할 수도 있다.
  - 웹 MVC는 스프링 MVC를 사용하고 리포지터리 구현 기술로는 JPA/하이버네이트를 사용하는 BOUNDED CONTEXT가 존재하고, Netty를 이용해서 REST API를 제공하고 MyBatis를 리포지터리 구현 기술로 사용하는 BOUNDED CONTEXT가 존재할 수도 있다.
  - 어떤 BOUNDED CONTEXT는 RDBMS 대신 HBase나 몽고DB와 같은 NoSQL을 사용할 수도 있을 것이다.
- BOUNDED CONTEXT가 반드시 사용자에게 보여지는 UI를 가져야 하는 것은 아니다.
  - 예) 상품 상세 정보를 보여주는 페이지
  - 웹 브라우저는 아래 그림과 같이 카탈로그 BOUNDED CONTEXT를 통해 상세 정보를 읽어온 뒤, 리뷰 BOUNDED CONTEXT의 REST API를 직접 호출해서 로딩한 JSON 데이터를 알맞게 가공해서 리뷰 목록을 보여줄 수도 있다. 
  ![image](https://user-images.githubusercontent.com/28394879/136530167-88eae370-7493-4063-93fb-659e7d8beb89.png)


- 아래그림과 같이 UI를 처리하는 서버를 두고 UI 서버에서 BOUNDED CONTEXT와 통신해서 사용자 요청을 처리하는 방법도 있다.
  ![image](https://user-images.githubusercontent.com/28394879/136530572-35ca200a-9bc8-4497-90c8-f47e63fe029c.png)
  - 이 구조에서 UI 서버는 각 BOUNDED CONTEXT를 위한 파사드(Facede) 역할을 수행한다.
  - 브라우저가 UI 서버에 요청을 보내면 UI 서버는 카탈로그와 리뷰 BOUNDED CONTEXT로부터 필요한 정보를 읽어와 조합한 뒤 브라우저에 응답을 제공한다.
  - 각 BOUNDED CONTEXT는 UI 서버와 통신하기 위해 HTTP, Protobuf, Thrift와 같은 방식을 이용할 수 있을 것이다.
 
   
   


</details>

<details> <summary> 4. BOUNDED CONTEXT간 통합 </summary>

## 4. BOUNDED CONTEXT간 통합

- 온라인 쇼핑 사이트에서 매출 증대를 위해 카탈로그 하위 도메인에 개인화 추천 기능을 도입하기로 했다고 하자.
  - 기존 카탈로그 시스템을 개발하던 팀과 별도로 추천 시스템을 담당하는 팀이 새로 생겨서 이 팀에서 주도적으로 추천 시스템을 만들기로 했다.
  - 이렇게 되면 카탈로그 하위 도메인에는 기존 카탈로그를 위한 BOUNDED CONTEXT와 추천 기능을 위한 BOUNDED CONTEXT가 생긴다.
  ![image](https://user-images.githubusercontent.com/28394879/136876119-3488f716-f4aa-487c-9cb0-c0a2a3c8ca7c.png)

- 두 팀이 관련된 BOUNDED CONTEXT를 개발하면 자연스럽게 두 BOUNDED CONTEXT 간 통합이 발생한다.
  - 카탈로그와 추천 BOUNDED CONTEXT 간 통합이 필요한 기능은 다음과 같다.
  - 사용자가 제품 상세 페이지를 볼 때, 보고 있는 상품과 유사한 상품 목록을 하단에 보여준다
- 사용자가 카탈로그 BOUNDED CONTEXT에 추천 제품 목록을 요청하면 카탈로그 BOUNDED CONTEXT는 추천 BOUNDED CONTEXT로부터 추천 정보를 읽어와 추천 제품 목록을 제공한다.
  - 이때 카탈로그 컨텍스트와 추천 컨텍스트의 도메인 모델은 서로 다르다.
  - 카탈로그는 제품을 중심으로 도메인 모델을 구현하지만 추천은 추천 연산을 위한 모델을 구현한다.
  - 예) 추천 시스템은 상품의 상세 정보를 포함하지 않으며 상품 번호 대신 아이템 ID라는 용어를 사용해서 식별자를 표현하고 추천 순위와 같은 데이터를 담게 된다.
- 카탈로그 시스템은 추천 시스템으로부터 추천 데이터를 받아오지만, 카탈로그 시스템에서는 추천의 도메인 모델을 사용하기보다는 카탈로그 도메인 모델을 사용해서 추천 상품을 표현해야 한다.
  - 즉, 다음과 같이 카탈로그의 모델을 기반으로 하는 도메인 서비스를 이용해서 상품 추천 기능을 표현해야 한다.
  ```java
  /**
    * 상품 추천 기능을 표현하는 도메인 서비스 
  */
  public interface ProductRecommendationService {
    public List<Product> getRecommendationOf(ProductId id);
  }
  ``` 
- 도메인 서비스를 구현한 클래스는 인프라스트럭처 영역에 위치한다.
  - 이 클래스는 외부 시스템과의 연동을 처리하고 외부 시스템의 모델과 현재 도메인 모델 간의 변환을 책임진다.
  ![image](https://user-images.githubusercontent.com/28394879/136878274-f3f38894-4098-4444-a10f-b74554787bd9.png)

- 위의 그림에서 RecSystemClient는 외부 추천 시스템이 제공하는 REST API를 이용해서 특정 상품을 위한 추천 상품 목록을 로딩한다.
  - 이 REST API가 제공하는 데이터는 추천 시스템의 모델을 기반으로 하고 있기 때문에 API 응답은 다음과 같이 상품 도메인 모델과 일치하지 않는 데이터를 제공할 것이다.
  ```
  [
    {itemId: 'PROD-1000', type: 'PRODUCT', rank:100},
    {itemId: 'PROD-1001', type: 'PRODUCT', rank:54}
  ]
  ``` 

- RecSystemClient는 REST API로 부터 데이터를 읽어와 카탈로그 도메인에 맞는 상품 모델로 변환한다.
  - 다음은 일부 코드를 가상으로 만들어 본 것이다.
  ```java
  public class RecSystemClient implements ProductRecommendationService {
    private ProductRepository productRepository;

    @Override
    public List<Product> getRecommendationsOf(ProductId id) {
      List<RecommendationItem> items = getRecItems(id.getValue());
      return toProducts(items);
    }

    private List<RecommendationItem> getRecItems(String itemId) {
      // externalRecClient는 외부 추천 시스템을 위한 클라이언트라고 가정
      return externalRecClient.getRecs(itemId);
    }

    private List<Product> toProducts(List<RecommendationItem> items) {
      return items.stream()
          .map(item -> toProductId(item.getItemId()) )
          .map(prodId -> productRepository.findById(prodId ) )
          .collect(toList());
    }

    private ProductId toProductId(String itemId) {
      return new ProductId(itemId);
    }

  ...
  }
  ```

- 이 코드에서 getRecItems() 메서드에서 사용하는 externalRecClient는 외부 추천 시스템에 연결할 때 사용하는 클라이언트로서 추천 시스템을 관리하는 팀에서 배포하는 모듈이라고 가정하자.
  - 이 모듈이 제공하는 RecommendationItem은 추천 시스템의 모델을 따를 것이다.
  - RecSystemClient는 추천 시스템의 모델을 받아와 toProducts() 메서드를 이용해서 카탈로그 도메인의 Product 모델로 변환하는 작업을 처리한다.

- 두 모델 간의 변환 과정이 복잡하면 아래 그림과 변환 처리를 위한 별도 클래스를 만들고 이 클래스에서 변환을 처리해도 된다.
  ![image](https://user-images.githubusercontent.com/28394879/136881074-bc1fe79a-9d9b-4c20-ac81-93081c00cfa1.png)


- REST API를 호출하는 것은 두 BOUNDED CONTEXT를 직접 통합하는 방법이다.
  - 직접 통합하는 대신 간접적으로 통합하는 방법도 있다.
  - 대표적인 간접 통합 방식이 메시지 큐를 사용하는 것이다.
  - 추천 시스템은 사용자의 조회 상품 이력이나 구매 이력과 같은 사용자 활동 이력을 필요로 하는데 이 내역을 전달할 때 메시지 큐를 사용할 수 있다.
  ![image](https://user-images.githubusercontent.com/28394879/136882547-d6c0836e-5bad-4033-ac4b-e6dcb9f40600.png)
  
- 위의 그림에서 카탈로그 BOUNDED CONTEXT는 추천 시스템이 필요로 하는 사용자 활동 이력을 메시지 큐에 추가한다.
  - 메시지 큐는 보통 비동기로 메시지를 처리하기 때문에 카탈로그 BOUNDED CONTEXT는 메시지를 큐에 추가한 뒤에 추천 BOUNDED CONTEXT가 메시지를 처리할 때까지 기다리지 않고 바로 이어서 자신의 처리를 계속한다.
- 추천 BOUNDED CONTEXT는 큐에서 이력 메시지를 읽어와 추천을 계산하는데 사용할 것이다.
  - 이는 두 BOUNDED CONTEXT가 사용할 메시지의 데이터 구조를 맞춰야 함을 의미한다.
  - 각각의 BOUNDED CONTEXT를 담당하는 팀은 서로 만나서 주고 받을 데이터 형식에 대해 협의해야 한다.
  - 메시지 시스템을 카탈로그 측에서 관리하고 있다면 큐에 담기는 메시지는 아래 그림과 같이 카탈로그 도메인을 따르는 데이터를 담을 것이다.
   
  ![image](https://user-images.githubusercontent.com/28394879/136883180-686c8031-bb7f-43c9-9432-fba2b15a5435.png)

- 추천 BOUNDED CONTEXT 관점에서 접근하면 아래 그림과 같이 메시지 데이터 구조를 잡을 수 있다.
  
   ![image](https://user-images.githubusercontent.com/28394879/136883653-8e984cc6-d375-4a91-aa1c-85007e54c8f7.png)

  

- 어떤 도메인 관점에서 모델을 사용하느냐에 따라 두 BOUNDED CONTEXT의 구현 코드가 달라지게 된다.
  - 카탈로그 도메인 관점에서 큐에 저장할 메시지를 생성하면 카탈로그 시스템의 연동 코드는 카탈로그 기준의 데이터를 그대로 메시지 큐에 저장한다.
  ```java
  // 상품 조회 관련 로그 기록 코드
  public class ViewLogService {
    private MessageClient messageClient;

    public void appendViewLog(String memberId, String productId, Date time) {
      messageClient.send(new ViewLog(memberId, productId, time));
    }
    ...

  }

  // messageClient
  public class RabbitMQClient implements MessageClient {
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(ViewLog viewLog) {
      // 카탈로그 기준으로 작성한 데이터를 큐에 그대로 보관
      rabbitTemplate.convertAndSend(logQueueName, viewLog);
    }
    ...
  }
  ``` 

- 카탈로그 도메인 모델을 기준으로 메시지를 전송하므로 추천 시스템에서는 자신의 모델에 맞게 메시지를 변환해서 처리해야 한다.
- 반대로 추천 시스템을 기준으로 큐에 데이터를 저장하기로 했다면 카탈로그의 코드는 다음과 같이 바뀔 것이다.
  ```java
  // 상품 조회 관련 로그 기록 코드
  public class ViewLogService {
    private MessageClient messageClient;

    public void appendViewLog(String memberId, String productId, Date time) {
      messageClient.send(new ActivityLog(productId, memberId, ActivityType.VIEW, time));
    }
    ...
  }

  // messageClient
  public class RabbitMQClient implements MessageClient {
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(ActivityLog activityLog) {
      rabbitTemplate.convertAndSend(logQueueName, activityLog);
    }
  }
  ``` 

- 두 BOUNDED CONTEXT를 개발하는 팀은 메시징 큐에 담을 데이터의 구조를 합의 하게 되는데 그 큐를 누가 제공하느냐에 따라 데이터 구조가 결정된다.
  - 예) 카탈로그 시스템에서 큐를 제공한다면 큐에 담기는 내용은 카탈로그 도메인을 따른다.
  - 카탈로그 도메인은 메시징 큐에 카탈로그와 관련된 메시지를 저장하게 되고, 다른 BOUNDED CONTEXT는 이 큐로부터 필요한 메시지를 수신하는 방식을 사용한다.
  - 즉, 이 방식은 한쪽에서 메시지를 출판하고 다른 쪽에서 메시지를 구독하는 출판/구독 모델을 따른다.
  ![image](https://user-images.githubusercontent.com/28394879/136890296-212d0cb6-5cf4-4689-b011-f8c11e2a9eef.png)

- 큐를 추천 시스템에서 제공할 경우 큐를 통해 메시지를 추천 시스템에 전달받는 방식이 된다.
  - 이 경우, 큐로 인해 비동기로 추천 시스템에 데이터를 전달하는 것을 제외하면 추천 시스템이 제공하는 REST API를 사용해서 데이터를 전달하는 것과 차이가 없다.

**마이크로서비스와 BOUNDED CONTEXT**
> 마이크로서비스 아키텍처가 단순 유행을 지나 점차 기업에서 자리를 잡아 가고 있다.
> 넷플리스나 아마존 같은 선도 기업뿐만 아니라 많은 기업이 마이크로서비스 아키텍처를 수용하는 추세이다.
> 마이크로서비스는 애플리케이션을 작은 서비스로 나누어 개발하는 아키텍처 스타일이다.
> 개별 서비스를 독립된 프로세스로 실행하고 각 서비스가 REST API나 메시징을 이용해서 통신하는 구조를 갖는다.
> 이런 마이크로서비스의 특징은 BOUNDED CONTEXT와 잘 어울린다.
> 각 BOUNDED CONTEXT는 모델의 경계를 형성하는데, BOUNDED CONTEXT를 마이크로서비스로 구현하면 자연스럽게 컨텍스트별로 모델이 분리된다.
> 코드로 치면 마이크로서비스마다 프로젝트를 생성하므로 BOUNDED CONTEXT마다 프로젝트를 만들게 된다.
> 이는 코드 수준에서 모델을 분리해서 두 BOUNDED CONTEXT의 모델이 섞이지 않도록 해준다
> 별도 프로세스로 개발한 BOUNDED CONTEXT는 독립적으로 배포하고 모니터링하고 확장하게 되는데 이 역시 마이크로서비스의 특징이다.





   
   

</details>

<details> <summary> 5. BOUNDED CONTEXT간 관계 </summary>

## 5. BOUNDED CONTEXT간 관계

- BOUNDED CONTEXT는 어떤 식으로든 연결되기 때문에 두 BOUNDED CONTEXT는 다양한 방식으로 관계를 맺는다.
  - 두 BOUNDED CONTEXT 간 관계 중 가장 흔한 관계는 한쪽에서 API를 제공하고 다른 한쪽에서 그 API를 호출하는 관계이다.
  - REST API가 대표적이다.
  - 이 관계에서 API를 사용하는 BOUNDED CONTEXT는 API를 제공하는 BOUNDED CONTEXT에 의존하게 된다.
   
  ![image](https://user-images.githubusercontent.com/28394879/136894666-0708894f-39c3-429c-a25f-6a24dccdd06d.png)
  
- 위의 그림에서 하류(downstream) 컴포넌트인 카탈로그 컨텍스트는 상류(upstream)컴포넌트인 추천 컨텍스트가 제공하는 데이터와 기능에 의존한다.
  - 카탈로그는 추천 상품을 보여주기 위해 추천 BOUNDED CONTEXT가 제공하는 REST API를 호출한다.
  - 추천 시스템이 제공하는 REST API의 인터페이스가 바뀌면 카탈로그 시스템의 코드도 바뀌게 된다.
- 상류 컴포넌트는 일종의 서비스 공급자 역할을 하며, 하류 컴포넌트는 그 서비스를 사용하는 고객 역할을 한다.
  - 고객과 공급자 관계에 있는 두 팀은 상호 협력이 필수적이다.
  - 공급자 역할을 하는 상류 팀이 마음대로 API를 변경하면 하류 팀은 변경된 API에 맞추느라 우선순위가 높은 다른 기능을 개발하지 못할 수도 있다. 
  - 반대로 상류 팀이 무언가를 변경할 때마다 하류 팀으로부터 여러 절차를 거쳐 승낙을 받아야 한다면 상류 팀은 새로운 개발 시도 자체를 하지 않을 수도 있다. 
  - 따라서, 상류 팀과 하류 팀은 개발 계획을 서로 공유하고 일정을 협의해서 결정해야 한다.
- 상류 컴포넌트는 보통 하류 컴포넌트가 사용할 수 있는 통신 프로토콜을 정의하고 이를 공개한다.
  - 예) 추천시스템은 하류 컴포넌트가 사용할 수 있는 REST API를 제공할 수 있다.
  - 구글의 프로토콜버퍼와 같은 것을 이용해서 서비스를 제공할 수도 있다.
  - 상류 팀의 고객인 하류 팀이 다수 존재하면 상류 팀은 여러 하류 팀의 요구사항을 수용할 수 있는 API를 만들고 이를 서비스 형태로 공개해서 서비스의 일관성을 유지할 수 있다.
  - 이런 서비스를 가리켜 공개 호스트 서비스(OPEN HOST SERVICE)라고 한다.
- 공개 호스트 서비스의 대표적인 예가 검색이다.
  - 블로그, 카페, 게시판과 같은 서비스를 제공하는 포탈은 각 서비스별로 검색 기능을 구현하기보다는 검색을 위한 전용 시스템을 구축하고 검색 시스템과 각 서비스를 통합한다.
  - 이때, 검색 시스템은 상류 컴포넌트가 되고 블로그, 카페, 게시판은 하류 컴포넌트가 된다.
  - 상류 팀은 각 하류 컴포넌트의 요구사항을 수용하는 단일 API를 만들어 이를 공개하고 각 하류팀은 공개된 API를 사용해서 검색 기능을 구현하게 된다.
  ![image](https://user-images.githubusercontent.com/28394879/136898276-b4bed6a7-27a2-45e0-9bab-cb9ed64e84bf.png)

- 상류 컴포넌트의 서비스는 상류 BOUNDED CONTEXT의 도메인 모델을 따른다.
  - 따라서, 하류 컴포넌트는 상류 서비스의 모델이 자신의 모델에 영향을 주지 않도록 보호해 주는 완충 지대를 만들어야 한다.
  - 이미 앞서 이 완충 지대에 대해 언급 했었다. 그게 아래 그림이다.
  ![image](https://user-images.githubusercontent.com/28394879/136878274-f3f38894-4098-4444-a10f-b74554787bd9.png) 

- 위 그림에서 RecSystemClient는 외부 시스템과의 연동을 처리하는데 외부 시스템의 도메인 모델이 내 도메인 모델을 침범하지 않도록 막아주는 역할을 한다. 
  - 즉, 내 모델이 깨지는 것을 막아주는 안티코럽션 계층(Anticorruption Layer)이 된다.
  - 이 계층에서 두 BOUNDED CONTEXT 간의 모델 변환을 처리해 주기 때문에 다른 BOUNDED CONTEXT의 모델에 영향을 받지 않고 내 도메인 모델을 유지할 수 있다.
  - 아래 그림은 RectSystemClient는 외부 시스템의 모델이 내 도메인 모델을 침범하지 않도록 만들어주는 안티코럽션 계층(Anticorruption Layer)역할을 한다에 해당하는 그림이다.
   
  ![image](https://user-images.githubusercontent.com/28394879/136900532-ff9ba59e-b2e6-433d-a674-67be342cd7af.png) 

- 두 BOUNDED CONTEXT가 같은 모델을 공유하는 경우도 있다.
  - 예) 운영자를 위한 주문 관리 도구를 개발하는 팀과 고객을 위한 주문 서비스를 개발하는 팀이 다르다고 가정하자.
  - 이 경우, 두 팀은 주문을 표현하는 모델을 공유함으로써 주문과 관련된 중복 개발을 막을 수 있다.
  - 이렇게 두 팀이 공유하는 모델을 공유 커널(SHARED KERNEL)이라고 부른다.
- 공유 커널의 장점은 중복을 줄여준다는 것이다.
  - 두 팀이 하나의 모델을 개발해서 공유하기 때문에 두 팀에서 동일한 모델을 두 번 개발하는 중복을 줄일 수 있다.
  - 하지만, 두 팀이 한 모델을 공유하기 때문에 한 팀에서 임의로 모델을 변경해서는 안되며 두 팀이 밀접한 관계를 유지해야 한다.
  - 두 팀이 밀접한 관계를 형성할 수 없다면 공유 커널을 사용할 때의 장점보다 공유 커널로 인해 개발이 지연되고 정체되는 문제가 더 커지게 된다.
- 마지막으로 살펴볼 관계는 독립 방식(SEPARATE WAY) 관계이다.
  - 독립 방식 관계는 간단하다.
  - 그냥 서로 통합하지 않는 방식이다.
  - 두 BOUNDED CONTEXT 간에 통합을 하지 않으므로 서로 독립적으로 모델을 발전시킨다.
- 독립 방식에서 두 BOUNDED CONTEXT 간의 통합은 수동으로 이루어진다.
  - 예) 온라인 쇼핑몰 솔루션과 외부의 ERP 서비스를 사용하고 있을 때
  - 온라인 쇼핑몰 솔루션은 외부 ERP 서비스와의 연동을 지원하지 않으므로 온라인 쇼핑몰에서 판매가 발생하면 쇼핑몰 운영자는 쇼핑물 시스템에서 판매 정보를 보고 ERP 시스템에 입력해야 한다.
  ![image](https://user-images.githubusercontent.com/28394879/136904798-65139a7c-00f9-4433-b4a2-868cd7f16040.png)
  
- 수동으로 통합하는 방식이 나쁜 것은 아니지만 규모가 커질수록 수동 통합에는 한계가 있으므로 장사가 잘되기 시작하면 두 BOUNDED CONTEXT를 통합해야 한다.
  - 이때 외부에서 구매한 솔루션과 ERP를 완전히 대체할 수 없다면 두 BOUNDED CONTEXT를 통합해 주는 별도의 시스템을 만들어야 할 수도 있다.
  ![image](https://user-images.githubusercontent.com/28394879/136905585-70064421-c748-40a9-b14a-46027487cfcd.png)

  

</details>

<details> <summary> 6. 컨텍스트 맵 </summary>

## 6. 컨텍스트 맵 

- 개별 BOUNDED CONTEXT에 매몰되면 전체를 보지 못할 때가 있다.
  - 나무만 보고 숲을 보지 못하는 상황을 방지하렴녀 전체 비즈니스를 조망할 수 있는 지도가 필요한데, 그것이 바로 컨텍스트 맵이다.
  - 컨텍스트 맵은 아래 그림처럼 BOUNDED CONTEXT 간의 관계를 표시한 것이다.
  ![image](https://user-images.githubusercontent.com/28394879/136906896-c818c78d-2d36-42dc-8b03-97af334c2725.png)

- 위의 그림만봐도 한눈에 각 BOUNDED CONTEXT의 경계가 명확하게 드러나고 서로 어떤 관계를 맺고 있는지 알 수 있다.
  - BOUNDED CONTEXT 영역에 주요 애그리거트를 함께 표시하면 모델에 대한 관계가 더 명확히 드러난다.
  - 위의 그림은 오픈 호스트 서비스(OHS)와 안티코럽션 계층(ACL)만 표시했는데 하위 도메인이나 조직 구조를 함께 표시하면 도메인을 포함한 전체 관계를 이해하는 데 도움이 된다.
- 컨텍스트 맵은 시스템의 전체 구조를 보여준다.
  - 이는 하위 도메인과 일치하지 않는 BOUNDED CONTEXT를 찾아 도메인에 맞게 BOUNDED CONTEXT를 조절하고 사업의 핵심 도메인을 위해 조직 역량을 어떤 BOUNDED CONTEXT에 집중할지 파악하는데 도움을 준다.
- 컨텍스트 맵을 그리는 규칙은 따로 없다.
  - 위의 그림과 같이 간단한 도형과 선을 이용해서 각 컨텍스트의 관계를 이해할 수 있는 수준에서 그리면 된다.
  - 컨텍스트 맵은 단순하기 때문에 화이트보드나 파워포인트와 같은 도구를 이용해서 쉽게 그릴 수 있다.

> 컨텍스트 맵은 전체 시스템의 이해 수준을 보여준다. 
> 즉, 시스템을 더 잘 이해하거나 시간이 지나면서 컨텍스트 간 관계가 바뀌면 컨텍스트 맵도 함께 바뀐다.

</details>


# 10. 이벤트 

<details> <summary> 1. 시스템 간 강결합의 문제 </summary>

## 1. 시스템 간 강결합의 문제

- 쇼핑몰에서 구매를 취소하면 환불을 처리해야 한다.
  - 이때 환불 기능을 실행하는 주체는 주문 도메인 엔티티가 될 수 있다.
  - 도메인 객체에서 환불 기능을 실행하려면 다음 코드처럼 환불 기능을 제공하는 도메인 서비스를 파라미터로 전달받고 취소 도메인 기능에서 도메인 서비스를 실행하게 된다.
  ```java
  public class Order {
    ...
    // 외부 서비스를 실행하기 위해 도메인 서비스를 파라미터로 전달받음
    public void cancel(ReFundService refundService) {
      verifyNotYetShipped();
      this.state = OrderState.CANCELED;

      this.refundStatus = State.REFUND_STARTED;
      try {
        refundService.refund(getPaymentId());
        this.refundStatus = State.REFUND_COMPLETED;
      } catch (Exception ex) {
        ??
      }
    }
  }
  ...
  ``` 
- 응용 서비스에서 환불 기능을 실행할 수도 있다.
  ```java
  public class CancelOrderService {
    private RefundService refundService;

    @Transactional
    public void cancel(OrderNo orderNo) {
      Order order = findOrder(orderNo);
      order.cancel();

      order.refundStarted();
      try {
        refundService.refund(order.getPaymentId());
        order.refundCompleted();
      } catch(Exception ex) {
        ???
      }
    }
    ...
  }
  ``` 
- 보통 결제 시스템은 외부에 존재하므로 RefundService는 외부의 환불 시스템 서비스를 호출하는데, 이때 두 가지 문제가 발생한다.

- 첫번째 
  - 첫 번째 문제는 외부 서비스가 정상이 아닐 경우 트랜잭션 처리를 어떻게 해야 할지 애매하다는 것이다.
  - 환불 기능을 실행하는 과정에서 익셉션이 발생하면 트랜잭션을 롤백해야 할까? 아니면 일단 커밋해야 할까?
  - 외부의 환불 서비스를 실행하는 과정에서 익셉션이 발생하면 환불에 실패했으므로 주문 취소 트랜잭션을 롤백하는 것이 맞는 것으로 보인다.
  - 하지만, 반드시 트랜잭션을 롤백해야 하는 것은 아니다.
  - 주문 취소 상태로 변경하고 환불만 나중에 다시 시도하는 방식으로 처리할 수도 있다.
- 두번째
  - 두 번째 문제는 성능에 대한 것이다.
  - 환불을 처리하는 외부 시스템이 응답 시간이 길어지면 그만큼 대기 시간이 발생한다.
  - 환불 처리 기능이 30초가 걸리면 주문 취소 기능은 30초만큼 대기 시간이 증가한다.
  - 즉, 외부 서비스 성능에 직접적인 영향을 받는 문제가 있다.
  ```java
  @Transactional
  public void cancel(OrderNo orderNo) {
    Order order = findOrder(orderNo);
    order.cancel();

    order.refundStarted();
    try {
      refundService.refund(order.getPaymentId()); // 외부 서비스 성능에 직접 영향을 받는다.
      order.refundCompleted();
    } catch (Exception ex) {
      ???
    }
  }
  ``` 


- 두가지 문제 외에 도메인 객체에 서비스를 전달하면 추가로 설계상 문제가 나타낱 수 있다.
  - 우선, 다음과 같이 주문 로직과 결제 로직이 섞이는 문제가 있다.
  ```java
  public class Order{

    public void cancel(RefundService refundService) {
      verifyNotYetShipped(); // 주문 로직 
      this.state = OrderState.CANCELED; // 주문 로직

      /* 결제 로직 */
      this.refundStatus = State.REFUND_STATED;
      try {
        refundSvc.refund(getPaymentId());
        this.refundStatus = State.REFUND_COMPLETED;
      } catch (Exception ex) {
        ...
      }
      /* 결제 로직 */
    }
  }
  ``` 

- Order는 주문을 표현하는 도메인 객체인데 결제 도메인의 환불 관련 로직이 뒤섞이게 된다.
  - 이는 환불 기능이 바뀌면 Order도 영향을 받게 된다는 것을 의미한다.
  - 주문 도메인 객체의 코드를 결제 도메인 떄문에 변경할지도 모르는 상황은 좋아 보이지 않는다.
- 도메인 객체에 서비스를 전달할 때 또 다른 문제는 기능을 추가할 때 발생한다.
  - 만약 주문을 취소한 뒤에 환불뿐만 아니라 취소했다는 내용을 통지해야 한다면 어떻게 될까?
  - 환불 도메인 서비스와 동일하게 파라미터로 통지 서비스를 받도록 구현하면 앞서 언급한 로직이 섞이는 문제가 더 커지고 트랜잭션 처리가 더 복잡해진다.
  - 게다가 영향을 주는 외부 서비스가 두 개나 증가했다.
  ```java
  public class Order {
    // 기능을 추가할 때마다 파라미터가 함께 추가되면
    // 다른 로직이 더 많이 섞이고, 트랜잭션 처리가 더 복잡해진다.
    public void cancel(RefundService refundService, NotiService notiSvc) {
      verifyNotYetShipped();
      this.state = OrderState.CANCELED;
      ...
      // 주문+결제+통지 로직이 섞임
      // refundService는 성공하고, notiSvc는 실패하면?
      // refundService와 notiSvc 중 무엇을 먼저 처리하나? 
    }
  }
  ``` 

- 지금까지 언급한 문제가 발생하는 이유는 주문 BOUNDED CONTEXT와 결제 BOUNDED CONTEXT간의 강결합(high coupling) 때문이다.
  - 주문이 결제와 강하게 결합되어 있어서 주문 BOUNDED CONTEXT가 결제 BOUNDED CONTEXT에 영향을 받게 되는 것이다. 
- 이런 강한 결합을 없앨 수 있는 방법이 있는게 그것은 바로 이벤트를 사용하는 것이다.
  - 특히 비동기 이벤트를 사용하면 두 시스템 간의 결합을 크게 낮출 수 있다.
  - 한번 익숙해지면 모든 연동을 이벤트와 비동기로 처리하고 싶을 정도로 강력하고 매력적인 것이 이벤트이다.
  - 지금부터 이벤트에 대해 살펴보도록 하자.

</details>


<details> <summary> 2. 이벤트 개요 </summary>

## 2. 이벤트 개요
- 이 절에서 사용하는 이벤트(event)라는 용어는 '과거에 벌어진 어떤 것' 을 뜻한다.
  - 예) 사용자가 암호를 변경한 것을 '암호를 변경했음 이벤트' 라고 부를 수 있다.
  - 예) 주문을 취소했다면 '주문을 취소했음 이벤트' 가 발생했다고 할 수 있다.
- 웹 브라우저에서 자바 스크립트 코드를 작성한 개발자라면 이미 이벤트에 익숙할 것이다.
  - UI 개발에서 모든 UI 컴포넌트는 관련 이벤트를 발생시킨다.
  - 예) 버튼을 클릭하면 '버튼 클릭됨 이벤트' 가 발생하고, 스크롤을 하면 '스크롤됨 이벤트' 가 발생한다.
- 이벤트가 발생한다는 것은 상태가 변경됐다는 것을 의미한다.
  - '암호 변경됨 이벤트'가 발생한 이유는 회원의 암호를 변경했기 때문이다.
  - '주문 취소됨 이벤트'가 발생한 이유는 주문이 취소 상태로 바뀌었기 때문이다.
- 이벤트는 발생하는 것에서 끝나지 않는다.
  - 이벤트가 발생하면 그 이벤트에 반응하여 원하는 동작을 수행하는 기능을 구현한다.
  - 다음 자바스크립트는 jQuery 를 이용해서 작성한 코드이다.
  - 이 코드에서 click()에 전달한 함수는 'myBtn' 버튼에서 '클림 됨 이벤트'가 발생하면 그 이벤트에 반응하여 경고 창을 출력한다.
  ```javascript
  $('#myBtn').click(function(evt) {
    alert("경고");
  });
  ``` 

- 도메인 모델에서도 UI 컴포넌트와 유사하게 도메인의 상태 변경을 이벤트로 표현할 수 있다.
  - 보통 '~할 때', '~가 발생하면', '만약-하면' 과 같은 요구사항은 도메인의 상태 변경과 관련된 경우가 밚고 이런 요구사항을 이벤트를 이용해서 구현할 수 있다.
  - 예) '주문을 취소할 때 이메일을 보낸다' 라는 요구사항에서 '주문을 취소할 때'는 주문이 취소 상태로 바뀌는 것을 의미하므로 '주문 취소됨 이벤트'를 활용해서 구현할 수 있다.

### 이벤트 관련 구성요소
- 도메인 모델에 이벤트를 도입하려면 아래 그림과 같은 네 개의 구성요소를 구현해야 한다.  

  ![image](https://user-images.githubusercontent.com/28394879/137086328-14d3023c-7c42-406b-9e48-98729a3bb464.png)

- 도메인 모델에서 이벤트 주체는 엔티티, 밸류, 도메인 서비스와 같은 도메인 객체이다.
  - 이들 도메인 객체는 도메인 로직을 실행해서 상태가 바뀌면 관련 이벤트를 발생한다.
- 이벤트 핸들러(handler)는 이벤트 생성 주체가 발생한 이벤트에 반응한다.
  - 이벤트 핸들러는 생성 주체가 발생한 이벤트를 전달받아 이벤트에 담긴 데이터를 이용해서 원하는 기능을 실행한다.
  - 예) '주문 취소됨 이벤트'를 받는 이벤트 핸들러는 해당 주문의 주문자에게 SMS로 주문 취소 사실을 통지할 수 있다.
- 이벤트 생성 주체와 이벤트 핸들러를 연결해 주는 것이 이벤트 디스패처(dispatcher)이다.
  - 이벤트 생성 주체는 이벤트를 생성해서 디스패처에 이벤트를 전달한다.
  - 이벤트를 전달받은 디스패처는 해당 이벤트를 처리할 수 있는 핸들러에 이벤트를 전파한다.
  - 이벤트 디스패처의 구현 방식에 따라 이벤트 생성과 처리를 동기나 비동기로 실행하게 된다.

### 이벤트의 구성
- 이벤트는 발생한 이벤트에 대한 정보를 담는다. 
- 이 정보는 다음을 포함한다.
  - 이벤트 종류: 클래스 이름으로 이벤트 종류를 표현
  - 이벤트 발생 시간
  - 추가 데이터: 주문번호, 신규 배송지 정보 등 이벤트와 관련된 정보 
- 배송지를 변경할 때 발생하는 이벤트를 생각해보자.
  - 이 이벤트를 위한 클래스는 다음과 같이 작성할 수 있다.
  ```java
  public class ShippingInfoChangedEvent {
    private String orderNumber;
    private long timestamp;
    private ShippingInfo newShippingInfo;

    // 생성자, getter
  }
  ``` 

- 클래스 이름을 보면 'Changed' 라는 과거 시제를 사용했다.
  - 이벤트는 현재 기준으로 (바로 직전이라도) 과거에 벌어진 것을 표현하기 때문에 이벤트 이름에는 과거 시제를 사용한다.
- 이 이벤트를 발생하는 주체는 Order 애그리거트이다.
  - Order 애그리거트의 배송지 변경 기능을 구현한 메서드는 다음 코드처럼 배송지 정보를 변경한 뒤에 이벤트 디스패처를 사용해서 이 이벤트를 발생시킬 것이다. 
  - 이 코드에서 Event.raise()는 디스패처를 통해 이벤트를 전파하는 기능을 제공하는데 이 기능의 구현과 관련된 내용은 뒤에서 살펴보도록 하자.
  ```java
  public class Order {

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
      verifyNotYetShipped();
      setShippingInfo(newShippingInfo);
      Events.raise(new ShippingInfoChangedEvent(member, newShippingInfo));
    }
  }
  ```      
- ShippingInfoChangedEvent 를 처리하는 핸들러는 디스패처로부터 이벤트를 전달받아 필요한 작업을 수행한다.
  - 예) 변경된 배송지 정볼르 물류 서비스에 재전송하는 핸들러는 다음과 같이 구현할 수 있다.
  ```java
  public class ShippingInfoChangedHandler implements EventHandler<ShippingInfoChangedEvent> {

    @Override
    public void handle(ShippingInfoChangedEvent evt) {
      shippingInfoSynchronizer.sync(
        evt.getOrderNumber(),
        evt.getNewShippingInfo());
    }
  }
  ``` 

- 이벤트는 이벤트 핸들러가 작업을 수행하는 데 필요한 최소한의 데이터를 담아야 한다.
  - 이 데이터가 부족할 경우 핸들러는 필요한 데이터를 읽기 위해 관련 API를 호출하거나 DB에서 데이터를 직접 읽어와야 한다.
  - 예) ShippingInfoChangedEvent가 바뀐 배송지 정보를 포함하고 있지 않을 때
  - 이 핸들러가 같은 VM에서 동작하고 있다면 다음과 같이 주문 데이터를 로딩해서 배송지 정보를 추출해야 한다.
  ```java
  public class ShippingInfoChangedHandler implements EventHandler<ShippingInfoChangedEvent> {
    
    @Override
    public void handle(ShippingInfoChangedEvent evt) {
      // 이벤트가 필요한 데이터를 담고 있지 않으면,
      // 이벤트 핸들러는 리포지터리, 조회 API, 직접 DB 접근 등의
      // 방식을 통해 필요한 데이터를 조회해야 한다.
      Order order = orderRepository.findById(evt.getOrderNo());
      shippingInfoSynchronizer.sync(
        order.getNumber().getValue(),
        order.getShippingInfo());
    }
  }
  ``` 
- 이벤트는 데이터를 담아야 하지만 그렇다고 이벤트 자체와 관련 없는 데이터를 포함할 필요는 없다.
  - 배송지 정보를 변경해서 발생시킨 ShippingInfoChangedEvent가 이벤트 발생과 직접 관련된 바뀐 배송지 정보를 포함하는 것은 맞지만 배송지 정보 변경과 전혀 관련 없는 주문 상품 번호와 개수를 담을 필요는 없다.


### 이벤트 용도
- 이벤트는 크게 두가지 용도로 쓰인다.
- 첫번째 용도는 트리거이다.
  - 도메인의 상태가 바뀔 때 다른 후처리를 해야 할 경우 후처리를 실행하기 위한 트리거로 이벤트를 사용할 수 있다.
  - 주문의 경우 주문 취소 이벤트가 트리거가 될 수 있다.
  - 주문을 취소하면 환불을 처리해야 하는데, 이 때 환불 처리를 위한 트리거로 주문 취소 이벤트를 사용할 수 있다.
  
  ![image](https://user-images.githubusercontent.com/28394879/137092536-9e0c51e3-817e-4cdf-b133-ee6048d7d9e8.png)

  - 예매 결과를 SMS로 통지할 때도 이벤트를 트리거로 사용할 수 있다.
    - 예매 도메인은 예매 완료 이벤트를 발생시키고 이 이벤트 핸들러에서 SMS를 발송시키는 방식으로 구현할 수 있다.


- 이벤트의 두 번째 용도는 서로 다른 시스템 간의 데이터 동기화이다.
  - 배송지를 변경하면 외부 배송 서비스에 바뀐 배송지 정보를 전송해야 한다.
  - 이 경우, 주문 도메인은 배송지 변경 이벤트를 발생시키고 이벤트 핸들러는 외부 배송 서비스와 배송지 정보를 동기화한다.

### 이벤트 장점
- 이벤트를 사용하면 다음 코드와 같이 서로 다른 도메인 로직이 섞이는 것을 방지할 수 있다. 
  ```java
  public class Order {

    public void cancel(RefundService refundService) {
      verifyNotYetShipped();
      this.state = OrderState.CANCELED;

      this.refundStatus = State.REFUND_STATED;
      try {
        refundService.refund(getPaymentId());
        this.refundStatus = State.REFUND_COMPLETED;
      } catch (Exception ex) {
        ...
      }
    }
  }
  // 위 코드에서 이벤트로 서로 다른 도메인 로직이 섞이는 것을 방지 한 코드로 변경한게 아래 코드 
  
  public class Order {
    
    public void cancel() { // 구매 취소에 더 이상 환불 로직이 없음
      verifyNotYetShipped();
      this.state = OrderState.CANCELED;

      this.refundStatus = State.REFUND_STATED;
      Events.raise(new OrderCanceledEvent(number.getNumber()));
    }
  }
  ```

- 위 코들르 보면 구매 취소 로직에 이벤트를 적용함으로써 환불 로직이 없어진 것을 알 수 있다.
  - cancel() 메서드에서 환불 서비스를 실행하기 위해 사용한 파라미터도 없어졌다.
  - 환불 실행 로직은 주문 취소 이벤트를 받는 이벤트 핸들러로 이동하게 된다.
  - 이를 통해 이벤트를 사용해서 주문 도메인에서 결제(환불) 도메인으로의 의존을 제거했다.
- 이벤트 핸들러를 사용하면 기능 확장도 용이하다.
  - 구매 취소 시 환불과 함께 이벤트로 취소 내용을 보내고 싶다면 이메일 발송을 처리하는 핸들러를 구현하고 디스페처에 등록하면 된다.
  - 기능을 확장해도 구매 도메인 로직은 수정할 필요가 없다.
  ![image](https://user-images.githubusercontent.com/28394879/137095439-ad39b60c-0843-44a3-a911-52d1bc4d41bd.png)



</details>


<details> <summary> 3. 이벤트, 핸들러, 디스패처 구현 </summary>

## 3. 이벤트, 핸들러, 디스패처 구현
- 지금까지 이벤트에 대한 내용을 살펴봤는데 실제 이벤트와 관련된 코드를 구현해보자
- 이벤트와 관련된 코드는 다음과 같다.
  - 이벤트 클래스
  - EventHandler: 이벤트 핸들러를 위한 상위 타입으로 모든 핸들러는 이 인터페이스를 구현한다.
  - Events: 이벤트 디스패처, 이벤트 발행, 이벤트 핸들러 등록, 이벤트를 핸들러에 등록하는 등의 기능을 제공한다.

### 이벤트 클래스
- 이벤트 자체를 위한 상위 타입은 존재하지 않는다.
  - 원하는 클래스를 이벤트로 사용할 것이다.
  - 이벤트는 과거에 벌어진 상태 변화나 사건을 의미하므로 이벤트 클래스의 이름을 결정할 때에는 과거 시제를 사용해야 한다는 점만 유의하면 된다.
  - OrderCanceledEvent와 같이 클래스 이름 뒤에 접미사로 Event를 사용해야 이벤트로 사용하는 클래스라는 것을 명시적으로 표현할 수도 있고 OrderCanceled처럼 간결함을 위해 과거 시제만 사용할 수도 있다.
- 이벤트 구성에서 설명한 것처럼 이벤트 클래스는 이벤트를 처리하는 데 필요한 최소한의 데이터를 포함해야 한다.
  - 예) 주문 취소 이벤트는 적어도 주문번호를 포함해야 관련 핸들러에서 후속 처리를 할 수 있다.
  ```java
  public class OrderCanceledEvent {
    // 이벤트는 핸들러에서 이벤트를 처리하는 데 필요한 데이터를 포함한다.
    private String orderNumber;
    public OrderCanceledEvent(String number) {
      this.orderNumber = number;
    }

    public String getOrderNumber() { return orderNumber; }
  }
  ``` 
- 모든 이벤트가 공동으로 갖는 프로퍼티가 존재한다면 관련 상위 클래스를 만들 수도 있다.
  - 예) 모든 이벤트가 발생 시간을 갖도록 하려면 다음 코드와 같은 상위 클래스를 만들고 각 이벤트 클래스가 상속받도록 할 수 있다.
  ```java
  public abstract class Event {
    private long timestamp;

    public Event() {
      this.timestamp = System.currentTimeMillis();
    }
    
    public long getTimestamp() {
      return timestamp;
    }
  }
  ``` 
  - 이제 발생 시간이 필요한 이벤트 클래스는 다음 코드처럼 Event 클래스를 상속 받아 구현하면 된다.
  ```java
  // 발생 시간이 필요한 각 이벤트 클래스는 Event를 상속받아 구현한다.
  public class OrderCancelEvent extends Event {
    private String orderNumber;
    public OrderCanceledEvent(String number) {
      super();
      this.orderNumber = number;
    }
  }
  ``` 

### EventHandler 인터페이스
- EventHandler 인터페이스는 이벤트 핸들러를 위한 상위 인터페이스이다. 
  - 여기에서 사용할 인터페이스는 다음과 같다.
  ```java
  package com.myshop.common.event;

  import net.jodah.typetools.TypeResolver;

  public interface EventHandler<T> {
    void handle(T event);

    default boolean canHandle(Object event) {
      Class<?>[] typeArgs = TypeResolver.resolverRawArguments(
        EventHandler.class, this.getClass());
      return typeArgs[0].isAssignableFrom(event.getClass());
    }
  }
  ``` 
- EventHandler 인터페이스를 상속받는 클래스는 handle() 메서드를 이용해서 필요한 기능을 구현하면 된다.
  - canHandle() 메서드는 핸들러가 이벤트를 처리할 수 있는지 여부를 검사한다.
  - 위 코드의 canHandle() 메서드는 자바8의 디폴트 메시지를 이용해서 기본 기능을 구현했다.
  - 이 기능은 파라미터로 받은 event의 타입이 T의 파라미터화 타입에 할당 가능하면 true를 리턴한다.
  - 예) 다음과 같이 타입 파라미터로 PasswordChangedEvent를 사용한 EventHandler 임의 클래스 구현이 있다고 하자.
  ```java
  EventHandler<?> handler = new EventHandler<PasswordChangedEvent>() {
    @Override
    public void handle(PasswordChangedEvent event) {...생략}
  };
  boolean result = handler.canHandle(new PasswordChangedEvent(someId, newPw));
  ``` 

- 이때, handler의 파라미터화 타입은 PasswordChangedEvent이므로 canHandle() 메서드에 PasswordChangedEvent 객체를 파라미터로 전달하면 true를 리턴한다.
- canHandle() 메서드를 구현할 때 사용하는 TypeResolver는 EventHandler의 파라미터화 타입을 구하는 기능을 제공한다. 

> TypeResolver의 코드는 https://github.com/jhalterman/typetools 사이트에서 구할 수 있고 
> 이 페이지의 예제 코드에도 포함되어 있다.


- 자바 8 이전 버전이라면 다음과 같이 EventHandler 인터페이스와 이 인터페이스를 구현한 추상 클래스를 구현하면 된다.
  ```java
  public interface EventHandler<T> {
    void handle(T event);
    boolean canHandle(Object event);
  }
  
  public abstract class AbstractEventHandler<T> implements EventHandler<T> {
    @Override
    public boolean canHandle(Object event) {
      Class<?>[] typeArgs = TypeResolver.resolveRawArguments(
        EventHandler.class, this.getClass());
      return typeArgs[0].isAssignableFrom(event.getClass());
    }
  }
  ``` 

- 파라미터화 타입 대신에 다른 타입을 이용해서 처리 가능 여부를 검사하고 싶다면, 핸들러 구현 클래스에서 canHandle() 메서드를 재정의한다.

### 이벤트 디스패처인 Events 구현
- 이벤트 디스패처인 Events를 구현할 차례이다.
  - 도메인을 사용하는 응용 서비스는 이벤트를 받아 처리할 핸들러를 Evnets.handle()로 등록하고, 도메인 기능을 실행한다.
  - 이벤트 핸들러 등록을 쉽게 하기 위해 다음과 같이 정적 메서드를 이용해서 구현했다.
  ```java
  public class CancelOrderService {
    private OrderRepository orderRepository;
    private RefundService refundService;

    @Transactional
    public void cancel(OrderNo orderNo) {
      Events.handle(
          (OrderCanceledEvent evt) -> refundService.refund(evt.getOrderNumber());
      );

      Order order = findOrder(orderNo);
      order.cancel();
      
      Events.reset();
    }
  }
  ``` 

- 이 코드는 OrderCanceledEvent가 발생하면 Events.handle() 메서드에 전달한 EventHandler를 이용해서 이벤트를 처리하게 된다.
  - 뒤에서 언급하겠지만 Events는 내부적으로 핸들러 목록을 유지하기 위해 ThreadLocal을 사용한다.
  - Events.handle() 메서드는 인자로 전달받은 EventHandler를 List에 보관한다.
  - 이벤트가 발생하면 이벤트를 처리할 EventHandler를 List에서 찾아 EventHandler의 handle() 메서드를 호출해서 이벤트를 처리한다.
- 이벤트를 발생시킬 때에는 Events.raise() 메서드를 사용한다.
  - 예) Order#cancel() 메서드는 다음과 같이 구매 취소 로직을 수행한 뒤 Events.raise()를 이용해서 이벤트를 발생시킨다.
  ```java
  public class Order {

    public void cancel() {
      verifyNotYetShipped();
      this.state = OrderState.CANCELED;
      Events.raise(new OrderCanceledEvent(number.getNumber()));
    }
  }
  ``` 
- Events.raise()를 이용해서 이벤트를 발생시키면 Events.raise() 메서드는 이벤트를 처리할 핸들러를 찾아 handle() 메서드를 실행한다.
- Events 클래스의 구현 코드는 아래코드와 같다.
  - 이 코드를 이해하려면 ThreadLocal에 대한 이해가 필요하다.
  - ThreadLocal을 처음 접한다면 개인 블로그에 정리한 http://javacan.tistory.com/entry/ThreadLocalUsage 문서를 읽어 보면 도움이 될 것이다.
  ```java
  package com.myshop.common.event;

  import java.util.ArrayList;
  import java.util.List;

  public class Events {
    private static ThreadLocal<List<EventHandler<?>>> handlers = new ThreadLocal<>(); // EventHandler 목록을 보관하는 ThreadLocal 변수를 생성한다.
    private static ThreadLocal<Boolean> publishing = new ThreadLocal<Boolean>() {
      @Override
      protected Boolean initialValue() {
        return Boolean.FALSE;
      }
    }; // 이벤트를 처리 중인지 여부를 보관하는 ThreadLocal 변수를 생성한다.

    public static void raise(Object event) { // 파라미터로 전달받은 이벤트를 처리한다.
      if (publishing.get()) return; // 이벤트를 이미 출판 중이면 출판하지 않는다. 이는 이벤트 핸들러에서 이벤트를 출판하려 할 때 발생하는 무한 재귀 문제를 방지한다.

      try {
        publishing.set(Boolean.TRUE); // 출판 상태로 변경한다.

        List<EventHandler<?>> eventHandlers = handlers.get();
        if(eventHandlers == null) return;

        for(EventHandler handler : eventHandlers) { // handlers에 담긴 EventHandler가 파라미터로 전달받은 이벤트를 처리할 수 있는지 확인하고, 처리 가능하면 핸들러의 handle() 메서드에 이벤트 객체를 전달한다. 
          if(handler.canHandle(event)) {
            handler.handle(event);
          }
        }
      } finally {
        publishing.set(Boolean.FALSE); // 핸들러의 이벤트 처리가 끝나면 출판 진행 상태를 False로 변경한다.
      }
    }

    public static void handle(EventHandler<?> handler) { // 이벤트 핸들러를 등록하는 handle() 메서드를 구현한다.
      if(publishing.get()) return; // 이벤트를 처리 중이면 등록하지 않는다.

      List<EventHandler<?>> eventHandlers = handlers.get(); // handlers에 보관된 List를 구한다.
      if(eventHandlers == null) { // eventHandlers가 null이면 새로운 List 객체를 생성하고 handlers의 값으로 설정한다.
        eventHandlers = new ArrayList<>();
        handlers.set(eventHandlers);
      }
      eventHandlers.add(handler); // List에 핸들러를 등록한다.
    }

    public static void reset() { // handlers에 보관된 List 객체를 삭제한다. 
      if (!publishing.get()) {
        handlers.remove();
      }
    }
  }
  ``` 

- Events는 핸들러 목록을 유지하기 위해 ThreadLocal 변수를 사용한다. 
  - 톰캣과 같은 웹 애플리케이션 서버는 스레드를 재사용하므로 ThreadLocal에 보관한 값을 제거하지 않으면 기대했던 것과 다르게 코드가 동작할 수 있다.
  - 예) 사용자의 요청을 처리한 뒤 Event.reset()을 실행하지 않으면 스레드 handlers가 담고 있는 List에 계속 핸들러 객체가 쌓이게 되어 결국 메모리 부족 에러(OOME, OutOfMemberError)이 발생하게 된다.
  - 따라서, 이벤트 핸들러를 등록하는 응용 서비스는 다음과 같이 마지막에 Events.reset() 메서드를 실행해야 한다.
  ```java
  @Transactional
  public void cancel(OrderNo orderNo) {
    Events.handle(
      (OrderCanceledEvent evt) -> refundService.refund(evt.getOrderNumber())
    );
    
    Order order = findOrder(orderNo);
    order.cancel();

    Events.reset(); // ThreadLocal 변수를 초기화해서 OOME가 발생하지 않도록 함
  }
  ``` 
- 스프링 프레임워크의 AOP를 사용해서 모든 서비스의 public 메서드의 실행이 끝나면 Events.reset()을 실행하도록 할 수도 있다. 
  - 이에 대한 내용은 잠시 뒤에 살펴 보자.


### 흐름 정리
- 이벤트 처리 흐름을 다음 그림에 시퀀스 다이어그램으로 정리했다.
  
  ![image](https://user-images.githubusercontent.com/28394879/137253760-c82bbeb7-fa63-43d1-9c41-54940dfbd68a.png)

- 이벤트 처리 흐름
  1. 이벤트 처리에 필요한 이벤트 핸들러를 생성한다.
  2. 이벤트 발생 전에 이벤트 핸들러를 Events.handle() 메서드를 이용해서 등록한다.
  3. 이벤트를 발생하는 도메인 기능을 실행한다.
  4. 도메인은 Events.raise()를 이용해서 이벤트를 발생한다.
  5. Events.raise()는 등록된 핸들러의 canHandle()을 이용해서 이벤트를 처리할 수 있는지 확인한다.
  6. 핸들러가 이벤트를 처리할 수 있다면 handle() 메서드를 이용해서 이벤트를 처리한다.
  7. Events.raise() 실행을 끝내고 리턴한다.
  8. 도메인 기능 실행을 끝내고 리턴한다.
  9. Events.reset()을 이용해서 ThreadLocal을 초기화한다.

- 코드 흐름을 보면 응용 서비스와 동일한 트랜잭션 범위에서 핸들러의 handle()이 실행되는 것을 알 수 있다.
  - 즉, 도메인의 상태 변경과 이벤트 핸들러는 같은 트랜잭션 범위에서 실행된다.

### AOP를 이용한 Events.reset() 실행
- 응용 서비스가 끝나면 ThreadLocal에 등록된 핸들러 목록을 초기화하기 위해 Events.reset() 메서드를 실행한다.
  - 모든 응용 서비스마다 메서드 말미에 Events.reset()을 실행하는 코드를 넣는 것은 중복에 해당한다.
  - 이런 류의 중복을 없앨 때 적합한 것이 바로 AOP이다.
  - 스프링 AOP를 이용해서 Events.reset()을 실행하는 구현코드는 다음과 같다.
  ```java
  package com.myshop.common.event;

  @Aspect
  @Order(0) // @Order를 이용해서 우선순위를 0으로 지정한다. 이를 통해 트랜잭션 관련 AOP보다 우선순위를 높여 이 AOP가 먼저 적용되도록 설정한다. 
  @Component
  public class EventsResetProcessor {
    private ThreadLocal<Integer> nestedCount = new ThreadLocal<Integer>() { // 서비스 메서드의 중첩 실행 개수를 저장하기 위한 ThreadLocal 변수를 생성한다.
      @Override
      protected Integer initialValue() {
        return new Integer(0);
      }
    }; 

  @Around( // @Around Aspect를 이용해서 AOP를 구현한다. 적용 대상은 com.myshop 패키지 및 그 하위 패키지에 위치한 @Service가 붙은 빈 객체이다.
    "@target(org.springframework.stereotype.Service) and within(com.myshop..*)")
    public Object doReset(ProceedingJoinPoint joinPoint) throws Throwable {
      nestedCount.set(nestedCount.get() + 1); // 중첩 실행 횟수를 1증가한다.
      try {
        return joinPoint.proceed(); // 대상 메서드를 실행한다.
      } finally {
        nestedCount.set(nestedCount.get() - 1); // 중첩 실행 횟수를 1감소한다.
        if (nestedCount.get() == 0) { // 중첩 실행 횟수가 0이면 Events.reset()을 실행한다.
          Events.reset();
        }
      }
    }
  ``` 
- 이 AOP를 적용하면 다음과 같이 @Service가 붙은 클래스는 이제 Events.reset()을 명시적으로 호출하지 않아도 된다.
  ```java
  @Service
  public class CancelOrderService {
    private OrderRepository orderRepository;
    private RefundService refundService;

    @Transactional
    public void cancel(OrderNo orderNo) {
      Events.handle(
        (OrderCancelEvent evt) -> refundService.refund(evt.getOrderNumber()));

      
      Order order = findOrder(orderNo);
      order.cancel();

      // AOP를 이용해서 Events.reset()을 실행 
    }
  }
  ``` 

- 스프링에서 제공하는 @Service 애노테이션을 이용해서 응용 서비스를 지정했는데 @Service를 사용하지 않을 경우 @Around의 포인트컷에 @target 대신 execution() 명시자를 사용해도 된다.
  ```java
  @Around("execution(public * com.myshop..*Serice.*(..))")
  public Object doReset(ProceedingJoinPoint joinPoint) throws Throwable {
    ...
  }
  ``` 

</details>


<details> <summary> 4. 동기 이벤트 처리 문제 </summary>

## 4. 동기 이벤트 처리 문제
- 이벤트를 사용해서 강결합 문제는 해소했지만 아직 남아 있는 문제가 하나 있다.
  - 바로 외부 서비스에 영향을 받는 문제이다. 아래 코드를 보자.
  ```java
  @Transactional // 외부 연동 과정에서 익셉션이 발생하면 트랜잭션 처리는?
  public void cancel(OrderNo orderNo) {
    Events.handle(
      // refundService.refund()가 오래 걸리면?
      (OrderCanceledEvent evt) -> refundService.refund(evt.getOrderNumber()));

      Order order = findOrder(orderNo);
      order.cancel();
  }
  ``` 
- 이 코드에서 refundService.refund()가 외부의 환불 서비스와 연동한다고 가정해보자.
  - 만약 외부 환불 기능이 갑자기 느려지면 cancel() 메서드도 함께 느려지게 된다.
  - 이는 외부 서비스의 성능 지하가 바로 내 시스템의 성능 저하로 연결된다는 것을 의미한다.
- 성능 저하뿐만 아니라 트랜잭션도 문제가 된다.
  - refundService.refund()에서 익셉션이 발생하면 cancel() 메서드의 트랜잭션을 롤백해야 할까?
  - 트랜잭션을 롤백하면 구매 취소 기능을 롤백하는 것이므로 구매 취소에 실패하는 것이다.
  - 생각해 볼 만한 것은 외부의 환불 서비스 실행에 실패했다고 해서 반드시 트랜잭션을 롤백해야 하는지에 대한 문제이다.
  - 일단 구매 취소 자체는 처리하고 환불만 재처리하거나 수동으로 처리할 수도 있다.
- 외부 시스템과의 연동을 동기로 처리할 때 발생하는 성능과 트랜잭션 범위 문제를 해소하는 방법 중 하나가 이벤트를 비동기로 처리하는 것이다. 
  - 이어서 비동기 이벤트 처리에 대해 알아보자.

</details>


<details> <summary> 5. 비동기 이벤트 처리 </summary>

## 5. 비동기 이벤트 처리

- 회원 가입 신청을 하면 검증을 위해 이메일을 보내는 서비스가 많다.
  - 회원 가입 신청을 하자마자 바로 내 메일함에 검증 이메일이 도착해야 할 필요는 없다.
  - 이메일이 수초 후에 도착한다고 해서 문제될 것이 없다.
  - 10~20초 후에 이메일이 도착해도 되고, 심지어 이메일을 받지 못하면 다시 받을 수 있는 기능을 이용해서 다시 받을 수도 있다.
- 비슷하게 주문을 취소하자마자 바로 결제를 취소하지 않아도 된다.
  - 많은 고객은 수분 내에 결제 취소가 이루어지면 만족한다.
  - 어떤 경우에는 몇 일 뒤에 결제가 확실하게 취소되면 문제가 없을 때도 있다.
- 이렇게 우리가 구현해야 할 것 중에서 'A하면 이어서 B하라' 는 내용을 담고 있는 요구사항은 실제로 'A하면 최대 언제까지 B하라' 인 경우가 많다.
  - 즉, 후속 조치를 바로 할 필요 없이 일정 시간 안에만 처리하면 되는 경우가 적지 않다.
  - 게다가, 'A하면 이어서 B하라'는 요구사항에서 B를 하는데 실패하면 일정 간격으로 재시도를 하거나 수동 처리를 해도 상관이 없는 경우가 있다.
  - 앞서 이메일 인증 예가 이에 해당된다.
  - 회원 가입 신청 시점에서 이메일 발송에 실패하더라도 사용자는 이메일 재전송 요청을 이용해서 수동으로 인증 이메일을 다시 받아볼 수 있다.
- 'A하면 일정 시간 안에 B하라'는 요구사항에서 'A하면' 은 이벤트로 볼 수도 있다.
  - '회원 가입 신청을 하면 인증 이메일을 보내라'는 요구사항에서 '회원 가입 신청을 하면'은 '회원 가입 신청함' 이벤트로 볼 수 있다.
  - 따라서, '인증 이메일을 보내라' 기능은 '회원 가입 신청함' 이벤트를 처리하는 핸들러에서 보낼 수 있다.
- 앞서 말했듯 'A하면 이어서 B하라' 는 요구사항 중에서 'A하면 최대 언제까지 B하라'로 바꿀 수 있는 요구사항은 이벤트를 비동기로 처리하는 방식으로 구현할 수 있다.
  - 다시 말해서, A 이벤트가 발생하면 별도 스레드로 B를 수행하는 핸들러를 실행하는 방식으로 요구사항을 구현할 수 있는 것이다.
- 이벤트를 비동기로 구현할 수 있는 방법은 매우 다양한데, 이 절에서는 다음의 네가지 방식으로 비동기 이벤트 처리를 구현하는 방법에 대해 살펴볼 것이다.
  - 로컬 핸들러를 비동기로 실행하기
  - 메시지 큐를 사용하기
  - 이벤트 저장소와 이벤트 포워더 사용하기
  - 이벤트 저장소와 이벤트 제공 API 사용하기
- 네가지 방식은 각자 구현하는 방식도 다르고 그에 따른 장점과 단점이 있다.
  - 각 방식에 대해 차례대로 살펴보자.

### 로컬 핸들러의 비동기 실행 
- 이벤트 핸들러를 비동기로 실행하는 방법은 이벤트 핸들러를 별도 스레드로 실행하는 것이다.
  - 앞서 구현한 Events 클래스에 비동기로 핸들러를 실행하는 기능을 추가한 코드는 다음과 같다.
  - 코드가 다소 길어 일부 코드를 생략했다. 
  ```java
  import java.util.concurrent.ExecutorService;
  import java.util.concurrent.TimeUnit;

  public class Events {
    ...//handlers 필드와 publishing 필드 생략
    private static ThreadLocal<List<EventHandler<?>>> asyncHandlers = new ThreadLocal<>(); // 비동기로 실행할 이벤트 핸들러 목록을 보관할 ThreadLocal 변수인 asyncHandlers를 생성한다.

    private static ExecutorService executor; // 비동기로 이벤트 핸들러를 실행할 때 사용할 ExecutorService를 선언한다.

    public static void init(ExecutorService executor) { // executor를 초기화한다.
      Events.executor = executor;
    }

    public static void close() { // executor를 셧다운한다.
      if(executor != null) {
        executor.shutdown();
        try {
          executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {

        }
      }
    }

    public static void raise(Object event) { 
      if (publishing.get()) return;

      try {
        publishing.set(Boolean.TRUE);
        /* 이벤트를 처리할 수 있는 핸들러를 비동기로 실행한다. */
        List<EventHandler<?>> asyncEvtHandlers = asyncHandlers.get(); 
        if(asyncEvtHandlers != null) {
          for (EventHandler handler : asyncEvtHandlers) {
            if (handler.canHandle(event)) {
              executor.submit(() -> handler.handle(event));
            }
          }
        }
        /* 이벤트를 처리할 수 있는 핸들러를 비동기로 실행한다. */

        List<EventHandler<?>> eventHandlers = handlers.get();
        if(eventHandlers == null) return;
        for (EventHandler handler : eventHandlers) {
          if (handler.canHandle(event)) {
            handler.handle(event);
          }
        }
      } finally {
        publishing.set(Boolean.FALSE);
      }
    }

    public static void handle(EventHandler<?> handler) {
      ... 생략 
    }

    public static void handleAsync(EventHandler<?> handler) { // 비동기로 처리할 이벤트 핸들러를 등록한다.
      if(publishing.get()) return;

      List<EventHandler<?>> eventHandlers = asyncHandlers.get();
      if(eventHandlers == null) {
        eventHandlers = new ArrayList<>();
        asyncHandlers.set(eventHandlers);
      }
      eventHandlers.add(handler);
    }

    public static void reset() { // reset()을 수행할 때 asyncHandler에 보관된 값을 제거한다.
      if (!publishing.get()) {
        handlers.remove();
        asyncHandlers.remove();
      }
    }

  }
  ``` 
- 동기나 비동기로 실행할 이벤트 핸들러를 처리하는 방식은 거의 유사하다.
  - 차이점이라면 비동기로 실행할 이벤트 핸들러는 executor.submit()을 이용해서 스레드 풀에 핸들러 실행 작업을 등록하는 반면에 동기로 실행할 이벤트 핸들러는 바로 실행한다는 점이다.
- executor.submit()에 handler.handle()을 실행하는 람다식을 전달하고 있다.
  - executor는 내부적으로 사용하는 스레드 풀을 이용해서 인자로 전달받은 람다식을 실행하므로 결과적으로 raise() 메서드를 실행하는 스레드가 아닌 다른 스레드를 이용해서 이벤트 핸들러를 비동기로 실행하게 된다.
  ```java
  executor.submit( () -> handler.handle(event) );
  ``` 

- 별도 스레드로 이벤트 핸들러를 사용한다는 것은 raise() 메서드와 관련된 트랜잭션 범위에 이벤트 핸들러 실행이 묶이지 않는다는 것을 의미한다.
  - 다음 코드를 보자.
  ```java
  @Transactional
  public void cancel(OrderNo orderNo) {
    Events.handleAsync(
      (OrderCanceledEvent evt) -> refundService.refund(evt.getOrderNumber()));
    Order order = findOrder(orderNo);
    order.cancel(); // Events.raise(new OrderCanceledEvent()) 실행 
  }
  ``` 

- 이 코드에서 order.cancel() 메서드는 Events.raise()를 이용해서 이벤트를 발생시킨다.
  - 여기서 cancel() 메서드를 실행하는 스레드와 Events.raise() 메서드를 실행하는 스레드는 동일 스레드에서 실행되므로 같은 트랜잭션 범위에 묶인다.
  - 반면에 Events.handleAsync()로 등록한 이벤트 핸들러는 별도 스레드로 실행되므로 refundService.refund() 코드는 cancel()메서드와 관련된 트랜잭션 범위에 묶이지 않는다.
  - 만약 refundService.refund()를 트랜잭션 범위에서 실행되도록 설정했다면 cancel() 메서드와 refundService.refund() 메서드는 서로 다른 트랜잭션 범위에서 실행된다.
 
> 스프링의 트랜잭션 관리자는 보통 스레드를 이용해서 트랜잭션을 전파한다.
> 물론, 스레드가 아닌 다른 방식을 이용해서 트랜잭션을 전파할 수 있지만 일반적으로 사용하는 트랜잭션 관리자는 스레드를 이용해서 트랜잭션을 전파한다.
> 이런 이유로 다른 스레드에서 실행되는 두 메서드는 서로 다른 트랜잭션을 사용하게 된다.

- 별도 스레드를 이용해서 이벤트 핸들러를 실행하면 이벤트 발생 코드와 같은 트랜잭션 범위에 묶을 수 없기 떄문에 한 트랜잭션으로 실행해야 하는 이벤트 핸들러는 비동기로 처리해서는 안 된다.
- Events 클래스는 init() 메서드를 이용해서 이벤트 핸들러를 비동기로 실행할 때 사용할 ExecutorService를 전달받으므로 초기화 과정에서 init() 메서드를 실행해야 한다.
  - 이를 위한 코드는 다음과 같이 작성할 수 있다.
  ```java
  package com.myshop.common.event;

  @Component
  public class AsyncEventsInitializer {

    @PostConstruct
    public void init() {
      Events.init(Executors.newFixedThreadPool(10));
    }

    @PreDestroy
    public void close() {
      Events.close();
    }
  }
  ```
  - 위의 코드는 스프링에서 사용할 빈을 구현한 코드이다.


### 메시징 시스템을 이용한 비동기 구현
- 비동기로 이벤트를 처리해야 할 때 사용하는 또 다른 방법은 RabbitMQ와 같은 메시징 큐를 사용하는 것이다.
  - 이벤트가 발생하면 이벤트 디스패처는 아래 그림과 같이 이벤트를 메시지 큐에 보낸다.
  - 메시지 큐는 이벤트를 메시지 리스너에 전달하고, 메시지 리스너는 알맞은 이벤트 핸들러를 이용해서 이벤트를 처리한다.
  - 이때 이벤트를 메시지 큐에 저장하는 과정과 메시지 큐에서 이벤트를 읽어와 처리하는 과정은 별도 스레드나 프로세스로 처리된다.
   
  ![image](https://user-images.githubusercontent.com/28394879/137421390-cb0aa2dd-349a-4366-8f43-ba3eb060bdfc.png)
 
- 필요하다면 이벤트를 발생하는 도메인 기능과 메시지 큐에 이벤트를 저장하는 절차를 한 트랜잭션으로 묶어야 한다.
  - 도메인 기능을 실행한 결과를 DB에 반영하고 이 과정에서 발생한 이벤트를 메시지 큐에 저장하는 것을 같은 트랜잭션 범위에서 실행하려면 글로벌 트랜잭션이 필요하다.
- 글로벌 트랜잭션을 사용하면 안전하게 이벤트를 메시지 큐에 전달할 수 있는 장점이 있지만, 반대로 글로벌 트랜잭션으로 인해 전체 성능이 떨어지는 단점도 있다.

- 많은 경우 메시지 큐를 사용하면 보통 이벤트를 발생하는 주체와 이벤트 핸들러가 별도 프로세스에서 동작한다.
  - 이는 자바의 경우 이벤트 발생 JVM과 이벤트 처리 JVM이 다르다는 것을 의미한다.
  - 물론, 한 JVM에서 이벤트 발생 주체와 이벤트 핸들러가 메시지 큐를 이용해서 이벤트를 주고 받을 수 있지만, 동일 JVM에서 비동기 처리를 위해 메시지 큐를 사용하는 것은 시스템을 복잡하게 만들 뿐이다.
- RabbitMQ처럼 많이 사용하는 메시징 시스템은 글로벌 트랜잭션 지원과 함께 클러스터와 고가용성을 지원하기 떄문에 안정적으로 메시지를 전달할 수 있는 장점이 있다.
  - 또한, 다양한 개발 언어와 통신 프로토콜을 지원하고 있다.
  - 메시지를 전달하기 위해 많이 사용하는 것중에 Kafka도 있다.
  - Kafka는 글로벌 트랜잭션을 지원하지 않지만 다른 메시징 시스템에 비해 높은 성능을 보여준다.

### 이벤트 저장소를 이용한 비동기 처리
- 비동기로 이벤트를 처리하기 위한 또 다른 방법은 이벤트를 일단 DB에 저장한 뒤에 별도 프로그램을 이용해서 이벤트 핸들러에 전달하는 것이다.
  - 이 방식의 실행 흐름은 다음 그림과 같다.
   
  ![image](https://user-images.githubusercontent.com/28394879/137423421-418a77bc-91bf-4025-921a-993a354c7373.png) 

- 이벤트가 발생하면 핸들러는 스토리지에 이벤트를 저장한다.
  - 포워더는 주기적으로 이벤트 저장소에서 이벤트를 가져와 이벤트 핸들러를 실행한다.
  - 포워더는 별도 스레드를 이용하기 때문에 이벤트 발행과 처리가 비동기로 처리된다.
- 이 방식은 도메인의 상태와 이벤트 저장소로 동일한 DB를 사용한다.
  - 즉, 도메인의 상태 변화와 이벤트 저장이 로컬 트랜잭션으로 처리된다.
  - 이벤트를 물리적 저장소에 보관하기 때문에 핸들러가 이벤트 처리에 실패할 경우, 포워더는 다시 이벤트 저장소에서 이벤트를 읽어와 핸들러를 실행하면 된다.
- 이벤트 저장소를 이용한 두 번째 방법은 아래그림과 같이 이벤트를 외부에 제공하는 API를 사용하는 것이다.
  
  ![image](https://user-images.githubusercontent.com/28394879/137425002-43bf1a48-7c6b-4754-90cf-183cf5e7e9ca.png)

- API 방식과 포워더 방식의 차이점은 이벤트를 전달하는 방식에 있다.
  - 포워더 방식에서는 포워더를 이용해서 이벤트를 외부에 전달하는 방식이라면, API 방식에서는 외부 핸들러가 API 서버를 통해 이벤트 목록을 가져오는 방식이다.
  - 포워더 방식은 이벤트를 어디까지 처리했는지 추적하는 역할이 포워더에 있다면, API 방식에서는 이벤트 목록을 요구하는 외부 핸들러가 자신이 어디까지 이벤트를 처리했는지 기억해야 한다.


### 이벤트 저장소 구현
- 포워더 방식과 API 방식 모두 이벤트 저장소를 사용하므로 이벤트를 저장할 저장소가 필요하다. 
  - 이벤트 저장소를 구현한 코드 구조는 다음 그림과 같다.

  ![image](https://user-images.githubusercontent.com/28394879/137425743-2c486415-3e44-4ef0-b000-0d0914ba379e.png)

  - EventEntry: 이벤트 저장소에 보관할 데이터이다. EventEntry는 이벤트를 식별하기 위한 id, 이벤트의 타입인 type, 직렬화한 데이터의 형식인 contentType, 이벤트 데이터 자체인 payload, 이벤트 시간인 timestamp를 갖는다.
  - EventStore: 이벤트를 저장하고 조회한느 인터페이스를 제공한다.
  - JdbcEventStore: JDBC를 이용한 EventStore 구현 클래스이다.
  - EventApi: REST API를 이용해서 이벤트 목록을 제공하는 컨트롤러이다.
  


- EventEntry 클래스는 다음과 같다. 이벤트 데이터를 정의하고 있다.
  ```java
  public class EventEntry {
    private Long id;
    private String type;
    private String contentType;
    private String payload;
    private long timestamp;
  }

  public EventEntry(String type, String contentType, String payload) {
    this.type = type;
    this.contentType = contentType;
    this.payload = payload;
    this.timestamp = System.currentTimeMillis();
  }
  
  public Long getId() {
    return id;
  }

  public String getType() {
    return type;
  }
  
  public String getContentType() {
    return contentType;
  }
  
  public String getPayload() {
    return payload;
  }

  public long getTimestamp() {
    return timestamp;
  }
  ``` 

- EventStore는 이벤트객체를 직렬화해서 payload에 저장한다.
  - 이때 JSON으로 직렬화 했다면 contentTypeㅡ이 값으로 'application/json'을 갖는다.
  - EventStore 인터페이스는 다음과 같다.
  ```java
  public interface EventStore {
    void save(Object event);
    List<EventEntry> get(long offset, long limit);
  }
  ```  
- 이벤트는 과거에 벌어진 사건이므로 데이터가 변경되지 않는다.
  - 이런 이유로 EventStore 인터페이스는 새로운 이벤트를 추가하는 기능과 조회하는 기능만 제공하고 기존 이벤트 데이터를 수정하는 기능은 제공하지 않는다.
  ```java
  @Component
  public class JdbcEventStore implements EventStore {
    private ObjectMapper objectMapper;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Object event) {
      EventEntry entry = new EventEntry(event.getClass().getName(), "application/json", toJson(event));
      jdbcTemplate.update(
        "insert into evententry (type, content_type, payload, timestamp) values (?, ?, ?, ?)", ps -> {
          ps.setString(1, entry.getType());
          ps.setString(2, entry.getContentType());
          ps.setString(3, entry.getPayload());
          ps.setTimestamp(4, new Timestamp(entry.getTimestamp()));
        });
    }

    private String toJson(Object event) {
      try {
        return objectMapper.writeValueAsString(event);
      } catch (JsonProcessingException e) {
        throw new PayloadConvertException(?e);
      }
    }

    @Override
    public List<EventEntry> get(long offset, long limit) {
      return jdbcTemplate.query("select * from evententry order by id asc limit ?,?", ps -> {
        ps.setLong(1, offset);
        ps.setLong(2, limit);
      },
      (rs, rowNum) -> {
        return new EventEntry(
          rs.getLong("id"), rs.getString("type"), rs.getString("content_type"), rs.getString("payload"), rs.getTimestamp("timestamp").getTime());
    
      });
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
      this.objectMapper = objectMapper;
    }
  }
  ``` 

- 간단한 구현이므로 스프링이 제공하는 JdbcTemplate을 사용했다.
  - save() 메서드는 EventEntry 객체를 생성할 때 파라미터로 전달받은 event 객체를 JSON 문자열로 변환해서 payload로 전달하고, contentType은 'application/json' 으로 설정했다.
- 여기에서는 MySQL을 사용해서 예제를 구현했는데, evententry 테이블의 주요 키를 자동 증가(auto_increment) 칼럼으로 설정했다.
  - 그래서, insert 쿼리를 실행할 때 테이블의 주요 키를 설정하지 않았다.
- get()메서드는 MySQL의 limit을 이용해서 id순으로 정렬했을 때 offset파라미터로 지정한 이벤트부터 limit 개수만큼 데이터를 조회한다.
- EventEntry를 저장할 evententry 테이블의 DDL은 다음과 같다.
  ```
  create table evententry {
    id int not null AUTO_INCREMENT PRIMARY KEY,
    `type` varchar(255),
    `content_type` varchar(255),
    payload MEDIUMTEXT,
    `timestamp` datetime
  } character set utf8;
  ``` 

### 이벤트 저장을 위한 이벤트 핸들러 구현 
- 이벤트 저장소를 위한 기반이 되는 클래스는 모두 구현했다.
  - 이제 남은 것은 발생한 이벤트를 이벤트 저장소에 추가하는 이벤트 핸들러를 구현하는 것이다.
  - 이 핸들러는 다음과 같다.
  ```java
  @Component
  public class EventStoreHandler implements EventHandler<Object> {
    private EventStore eventStore;

    @Override
    public void handle(Object event) {
      eventStore.save(event);
    }

    @Autowired
    public void setEventStore(EventStore eventStore) {
      this.eventStore = eventStore;
    }
  }
  ``` 

- EventStoreHandler의 handle() 메서드는 eventStore.save() 메서드를 이용해서 이벤트 객체를 저장한다.
  - EventStoreHandler는 EventHandler(Object)를 상속받고 있으므로 canHandle() 메서드는 모든 객체에 대해 true를 리턴한다.
  - 즉, 이벤트 타입에 상관없이 이벤트는 저장소에 보관된다.
- EventStoreHandler를 이벤트 핸들러로 사용하려면 응용 서비스의 메서드마다 Events.handle()로 등록해야 한다.
  ```java
  public void changePassword(...) {
    Events.handle(eventStoreHandler); // 모든 응용 서비스에 적용해야 함 
    ...
  }
  ``` 
- 모든 응용 서비스에 대해 이 코드를 추가하면 많은 중복이 발생하므로 중복을 제거하기 위해 AOP를 사용하면 좋다.
  - 여기서 사용할 AOP 구현 코드는 다음과 같다.
  ```java
  @Aspect
  @Order(1)
  @Component
  public class EventStoreHandlerAspect {
    private EventStoreHandler eventStoreHandler;

    @Before("execution(public * com.myshop..*Service.*(..))")
    public void registerEventStoreHandler() throws Throwable {
      Events.handle(eventStoreHandler);
    }

    @Autowired
    public void setEventStoreHandler(EventStoreHandler eventStoreHandler) {
      this.eventStoreHandler = eventStoreHandler;
    }
  }
  ``` 
- Before Aspect이므로 com.myshop의 하위 패키지에 속한 Service의 메서드를 실행하기 이전에 EventStoreHandler가 이벤트 핸들러로 등록되어 서비스를 실행하는 과정에서 발생한 이벤트가 EventStore에 저장된다.


### REST API 구현
- REST API는 단순하다.
  - offset과 limit의 웹 요청 파라미터를 이용해서 EventStore#get을 실행하고 그 결과를 JSON으로 리턴하면 된다.
  - 스프링 MVC의 컨트롤러를 이용해서 REST API를 구현한 코드는 다음과 같다.
  ```java
  @RestController
  public class EventApi {
    private EventStore eventStore;

    @RequestMapping(value = "/api/events", method = RequestMethod.GET)
    public List<EventEntry> list(
      @RequestParam(name="offset", required = true) Long offset,
      @RequestParam(name="limit", required = true) Long limit) { 
      return eventStore.get(offset,limit);
    }
    
    @Autowired
    public void setEventStore(EventStore eventStore) {
      this.eventStore = eventStore;
    }
  }
  ``` 

- EventApi가 처리하는 URL에 연결하면 JSON형식으로 EventEntry 목록을 구할 수 있다.
- 이벤트를 수정하는 기능이 없으므로 REST API도 단순 조회 기능만 존재한다.
- API를 사용하는 클라이언트는 일정 간격으로 다음 과정을 실행한다.
  1. 가장 마지막에 처리한 데이터의 오프셋인 lastOffset을 구한다. 저장한 lastOffset이 없으면 0을 사용한다.
  2. 마지막에 처리한 lastOffset을 offset으로 사용해서 API를 실행한다.
  3. API 결과로 받은 데이터를 처리한다.
  4. offset + 데이터 개수를 lastOffset으로 저장한다.

- 마지막에 처리한 lastOffset을 저장하는 이유는 같은 이벤트를 중복해서 처리하지 않기 위함이다.
  - API를 사용하는 과정을 그림으로 정리하면 다음과 같다.
  
  ![image](https://user-images.githubusercontent.com/28394879/137441899-8dd2fd15-effe-4220-b4ef-3e29411763e3.png) 

   
- 위의 그림에서는 클라이언트가 1분 주기로 최대 5개의 이벤트를 조회하는 상황을 정리한 것이다.
  - 최초로 이벤트를 조회하는 1분 시점에서는 조회한 이벤트가 없으므로 offset이 0이다.
  - 1분 시점에 5개의 이벤트를 조회했다고 해보자.
  - 클라이언트가 읽어온 데이터가 5개이므로 2분 시점에 요청하는 offset은 5가 된다.
- 2분 시점에 오프셋 5 이후로 저장된 이벤트가 3개밖에 없어서 API가 3개의 이벤트를 제공했다고 하자.
  - 그러면 클라이언트는 직접 offset 값인 5에 조회한 이벤트 개수인 3을 더한 8을 3분 시점의 offset 값으로 사용한다.
  - 3분 시점에 제공한 이벤트가 0개이면 클라이언트는 다음 요청 때 3분 시점과 동일한 offset을 사용한다.
- 클라이언트 API를 이용해서 언제든지 원하는 이벤트를 가져올 수 있기 대문에 이벤트 처리에 실패하면 다시 실패한 이벤트부터 읽어와 이벤트를 재처리할 수 있다.
  - API 서버에 장애가 발생한 경우에도 주기적으로 재시도를 해서 API 서버가 살아나면 이벤트를 처리할 수 있다.
  

### 포워더 구현
- 포워더는 앞서 봤던 API 방식에서 클라이언트의 구현과 유사하다.
  - 포워더는 일정 주기로 EventStore로부터 이벤트를 읽어와 이벤트 핸들러에 전달하면 된다.
  - API방식에서 클라이언트와 마찬가지로 마지막으로 전달한 이벤트의 오프셋을 기억해 두었다가 다음 조회 시점에 마지막으로 처리한 오프셋부터 이벤트를 가져오면 된다.
  - 포워더는 다음과 같이 구현해 볼 수 있다.
  ```java
  @Component
  public class EventForwarder {
    private static final int DEFAULT_LIMIT_SIZE = 100;
    
    private EventStore eventStore;
    private OffsetStore offsetStore;
    private EventSender eventSender;
    private int limitSize = DEFAULT_LIMIT_SIZE;

    @Scheduled(initialDelay = 1000L, fixedDelay = 1000L) 
    public void getAndSend() {
      long nextOffset = getNextOffset(); // 읽어올 이벤트의 다음 오프셋을 구한다.
      List<EventEntry> events = eventStore.get(nextOffset, limitSize); // 이벤트 저장소에서 오프셋부터 limitSize만큼 이벤트를 구한다.
      if(!events.isEmpty()) { // 구한 이벤트가 존재하는지 검사한다. 
        int processedCount = sendEvent(events); // 구한 이벤트가 존재하면 sendEvent()를 이용해서 이벤트를 전송한다. sendEvent()는 처리한 이벤트 개수를 리턴한다. 
        if (processedCount > 0) { // 처리한 이벤트 개수가 0보다 크면 다음에 읽어올 오프셋을 저장한다.
          saveNextOffset(nextOffset + processedCount);
        }
      }
    }

    private long getNextOffset() {
      return offsetStore.get();
    }

    private int sendEvent(List<EventEntry> events) {
      int processedCount =0 ;
      try {
        for (EventEntry entry : events) {
          eventSender.send(entry);
          processedCount ++;
        }
      } catch(Exception ex) {
        // 로깅 처리 
      }
      return processedCount;
    }

    private void saveNextOffset(long nextOffset) {
      offsetStore.update(nextOffset);
    }

    ... // 각 필드에 대한 set 메서드 
  }
  ``` 

- getAndSend() 메서드를 주기적으로 실행하기 위해 스프링의 @Scheduled 애노테이션을 사용했다.
  - 스프링을 사용하지 않으면 별도 스케줄링 프레임워클르 이용해서 getAndSend() 메서드를 원하는 주기로 실행하면 된다.
- getNextoffset() 메서드와 saveNextOffset() 메서드에서 사용한 OffsetStore 인터페이스는 다음의 두 메서드를 정의하고 있다.
  ```java
  public interface OffsetStore {
    long get();
    void update(long nextOffset);
  }
  ``` 
- OffsetStore를 구현한 클래스는 오프셋 값을 DB 테이블에 저장하거나 로컬 파일에 보관해서 마지막 오프셋 값을 물리적 저장소에 보관하면 된다.


- sendEvent() 메서드는 파라미터로 전달받은 이벤트를 eventSender.send()를 이용해서 차례대로 발송한다.
  - 익셉션이 발생하면 이벤트 전송을 멈추고 전송에 성공한 이벤트 개수를 리턴한다.
  - 전송에 성공한 이벤트 개수를 리턴하기 떄문에 저장하는 오프셋은 최종적으로 전송에 성공한 이벤트를 기준으로 다음 이벤트에 대한 오프셋이다.
  - 따라서, 다음번에 getAndSend() 메서드를 실행하면 마지막으로 전송에 성공한 이벤트의 다음 이벤트부터 읽어와 전송을 시도하게 된다.
- EventSender 인터페이스는 다음과 같이 단순하다.
  ```java
  public interface EventSender {
    void send(EventEntry event);
  }
  ```  
- 이 인터페이스를 구현한 클래스는 send() 메서드에서 외부 메시징 시스템에 이벤트를 전송하거나 원하는 핸들러에 이벤트를 전달하면 된다.
  - 이벤트 처리 중에 익셉션이 발생하면 그대로 전파해서 다음 주기에 getAndSend() 메서드를 실핼할 때 재처리할 수 있도록한다.




</details>


<details> <summary> 6. 이벤트 적용 시 추가 고려사항 </summary>

## 6. 이벤트 적용 시 추가 고려사항

- 이 장에서 구현하지 않았지만 이벤트를 구현할 때 추가로 고려할 점이 있다.
  - 첫번째는 이벤트 소스를 EventEntry에 추가할지 여부이다.
  - 앞서 구현한 EventEntry는 이벤트발생 주체가 없다.
  - 따라서, 'Order가 발생한 이벤트만 조회하기' 처럼 '특정 주체가 발생한 이벤트만 조회' 하는 기능을 구현할 수 없다.
  - 이 기능을 구현하려면 다음의 다섯 가지를 추가해야 한다.
    - Event.raise()에 source를 파라미터로 추가한다.
    - EventHandler.handle() 메서드에 source를 파라미터로 추가한다.
    - EventEntry에 source필드를 추가한다.
    - EventStore.save()에 source 파라미터를 추가한다.
    - EventStore.get()에 필터 조건으로 source 파라미터를 추가한다.
- 두 번쨰로 고려할 점은 포워더에서 전송 실패를 얼마나 허용할 것이냐에 대한 것이다.
  - 포워더는 이벤트 전송에 실패하면 실패한 이벤트부터 다시 읽어와 전송을 시도한다.
  - 그런데 특정 이벤트에서 계속 전송에 실패하면 어떻게 될까?
  - 이러면 그 이벤트 떄문에 나머지 이벤트를 전송할 수 없게 된다.
  - 따라서, 포워더를 구현할 떄는 실패한 이벤트의 재전송 횟수에 제한을 두어야 한다.
  - 예) 동일 이벤트를 전송하는 데 3회 실패했다면 해당 이벤트는 생략하고 다음 이벤트로 넘어가는 등의 정책이 필요하다.
- 세 번째 고려할 점은 이벤트 손실에 대한 것이다.
  - 이벤트 저장소를 사용하는 방식은 이벤트 발생과 이벤트 저장을 한 트랜잭션으로 처리하기 떄문에 트랜잭션에 성공하면 이벤트가 저장소에 보관된다는 것을 보장할 수 있다.
  - 반면에 로컬 핸들러를 이용해서 이벤트를 비동기로 처리할 경우 이벤트 처리에 실패하면 이벤트를 유실하게 된다.
- 네 번째 고려할 점은 이벤트 순서에 대한 것이다.
  - 이벤트를 발생 순서대로 외부 시스템에 전달해야 할 경우 이벤트 저장소를 사용하는 것이 좋다.
  - 이벤트 저장소는 일단 저장소에 이벤트를 발생 순서대로 저장하고, 그 순서대로 이벤트 목록을 제공하기 때문이다.
  - 반면에 메시징 시스템은 사용 기술에 따라 이벤트 발생 순서와 메시지 전달 순서가 다를 수도 있다.
- 다섯 번째 고려할 점은 이벤트 재처리에 대한 것이다.
  - 동일한 이벤트를 다시 처리해야 할 때 이벤트를 어떻게 할지 결정해야 한다.
  - 가장 쉬운 방법은 마지막으로 처리한 이벤트의 순번을 기억해 두었다가 이미 처리한 순번의 이벤트가 도착하면 해당 이벤트를 처리하지 않고 무시하는 것이다.
  - 예) 회원 가입 신청 이벤트가 처음 도착하면 이메일을 발송하는데, 동일한 순번의 이벤트가 다시 돌아오면 이메일을 발송하지 않는 방식으로 구현한다.
  - 이외에 이벤트 처리를 멱등(idempotent)으로 처리하는 방법도 있다.

**멱등성**
> 연산을 여러 번 적용해도 결과가 달라지지 않는 성질을 멱등성(idempotent)이라고 한다.
> 수학에서 절대값 함수인 abs()가 멱등성을 갖는 대표적인 예이다.
> 어떤 값 x에 대해 abs() 연산을 여러 번 적용해도 결과는 동일하다. 즉, abs(x), abs(abs(x)), abs(abs(abs(x)))는 모두 결과가 같다.
> 비슷하게 이벤트 처리도 동일 이벤트를 한 번 적용하나 여러 번 적용하나 시스템이 같은 상태가 되도록 핸들러를 구현할 수 있다.
> 예) 배송지 정보 변경 이벤트를 받아서 주소를 변경하는 핸들러는 그 이벤트를 한 번 처리하나 여러 번 처리하나 결과적으로 동일 주소를 값으로 갖는다.
> 같은 이벤트를 여러 번 적용해도 결과가 같으므로 이 이벤트 핸들러는 멱등성을 갖는다.
> 이벤트 핸들러가 멱등성을 가지면 시스템 장애로 인해 같은 이벤트가 중복해서 발생해도 결과적으로 동일 상태가 된다. 
> 이는 이벤트 중복 발생이나 중복 처리에 대한 부담을 줄여준다. 

</details>

# 11. CQRS

<details> <summary> 1. 단일 모델의 단점 </summary>

## 1. 단일 모델의 단점

- 주문 내역 조회 기능을 구현하려면 여러 애그리거트에서 데이터를 가져와야 한다.
  - Order에서 주문 정보를 가져와야 하고, Product에서 상품 이름을 가져와야 하고, Member에서 회원 이름과 아이디를 가져와야 한다.

  ![image](https://user-images.githubusercontent.com/28394879/137461674-8310c75c-9c3a-4138-ae2c-997b32ed734b.png)


- 조회 화면의 특성상 조회 속도가 빠를수록 좋은데 여러 애그리거트에서 데이터를 가져와야할 경우 구현 방법을 고민해야 한다.
  - 3장에서 언급한 ID를 이용해서 애그리거트를 참조하는 방식을 사용하면 즉시 로딩(eager loading) 방식과 같은 JPA의 쿼리 관련 최적화 기능을 사용할 수 없다.
  - 이는 한 번의 select 쿼리로 조회 화면에 필요한 데이터를 읽어올 수 없어 조회 속도에 문제가 생길 수 있다.
- 애그리거트 간의 연관을 ID가 아니라 직접 참조는 방식으로 연결해도 고민거리가 생긴다.
  - 조회 화면의 특성에 따라 같은 연관도 즉시 로딩이나 지연 로딩(lazy loading)으로 처리해야 하기 때문이다.
  - 경우에 따라 DBMS가 제공하는 전용 기능을 이용해서 조회 쿼리를 작성해야 해서 JPA의 네이티브 쿼리를 사용해야 할 수도 있다.
- 이런 고민이 발생하는 이유는 시스템의 상태를 변경할 때와 조회할 때 단일 도메인 모델을 사용하기 떄문이다.
  - 객체 지향으로 도메인 모델을 구현할 때 주로 사용하는 ORM 기법은 Order.cancel()이나 Order.changeShippingInfo()처럼 도메인의 상태 변경을 구현하는데도 적합하지만, 주문 상세 조회 화면처럼 여러 애그리거트에서 데이터를 가져와 출력하는 기능을 구현하기에는 고려할 것들이 많아서 구현을 복잡하게 만드는 원인이 된다.
- 이런 구현 복잡도를 낮추는 방법이 있는데 그것은 바로 상태 변경을 위한 모델과 조회를 위한 모델을 분리하는 것이다.

</details>

<details> <summary> 2. CQRS </summary>


## 2. CQRS 

- 시스템이 제공하는 기능은 크게 두 가지로 나누어 생각해 볼 수 있다.
- 하나는 상태를 변경하는 기능이다. 새로운 주문을 생성하거나, 배송지 정보를 변경하거나, 회원의 암호를 변경하는 기능이 이에 해당한다.
  - 개발자는 현재 저장하고 있는 데이터를 변경하는 방식으로 기능을 구현한다.
- 또 다른 하나는 사용자 입장에서 상태 정보를 조회하는 기능이다.
  - 주문 상세 내역 보기, 게시글 목록 보기, 회원 정보 보기, 판매 통계 보기가 이에 해당 된다.
  - 조회 기능은 필요한 데이터를 읽어와 UI를 통해 보여주는 방식으로 구현한다.
- 도메인 모델 관점에서 상태 변경 기능은 주로 한 애그리거트의 상태를 변경한다.
  - 예) 주문 취소 기능과 배송지 정보 변경 기능은 한 개의 Order 애그리거트를 변경한다.
  - 반면에 조회 기능은 한 애그리거트의 데이터를 조회할 수도 있지만 두 개 이상의 애그리거트에서 데이터를 조회할 수도 있다.
  - 앞서 살펴본 주문 상세 조회 기능이 이에 해당된다.
- 상태를 변경하는 범위와 상태를 조회하는 범위가 정확하게 일치하지 않기 때문에 단일 모델로 두 종류의 기능을 구현하면 모델이 불필요하게 복잡해진다.
  - 단일 모델을 사용할 때 발생하는 복잡도를 해결하기 위해 사용하는 방법이 있는데, 그것이 바로 CQRS이다.
- CQRS는 Command Query Responsibility Segregation의 약자로 다음 그림과 같이 상태를 변경하는 명령(Command)을 위한 모델과 상태를 제공하는 조회(Query)를 위한 모델을 분리하는 패턴이다.

  ![image](https://user-images.githubusercontent.com/28394879/137466006-de50011c-77d9-479d-869f-31cb48c9e64b.png)


- CQRS는 복잡한 도메인에 적합하다.
  - 도메인이 복잡할수록 명령 기능과 조회 기능이 다루는 데이터 범위에 차이가 발생하는데, 이 두 기능을 단일 모델로 처리하게 되면 조회 기능의 로딩 속도를 위해 모델 구현이 필요 이상으로 복잡해지는 문제가 발생한다.
  - 예) 온라인 쇼핑에서 다양한 차원에서 주문/판매 통계를 조회해야 한다고 해보자
  - JPA 기반의 단일 도메인 모델을 사용하면 통계 값을 빠르게 조회하기 위해 JPA의 관련된 다양한 성능 관련 기능을 모델에 적용해야 한다.
  - 이런 도메인에 CQRS를 적용하면 통계를 위한 조회 모델을 별도로 만들기 때문에 조회 때문에 도메인 모델이 복잡해지는 것을 막을 수 있다.

- CQRS를 사용하면 각 모델에 맞는 구현 기술을 선택할 수 있다.
  - 예) 명령 모델은 객체 지향에 기반해서 도메인 모델을 구현하기에 적당한 JPA를 사용해서 구현하고, 조회 모델은 DB 테이블에서 SQL로 데이털르 조회할 때 좋은 MyBatis를 사용해서 구현할 수 있다.

  ![image](https://user-images.githubusercontent.com/28394879/137467075-8c06694a-c508-42aa-bab2-8e7746a6bf54.png)

  
- 위 그림을 보면 조회 모델에는 응용 서비스가 존재하지 않는다.
  - 단순히 데이터를 읽어와 조회하는 기능은 응용 로직이 복잡하지 않기 떄문에 컨트롤러에서 바로 DAO를 실행해도 무방하다.
  - 물론, 데이터를 표현 영역에 전달하는 과정에서 몇 가지 로직이 필요하다면 응용 서비스를 두고 로직을 구현하면 된다.
- 아래 그림은 명령 모델과 조회 모델의 설계 예를 보여주고 있다.
  - 상태 변경을 위한 명령 모델은 객체를 기반으로 한 도메인 모델을 이용해서 구현한다.
  - 반면에 조회 모델은 주문 요약 목록을 제공할 떄 필요한 정보를 담고 있는 데이터 타입을 이용한다.
  - 두 모델 모두 주문과 관련되어 있지만 명령 모델은 상태를 변경하는 도메인 로직을 수행하는데 초점을 맞춰 설계했고, 조회 모델은 화면에 보여줄 데이터를 조회하는 데 초점을 맞춰 설계했다.

  ![image](https://user-images.githubusercontent.com/28394879/137469143-05a4b85b-874d-4e4a-892e-5ad3a7356cec.png)


- 명령 모델과 조회 모델이 같은 구현 기술을 사용할 수도 있다.
  - 이에 대한 내용은 이미 5장에서 다룬바 있다.
  - 5장의 '조회 전용 기능 구현' 절에서 JPQL을 이용한 동적 인스턴스 생성과 하이버네이트의 @Subselect를 이용하는 방법을 설명했는데, 여기서 동적 인스턴스로 사용할 클래스와 @Subselect를 적용한 클래스가 조회 모델에 해당한다.

- 아래의 그림과 같이 명령 모델과 조회 모델이 서로 다른 데이터 저장소를 사용할수도 있다.
  - 명령 모델은 트랜잭션을 지원해 주는 RDBMS를 사용하고, 조회 모델은 조회 성능이 좋은 메모리 기반 NoSQL을 사용할 수 있을 것이다.

  ![image](https://user-images.githubusercontent.com/28394879/137470451-ef3048ee-413c-4807-8899-66e42f54bc09.png)

- 두 데이터 저장소 간의 데이터 동기화는 10장에서 배운 이벤트를 활용해서 처리한다.
  - 명령 모델에서 상태를 변경하면 이에 해당하는 이벤트가 발생하고, 그 이벤트를 조회 모델에 전달해서 변경 내역을 반영하면 된다.
- 명령 모델과 조회 모델이 서로 다른 데이터 저장소를 사용할 경우 데이터 동기화 시점에 따라 구현 방식이 달라질 수 있다.
  - 명령 모델에서 데이터가 바뀌자마자 변경 내역을 바로 조회 모델에 반영해야 한다면 동기 이벤트와 글로벌 트랜잭션을 사용해서 실시간으로 동기화를 할 수 있다.
  - 하지만 10장에서 언급한 것처럼 동기 이벤트와 글로벌 트랜잭션을 사용하면 전반적인 성능(응답 속도와 처리량)이 떨어지는 단점이 있다.
- 서로 다른 저장소의 데이터를 특정 시간 안에만 동기화하면 된다면 비동기로 데이터를 전송해도 된다.
  - 예) 통계 처리 목적으로 조회 전용 저장소를 구축했을 떄
  - 통계 데이터는 수초, 수분 또는 1시간 단위로 최근 데이터를 반영해도 문제가 되지 않을 때가 많다.
  - 이러한 경우라면 비동기로 데이터를 보냄으로써 데이터 동기화로 인해 명령 모델이 성능이 나빠지지 않도록 할 수 있다.

> CQRS 패턴을 적용하기 위해 반드시 사용해야 할 기술이 따로 존재하는 것은 아니다.
> 5장에서 언급한 것 처럼 JPA만 사용해서 명령 모델과 조회 모델을 구현할 수도 있다.
> 명령 모델은 JPA로 구현하고 조회 모델은 직접 SQL을 사용해서 구현할 수도 있다.

### 웹과 CQRS
- 일반적인 웹 서비스는 상태를 변경하는 요청보다 상태를 조회하는 요청이 많다.
  - 온라인 쇼핑몰을 보면 주문 요청보다 카탈로그를 조회하고 상품의 상세 정보를 조회하는 요청이 비교할 수 없을 정도로 더 많다.
  - 게시판도 한번 등록한 게시글을 수십에서 수천 내지 수백만 번 조회한다.
- 포털이나 대형 온라인 쇼핑몰과 같이 조회 기능 요청 비율이 월등히 높은 서비스를 만드는 개발팀은 조회 성능을 높이기 위해 다양한 기법을 사용한다.
  - 기본적으로 쿼리 최적화를 해서 쿼리 실행 속도 자체를 높이고, 메모리에 조회 데이터를 캐시해서 응답 속도를 높이기도 한다.
  - 조회 전용 저장소를 따로 사용하기도 한다.
- 이렇게 조회 성능을 높이기 위해 다양한 기법을 사용하는 것은 결과적으로 CQRS를 적용하는 것과 같은 효과를 만든다.
  - 메모리에 캐시하는 데이터는 DB에 보관된 데이터를 그대로 저장하기보다는 화면에 맞는 모양으로 변환한 데이터를 캐시할 때 성능에 더 유리하다.
  - 즉, 조회 전용 모델을 캐시하는 것이다.
  - 비슷하게 조회 속도를 높이기 위해 쿼리를 최적화한다느 것은 조회 화면에 보여질 데이터를 빠르게 읽어올 수 있도록 쿼리를 작성한다는 것이다.
- 대규모 트래픽이 발생하는 웹 서비스는 알게 모르게 CQRS를 적용하게 된다.
  - 단지, 명시적으로 명령 모델과 조회 모델을 구분하지 않을 뿐이다.
  - 조회 속도를 높이기 위해 별도 처리를 하고 있다면 명시적으로 명령 모델과 조회 모델을 구분하자.
  - 이를 통해 조회 기능 때문에 명령 모델이 복잡해지는 것을 방지할 수 있고 명령 모델에 관계없이 조회 기능에 특화된 구현 기법을 보다 쉽게 적용할 수 있다.


### CQRS 장단점
- CQRS 패턴을 적용할 때 얻을 수 있는 장점 중 하나는 명령 모델을 구현할 때 도메인 자체에 집중할 수 있다는 점이다.
  - 복잡한 도메인은 주로 상태 변경 로직이 복잡한데 명령 모델과 조회 모델을 구분하면 조회 성능을 위한 코드가 명령 모델에 없으므로 도메인 로직을 구현하는 데 집중할 수 있다.
  - 또한 명령 모델에서 조회 관련 로직이 사라져 복잡도를 낮춰준다.
- 또 다른 장점은 조회 성능을 향상시키는 데 유리하다는 점이다.
  - 조회 단위로 캐시 기술을 적용할 수 있고, 조회에 특화된 쿼리를 마음대로 사용할 수도 있다.
  - 캐시뿐만 아니라 조회 전용 저장소를 사용하면 조회 처리량을 대폭 늘릴 수도 있다.
  - 조회 전용 모델을 사용하기 때문에 조회 성능을 높이기 위한 코드가 명령 모델에 영향을 주지 않는다.
  ![image](https://user-images.githubusercontent.com/28394879/137658921-25cd7aa5-ab84-468a-9af4-b463153bf80b.png)


- 물론 단점도 있다.
- 첫 번째 단점은 구현해야 할 코드가 더 많다는 점이다.
  - 단일 모델을 사용할 때 발생하는 복잡함 떄문에 발생하는 구현 비용과 조회 전용 모델을 만들 떄 발생하는 구현 비용을 따져봐야 한다.
  - 도메인이 복잡하거나 대규모 트래픽이 발생하는 서비스라면 조회 전용 모델을 만드는 것이 향후 유지보수에 유리할 수 있다.
  - 반면에 도메인이 단순하거나 트래픽이 많지 않은 서비스라면 조회 전용 모델을 만들 이유가 없다.
- 두 번째 단점은 더 많은 구현 기술이 필요하다는 것이다.
  - 명령 모델과 조회 모델을 다른 구현 기술을 사용해서 구현하기도 하고 경우에 따라 다른 저장소를 사용하기도 한다.
  - 또한, 데이터 동기화를 위해 메시징 시스템을 도입해야 할 수도 있다.
- 이런 장단점을 고려해서 CQRS 패턴을 도입할지 여부를 결정해야 한다.
  - 도메인이 복잡하지 않은데 CQRS를 도입하면 두 모델을 유지하는 비용만 높아지고 얻을 수 있는 이점은 없다.
  - 반면에 트래픽이 높은 서비스인데 단일 모델을 고집하면 유지보수 비용이 오히려 높아질 수 있으므로 CQRS 도입을 고려해보자.



</details>