package io.github.ccjhr.collection

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.charsequence.mustNotBe
import io.github.ccjhr.collection.CollectionAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Collection] under test applies to a given [CollectionAssertionAdjective].
 * @since 4.0.0
 * @param adjective The [CollectionAssertionAdjective] that applies to the [Collection] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Collection] containing any nullable or non-nullable type.
 * @see mustNotBe
 * @sample io.github.ccjhr.samples.collection.mustBeEmpty
 */
inline infix fun <reified T> AssertionContext<out Collection<T>?>.mustBe(adjective: CollectionAssertionAdjective) {
    expectNotNull(this.content)

    when (adjective) {
        Empty -> if (this.content.isNotEmpty()) fail("Expecting Collection to be <empty>, but it was not.")
    }
}