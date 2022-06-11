package io.github.ccjhr.map

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Map] under test doesn't contain a specific key..
 * @since 2.0.0
 * @param key The key the [Map] under test is not supposed to contain.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Map] containing any nullable or non-nullable type for key and value.
 * @see containsKey
 * @sample io.github.ccjhr.samples.map.notContainskey
 */
inline infix fun <reified KEY, VALUE> AssertionContext<out Map<KEY, VALUE>?>.notContainsKey(key: KEY) {
    expectNotNull(this.content)

    if (this.content.containsKey(key)) {
        fail("Expecting Map to not contain key <$key>, but it does.")
    }
}