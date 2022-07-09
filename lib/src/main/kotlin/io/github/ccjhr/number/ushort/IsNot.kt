package io.github.ccjhr.number.ushort

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.UnsignedNumberAssertionAdjectives
import io.github.ccjhr.number.UnsignedNumberAssertionAdjectives.Even
import io.github.ccjhr.number.UnsignedNumberAssertionAdjectives.Odd
import kotlin.test.fail

/**
 * Verifies that the [UShort] under test does not apply to a given [UnsignedNumberAssertionAdjectives].
 * @since 2.0.0
 * @param adjective The [UnsignedNumberAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [UShort].
 * @see is
 * @sample io.github.ccjhr.samples.number.ushort.isNotOdd
 * @sample io.github.ccjhr.samples.number.ushort.isNotEven
 */
inline infix fun <reified T : UShort?> AssertionContext<T>.isNot(adjective: UnsignedNumberAssertionAdjectives) {
    expectNotNull(this.content)

    when (adjective) {
        Odd -> if (this.content.mod(2.toUShort()) != 0.toUShort()) fail("Expecting <${this.content}> not to be odd, but it is.")
        Even -> if (this.content.mod(2.toUShort()) == 0.toUShort()) fail("Expecting <${this.content}> not to be even, but it is.")
    }
}