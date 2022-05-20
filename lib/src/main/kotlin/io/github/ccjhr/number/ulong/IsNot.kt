package io.github.ccjhr.number.ulong

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.UnsignedNumberAssertionAdjectives
import io.github.ccjhr.number.UnsignedNumberAssertionAdjectives.Even
import io.github.ccjhr.number.UnsignedNumberAssertionAdjectives.Odd
import kotlin.test.fail

/**
 * Verifies that the [ULong] under test does not apply to a given [UnsignedNumberAssertionAdjectives].
 * @since 1.1.0
 * @param adjective The [UnsignedNumberAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [ULong].
 * @see is
 * @sample io.github.ccjhr.samples.number.ulong.isNotOdd
 * @sample io.github.ccjhr.samples.number.ulong.isNotEven
 */
inline infix fun <reified T : ULong?> AssertionContext<T>.isNot(adjective: UnsignedNumberAssertionAdjectives) {
    expectNotNull(this.content)

    when (adjective) {
        Odd -> if (this.content % 2uL != 0uL) fail("Expecting <${this.content}> not to be odd, but it is.")
        Even -> if (this.content % 2uL == 0uL) fail("Expecting <${this.content}> not to be even, but it is.")
    }
}