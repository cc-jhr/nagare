package io.github.ccjhr.any

import io.github.ccjhr.AssertionContext
import kotlin.reflect.KClass
import kotlin.test.fail

/**
 * Verifies that the object under test is of a given type.
 * @since 1.0.0
 * @param type The type the object under test is supposed to have.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable object.
 * @see isNotOfType
 * @sample io.github.ccjhr.samples.any.isOfType
 */
inline infix fun <reified T> AssertionContext<T>.isOfType(type: KClass<*>) {
    requireNotNull(this.content) { "Object for assertion is null." }
    if (!type.isInstance(this.content)) {
        fail("Expecting object to be of type <${type.qualifiedName}>, but was <${this.content!!::class.qualifiedName}>.")
    }
}