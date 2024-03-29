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
    - [2. 데이터 클래스](#2-데이터-클래스)
    - [3. 싱글톤과 동반객체](#3-싱글톤과-동반객체)
    - [4. 실드 클래스](#4-실드-클래스)
    - [5. 확장 함수](#5-확장-함수)
    - [6. 제네릭](#6-제네릭)
    - [7. 지연 초기화](#7-지연-초기화)
    - [8. 페어와 구조분해할당](#8-페어와-구조분해할당)
    - [9. 스코프 함수](#9-스코프-함수)
    - [10. 고급 예외처리](#10-고급-예외처리)
    - [11. 람다로 프로그래밍하기](#11-람다로-프로그래밍하기)
- [3. 자바 프로젝트에 코틀린 도입해보기](#3-자바-프로젝트에-코틀린-도입해보기)
    - [1. 게터, 세터 호출하기](#1-게터-세터-호출하기)
- [4. 코틀린&스프링 MVC](#4-코틀린스프링-mvc)
    - [1. 요구사항 분석](#1-요구사항-분석)
    - [2. 프로젝트 구성하기](#2-프로젝트-구성하기)
    - [3. API 스펙 정의](#3-api-스펙-정의)
    - [4. 공통 에러 처리](#4-공통-에러-처리)
    - [5. 이슈 등록 ~](#5-이슈-등록-)
- [5. 스프링 WebFlux 기반의 리액티브 프로그래밍](#5-스프링-webflux-기반의-리액티브-프로그래밍)
  - [1. 리액티브 프로그래밍](#1-리액티브-프로그래밍)
    - [1. 비동기-논블로킹 프로그래밍](#1-비동기-논블로킹-프로그래밍)
      - [1-1. 동기 프로그래밍](#1-1-동기-프로그래밍)
      - [1-2. 비동기 프로그래밍](#1-2-비동기-프로그래밍)
    - [2. 비동기 프로그래밍 구현](#2-비동기-프로그래밍-구현)
      - [2-1. Thread](#2-1-thread)
      - [2-2. Future](#2-2-future)
    - [3. 옵저버 패턴](#3-옵저버-패턴)
      - [3-1. 옵저버 패턴의 구조](#3-1-옵저버-패턴의-구조)
    - [4. 이터레이터 패턴](#4-이터레이터-패턴)
    - [5. 리액티브 프로그래밍](#5-리액티브-프로그래밍)
      - [5-1. 리액티브 프로그래밍 이전의 비동기 프로그래밍](#5-1-리액티브-프로그래밍-이전의-비동기-프로그래밍)
      - [5-2. 리액티브 프로그래밍을 적용한 사례](#5-2-리액티브-프로그래밍을-적용한-사례)
    - [6. 리액티브 스트림](#6-리액티브-스트림)
      - [6-1. 리액티브 스트림의 다양한 구현체들](#6-1-리액티브-스트림의-다양한-구현체들)
      - [6-2. 리액티브 스트림 사양](#6-2-리액티브-스트림-사양)
  - [2. 스프링 Webflux 이해하기](#2-스프링-webflux-이해하기)
    - [1. 스프링 Webflux](#1-스프링-webflux)
      - [1. 프로젝트 리액터](#1-프로젝트-리액터)
      - [2. 스프링 WebFlux와 스프링 MVC 비교](#2-스프링-webflux와-스프링-mvc-비교)
    - [2. 함수형 엔드포인트](#2-함수형-엔드포인트)
    - [3. 애노테이션 컨트롤러](#3-애노테이션-컨트롤러)
    - [4. 웹 클라이언트](#4-웹-클라이언트)
    - [5. 스프링 데이터 R2DBC](#5-스프링-데이터-r2dbc)
        - [1.1 R2DBC 이전](#11-r2dbc-이전)
        - [1.2 R2DBC](#12-r2dbc)
      - [2. 스프링 데이터 R2DBC](#2-스프링-데이터-r2dbc)
        - [2.1 ReactiveCrudRepository 살펴보기](#21-reactivecrudrepository-살펴보기)
    - [6. 스프링 WebFlux의 코루틴 지원](#6-스프링-webflux의-코루틴-지원)
      - [1. 코루틴](#1-코루틴)
      - [2. 스프링 WebFlux의 코루틴 지원](#2-스프링-webflux의-코루틴-지원)
    - [7. 코루틴 기초](#7-코루틴-기초)
      - [1. runBlocking](#1-runblocking)
      - [2. launch](#2-launch)
      - [3. async](#3-async)
      - [4. suspend 함수](#4-suspend-함수)
      - [5. Flow](#5-flow)
- [6. 이슈 관리 프로젝트로 코틀린 & 스프링 WebFlux](#6-이슈-관리-프로젝트로-코틀린--스프링-webflux)
  - [1. 회원 인증 서비스 개발하기](#1-회원-인증-서비스-개발하기)
    - [1. 요구사항 분석](#1-요구사항-분석-1)
    - [2. 프로젝트 구성](#2-프로젝트-구성)
    - [3. API 스펙](#3-api-스펙)
      - [1. 회원 가입](#1-회원-가입)
      - [2. 로그인](#2-로그인)
      - [3. 로그아웃](#3-로그아웃)
      - [4. 내정보 조회](#4-내정보-조회)
      - [5. 리포터 조회](#5-리포터-조회)
      - [6. 내정보 수정](#6-내정보-수정)
    - [5. 토큰 기반 인증](#5-토큰-기반-인증)
      - [토큰 기반 인증](#토큰-기반-인증)
      - [1. 세션 기반 인증](#1-세션-기반-인증)
      - [2. 토큰 기반 인증](#2-토큰-기반-인증)




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


### 2. 데이터 클래스 
- 데이터를 보관하거나 전달하는 목적을 가진 객체를 만들 때 사용

```kotlin
data class Person(val name: String, val age: Int)

fun main() {
  val person1 = Person(name = "tony", age = 12)
  val person2 = Person(name = "tony", age = 12)

  println(person1 == person2) // data class는 equals를 자동으로 생성해주기때문에 true로 반환됨. 일반 class면 false.

  val set = hashSetOf(person1)
  println(set.contains(person2)) // data class는 hashCode도 자동으로 생성해주기 때문에 true.

  val person11 = person1.copy(name="strange")
  println(person11)

  println("이름=${person1.component1()}, 나이=${person1.component2()}")

  val (name, age) = person1
  println(name, age)
}
```
- data class가 생성해주는 함수
  - equals
  - hashCode
  - toString
  - copy

### 3. 싱글톤과 동반객체

1. 싱글톤 
- 싱글톤 패턴은 클래스의 인스턴스를 하나의 `단일` 인스턴스로 제한하는 디자인 패턴이다.
- 싱글톤 패턴을 구현할 때는 몇가지 제약사항을 통해 구현한다
  - 직접 인스턴스화 하지 못하도록 생성자를 `private`으로 숨긴다
  - `getInstance()`라는 클래스의 단일 인스턴스를 반환하는 static 메서드를 제공한다
  - 멀티-스레드 환경에서도 `안전하게` 유일한 인스턴스를 반환해야 한다 
- 다양한 구현 방법들
  - DCL (JVM에선 거의 사용X)
  - Enum 싱글톤 (이펙티브 자바에서 소개)
  - 이른 초기화(Eager)
  - 지연 초기화(Lazy)
- 자바에서 많이 쓰이는 구현 방식
  - 이른 초기화 (사용하지 않는 객체들도 메모리에 생성되므로 비효율적)
  - 지연 초기화 (사용하지 않는 객체들은 메모리에 생성안된다)


코틀린의 싱글톤 
```kotlin
object Singleton {

  val a = 1234

  fun printA() = println(a)
}

fun main() {
  println(Singleton.a)
  Singleton.printA()
}
```

```kotlin
object DatetimeUtils {

  val now : LocalDateTime
      get() = LocalDateTime.now()

  const val DEFAULT_FORMAT = "YYYY-MM-DD"

  fun same(a: LocalDateTime, b: LocalDateTime) : Boolean {
    return a == b 
  }
}

fun main() {
  println(DateTimeUtils.now)
  println(DateTimeUtils.now)
  println(DateTimeUtils.now)

  println(DateTimeUtils.DEFAULT_FORMAt)

  val now = LocalDateTime.now()
  println(DatetimeUtils.same(now, now)) // true
}
```


2. 코틀린의 동반객체 
```kotlin
class MyClass {
  
  private constructor()

  companion object MyCompanion{
    val a = 1234
    
    fun newInstance() = MyClass()
  }
}

fun main() {
  println(MyClass.a)
  println(MyClass.newInstance())

  println(MyClass.MyCompanion.a)
  println(MyClass.MyCompanion.newInstance())
}
```


### 4. 실드 클래스 
- 실드클래스: 하나의 상위클래스 또는 인터페이스에서 하위 클래스에 대한 정의를 제한

```kotlin
sealed class Developer {

    abstract val name: String
    abstract fun code(language: String)

}

data class BackendDeveloper(override val name: String) : Developer() {

    override fun code(language: String) {
        println("저는 백엔드 개발자입니다 ${language}를 사용합니다")
    }
}

object OtherDeveloper : Developer() {

    override val name: String = "익명"

    override fun code(language: String) {
        TODO("Not yet implemented")
    }

}

data class AndroidDeveloper(override val name: String) : Developer() {

    override fun code(language: String) {
        println("저는 안드로이드 개발자입니다 ${language}를 사용합니다")
    }
}



object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when(developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        is AndroidDeveloper ->  pool[developer.name] = developer
        is OtherDeveloper -> println("지원하지않는 개발자종류입니다")
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper = BackendDeveloper(name="토니")
    DeveloperPool.add(backendDeveloper)

    val androidDeveloper = AndroidDeveloper(name="안드로")
    DeveloperPool.add(androidDeveloper)

    println(DeveloperPool.get("토니"))
    println(DeveloperPool.get("안드로"))


}
```
- 일반 추상클래스를 상속받은 2개의 클래스가 있다면, when절에 2개의 클래스를 정의하고 else를 안적는다면 컴파일 오류가 발생한다. -> 컴파일 단계에서 어떤 클래스를 상속받고 있는지 모른다.
- sealed class를 상속받은 2개의 클래스가 있다면, when절에 그 2개의 클래스만 정의해도 else를 정의안해도 된다 -> 컴파일 단계에서 어떤 클래스를 상속받고 있는지 알고 있으므로 else가 필요 없다.
- sealed class를 상속받은 클래스가 추가될 때 마다 컴파일러는 그 추가된 클래스들의 존재를 알기 때문에 when절에 그 추가된 클래스를 추가해주어야 한다.


### 5. 확장 함수 

```kotlin
fun String.first() : Char {
  return this[0]
}

fun String.addFirst(char: Char) : String {
  return char + this.substring(0)
}

fun main() {
  println("ABCD".first())

  println("ABCD".addFirst('Z'))
}
```
- 여기서 this를 리시버 혹은 수신자객체 라고 부른다


```kotlin
class MyExample {
  fun printMessage() = println("클래스 출력")
}

fun MyExample.printMessage() = println("확장 출력") // 이미 멤버 함수가 있으므로 무시됨

fun main() {
  MyExample().printMessage() // 클래스 출력
}
```
- 확장함수 주의점
  - 확장하는 클래스의 동일한 명칭의 함수가 존재할 경우 클래스의 멤버 함수가 우선되는 규칙이 있다.
  - 그래서 동일한 시그니처가 있는지 확인해봐야 한다.



```kotlin
fun MyExample?.printNullOrNotNull() {
  if (this == null) println("널인 경우에만 출력")
  else println("널이 아닌 경우에만 출력")
}

fun main() {
  var myExample: MyExample? = null
  myExample.printNullOrNotNull() // 널인 경우에만 출력

  myExample = MyExample()
  myExample.printNullOrNotNull() // 널이 아닌 경우에만 출력
}
```
- 위 예제에서는 안전 연산자(?)를 안써도 에러가 안뜬다.
- 왜냐하면 null인 케이스에 대해서도 다루고 있다는것을 컴파일러가 알기 때문에 NPE가 발생하지 않는것을 알고 있으므로 컴파일 에러가 생기지 않는다 


### 6. 제네릭

```kotlin
class MyGenerics<T>(val t: T) {
  
}

fun main() {
  // 제네릭을 사용한 클래스의 인스턴스를 만들려면 타입아규먼트를 제공
  val generics = MyGenerics<String>("테스트")

  // 타입 아규먼트 생략 가능
  val generics = MyGenerics("테스트")

  // 변수의 타입에 제네릭을 사용한 경우 
  val list1: MutableList<String> = mutableListOf()
  // 타입아규먼트를 생성자에서 추가
  val list2 = mutableListOf<String>()

  // *를 사용하면 어떤 타입이든 올 수 있다.
  val list3 : List<*> = listOf<String>("테스트")
  val list4 : List<*> = listOf<String>(1,2,3,4)
}
```



- 변성
  - 공변성은 자바 제네릭의 extends, 코틀린에선 out
  - 반공변성은 자바 제네릭의 super, 코틀린에선 in 

```kotlin
class MyGenerics<out T>(val t: T) {

}

fun main() {
  val generics = MyGenerics<String>("테스트")
  val charGenerics : MyGenerics<CharSequence> = generics
}
```
- CharSequence가 부모, String 클래스가 자식 클래스이다.
- 위 예제는 공변성에 대한 예제이다.
- CharSequence에 generics를 할당하려면 Mygenerics타입에 out키워드를 추가해야한다.
- 추가하지 않으면 컴파일 오류가 발생한다 


```kotlin
class Bag<T> {
  
  fun saveAll(
    to: MutableList<in T>,
    from: MutableList<T>,
  ) {
    to.addAll(from)
  }
}

fun main() {
  val bag = Bag<String>()
  bag.saveAll(mutableListOf<CharSequence>("1","2"), mutableListOf<String>("3","4"))
  
}
```
- 위 예제는 반공변성 예쩨이다.
- saveAll함수의 to쪽에 in키워드를 추가하지 않으면 컴파일 오류가 발생한다.


### 7. 지연 초기화 

- 지연초기화는 많은 상황에서 쓰이고 있다.
  - 웹페이지에서 특정 스크롤에 도달했을 때 컨텐츠를 보여주는 무한 스크롤
  - 싱글톤 패턴의 지연초기화 
  - JPA의 엔티티 LazyLoading 기능


코틀린은 두가지 다른 방식의 지연초기화를 제공한다

1. 코틀린의 by lazy

```kotlin
class HelloBot {

  val greeting: String by lazy { getHello() }
  
  fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"

fun main() {
  val helloBot = HelloBot()

  helloBot.sayHello()
}
```
- var에서는 by lazy를 사용할 수 없다.
- val변수에서만 사용할 수 있다.
- by lazy 안에 로직은 정확히 딱 한번만 수행된다.
- by lazy는 기본적으로 멀티쓰레드에서도 안전하게 동작하도록 설계되었다.


2. 코틀린의 lateinit
```kotlin
class Test {
  lateinit var text: String

  fun printText() {
    if (this::text.isInitialized) { 
      println("초기화됨")
    } else {
      text = "안녕하세요"
    }
    println(text)
  }
}
```
- lateinit은 val에선 사용하지못하고, var에서만 사용할 수 있다.
- 클래스 외부에서는 isInitialized를 사용할 수 없다.


### 8. 페어와 구조분해할당

```kotlin
// data class Tuple(val a : Int, val b : Int)

// fun plus(tuple: Tuple) = tuple.a + tuple.b
fun plus(pair: Pair<Int,Int>) = pair.first + pair.second
fun plus(triple: Triple<Int,Int,Int>) = triple.first + triple.second + triple.third
```
- 코틀린에서 pair와 triple을 사용할 수 있다.


```kotlin
fun main() { 
  val (a,b,c) = Triple(1,2,3)
}
```
- 구조 분해 할당을 사용하면, 값을 분해해서 한번에 여러개의 변수를 초기화 할 수 있다. 

### 9. 스코프 함수

스코프 함수란
- 코틀린의 표준 라이브러리에는 객체의 컨텍스트 내에서 코드 블록을 실행하기 위해서만 존재하는 몇가지 함수가 포함되어 있는데 이것을 `스코프함수`라고 한다
- 스포크 함수를 제대로 사용하면 불필요한 변수 선언이 없어지며 코드를 더 간결하고 읽기 쉽게 만든다
- 스코프 함수의 코드 블록 내부에서는 변수명을 사용하지 않고도 수신자 객체에 접근할 수 있기 때문에 객체에 접근할 수 있다.
- 수신자 객체는 람다식 내부에서 사용할 수 있는 객체의 참조이다
- 스코프 함수를 사용하면 수신자 객체에 대한 참조로 `this` 또는 `it` 를 사용한다


스코프 함수들의 특징

| 함수명 | 수신자 객체 참조 방법 | 반환 값 | 확장 함수 여부 |
| --- | --- | --- | --- |
| let | it | 함수의 결과 | O |
| run | this | 함수의 결과 | O |
| with | this | 함수의 결과 | X |
| apply | this | 컨텍스트 객체 | O |
| also | it | 컨텍스트 객체 | O | 



let 예제
```kotlin
fun main() {
  val str: String? = null
  
  val result = str?.let {
    println(it)

    1234
  }

  println(result)
}
```
- null 가능한 변수에 대해서 동작시킬 때 주로 사용 


run 예제 
```kotlin
class DatabaseClient {
    var url: String? = null
    var username: String? = null
    var password: String? = null

    // DB에 접속하고 Boolean 결과를 반환
    fun connect(): Boolean {
        println("DB 접속 중 ...")
        Thread.sleep(1000)
        println("DB 접속 완료")
        return true
    }
}

fun main() {

//    val config = DatabaseClient()
//    config.url = "localhost:3306"
//    config.username = "mysql"
//    config.password = "1234"
//    val connected = config.connect()

    val connected: Boolean = DatabaseClient().run {
        this.url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect()
    }
    println(connected)
}
```
- 수신객체에 프로퍼티를 구성하거나, 새로운 결과를 반환할 때 사용 
- let으로도 대체 가능하지만, 프로퍼티에 접근하기위해서 it를 반복적으로 추가해주어야 한다.


with 예제
```kotlin
fun main() {
  
  val str = "hi"
  
  val leng = with(str) {
    length
  }

  println(leng)
}
```
- 결과 반환 없이 내부에서 수신 객체를 사용해서 다른 함수를 호출하고 싶을 때 사용 
- run을 대체할 수도 있다.


apply 예제
```kotlin
fun main() {

  val client: DatabaseClient = DatabaseClient().apply {
        this.url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect()
    }

    client.connect().run { println(this) }
}
```
- 수신객체 프로퍼티를 구성하고, 수신 객체 결과를 그대로 반환할 때 사용 


also 예제
```kotlin
class User(val name: String, val password: String) {

    fun validate() {
        if (name.isNotEmpty() && password.isNotEmpty()) {
            println("검증 성공!")
        } else {
            println("검증 실패!")
        }
    }

    fun printName() = println(name)

}

fun main() {

    User(name = "tony", password = "1234").also {
        it.validate()
        it.printName()
    }
}
```
- 부수작업을 수행하거나, 전달받은 수신 객체를 그대로 반환할 때 사용


### 10. 고급 예외처리

1. use 
```kotlin
fun main() {
  FileWriter("test.txt")
    .use {
      it.write("Hello world")
    }
}
```

2. runCatching
```kotlin
fun getStr(): Nothing = throw Exception("test")
fun main() {
  val result = runCatching { getStr() }
    .getOrElse { println(it.message) "기본값" }
    
  println(result)
}
```
- runCatching은 try catch를 사용하는것이랑 동일한 동작을 해준다


### 11. 람다로 프로그래밍하기

```kotlin
fun main() {
  
  val list = mutableListOf(printHello) // 일반 함수는 넣을 수 없다.

  val func = list[0]
  func()
  // list[0]()

  call(printHello) // 일반 함수는 넣을 수 없다.
}
val printHello : () -> Unit = { println("hello")}

fun call(block: () -> Unit) {
  block()
}

val printMessage: (String) -> Unit = { println(it) }

val plus: (Int, Int) -> Int = { a,b -> a + b}
```


고차 함수 예시
```kotlin
fun main() {
  val list = listOf("a", "b", "c")
  val printStr : (String) -> Unit = { println(it) }
  forEachStr(list, printStr)

  list.forEach (printStr) // forEach도 고차함수다.
}

fun forEachStr(collection:Collection<String>, action: (String) -> Unit) {
  for (item in collection) {
    action(item)
  }
}
```
- 함수를 인자로 받아서 별도 처리하는것을 고차함수라고 한다.
- forEach도 고차함수다.


익명 함수
```kotlin
fun main() {
  outerFunc()()
}

fun outerFunc() : () -> Unit {

  return fun() {
    println("익명함수")
  }
}
```
- 이름없는 함수를 익명함수라고 한다


람다 함수
```kotlin
fun main() {
  outerFunc()()
}

fun outerFunc() : () -> Unit {
  return { println("람다함수") }
}

fun outerFunc2() : () -> Unit = { println("람다함수") }

fun sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

fun sum2 = {x: Int, y: Int -> x + y }
```
- 익명함수와 비슷한데 함수 블록만 선언한것을 람다함수라고 한다.


후행 람다 
```kotlin
fun main() {
  val list = listOf("a", "b", "c")
  val printStr : (String) -> Unit = { println(it) }
  // forEachStr(list, printStr)

  forEachStr(list) {
    printStr
  }
  
  forEachStr(list) {
    println(it.length)
  }
}

fun forEachStr(collection:Collection<String>, action: (String) -> Unit) {
  for (item in collection) {
    action(item)
  }
}
```
- 람다의 마지막 인자가 함수일 때 사용할 수 있다.


람다 레퍼런스 
```kotlin
fun main() {

  val callReference : () -> Unit = { printHello() }
  val callReference2 = ::printHello
  
  callReference()()
}

val printHello : () -> Unit = { println("hello")}
```

람다 레퍼런스2
```kotlin
fun main() { 
  val numberList = list("1", "2", "3")
  
  numberList.map { it.toInt() }.forEach { println(it) }
  numberList.map(String::toInt).forEach(::println) // 람다 레퍼런스
}
```

다양한 함수형 프로그래밍의 함수들을 사용하고 싶다면, `Arrow` 라는 라이브러리를 사용해보자. 


# 3. 자바 프로젝트에 코틀린 도입해보기

### 1. 게터, 세터 호출하기

```kotlin
class Student {
  
  var name: String? = null

  var birthDate: LocalDate? = null

  val age : Int = 10 

  val grade: String? = null
    private set
}

fun main() {

  // 자바 스타일 
  val student = Student()
  student.setName("토니스타크")
  println(student.getName())
  
  // 코틀린 스타일
  val student2 = Student()
  student2.name = "토니스타크"

  println(student2.name)
}
```


# 4. 코틀린&스프링 MVC 

### 1. 요구사항 분석

- 이슈를 등록할 수 있다.
- 이슈를 조회할 수 있다.
- 이슈의 우선순위나 진행 상태, 댓글이나 내용을 수정할 수 있다.
- 이슈를 삭제할 수 있다.
- 이슈를 할일, 진행중, 완료 탭에 따라서 볼 수 있다.


### 2. 프로젝트 구성하기
```
./TIL/til-by-topic/kotlin/4.실무-프로젝트로-배우는-Kotlin&Spring-리팩토링부터-서비스-구현까지/4.kotlin_spring_mvc
```


### 3. API 스펙 정의 

1. 이슈 목록 조회 API

- 메인 페이지에는 상태에 따라 할일, 진행중, 완료 세가지 탭이 존재
- 기본 상태는 할일이고 탭을 눌렀을 때 상태별 `이슈 목록 API`를 조회한다

요청
```
GET {host}/api/v1/issues?status=TODO
```

요청 파라미터
- status: `TODO(기본값)`, `IS_PROGRESS`, `RESOLVED`

응답 
```
200 OK

[
  {
    "id": 1,
    "comments": [
      {
        "id": 1,
        "issueId": 1,
        "userId": 1,
        "body": "이것은 댓글입니다",
        "username": "kd"
      }
    ],
    "summary": 테스트",
    "description": "설명",
    "userId": 1,
    "type": "TASK",
    "priority": "LOW",
    "status": "TODO",
    "createdAt": "2022-11-06 00:16:42",
    "updatedAt": "2022-11-06 00:16:42"
  }
]
```
- type: `BUG`, `TASK`
- priority: `LOW`, `MEDIUM`, `HIGH`
- status: `TODO`, `IN_PROGRESS`, `RESOLVED`

2. 이슈 등록 
- 이슈 등록 모달에선 이슈를 생성하는데 필요한 데이터를 입력받아 이슈 등록 API를 호출한다

요청
```
POST {host}/api/v1/issues
```

요청 본문
```
{
  "summary": "test",
  "description": "설명",
  "userId": 1,
  "type": "TASK",
  "priority": "LOW",
  "status": "TODO"
}
```

응답
```
200 OK

{
  "id": 1,
  "comments": [],
  "description": "설명",
  "userId": 1,
  "type": "TASK",
  "priority": "LOW",
  "createdAt": "2022-11-06 00:16:42",
  "updatedAt": "2022-11-06 00:16:42"
}
```

3. 이슈 상세 조회 API
- 이슈 상세를 눌렀을 때 선택된 `이슈 상세 조회 API`를 호출한다

```
GET {host}/api/v1/issues/{issueId}
```

응답
```
200 OK

{
  "id": 1,
  "comments": [
    {
      "id": 1,
      "issueId": 1,
      "userId": 1,
      "body": "이것은 댓글입니다",
      "username": "kd"
    }
  ]
  "summary": "test",
  "description": "설명",
  "userId": 1,
  "type": "TASK",
  "priority": "LOW",
  "status": "TODO"
}
```

4. 이슈 수정 API
- 저장 버튼을 눌렀을 때 변경된 데이터로 `이슈 수정 API`를 호출한다

```
PUT {host}/api/v1/issues/{issueId}
```

요청 본문
```
{
  "summary": 변경된 제목",
  "description": "바뀐 설명",
  "type": "BUG",
  "priority": "HIGH",
  "status": "TODO"
}
```

응답 
```
200 OK

{
  "id": 1,
  "comments": [],
  "summary": "변경된 제목",
  "description": "바뀐 설명",
  "type": "BUG",
  "priority": "HIGH",
  "status": "TODO",
  "createdAt": "2022-11-06 00:16:42",
  "updatedAt": "2022-11-06 00:17:10"
}
```

5. 이슈 삭제 API
- 삭제 버튼을 누르면 `이슈 삭제 API`를 호출 

요청
```
DELETE {host}/api/v1/issues/{issueId}
```

응답 
```
204 No Content
```

6. 코멘트 등록 API
- 댓글 입력 후 엔터를 누르면 `코멘트 등록 API`를 호출한다

코멘트 등록 API
```
POST {host}/api/v1/issues/{issueId}/comments
```

요청 본문
```
{
  "body": "이것은 댓글입니다"
}
```

응답
```
200 OK

{
  "id": 1,
  "issueId": 1,
  "userId": 1,
  "body": "이것은 댓글입니다"
}
```

7. 코멘트 수정 API
- 댓글 수정 버튼을 누르면 댓글을 수정할 수 있고 엔터를 누르면 `코멘트 수정 API`를 호출한다

요청
```
PUT {host}/api/v1/issues/{issueId}/comments/{commentId}
```

요청 본문 
```
{
  "body": "수정된 댓글입니다"
}
```

응답
```
200 OK

{
  "id": 1,
  "issueId": 1,
  "userId": 1,
  "body": "수정된 댓글입니다"
}
```

8. 코멘트 삭제 API
- 댓글 삭제 버튼을 누르면 `코멘트 삭제 API`를 호출한다

코멘트 삭제 API
```
DELETE {host}/api/v1/issue/{issueId}/comments/{commentId}
```

응답
```
204 No Content
```

### 4. 공통 에러 처리 
```
/TIL/til-by-topic/kotlin/4.실무-프로젝트로-배우는-Kotlin&Spring-리팩토링부터-서비스-구현까지/4.kotlin_spring_mvc/kdsin-issue-service/issue-service/src/main/kotlin/com/kdsin/issueservice/exception/...
```

### 5. 이슈 등록 ~
```
/TIL/til-by-topic/kotlin/4.실무-프로젝트로-배우는-Kotlin&Spring-리팩토링부터-서비스-구현까지/4.kotlin_spring_mvc/kdsin-issue-service/issue-service/src/main/kotlin/com/kdsin/issueservice/...
```

# 5. 스프링 WebFlux 기반의 리액티브 프로그래밍 

## 1. 리액티브 프로그래밍
 

### 1. 비동기-논블로킹 프로그래밍


#### 1-1. 동기 프로그래밍
- 동기(Synchronous)방식의 프로그램에서 작업의 실행 흐름은 순차적으로 동작 
- 순차적으로 동작하는 프로그램은 코드를 파악하기 쉽고 결과를 예측하기 쉬우므로 디버깅이 쉽다
- 특정 작업을 실행하는 동안에는 다른 작업을 할 수 없다는 단점 존재 

#### 1-2. 비동기 프로그래밍
- 비동기(Asynchronous) 방식의 프로그램에서 작업의 실행 흐름은 기본적으로 순차적이지 않다
- 이러한 특징으로 인해 비동기 처리 방식은 현재 실행 중인 작업이 끝나는 것을 기다리지 않고 다른 작업 가능
- 서버, 클라이언트 등 모든 환경에서 유용
- UI애플리케이션의 경우 특정 이벤트가 발생할 경우에 반응하는 동작을 구현해야 하는데 이럴 때 필수적으로 비동기 프로그래밍을 사용하게 된다
- 대부분의 프로그래밍 언어들은 각 언어의 철학에 맞는 다양한 비동기 처리 방법들을 지원한다
- 대표적으로 `Callback`, `Promise`, `Future`, `Async-await`, `Coroutine` 등이 있고 각각의 방법들은 장단점이 존재

### 2. 비동기 프로그래밍 구현

#### 2-1. Thread
- 비동기 처리 방식의 가장 기본
- 스레드는 `Runnable` 인터페이스를 사용해 비동기 동작을 수행
- 스레드가 1개인 경우 싱글 스레드, 하나 이상 존재하면 멀티 스레드라고 부름
- 멀티스레드를 사용하면 애플리케이션에서 여러개의 작업을 동시에 가능
- 멀티스레드를 사용하면 스케쥴링 알고리즘에 의해 스레드가 전환되면서 작업을 처리하는데 이것을 `컨텍스트 스위칭`이라 한다
- 하나의 `프로세스 (Process)`에는 최소한 하나 이상의 스레드가 존재하고 프로세스 내의 스레드들은 동일한 메모리를 공유
- 스레드는 프로세스를 생성하는 것보다 가볍다 
- 하지만 스레드가 무한정 많아지면 메모리 사용량이 높아져서 `OOME`가 발생할 수 있고 높은 동시 처리량을 요구하는 시스템에서는 스레드를 생성하면서 발생하는 대기 시간 때문에 응답 지연이 발생한다
  - 이런 문제를 해결하기 위해선 `스레드 풀(Thread Pool)`을 사용해야 한다.
  - 스레드 풀을 사용하면 애플리케이션 내에서 사용할 총 스레드 수를 제한 할 수 있고
  - 기존에 생성된 스레드를 재사용하므로 빠른 응답이 가능 
  - 직접 만드는 것보다 검증된 라이브러리를 사용해야 한다. java.util.concurrent 패키지의 ExecutorService를 사용하면 쉽고 안전하게 스레드 풀을 사용할 수 있다. 

#### 2-2. Future
- `Future`는 비동기 작업에 대한 결과를 얻고 싶은 경우에 사용
- 예를 들어 수행 시간이 오래 걸리는 작업이나 작업에 대한 결과를 기다리면서 다른 작업을 병행해서 수행하고 싶은 경우에 유용
- 스레드는 Runnable을 사용해 비동기 처리를 하지만 퓨처를 사용해 처리 결과를 얻기 위해선 `Callable`을 사용한다
- 퓨처를 사용하면 비동기 작업을 쉽게 구현할 수 있지만 몇가지 단점이 있다
  - `get`함수는 비동기 작업의 처리가 완료될 때 까지 다음 코드로 넘어가지 않고 무한정 대기하거나 지정해둔 타임아웃 시간까지 블로킹됨
  - 또한 퓨처를 사용하면 동시에 실행되는 한 개 이상의 비동기 작업에 대한 결과를 하나로 조합하여 처리하거나 수동으로 `완료 처리` 할 수 있는 방법을 지원하지 않음 

### 3. 옵저버 패턴
- GoF가 소개한 디자인 패턴 중 하나로 관찰 대상이 되는 객체가 변경되면 대상 객체를 관찰하고 있는 `옵저버(Observer)`에게 변경사항을 `통지(notify)`하는 디자인 패턴
- 옵저버 패턴을 사용하면 객체 간의 상호작용을 쉽게 하고 효과적으로 데이터를 전달

#### 3-1. 옵저버 패턴의 구조
- 관찰 대상인 `서브젝트(Subjetct)`와 Subject를 관찰하는 `옵저버(Objserver)`로 이뤄져 있음
- 하나의 서브젝트에는 1개 또는 여러 개의 옵저버를 등록 
- 서브젝트의 상태가 변경되면 자신을 관찰하는 옵저버들에게 변경사항을 통지
- 서브젝트로 변경사항을 통지 받은 옵저버는 부가적인 처리
- 옵저버 패턴은 서브젝트와 옵저버를 상속하는 `구체화(Concrete)` 클래스가 존재
- 구체화 클래스는 서브젝트와 옵저버에 대한 상세 구현을 작성

**옵저버 패턴의 장점**
- 옵저버 패턴을 사용하지 않았다면 고객은 일정 간격으로 커피가 완성됐는지 바리스타에게 확인하는 처리가 있어야함
- 간격이 너무 짧으면 변경된 상태를 빠르게 확인할 수 있지만 매번 불필요한 호출이 발생하므로 성능상 문제가 발생할 수 있음
- 또한 간격이 너무 길면 변경된 상태를 즉시 확인할 수 없으므로 실시간성이 떨어짐
- 옵저버 패턴은 관찰자인 옵저버가 서브젝트의 변화를 신경 쓰지 않고 상태 변경의 주체인 서브젝트가 변경사항을 옵저버에게 알려줌으로써 앞서 언급한 문제를 해결할 수 있다
- 옵저버 패턴은 데이터를 제공하는 측에서 데이터를 소비하는 측에 통지하는 `푸시 (Push-Based) 방식`이다

**옵저버 패턴에서 서브젝트와 옵저버는 관심사에 따라 역할과 책임이 분리되어 있다**
- 서브젝트는 옵저버가 어떤 작업을 하는지 옵저버의 상태가 어떤지에 대해 관심을 가질 필요가 없고 
- 오직 변경사항을 통지하는 역할만 수행하고
- 하나 혹은 다수의 옵저버는 각각 맡은 작업을 스스로 하기 때문에 옵저버가 하는 일이 서브젝트에 영향을 끼치지 않고 옵저버는 단순한 데이터의 소비자로서 존재


### 4. 이터레이터 패턴
- 데이터의 집합에서 데이터를 순차적으로 꺼내기 위해 만들어진 디자인 패턴
- 컬렉션이 변경되더라도 동일한 인터페이스를 사용해 데이터를 꺼내올 수 있기 때문에 변경사항이 없이 사용할 수 있다
- 데이터의 집합이 얼만큼의 크기를 가진지 알 수 없는 경우 이터레이터 패턴을 사용하면 순차적으로 데이터를 꺼내올 수 있다.
- `애그리게잇`은 요소들의 집합체를 나타냄
- 이터레이터는 집합체 내부에 구현된 iterator를 이용해 생성됨
- 이터레이터를 사용하는 클라이언트는 생성된 이터레이터의 `hasNext` 함수를 사용해 데이터가 존재하는지 검사하고 `next` 함수를 사용해 데이터를 꺼낸다.

### 5. 리액티브 프로그래밍
- 데이터 또는 이벤트의 변경이 발생하면 이에 반응해 처리하는 프로그래밍 기법
- 비동기 프로그래밍을 처리하는 새로운 접근 방식
- 데이터의 통지, 완료, 에러에 대한 처리를 옵저버 패턴에 영감을 받아 설계되었고 데이터의 손쉬운 비동기 처리를 위해 함수형 언어의 접근 방식을 사용 

#### 5-1. 리액티브 프로그래밍 이전의 비동기 프로그래밍
- 리액티브 프로그래밍이 나오기 전 비동기 프로그래밍은 대부분 `콜백` 기반의 비동기 처리 방식을 사용했다
- 간단한 콜백은 이해하기 쉬울 수 있지만 콜백이 많아져서 발새앟는 `콜백 헬`로 인해 코드의 복잡도가 늘어난다

#### 5-2. 리액티브 프로그래밍을 적용한 사례
- 리액티브 프로그래밍을 사용하면 콜백 헬 문제를 함수형 프로그래밍 관점으로 해결할 수 있다. 
```kotlin
fetchReactive("/api/users/me")
  .zip { user -> fetchReactive("api/users/${user.id}/followers")}
  .zip { user -> fetchReactive("api/users/${user.id}/likes")}
  .zip { user -> fetchReactive("api/users/${user.id}/contacts")}
  .fletMap { followers, likes, contacts -> 
    // 로직 구현
  }
```

### 6. 리액티브 스트림
- `리액티브 스트림`은 리액티브 프로그래밍의 표준 API 사양 
- `비동기 데이터 스트림`과 `논-블로킹 백프레셔`에 대한 사양을 제공
- 리액티브 스트림 이전의 비동기식 애플리케이션에서는 CPU의 멀티 코어를 제대로 활용하기 위해 복잡한 병렬 처리 코드가 필요했다
- 기존의 방식은 처리할 데이터가 무한정 많아져서 시스템의 한계를 넘어서는 경우 애플리케이션은 `병목 현상`이 발생하거나 심각한 경우 애플리케이션이 정지되는 경우도 발생할 수 있다

#### 6-1. 리액티브 스트림의 다양한 구현체들 
- 리액티브 스트림은 `TCK`를 지원하기 떄문에 라이브러리가 정해진 사양에 맞게 구현되었는지 보장할 수 있다
- 리액티브 스트림은 TCK만 통과한다면 각 구현체들은 표준 사양에 포함되지 않은 라이브러리만의 추가 기능도 자유롭게 지원할 수 있게 함 
- 리액티브 스트림을 표준 사양을 채택한 대표적인 구현체들
  - Project Reactor
  - RxJava
  - JDK9 Flow
  - Akka Streams
  - Vert.x

#### 6-2. 리액티브 스트림 사양
- 리액티브 스트림 `사양(specification)`은 `핵심 인터페이스`와 `프로토콜`로 구성된다

## 2. 스프링 Webflux 이해하기

### 1. 스프링 Webflux

#### 1. 프로젝트 리액터
- 리액티브 스트림의 구현체 중 하나로 스프링의 에코시스템 범주에 포함된 프레임워크
- 리액티브 스트림 사양을 구현하고 있으므로 리액티브 스트림에서 사용하는 용어와 규칙을 그대로 사용 
- 리액터를 사용하면 애플리케이션에 리액티브 프로그래밍을 적용할 수 있고 비동기-논블로킹을 적용할 수 있다
- 함수형 프로그래밍의 접근 방식을 사용해서 비동기-논블로킹 코드의 난해함을 어느정도 해결함
- 백프레셔를 사용해 시스템의 부하를 효율적으로 조절 

**모노와 플럭스**
- 리액터는 리액티브 스트림의 publisher 인터페이스를 구현하는 Mono와 Flux라는 두 가지 핵심 타입을 제공
- 모노는 0..1개의 단일 요소 스트림을 통지하는 발행자
- 플럭스는 0..N개로 이뤄진 다수 요소 스트림을 통지하는 발행자
- 두 타입 모두 리액티브 스트림 데이터 처리 프로토콜대로 onComplete 또는 onError 시그널이 발생할 때 까지 onNext를 사용해 구독자에게 데이터를 통지

#### 2. 스프링 WebFlux와 스프링 MVC 비교

**스프링 MVC**
- 스프링으로 개발된 대부분의 웹 애플리케이션은 서블릿 기반의 스프링 MVC
- 스프링 MVC는 동시성 처리를 전통적 웹 방식인 하나의 스레드가 하나의 요청을 처리하는 Thread Per Request Model을 사용한다
- Thread per Request Model은 DB, Network IO 등이 발생할 경우 결과를 받기까지 스레드가 블로킹됨
- 이러한 문제를 해결하기 위해 스레드 풀을 사용해 동시성을 제어함

**스프링 WebFlux**
- 리액티브 기반의 웹 스택 프레임워크
- 기본적으로 프로젝트 리액터 기반이며 리액티브 스트림의 다른 구현체인 RxJava나 코틀린 코루틴으로도 개발이 가능
- 스프링 WebFlux는 비동기-논 블로킹으로 동작하므로 적은 수의 스레드로 대량의 동시성을 제어할 수 있음
- 스프링 MVC와 스프링 WebFlux의 공통점과 각각이 고유하는 지원하는 기능 들
![image](https://user-images.githubusercontent.com/28394879/203325537-fa5cf087-b411-4e35-85f2-e60209ea8a1d.png)


- 스프링 MVC
  - 코드의 흐름을 쉽게 이해할 수 있고 디버깅하기 쉬움
  - 대부분의 스프링 웹 애플리케이션이 스프링 MVC 기반이므로 안정성과 풍부한 라이브러리를 지원
  - JPA, JDBC와 같은 블로킹 API를 사용하는 경우에는 스프링 MVC를 사용
- 스프링 WebFlux
  - 함수형 엔드포인트와 애노테이션 컨트롤러 방식을 모두 지원
  - 이벤트 루프 동시성 모델
  - 스프링 MVC에 비해 러닝커브가 많아 높은 편 
  - 전 구간 비동기-논블로킹인 경우에 최적의 성능을 보여줌 
```kotlin
// 어쩔 수 없이 블로킹 API를 쓰는 경우 별도의 스케쥴러로 동작시키는 게 좋다
val blockingWrapper = Mono.fromCallable {
  
  // JPA의 블로킹 코드
  jpaRepository.findById(id)
  
}.subscribeOn(Schedulers.boundedElastic())
```
- 스프링 MVC에서도 리액터와 Webflux 의존성을 추가하여 리액티브 코드와 논블로킹 라이브러리를 사용할 수 있음 

### 2. 함수형 엔드포인트 

```
./til-by-topic/kotlin/4.실무-프로젝트로-배우는-Kotlin&Spring-리팩토링부터-서비스-구현까지/5.springwebflux/springwebflux/src/main/kotlin/com/kdsin/springwebflux/functional
```

### 3. 애노테이션 컨트롤러 

```
./til-by-topic/kotlin/4.실무-프로젝트로-배우는-Kotlin&Spring-리팩토링부터-서비스-구현까지/5.springwebflux/springwebflux/src/main/kotlin/com/kdsin/springwebflux/annotation_controller
```

### 4. 웹 클라이언트

```
./til-by-topic/kotlin/4.실무-프로젝트로-배우는-Kotlin&Spring-리팩토링부터-서비스-구현까지/5.springwebflux/springwebflux/src/main/kotlin/com/kdsin/springwebflux/webclient
```

### 5. 스프링 데이터 R2DBC

##### 1.1 R2DBC 이전 
- 전통적인 방식의 `JDBC` 드라이버는 하나의 커넥션에 하나의 스레드를 사용하는 `Thread Per Connection` 방식
- Thread per Connection 방식은 데이터베이스로부터 응답을 받기 전까지 스레드는 블로킹 됨
- 높은 처리량과 대규모 애플리케이션을 위해 비동기-논블로킹 데이터베이스 API에 대한 요구가 생김
- 애플리케이션 로직이 비동기-논블로킹 이더라도 DB 드라이버가 JDBC라면 필연적으로 블로킹이 발생하므로 100% 비동기-논블로킹의 성능을 내기 어려웠음
- JPA, Mybatis 둘다 `JDBC` 드라이버를 사용한다
- 오라클의 `ADBA` 프로젝트가 표준화 진행 중 지원 종료 됨 

##### 1.2 R2DBC
- `R2DBC`는 빠르게 성장 중인 리액티브 기반의 비동기-논블로킹 데이터베이스 드라이버
- 다양한 데이터베이스를 지원한다 
  - Oracle
  - Postgres
  - H2
  - MSSQL
  - Google Spanner
  - MariaDB
- 리액티브 스트림 구현체인 Porject Reactor, RxJava 등을 지원 
```java
connection.createStatement("SELECT * FROM employess")
    .execute()
    .flatMap(r -> r.map((row, metadata) -> {
    Employee emp = new Employee();
    emp.setId(row.get("emp_id", Integer.class));
    emp.setName(row.get("name", String.class));
    emp.setPosition(row.get("position", String.class));
    emp.setSalary(row.get("salary", Double.class));
    return emp;
    }))
    .close()
    .subscribe();
```

#### 2. 스프링 데이터 R2DBC
- R2DBC 기바의 스프링 데이터 프로젝트
- 스프링 데이터 프로젝트이므로 스프링 애플리케이션에 쉽게 통합할 수 있으며 스프링 데이터 JPA, 스프링 데이터 몽고DB 같은 프로젝트처럼 뛰어난 추상화를 제공
- 스프링 WebFlux와 스프링 데이터 R2DBC를 같이 사용하면 전 구간 비동기-논블로킹 애플리케이션을 구현할 수 있다
- 많은 ORM(JPA)에서 제공하는 LazyLoading, Dirty-checking, Cache 등을 지원하지 않으므로 ORM으로써의 기능은 적지만 오히려 더 심플하게 사용할 수 있음 

##### 2.1 ReactiveCrudRepository 살펴보기 
- `ReactiveCRUDRepository`는 리액티브를 지원하는 CRUD 인터페이스
- 모든 반환 타입이 Mono, Flux 같은 리액터의 Publisher인 것을 확인할 수 있다

### 6. 스프링 WebFlux의 코루틴 지원

#### 1. 코루틴 
- 코틀린에서 비동기-논블로킹 프로그래밍을 명령형 스타일로 작성할 수 있도록 도와주는 라이브러리
- 코루틴은 멀티 플랫폼을 지원하여 코틀린을 사용하는 안드로이드, 서버 등 여러 환경에서 사용 가능
- 일시 중단 가능한 함수(suspend function) 를 통해 스레드가 실행을 잠시 중단했다가 중단한 지점부터 다시 재개(resume) 할 수 있다.

```kotlin
suspend fun combineApi() = coroutineScope {
  val response1 = async { getApi1() }
  val response2 = async { getApi2() }

  return ApiResult {
    response1.await()
    response2.await()
  }
}
```

#### 2. 스프링 WebFlux의 코루틴 지원
- 스프링 MVC, 스프링 WebFlux 모두 코루틴을 지원하여 의존성만 추가하면 바로 사용 가능
- 아래 의존성을 build.gradle.kts에 추가하면 코루틴을 사용 가능
```kotlin
dependencies {
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${version}")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${version}")
}
```

**리액티브가 코루틴으로 변환되는 방식**
```kotlin
// Mono -> suspend
fun handler(): Mono<Void> -> suspend fun handler()

// Fluw -> Flow
fun handler(): Flux<T> -> fun handler(): Flow<T>
```
- Mono는 suspend 함수로 변환
- Flux는 Flow로 변환


**코루틴을 적용한 컨트롤러 코드**
```kotlin
@RestController
class UserController(
  private val userService : UserService,
  private val userDetailService: UserDetailService
  ) {

  @GetMapping("/{id}")
  suspend fun get(@PathVariable id: Long) : User {
    return userService.getById(id)
  }
  @GetMapping("/users")
  suspend fun gets() = withContext(Dispatchers.IO) {
    val usersDeffered = async { userService.gets() }
    val userDetailsDeffered = async { userDetailService.gets() }
    return UserList(usersDeffered.await(), userDetailsDeffered.await())
  }
}
```

**코루틴을 사용한 WebClient**
```kotlin
val client = WebClient.create("https://example.org")

val result = client.get()
  .uri("/persons/{id}", id)
  .retrieve()
  .awaitBody<Person>()
```
- 기존 리액티브 코드를 코루틴으로 변환하고 싶다면 `awaitXXX` 시작하는 확장 함수를 사용하면 즉시 코루틴으로 변환 가능


**Spring Data R2DBC의 ReactiveCrudRepository에서 코루틴 적용**
```kotlin
interface ContentReactiveRepository : ReactiveCrudRepository<Content, Long> {
  fun findByUserId(userId: Long) : Mono<Content>
  fun findAllByUserId(userId: Long): Flux<Content>
}
class ContentService (
  val repository : ContentReactiveRepository
) {
  fun findByUserIdMono(userId: Long) : Mono<Content> {
    return repository.findByUserId(userId)
  }
  suspend findByUserId (userId: Long) : Content {
    return repository.findByUserId(userId).awaitSingle()
  }
}
```

**CoroutineCrudRepository 를 사용하면 awaitXXX 코드 없이 사용 가능**
```kotlin
interface ContentCouroutineRepository : CoroutineCrudRepository<Content, Long> {
  suspend fun findByUserId(userId:Long) : Content?
  fun findAllByUserId(userId: Long): Flow<Content>
}
class ContentService (
  val repository : ContentCouroutineRepository
) {
  suspend findByUserId (userId: Long) : Content {
    return repository.findByUserId(userId)
  }
}
```

### 7. 코루틴 기초 


#### 1. runBlocking
- 코루틴을 생성하는 `코루틴 빌더`
- runBlocking으로 감싼 코드는 코루틴 내부의 코드가 수행이 끝날 때 까지 스레드가 블로킹 된다

```kotlin
fun main() {

  runBlocking {
    println("Hello")
  }
  println("World")
}

//Hello
//World
```
- 일반적으로 코루틴은 스레드를 차단하지 않고 사용해야하므로 runBlocking을 사용하는 것은 좋지 않지만 반드시 사용해야 하는 경우가 있다
  - 예) 테스트 코드, 스프링 배치 등

#### 2. launch
- 스레드 차단 없이 새 코루틴을 시작하고 결과로 job을 반환하는 코루틴 빌더
- 결과를 만들어내지 않는 비동기 작업에 적합하기 때문에 인자로 Unit을 반환하는 람다를 인자로 받음
```kotlin
fun main() = runBlocking<Unit> {
  launch {
    delay(500L)
    println("World")
  }
  println("Hello")
}

//Hello
//World
```

- `delay()` 함수는 코루틴 라이브러리에 정의된 일시 중단 함수, Thread.sleep()과 유사하지만 현재 스레드를 차단하지 않고 일시 중단 시킨다
- 이 때 일시 중단 된 스레드는 코루틴내에서 다른 일시 중단 함수를 수행한다 

- launch를 사용해서 여러 개의 작업을 병렬적으로 수행할 수 있다
```kotlin
fun main() {
  
  runBlocking {
    
    launch {
      val timeMilis = measureTimeMilis {
        delay(150)
      }
      println("async task-1 $timeMilis ms")
    }

    launch {
      val timeMilis = measureTimeMilis {
        delay(100)
      }
      println("async task-2 $timeMilis ms")
    }
  }
}
```

- launch가 반환하는 `Job`을 사용해 현재 코루틴의 상태를 확인하거나 실행 또는 취소도 가능 
```kotlin
fun main() = runBlocking<Unit> {
  val job1: Job = launch {
    val timeMillis = measureTimeMillis {
      delay(150)
    }
    println("async task-1 $timeMillis ms")
  }
  job1.cancel() // 취소
  val job2: Job = launch(start = CoroutineStart.LAZY) {
    val timeMillis = measureTimeMillis {
      delay(100)
    }
      println("async task-2 $timeMillis ms")
  }
  println("start task-2")
  job2.start()
}
```
- job1.cancel()을 호출해 코루틴을 취소 할 수 있다
- launch 를 사용해서 start함수를 호출하는 시점에 코루틴을 동작시킬 수 있다
  - start 함수를 주석처리하면 launch가 동작하지 않는다

#### 3. async
- async 빌더는 비동기 작업을 통해 결과를 만들어내는 경우에 적합

```kotlin
fun sum(a: Int, b: Int) = a + b
fun main()= runBlocking<Unit> {
  val result1: Deferred<Int> = async {
    delay(100)
    sum(1, 3)
  }
  println("result1 : ${result1.await()}")
  val result2: Deferred<Int> = async {
    delay(100)
    delay(100)
    sum(2, 5)
  }
  println("result2 : ${result2.await()}")
}
```
- async는 비동기 작업의 결과로 `Deferred` 라는 특별한 인스턴스를 반환하는데 `await` 이라는 함수를 통해 async로 수행한 비동기 작업의 결과를 받아올 수 있다
- 자바스크립트나 다른 언어의 async-await은 `키워드`인 경우가 보통이지만
- 코틀린의 코루틴은 async-await이 함수인 점이 차이가 있다

#### 4. suspend 함수 
- suspend 함수는 코루틴의 핵심 요소로써 일시 중단이 가능한 함수
- suspend는 키워드이다
- suspend 함수는 일반 함수를 마음껏 호출할 수 있지만 일반 함수에선 suspend 함수를 호출할 수 없다 
- 호출하는 함수에 suspend 키워드를 붙여주면 된다 
- suspend 함수에서 async, launch와 같은 코루틴 빌더를 사용하려면 `코루틴 스코프`를 사용한다

```kotlin
suspend fun main() {
  doSomething()
}

fun printHello() = println("hello")

suspend fun doSomething() = coroutineScope {
  launch {
    delay(200)
    println("world!")
  }
  launch {
    printHello()
  }
}
```
- coroutineScope를 사용하면 runBlocking과 다르게 현재 스레드가 차단되지 않고 코루틴이 동작한다 

#### 5. Flow
- 코루틴에서 리액티브 프로그래밍 스타일로 작성할 수 있도록 만들어진 API
- 코루틴의 suspend 함수는 단일 값을 비동기로 반환하지만, Flow를 사용하면 여러개의 값을 반환할 수 있다

```kotlin
fun main() = runBlocking<Unit> {
  val flow = simple()
  flow.collect { value -> println(value) }
}
fun simple(): Flow<Int> = flow {
  println("Flow started")
  for (i in 1..3) {
    delay(100)
    emit(i)
  }
}
```
- 리액티브 스트림과 같이 collect를 호출하지 않으면 아무런 일도 일어나지 않는다


# 6. 이슈 관리 프로젝트로 코틀린 & 스프링 WebFlux

## 1. 회원 인증 서비스 개발하기 

### 1. 요구사항 분석
- 회원가입, 로그인, 로그아웃, 유저관련 정보를 가져올 수 있는 API, 이슈를 눌렀을 때 리포터 이름을 가져오는 API, 사용자 수정 API 등을 개발 
- 로그인 API를 호출하면 유저 검증과 JWT토큰을 클라이언트로 응답

### 2. 프로젝트 구성
```
./til-by-topic/kotlin/4.실무-프로젝트로-배우는-Kotlin&Spring-리팩토링부터-서비스-구현까지/5.springwebflux
```

### 3. API 스펙 

#### 1. 회원 가입 

**API**  
```
POST {host}/api/v1/users/signup
```

**body**
```
{
  "email" : "dev@gmail.com",
  "password" : "",
  "username" : "사용자"
}
```

**response**
```
200 OK
```

#### 2. 로그인 

**API**
```
POST {host}/api/v1/users/signin
```

**body**
```
{
  "email" : "dev@gmail.com",
  "password" : "",
}
```

**response**
```
{
  "email" : "",
  "username" : "",
  "token" : "",
  "refreshToken" : ""
}
```


#### 3. 로그아웃

**API**
```
DELETE {host}/api/v1/users/logout
```

**헤더**
```
Authorization : Bearer {token}
```

**response**
```
204 NO_CONTENT
```


#### 4. 내정보 조회
**API**
```
GET {host}/api/v1/users/me
```

**헤더**
```
Authorization : Bearer {token}
```

**response**
```
200 OK
{
  "id": 1,
  "profileUrl": "",
  "username": "사용자",
  "email": "dev@gmail.com",
  "createdAt": "2022-06-12 00:16:41",
  "updatedAt": "2022-06-12 00:18:01"
}
```

#### 5. 리포터 조회 

**API**
```
GET{host}/api/v1/users/{reporterId}/username
```

**response**
```
200 OK
{
  "reporter" : "작성자"
}
```


#### 6. 내정보 수정 

**API**
```
POST {host}/api/v1/users/{id}
```

**헤더**
```
Content-Type: multipart/form-data
```

**response**
```
200 OK
{
  "id": 1,
  "profileUrl": "이미지 경로",
  "username": "사용자",
  "email": "dev@gmail.com",
  "createdAt": "2022-06-12 00:16:41",
  "updatedAt": "2022-06-12 00:18:01"
}
```

### 5. 토큰 기반 인증 

#### 토큰 기반 인증 
- 사용자의 로그인 상태를 처리하는 방법은 대표적으로 `세션 기반 인증` 방식과 `토큰 기반 인증` 방식으로 나뉨 

#### 1. 세션 기반 인증 
- 세션 기반 인증 방식은 서버가 클라이언트의 세션 정보를 저장하고 있는 `stateful` 방식이다.

**특징**
- 사용자가 로그인을 하게되면 서버는 사용자 정보 검증 후 세션id를 발급하고 브라우저의 쿠키에 저장한다
- 브라우저는 모든 요청마다 쿠키에 있는 세션 id를 포함하고 서버는 세션 id를 통해 유저 정보를 세션 스토리지에서 조회한다
- 일반적으로 서버 메모리, 데이터베이스 등을 사용해 세션을 저장한다
- 세션은 서버에서 `만료(invalidate)` 시켜서 클라이언트의 권한을 회수할 수 있다 

**단점**
- 서버 확장이 어렵다. 분산 환경에서는 세션을 공유할 수 있는 세션 클러스터링이 필요함
- 중앙에서 세션을 관리할 수 있는 세션 DB를 구축해야함
- 요청이 많아지면 세션 조회에 따른 DB 부하가 심해질 수 있다 

#### 2. 토큰 기반 인증
- 토큰 기반 인증 방식은 서버가 클라이언트의 세션을 저장하지 않기 떄문에 `stateless` 방식이다.
- 대표적으로 `JWT`이 있다

**특징**
- 사용자가 로그인을 하게되면 서버는 사용자 정보 검증 후 토큰을 발급하고 응답으로 내려준다
- 클라이언트는 토큰을 저장하고 있다가 Authorization 헤더에 토큰을 전달한다
- 서버가 분산된 환경에서도 서버에선 클러스터링 처리가 필요 없다는 것이 장점이다
- JWT 토큰 내부에는 기본적인 정보와 검증된 토큰임을 증명하는 서명과 같은 유용한 정보를 가지고 있다
- 토큰안에 유용한 정보를 담고 있어서 I/O 작업을 하지 않아도 된다

**단점**
- 한번 발행된 토큰은 클라이언트가 보관하고 있으므로 회수하기 어렵다
- 회수가 어렵고 탈취되면 대처가 어려우므로 만료 시간을 짧게 가져가야한다
- 토큰이 길어지면 네트워크 부하가 커질 수 있다
- 페이로드는 암호화된 정보가 아니기 때문에 민감정보를 담아선 안된다
- JWT의 경우 단일 키를 사용하기 때문에 시크릿 키가 유출되면 보안 취약사항이된다

