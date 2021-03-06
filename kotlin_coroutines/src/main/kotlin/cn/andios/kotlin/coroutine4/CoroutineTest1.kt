package cn.andios.kotlin.coroutine4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

/**
 * @author lvsdian
 * Created on 2020-08-27
 */
// 协程与线程的关系
// 协程上下文与分发器（Coroutine Context与Dispatcher）
// 协程总是会在某个上下文中执行，这个上下文实际上是由CoroutineContext类型的一个实例来表示的，该实例是由kotlin标准库来定义的
// 协程上下午本质上是各种元素所构成的一个集合，其中，主要的元素包括协程的Job，以及分发器
// 所谓的分发器，其主要功能就是确定由哪个线程来执行我们所指定的协程代码
// 协程上下文包含了一个协程分发器（CoroutineDispatcher），协程分发器确定了到底由哪个线程或是线程池来执行我们所指定的协程，协程
// 分发器可以将协程的执行限制到一个具体指定的线程，也可以将协程的执行分发到一个线程池中，由线程池中的某个线程来执行我们所指定的协程，
// 还可以不加任何限制的去执行我们所指定的协程代码(这种情况下，我们所指定的协程代码到底是由哪个线程或线程池来执行是不确定的，这种方式的
// 协程分发器在一般的开发中使用较少，它只用在一些极为特殊的情况下)
// 所有的协程构建器（Coroutine builder）如launch何async都会接收一个可选的CoroutineContext参数，该参数可用于显式指定新协程所运行的分发器
// 以及其他上下文元素

// 程序分析：
// 1.当通过launch来启动协程并且不指定协程分发器时，它会继承启动它的那个CoroutineScope的上下文与分发器，对于该实例来说，它会继承runBlocking的上下文，
//  而runBlocking则是运行在main线程中
// 2.Dispatcher.Unconfined是一种很特殊的协程分发器，它在如下示例中也是运行在main线程中，但实际上，它的运行机制与不指定协程分发器是是完全不同的
// 3.Dispatcher.Default是默认的分发器，当协程是通过GlobalScope来启动时，它会使用该默认的分发器来启动协程，它会使用一个后台的共享线程池来运行我们的协程代码
//  因此,launch(Dispatcher.Default)等价于GlobalScope.launch{}
// 4.Executors.newSingleThreadExecutor().asCoroutineDispatcher()会创建一个单线程的线程池，该线程池中的线程用来执行我们所指定的协程代码：在实际的开发中，使用专门的线程
//  来执行协程代码代价是非常高的，因此在协程中代码执行完毕后，我们必须要释放相应的资源，这里就需要使用close()方法来关闭相应的协程分发器，从而释放掉资源；也可以将该协程分发器
//  存储到一个顶层变量中，以便在程序的其他地方进行复用
fun main() = runBlocking<Unit> {
    //no params, thread:main
    launch {
        println("no params, thread:${Thread.currentThread().name}")
    }

    // Dispatchers.Unconfined invoked, thread:main
    launch(Dispatchers.Unconfined) {
        delay(100)
        println("Dispatchers.Unconfined invoked, thread:${Thread.currentThread().name}")
    }

    // Dispatchers.Default invoked, thread:DefaultDispatcher-worker-1
    launch(Dispatchers.Default) {
        println("Dispatchers.Default invoked, thread:${Thread.currentThread().name}")
    }

    //single thread executor invoked, thread:pool-1-thread-1
    // 将线程池作为要执行协程代码的分发器
    val thread = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    launch(thread) {
        println("single thread executor invoked, thread:${Thread.currentThread().name}")
    }
    // 如果这里不close()，整个程序就不会退出
    thread.close()

    //GlobalScope.launch, thread:DefaultDispatcher-worker-1
    GlobalScope.launch() {
        println("GlobalScope.launch, thread:${Thread.currentThread().name}")
    }
}