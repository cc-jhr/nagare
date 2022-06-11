package io.github.ccjhr.number.long

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Long] under test is greater than the given value.
 * @since 2.0.0
 * @param obj The value which is supposed the be less than the [Long] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Long].
 * @see isLessThan
 * @sample io.github.ccjhr.samples.number.long.isGreaterThan
 */
inline infix fun <reified T : Long?> AssertionContext<T>.isGreaterThan(obj: Long) {
    expectNotNull(this.content)

    if (this.content <= obj) {
        fail("Expecting <${this.content}> to be greater than <$obj>, but it's not.")
    }
}