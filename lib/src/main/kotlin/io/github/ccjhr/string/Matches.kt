package io.github.ccjhr.string

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [String] under test matches a given [Regex].
 * @since 2.0.0
 * @param regex The [Regex] that the [String] under test is supposed to match.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [String].
 * @sample io.github.ccjhr.samples.string.matches
 * @see notMatches
 */
inline infix fun <reified T : String?> AssertionContext<T>.matches(regex: Regex) {
    expectNotNull(this.content)

    if (!this.content.matches(regex)) {
        fail("Expecting <${this.content}> to match <${regex.pattern}>, but it doesn't.")
    }
}