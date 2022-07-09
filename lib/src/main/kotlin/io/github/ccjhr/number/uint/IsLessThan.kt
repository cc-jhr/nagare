package io.github.ccjhr.number.uint

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [UInt] under test is less than the given value.
 * @since 2.0.0
 * @param obj The value which is supposed the be greater than the [UInt] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [UInt].
 * @see isGreaterThan
 * @sample io.github.ccjhr.samples.number.uint.isLessThan
 */
inline infix fun <reified T : UInt?> AssertionContext<T>.isLessThan(obj: UInt) {
    expectNotNull(this.content)

    if (this.content >= obj) {
        fail("Expecting <${this.content}> to be less than <$obj>, but it's not.")
    }
}