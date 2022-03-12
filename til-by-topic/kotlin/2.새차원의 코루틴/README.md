
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

### Structured Concurrency
- runBlocking안에 GlobalScope(탑 레벨 코루틴)를 쓰게되면, GlobalScope는 runBlocking과는 상관없이 프로그램이 돌게 된다. (join이 없을 경우)
- runBlocking과 launch에서 실행된 코루틴이 구조적으로 관계를 가지면 서로를 기다릴 수 있게된다. 이것이 structured Concurrency이다.
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

  
### 코루틴 취소
- 코루틴을 정교하게 취소해주는 것은 중요하다.
- 왜냐하면, 메모리라는 리소스를 차지하기 때문이다.
- 코루틴 취소하는 방법은 간단하지만, 코루틴 자체가 취소에 대해서 협조적인 상태가 되어야 하는게 중요하다.

```kotlin
fun main() = runBlocking {
    var job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L) 
        }
    }
    delay(1300L) // 1.3초 뒤에 job을 취소
    println("main: I'm tired of waiting!")
    job.cancel()
    job.join()
    println("main: Now I can quit.")
}
```

### 코루틴 취소는 협조적이다.
- 코루틴이 취소가 되려면 조건이 필요하다. 즉, 협력이 필요하다. 
- suspend function은 취소가 가능하다.
- suspend function을 호출하면 취소됐는지 확인할 수 있다. 
- yield() 함수를 통해서 정상 취소가 가능하다. (취소가 되면 내부적으로 예외를 던져서 종료시킴)
```kotlin
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) { // 이 예제는 코루틴 취소에 대해서 협조적이지 않다. (suspend function이 안불렸기 때문)
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                // delay(1L) // 이 주석을 지우면 suspend function이 호출되므로 정상적으로 cancel이 된다. 
                // yield() // 위의 delay를 호출하지 않고, yield()를 통해서 취소를 확인 할 수 있다 ( 이 방법이 더 좋다)
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // 1.3초 뒤 코루틴 취소를 하려고하지만, 잘 안되는 것을 확인할 수 있다. 
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() 
    println("main: Now I can quit.")
}


```


### 복잡한 코루틴 코드를 취소 가능 하도록 만들기
1) 주기적으로 suspend fucntion을 호출한다 (ex: yield)
2) 명시적으로 취소에 대한 상태를 체크한다 (isActive) - 여기에서 사용한 방법 
```kotlin
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        // 이 방법은 exception을 던지지 않는다.
        var nextPrintTime = startTime
        var i = 0
        println("isActive $isActive ...")
        while (isActive) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
        println("isActive $isActive ...")
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}
```

### 코루틴을 종료 할 때 리소스 해제 방법 
- 코루틴에서 네트워크를 사용하거나 DB를 쓸 때, 도중에 코루틴이 취소되면 리소스를 닫아주고 종료해야 한다.

```kotlin
fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            // 여기에서 리소스를 종료 해준다. 
            println("job: I'm running finally")
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}
```

### 취소가 불가능한 영역을 실행
- 드문 케이스이다.
- 캔슬을 실행해서 이미 코루틴이 캔슬된 상태에서 다시 코루틴을 실행하는 상황 
- withContext(NonCancellable)을 활용한다.
```kotlin
fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable) { // finally부분에서 다시 코루틴을 사용하기 위함
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}
```

### Timeout
- 코루틴을 다른곳에서 취소하는 것이 아닌, 코루틴을 실행할 때 이 시간이 지난후에 종료하게끔 하는 것이다.
- 시간이 지나면 Exception을 던지는데, main에서 던지기 때문에 에러가 발생한다.
```kotlin
fun main() = runBlocking {
    withTimeout(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
}
```

### withTimeoutOrNull
- 예외를 던지는 것 대신에 null을 리턴해준다.
```kotlin
fun main() = runBlocking {
    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
        "Done" // will get cancelled before it produces this result
    }
    println("Result is $result")
}
```


---

# 4. Composing Suspending Functions


### 기본 순차적 코딩
- 코루틴에서 일반 코드처럼 작성하게되면, 비동기이지만 순차적으로 실행 된다.
```kotlin
fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUseFulOne()
        val two = doSomethingUseFulTwo()
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUseFulOne(): Int {
    println("doSomethingUsefulOne - START")
    delay(1000L)
    println("doSomethingUsefulOne - END")
    return 13
}

suspend fun doSomethingUseFulTwo(): Int {
    println("doSomethingUsefulTwo - START")
    delay(1000L)
    println("doSomethingUsefulTwo - END")
    return 29
}
```
```
결과 
doSomethingUsefulOne - START
doSomethingUsefulOne - END
doSomethingUsefulTwo - START
doSomethingUsefulTwo - END
The answer is 42
Completed in 2011 ms
```

### async를 통한 동시성 처리 
- 바로 위 예제는 1초 걸리는 연산을 2번해서 2초가 걸렸는데, 두 연산의 처리가 의존적이지 않은 상황일 때 동시에 처리하면 더 빠를 것이다.
- 코루틴 내부에서 순차적으로 코드를 작성하면, 순차적으로 실행이 되는데 이걸 비동기적으로 실행하고 싶으면 명시적으로 async로 콜해야 한다. 
- async로 1초 짜리 두개의 연산을 실행하면 1초가 걸린다.
- await은 async가 끝날때 까지 기다린다. 
- async는 코루틴 빌더이다. 

```kotlin
fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
//        delay(2000L)
//        println("test..")
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne(): Int {
    println("doSomethingUsefulOne - START")
    delay(1000L)
    println("doSomethingUsefulOne - END")
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    println("doSomethingUsefulTwo - START")
    delay(1000L)
    println("doSomethingUsefulTwo - END")
    return 29
}
```
```
doSomethingUsefulOne - START
doSomethingUsefulTwo - START
doSomethingUsefulOne - END
doSomethingUsefulTwo - END
The answer is 42
Completed in 1017 ms
```


### async 코루틴을 지연시켜서 실행시키기 
- CoroutineStart.LAZY로 async를 쓰면, `start()` 혹은 `await()`을 콜할 때 실행된다.
```kotlin
fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async (start = CoroutineStart.LAZY){ doSomethingUsefulOne3() }
        val two = async (start = CoroutineStart.LAZY){ doSomethingUsefulTwo3() }

        println("START")
        delay(2000L)
        one.start()
        two.start() // one.start(), two.start()값을 제거하면 one.await()이 완료된 후에 two.await()이 실행되므로 두 연산에 2초가 걸린다

        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne3(): Int {
    println("doSomethingUsefulOne - START")
    delay(1000L)
    println("doSomethingUsefulOne - END")
    return 13
}

suspend fun doSomethingUsefulTwo3(): Int {
    println("doSomethingUsefulTwo - START")
    delay(1000L)
    println("doSomethingUsefulTwo - END")
    return 29
}
```
```
START
doSomethingUsefulOne - START
doSomethingUsefulTwo - START
doSomethingUsefulOne - END
doSomethingUsefulTwo - END
The answer is 42
Completed in 3022 ms
```

### async-style 함수 
- 위의 async 예제들을 작성하다보면, async를 호출하는 것 자체를 함수로 만들어서 사용하고 싶은 유혹이 생길 수 있는데, 그러면 안된다는 것을 보여준다.
- xxxAsync functions 들은 suspend functions이 아니다.
- 이 스타일은 코틀린 코루틴에서는 안쓰는 것이 좋다
- 이러한 문제는 structured concurrency를 통해 해결할 수 있다. 
```kotlin
fun main() { // 이렇게 쓰면 안된다 라는 예제를 보여준것임. GlobalScope.async를 하게 되면 exception이 발생했음 에도 불구하고 코루틴이 계속 실행되는것을 볼 수 있음
    try { // GlobalScope로 선언했기 때문에, 이 어플리케이션 종료와는 무관한 async함수들이 되버린다. 그러므로, 이 어플리케이션이 excpetion이 터져서 종료되도 실행되는 것이다. 
        val time = measureTimeMillis {
            val one = somethingUsefulOneAsync4()
            val two = somethingUsefulTwoAsync4()

            println("my exceptions")
            throw Exception("my exceptions")

            runBlocking {
                println("The answer is ${one.await() + two.await()}")
            }
        }
        println("Completed in $time ms")
    } catch (e: Exception) {

    }

    runBlocking {
        delay(100000)
    }
}

fun somethingUsefulOneAsync4() = GlobalScope.async {
    println("start, somethingUsefulOneAsync")
    val res = doSomethingUsefulOne4()
    println("end, somethingUsefulOneAsync")
    res
}

fun somethingUsefulTwoAsync4() = GlobalScope.async {
    println("start, somethingUsefulTwoAsync")
    val res = doSomethingUsefulTwo4()
    println("end, somethingUsefulTwoAsync")
    res
}

suspend fun doSomethingUsefulOne4(): Int {
    println("doSomethingUsefulOne - START")
    delay(3000L)
    println("doSomethingUsefulOne - END")
    return 13
}

suspend fun doSomethingUsefulTwo4(): Int {
    println("doSomethingUsefulTwo - START")
    delay(3000L)
    println("doSomethingUsefulTwo - END")
    return 29
}
```
```
my exceptions
start, somethingUsefulTwoAsync
start, somethingUsefulOneAsync
doSomethingUsefulTwo - START
doSomethingUsefulOne - START
doSomethingUsefulTwo - END
doSomethingUsefulOne - END
end, somethingUsefulOneAsync
end, somethingUsefulTwoAsync
```

### Structured concurrency with async
```kotlin
fun main() = runBlocking {
    try {
        val time = measureTimeMillis {
            println("The answer is ${concurrentSum()}")
        }
        println("Completed in $time ms")
    } catch (e: Exception) {

    }

    runBlocking {
        delay(5000)
    }
}

// 바로 이전 예제처럼 아무 곳에서나 쓸 수 있는 것이 아니라, 코루틴 안에서만 사용 가능하다.
suspend fun concurrentSum(): Int = coroutineScope { // coroutineScope를 사용함으로써 exception이 발생하면 전체 코루틴이 취소된다.
    val one = async { doSomethingUsefulOne5() }
    val two = async { doSomethingUsefulTwo5() }

    delay(10)
    println("Exception")
    throw Exception()

    one.await() + two.await()
}

suspend fun doSomethingUsefulOne5(): Int {
    println("doSomethingUsefulOne - START")
    delay(3000L)
    println("doSomethingUsefulOne - END")
    return 13
}

suspend fun doSomethingUsefulTwo5(): Int {
    println("doSomethingUsefulTwo - START")
    delay(3000L)
    println("doSomethingUsefulTwo - END")
    return 29
}
```
```
doSomethingUsefulOne - START
doSomethingUsefulTwo - START
Exception
```

### 코루틴은 예외가나 취소가 hierarchy하게 전파된다.
```kotlin
fun main() = runBlocking<Unit> {
    try {
        failedConcurrentSum()
    } catch (e: ArithmeticException) {
        println("Computation failed with ArithmeticException")
    }
}

suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async<Int> {
        try {
            delay(Long.MAX_VALUE)
            42
        } finally {
            println("First child was cancelled")
        }
    }
    val two = async<Int> {
        println("Second child throws an exception")
        throw ArithmeticException()
    }

    one.await() + two.await()
}
```
```
Second child throws an exception
First child was cancelled
Computation failed with ArithmeticException
```

---

# 5. Coroutines under the hood

### 코루틴은 마법이 아니다.
- 내부적으로 코틀린 컴파일러가 콜백형태로 만들어서 콜백을 해준다. 즉, 일반적인 코드이다.
- 컴파일해보면, Continuation Pass Style == CPS 스타일로 변경되는 것을 확인할 수 있다.

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