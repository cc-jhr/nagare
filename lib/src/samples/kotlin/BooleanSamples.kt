package io.github.ccjhr.samples.charsequence

fun `isTrue`() {
    // given
    val obj = true

    // then
    obj mustSatisfy {
        it `is` true
    }
}

fun `isFalse`() {
    // given
    val obj = false

    // then
    obj mustSatisfy {
        it `is` false
    }
}

fun `isNotTrue`() {
    // given
    val obj = false

    // then
    obj mustSatisfy {
        it isNot true
    }
}

fun `isNotFalse`() {
    // given
    val obj = true

    // then
    obj mustSatisfy {
        it isNot false
    }
}