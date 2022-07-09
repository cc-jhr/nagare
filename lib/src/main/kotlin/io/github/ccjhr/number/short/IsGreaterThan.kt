package io.github.ccjhr.number.short

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Short] under test is greater than the given value.
 * @since 2.0.0
 * @param obj The value which is supposed the be less than the [Short] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Short].
 * @see isLessThan
 * @sample io.github.ccjhr.samples.number.short.isGreaterThan
 */
inline infix fun <reified T : Short?> AssertionContext<T>.isGreaterThan(obj: Short) {
    expectNotNull(this.content)

    if (this.content <= obj) {
        fail("Expecting <${this.content}> to be greater than <$obj>, but it's not.")
    }
}