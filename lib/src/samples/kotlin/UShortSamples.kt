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

private fun isEven() {
    // given
    val obj: UShort = 12u

    // then
    obj mustSatisfy {
        it `is` Even
    }
}

private fun isNotEven() {
    // given
    val obj: UShort = 11u

    // then
    obj mustSatisfy {
        it isNot Even
    }
}

private fun isOdd() {
    // given
    val obj: UShort = 11u

    // then
    obj mustSatisfy {
        it `is` Odd
    }
}

private fun isNotOdd() {
    // given
    val obj: UShort = 12u

    // then
    obj mustSatisfy {
        it isNot Odd
    }
}

private fun isBetween() {
    // given
    val obj: UShort = 12u

    // then
    obj mustSatisfy {
        it isBetween 10.toUShort() and 20.toUShort()
        it isBetween 10.toUShort()..20.toUShort()
        it isBetween (10.toUShort() to 20.toUShort())
    }
}