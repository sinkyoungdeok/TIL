- [1. 코틀린 이해하기](#1-코틀린-이해하기)
  - [1. 코틀린의 현재와 미래](#1-코틀린의-현재와-미래)
    - [코틀린을 배워야 하는 이유](#코틀린을-배워야-하는-이유)
    - [유명 오픈 소스 프로젝트의 코틀린 지원 현황](#유명-오픈-소스-프로젝트의-코틀린-지원-현황)
  - [2. 자바와 코틀린의 차이점](#2-자바와-코틀린의-차이점)
    - [자바에는 있지만 코틀린에는 없는 기능](#자바에는-있지만-코틀린에는-없는-기능)
      - [체크드 익셉션이란](#체크드-익셉션이란)
      - [자바에서의 체크드 익셉션](#자바에서의-체크드-익셉션)
      - [코틀린에서의 체크드 익셉션](#코틀린에서의-체크드-익셉션)
      - [기본 자료형](#기본-자료형)
      - [정적 멤버](#정적-멤버)
      - [삼항 연산자](#삼항-연산자)
      - [세미콜론](#세미콜론)
    - [코틀린에는 있지만 자바에는 없는 기능](#코틀린에는-있지만-자바에는-없는-기능)
      - [확장](#확장)
      - [데이터 클래스](#데이터-클래스)
      - [문자열 템플릿](#문자열-템플릿)
      - [널 안정성](#널-안정성)
      - [기타](#기타)
  - [3. 스프링의 코틀린 지원](#3-스프링의-코틀린-지원)
    - [@ConfigurationProperties](#configurationproperties)
    - [테스트 지원](#테스트-지원)
    - [확장 함수](#확장-함수)
    - [코루틴](#코루틴)
- [2. 코틀린 문법 학습하기](#2-코틀린-문법-학습하기)
  - [1. 코틀린 기초](#1-코틀린-기초)
    - [1. 변수](#1-변수)
    - [2. 함수](#2-함수)
    - [3. 흐름 제어](#3-흐름-제어)
    - [4. 널 안정성](#4-널-안정성)
      - [널 참조의 위험성](#널-참조의-위험성)
      - [kotlin nullable 기본](#kotlin-nullable-기본)
      - [kotlin nullable 예제](#kotlin-nullable-예제)
    - [5. 예외처리](#5-예외처리)
    - [6. 클래스와 프로퍼티](#6-클래스와-프로퍼티)
    - [7. 상속](#7-상속)
    - [8. 인터페이스](#8-인터페이스)
    - [9. 열거형](#9-열거형)
  - [2. 코틀린 고급](#2-코틀린-고급)
    - [1. 컬렉션 타입](#1-컬렉션-타입)




# 1. 코틀린 이해하기 

## 1. 코틀린의 현재와 미래 

### 코틀린을 배워야 하는 이유
- 코틀린은 젯브레인사에서 만든 언어이므로 intellij에서 자동완성, 자바-코틀린 변환, 코루틴 등 코틀린 관련 편의 기능을 완벽히 지원
- 자바는 발표된지 20년이 넘었지만 코틀린, C#, 스위프트와 같은 현대적 언어에 비해 기능이 부족
- 자바에서 Best-Practice로 불리는 기법들을 코틀린에서는 언어적 차원에서 기본 제공 
- 자바에 비해 문법이 간결하기 때문에 가독성과 생산성이 높고 오류 가능성이 적어진다
- 자바에 익숙하면 쉽게 익힐 수 있다.
- 자바와 상호 운용이 가능해서 기존 자바 프로젝트에 쉽게 적용할 수 있다. 
- 멀티 플랫폼 언어로써 서버, 모바일앱, 프론트 등 모든 분야에서 사용 가능

### 유명 오픈 소스 프로젝트의 코틀린 지원 현황
- 스프링 프레임워크
- Gradle
  - 오픈 소스 빌드 자동화 도구
  - Kotlin DSL을 지원하기 떄문에 Intellij의 지원(자동 완성, 컴파일 검사)를 받을 수 있음
- Ktor (서버)
- Exposed (ORM)

## 2. 자바와 코틀린의 차이점

### 자바에는 있지만 코틀린에는 없는 기능


#### 체크드 익셉션이란
- 자바의 익셉션 계층
  - Throwable: 예외 계층의 최상위 클래스 (다음 계층으로는 Error 와 Exception 계층이 있음)
  - Error: 시스템에 비정상적인 상황이 발생. 예측이 없고 기본적으로 복구가 불가능 
    - ex) OutOfMemoryError, StackOverflowError, etc..
  - Exception: 시스템에서 포착 가능하여(try-catch)복구 가능, 예외 처리 강제 (다음 계층으로는 RuntimeException, Checked excpetions가 있음)
    - ex) IOException, FileNotFoundException, etc..
    - `@Transactional` 에서 해당 예외가 발생하면 기본적으로 롤백이 동작하지 않음
  - RuntimeException: 런타임시에 발생하는 예외, 예외 검사를 강제하지 않음 (unchecked Exception임)
    - ex) NullPointerException, AnalyIndexOutOfBoundsException, etc 

#### 자바에서의 체크드 익셉션
- 자바에서 체크드 익셉션은 컴파일 에러가 발생하기 떄문에 무조건 try-catch로 감싸거나 throws로 예외를 전파해야 한다.
- 대부분의 개발자들이 자바에서 체크드 익셉션을 처리할 때 의미 없는 처리를 반복한다.
- 체크드 익셉션이 발생할 경우 catch안에서 에러를 해결하는 일은 생각보다 흔하지 않고 오히려 생산성을 감소시킨다.

```java
try {
  log.append(message)
} catch (IOException e) {
  // Do nothing
}

try {
  File file = FileUtils.get(filename);
} catch (FileNotFoundException e) {
  // 파일이 없으면 처리할만한게 없다
}

try {
  return objectMapper.readValue(json, clazz);
} catch (IOException e) {
  // 단순 에러 로그 출력
  logger.error(e.message(), e);
}
```

#### 코틀린에서의 체크드 익셉션
- 코틀린은 체크드 익셉션을 강제하지 않는다.
```kotlin
Thread.sleep(1); // 자바에서는 체크드 익셉션에 대한 처리 필요
```

- 원하는 경우 try-catch를 쓸 수 있다.
```kotlin
try {
  Thread.sleep(1);
} catche(e: Exception) {
  // 예외 처리
}
```

#### 기본 자료형 
- 자바는 원시 자료형을 지원하며 객체로된 레퍼런스 타입도 지원한다.
```java
int i = 0;
Integer ii = 0;
String str = ii.toString();
```

- 코틀린은 레퍼런스 타입만 지원한다.
```kotlin
val i: Int = 0
val str: String = i.toString()
```

- 코틀린의 레퍼런스 타입은 최적화된 방식으로 컴파일된다
```java
int i = 0;
String str = String.valueOf(i);
```

#### 정적 멤버 
- 자바는 static 키워드로 정적 멤버를 선언한다
```java
public class JavaClass {
  static int i = 0;
  public static void staticMethod() {

  }
}
```

- 코틀린은 `companion object`로 대체 
```kotlin
class KotlinClass {
  
  companion object {
    val i: Int = 0

    fun function() {
      
    }
  }
}
```

#### 삼항 연산자
- 자바는 삼항 연산자가 존재하지만, 코틀린은 if-else로 대체한다.
```java
String animalSound = "호랑이".equals(animal) ? "어흥" : "야옹";
```

```kotlin
val animalSound: String = if ("효랑이" ==animal) "어흥" else "야옹"
```


#### 세미콜론
- 자바는 라인의 끝이 무조건 세미콜론이 있어야 하지만, 코틀린은 선택이다.
```java
Boolean isAdmin = userService.isAdmin(userId); 
```

```kotlin
val isAdmin: Boolean = userService.isAdmin(userId)
```


### 코틀린에는 있지만 자바에는 없는 기능

#### 확장
- 개발자가 임의로 객체의 함수나 프로퍼티를 확장해서 사용할 수 있다.

```kotlin
fun String.first(): Char {
  return this[0]
}

fun String.addFirst(char: Char): String {
  return char + this.substring(0)
}

fun main() {
  println("ABCD".first()) // A

  println("ABCD".addFirst('Z')) // ZABCD
}
```

#### 데이터 클래스
- 데이터를 보관하거나 전달하는 목적을 가진 불변 객체로 사용 ex) DTO

```kotlin
data class Person(val name: String, val age: Int) 
// hashCode(), equals(), toString() 자동 생성
// 이외에도 copy(), componentN()도 유용
```

- 기존 자바에선 Lombok으로 사용
- JDK 15에서는 record라는 이름으로 추가됨
```java
public record Person(String name, int age) {
}
```

#### 문자열 템플릿
- 문자열에 변수를 사용하거나 여러 행으로 된 텍스트 블록을 만들 수 있다.
```kotlin
val text = "World"
val greeting = "Hello, ${text}"

// 문자열 템플릿 기반의 다이나믹 쿼리
fun sql(nameIncluded: Boolean) = 
  """
    SELECT id, name, email, age
    FROM users
    WHERE id = :id
    ${
      if (nameIncluded) {
        """
        AND name = :name
        """
      }
    } else ""
  """
```

#### 널 안정성
- 자바에서 가장 많이 발생하는 예외는 `NullPointerException` 줄여서 NPE
- 자바의 옵셔널(Optional)은 값을 래핑하기 떄문에 객체 생성에 따른 오버헤드가 발생하고, 컴파일 단계에서 Null 가능성을 검사하지 않음
- 코틀린은 언어적 차원에서 NPE가 발생할 가능성을 제거한다.

```kotlin
val a : String = null 

val b : String = "aabbcc"
b = null // 컴파일 오류
```

- Nullable 참조는 컴파일 단계에서 널 안정성을 제공
```kotlin
var a : String? = null
a.length // 컴파일 오류 

a?.length // safe-call 정상

a!!.length // Null이 아니라고 확신하는 경우
```

#### 기타
- 스마트 캐스트
- 실드 클래스 (Jdk 15추가)
- 위임
- 중위 표현식
- 연산자 오버로딩
- 코루틴
- etc

## 3. 스프링의 코틀린 지원 

### @ConfigurationProperties
- 스프링 애플리케이션에 지정한 설정을 기반으로 설정 클래스를 만들 때 `@ConstructorBinding`을 사용하면 setter가 아닌 생성자를 통해 바인딩 하므로 불변 객체를 쉽게 생성할 수 있다.
```kotlin
@ConstructorBinding
@ConfigurationProperties
```

### 테스트 지원
- 기본 제공되는 Junit5 기반의 테스트를 특별한 설정 없이 그대로 사용 가능
- Mockito 대신 MockK를 사용할 수 있다.
- `@MockBean` `@SpyBean` --> `@MockkBean`, `@SpykBean`

### 확장 함수
- 스프링에서 지원하는 코틀린 API의 대부분은 확장 기능을 사용해 기존 API에 코틀린 API를 추가 
- 스프링 프로젝트에선 확장함수를 통해 기존 자바 API를 건드리지 않고 쉽게 코틀린 확장 기능을 추가하고 있다.
```kotlin
pakcage org.springframework.data.repository

fun <T, ID> CrudRepository<T, ID>.findByIdOrNull(id: ID): T? {
  return findById(id).orElse(null)
}

class MyService(
  private val myRepository: MyRepository,
) {
  fun findById(id: Long): My? = myRespotiroy.findByIdOrNull(id)
}
```

### 코루틴
- 비동기-논블로킹 방식을 선언형으로 구현하기 위한 코틀린 기능
- 스프링 MVC, 스프링 WebFlux 모두 코루틴을 지원하여 의존성만 추가하면 바로 사용 가능 
- 코루틴이 지원되어 비동기-논블로킹 스타일의 구현을 쉽게 할 수 있다.

# 2. 코틀린 문법 학습하기

## 1. 코틀린 기초 

### 1. 변수 

```kotlin
var x = 5 // 탑 레벨 변수 (클래스에 속하지 않은 변수)

fun main() {
  x += 1
  println(x)

  val a : Int = 1

  val b = 1

  val c : Int // 지연 할당 
  c = 3

}
```
- 지연 할당에서는 타입을 명시해야 된다. -> 명시하지 않으면 컴파일 에러 
- val == value (readonly 타입) 
- var == variable (가변 변수)

### 2. 함수

```kotlin
// 기본적인 함수 선언 - 반환 타입을 제거하면 컴파일 오류
func sum(a: Int, b: Int) : Int {
  return a + b
}

// 표현식 
fun sum2(a: Int, b: Int) : Int a + b

// 표현식 & 반환 타입 생략
fun sum3(a: Int, b: Int) = a + b

// 반환타입이 없는 함수는 Unit(자바에서는 Void와 유사) 을 반환한다
fun printSum(a: Int, b: Int) {
  println("$a + $b = ${a + b}")
}

// 디폴트 파라미터 
fun greeting(message: String = "안녕하세요") {
  println(message)
}

// named argument
fun log(level: String = "INFO", message: String) {
  println("[$level]$message")
}

fun main() {
  log(message = "인포 로그")
}
```

### 3. 흐름 제어

- if else 
```kotlin
fun main() {

  // if else
  val job = "Software Developer"
  if (job == "Software Developer") {
    println("개발자")
  } else {
    println("개발자 아님")
  }

  // 코틀린의 if else는 표현식이다. 자바의 if else는 구문이다. 
  val age:  Int = 10

  val str = if (age > 10) {
    "성인"
  } else {
    "아이"
  }

  // 코틀린은 삼항 연산자가 없다. if else가 표현식이므로 불필요하다.
  val a = 1
  val b = 2
  val c = if (b > a) b else a 
}
```


- when 
```kotlin
fun main() {
  
  // 자바 코드를 코틀린의 when식으로 변환 
  val day = 2

  val result = when (day) {
    1 -> "월요일"
    2 -> "화요일"
    3 -> "수요일"
    4 -> "목요일"
    else -> "기타"
  }
  println(result)

  // else를 생략할 수 있다.
  when(getColor()) {
    Color.RED -> print("red")
    Color.GREEN -> println("green")
  }

  // 여러개의 조건을 콤마로 구분해 한줄에서 정의할 수 있다.
  when (getNumber()) {
    0, 1 -> print("0 or 1")
    else -> print("not (0 or 1)")
  }
}

enum class Color {
  RED, GREEN
}

fun getColor() = Color.RED

fun getNumber() = 2
```


- for
```kotlin
fun main() {

  // 범위 연산자 .. 를 사용해 for loop 
  for (i in 0..3) {
    println(i) // 0,1,2,3
  }

  // until 을 사용 
  // 뒤에 온 숫자는 포함하지 않는다 
  for (i in 0 until 3) {
    println(i) // 0,1,2
  }

  // step에 들어온 값 만큼 증가
  for (i in 0..6 step 2) {
    println(i) // 0 2 4 6
  }

  // downTo를 사용해 반복
  for (i in 3 downTo 1) {
    println(i) // 3 2 1
  }

  // 전달받은 배열 반복 
  val numbers = arrayOf(1,2,3)

  for (i in numbers) {
    println(i) // 1 2 3 
  }
}
```


- while (자바와 동일)
```kotlin
fun main() {
  var x = 5

  while (x >0) {
    println(x)
    x--
  }
}
```

### 4. 널 안정성 

#### 널 참조의 위험성
- 자바를 포함한 많은 프로그래밍 언어에서 가장 많이 발생하는 예외 유형은 `NullPointerException` 즉 `NPE`
- 자바에서는 NPE를 줄이기 위해 JDK8에서 `Optional`을 지원한다.
- 자바의 옵셔널은 값을 래핑하기 떄문에 객체 생성에 따른 오버헤드가 발생하고, 컴파일 단계에서 Null 가능성을 검사 못함 
- 코틀린을 비롯한 최신 언어에선 널 가능성을 컴파일러가 미리 감지해서 NPE 가능성을 줄일 수 있다.


#### kotlin nullable 기본
```kotlin
fun main() {
  
  val a : String = null // 컴파일 오류 발생
  val b : String = "aa"
  b = null // 컴파일 오류 발생

  val a : String? = null // null이 가능한 타입
  a.length // 컴파일 오류
  println(a?.length) // null 출력

  val b: Int = if(a != null) a.length else 0
  println(b) // 0

  val c = a?.length ?: 0 // ?: -> 엘비스 연산자
  println(c) // 0, 위 로직과 동일함
}
```


#### kotlin nullable 예제

```kotlin
fun getNullStr(): String? = null

fun getLengthIfNotNull(str: String?) = str?.length ?: 0

fun main() {
  val nullableStr = getNullStr()

  val nullableStrLength = nullableStr?.length ?: 0
  println(nullableStrLength) // 0

  val length = getLengthIfNotNull(null)
  println(length) // 0

  val c: String ?= null
  val d = c!!.length // 단언 연산자. 여기에서는 nullPointerException 발생
}
```

### 5. 예외처리

- 코틀린의 모든 예외 클래스는 최상위 예외 클래스인 `Throwable`을 상속한다. 

![image](https://user-images.githubusercontent.com/28394879/196023739-1d75d05f-b5af-4f9c-a936-3de90069e003.png)
- Error
  - 시스템에 비정상적인 상황이 발생.
  - 예측이 어렵다 
  - 기본적으로 복구가 불가능 함
  - ex) OutOfMemoryError, StackOverflowError, etc
- Exception
  - 시스템에서 포착 가능하다. (try-catch)
  - 복구 가능
  - 예외 처리 강제
  - `@Transactional` 에서 해당 예외가 발생하면 기본적으로는 롤백이 동작하지 않음 (rollbackFor를 사용해야 함 )
  - ex) IOException, FileNotFoundException, etc
- RuntimeException
  - 런타임시에 발생하는 예외 
  - 예외 처리를 강제 X
  - ex) NullPointerException, ArrayIndexOutOfBoundsException, etc 
- Checked Exceptions
  - 자바는 컴파일에러가 발생하기 떄문에 무조건 try-catch 로 감싸거나 throws로 예외를 전파해야함
  - 코틀린은 강제하지 않는다 
  - ex) InterruptedException 

```kotlin
fun main() {
  try {
    throw Exception()
  } catch(e: Exception) {
    println("에러 발생!")
  } finally {
    println("finally 실행!")
  }

  val a = try{ 
    "1234".toInt()
  } catch (e: Exception) {
    println("예외 발생")
  }
  println(a)
}
```
- 코틀린은 try도 표현식이다. 

```kotlin
fun main() {
  val b: String? = null
  val c: String = b ?: failFast("a is null")

  println(c.length) // null 일경우 exception을 발생하므로, ?.처리가 필요없다.
}

fun failFast(message: String): Nothing {
  throw IllegalArgumentException(message)
}
```
- 코틀린은 아무것도 반환하지 않으면 Unit타입을 사용 한다. 
- 코틀린은 정상적으로 실행을 보장하지 않는 경우 Nothing이라는 타입을 반환한다. (예외가 발생할 수 있는 경우)

### 6. 클래스와 프로퍼티

```kotlin
class Coffee(
  var name: String = "",
  var price: Int = 0,
  var iced: Boolean = false,
) {

  val brand: String
      get() = "스타벅스" //custom getter

  val brand2: String
      get() {
        return "스타벅스" 
      }

  var quantity: Int = 0
      set(value) { //custom setter
        if (value > 0) { 
          field = value // field == backing field
          // quantity = value 로 할당하면 stackOverflow 발생 
        }
      }
}

class EmptyClass

fun main() {
  val coffee = Coffee()
  coffee.name = "아이스 아메리카노"
  coffee.price = 2000
  coffee.quantity = 1 
  coffee.iced = true

  if (coffee.iced) { // getter를 사용하긴 하지만, 프로퍼티 자체로 상태를 표현이 가능하다.
    println("아이스 커피")
  }

  println("${coffee.brand} ${coffee.name} 가격은 ${coffee.price} 수량은 ${coffee.quantity}")
}
```

- 프로퍼티를 var로 선언하면 getter, setter를 사용할 수 있다.
- 프로퍼티를 val로 선언하면 getter만 사용할 수 있다.
- 코틀린은 프로퍼티의 상태를 표현하기 위해 프로퍼티로써 표현이 가능하다. (위 예제에서 iced)
- 자바에서는 프로퍼티의 상태를 표현하기 위해 메서드를 만들어야 한다. 


### 7. 상속

1. 자바의 상속 
- 자바는 기본적으로 모든 클래스가 상속이 가능하나 
- 상속에 따른 부작용이 발생할 경우를 대비해 `final` 키워드로 막을 수 있다
- 대표적으로 System 클래스 
```java
System.out.println("");

public final class System {
  /*...*./
}
```

- 이펙티브 자바의 아이템중 `상속을 위한 설계와 문서를 작성하고 그렇지 않으면 상속을 금지하라` 라는 주제가 있는데
- 여기에는 여러가지 상속에 대한 문제점에 대해 나와있으며 결과적으로 상속을 목적으로 만든 클래스가 아니라면
- `모두 final로 작성하는 것이` 좋다 


2. 코틀린의 상속

```kotlin
open class Dog {
  open var age: Int = 0

  open fun bark() {
    println("멍멍")
  }
}

class Bulldog : Dog() {
  
  override var age: Int = 0

  override fun bark() {
    println("컹컹")
  }
}

class BulldogV2(override var age: Int = 0): Dog() {

  override fun bark() {
    println("컹컹")
  }
}

class ChildBulldog : BulldogV2 () {
  override var age: Int = 0
  override fun bark() {
    super.bark()
  }
}

abstract class Developer {

  abstract var age: Int
  abstract fun code(language: String)
}

class BackendDeveloper(override var age: Int = 0): Developer() {

  override fun code(language: String) {
    println("develop $language")
  }
}

fun main() {
  val dog = Bulldog(age = 2)
  println(dog.age)
  dog.bark()
}
```
- 코틀린은 open 키워드를 써야 상속을 허용할 수 있다
- override 된 함수 `Bulldog.bark()`나 프토퍼티는 자동으로 상속을 허용(open)하게 된다.
- 상속을 허용하지 않으려면 final키워드를 사용하자. `final override fun bark(){}`
- super 키워드를 통해서 부모클래스의 함수나 프로퍼티를 사용할 수 있다. `ChildBulldog.bark()`
- abstract는 자바와 동일하다 

### 8. 인터페이스

```kotlin
class Product(val name: String, val price: Int)

interface Wheel {
  fun roll()
}

interface Cart : Wheel {

  var coin: Int // 추상 프로퍼티 -> override해야됨 
  
  val weight: String
      get() = "20KG" // interface에서는 backing field를 사용할 수 없다. 

  fun add(product: Product)

  fun rent() { // 여기에서 구현했으므로, override안해도 된다. 
    if (coin > 0) {
      println("카트를 대여합니다")
    }
  }

  override fun roll() {
    println("카트가 굴러갑니다")
  }
}

interface Order {
  fun add(product: Product) {
    println("${product.name} 주문이 완료되었습니다")
  }
}

class MyCart(override var coin): Cart, Order {
  override fun add(product: Product) {
    if (coin <= 0) println("코인을 넣어주세요")
    else println("%{product.name}이(가) 카트에 추가됐습니다")

    // 주문하기
    super<Order>.add(product)
  }
}

fun main() {
  val cart = MyCart(coin=100)
  cart.rent()
  cart.roll()
  cart.add(Product(name = "장난감", price = 1000))
}
```
- default함수는 override안해도 된다.
- 하지만, 부모클래스 두개다 동일한 시그니처의 default 함수를 제공한다면 자식 클래스에서 구현해야 컴파일오류가 발생하지 않는다.


### 9. 열거형

```kotlin
enum class PaymentStatus(val label: String) : Payable{
  UNPAID("미지급") {
    override fun isPayable(): = true 
  }, 
  PAID("지급완료") {
    override fun isPayable() = false 
  }, 
  FAILED("지급실패") {
    override fun isPayable() = false 
  }, 
  REFUNDED("환불") {
    override fun isPayable() = false 
  }; 
}

interface Payable {
  fun isPayable(): Boolean
}

fun main() {
  print(PaymentStatus.UNPAID.label)

  if (PaymentStatus.UNPAID.isPayable()) {
    println("결재 가능 상태")
  }

  val paymentStatus = PaymentStatus.valueOf("PAID")
  println(paymentStatus.label)

  if (paymentStatus == PaymentStatus.PAID) {
    println("결재 완료 상태")
  }

  for (status in PaymentStatus.values()) {
    println("[$status.name](${status.label} : ${status.ordinal}")
  }
}
```

## 2. 코틀린 고급

### 1. 컬렉션 타입
- 코틀린 표준 라이브러리는 기본 컬렉션 타입인 `List`, `Set`, `Map`을 제공
- 컬렉션은 두가지 종류로 나뉨 
  - 불변 컬렉션: 읽기 전용
  - 가변 컬렉션: 삽입, 수정, 삭제와 같은 쓰기 작업이 가능


컬렉션 계층 다이어그램 
![image](https://user-images.githubusercontent.com/28394879/197341885-05555d9b-4006-423a-8cc8-473c979a21ef.png)

```kotlin
fun main() {
  
  // immutable
  val currentList = listOf("달러", "유로", "원") // add 함수 제공 X

  // mutable
  val mutableCurrentList = mutableListOf<String>()
  mutableCurrentList.add("달러")
  mutableCurrentList.add("유로")
  mutableCurrentList.add("원")

  // mutable
  val mutableCurrentList2 = mutableListOf<String>().apply {
      this.add("달러")
      add("유로")
      add("원") 
  }

  // immutable set
  val numberSet = setOf(1,2,3,4)

  // mutable set
  val mutableSet = mutableSetOf<Int>().apply {
    add(1)
    add(2)
    add(3)
    add(4)
  }

  // immutable map
  val numberMap = mapOf("one" to 1, "two" to 2)

  // mutable map
  val mutableNumberMap = mutableMapOf<String, Int>()
  mutableNumberMap["one"] = 1
  mutableNumberMap["two"] = 2

  

  // 컬렉션 빌더 -> 내부에선 mutable로 쓰지만, immutable로 변환해서 return 한다
  val numberList: List<Int> = buildList {
    add(1)
    add(2)
    add(3)
  }

  // linkedList
  val linkedList = LinkedList<Int>.apply {
    addFirst(1)
    add(2)
    addLast(1)
  }

  // arrayList
  val arrayList = ArrayList<Int>().apply {
    add(1)
    add(2)
    add(3)
  }

  val iterator = currencyList.iterator()
  while (iterator.hasNext()) {
    println(iterator.next())
  }

  for (currency in currencyList) {
    println(currency)
  }

  currencyList.forEach {
    println(it)
  }

  val lowerList = listOf("a","b","c")
  val upperList = lowerList.map { it.uppercase() }
  println(upperList)

  val filteredList = upperList.filter { it == "A" || it == "C" } // inline 함수
  println(filteredList)

  val filteredList2 = upperList
      .asSequence() // 자바의 stream과 유사
      .filter {it == "A" || it == "C"}
      .toList() // 이게 없으면 값을 리턴 못받고, 레퍼런스가 출력됨
}
```

- 자바의 foreach, map 등은 terminal operator (`collect().Collectors.toList()`) 가 호출이 되어야 값을 리턴 받는다.
- 코틀린은 terminal operator없이도 값을 리턴받을 수 있다.
- 하지만, inline 함수를 사용하면
  - filter를 연속으로 5개 쓴다고 가정하면, 5번다 collection을 반환하기 때문에 메모리가 비효율적이다.
  - asSequence로 처리하고 inline이 아닌 filter를 5번쓰고 최종적으로 collection으로 변환하는게 좋다 
  - asSequence는 terminal operator가 있어야 collection으로 반환한다