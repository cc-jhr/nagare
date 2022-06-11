package io.github.ccjhr.number.float

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Float] under test is less than the given value.
 * @since 2.0.0
 * @param obj The value which is supposed the be greater than the [Float] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Float].
 * @see isGreaterThan
 * @sample io.github.ccjhr.samples.number.float.isLessThan
 */
inline infix fun <reified T : Float?> AssertionContext<T>.isLessThan(obj: Float) {
    expectNotNull(this.content)

    if (this.content >= obj) {
        fail("Expecting <${this.content}> to be less than <$obj>, but it's not.")
    }
}