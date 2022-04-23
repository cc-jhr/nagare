package io.github.ccjhr.any

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.Null
import kotlin.test.fail

/**
 * Verifies that the object under test does not apply to a given [AnyAssertionAdjective].
 * @since 1.0.0
 * @param adjective The [AnyAssertionAdjective] that does not apply to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable object.
 * @see is
 * @sample io.github.ccjhr.samples.any.isNotNull
 */
inline infix fun <reified T> AssertionContext<T>.isNot(adjective: AnyAssertionAdjective) {
    when(adjective) {
        Null -> if(this.content == null) fail("Expecting object not to be null, but it is.")
    }
}