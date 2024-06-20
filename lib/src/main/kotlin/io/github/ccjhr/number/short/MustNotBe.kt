package io.github.ccjhr.number.short

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.NumberAssertionAdjectives
import io.github.ccjhr.number.NumberAssertionAdjectives.*
import kotlin.test.fail

/**
 * Verifies that the [Short] under test does not apply to a given [NumberAssertionAdjectives].
 * @since 4.0.0
 * @param adjective The [NumberAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Short].
 * @see mustBe
 * @sample io.github.ccjhr.samples.number.short.mustNotBeOdd
 * @sample io.github.ccjhr.samples.number.short.mustNotBeEven
 * @sample io.github.ccjhr.samples.number.short.mustNotBePositive
 * @sample io.github.ccjhr.samples.number.short.mustNotBeNegative
 */
inline infix fun <reified T : Short?> AssertionContext<T>.mustNotBe(adjective: NumberAssertionAdjectives) {
    expectNotNull(this.content)

    when (adjective) {
        Odd -> if (this.content.mod(2.toShort()) != 0.toShort()) fail("Expecting <${this.content}> not to be odd, but it is.")
        Even -> if (this.content.mod(2.toShort()) == 0.toShort()) fail("Expecting <${this.content}> not to be even, but it is.")
        Positive -> if (this.content > 0.toShort()) fail("Expecting <${this.content}> not to be positive, but it is.")
        Negative -> if (this.content < 0.toShort()) fail("Expecting <${this.content}> not to be negative, but it is.")
    }
}