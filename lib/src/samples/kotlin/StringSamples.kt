package io.github.ccjhr.samples.charsequence

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