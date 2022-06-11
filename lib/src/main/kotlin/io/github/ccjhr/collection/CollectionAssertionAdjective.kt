package io.github.ccjhr.collection

import io.github.ccjhr.charsequence.`is`
import io.github.ccjhr.charsequence.isNot

/**
 * Adjectives that are expected to apply to a [Collection].
 * @since 2.0.0
 * @see is
 * @see isNot
 */
enum class CollectionAssertionAdjective {
    /**
     * @since 2.0.0
     * @sample io.github.ccjhr.samples.collection.isEmpty
     * @sample io.github.ccjhr.samples.collection.isNotEmpty
     */
    Empty,
}