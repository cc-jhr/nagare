package io.github.ccjhr.samples.map

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

fun contains() {
    // given
    val map = mapOf(
        1 to "Hello",
        2 to "of",
        3 to "words.",
    )

    // when
    map mustSatisfy {
        it contains (2 to "of")
    }
}

fun notContains() {
    // given
    val map = mapOf(
        1 to "Hello",
        2 to "of",
        3 to "words.",
    )

    // when
    map mustSatisfy {
        it notContains (2 to "test")
    }
}

fun containsKey() {
    // given
    val map = mapOf(
        1 to "Hello",
        2 to "of",
        3 to "words.",
    )

    // when
    map mustSatisfy {
        it containsKey 2
    }
}

fun notContainsKey() {
    // given
    val map = mapOf(
        1 to "Hello",
        2 to "of",
        3 to "words.",
    )

    // when
    map mustSatisfy {
        it containsKey 4
    }
}