package io.github.ccjhr

import kotlin.annotation.AnnotationRetention.BINARY
import kotlin.annotation.AnnotationTarget.*

/**
 * Indicates that the target is experimental. This means that both signature and implementation can change or the target
 * it can be removed completely. Changes on the target don't have an effect on the major version.
 * @since 2.0.0
 */
@RequiresOptIn(level = RequiresOptIn.Level.ERROR)
@Retention(BINARY)
@Target(
    CLASS,
    ANNOTATION_CLASS,
    PROPERTY,
    FIELD,
    LOCAL_VARIABLE,
    VALUE_PARAMETER,
    CONSTRUCTOR,
    FUNCTION,
    PROPERTY_GETTER,
    PROPERTY_SETTER,
    TYPEALIAS,
)
annotation class Experimental
