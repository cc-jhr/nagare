package io.github.ccjhr.collection

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.collection.CollectionAssertionAdjective.*
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Collection] under test doesn't apply to a given [CollectionAssertionAdjective].
 * @since 2.0.0
 * @param adjective The [CollectionAssertionAdjective] that applies to the [Collection] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Collection] containing any nullable or non-nullable type.
 * @see is
 * @sample io.github.ccjhr.samples.collection.isNotEmpty
 */
inline infix fun <reified T> AssertionContext<out Collection<T>?>.isNot(adjective: CollectionAssertionAdjective) {
    expectNotNull(this.content)

    when (adjective) {
        Empty -> if (this.content.isEmpty()) fail("Expecting Collection not to be <empty>, but it was.")
    }
}