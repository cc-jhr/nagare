package io.github.ccjhr.int

import io.github.ccjhr.AssertionContext
import kotlin.test.fail

/**
 * Verifies that the [Int] under test is greater than the given value.
 * @since 1.0.0
 * @param obj The value which is supposed the be less than the [Int] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Int].
 * @see isLessThan
 * @sample io.github.ccjhr.samples.int.isGreaterThan
 */
inline infix fun <reified T : Int?> AssertionContext<T>.isGreaterThan(obj: Int) {
    requireNotNull(this.content) { "Object for assertion is null." }
    if (this.content <= obj) {
        fail("Expecting <${this.content}> to be greater than <$obj>, but it's not.")
    }
}