package io.github.ccjhr.any

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import io.github.ccjhr.instanceString
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
    expectNotNull(this.content)

    if (this.content === expectedInstance) {
        fail("Expecting <${instanceString(this.content)}> and <${instanceString(expectedInstance)}> to point to different objects, but they don't.")
    }
}