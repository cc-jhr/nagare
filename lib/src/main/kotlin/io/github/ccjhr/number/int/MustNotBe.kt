package io.github.ccjhr.number.int

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.NumberAssertionAdjectives
import io.github.ccjhr.number.NumberAssertionAdjectives.*
import kotlin.test.fail

/**
 * Verifies that the [Int] under test does not apply to a given [NumberAssertionAdjectives].
 * @since 4.0.0
 * @param adjective The [NumberAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Int].
 * @see mustBe
 * @sample io.github.ccjhr.samples.number.int.mustNotBeOdd
 * @sample io.github.ccjhr.samples.number.int.mustNotBeEven
 * @sample io.github.ccjhr.samples.number.int.mustNotBePositive
 * @sample io.github.ccjhr.samples.number.int.mustNotBeNegative
 */
inline infix fun <reified T : Int?> AssertionContext<T>.mustNotBe(adjective: NumberAssertionAdjectives) {
    expectNotNull(this.content)

    when (adjective) {
        Odd -> if (this.content % 2 != 0) fail("Expecting <${this.content}> not to be odd, but it is.")
        Even -> if (this.content % 2 == 0) fail("Expecting <${this.content}> not to be even, but it is.")
        Positive -> if (this.content > 0) fail("Expecting <${this.content}> not to be positive, but it is.")
        Negative -> if (this.content < 0) fail("Expecting <${this.content}> not to be negative, but it is.")
    }
}