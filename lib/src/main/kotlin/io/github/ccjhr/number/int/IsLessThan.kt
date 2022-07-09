package io.github.ccjhr.number.int

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Int] under test is less than the given value.
 * @since 1.0.0
 * @param obj The value which is supposed the be greater than the [Int] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Int].
 * @see isGreaterThan
 * @sample io.github.ccjhr.samples.number.int.isLessThan
 */
inline infix fun <reified T : Int?> AssertionContext<T>.isLessThan(obj: Int) {
    expectNotNull(this.content)

    if (this.content >= obj) {
        fail("Expecting <${this.content}> to be less than <$obj>, but it's not.")
    }
}