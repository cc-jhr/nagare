package io.github.ccjhr.any

import io.github.ccjhr.AssertionContext
import kotlin.test.fail

/**
 * Verifies that the object under test is not equal to a given object.
 * @since 1.0.0
 * @param other Object that is not supposed to be equal to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable object.
 * @see isEqualTo
 * @sample io.github.ccjhr.samples.any.isNotEqualTo
 */
inline infix fun <reified T> AssertionContext<T>.isNotEqualTo(other: Any) {
    requireNotNull(this.content) { "Object for assertion is null." }
    if (this.content == other) {
        fail("Expecting objects not to be equal, but they are.")
    }
}