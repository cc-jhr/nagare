package io.github.ccjhr.samples.collection

fun contains() {
    // given
    val list = listOf("List", "of", "words.")

    // then
    list mustSatisfy {
        it contains "of"
    }
}

fun notContains() {
    // given
    val list = listOf("List", "of", "words.")

    // then
    list mustSatisfy {
        it notContains "world"
    }
}

fun containsAllOf() {
    // given
    val list = listOf("List", "of", "words.")

    // when
    list mustSatisfy {
        it containsAllOf mutableListOf("of", "words.", "List")
    }
}

fun containsNoneOf() {
    // given
    val list = listOf("List", "of", "words.")

    // when
    list mustSatisfy {
        it containsNoneOf mutableListOf("hello", "world")
    }
}