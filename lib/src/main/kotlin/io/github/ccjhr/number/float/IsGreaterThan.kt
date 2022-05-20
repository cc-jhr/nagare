package io.github.ccjhr.number.float

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Float] under test is greater than the given value.
 * @since 1.1.0
 * @param obj The value which is supposed the be less than the [Float] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Float].
 * @see isLessThan
 * @sample io.github.ccjhr.samples.number.float.isGreaterThan
 */
inline infix fun <reified T : Float?> AssertionContext<T>.isGreaterThan(obj: Float) {
    expectNotNull(this.content)

    if (this.content <= obj) {
        fail("Expecting <${this.content}> to be greater than <$obj>, but it's not.")
    }
}