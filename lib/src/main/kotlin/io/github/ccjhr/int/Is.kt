package io.github.ccjhr.int

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.int.IntAssertionAdjectives.Even
import io.github.ccjhr.int.IntAssertionAdjectives.Odd
import kotlin.test.fail

/**
 * Verifies that the [Int] under test applies to a given [AnyAssertionAdjective].
 * @since 1.1.0
 * @param adjective The [IntAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable object.
 * @see isNot
 * @sample io.github.ccjhr.samples.int.isOdd
 * @sample io.github.ccjhr.samples.int.isEven
 */
inline infix fun <reified T: Int?> AssertionContext<T>.`is`(adjective: IntAssertionAdjectives) {
    requireNotNull(this.content) { "Object for assertion is null." }
    when(adjective) {
        Odd -> if(this.content % 2 == 0) fail("Expecting <${this.content}> to be odd, but it's even.")
        Even -> if(this.content % 2 != 0) fail("Expecting <${this.content}> to be even, but it's odd.")
    }
}