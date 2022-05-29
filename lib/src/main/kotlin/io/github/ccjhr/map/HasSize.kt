package io.github.ccjhr.map

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Map] under test is of given size.
 * @since 1.1.0
 * @param expectedSize Expected size of the [Map] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Map] containing any nullable or non-nullable type for key and value.
 * @sample io.github.ccjhr.samples.map.hasSize
 */
inline infix fun <reified KEY, VALUE> AssertionContext<out Map<KEY, VALUE>?>.hasSize(expectedSize: Int) {
    expectNotNull(this.content)

    if (this.content.size != expectedSize) {
        fail("Expecting Map to be of size <$expectedSize>, but has size <${this.content.size}>.")
    }
}