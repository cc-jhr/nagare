package io.github.ccjhr.number.int

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Int] under test is greater than the given value.
 * @since 1.0.0
 * @param obj The value which is supposed the be less than the [Int] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Int].
 * @see isLessThan
 * @sample io.github.ccjhr.samples.number.int.isGreaterThan
 */
inline infix fun <reified T : Int?> AssertionContext<T>.isGreaterThan(obj: Int) {
    expectNotNull(this.content)

    if (this.content <= obj) {
        fail("Expecting <${this.content}> to be greater than <$obj>, but it's not.")
    }
}