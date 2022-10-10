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
