package io.github.ccjhr.number.ulong

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [ULong] under test is greater than the given value.
 * @since 2.0.0
 * @param obj The value which is supposed the be less than the [ULong] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [ULong].
 * @see isLessThan
 * @sample io.github.ccjhr.samples.number.ulong.isGreaterThan
 */
inline infix fun <reified T : ULong?> AssertionContext<T>.isGreaterThan(obj: ULong) {
    expectNotNull(this.content)

    if (this.content <= obj) {
        fail("Expecting <${this.content}> to be greater than <$obj>, but it's not.")
    }
}