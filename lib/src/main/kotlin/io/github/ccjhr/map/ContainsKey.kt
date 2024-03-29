package io.github.ccjhr.map

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Map] under test contains a specific key.
 * @since 2.0.0
 * @param key The key that the [Map] under test is supposed to contain.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Map] containing any nullable or non-nullable type for key and value.
 * @see doesntContainKey
 * @sample io.github.ccjhr.samples.map.containsKey
 */
inline infix fun <reified KEY, VALUE> AssertionContext<out Map<KEY, VALUE>?>.containsKey(key: KEY) {
    expectNotNull(this.content)

    if (!this.content.containsKey(key)) {
        fail("Expecting Map to contain key <$key>, but it doesn't.")
    }
}