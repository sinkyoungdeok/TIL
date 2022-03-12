
# 출처
- url: https://www.inflearn.com/course/%EC%83%88%EC%B0%A8%EC%9B%90-%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%BD%94%EB%A3%A8%ED%8B%B4/dashboard
- 강사님: 새차원

---


# 1. why coroutines


### Coroutine 용어
- 코루틴(coroutine)은 루틴의 일종
- 협동 루틴이라 할 수 있다
- 코루틴의 "Co"는 with 또는 together를 뜻한다.

### Coroutine 특징 
- 코루틴은 이전에 자신의 실행이 마지막으로 **중단**되었던 지점 다음의 장소에서 실행을 **재개**한다
- 코루틴은 협력작업, 예외, 이벤트 루프, 반복자, 무한 목록 및 파이프와 같은 친숙한 프로그램 구성 요소를 구현하는데 적합하다
- 코루틴은 비동기처리에 대한 코드를 간단히 작성할 수 있음
- 코루틴은 메인스레드가 블록킹되는 것에 대해서 도움을 준다.
- 코루틴은 비동기 콜백처리하는 코드를 순차적으로 짤 수 있게 해준다. 

---

# 2. basics

### Coroutine
- 코루틴은 경량 쓰레드이다.

### Coroutine builder
- coroutine builder에서 코루틴이 만들어지고, 블럭(코루틴 Scope) 안에서 코루틴이 실행된다.
- 코루틴 빌더를 사용하기 위해서는 Scope가 필요하다. 
- launch: 자신을 호출한 쓰레드를 블록킹 하지 않는다.
- runBlocking: 자신을 호출한 쓸레드를 블록킹 한다. 

### Scope
- 코루틴이 실행되는 영역 
- GlobalScope: life time이 프로그램 전체를 가진다. (전역 스코프)
- CoroutineScope: 코루틴 블럭(영역)을 생성하는 역할 

### join()
- 코루틴이 끝나는 것을 기다린다. (delay로도 기다릴 수 있지만, delay로 처리하는 것은 좋은 방법이 아니다)
```kotlin
fun main() = runBlocking {
  val job = GlobalScope.launch {
    delay(3000L)
    println("World!")
  }

  println("Hello,")
  job.join() // job이 끝날때까지 main 쓰레드를 blocking
}
```

### Structed concurrency
- runBlocking안에 GlobalScope(탑 레벨 코루틴)를 쓰게되면, GlobalScope는 runBlocking과는 상관없이 프로그램이 돌게 된다. (join이 없을 경우)
- runBlocking과 launch에서 실행된 코루틴이 구조적으로 관계를 가지면 서로를 기다릴 수 있게된다. 이것이 Structed Concurrency이다.
```kotlin
fun main() = runBlocking {
    this.launch {
        delay(1000L)
        println("World!")
    }

    this.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello,")
}
```

### Suspend function
- 일반 함수에서는 delay와 같은 코루틴에서 사용하는 키워드를 사용할 수 없다.
- 이것을 위해서 suspend 함수가 필요한데, 함수를 일시중단 될 수 있게(코루틴이 가능하게) 만들어 주는 키워드이다.
- suspend function인 delay(), join() 등은 suspend 키워드가 붙은 함수 혹은 코루틴 내에서만 호출할 수 있다. 

```kotlin
fun main() = runBlocking {
    this.launch {
        myWorld()
    }

    println("Hello,")
}

suspend fun myWorld() {
    delay(1000L)
    println("world.")
}
```


### 코루틴은 경량 스레드이다.
- 많은 양의 코루틴을 만들어도 부하가 적다 
- 코루틴의 같은 코드를 스레드로 만들어 보면 굉장히 느리게 동작하고, 메모리 오류가 날 수 있다
```kotlin
fun main() = runBlocking {
    repeat(100_000) {
        launch { // launch부분을 thread로 바꿔보면 상당한 차이를 느낄 수 있다. 
            delay(1000L)
            print(".")
        }
    }
}

```

### 코루틴은 데몬 쓰레드와 비슷하다.
- 코루틴이 계속 실행 되어 있다고 해도, 프로세스가 유지되지 않는다.
- 프로세스가 살아있을 때만, 코루틴이 동작한다.
```kotlin
fun main() = runBlocking {
    GlobalScope.launch { 
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // 1.3초가 지난후에 코루틴도 같이 종료된다.
}
```

### 코루틴 예제 
```kotlin
fun main() = runBlocking {
    launch { // A가 다 끝난 뒤, B가 실행된다.
        repeat(5) { i ->
            println("Coroutine A, $i")
        }
    }

    launch {
        repeat(5) { i ->
            println("Coroutine B, $i")
        }
    }

    println("Coroutine Outer")
}
```

```kotlin
fun main() = runBlocking {
    launch { 
        repeat(5) { i ->
            println("Coroutine A, $i")
            delay(10L) // A가 한번 호출됐다가, 중지된상태에서 B가 모두 출력되고나서 나머지 A들이 출력 된다.
        } 
    }

    launch {
        repeat(5) { i ->
            println("Coroutine B, $i")
        }
    }

    println("Coroutine Outer")
}
```

```kotlin
fun main() = runBlocking {
    launch { 
        repeat(5) { i ->
            println("Coroutine A, $i")
            delay(10L) 
        } 
    }

    launch {
        repeat(5) { i ->
            println("Coroutine B, $i")
            delay(10L) // A와 B가 번갈아 가면서 호출된다.
        }
    }

    println("Coroutine Outer")
}
```


---

# 3. Cancellation and Timeouts

<details><summary> 자세히 보기 </summary>

- Job
  - cancel()
- Cancellation is cooperative
  - way 1: to periodically invoke a suspending
  - way 2: explicitly check the cancellation status (isActive)
- Timeout
  - withTimeout
  - withTimeoutOrNull

</details>


# 4. Composing Suspending Functions

<details><summary> 자세히 보기 </summary>

- Async to sequential
  - Sequential by default
  - The Dream Code on Android

- async
  - Concurrent using async
  - Lazily started async

- Structured concurrency
  - Async-style functions (strongly discouraged)
  - Structured concurrency with async

</details>


# 5. Coroutines under the hood

<details><summary> 자세히 보기 </summary>

- There is no magic
  - CPS == Callbacks
  - CPS Transformation
- Decompile
  - Labels
  - Callback
- CPS simulation
  - debugging

</details>


# 6. Coroutine Context and Dispatchers

<details><summary> 자세히 보기 </summary>

### Dispatchers and threads
- coroutine context는 coroutine dispatcher를 포함한다.
- coroutine dispatcher는 어떤 스레드에서 실행될지를 결정한다.
- 모든 코루틴 빌더들은 optional로 coroutineContext parameter를 가지고 있다.

### 코루틴 디버깅 방법
- JVM option에 -Dkotlinx.coroutines.debug 명령어를 추가 하면 됨 

### 다룬내용
- Dispatchers and threads
- Debugging coroutines and threads
- Jumping between threads
- Job in the context
- Children of a coroutine
- Parental responsibilities
- Combining context elements
- Coroutine scope

</details>