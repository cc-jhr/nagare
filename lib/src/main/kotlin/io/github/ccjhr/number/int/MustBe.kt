package io.github.ccjhr.number.int

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.NumberAssertionAdjectives
import io.github.ccjhr.number.NumberAssertionAdjectives.*
import kotlin.test.fail

/**
 * Verifies that the [Int] under test applies to a given [NumberAssertionAdjectives].
 * @since 4.0.0
 * @param adjective The [NumberAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Int].
 * @see mustNotBe
 * @sample io.github.ccjhr.samples.number.int.mustBeOdd
 * @sample io.github.ccjhr.samples.number.int.mustBeEven
 * @sample io.github.ccjhr.samples.number.int.mustBePositive
 * @sample io.github.ccjhr.samples.number.int.mustBeNegative
 */
inline infix fun <reified T: Int?> AssertionContext<T>.mustBe(adjective: NumberAssertionAdjectives) {
    expectNotNull(this.content)

    when(adjective) {
        Odd -> if(this.content % 2 == 0) fail("Expecting <${this.content}> to be odd, but it's even.")
        Even -> if(this.content % 2 != 0) fail("Expecting <${this.content}> to be even, but it's odd.")
        Positive -> if (this.content < 0) fail("Expecting <${this.content}> to be positive, but it's negative.")
        Negative -> if (this.content > 0) fail("Expecting <${this.content}> to be negative, but it's positive.")
    }
}