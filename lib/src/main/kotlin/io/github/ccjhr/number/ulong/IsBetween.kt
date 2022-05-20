package io.github.ccjhr.number.ulong

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.IsBetweenContext
import kotlin.test.fail

/**
 * Verifies that the [ULong] under test is between two values without being equal to a value of the boundaries.
 * To make this actually work chain it with [and].
 * @since 1.1.0
 * @param lowerBoundary The value which is supposed the be less than the [ULong] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [ULong].
 * @see and
 * @sample io.github.ccjhr.samples.number.ulong.isBetween
 */
inline infix fun <reified T : ULong?> AssertionContext<T>.isBetween(lowerBoundary: ULong): IsBetweenContext<ULong> {
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
 * @param upperBoundary The value which is supposed the be greater than the [ULong] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [ULong].
 * @see isBetween
 * @sample io.github.ccjhr.samples.number.ulong.isBetween
 */
infix fun IsBetweenContext<ULong>.and(upperBoundary: ULong) {
    if (objectUnderTest >= upperBoundary) {
        fail("Value <${objectUnderTest}> violates upper boundary. It must be less than <$upperBoundary>")
    }
}

/**
 * Verifies that the [ULong] under test is between two values without being equal to a value of the boundaries.
 * @since 1.1.0
 * @param range An [ULongRange] defining lower and upper boundary.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [ULong].
 * @sample io.github.ccjhr.samples.number.ulong.isBetween
 */
inline infix fun <reified T : ULong?> AssertionContext<T>.isBetween(range: ULongRange) {
    expectNotNull(this.content)

    if (this.content <= range.first || this.content >= range.last) {
        fail("Expecting <${this.content}> to be greater than <${range.first}> and less than <${range.last}>, but it's not.")
    }
}

/**
 * Verifies that the [ULong] under test is between two values without being equal to a value of the boundaries.
 * @since 1.1.0
 * @param range A [Pair] defining lower and upper boundary.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [ULong].
 * @sample io.github.ccjhr.samples.number.ulong.isBetween
 */
inline infix fun <reified T : ULong?> AssertionContext<T>.isBetween(range: Pair<ULong, ULong>) {
    expectNotNull(this.content)

    if (this.content <= range.first || this.content >= range.second) {
        fail("Expecting <${this.content}> to be greater than <${range.first}> and less than <${range.second}>, but it's not.")
    }
}