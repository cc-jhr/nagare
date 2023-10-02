package io.github.ccjhr.samples.any

fun mustBeNull() {
    // given
    val obj: String? = null

    // then
    obj mustSatisfy {
        it mustBe Null
    }
}

fun mustNotBeNull() {
    // given
    val obj = "test"

    // then
    obj mustSatisfy {
        it mustNotBe Null
    }
}

fun isOfType() {
    // given
    val obj = 12

    // then
    obj mustSatisfy {
        it isOfType Int::class
    }
}

fun isNotOfType() {
    // given
    val obj = 12

    // then
    obj mustSatisfy {
        it isNotOfType String::class
    }
}

fun isEqualTo() {
    // given
    val obj = 12

    // then
    obj mustSatisfy {
        it isEqualTo 12
    }
}

fun isNotEqualTo() {
    // given
    val obj = 12

    // then
    obj mustSatisfy {
        it isNotEqualTo 13
    }
}

fun isSameAs() {
    // given
    val obj = 12 to "content"

    // then
    obj mustSatisfy {
        it isSameAs obj
    }
}

fun isNotSameAs() {
    // given
    val obj = 12 to "content"

    // then
    obj mustSatisfy {
        it isNotSameAs 12 to "content"
    }
}