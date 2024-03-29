package io.github.ccjhr.collection

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Collection] under test does not contain a specific element.
 * @since 2.1.0
 * @param obj The element the [Collection] under test is not supposed to contain.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Collection] containing any nullable or non-nullable type.
 * @see contains
 * @sample io.github.ccjhr.samples.collection.doesntContain
 */
inline infix fun <reified T> AssertionContext<out Collection<T>?>.doesntContain(obj: T) {
    expectNotNull(this.content)

    if (this.content.contains(obj)) {
        fail("Expecting <${this.content}> not to contain <$obj>, but it does.")
    }
}