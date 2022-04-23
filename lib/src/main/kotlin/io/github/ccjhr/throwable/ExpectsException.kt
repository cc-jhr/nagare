package io.github.ccjhr.throwable

/**
 * Wrapper for code which is expected to throw a [Throwable] and returns it for inspection.
 * @since 1.0.0
 * @param invocation Code which is expected to throw a [Throwable] of type [T].
 * @return The exception that was thrown in case it has the expected type.
 * @throws [RuntimeException] In case the exception which was thrown is of type [T] or no exception was thrown at all.
 * @sample io.github.ccjhr.samples.throwable.expectsException
 */
inline fun <reified T: Throwable> expectsException(invocation: () -> Any): T {
    try {
        invocation.invoke()
    } catch (e: Throwable) {
        when (e) {
            is T -> return e
            else -> throw RuntimeException("Expected [${T::class.qualifiedName}] to be thrown, but [${e::class.qualifiedName}] was thrown.")
        }
    }

    throw RuntimeException("Expected exception of type [${T::class.qualifiedName}], but nothing was thrown.")
}