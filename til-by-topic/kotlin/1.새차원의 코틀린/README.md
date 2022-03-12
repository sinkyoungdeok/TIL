
# 출처 
- url: https://www.inflearn.com/course/%EC%BD%94%ED%8B%80%EB%A6%B0-%EA%B0%95%EC%A2%8C-%EC%83%88%EC%B0%A8%EC%9B%90/dashboard
- 강사님: 새차원

## Install

<details><summary>자세히 보기</summary>

### 코틀린 설치 (Mac OS)
- brew install adoptopenjdk8
- brew install kotlin

</details>

## Basic Syntax

<details><summary>자세히 보기</summary>

### 패키지 정의
- 패키지 정의는 파일 최상단에 위치
- 디렉터리와 패키지를 일치시키지 않아도 됨 
```kotlin
package my.demo

import java.util.*

//..
```

### 함수 정의
- 함수는 fun 키워드로 정의
```kotlin
fun sum(a: Int, b: Int): Int {
    return a+b
}
```

- 함수 몸체가 식(Expression)인 경우 return 생략 가능
- 이런 경우 return type이 추론됨
```kotlin
fun sum(a: Int, b: Int) = a+b
```

- 리턴 할 값이 없는 경우 Unit(Object)으로 리턴 함 
- Unit는 Java에서 void 리턴 역할
```kotlin
fun printKotlin(): Unit {
    println("hello Kotlin")
}
``` 
- Unit은 생략 가능
```kotlin
fun printKotlin() {
    println("hello Kotlin")
}
```

### 지역 변수 정의 
- val: 읽기 전용 변수
- 값의 할당이 1회만 가능, Java의 final과 유사
```kotlin
val a: Int = 1 // 즉시 할당
val b = 2 // `int` type 추론
val c: Int // 컴파일 오류, 초기화가 필요함
c = 3 // 컴파일 오류, 읽기 전용
```

- var: Mutable 변수
```kotlin
var x = 5
x += 1 
```

### 주석
- Java와 Javascript와 동일함
- //: 한 줄 주석
- /* */.: 여러 줄 주석 (block comment)
- block comment가 Java와 다르게 중첩 허용됨 
```kotlin
// 한줄 주석
/* 여러 줄 
주석 */
 
/* block comment가 
    /* 중첩도 가능 */
 */
```

### 문자열 템플릿
- String Interpolation (문자열 보간법) 
```kotlin
var a = 1
// simple name in template:
val s1 = "a is $a"

a = 2
// arbitrary expression in template:
val s2 = "${s1.replace("is", "was")}, but now is $a"
```

### 조건문 
```kotlin
fun maxOf(a: Int, b: Int): Int {
    if (a>b) {
        return a
    } else {
        return b
    }
}
```
- 조건식으로 사용가능
```kotlin
fun maxOf(a: Int, b: Int) = if(a>b) a else b
```

### nullable
- 값이 null일 수 있는 경우 타입에 nullable 마크를 명시 해야 함 
```kotlin
fun parseInt(str: String): Int? {
    //정수가 아닌 경우 null을 리턴
}
```
- nullable 타입의 변수를 접근 할 때는 반드시 null 체크를 해야 함
- 그렇지 않으면 컴파일 오류가 발생 됨
```kotlin
fun printProduct(arg1: String, arg2: String) {
    val x: Int? = parseInt(arg1)
    val y: Int? = parseInt(arg2)
    
    if ( x != null && y != null) {
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}
```

### 자동 타입 변환
- 타입 체크만 해도 자동으로 타입 변환이 됨
```kotlin
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }
    
    return null
}
```

### while loop
```kotlin
val items = listOf("apple", "banana", "kiwi")
var index = 0
while (index < items.size) {
    println("item at $index is ${items[index]}")
    index++
}
```

### when expression
```kotlin
fun describe(obj: Any): String = 
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a String"
        else -> "Unknown"
    }
```

### ranges
- In 연산자를 이용해서 숫자 범위를 체크 가능
```kotlin
val x = 3
if (x in 1..10) {
    println("fits in range")
}
```
- range를 이용한 for loop
```kotlin
for (x in 1..5) {
    print(x)
}
```

### collections
- 컬렉션도 in으로 loop 가능
```kotlin
val items = listOf("apple", "banana", "kiwi")
for (item in items) {
    println(item)
}
```
- in으로 해당 값이 collection에 포함되는지 체크 가능
```kotlin
val items = setOf("apple", "banana", "kiwi")
when {
    "orance" in items -> println("juicy")
    "apple" in items -> println("apple is fine too")
}
```

- 람다식을 이용해서 컬렉션에 filter, map 등의 연산 가능
```kotlin
val fruits = listOf("banana", "avocade", "apple", "kiwi")
fruits
    .filter{ it.startsWith("a")}
    .sortedBy{ it }
    .map {it.toUpperCase() }
    .forEach { println(it) }
```


</details>

## Basic Types

<details><summary>자세히 보기</summary>

### 기본 타입 
- 코틀린에서 모든 것은 객체임
- 모든 것에 멤버 함수나 프로퍼티를 호출 가능하다는 의미이다. 

### 숫자 (Numbers)
- Java의 숫자형과 거의 비슷하게 처리
- Kotlin에서 Number는 클래스임, java의 primitive type에 직접 접근 할 수 없음
- Java에서 숫자형이던 char가 kotlin에서는 숫자 형이 아님 

### 리터럴 (Literal)
- 10진수: 123 (Int, Short)
- Long: 123L
- Double: 123.5, 123.5e10
- Float: 123.5f
- 2진수: 0b00001011
- 8진수: 미지원 ( Java: int I = 017; )
- 16진수: 0x0F

### Underscores in numeric literal (since 1.1)
```kotlin
val oneMilion = 1_000_000
val creditCardNumber = 1234_5678_9012_3456L
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010
```

### Representation
- Java 플랫폼에서 숫자형은 JVM primitive type으로 저장됨
- Nullable이나 제네릭의 경우에는 박싱됨
- 박싱된 경우 identity를 유지 하지 않음
```kotlin
// JVM primitive
val a: Int = 100
print(a === a) // Prints 'true'

// Boxed
val boxedA: Int? = a
val anotherBoxedA: Int? = a
println("==: ${boxedA == anotherBoxedA}") // Prints 'true'
println("===: ${boxedA === anotherBoxedA}") // Prints 'true'
```

### Explicit Conversions
- 작은 타입은 큰 타입의 하위 타입이 아님, 즉 작은 타입에서 큰 타입으로의 대입이 안됨 
```kotlin
val a: Int = 1 // A boxed Int
// val b: Long = a // 오류 
val b: Long = a.toLong()
// println(a == b) // 오류
```

- 명시적으로 변환을 해주어야 함 
```kotlin
val i: Int = b.toInt() // OK 
```
```
toByte(): Byte
toShort(): Short
toInt(): Int
toLong(): Long
toFloat(): Float
toDouble(): Double
toChar(): Char
```

### 문자 (Characters)
- Char는 숫자로 취급 되지 않음
```kotlin
fun check(c: Char) {
    if ( c == 1) { /* ... */ } // ERROR
}

fun check(c: Char) {
    if (c == 'a') { /* ... */ } // OK
}

print('0'.toInt()) // print 48
```

### 배열 
- 배열은 Array 클래스로 표현됨
- get, set ([] 연산자 오버로딩됨)
- size 등 유용한 멤버 함수 포함 
```kotlin
var array: Array<String> = arrayOf("코틀린", "강좌")
println(array.get(0))
println(array[0])
println(array.size)
``` 

### 배열 생성 
- Array의 팩토리 함수를 이용
- arrayOf() 등의 라이브러리 함수 이용 
```kotlin
val b = Array(5, {i -> i.toString() })

val a = arrayOf("0", "1", "2", "3", "4")
```

### 특별한 Array 클래스 
- Primitive 타입의 박싱 오버헤드를 없애기 위한 배열
- IntArray, ShortArray, IntArray
- Array를 상속한 클래스들은 아니지만, Array와 같은 메소드와 프로퍼티를 가짐
- size등 유용한 맴버 함수 포함 
```kotlin
val x: IntArray = intArrayOf(1, 2, 3)
x[0] = 7
println(x.get(0))
println(x[0])
println(x.size)
```

### 문자열
- 문자열은 String 클래스로 표현
- String은 characters로 구성됨
- s[i] 와 같은 방식으로 접근 가능 (immutable이므로 변경 불가)
```kotlin
var x: String = "Kotlin"
println(x.get(0))
println(x[0])
println(x.length)

for (c in x) {
    println(c)
}
```

### 문자열 리터럴
- escaped string ("Kotlin")
  - 전통적인 방식으로 Java String과 거의 비슷
  - Backslash를 사용하여 escaping 처리
- raw string ("""Kotlin"")
  - escaping 처리 필요 없음
  - 개행 이나 어떠한 문자 포함 가능
```kotlin
val s = "Hello, world!\n"

val s = """
"'이것은 코틀린의
 raw String
입니다.'"
"""
```

</details>

## Control Flow

<details><summary>자세히 보기</summary>

### if else 문
- Java와 거의 유사함
```kotlin
//Traditional usage
var max = a
if (a < b) max = b
```
```kotlin
var max: Int
if (a > b) {
    max = a
} else {
    max = b
}
```

- If문이 식으로 사용되는 경우 값을 반환함
- If식의 경우 반드시 else를 동반해야 함
```kotlin
val max = if (a > b) a else b 
```

- If식의 branches들이 블록을 가질 수 있음 {...}
- 블록의 마지막 구문이 반환 값이 됨 
```kotlin
val max = if (a>b) {
    print("Choose a")
    a
} else {
    print("Choose b")
    b
}
```

- 삼항연산자(ternary)가 없음
  - If문이 삼항연산자 역할을 잘 해내기 때문에 

### when
- when 문은 C 계열 언어의 switch문을 대체함
- when 문은 각각의 branches의 조건문이 만족 할 때 까지 위에서 부터 순차적으로 인자를 비교함 
```kotlin
when (x) {
  1 -> print("x == 1")
  2 -> print("x == 2")
  else -> { // Note the block
      print("x is neither 1 nor 2")
  }
}
``` 
- when문이 식으로 사용된 경우에는 조건을 만족하는 branch의 값이 전체 식의 결과 값이 됨
- else의 경우 다른 branch들의 조건이 만족되지 않을 때 수행 됨
- when이 식으로 사용된 경우 else문이 필수임
- when이 식으로 사용된 경우 컴파일러가 else문이 없어도 된다는 것을 입증할 수 있는 경우에는 else를 생략가능
```kotlin
var res = when (x) {
  100 -> "A"
  90 -> "B"
  80 -> "C"
  else -> "F"
}
```
```kotlin
var res = when (x) { // boolean인 경우 true or false이므로 else가 없어도 됨 
  true -> "맞다"
  false -> "틀리다"
}
```
- 여러 조건들이 같은 방식으로 처리될 수 있는 경우, branch의 조건문에 콤마를 (,) 사용하여 표기하면 됨
```kotlin
when (x) {
  0,1 -> print("x==0 or x==1")
  else -> print("otherwise")
}
```
- Branch의 조건문에 함수나 식을 사용할 수 있음 
```kotlin
when (x) {
  parseInt(x) -> print("s encodes x")
  1 + 3 -> print("4")
  else -> print("s does not encode x")
}
```

- range나 collection에 in이나 !in으로 범위 등을 검사 할 수 있음 
```kotlin
val validNumbers = listOf(3,6,9)
when (x) {
  in validNumbers -> print("x is valid")
  in 1..10 -> print("x is in the range")
  !in 10..20 -> print("x is outside the range")
  else -> print("none of the above")
}
```

- is나 !is를 이용하여 타입도 검사 할 수 있음
  - 이 때 스마트 캐스트가 적용됨
```kotlin
fun hasPrefix(x: Any) = when(x) {
  is String -> x.startsWith("prefix")
  else -> false
}
```

- when은 if-else if 체인을 대체할 수 있음
- when에 인자를 입력하지 않으면, 논리연산 으로 처리됨 
```kotlin
when {
  x.isOdd() -> print("x is odd")
  x.isEven() -> print("x is even")
  else -> print("x is funny")
}
```


### For Loops
- for문은 iterator을 제공하는 모든 것을 반복할 수 있음
```kotlin
for (item in collection)
    print(item)
```

- for문의 Body가 블록이 올 수도 있음
```kotlin
for (item in collection) {
  print(item.id)
  print(item.name)
}
```

- For문을 지원하는 iterator의 조건
  - 멤버함수나 확장 함수 중에
    - iterator()를 반환 하는 것이 있는 경우
    - next()를 가지는 경우
    - hasNext(): Bollean를 가지는 경우
    - 함수는 위의 3개를 operator로 표기 되어야 For문을 지원한다. 
```kotlin
val myData = MyData()
for (item in myData) {
    print(item)
}
```
```kotlin
class MyData {
    operator fun iterator(): MyIterator {
        return MyIterator()
    }
}
```
```kotlin
class MyIterator {
  val data = listOf(1,2,3,4,5)
  val idx = 0
  operator fun hasNext(): Boolean {
      return data.size > idx
  }
  
  operator fun next(): Int {
      return data[idx++]
  }
}
```

- 배열이나 리스트를 반복할 때, index를 이용하고 싶다면 indices를 이용하면 됨
```kotlin
val array = arrayOf("가","나","다")
for (i in array.indices) {
    println("$i: ${array[i]}")
}
```
- Index를 이용하고 싶을 때, withIndex()를 이용할 수도 있음
```kotlin
val array = arrayOf("가","나","다")
for ((index, value) in array.withIndex()) {
    println("$index: ${value}")
}
```

### While Loops
- while, do-while문은 java와 거의 같음
- do-while문에서 body의 지역변수를 do-while문의 조건문이 참조 할 수 있음
```kotlin
while (x>) {
    x--
}
```
```kotlin
do {
    val y = retrieveData()
} while ( y != null) // y is visible here!
```




</details>

## Packages, Return and Jumps

<details><summary>자세히 보기</summary>

### Package

- 소스 파일은 패키지 선언으로 시작 됨 
- 모든 콘텐츠(클래스, 함수, ...)는 패키지에 포함 됨
- 패키지를 명세하지 않으면 이름이 없는 기본 패키지에 포함됨 
```kotlin
package foo.bar

fun baz() {}

class Goo {}

fun main(args: Array<String>) {
  foo.bar.baz()
  foo.bar.Goo()
}
```

### 기본 패키지 
- 기본으로 import되는 package가 있음
- 플랫폼 별로 import되는 package도 다른 부분도 있음
```
kotlin.*
kotlin.annotation.*
kotlin.collections.*
kotlin.comparisons.* (since 1.1)
kotlin.io.*
kotlin.ranges.*
kotlin.sequences.*
kotlin.text.*
```
```
JVM:
  java.lang.*
  kotlin.jvm.*
JS:
  kotlin.js.*
```

### Imports
- 기본으로 포함되는 패키지 외에도, 필요한 package들을 직접 import 할 수 있음
```kotlin
// Bar 1개만 import함
import foo.Bar

// 'foo' 패키지에 모든 것을 import함
import foo.*

// foo.Bar
// bar.Bar 이름이 충돌 나는 경우 `as` 키워드로 로컬 리네임 가능
import bar.Bar as bBar
```

### Return and Jumps
- 3가지 Jump 표현식
  - return: 함수나 익명 함수에서 반환
  - break: 루프를 종료 시킴
  - continue: 루프의 다음 단계로 진행
```kotlin
fun sum(a: Int, b: Int): Int {
  println("a: $a, b: $b")
  return a+b
}
```
```kotlin
for (x in 1..10) {
  if(x>2) {
      break
  }
  println("x: $x")
}
```
```kotlin
for (x in 1..10) {
  if ( x < 2) {
      continue
  }
  println("x: $x")
}
```

### Label로 Break and Continue
- 레이블 표현: Label@, abc@, fooBar@
  - 식별자 + @ 형태로 사용 

```kotlin
labelDefinition
(used by prefixUnaryOperation, annotatedLambda)
    : LabelName ++ "@"
;
```
```kotlin
loop@ for (i in 1..10) {
  println("--- i: $i ---")
  
  for (j in 1..10) {
    println("j: $j")
    if (i+j > 12) {
        break@loop   
    }
  }
}
```
```kotlin
loop@ for (i in 1..10) {
  println("--- i: $i ---")
  
  for (j in 1..10) {
    if (j < 2) {
        continue@loop
    }
    println("j: $j")
  }
}
```

### Label로 Return
- 코틀린에서 중첩 될 수 있는 요소들
  - 함수 리터럴 (function literals)
  - 지역함수 (local function)
  - 객체 표현식 (object expression)
  - 함수 (functions)
```kotlin
fun foo() {
  var ints = listOf(0,1,2,3)
  
  ints.forEach(fun(value: Int) {
    if (value == 1) return
    print(value)
  })
  print("End")
}
```

### 람다식에서 return 할 때 주의 사항
- 람다식에서 return시 nearest enclosing 함수가 return됨
- 람다식에 대해서만 return 하려면 label을 이용해야 함
```kotlin
fun foo() {
  var ints = listOf(0,1,2,3)
  
  ints.forEach {
    if (it == 1) return
    print(it)
  }
  print("End")
}
```

```kotlin
fun foo3() {
  var ints = listOf(0,1,2,3)
  ints.forEach label@ {
    if (it == 1) return@label
    print(it)
  }
  print("End")
}
```

### 암시적 레이블
- 람다식에서만 return 하는 경우 label을 이용해서 return 해야 함
- 직접 label을 사용하는 것 보다 암시적 레이블이 편리함
- 암시적 레이블은 람다가 사용된 함수의 이름과 동일함 
```kotlin
fun foo4() {
  var ints = listOf(0,1,2,3)
  ints.forEach {
    if(it==1) return@forEach
    print(it)
  }
  print("End")
}
```

### 레이블 return시 값을 반환할 경우
- return@label 1 형태로 사용
- return + @label + 값 
```kotlin
fun foo(): List<String> {
  var ints = listOf(0,1,2,3)
  var result = ints.map {
    if (it == 0) {
        return@map "zero" // return at named label
    }
    "number $it" // expression returned from lambda
  }
  return result
}
```


</details>

## Class

<details><summary>자세히 보기</summary>

### 클래스
- 클래스는 class 키워드로 선언함
  - 클래스 이름
  - 클래스 헤더 (형식 매개변수, 기본 생성자 등)
  - 클래스 바디 (중괄호 { })
```kotlin
class Invoice(data: Int) {
}
```

- 헤더와 바디는 옵션이고, 바디가 없으면 {} 도 생략 가능
```kotlin
class Empty
```

### 기본 생성자 
- 클래스 별로 1개만 가질 수 있음
- 클래스 헤더의 일부
- 클래스 이름 뒤에 작성
```kotlin
class Person constructor(firstName: String) {
}
```

- 어노테이션이나 접근지정자가 없을 때는, 기본생성자의 construct 키워드를 생략가능 
```kotlin
class Person(firstName: String) {
}
```

- 기본생성자는 코드를 가질 수 없음
  - 초기화는 초기화(init) 블록 안에서 작성해야 함
  - 초기화 블록은 init 키워드로 작성
- 기본생성자의 파라미터는 init 블록 안에서 사용 가능함
```kotlin
class Customer(name: String) {
    init {
        logger.info("Customer initialized with value ${name}")
    }
}
```

- 기본 생성자의 파라미터는 프로퍼티 초기화 선언에도 사용 가능
```kotlin
class Customer(name: String) {
    val customerKey = name.toUpperCase()
}
```

- 프로퍼티 선언 및 초기화는 기본생성자에서 간결한 구문으로 사용 가능 
```kotlin
class Person(val firstname: String, val lastName: String) {
    //...
}
```

- 기본 생성자에 어노테이션 접근지정자 등이 있는 경우 constructor 키워드가 필요함
```kotlin
class Customer public @Inject constructor(name: String) { ... }
```

### 보조 생성자
- 클래스 별로 여러 개를 가질 수 있음
- constructor 키워드로 선언
```kotlin
class Person {
    constructor(parent: Person) {
        parent.children.add(this)
    }
}
``` 
- 클래스가 기본생성자를 가지고 있다면, 각각의 보조생성자들은 기본 생성자를 직접 or 간접적으로 위임해 주어야 함
- this 키워드를 이용
  - 직접적: 기본생성자에 위임
  - 간접적: 다른 보조 생성자에 위임
```kotlin
class Person(val name: String) {
    constructor(name: String, parent: Person): this(name) {
        //...
    }
  
    constructor() :this("홍길동", Person()) {
        //...
    }
}
```

### 생성된(generated) 기본생성자
- 클래스에 기본 생성자 or 보조 생성자를 선언하지 않으면, 생성된 기본 생성자가 만들어짐
- generated primary constructor
  - 매개변수가 없음
  - 가시성이 public임
- 만약 생성된 기본 생성자의 가시성이 public이 아니어야 한다면, 다른 가시성을 가진 빈 기본 생성자를 선언 해야 함 
```kotlin
class DontCreateMe private constructor() {
    
}
```

### 인스턴스 생성
- 코를린은 new 키워드가 없음
- 객체를 생성하려면 생성자를 일반 함수처럼 호출 하면 됨
```kotlin
val invoice = Invoice()

val customer = Customer("Joe Smith")
```

- 클래스 맵버
  - 클래스는 아래의 것들을 포함할 수 있음
  - Constructors and initializer blocks
  - Functions
  - Properties
  - Nested and Inner Classes
  - Object Declarations
  
</details>

## Inheritance

<details><summary>자세히 보기</summary>

### 상속
- 코틀린의 최상위 클래스는 Any임
- 클래스에 상위타입을 선언하지 않으면 Any가 상속됨
```kotlin
class Example1 // 암시적인 Any 상속
class Example2: Any() // 명시적인 Any 상속
```

- Any는 java.lang.Object와는 다른 클래스임
  - equals(), hashCode(), toString() 만 있음
```kotlin
package kotlin
public open class Any {
    public open operator fun equals(other: Any?): Boolean
    public open fun hashCode(): Int
    public open fun toString(): String
}
```

- 명시적으로 상위타입을 선언하려면,
- 클래스헤더의 콜론(:) 뒤에 상위타입을 선언하면 됨
```kotlin
open class Base(p: Int)

class Derived(p: Int) : Base(p)
```
- 파생 클래스에 기본 생성자가 있으면,
  - 파생 클래스의 기본생성자에서 상위타입의 생성자를 호출에서 초기화할 수 있음 

- 파생 클래스에 기본 생성자가 없으면 
  - 각각의 보조 생성자에서 상위타입을 super 키워드를 이용해서 초기화 해주어야 함
  - or 다른 생성자에게 상위 타입을 초기화 할 수 있게 위임 해주어야 함
```kotlin
class MyView: View {
    constructor() : super(1)
    constructor(ctx: Int): this()
    constructor(ctx: INt, attrs: Int) super(ctx, attrs)
}
```

- open 어노테이션은 Java의 final과 반대임
- open class는 다른 클래스가 상속할 수 있음
- 기본적으로 코틀린의 모든 class는 final임
- 이유는: Effective Java, Item 17: Design and document for inheritence or else prohibit it.
```kotlin
open class Base(p: Int)

class Derived(p: Int): Base(p)
```

### 메소드 오버라이딩
- 오버라이딩 될 메소드
  - open 어노테이션이 요구됨
- 오버라이딩 된 메소드
  - override 어노테이션이 요구됨 
```kotlin
open class Base {
    open fun v() {}
    fun nv() {}
}

class Derived(): Base() {
    override fun v() {}
}
```

### 프로퍼티 오버라이딩
- 메소드 오버라이딩과 유사한 방식으로 오버라이딩 가능
```kotlin
open class Foo {
    open val x: Int get {...}
}

class Bar1: Foo() {
    override val x: Int = ...
}
```

### 오버라이딩 규칙
- 같은 멤버에 대한 중복된 구현을 상속 받은 경우, 상속 받은 클래스는 해당 멤버를 오버라이딩 하고 자첵 구현을 제공 해야 함
- super + <클래스명>을 통해서 상위 클래스를 호출 할 수 있음

```kotlin
open class A {
  open fun f() { print("A")}
  fun a() {print("a")}
}

interface B {
  fun f() { print("B")}
  fun b() { print("b")}
}

class C(): A(), B {
  override fun f() {
    super<A>.f() // call to A.f()
    super<B>.f() // call to B.f()
  }
}
```

### 추상 클래스
- abstract 멤버는 구현이 없음
- abstract 클래스나 멤버는 open이 필요 없음
```kotlin
abstract class AbsClass {
    abstract fun f()
}

class MyClass(): AbsClass() {
    override fun f() { /* 구현 */ }
}
```

</details>

## Properties and Fields

<details><summary>자세히 보기</summary>

### 프로퍼티 선언
- 코틀린 클래스는 프로퍼티를 가질 수 있음 
  - var (mutable) / val (read-only)
```kotlin
class Address {
    var name: String = "Kotlin"
    val city: String = "Seoul"
}
```

- 프로퍼티 사용은 자바의 필드를 사용하듯이 하면 됨
```kotlin
fun copyAddress(address: Address): Address {
  val result = Address()
  result.name = address.name
  // ...
  return result 
}
```

### 프로퍼티 문법
- 전체 문법
```
var <propertyName>[: <PropertyType>] [=<property_initializer>]
  [<getter>]
  [<setter>]
```

- 옵션 (생략가능)
  - PropertyType
    - property_initializer에서 타입을 추론 가능한 경우 생략가능
  - property_initializer
  - getter
  - setter

### 프로퍼티 예제
- 두 코드는 거의 같음
```kotlin
class Address {
    var name = "Kotlin"
}
class Address2 {
    var name: String = "Kotlin"
        get() {
            return field
        }
        set(value) {
            field = value
        }
}
```

- var(mutable) 프로퍼티
```kotlin
class Address {
    // default getter와 setter
    // 타입은 Int
    var initialized = 1
  
    // error: 오류 발생
    // default getter와 setter를 사용한 경우
    // 명시적인 초기화가 필요함
    var allByDefault: Int?
}
```

- val(read-only) 프로퍼티
  - var대신 val 키워드 사용
  - setter가 없음
```kotlin
class Address {
    //default getter
    //타입은 Int
    val initialized = 1
  
    //error: 오류 발생
    //default getter
    //명시적인 초기화가 필요함
    val allByDefault: Int?
}
```

### Custom accessors (getter, setter)
- custom accessor는 프로퍼티 선언 내부에, 일반 함수 처럼 선언 할 수 있음
- getter
```kotlin
val isEmpty: Boolean
    get() = this.size == 0
```
- setter
  - 관습적으로 setter의 파라미터의 이름은 value임 (변경가능)
```kotlin
var stringRepresentation: String
    get() = this.toString()
    set(value) {
        setDataFromString(value)
    }
```

### 타입생략
- 코틀린 1.1 부터는 getter를 통해 타입을 추론 할 수 있는 경우, 프로퍼티의 타입을 생략 할 수 있음
```kotlin
val isEmpty: Boolean
    get() = this.size == 0 // has type Boolean
```
```kotlin
val isEmpty
  get() = this.size == 0 // has type Boolean
```

### 프로퍼티
- accessor에 가시성 변경이 필요하거나
- accessor에 어노테이션이 필요한 경우
- 기본 accessor의 수정 없이 body없는 accessor를 통해 정의 가능
```kotlin
var setterVisibility: String = "abc"
    private set
var setterWithAnnotation: Any? = null
    @Inject set // annotate the setter with Inject
```
- Body를 작성해 주어도 됨
```kotlin
var setterVisibility: String = "abc"
    private set(value) {
        field = value 
    }
```

### Backing Fields
- 코틀린 클래스는 field를 가질 수 없음
- 'field'라는 식별자를 통해 접근할 수 있는, automatic backing field를 제공함
- field는 프로퍼티의 accessor에서만 사용 가능 함 
```kotlin
// the initializer value is written directly
// to the backing field
var counter = 0
    set(value) {
        if (value >= 0) field = value 
    }
```

### Backing Fields 생성 조건
- accessor중 1개라도 기본 구현을 사용하는 경우
- custom accessor에서 field 식별자를 참조하느 경우
```kotlin
// the initializer value is written directly to the backing field
var counter = 0
    set(value) {
        if(value >= 0) field = value
    }
```

- 아래의 경우는 bakcing field를 생성하지 않음
```kotlin
val isEmpty: Boolean
    get = this.size == 0
```

### Backing Properties
- "implicit backing field" 방식이 맞지 않는 경우에는
- "backing property"를 이용할 수도 있음
```kotlin
private var _table: Map<String, Int> ? = null
public val table: Map<String, Int>
    get() {
        if (_table == null) {
            _tabel = HashMap()
        }
        return _table ?: throw AssertionError("null ")
    }
```

### Compile-Time Constants
- const modifier를 이용하면 컴파일 타임 상수를 만들 수 있음
  - 이런 프로퍼티는 어노테이션 에서도 사용 가능함
- 조건
  - Top-Level 이거나
  - object의 멤버이거나
  - String이나 프리미티브 타입으로 초기화된 경우
```kotlin
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

@Deprecated(SUBSYSTEM_DEPRECATED)
fun foo() {...}
```

### Late-Initialized Properties
- 일반적으로 프로퍼티는 non-null 타입으로 선언됨
- 간혹 non-null 타입 프로퍼티를 사용하고 싶지만, 생성자에서 초기화를 해줄 수 없는 경우가 있음
  - Dependency injection
  - Butter knife
  - Unit test의 setup 메소드
```kotlin
public class MyTest {
    lateinit var subject: TestSubject
    
    @SetUp fun setup() {
        subjet = TestSubject()
    }
  
    @Test fun test() {
        subject.method() // dereference directly
    }
}
```
- 객체가 constructor에서는 할당 되지 못하지만
- 여전히 non-null타입으로 사용하고 싶은 경우
- Lateinit modifier를 사용가능
- 조건
  - 클래스의 바디에서 선언된 프로퍼티만 가능
  - 기본생성자에서 선언된 프로퍼티는 안 됨
  - var 프로퍼티만 가능
  - custom accessor이 없어야 함
  - non-null 타입이어야 함
  - 프리미티브 타입이면 안됨
- lateinit 프로퍼티가 초기화 되기 전에 접근되면, 오류가 발생됨
  - kotlin.UninitializedPropertyAccessException: lateinit property tet has not been initialized



</details>

## Data, Nested classes

<details><summary>자세히 보기</summary>

### Data 클래스
- 용도: 데이터는 보유하지만 아무것도 하지 않는 클래스
- 코틀린에서는 data class 제공 
```kotlin
data class User(val name: String, val age: Int)
```

- 기본 생성자에서 선언된 속성을 통해, 아래의 기능들을 컴파일러가 자동으로 생성해 줌
  - equals()
  - hashCode()
  - copy()
  - toString() of the form "User(name=John, age=42)",
  - componentN() functions
- 명시적으로 정의해주는 경우에는, 컴파일러가 자동으로 생성해 주지 않음

- 의미 있는 Data 클래스의 조건
  - 기본 생성자에 1개 이상의 파라미터
  - 기본생성자의 파라미터가 var, val로 선언
  - Data 클래스는 abstract, open, sealed, inner가 안됨
- 1.1이후에 바뀐점
  - Data 클래스 interface구현 가능
  - Sealed class 상속 가능 

### 기본 값
- Jvm에서 파라미터 없는 생성자가 필요한 경우
- 모든 프로퍼티에 기본 값을 설정해 주면 됨
```kotlin
data class user(val name: String = "", val age: Int = 0)
```
```kotlin
val exam_0 = User()
val exam_1 = User("Kotlin")
val exam_2 = User("Kotlin", 113)
val exam_3 = User(age=113)
val exam_4 = User(name="Kotlin", age = 113)
```

### 복사
- 객체의 기존 값들은 유지하고, 일부 값만 고쳐서 새로운 객체를 만들고 싶은 경우
- Data 클래스에 컴파일러가 copy를 만들어 주기 때문에 바로 copy를 호출해서 사용하면 됨
```kotlin
fun copy(name: String = this.name, age:Int = this.age) = User(name,age)
```
```kotlin
val jack = User(name = "Jack", age = 1)
val olderJack = jack.copy(age = 2)
```

### Destructing Declarations
- data 클래스는 Destructing Declarations을 사용 가능함
- 컴파일러가 componentN 함수를 자동으로 만들어 주기 때문

```kotlin
val jane = User("Jane", 35)
val (name, age) = jane
println("$name, $age years of age")
// prints "Jane, 35 years of age"
```

### Standard Data Classes
- 스캔다드 라이브러리에서 제공하는 data 클래스도 있음
  - Pair
  - Triple
- 물론 가독성을 위해서는 프로퍼티에 의미 있는 이름을 제공하는 클래스가 최고임
```kotlin
val jane = User("Jane", 35)
println(jane) // User(name=Jane, age=35)

val pair = Pair("Jane", 35)
println(pair) // (Jane, 35)
```

### 중첩 클래스 (Nested Classes)
- 클래스는 다른 클래스에 중첩될 수 있음 
```kotlin
class Outer {
  private val bar: Int = 1
    
  class Nest {
      fun foo() = 2
  }
}

val demo = Outer.Nested().foo() // == 2
```

### 내부 클래스 (Inner Class)
- 클래스에 inner를 표기하면 바깥쪽 클래스의 멤버에 접근 할 수 있음 
```kotlin
class Outer {
  private val bar: Int = 1
  inner class Inner {
      fun foo() = bar
  }
}

val demo = Outer().inner().foo() // == 1
```

### 익명 내부 클래스 (Anonymous inner classes)
- 객체 표현식 (object expression)을 이용해서 익명 내부 클래스의 인스턴스를 생성할 수 있음
```kotlin
mSearchEditText.setOnClickListener(object : View.OnClickListener {
    override fun onClick(v: View?) { // ...
        
    }
})
```
- Functional java interface인 경우에는 접두어에 인터페이스 이름을 사용해서 람다식으로 표현할 수도 있음
```kotlin
mSearchEditText.setOnClickListener( View.OnClickListener {
    v -> // ...
})
```

</details>

## Object Expressions and Declarations

<details><summary>자세히 보기</summary>

- Object 용도
  - 어떤 class에서 조금 변경된 객체를 생성 할 때
  - 새로운 subclass의 명시적인 선언 없이 객체 생성
- Object Expressions
  - Java익명 객체
- Object Declarations
  - 싱글턴
- Companion Object
  - 싱글턴 + Class method (static)

### 객체 표현식
- Java에서는 익명 내부 클래슬르 사용해서 처리했음
- Kotlin에서는 Object Expressions을 이용

**자바 코드 예시**  
```java
btn.setOnClickListener(new OnClickListener() {
   public void onClick(View v) {
       
   } 
});
```

### 객체 표현식 문법
- 어떤 클래스를 상속 받은 익명 객체를 생성 
```kotlin
window.addMouseListener(object: MouseAdapter() {
    override fun mouseClicked(e: MouseEvent) { } 
    override fun mouseEntered(e: MouseEvent) { }
})
```

### 객체 표현식 상속
- 슈퍼타입의 생성자가 있는 경우, 반드시 값을 전달 해 주어야 함
- 슈퍼타입이 여러 개 있는 경우 ':' 콜론 뒤에, ','콤마로 구분해서 명시해주면 됨
```kotlin
open class A(x: Int) {
    public open val y: Int = x
}

interface B {...}

val ab: A = object : A(1), B {
    override val y = 15
}
```

### 객체 표현식 상속 없는 경우
- 특별히 상속 받을 supertypes 가 없는 경우, 간단하게 작성 가능
```kotlin
val adHoc = object {
    var x: Int = 0
    var y: Int = 0
}
print(adHoc.x + adHoc.y)
```

### 객체 표현식 제약 사항
- 익명 객체가 local이나 private으로 선언 될 때만 type으로 사용 될 수 있음
- 익명 객체가 public function이나 public property에서 리턴 되는 경우, 익명 객체의 슈퍼 타입으로 동작됨, 이런 경우 익명 객체에 추가된 멤버에 접근이 불가능함 
```kotlin
class C {
    private fun foo() = object { val x : String = "x" }
    fun publicFoo() = object { val x : String = "X" }
    
    fun bar() {
        val x1 = foo().x // Works
        val x2 = publicFoo().x // ERROR
    }
}
```

### 객체 표현식 특징
- 익명 객체의 코드는 enclosing scope의 변수를 접근 할 수 있음
- Java와는 다르게 final variables 제약 조건이 없음
```kotlin
fun countClicks(window: JComponent) {
  var clickCount = 0
  var enterCount = 0
  window.addMouseListener(object: MouseAdapter() {
      override fun mouseClicked(e: MouseEvent) {
          clickCount++
      }
      override fun mouseEntered(e: MouseEvent) {
          enterCount++
      }
  })
}
```

### 객체 선언 용도 
- 매우 유용한 Singleton 패턴을
- Kotlin에서는 object declarations을 이용해서 만들 수 있음
```kotlin
object DataProviderManater {
    fun registerDataProvider (provider: DataProvider) {
        //...
    }
    val allDataProviders: Collection<DataProvider>
        get() = // ...
}
```

### 객체 선언 문법
- object 키워드 뒤에 항상 이름이 있어야함
- object declaration은 object expression이 아님
- 그래서 할당 구문의 우측에 사용 될 수가 없음
```kotlin
object DataProviderManager {
    fun registerDataProvider(provider: DataProvider) {}
    val allDataProviders: Collection<DataProvider>
}
```

- object declaration의 객체를 참조 하려면, 해당 이름으로 직접 접근하면 됨
```kotlin
DataProviderManager.registerDataProvider(...)
```

- 슈퍼 타입을 가질 수 있음 (상속가능)
```kotlin
object DefaultListener : MouseAdapter() {
  override fun mouseClicked(e: MouseEvent) { }
  override fun mouseEntered(e: MouseEvent) { }
}
```

### 동반자 객체 (Companion Object)
- 클래스 내부의 object declaration은 companion 키워드를 붙일 수 있음
```kotlin
class MyClass {
  campanion object Factory {
      fun create(): MyClass = MyClass()
  }
}
```

- companion object의 멤버는 클래스 이름을 통해서 호출 할 수 있음 
```kotlin
val instance = MyClass.create()
```

- Companion object의 이름은 생략 될 수 있음
- 이런 경우 [class name].Companion 형태로 객체에 접근 가능
```kotlin
class MyClass {
    companion object {
        
    }
}

val x = MyClass.Campanion
```

- campanion object의 멤버가 다른 언어의 static 멤버 처럼 보일 수 있지만 아님
- companion object의 멤버는 실제 객체의 멤버임
- 슈퍼클래스도 가질 수 있는 클래스의 객체임
```kotlin
interface Factory<T> {
  fun create(): T 
}

class MyClass {
  companion object : Factory<MyClass> {
      override fun create(): MyClass = MyClass()
  }
}
```

### object expressions vs object declaration
- object expressions는 즉시 초기화 되고 실행 된다
- object declarations는 나중에 초기화 된다 (최초 접근 시)
- companion object는 클래스가 로드 될 때 초기화 됨, java static initializer와 매칭됨 



</details>