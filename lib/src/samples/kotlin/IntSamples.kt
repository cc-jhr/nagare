package io.github.ccjhr.samples.number.int

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

private fun mustBeEven() {
    // given
    val obj = 12

    // then
    obj mustSatisfy {
        it mustBe Even
    }
}

private fun mustNotBeEven() {
    // given
    val obj = 11

    // then
    obj mustSatisfy {
        it mustNotBe Even
    }
}

private fun mustBeOdd() {
    // given
    val obj = 11

    // then
    obj mustSatisfy {
        it mustBe Odd
    }
}

private fun mustNotBeOdd() {
    // given
    val obj = 12

    // then
    obj mustSatisfy {
        it mustNotBe Odd
    }
}

private fun mustbePositive() {
    // given
    val obj = 12

    // then
    obj mustSatisfy {
        it mustBe Positive
    }
}

private fun mustNotBePositive() {
    // given
    val obj = -12

    // then
    obj mustSatisfy {
        it mustNotBe Positive
    }
}

private fun mustbeNegative() {
    // given
    val obj = -12

    // then
    obj mustSatisfy {
        it mustBe Negative
    }
}

private fun mustNotBeNegative() {
    // given
    val obj = 12

    // then
    obj mustSatisfy {
        it mustNotBe Negative
    }
}

private fun isBetween() {
    // given
    val obj = 12

    // then
    obj mustSatisfy {
        it isBetween 10..20
    }
}