package io.github.ccjhr.number

/**
 * Adjectives that are expected to apply to any signed number.
 * @since 1.1.0
 * @see io.github.ccjhr.number.double.is
 * @see io.github.ccjhr.number.double.isNot
 * @see io.github.ccjhr.number.float.is
 * @see io.github.ccjhr.number.float.isNot
 * @see io.github.ccjhr.number.int.is
 * @see io.github.ccjhr.number.int.isNot
 * @see io.github.ccjhr.number.long.is
 * @see io.github.ccjhr.number.long.isNot
 * @see io.github.ccjhr.number.short.is
 * @see io.github.ccjhr.number.short.isNot
 */
enum class NumberAssertionAdjectives {
    /**
     * @since 1.0.0
     * @sample io.github.ccjhr.samples.number.double.isOdd
     * @sample io.github.ccjhr.samples.number.double.isNotOdd
     * @sample io.github.ccjhr.samples.number.float.isOdd
     * @sample io.github.ccjhr.samples.number.float.isNotOdd
     * @sample io.github.ccjhr.samples.number.int.isOdd
     * @sample io.github.ccjhr.samples.number.int.isNotOdd
     * @sample io.github.ccjhr.samples.number.long.isOdd
     * @sample io.github.ccjhr.samples.number.long.isNotOdd
     * @sample io.github.ccjhr.samples.number.short.isOdd
     * @sample io.github.ccjhr.samples.number.short.isNotOdd
     */
    Odd,

    /**
     * @since 1.0.0
     * @sample io.github.ccjhr.samples.number.double.isEven
     * @sample io.github.ccjhr.samples.number.double.isNotEven
     * @sample io.github.ccjhr.samples.number.float.isEven
     * @sample io.github.ccjhr.samples.number.float.isNotEven
     * @sample io.github.ccjhr.samples.number.int.isEven
     * @sample io.github.ccjhr.samples.number.int.isNotEven
     * @sample io.github.ccjhr.samples.number.long.isEven
     * @sample io.github.ccjhr.samples.number.long.isNotEven
     * @sample io.github.ccjhr.samples.number.short.isEven
     * @sample io.github.ccjhr.samples.number.short.isNotEven
     */
    Even,

    /**
     * @since 1.1.0
     * @sample io.github.ccjhr.samples.number.double.isPositive
     * @sample io.github.ccjhr.samples.number.double.isNotPositive
     * @sample io.github.ccjhr.samples.number.float.isPositive
     * @sample io.github.ccjhr.samples.number.float.isNotPositive
     * @sample io.github.ccjhr.samples.number.int.isPositive
     * @sample io.github.ccjhr.samples.number.int.isNotPositive
     * @sample io.github.ccjhr.samples.number.long.isPositive
     * @sample io.github.ccjhr.samples.number.long.isNotPositive
     * @sample io.github.ccjhr.samples.number.short.isPositive
     * @sample io.github.ccjhr.samples.number.short.isNotPositive
     */
    Positive,

    /**
     * @since 1.1.0
     * @sample io.github.ccjhr.samples.number.double.isNegative
     * @sample io.github.ccjhr.samples.number.double.isNotNegative
     * @sample io.github.ccjhr.samples.number.float.isNegative
     * @sample io.github.ccjhr.samples.number.float.isNotNegative
     * @sample io.github.ccjhr.samples.number.int.isNegative
     * @sample io.github.ccjhr.samples.number.int.isNotNegative
     * @sample io.github.ccjhr.samples.number.long.isNegative
     * @sample io.github.ccjhr.samples.number.long.isNotNegative
     * @sample io.github.ccjhr.samples.number.short.isNegative
     * @sample io.github.ccjhr.samples.number.short.isNotNegative
     */
    Negative,
}