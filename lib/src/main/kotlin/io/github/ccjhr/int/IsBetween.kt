package io.github.ccjhr.int

import io.github.ccjhr.AssertionContext
import kotlin.test.fail

/**
 * Verifies that the [Int] under test is between two values without being equal to a value of the boundaries.
 * To make this actually work chain it with [and].
 * @since 1.1.0
 * @param lowerBoundary The value which is supposed the be less than the [Int] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Int].
 * @see and
 * @sample io.github.ccjhr.samples.int.isBetween
 */
inline infix fun <reified T: Int?> AssertionContext<T>.isBetween(lowerBoundary: Int): IsBetweenContext {
    requireNotNull(this.content) { "Object for assertion is null." }

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
 * @param upperBoundary The value which is supposed the be greater than the [Int] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Int].
 * @see isBetween
 * @sample io.github.ccjhr.samples.int.isBetween
 */
infix fun IsBetweenContext.and(upperBoundary: Int) {
    if (objectUnderTest >= upperBoundary) {
        fail("Value <${objectUnderTest}> violates upper boundary. It must be less than <$upperBoundary>")
    }
}

/**
 * @since 1.1.0
 */
@JvmInline
value class IsBetweenContext(
    val objectUnderTest: Int,
)

/**
 * Verifies that the [Int] under test is between two values without being equal to a value of the boundaries.
 * @since 1.1.0
 * @param range An [IntRange] defining lower and upper boundary.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Int].
 * @sample io.github.ccjhr.samples.int.isBetween
 */
inline infix fun <reified T : Int?> AssertionContext<T>.isBetween(range: IntRange) {
    requireNotNull(this.content) { "Object for assertion is null." }
    if (this.content <= range.first || this.content >= range.last) {
        fail("Expecting <${this.content}> to be greater than <${range.first}> and less than <${range.last}>, but it's not.")
    }
}

/**
 * Verifies that the [Int] under test is between two values without being equal to a value of the boundaries.
 * @since 1.1.0
 * @param range A [Pair] defining lower and upper boundary.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Int].
 * @sample io.github.ccjhr.samples.int.isBetween
 */
inline infix fun <reified T : Int?> AssertionContext<T>.isBetween(range: Pair<Int, Int>) {
    requireNotNull(this.content) { "Object for assertion is null." }
    if (this.content <= range.first || this.content >= range.second) {
        fail("Expecting <${this.content}> to be greater than <${range.first}> and less than <${range.second}>, but it's not.")
    }
}