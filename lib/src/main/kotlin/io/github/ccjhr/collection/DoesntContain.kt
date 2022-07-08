package io.github.ccjhr.collection

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.expectNotNull
import kotlin.DeprecationLevel.WARNING
import kotlin.test.fail

@Deprecated(
    message = "Will be removed in future versions.",
    replaceWith = ReplaceWith(
        expression = "doesntContain",
        imports = ["io.github.ccjhr.collection.doesntContain"],
    ),
    level = WARNING,
)
inline infix fun <reified T> AssertionContext<out Collection<T>?>.notContains(obj: T) = doesntContain(obj)

/**
 * Verifies that the [Collection] under test does not contain a specific element.
 * @since 3.0.0
 * @param obj The element the [Collection] under test is not supposed to contain.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable [Collection] containing any nullable or non-nullable type.
 * @see contains
 * @sample io.github.ccjhr.samples.collection.doesntContain
 */
inline infix fun <reified T> AssertionContext<out Collection<T>?>.doesntContain(obj: T) {
    expectNotNull(this.content)

    if (this.content.contains(obj)) {
        fail("Expecting <${this.content}> to not contain <$obj>, but it does.")
    }
}