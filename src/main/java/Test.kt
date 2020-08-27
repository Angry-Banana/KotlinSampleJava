import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope.coroutineContext

object Test {

    @JvmStatic
    fun main(args: Array<String>) {
        println("Main Thread Name: ${Thread.currentThread().name} + Main ThreadId:${Thread.currentThread().id}")
        asyncAndWait2()
        println("Main Thread Name: ${Thread.currentThread().name} + Main ThreadId:${Thread.currentThread().id}")
        while (true) {

        }
    }

    /**
     * 不会阻塞主线程
     */
    private fun aboutGlobalScope() {
        GlobalScope.launch {
            delay(100)
            println("Thread Name: ${Thread.currentThread().name} +  ThreadId:${Thread.currentThread().id}")
        }
    }

    /**
     * 会阻塞主线程
     */
    private fun aboutRunBlocking() {
        runBlocking {
            delay(100)
            println("Thread Name: ${Thread.currentThread().name} +  ThreadId:${Thread.currentThread().id}")
        }
    }

    /**
     * 测试协程之间的是否是并发的
     */
    private fun isAsynchronous() = runBlocking {
        launch {
            println("launch1")
            println("Thread Name: ${Thread.currentThread().name} +  ThreadId:${Thread.currentThread().id}")
            delay(1000)
            println("launch1 finished")
        }
        launch {
            println("launch2")
            println("Thread Name: ${Thread.currentThread().name} +  ThreadId:${Thread.currentThread().id}")
            delay(1000)
            println("launch2 finished")
        }
    }

    /**
     * 协程的创建，销毁，调度的效率高
     */
    private fun lowConsume() {
        val start = System.currentTimeMillis()
        runBlocking {
            repeat(10000) {
                launch {
                    println(".")
                }
            }
        }
        val end = System.currentTimeMillis()
        println("time: ${end - start}")
    }

    /**
     * 串行操作
     */
    private fun asyncAndWait1() {
        runBlocking {
            val start = System.currentTimeMillis();
            val result1 = async {
                delay(1000)
                5 + 5
            }.await()
            val result2 = async {
                delay(1000)
                4 + 6
            }.await()
            println("result is ${result1 + result2}")
            val end = System.currentTimeMillis()
            println("time: ${end - start}")
        }
    }

    /**
     * 并行操作
     */
    private fun asyncAndWait2() {
        runBlocking {
            val start = System.currentTimeMillis();
            val deferred1 = async {
                delay(1000)
                5 + 5
            }
            val deferred2 = async {
                delay(1000)
                4 + 6
            }
            println("result is ${deferred1.await() + deferred2.await()}")
            val end = System.currentTimeMillis()
            println("time: ${end - start}")
        }
    }

    private fun aboutCoroutineScope() {
        GlobalScope.launch {
            printfThread()
            printfThread()
        }
    }

    private suspend fun printfThread() = coroutineScope {
        launch {
            delay(100)
            println("Thread Name: ${Thread.currentThread().name} +  ThreadId:${Thread.currentThread().id}")
        }
    }
}