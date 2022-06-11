package io.github.ccjhr.number.double

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Double] under test is less than the given value.
 * @since 2.0.0
 * @param obj The value which is supposed the be greater than the [Double] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Double].
 * @see isGreaterThan
 * @sample io.github.ccjhr.samples.number.double.isLessThan
 */
inline infix fun <reified T : Double?> AssertionContext<T>.isLessThan(obj: Double) {
    expectNotNull(this.content)

    if (this.content >= obj) {
        fail("Expecting <${this.content}> to be less than <$obj>, but it's not.")
    }
}