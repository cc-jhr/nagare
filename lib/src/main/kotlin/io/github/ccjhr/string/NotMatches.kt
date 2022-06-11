package io.github.ccjhr.string

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [String] under test not to match a given [Regex].
 * @since 2.0.0
 * @param regex The [Regex] that the [String] under test is not supposed to match.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [String].
 * @sample io.github.ccjhr.samples.string.notMatches
 * @see matches
 */
inline infix fun <reified T : String?> AssertionContext<T>.notMatches(regex: Regex) {
    expectNotNull(this.content)

    if (this.content.matches(regex)) {
        fail("Expecting <${this.content}> not to match <${regex.pattern}>, but it does.")
    }
}