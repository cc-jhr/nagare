package io.github.ccjhr.string

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [String] under test doesn't contain a given substring.
 * @since 3.0.0
 * @param value The substring that the [String] under test is not supposed to contain.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [String].
 * @sample io.github.ccjhr.samples.string.doesntContain
 * @see contains
 */
inline infix fun <reified T : String?> AssertionContext<T>.doesntContain(value: String) {
    expectNotNull(this.content)

    if (this.content.contains(value)) {
        fail("Expecting <${this.content}> not to contain <${value}>, but it does.")
    }
}