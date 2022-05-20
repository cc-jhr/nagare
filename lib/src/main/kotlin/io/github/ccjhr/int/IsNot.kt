package io.github.ccjhr.int

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective
import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.int.IntAssertionAdjectives.Even
import io.github.ccjhr.int.IntAssertionAdjectives.Odd
import kotlin.test.fail

/**
 * Verifies that the [Int] under test does not apply to a given [IntAssertionAdjectives].
 * @since 1.1.0
 * @param adjective The [IntAssertionAdjectives] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Int].
 * @see is
 * @sample io.github.ccjhr.samples.int.isNotOdd
 * @sample io.github.ccjhr.samples.int.isNotEven
 */
inline infix fun <reified T: Int?> AssertionContext<T>.isNot(adjective: IntAssertionAdjectives) {
    expectNotNull(this.content)

    when(adjective) {
        Odd -> if(this.content % 2 != 0) fail("Expecting <${this.content}> not to be odd, but it is.")
        Even -> if(this.content % 2 == 0) fail("Expecting <${this.content}> not to be even, but it is.")
    }
}