package io.github.ccjhr.number.ushort

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [UShort] under test is greater than the given value.
 * @since 1.1.0
 * @param obj The value which is supposed the be less than the [UShort] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [UShort].
 * @see isLessThan
 * @sample io.github.ccjhr.samples.number.ushort.isGreaterThan
 */
inline infix fun <reified T : UShort?> AssertionContext<T>.isGreaterThan(obj: UShort) {
    expectNotNull(this.content)

    if (this.content <= obj) {
        fail("Expecting <${this.content}> to be greater than <$obj>, but it's not.")
    }
}