
# 출처
- url: https://www.inflearn.com/course/%EC%83%88%EC%B0%A8%EC%9B%90-%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%BD%94%EB%A3%A8%ED%8B%B4/dashboard
- 강사님: 새차원

# 1. why coroutines

<details><summary> 자세히 보기 </summary>

### Coroutine
- 코루틴(coroutine)은 루틴의 일종
- 협동 루틴이라 할 수 있다
- 코루틴의 "Co"는 with 또는 together를 뜻한다.

- 코루틴은 이전에 자신의 실행이 마지막으로 **중단**되었던 지점 다음의 장소에서 실행을 **재개**한다
![image](https://user-images.githubusercontent.com/28394879/146778353-0cb4f22d-8216-473a-a43b-e00807d7434f.png)

- 코루틴은 협력작업, 예외, 이벤트 루프, 반복자, 무한 목록 및 파이프와 같은 친숙한 프로그램 구성 요소를 구현하는데 적합하다



</details>


# 2. basics

<details><summary> 자세히 보기 </summary>

- Coroutine builder
  - launch
  - runBlocking
- Scope
  - CoroutineScope
  - GlobalScope
- Suspend function
  - suspend
  - delay()
  - join()
- Structed concurrency

</details>


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