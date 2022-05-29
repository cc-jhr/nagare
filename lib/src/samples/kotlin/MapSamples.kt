package io.github.ccjhr.samples.collection

fun hasSize() {
    // given
    val map = mapOf(
        1 to "Hello",
        2 to "of",
        3 to "words.",
    )

    // when
    map mustSatisfy {
        it hasSize 3
    }
}