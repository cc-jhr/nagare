package io.github.ccjhr.number.float

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Float] under test is between a lower and an upper boundary.
 * To be successful the value must not be equal to the lower or upper boundary.
 * @since 1.1.0
 * @param boundaries Contains the lower and upper boundary.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Float].
 * @sample io.github.ccjhr.samples.number.float.isBetween
 */
inline infix fun <reified T : Float?> AssertionContext<T>.isBetween(boundaries: ClosedFloatingPointRange<Float>) {
    expectNotNull(this.content)

    if (this.content <= boundaries.start || this.content >= boundaries.endInclusive) {
        fail("Expecting <${this.content}> to be greater than <${boundaries.start}> and less than <${boundaries.endInclusive}>")
    }
}