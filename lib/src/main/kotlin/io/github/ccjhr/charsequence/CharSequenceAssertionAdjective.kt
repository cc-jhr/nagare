package io.github.ccjhr.charsequence

/**
 * Adjectives that may or may not apply to a [CharSequence].
 * @since 1.0.0
 * @see is
 * @see isNot
 * @sample io.github.ccjhr.samples.charsequence.isBlank
 * @sample io.github.ccjhr.samples.charsequence.isEmpty
 */
enum class CharSequenceAssertionAdjective {
    /**
     * A [CharSequence] which is not `null` and has a length of `0`. **example:** `""`
     * @since 1.0.0
     */
    Empty,

    /**
     * A [CharSequence] which is not `null` and either has a length of `0` or only contains whitespaces.
     * **example:** `""` or `"   "`
     * @since 1.0.0
     */
    Blank,
}