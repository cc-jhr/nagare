package io.github.ccjhr.number.long

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.NumberAssertionAdjectives
import io.github.ccjhr.number.NumberAssertionAdjectives.*
import kotlin.test.fail

/**
 * Verifies that the [Long] under test does not apply to a given [NumberAssertionAdjectives].
 * @since 4.0.0
 * @param adjective The [NumberAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Long].
 * @see mustBe
 * @sample io.github.ccjhr.samples.number.long.mustNotBeOdd
 * @sample io.github.ccjhr.samples.number.long.mustNotBeEven
 * @sample io.github.ccjhr.samples.number.long.mustNotBePositive
 * @sample io.github.ccjhr.samples.number.long.mustNotBeNegative
 */
inline infix fun <reified T : Long?> AssertionContext<T>.mustNotBe(adjective: NumberAssertionAdjectives) {
    expectNotNull(this.content)

    when (adjective) {
        Odd -> if (this.content % 2L != 0L) fail("Expecting <${this.content}> not to be odd, but it is.")
        Even -> if (this.content % 2L == 0L) fail("Expecting <${this.content}> not to be even, but it is.")
        Positive -> if (this.content > 0L) fail("Expecting <${this.content}> not to be positive, but it is.")
        Negative -> if (this.content < 0L) fail("Expecting <${this.content}> not to be negative, but it is.")
    }
}