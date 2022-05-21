package io.github.ccjhr.samples.number.long

private fun isGreaterThan() {
    // given
    val obj = 12L

    // then
    obj mustSatisfy {
        it isGreaterThan 11L
    }
}

private fun isLessThan() {
    // given
    val obj = 11L

    // then
    obj mustSatisfy {
        it isLessThan 12L
    }
}

private fun isEven() {
    // given
    val obj = 12L

    // then
    obj mustSatisfy {
        it `is` Even
    }
}

private fun isNotEven() {
    // given
    val obj = 11L

    // then
    obj mustSatisfy {
        it isNot Even
    }
}

private fun isOdd() {
    // given
    val obj = 11L

    // then
    obj mustSatisfy {
        it `is` Odd
    }
}

private fun isNotOdd() {
    // given
    val obj = 12L

    // then
    obj mustSatisfy {
        it isNot Odd
    }
}

private fun isPositive() {
    // given
    val obj = 12L

    // then
    obj mustSatisfy {
        it `is` Positive
    }
}

private fun isNotPositive() {
    // given
    val obj = -12L

    // then
    obj mustSatisfy {
        it isNot Positive
    }
}

private fun isNegative() {
    // given
    val obj = -12L

    // then
    obj mustSatisfy {
        it `is` Negative
    }
}

private fun isNotNegative() {
    // given
    val obj = 12L

    // then
    obj mustSatisfy {
        it isNot Negative
    }
}

private fun isBetween() {
    // given
    val obj = 12L

    // then
    obj mustSatisfy {
        it isBetween 10L..20L
    }
}