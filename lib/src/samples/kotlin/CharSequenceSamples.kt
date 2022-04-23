package io.github.ccjhr.samples.charsequence

fun hasLength() {
    // given
    val obj = "test"

    // when
    obj mustSatisfy {
        it hasLength 4
    }
}

fun `isNotEmpty`() {
    // given
    val obj = "test"

    // when
    obj mustSatisfy {
        it isNot Empty
    }
}

fun `isNotBlank`() {
    // given
    val obj = "test"

    // when
    obj mustSatisfy {
        it isNot Blank
    }
}

fun `isBlank`() {
    // given
    val obj = "    "

    // when
    obj mustSatisfy {
        it `is` Blank
    }
}

fun `isEmpty`() {
    // given
    val obj = ""

    // when
    obj mustSatisfy {
        it `is` Empty
    }
}