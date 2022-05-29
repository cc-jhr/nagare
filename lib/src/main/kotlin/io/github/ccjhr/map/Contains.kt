package io.github.ccjhr.map

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Map] under test contains a specific element.
 * @since 1.1.0
 * @param entry The element the [Map] under test is supposed to contain.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Map] containing any nullable or non-nullable type for key and value.
 * @see notContains
 * @sample io.github.ccjhr.samples.map.contains
 */
inline infix fun <reified KEY, VALUE> AssertionContext<out Map<KEY, VALUE>?>.contains(entry: Pair<KEY, VALUE>) {
    expectNotNull(this.content)

    if (this.content[entry.first] != entry.second) {
        fail("Expecting Map to contain <$entry>, but it doesn't.")
    }
}