package io.github.ccjhr.any

import io.github.ccjhr.AssertionContext
import kotlin.test.fail

/**
 * Verifies that the object under test is the exact same instance as a given object.
 * @since 1.0.0
 * @param expectedInstance Object that is the expected instance.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable object.
 * @see isNotSameAs
 * @sample io.github.ccjhr.samples.any.isSameAs
 */
inline infix fun <reified T> AssertionContext<T>.isSameAs(expectedInstance: Any) {
    requireNotNull(this.content) { "Object for assertion is null." }
    if (this.content !== expectedInstance) {
        fail("Expecting <${referenceString(this.content)}> and <${referenceString(expectedInstance)}> to point to the same object, but they don't.")
    }
}

fun referenceString(obj: Any) = "${obj::class.qualifiedName}@${System.identityHashCode(obj)}"