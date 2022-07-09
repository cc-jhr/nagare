package io.github.ccjhr.collection

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Collection] under test contains all of the given items. It is valid that the [Collection] under
 * can contain even more items which are not part of [expectedElements].
 * @since 2.0.0
 * @param expectedElements A [Collection] containing items which are expected to exist in the [Collection] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Collection] containing any nullable or non-nullable type.
 * @see containsNoneOf
 * @sample io.github.ccjhr.samples.collection.containsAllOf
 */
inline infix fun <reified T> AssertionContext<out Collection<T>?>.containsAllOf(expectedElements: Collection<T>) {
    expectNotNull(this.content)

    val diff = expectedElements.toSet() - this.content.toSet()
    if (diff.isNotEmpty()) {
        fail("Expecting <${this.content}> to contain all items of <$expectedElements>, but it it doesn't contain <$diff>.")
    }
}