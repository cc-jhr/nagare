package io.github.ccjhr.any

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the object under test is equal to a given object.
 * @since 1.0.0
 * @param other Object that is supposed to be equal to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable object.
 * @see isNotEqualTo
 * @sample io.github.ccjhr.samples.any.isEqualTo
 */
inline infix fun <reified T> AssertionContext<T>.isEqualTo(other: Any) {
    expectNotNull(this.content)

    if (this.content != other) {
        fail("Expecting <${this.content}> to be equal to <$other>, but it's not.")
    }
}