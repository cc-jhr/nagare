package io.github.ccjhr.number.uint

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [UInt] under test is greater than the given value.
 * @since 1.1.0
 * @param obj The value which is supposed the be less than the [UInt] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [UInt].
 * @see isLessThan
 * @sample io.github.ccjhr.samples.number.uint.isGreaterThan
 */
inline infix fun <reified T : UInt?> AssertionContext<T>.isGreaterThan(obj: UInt) {
    expectNotNull(this.content)

    if (this.content <= obj) {
        fail("Expecting <${this.content}> to be greater than <$obj>, but it's not.")
    }
}