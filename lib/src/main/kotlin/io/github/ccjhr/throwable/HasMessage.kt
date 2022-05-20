package io.github.ccjhr.throwable

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the message of a [Throwable] has the given value.
 * @since 1.0.0
 * @param message The message the [Throwable] is expected to have.
 * @throws AssertionError In case the assertion fails.
 * @see expectsException
 * @sample io.github.ccjhr.samples.throwable.hasMessage
 */
inline infix fun <reified T: Throwable?> AssertionContext<T>.hasMessage(message: String) {
    expectNotNull(this.content)

    if (this.content.message != message) {
        fail("Expecting <${this.content.message}> to be equal to <$message>, but it's not.")
    }
}