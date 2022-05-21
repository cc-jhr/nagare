package io.github.ccjhr.number.short

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.IsBetweenContext
import kotlin.test.fail

/**
 * Verifies that the [Short] under test is between a lower and an upper boundary.
 * To be successful the value must not be equal to the lower or upper boundary.
 * @since 1.1.0
 * @param boundaries Contains the lower and upper boundary.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Short].
 * @sample io.github.ccjhr.samples.number.short.isBetween
 */
inline infix fun <reified T : Short?> AssertionContext<T>.isBetween(boundaries: ClosedRange<Int>) {
    expectNotNull(this.content)

    if (this.content <= boundaries.start || this.content >= boundaries.endInclusive) {
        fail("Expecting <${this.content}> to be greater than <${boundaries.start}> and less than <${boundaries.endInclusive}>")
    }
}