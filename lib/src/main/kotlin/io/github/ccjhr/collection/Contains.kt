package io.github.ccjhr.collection

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Collection] under test contains a specific element.
 * @since 1.0.0
 * @param obj The element the [Collection] under test is supposed to contain.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Collection] containing any nullable or non-nullable type.
 * @see notContains
 * @sample io.github.ccjhr.samples.collection.contains
 */
inline infix fun <reified T> AssertionContext<out Collection<T>?>.contains(obj: T) {
    expectNotNull(this.content)

    if (!this.content.contains(obj)) {
        fail("Expecting <${this.content}> to contain <$obj>, but it doesn't.")
    }
}