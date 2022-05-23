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
        it containsAllOf setOf("of", "words.", "List")
    }
}

fun containsNoneOf() {
    // given
    val list = listOf("List", "of", "words.")

    // when
    list mustSatisfy {
        it containsNoneOf setOf("hello", "world")
    }
}

fun hasSize() {
    // given
    val list = listOf("List", "of", "words.")

    // when
    list mustSatisfy {
        it hasSize 3
    }
}

fun isEmpty() {
    // given
    val list = emptyList<Int>()

    // when
    list mustSatisfy {
        it `is` Empty
    }
}

fun isNotEmpty() {
    // given
    val list = listOf("List", "of", "words.")

    // when
    list mustSatisfy {
        it isNot Empty
    }
}

fun containsExactly() {
    // given
    val list = listOf("List", "of", "words.")

    // when
    list mustSatisfy {
        it containsExactly listOf("of", "words.", "List")
    }
}

fun containsExactlyAndInTheSameOrder() {
    // given
    val list = listOf("List", "of", "words.")

    // when
    list mustSatisfy {
        it containsExactly listOf("List", "of", "words.") and InTheSameOrder
    }
}