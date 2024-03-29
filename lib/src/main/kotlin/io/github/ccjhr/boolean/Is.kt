package io.github.ccjhr.boolean

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail


/**
 * Verifies that the object under test matches a given [Boolean] value.
 * @since 2.0.0
 * @param value A [Boolean] value that matches the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Boolean].
 * @see isNot
 * @sample io.github.ccjhr.samples.boolean.isTrue
 * @sample io.github.ccjhr.samples.boolean.isFalse
 */
inline infix fun <reified T : Boolean?> AssertionContext<T>.`is`(value: Boolean) {
    expectNotNull(this.content)

    if (this.content != value) {
        fail("Expecting value to be <$value>, but it wasn't.")
    }
}