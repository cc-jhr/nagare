package io.github.ccjhr.number.double

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Double] under test is greater than the given value.
 * @since 1.1.0
 * @param obj The value which is supposed the be less than the [Double] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Double].
 * @see isLessThan
 * @sample io.github.ccjhr.samples.number.double.isGreaterThan
 */
inline infix fun <reified T : Double?> AssertionContext<T>.isGreaterThan(obj: Double) {
    expectNotNull(this.content)

    if (this.content <= obj) {
        fail("Expecting <${this.content}> to be greater than <$obj>, but it's not.")
    }
}