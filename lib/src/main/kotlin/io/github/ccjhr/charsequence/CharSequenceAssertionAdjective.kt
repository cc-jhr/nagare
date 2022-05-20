package io.github.ccjhr.charsequence

/**
 * Adjectives that may or may not apply to a [CharSequence].
 * @since 1.0.0
 * @see is
 * @see isNot
 */
enum class CharSequenceAssertionAdjective {
    /**
     * A [CharSequence] which is not `null` and has a length of `0`. **example:** `""`
     * @since 1.0.0
     * @sample io.github.ccjhr.samples.charsequence.isEmpty
     */
    Empty,

    /**
     * A [CharSequence] which is not `null` and either has a length of `0` or only contains whitespaces.
     * **example:** `""` or `"   "`
     * @since 1.0.0
     * @sample io.github.ccjhr.samples.charsequence.isBlank
     */
    Blank,
}