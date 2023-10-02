package io.github.ccjhr.number

/**
 * Adjectives that are expected to apply to any unsigned number.
 * @since 2.0.0
 * @see io.github.ccjhr.number.uint.mustBe
 * @see io.github.ccjhr.number.uint.mustNotBe
 * @see io.github.ccjhr.number.ulong.mustbe
 * @see io.github.ccjhr.number.ulong.mustNotBe
 * @see io.github.ccjhr.number.ushort.mustBe
 * @see io.github.ccjhr.number.ushort.mustNotBe
 */
enum class UnsignedNumberAssertionAdjectives {
    /**
     * @since 2.0.0
     * @sample io.github.ccjhr.samples.number.uint.mustBeOdd
     * @sample io.github.ccjhr.samples.number.uint.mustNotBeOdd
     * @sample io.github.ccjhr.samples.number.ulong.mustBeOdd
     * @sample io.github.ccjhr.samples.number.ulong.mustNotBeOdd
     * @sample io.github.ccjhr.samples.number.ushort.mustBeOdd
     * @sample io.github.ccjhr.samples.number.ushort.mustNotBeOdd
     */
    Odd,

    /**
     * @since 2.0.0
     * @sample io.github.ccjhr.samples.number.uint.mustBeEven
     * @sample io.github.ccjhr.samples.number.uint.mustNotBeEven
     * @sample io.github.ccjhr.samples.number.ulong.mustBeEven
     * @sample io.github.ccjhr.samples.number.ulong.mustNotBeEven
     * @sample io.github.ccjhr.samples.number.ushort.mustBeEven
     * @sample io.github.ccjhr.samples.number.ushort.mustNotBeEven
     */
    Even,
}