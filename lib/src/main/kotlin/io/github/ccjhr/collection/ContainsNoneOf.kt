package io.github.ccjhr.collection

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Collection] under test doesn't contain any of the given elements.
 * @since 2.0.0
 * @param unexpectedElements A [Collection] containing items which are expected **not** to exist in the [Collection] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Collection] containing any nullable or non-nullable type.
 * @see containsAllOf
 * @sample io.github.ccjhr.samples.collection.containsNoneOf
 */
inline infix fun <reified T> AssertionContext<out Collection<T>?>.containsNoneOf(unexpectedElements: Collection<T>) {
    expectNotNull(this.content)

    val diff = this.content.toSet().intersect(unexpectedElements.toSet())
    if (diff.isNotEmpty()) {
        fail("Expecting <${this.content}> to contain none of the following items <$unexpectedElements>, but these items were found: <$diff>.")
    }
}