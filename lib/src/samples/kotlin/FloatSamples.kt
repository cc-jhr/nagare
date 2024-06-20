package io.github.ccjhr.samples.number.float

private fun isGreaterThan() {
    // given
    val obj = 12f

    // then
    obj mustSatisfy {
        it isGreaterThan 11f
    }
}

private fun isLessThan() {
    // given
    val obj = 11f

    // then
    obj mustSatisfy {
        it isLessThan 12f
    }
}

private fun mustBeEven() {
    // given
    val obj = 12f

    // then
    obj mustSatisfy {
        it mustBe Even
    }
}

private fun mustNotBeEven() {
    // given
    val obj = 11f

    // then
    obj mustSatisfy {
        it mustNotBe Even
    }
}

private fun mustBeOdd() {
    // given
    val obj = 11f

    // then
    obj mustSatisfy {
        it mustBe Odd
    }
}

private fun mustNotBeOdd() {
    // given
    val obj = 12f

    // then
    obj mustSatisfy {
        it mustNotBe Odd
    }
}

private fun mustbePositive() {
    // given
    val obj = 12f

    // then
    obj mustSatisfy {
        it mustBe Positive
    }
}

private fun mustNotBePositive() {
    // given
    val obj = -12f

    // then
    obj mustSatisfy {
        it mustNotBe Positive
    }
}

private fun mustbeNegative() {
    // given
    val obj = -12f

    // then
    obj mustSatisfy {
        it mustBe Negative
    }
}

private fun mustNotBeNegative() {
    // given
    val obj = 12f

    // then
    obj mustSatisfy {
        it mustNotBe Negative
    }
}

private fun isBetween() {
    // given
    val obj = 12f

    // then
    obj mustSatisfy {
        it isBetween 10f..20f
    }
}