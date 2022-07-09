package io.github.ccjhr.string

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [String] under test contains a given substring.
 * @since 3.0.0
 * @param value The substring that the [String] under test is supposed to contain.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [String].
 * @sample io.github.ccjhr.samples.string.contains
 * @see doesntContain
 */
inline infix fun <reified T : String?> AssertionContext<T>.contains(value: String) {
    expectNotNull(this.content)

    if (!this.content.contains(value)) {
        fail("Expecting <${this.content}> to contain <${value}>, but it doesn't.")
    }
}