package io.github.ccjhr.samples.string

fun matches() {
    // given
    val obj = "test-string-14"

    // when
    obj mustSatisfy {
        it matches Regex("[a-z]+-string-\\d+")
    }
}

fun notMatches() {
    // given
    val obj = "test"

    // when
    obj mustSatisfy {
        it notMatches Regex("[a-z]+-string-\\d+")
    }
}

fun contains() {
    // given
    val obj = "this is a test"

    // when
    obj mustSatisfy {
        it contains "is a"
    }
}

fun doesntContain() {
    // given
    val obj = "this is a test"

    // when
    obj mustSatisfy {
        it doesntcontain "hello"
    }
}