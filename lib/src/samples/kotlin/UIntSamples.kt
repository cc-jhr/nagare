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

private fun mustBeEven() {
    // given
    val obj = 12U

    // then
    obj mustSatisfy {
        it mustBe Even
    }
}

private fun mustNotBeEven() {
    // given
    val obj = 11U

    // then
    obj mustSatisfy {
        it mustNotBe Even
    }
}

private fun mustBeOdd() {
    // given
    val obj = 11U

    // then
    obj mustSatisfy {
        it mustBe Odd
    }
}

private fun mustNotBeOdd() {
    // given
    val obj = 12U

    // then
    obj mustSatisfy {
        it mustNotBe Odd
    }
}

private fun isBetween() {
    // given
    val obj = 12U

    // then
    obj mustSatisfy {
        it isBetween 10U..20U
    }
}