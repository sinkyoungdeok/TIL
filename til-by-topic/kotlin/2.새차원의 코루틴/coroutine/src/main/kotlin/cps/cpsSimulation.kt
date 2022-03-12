package cps

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/*
GlobalScope.launch {
    val userData = fetchUserData()
    val userCache = cacheUserData(userData)
    updateTextView(userCache)
*/

fun main() {
    println("[in] main")
    myCoroutine(MyContinuation())
    println("\n[out] main")
}

fun myCoroutine(cont: MyContinuation) {
    when(cont.label) {
        0 -> {
            println("\nmyCoroutine(), label: ${cont.label}")
            cont.label = 1
            fetchUserData(cont)
        }
        1 -> {
            println("\nmyCoroutine(), label: ${cont.label}")
            val userData = cont.result
            cont.label = 2
            cacheUserData(userData, cont)
        }
        2 -> {
            println("\nmyCoroutine(), label: ${cont.label}")
            val userCache = cont.result
            updateTextView(userCache)
        }
    }
}

fun fetchUserData(cont: MyContinuation) {
    println("fetchUserData(), called")
    val result = "[서버에서 받은 사용자 정보]"
    println("fetchUserData(), 작업완료: $result")
    cont.resumeWith(Result.success(result))
}

fun cacheUserData(user: String, cont: MyContinuation) {
    println("cacheUserData(), called")
    val result = "[캐시함 $user]"
    println("cacheUserData, 작업완료: $result")
    cont.resumeWith(Result.success(result))
}

fun updateTextView(user: String) {
    println("updateTextView(), called")
    println("updateTextView(), 작업완료: [텍스트 뷰에 출력 $user]")
}

class MyContinuation(override val context:
                     CoroutineContext = EmptyCoroutineContext): Continuation<String> {
    var label = 0
    var result = ""

    override fun resumeWith(result: Result<String>) {
        this.result = result.getOrThrow()
        println("Continuation.resumeWith()")
        myCoroutine(this)
    }
}