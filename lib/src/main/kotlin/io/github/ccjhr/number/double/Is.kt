package io.github.ccjhr.number.double

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.NumberAssertionAdjectives
import io.github.ccjhr.number.NumberAssertionAdjectives.*
import kotlin.test.fail

/**
 * Verifies that the [Double] under test applies to a given [NumberAssertionAdjectives].
 * @since 1.1.0
 * @param adjective The [NumberAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Double].
 * @see isNot
 * @sample io.github.ccjhr.samples.number.double.isOdd
 * @sample io.github.ccjhr.samples.number.double.isEven
 * @sample io.github.ccjhr.samples.number.double.isPositive
 * @sample io.github.ccjhr.samples.number.double.isNegative
 */
inline infix fun <reified T : Double?> AssertionContext<T>.`is`(adjective: NumberAssertionAdjectives) {
    expectNotNull(this.content)

    when (adjective) {
        Odd -> if (this.content % 2.0 == 0.0) fail("Expecting <${this.content}> to be odd, but it's even.")
        Even -> if (this.content % 2.0 != 0.0) fail("Expecting <${this.content}> to be even, but it's odd.")
        Positive -> if (this.content < 0.0) fail("Expecting <${this.content}> to be positive, but it's negative.")
        Negative -> if (this.content > 0.0) fail("Expecting <${this.content}> to be negative, but it's positive.")
    }
}