package io.github.ccjhr.number

/**
 * Adjectives that are expected to apply to any signed number.
 * @since 2.0.0
 * @see io.github.ccjhr.number.double.mustBe
 * @see io.github.ccjhr.number.double.mustNotBe
 * @see io.github.ccjhr.number.float.mustBe
 * @see io.github.ccjhr.number.float.mustNotBe
 * @see io.github.ccjhr.number.int.mustBe
 * @see io.github.ccjhr.number.int.mustNotBe
 * @see io.github.ccjhr.number.long.mustBe
 * @see io.github.ccjhr.number.long.mustNotBe
 * @see io.github.ccjhr.number.short.mustBe
 * @see io.github.ccjhr.number.short.mustNotBe
 */
enum class NumberAssertionAdjectives {
    /**
     * @since 1.0.0
     * @sample io.github.ccjhr.samples.number.double.mustBeOdd
     * @sample io.github.ccjhr.samples.number.double.mustNotBeOdd
     * @sample io.github.ccjhr.samples.number.float.mustBeOdd
     * @sample io.github.ccjhr.samples.number.float.mustNotBeOdd
     * @sample io.github.ccjhr.samples.number.int.mustBeOdd
     * @sample io.github.ccjhr.samples.number.int.mustNotBeOdd
     * @sample io.github.ccjhr.samples.number.long.mustBeOdd
     * @sample io.github.ccjhr.samples.number.long.mustNotBeOdd
     * @sample io.github.ccjhr.samples.number.short.mustBeOdd
     * @sample io.github.ccjhr.samples.number.short.mustNotBeOdd
     */
    Odd,

    /**
     * @since 1.0.0
     * @sample io.github.ccjhr.samples.number.double.mustBeEven
     * @sample io.github.ccjhr.samples.number.double.mustNotBeEven
     * @sample io.github.ccjhr.samples.number.float.mustBeEven
     * @sample io.github.ccjhr.samples.number.float.mustNotBeEven
     * @sample io.github.ccjhr.samples.number.int.mustBeEven
     * @sample io.github.ccjhr.samples.number.int.mustNotBeEven
     * @sample io.github.ccjhr.samples.number.long.mustBeEven
     * @sample io.github.ccjhr.samples.number.long.mustNotBeEven
     * @sample io.github.ccjhr.samples.number.short.mustBeEven
     * @sample io.github.ccjhr.samples.number.short.mustNotBeEven
     */
    Even,

    /**
     * @since 2.0.0
     * @sample io.github.ccjhr.samples.number.double.mustBePositive
     * @sample io.github.ccjhr.samples.number.double.mustNotBePositive
     * @sample io.github.ccjhr.samples.number.float.mustBePositive
     * @sample io.github.ccjhr.samples.number.float.mustNotBePositive
     * @sample io.github.ccjhr.samples.number.int.mustBePositive
     * @sample io.github.ccjhr.samples.number.int.mustNotBePositive
     * @sample io.github.ccjhr.samples.number.long.mustBePositive
     * @sample io.github.ccjhr.samples.number.long.mustNotBePositive
     * @sample io.github.ccjhr.samples.number.short.mustBePositive
     * @sample io.github.ccjhr.samples.number.short.mustNotBePositive
     */
    Positive,

    /**
     * @since 2.0.0
     * @sample io.github.ccjhr.samples.number.double.mustBeNegative
     * @sample io.github.ccjhr.samples.number.double.mustNotBeNegative
     * @sample io.github.ccjhr.samples.number.float.mustBeNegative
     * @sample io.github.ccjhr.samples.number.float.mustNotBeNegative
     * @sample io.github.ccjhr.samples.number.int.mustBeNegative
     * @sample io.github.ccjhr.samples.number.int.mustNotBeNegative
     * @sample io.github.ccjhr.samples.number.long.mustBeNegative
     * @sample io.github.ccjhr.samples.number.long.mustNotBeNegative
     * @sample io.github.ccjhr.samples.number.short.mustBeNegative
     * @sample io.github.ccjhr.samples.number.short.mustNotBeNegative
     */
    Negative,
}