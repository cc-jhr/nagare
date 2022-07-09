package io.github.ccjhr.map

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Map] under test doesn't contain a specific key.
 * @since 2.1.0
 * @param key The key the [Map] under test is not supposed to contain.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Map] containing any nullable or non-nullable type for key and value.
 * @see containsKey
 * @sample io.github.ccjhr.samples.map.doesntContainKey
 */
inline infix fun <reified KEY, VALUE> AssertionContext<out Map<KEY, VALUE>?>.doesntContainKey(key: KEY) {
    expectNotNull(this.content)

    if (this.content.containsKey(key)) {
        fail("Expecting Map not to contain key <$key>, but it does.")
    }
}