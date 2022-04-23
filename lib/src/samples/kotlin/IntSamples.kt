package io.github.ccjhr.samples.int

private fun isGreaterThan() {
    // given
    val obj = 12

    // when
    obj mustSatisfy {
        it isGreaterThan 11
    }
}

private fun isLessThan() {
    // given
    val obj = 11

    // when
    obj mustSatisfy {
        it isLessThan 12
    }
}