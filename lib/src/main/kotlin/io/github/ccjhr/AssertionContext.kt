package io.github.ccjhr

/**
 * Wrapper for the object under test which is the base for all the extension functions.
 * @since 1.0.0
 * @param content Object under test.
 * @see mustSatisfy
 */
data class AssertionContext<T : Any?>(val content: T)