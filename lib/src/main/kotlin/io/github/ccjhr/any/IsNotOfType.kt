package io.github.ccjhr.any

import io.github.ccjhr.AssertionContext
import kotlin.reflect.KClass
import kotlin.test.fail

/**
 * Verifies that the object under test is not of a given type.
 * @since 1.0.0
 * @param type The type the object under test is not supposed to have.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable object.
 * @see isOfType
 * @sample io.github.ccjhr.samples.any.isNotOfType
 */
inline infix fun <reified T> AssertionContext<T>.isNotOfType(type: KClass<*>) {
    requireNotNull(this.content) { "Object for assertion is null." }
    if (type.isInstance(this.content)) {
        fail("Expecting object not to be of type <${type.qualifiedName}>, but it was.")
    }
}