package io.github.ccjhr.number.long

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Long] under test is between a lower and an upper boundary.
 * To be successful the value must not be equal to the lower or upper boundary.
 * @since 2.0.0
 * @param boundaries Contains the lower and upper boundary.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Long].
 * @sample io.github.ccjhr.samples.number.long.isBetween
 */
inline infix fun <reified T : Long?> AssertionContext<T>.isBetween(boundaries: ClosedRange<Long>) {
    expectNotNull(this.content)

    if (this.content <= boundaries.start || this.content >= boundaries.endInclusive) {
        fail("Expecting <${this.content}> to be greater than <${boundaries.start}> and less than <${boundaries.endInclusive}>")
    }
}