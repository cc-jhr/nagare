package io.github.ccjhr.any

import io.github.ccjhr.AssertionContext
import kotlin.test.fail

/**
 * Verifies that the object under test is not the exact same instance as a given object.
 * @since 1.0.0
 * @param expectedInstance Object that is not the exact same instance.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable object.
 * @see isSameAs
 * @sample io.github.ccjhr.samples.any.isNotSameAs
 */
inline infix fun <reified T> AssertionContext<T>.isNotSameAs(expectedInstance: Any) {
    requireNotNull(this.content) { "Object for assertion is null." }
    if (this.content === expectedInstance) {
        fail("Expecting <${referenceString(this.content)}> and <${referenceString(expectedInstance)}> to point to different objects, but they don't.")
    }
}