package io.github.ccjhr.map

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.DeprecationLevel.WARNING
import kotlin.test.fail

@Deprecated(
    message = "Will be removed in future versions.",
    replaceWith = ReplaceWith(
        expression = "doesntContain",
        imports = ["io.github.ccjhr.map.doesntContain"],
    ),
    level = WARNING,
)
inline infix fun <reified KEY, VALUE> AssertionContext<out Map<KEY, VALUE>?>.notContains(entry: Pair<KEY, VALUE>) = doesntContain(entry)

/**
 * Verifies that the [Map] under test doesn't contain a specific element.
 * @since 3.0.0
 * @param entry The element the [Map] under test is not supposed to contain.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Map] containing any nullable or non-nullable type for key and value.
 * @see contains
 * @sample io.github.ccjhr.samples.map.doesntContain
 */
inline infix fun <reified KEY, VALUE> AssertionContext<out Map<KEY, VALUE>?>.doesntContain(entry: Pair<KEY, VALUE>) {
    expectNotNull(this.content)

    if (this.content[entry.first] == entry.second) {
        fail("Expecting Map to not contain <$entry>, but it does.")
    }
}