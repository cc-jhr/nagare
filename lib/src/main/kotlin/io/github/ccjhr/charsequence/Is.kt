package io.github.ccjhr.charsequence

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.charsequence.CharSequenceAssertionAdjective.Blank
import io.github.ccjhr.charsequence.CharSequenceAssertionAdjective.Empty
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [CharSequence] under test applies to a given [CharSequenceAssertionAdjective].
 * @since 1.0.0
 * @param adjective The [CharSequenceAssertionAdjective] that applies to the [CharSequence] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [CharSequence].
 * @see isNot
 * @sample io.github.ccjhr.samples.charsequence.isBlank
 * @sample io.github.ccjhr.samples.charsequence.isEmpty
 */
inline infix fun <reified T : CharSequence?> AssertionContext<T>.`is`(adjective: CharSequenceAssertionAdjective) {
    expectNotNull(this.content)

    when (adjective) {
        Blank -> if (this.content.isNotBlank()) fail("Expecting CharSequence to be <blank>, but it was not.")
        Empty -> if (this.content.isNotEmpty()) fail("Expecting CharSequence to be <empty>, but it was not.")
    }
}