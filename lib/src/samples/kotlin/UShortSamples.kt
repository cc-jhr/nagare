package io.github.ccjhr.samples.number.ushort

private fun isGreaterThan() {
    // given
    val obj: UShort = 12u

    // then
    obj mustSatisfy {
        it isGreaterThan 11u
    }
}

private fun isLessThan() {
    // given
    val obj: UShort = 11u

    // then
    obj mustSatisfy {
        it isLessThan 12u
    }
}

private fun mustBeEven() {
    // given
    val obj: UShort = 12u

    // then
    obj mustSatisfy {
        it mustBe Even
    }
}

private fun mustNotBeEven() {
    // given
    val obj: UShort = 11u

    // then
    obj mustSatisfy {
        it mustNotBe Even
    }
}

private fun mustBeOdd() {
    // given
    val obj: UShort = 11u

    // then
    obj mustSatisfy {
        it mustBe Odd
    }
}

private fun mustNotBeOdd() {
    // given
    val obj: UShort = 12u

    // then
    obj mustSatisfy {
        it mustNotBe Odd
    }
}

private fun isBetween() {
    // given
    val obj: UShort = 12u

    // then
    obj mustSatisfy {
        it isBetween 10.toUShort()..20.toUShort()
    }
}