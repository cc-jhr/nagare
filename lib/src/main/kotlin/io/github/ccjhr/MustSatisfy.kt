package io.github.ccjhr

/**
 * Entrypoint for tests.
 * @since 1.0.0
 * @param assertion Contains the assertion.
 * @receiver Any nullable or non-nullable object.
 * @see AssertionContext
 */
inline infix fun <reified T> T.mustSatisfy(assertion: (AssertionContext<T>) -> Unit) {
    assertion.invoke(AssertionContext(this))
}