package io.github.ccjhr.any

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.any.AnyAssertionAdjective.*
import kotlin.test.fail

/**
 * Verifies that the object under test applies to a given [AnyAssertionAdjective].
 * @since 1.0.0
 * @param adjective The [AnyAssertionAdjective] that applies to the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable object.
 * @see isNot
 * @sample io.github.ccjhr.samples.any.isNull
 */
inline infix fun <reified T> AssertionContext<T>.`is`(adjective: AnyAssertionAdjective) {
    when(adjective) {
        Null -> if(this.content != null) fail("Expecting object to be null, but it's not.")
    }
}