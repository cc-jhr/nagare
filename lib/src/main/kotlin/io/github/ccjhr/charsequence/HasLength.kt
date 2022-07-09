package io.github.ccjhr.charsequence

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [CharSequence] under test has the given length.
 * @since 1.0.0
 * @param expectedLength The length the [CharSequence] under test is supposed to have.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [CharSequence].
 * @sample io.github.ccjhr.samples.charsequence.hasLength
 */
inline infix fun <reified T : CharSequence?> AssertionContext<T>.hasLength(expectedLength: Int) {
    expectNotNull(this.content)

    if (this.content.length != expectedLength) {
        fail("Expecting CharSequence <${this.content}> to be of length <$expectedLength>, but the actual length is <${this.content.length}>")
    }
}