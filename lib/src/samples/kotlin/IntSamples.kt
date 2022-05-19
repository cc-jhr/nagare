package io.github.ccjhr.samples.int

private fun isGreaterThan() {
    // given
    val obj = 12

    // then
    obj mustSatisfy {
        it isGreaterThan 11
    }
}

private fun isLessThan() {
    // given
    val obj = 11

    // then
    obj mustSatisfy {
        it isLessThan 12
    }
}

private fun isEven() {
    // given
    val obj = 12

    // then
    obj mustSatisfy {
        it `is` Even
    }
}

private fun isOdd() {
    // given
    val obj = 11

    // then
    obj mustSatisfy {
        it `is` Odd
    }
}

private fun isNotEven() {
    // given
    val obj = 11

    // then
    obj mustSatisfy {
        it isNot Even
    }
}

private fun isNotOdd() {
    // given
    val obj = 12

    // then
    obj mustSatisfy {
        it isNot Odd
    }
}

private fun isBetween() {
    // given
    val obj = 12

    // then
    obj mustSatisfy {
        it isBetween 10 and 20
    }
}