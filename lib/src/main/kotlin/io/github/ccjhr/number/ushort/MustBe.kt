package io.github.ccjhr.number.ushort

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.UnsignedNumberAssertionAdjectives
import io.github.ccjhr.number.UnsignedNumberAssertionAdjectives.Even
import io.github.ccjhr.number.UnsignedNumberAssertionAdjectives.Odd
import kotlin.test.fail

/**
 * Verifies that the [UShort] under test applies to a given [UnsignedNumberAssertionAdjectives].
 * @since 4.0.0
 * @param adjective The [UnsignedNumberAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [UShort].
 * @see mustNotBe
 * @sample io.github.ccjhr.samples.number.ushort.mustBeOdd
 * @sample io.github.ccjhr.samples.number.ushort.mustBeEven
 */
inline infix fun <reified T : UShort?> AssertionContext<T>.mustBe(adjective: UnsignedNumberAssertionAdjectives) {
    expectNotNull(this.content)

    when (adjective) {
        Odd -> if (this.content.mod(2.toUShort()) == 0.toUShort()) fail("Expecting <${this.content}> to be odd, but it's even.")
        Even -> if (this.content.mod(2.toUShort()) != 0.toUShort()) fail("Expecting <${this.content}> to be even, but it's odd.")
    }
}