package io.github.ccjhr.number.uint

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.UnsignedNumberAssertionAdjectives
import io.github.ccjhr.number.UnsignedNumberAssertionAdjectives.*
import kotlin.test.fail

/**
 * Verifies that the [UInt] under test applies to a given [UnsignedNumberAssertionAdjectives].
 * @since 4.0.0
 * @param adjective The [UnsignedNumberAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [UInt].
 * @see mustNotBe
 * @sample io.github.ccjhr.samples.number.uint.mustBeOdd
 * @sample io.github.ccjhr.samples.number.uint.mustBeEven
 */
inline infix fun <reified T : UInt?> AssertionContext<T>.mustBe(adjective: UnsignedNumberAssertionAdjectives) {
    expectNotNull(this.content)

    when (adjective) {
        Odd -> if (this.content % 2U == 0U) fail("Expecting <${this.content}> to be odd, but it's even.")
        Even -> if (this.content % 2U != 0U) fail("Expecting <${this.content}> to be even, but it's odd.")
    }
}