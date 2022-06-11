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
 * @since 2.0.0
 * @param adjective The [UnsignedNumberAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [UShort].
 * @see isNot
 * @sample io.github.ccjhr.samples.number.ushort.isOdd
 * @sample io.github.ccjhr.samples.number.ushort.isEven
 */
inline infix fun <reified T : UShort?> AssertionContext<T>.`is`(adjective: UnsignedNumberAssertionAdjectives) {
    expectNotNull(this.content)

    when (adjective) {
        Odd -> if (this.content.mod(2.toUShort()) == 0.toUShort()) fail("Expecting <${this.content}> to be odd, but it's even.")
        Even -> if (this.content.mod(2.toUShort()) != 0.toUShort()) fail("Expecting <${this.content}> to be even, but it's odd.")
    }
}