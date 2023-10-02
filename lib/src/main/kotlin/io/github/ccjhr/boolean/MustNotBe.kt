package io.github.ccjhr.boolean

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the object under test doesn't match a given [Boolean] value.
 * @since 4.0.0
 * @param value A [Boolean] value that doesn't match the object under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Boolean].
 * @see mustBe
 * @sample io.github.ccjhr.samples.boolean.mustNotBeTrue
 * @sample io.github.ccjhr.samples.boolean.mustNotBeFalse
 */
inline infix fun <reified T : Boolean?> AssertionContext<T>.mustNotBe(value: Boolean) {
    expectNotNull(this.content)

    if (this.content == value) {
        fail("Expecting value not to be <$value>, but it was.")
    }
}