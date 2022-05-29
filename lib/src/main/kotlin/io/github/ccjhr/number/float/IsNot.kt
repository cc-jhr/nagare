package io.github.ccjhr.number.float

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.NumberAssertionAdjectives
import io.github.ccjhr.number.NumberAssertionAdjectives.*
import kotlin.test.fail

/**
 * Verifies that the [Float] under test does not apply to a given [NumberAssertionAdjectives].
 * @since 1.1.0
 * @param adjective The [NumberAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Float].
 * @see is
 * @sample io.github.ccjhr.samples.number.float.isNotOdd
 * @sample io.github.ccjhr.samples.number.float.isNotEven
 * @sample io.github.ccjhr.samples.number.float.isPositive
 * @sample io.github.ccjhr.samples.number.float.isNegative
 */
inline infix fun <reified T : Float?> AssertionContext<T>.isNot(adjective: NumberAssertionAdjectives) {
    expectNotNull(this.content)

    when (adjective) {
        Odd -> if (this.content % 2f != 0f) fail("Expecting <${this.content}> not to be odd, but it is.")
        Even -> if (this.content % 2f == 0f) fail("Expecting <${this.content}> not to be even, but it is.")
        Positive -> if (this.content > 0f) fail("Expecting <${this.content}> not to be positive, but it is.")
        Negative -> if (this.content < 0f) fail("Expecting <${this.content}> not to be negative, but it is.")
    }
}