package io.github.ccjhr.number.uint

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.number.IsBetweenContext
import kotlin.test.fail

/**
 * Verifies that the [UInt] under test is between two values without being equal to a value of the boundaries.
 * To make this actually work chain it with [and].
 * @since 1.1.0
 * @param lowerBoundary The value which is supposed the be less than the [UInt] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [UInt].
 * @see and
 * @sample io.github.ccjhr.samples.number.uint.isBetween
 */
inline infix fun <reified T : UInt?> AssertionContext<T>.isBetween(lowerBoundary: UInt): IsBetweenContext<UInt> {
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
 * @param upperBoundary The value which is supposed the be greater than the [UInt] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [UInt].
 * @see isBetween
 * @sample io.github.ccjhr.samples.number.uint.isBetween
 */
infix fun IsBetweenContext<UInt>.and(upperBoundary: UInt) {
    if (objectUnderTest >= upperBoundary) {
        fail("Value <${objectUnderTest}> violates upper boundary. It must be less than <$upperBoundary>")
    }
}

/**
 * Verifies that the [UInt] under test is between two values without being equal to a value of the boundaries.
 * @since 1.1.0
 * @param range An [UIntRange] defining lower and upper boundary.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [UInt].
 * @sample io.github.ccjhr.samples.number.uint.isBetween
 */
inline infix fun <reified T : UInt?> AssertionContext<T>.isBetween(range: UIntRange) {
    expectNotNull(this.content)

    if (this.content <= range.first || this.content >= range.last) {
        fail("Expecting <${this.content}> to be greater than <${range.first}> and less than <${range.last}>, but it's not.")
    }
}

/**
 * Verifies that the [UInt] under test is between two values without being equal to a value of the boundaries.
 * @since 1.1.0
 * @param range A [Pair] defining lower and upper boundary.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [UInt].
 * @sample io.github.ccjhr.samples.number.uint.isBetween
 */
inline infix fun <reified T : UInt?> AssertionContext<T>.isBetween(range: Pair<UInt, UInt>) {
    expectNotNull(this.content)

    if (this.content <= range.first || this.content >= range.second) {
        fail("Expecting <${this.content}> to be greater than <${range.first}> and less than <${range.second}>, but it's not.")
    }
}