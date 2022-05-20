package io.github.ccjhr.samples.number.uint

private fun isGreaterThan() {
    // given
    val obj = 12U

    // then
    obj mustSatisfy {
        it isGreaterThan 11U
    }
}

private fun isLessThan() {
    // given
    val obj = 11U

    // then
    obj mustSatisfy {
        it isLessThan 12U
    }
}

private fun isEven() {
    // given
    val obj = 12U

    // then
    obj mustSatisfy {
        it `is` Even
    }
}

private fun isNotEven() {
    // given
    val obj = 11U

    // then
    obj mustSatisfy {
        it isNot Even
    }
}

private fun isOdd() {
    // given
    val obj = 11U

    // then
    obj mustSatisfy {
        it `is` Odd
    }
}

private fun isNotOdd() {
    // given
    val obj = 12U

    // then
    obj mustSatisfy {
        it isNot Odd
    }
}

private fun isBetween() {
    // given
    val obj = 12U

    // then
    obj mustSatisfy {
        it isBetween 10U and 20U
        it isBetween 10U..20U
        it isBetween (10U to 20U)
    }
}