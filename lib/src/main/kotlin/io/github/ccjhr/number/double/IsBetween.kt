package io.github.ccjhr.number.double

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.IsBetweenContext
import kotlin.test.fail

/**
 * Verifies that the [Double] under test is between two values without being equal to a value of the boundaries.
 * To make this actually work chain it with [and].
 * @since 1.1.0
 * @param lowerBoundary The value which is supposed the be less than the [Double] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Double].
 * @see and
 * @sample io.github.ccjhr.samples.number.double.isBetween
 */
inline infix fun <reified T : Double?> AssertionContext<T>.isBetween(lowerBoundary: Double): IsBetweenContext<Double> {
    expectNotNull(this.content)

    if (this.content <= lowerBoundary) {
        fail("Value <${this.content}> violates lower boundary. It must be greater than <$lowerBoundary>")
    }

    return IsBetweenContext(
        objectUnderTest = this.content,
    )
}

/**
 * Used in conjunction with [isBetween] to check the upper boundary.
 * @since 1.1.0
 * @param upperBoundary The value which is supposed the be greater than the [Double] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Double].
 * @see isBetween
 * @sample io.github.ccjhr.samples.number.double.isBetween
 */
infix fun IsBetweenContext<Double>.and(upperBoundary: Double) {
    if (objectUnderTest >= upperBoundary) {
        fail("Value <${objectUnderTest}> violates upper boundary. It must be less than <$upperBoundary>")
    }
}

/**
 * Verifies that the [Double] under test is between two values without being equal to a value of the boundaries.
 * @since 1.1.0
 * @param range A [Pair] defining lower and upper boundary.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Double].
 * @sample io.github.ccjhr.samples.number.double.isBetween
 */
inline infix fun <reified T : Double?> AssertionContext<T>.isBetween(range: Pair<Double, Double>) {
    expectNotNull(this.content)

    if (this.content <= range.first || this.content >= range.second) {
        fail("Expecting <${this.content}> to be greater than <${range.first}> and less than <${range.second}>, but it's not.")
    }
}