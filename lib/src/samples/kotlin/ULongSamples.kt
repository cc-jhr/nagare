package io.github.ccjhr.samples.number.ulong

private fun isGreaterThan() {
    // given
    val obj = 12uL

    // then
    obj mustSatisfy {
        it isGreaterThan 11uL
    }
}

private fun isLessThan() {
    // given
    val obj = 11uL

    // then
    obj mustSatisfy {
        it isLessThan 12uL
    }
}

private fun isEven() {
    // given
    val obj = 12uL

    // then
    obj mustSatisfy {
        it `is` Even
    }
}

private fun isNotEven() {
    // given
    val obj = 11uL

    // then
    obj mustSatisfy {
        it isNot Even
    }
}

private fun isOdd() {
    // given
    val obj = 11uL

    // then
    obj mustSatisfy {
        it `is` Odd
    }
}

private fun isNotOdd() {
    // given
    val obj = 12uL

    // then
    obj mustSatisfy {
        it isNot Odd
    }
}

private fun isBetween() {
    // given
    val obj = 12uL

    // then
    obj mustSatisfy {
        it isBetween 10uL..20uL
    }
}