package io.github.ccjhr.samples.number.short

private fun isGreaterThan() {
    // given
    val obj: Short = 12

    // then
    obj mustSatisfy {
        it isGreaterThan 11.toShort()
    }
}

private fun isLessThan() {
    // given
    val obj: Short = 11

    // then
    obj mustSatisfy {
        it isLessThan 12.toShort()
    }
}

private fun isEven() {
    // given
    val obj: Short = 12

    // then
    obj mustSatisfy {
        it `is` Even
    }
}

private fun isNotEven() {
    // given
    val obj: Short = 11

    // then
    obj mustSatisfy {
        it isNot Even
    }
}

private fun isOdd() {
    // given
    val obj: Short = 11

    // then
    obj mustSatisfy {
        it `is` Odd
    }
}

private fun isNotOdd() {
    // given
    val obj: Short = 12

    // then
    obj mustSatisfy {
        it isNot Odd
    }
}

private fun isPositive() {
    // given
    val obj: Short = 12

    // then
    obj mustSatisfy {
        it `is` Positive
    }
}

private fun isNotPositive() {
    // given
    val obj: Short = -12

    // then
    obj mustSatisfy {
        it isNot Positive
    }
}

private fun isNegative() {
    // given
    val obj: Short = -12

    // then
    obj mustSatisfy {
        it `is` Negative
    }
}

private fun isNotNegative() {
    // given
    val obj: Short = 12

    // then
    obj mustSatisfy {
        it isNot Negative
    }
}

private fun isBetween() {
    // given
    val obj: Short = 12

    // then
    obj mustSatisfy {
        it isBetween 10.toShort() and 20.toShort()
        it isBetween 10.toShort()..20.toShort()
        it isBetween (10.toShort() to 20.toShort())
    }
}