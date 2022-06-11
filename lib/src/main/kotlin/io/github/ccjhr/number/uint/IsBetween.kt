package io.github.ccjhr.number.uint

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [UInt] under test is between a lower and an upper boundary.
 * To be successful the value must not be equal to the lower or upper boundary.
 * @since 2.0.0
 * @param boundaries Contains the lower and upper boundary.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [UInt].
 * @sample io.github.ccjhr.samples.number.uint.isBetween
 */
inline infix fun <reified T : UInt?> AssertionContext<T>.isBetween(boundaries: ClosedRange<UInt>) {
    expectNotNull(this.content)

    if (this.content <= boundaries.start || this.content >= boundaries.endInclusive) {
        fail("Expecting <${this.content}> to be greater than <${boundaries.start}> and less than <${boundaries.endInclusive}>")
    }
}