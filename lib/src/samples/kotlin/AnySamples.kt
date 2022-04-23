package io.github.ccjhr.samples.any

fun `isNull`() {
    // given
    val obj: String? = null

    // when
    obj mustSatisfy {
        it `is` Null
    }
}

fun `isNotNull`() {
    // given
    val obj = "test"

    // when
    obj mustSatisfy {
        it isNot Null
    }
}

fun isOfType() {
    // given
    val obj = 12

    // when
    obj mustSatisfy {
        it isOfType Int::class
    }
}

fun isNotOfType() {
    // given
    val obj = 12

    // when
    obj mustSatisfy {
        it isNotOfType String::class
    }
}

fun isEqualTo() {
    // given
    val obj = 12

    // when
    obj mustSatisfy {
        it isEqualTo 12
    }
}

fun isNotEqualTo() {
    // given
    val obj = 12

    // when
    obj mustSatisfy {
        it isNotEqualTo 13
    }
}

fun isSameAs() {
    // given
    val obj = 12 to "content"

    // when
    obj mustSatisfy {
        it isSameAs obj
    }
}

fun isNotSameAs() {
    // given
    val obj = 12 to "content"

    // when
    obj mustSatisfy {
        it isNotSameAs 12 to "content"
    }
}