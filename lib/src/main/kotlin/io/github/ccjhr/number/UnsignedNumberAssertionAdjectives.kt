package io.github.ccjhr.number

/**
 * Adjectives that are expected to apply to any unsigned number.
 * @since 2.0.0
 * @see io.github.ccjhr.number.uint.is
 * @see io.github.ccjhr.number.uint.isNot
 * @see io.github.ccjhr.number.ulong.is
 * @see io.github.ccjhr.number.ulong.isNot
 * @see io.github.ccjhr.number.ushort.is
 * @see io.github.ccjhr.number.ushort.isNot
 */
enum class UnsignedNumberAssertionAdjectives {
    /**
     * @since 2.0.0
     * @sample io.github.ccjhr.samples.number.uint.isOdd
     * @sample io.github.ccjhr.samples.number.uint.isNotOdd
     * @sample io.github.ccjhr.samples.number.ulong.isOdd
     * @sample io.github.ccjhr.samples.number.ulong.isNotOdd
     * @sample io.github.ccjhr.samples.number.ushort.isOdd
     * @sample io.github.ccjhr.samples.number.ushort.isNotOdd
     */
    Odd,

    /**
     * @since 2.0.0
     * @sample io.github.ccjhr.samples.number.uint.isEven
     * @sample io.github.ccjhr.samples.number.uint.isNotEven
     * @sample io.github.ccjhr.samples.number.ulong.isEven
     * @sample io.github.ccjhr.samples.number.ulong.isNotEven
     * @sample io.github.ccjhr.samples.number.ushort.isEven
     * @sample io.github.ccjhr.samples.number.ushort.isNotEven
     */
    Even,
}