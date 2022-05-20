package io.github.ccjhr.number

/**
 * Object creating a bridge between the lower boundary check and the upper boundary check.
 * @since 1.1.0
 * @param objectUnderTest Object under test
 * @see io.github.ccjhr.number.double.isBetween
 * @see io.github.ccjhr.number.double.and
 * @see io.github.ccjhr.number.float.isBetween
 * @see io.github.ccjhr.number.float.and
 * @see io.github.ccjhr.number.int.isBetween
 * @see io.github.ccjhr.number.int.and
 * @see io.github.ccjhr.number.long.isBetween
 * @see io.github.ccjhr.number.long.and
 * @see io.github.ccjhr.number.short.isBetween
 * @see io.github.ccjhr.number.short.and
 * @see io.github.ccjhr.number.uint.isBetween
 * @see io.github.ccjhr.number.uint.and
 * @see io.github.ccjhr.number.ulong.isBetween
 * @see io.github.ccjhr.number.ulong.and
 * @see io.github.ccjhr.number.ushort.isBetween
 * @see io.github.ccjhr.number.ushort.and
 */
data class IsBetweenContext<T : Any>(
    val objectUnderTest: T,
)