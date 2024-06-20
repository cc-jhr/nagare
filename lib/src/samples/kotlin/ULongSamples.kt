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

private fun mustBeEven() {
    // given
    val obj = 12uL

    // then
    obj mustSatisfy {
        it mustBe Even
    }
}

private fun mustNotBeEven() {
    // given
    val obj = 11uL

    // then
    obj mustSatisfy {
        it mustNotBe Even
    }
}

private fun mustBeOdd() {
    // given
    val obj = 11uL

    // then
    obj mustSatisfy {
        it mustBe Odd
    }
}

private fun mustNotBeOdd() {
    // given
    val obj = 12uL

    // then
    obj mustSatisfy {
        it mustNotBe Odd
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