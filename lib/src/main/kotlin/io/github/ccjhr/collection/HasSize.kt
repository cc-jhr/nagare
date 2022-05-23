package io.github.ccjhr.collection

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Collection] under test is of given size.
 * @since 1.1.0
 * @param expectedSize The element the [Collection] under test is supposed to contain.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Collection] containing any nullable or non-nullable type.
 * @sample io.github.ccjhr.samples.collection.hasSize
 */
inline infix fun <reified T> AssertionContext<out Collection<T>?>.hasSize(expectedSize: Int) {
    expectNotNull(this.content)

    if (this.content.size != expectedSize) {
        fail("Expecting Collection to be of size <$expectedSize>, but has size <${this.content.size}>.")
    }
}