package io.github.ccjhr.number.short

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.NumberAssertionAdjectives
import io.github.ccjhr.number.NumberAssertionAdjectives.*
import kotlin.test.fail

/**
 * Verifies that the [Short] under test applies to a given [NumberAssertionAdjectives].
 * @since 1.1.0
 * @param adjective The [NumberAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Short].
 * @see isNot
 * @sample io.github.ccjhr.samples.number.short.isOdd
 * @sample io.github.ccjhr.samples.number.short.isEven
 * @sample io.github.ccjhr.samples.number.short.isPositive
 * @sample io.github.ccjhr.samples.number.short.isNegative
 */
inline infix fun <reified T: Short?> AssertionContext<T>.`is`(adjective: NumberAssertionAdjectives) {
    expectNotNull(this.content)

    when(adjective) {
        Odd -> if(this.content.mod(2.toShort()) == 0.toShort()) fail("Expecting <${this.content}> to be odd, but it's even.")
        Even -> if(this.content.mod(2.toShort()) != 0.toShort()) fail("Expecting <${this.content}> to be even, but it's odd.")
        Positive -> if (this.content < 0.toShort()) fail("Expecting <${this.content}> to be positive, but it's negative.")
        Negative -> if (this.content > 0.toShort()) fail("Expecting <${this.content}> to be negative, but it's positive.")
    }
}