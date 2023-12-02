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

private fun mustBeEven() {
    // given
    val obj: Short = 12

    // then
    obj mustSatisfy {
        it mustBe Even
    }
}

private fun mustNotBeEven() {
    // given
    val obj: Short = 11

    // then
    obj mustSatisfy {
        it mustNotBe Even
    }
}

private fun mustBeOdd() {
    // given
    val obj: Short = 11

    // then
    obj mustSatisfy {
        it mustBe Odd
    }
}

private fun mustNotBeOdd() {
    // given
    val obj: Short = 12

    // then
    obj mustSatisfy {
        it mustNotBe Odd
    }
}

private fun mustbePositive() {
    // given
    val obj: Short = 12

    // then
    obj mustSatisfy {
        it mustBe Positive
    }
}

private fun mustNotBePositive() {
    // given
    val obj: Short = -12

    // then
    obj mustSatisfy {
        it mustNotBe Positive
    }
}

private fun mustbeNegative() {
    // given
    val obj: Short = -12

    // then
    obj mustSatisfy {
        it mustBe Negative
    }
}

private fun mustNotBeNegative() {
    // given
    val obj: Short = 12

    // then
    obj mustSatisfy {
        it mustNotBe Negative
    }
}

private fun isBetween() {
    // given
    val obj: Short = 12

    // then
    obj mustSatisfy {
        it isBetween 10.toShort()..20.toShort()
    }
}