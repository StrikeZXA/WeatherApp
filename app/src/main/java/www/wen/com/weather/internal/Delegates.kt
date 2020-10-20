package www.wen.com.weather.internal

import kotlinx.coroutines.*

/**
 * @author WEN
 * @Description:
 * @date 2020/10/14 21:10
 */

fun <T> lazyDeferred(block:suspend CoroutineScope.() -> T):Lazy<Deferred<T>>{
    return lazy{
        GlobalScope.async(start = CoroutineStart.LAZY) { block.invoke(this) }
    }
}

