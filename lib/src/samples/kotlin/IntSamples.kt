package io.github.ccjhr.samples.int

private fun isGreaterThan() {
    // given
    val obj = 12

    // when
    obj mustSatisfy {
        it isGreaterThan 11
    }
}

private fun isLessThan() {
    // given
    val obj = 11

    // when
    obj mustSatisfy {
        it isLessThan 12
    }
}

private fun isEven() {
    // given
    val obj = 12

    // when
    obj mustSatisfy {
        it `is` Even
    }
}

private fun isOdd() {
    // given
    val obj = 11

    // when
    obj mustSatisfy {
        it `is` Odd
    }
}

private fun isNotEven() {
    // given
    val obj = 11

    // when
    obj mustSatisfy {
        it isNot Even
    }
}

private fun isNotOdd() {
    // given
    val obj = 12

    // when
    obj mustSatisfy {
        it isNot Odd
    }
}