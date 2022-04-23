package io.github.ccjhr.samples.collection

fun contains() {
    // given
    val list = listOf("List", "of", "words.")

    // when
    list mustSatisfy {
        it contains "of"
    }
}

fun notContains() {
    // given
    val list = listOf("List", "of", "words.")

    // when
    list mustSatisfy {
        it notContains "world"
    }
}