package io.github.ccjhr.collection

import io.github.ccjhr.AssertionContext
import kotlin.test.fail

/**
 * Verifies that the [Collection] under test does not contain a specific element.
 * @since 1.0.0
 * @param obj The element the [Collection] under test is not supposed to contain.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Collection] containing any nullable or non-nullable type.
 * @see contains
 * @sample io.github.ccjhr.samples.collection.notContains
 */
inline infix fun <reified T> AssertionContext<out Collection<T>?>.notContains(obj: T) {
    requireNotNull(this.content) { "Object for assertion is null." }
    if (this.content.contains(obj)) {
        fail("Expecting <${this.content}> to not contain <$obj>, but it does.")
    }
}