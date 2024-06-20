package io.github.ccjhr.samples.boolean

fun mustBeTrue() {
    // given
    val obj = true

    // then
    obj mustSatisfy {
        it mustBe true
    }
}

fun mustBeFalse() {
    // given
    val obj = false

    // then
    obj mustSatisfy {
        it mustBe false
    }
}

fun mustNotBeTrue() {
    // given
    val obj = false

    // then
    obj mustSatisfy {
        it mustNotBe true
    }
}

fun mustNotBeFalse() {
    // given
    val obj = true

    // then
    obj mustSatisfy {
        it mustNotBe false
    }
}