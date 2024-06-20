package io.github.ccjhr.charsequence

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.charsequence.CharSequenceAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [CharSequence] under test does not apply to a given [CharSequenceAssertionAdjective].
 * @since 4.0.0
 * @param adjective The [CharSequenceAssertionAdjective] that does not apply to the [CharSequence] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [CharSequence].
 * @see mustBe
 * @sample io.github.ccjhr.samples.charsequence.mustNotBeBlank
 * @sample io.github.ccjhr.samples.charsequence.mustNotBeEmpty
 */
inline infix fun <reified T : CharSequence?> AssertionContext<T>.mustNotBe(adjective: CharSequenceAssertionAdjective) {
    expectNotNull(this.content)

    when (adjective) {
        Blank -> if (this.content.isBlank()) fail("Expecting CharSequence not to be <blank>, but it was.")
        Empty -> if (this.content.isEmpty()) fail("Expecting CharSequence not to be <empty>, but it was.")
    }
}