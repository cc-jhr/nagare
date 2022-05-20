package io.github.ccjhr.samples.number.double

private fun isGreaterThan() {
    // given
    val obj = 12.0

    // then
    obj mustSatisfy {
        it isGreaterThan 11.0
    }
}

private fun isLessThan() {
    // given
    val obj = 11.0

    // then
    obj mustSatisfy {
        it isLessThan 12.0
    }
}

private fun isEven() {
    // given
    val obj = 12.0

    // then
    obj mustSatisfy {
        it `is` Even
    }
}

private fun isNotEven() {
    // given
    val obj = 11.0

    // then
    obj mustSatisfy {
        it isNot Even
    }
}

private fun isOdd() {
    // given
    val obj = 11.0

    // then
    obj mustSatisfy {
        it `is` Odd
    }
}

private fun isNotOdd() {
    // given
    val obj = 12.0

    // then
    obj mustSatisfy {
        it isNot Odd
    }
}

private fun isPositive() {
    // given
    val obj = 12.0

    // then
    obj mustSatisfy {
        it `is` Positive
    }
}

private fun isNotPositive() {
    // given
    val obj = -12.0

    // then
    obj mustSatisfy {
        it isNot Positive
    }
}

private fun isNegative() {
    // given
    val obj = -12.0

    // then
    obj mustSatisfy {
        it `is` Negative
    }
}

private fun isNotNegative() {
    // given
    val obj = 12.0

    // then
    obj mustSatisfy {
        it isNot Negative
    }
}

private fun isBetween() {
    // given
    val obj = 12.0

    // then
    obj mustSatisfy {
        it isBetween 10.0 and 20.0
        it isBetween (10.0 to 20.0)
    }
}