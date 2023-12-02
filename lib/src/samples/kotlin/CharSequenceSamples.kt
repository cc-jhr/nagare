package io.github.ccjhr.samples.charsequence

fun hasLength() {
    // given
    val obj = "test"

    // then
    obj mustSatisfy {
        it hasLength 4
    }
}

fun mustNotBeEmpty() {
    // given
    val obj = "test"

    // then
    obj mustSatisfy {
        it mustNotBe Empty
    }
}

fun mustNotBeBlank() {
    // given
    val obj = "test"

    // then
    obj mustSatisfy {
        it mustNotBe Blank
    }
}

fun mustBeBlank() {
    // given
    val obj = "    "

    // then
    obj mustSatisfy {
        it mustBe Blank
    }
}

fun mustBeEmpty() {
    // given
    val obj = ""

    // then
    obj mustSatisfy {
        it mustBe Empty
    }
}