package io.github.ccjhr.collection

import io.github.ccjhr.charsequence.mustBe
import io.github.ccjhr.charsequence.mustNotBe

/**
 * Adjectives that are expected to apply to a [Collection].
 * @since 2.0.0
 * @see mustBe
 * @see mustNotBe
 */
enum class CollectionAssertionAdjective {
    /**
     * @since 2.0.0
     * @sample io.github.ccjhr.samples.collection.mustBeEmpty
     * @sample io.github.ccjhr.samples.collection.mustNotBeEmpty
     */
    Empty,
}