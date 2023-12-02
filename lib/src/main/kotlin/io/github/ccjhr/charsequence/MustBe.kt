package io.github.ccjhr.charsequence

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.charsequence.CharSequenceAssertionAdjective.Blank
import io.github.ccjhr.charsequence.CharSequenceAssertionAdjective.Empty
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [CharSequence] under test applies to a given [CharSequenceAssertionAdjective].
 * @since 4.0.0
 * @param adjective The [CharSequenceAssertionAdjective] that applies to the [CharSequence] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [CharSequence].
 * @see mustNotBe
 * @sample io.github.ccjhr.samples.charsequence.mustBeBlank
 * @sample io.github.ccjhr.samples.charsequence.mustBeEmpty
 */
inline infix fun <reified T : CharSequence?> AssertionContext<T>.mustBe(adjective: CharSequenceAssertionAdjective) {
    expectNotNull(this.content)

    when (adjective) {
        Blank -> if (this.content.isNotBlank()) fail("Expecting CharSequence to be <blank>, but it was not.")
        Empty -> if (this.content.isNotEmpty()) fail("Expecting CharSequence to be <empty>, but it was not.")
    }
}