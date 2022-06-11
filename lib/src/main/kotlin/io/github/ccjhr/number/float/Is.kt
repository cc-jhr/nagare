package io.github.ccjhr.number.float

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.NumberAssertionAdjectives
import io.github.ccjhr.number.NumberAssertionAdjectives.*
import kotlin.test.fail

/**
 * Verifies that the [Float] under test applies to a given [NumberAssertionAdjectives].
 * @since 2.0.0
 * @param adjective The [NumberAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Float].
 * @see isNot
 * @sample io.github.ccjhr.samples.number.float.isOdd
 * @sample io.github.ccjhr.samples.number.float.isEven
 * @sample io.github.ccjhr.samples.number.float.isPositive
 * @sample io.github.ccjhr.samples.number.float.isNegative
 */
inline infix fun <reified T : Float?> AssertionContext<T>.`is`(adjective: NumberAssertionAdjectives) {
    expectNotNull(this.content)

    when (adjective) {
        Odd -> if (this.content % 2f == 0f) fail("Expecting <${this.content}> to be odd, but it's even.")
        Even -> if (this.content % 2f != 0f) fail("Expecting <${this.content}> to be even, but it's odd.")
        Positive -> if (this.content < 0f) fail("Expecting <${this.content}> to be positive, but it's negative.")
        Negative -> if (this.content > 0f) fail("Expecting <${this.content}> to be negative, but it's positive.")
    }
}