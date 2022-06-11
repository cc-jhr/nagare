package io.github.ccjhr.throwable

import io.github.ccjhr.Experimental

/**
 * Checks if code will throw a [Throwable] or not.
 * @since 2.0.0
 * @param invocation Code which possibly throws an exception.
 * @return `true` if no [Throwable] has been thrown.
 */
@Experimental
fun noExceptionThrown(invocation: () -> Any): Boolean {
    return try {
        invocation.invoke()
        true
    } catch (e: Throwable) {
        false
    }
}