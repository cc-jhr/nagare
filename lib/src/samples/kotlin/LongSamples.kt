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

private fun mustBeEven() {
    // given
    val obj = 12L

    // then
    obj mustSatisfy {
        it mustBe Even
    }
}

private fun mustNotBeEven() {
    // given
    val obj = 11L

    // then
    obj mustSatisfy {
        it mustNotBe Even
    }
}

private fun mustBeOdd() {
    // given
    val obj = 11L

    // then
    obj mustSatisfy {
        it mustBe Odd
    }
}

private fun mustNotBeOdd() {
    // given
    val obj = 12L

    // then
    obj mustSatisfy {
        it mustNotBe Odd
    }
}

private fun mustbePositive() {
    // given
    val obj = 12L

    // then
    obj mustSatisfy {
        it mustBe Positive
    }
}

private fun mustNotBePositive() {
    // given
    val obj = -12L

    // then
    obj mustSatisfy {
        it mustNotBe Positive
    }
}

private fun mustbeNegative() {
    // given
    val obj = -12L

    // then
    obj mustSatisfy {
        it mustBe Negative
    }
}

private fun mustNotBeNegative() {
    // given
    val obj = 12L

    // then
    obj mustSatisfy {
        it mustNotBe Negative
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