package io.github.ccjhr

import io.github.ccjhr.any.isOfType

/**
 * @since 2.0.0
 * @param content Object under test.
 * @see given
 */
@Experimental
data class GivenContext<T : Any>(val content: T)

/**
 * @since 2.0.0
 */
@Experimental
inline fun <reified T: Any> given(setup: () -> T): GivenContext<T> = GivenContext(setup.invoke())

/**
 * @since 2.0.0
 * @receiver
 */
@Experimental
inline infix fun <reified T: Any, R> GivenContext<T>.`when`(doSth: (T) -> R) : AssertionContext<R> = AssertionContext(doSth.invoke(this.content))

/**
 * @since 2.0.0
 */
@Experimental
inline fun <reified R> `when`(doSth: () -> R) : AssertionContext<R> = AssertionContext(doSth.invoke())

/**
 * @since 2.0.0
 * @receiver
 */
@Experimental
inline infix fun <reified T> AssertionContext<T>.then(doSth: (AssertionContext<T>) -> Unit) = doSth.invoke(this)



@OptIn(Experimental::class)
fun main() {
    val expectedElements = setOf<Int>()


    given {
        Tester()
    } `when` {
        it.doSomething()
    } then {
        it isOfType Tester::class
    }


    `when` {
        Tester().doSomething()
    } then {
        it isOfType Tester::class
    }
}


class Tester {
    fun doSomething() {}
}