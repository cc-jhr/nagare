package io.github.ccjhr.collection

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.collection.ContainsExactlyAssertionAdjective.InTheSameOrder
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

/**
 * Verifies that the [Collection] under test contains only the elements from the [Collection] of expected elements.
 * If there are duplicates expected then the [Collection] of expected elements must contain these duplicates as well.
 * You can chain this assertion with [and] and a [ContainsExactlyAssertionAdjective].
 * @since 2.0.0
 * @param expectedElements A [Collection] of elements containing all of the elements expected to exist in the [Collection] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver Any nullable or non-nullable [Collection] containing any nullable or non-nullable type.
 * @see and
 * @sample io.github.ccjhr.samples.collection.containsExactly
 * @sample io.github.ccjhr.samples.collection.containsExactlyAndInTheSameOrder
 */
inline infix fun <reified T> AssertionContext<out Collection<T>?>.containsExactly(expectedElements: Collection<T>): ContainsExactlyContext<T> {
    expectNotNull(this.content)

    val collectionUnderTestGrouped = this.content.groupBy { it }
    val expectedElementsGrouped = expectedElements.groupBy { it }

    val missingInCollectionUnderTest = (expectedElementsGrouped.keys - collectionUnderTestGrouped.keys).toMutableSet()
    val missingInExpectedElements = (collectionUnderTestGrouped.keys - expectedElementsGrouped.keys).toMutableSet()

    if (this.content.size != expectedElements.size && missingInCollectionUnderTest.isEmpty() && missingInExpectedElements.isEmpty()) {
        collectionUnderTestGrouped.forEach { (key, numberOfEntries) ->
            if (expectedElementsGrouped[key]!!.size > numberOfEntries.size) {
                missingInCollectionUnderTest.add(key)
            } else if (expectedElementsGrouped[key]!!.size < numberOfEntries.size) {
                missingInExpectedElements.add(key)
            }
        }
    }

    if (missingInCollectionUnderTest.isNotEmpty() || missingInExpectedElements.isNotEmpty()) {
        fail("""
            Expecting <${this.content}>
            to contain <$expectedElements>
            
            Elements which exist in collection under test, but not in expected elements: <$missingInExpectedElements>
            Elements which exist in expected elements, but not in collection under test: <$missingInCollectionUnderTest>
        """.trimIndent())
    }

    return ContainsExactlyContext(this.content, expectedElements)
}

/**
 * Verifies that the [Collection] under test contains only the elements from the [Collection] of expected elements and
 * as well as an additional condition expressed by [ContainsExactlyAssertionAdjective].
 * @since 2.0.0
 * @param adjective The [ContainsExactlyAssertionAdjective] that additionally applies to the [Collection] under test.
 * @throws AssertionError In case the assertion fails.
 * @receiver An instance of [ContainsExactlyContext] which contains both the [Collection] und test as well as the
 * [Collection] of expeceted elements.
 * @see containsExactly
 * @sample io.github.ccjhr.samples.collection.containsExactlyAndInTheSameOrder
 */
inline infix fun <reified T> ContainsExactlyContext<T>.and(adjective: ContainsExactlyAssertionAdjective) {
    when (adjective) {
        InTheSameOrder -> {
            val diffs = mutableListOf<String>()

            this.collectionUnderTest.zip(this.expectedElements).forEachIndexed { index, pair ->
                if (pair.first != pair.second) {
                    diffs.add("Diff on index [$index]: Expecting <${pair.first}> to be <${pair.second}>")
                }
            }

            if (diffs.isNotEmpty()) {
                val messageBuilder = StringBuilder("""
                    Expecting <${this.collectionUnderTest}>
                    to contain <${this.expectedElements}>
                """.trimIndent()).append("\n")

                diffs.forEach { messageBuilder.append("\n").append(it) }

                fail(messageBuilder.toString())
            }
        }
    }
}

/**
 * Creates In conjunction with [and] a bridge for an additional condition.
 * @since 2.0.0
 * @param collectionUnderTest [Collection] under test.
 * @param expectedElements [Collection] containing all elements expected to exist in [Collection] under test.
 * @see containsExactly
 * @see and
 * @see ContainsExactlyAssertionAdjective
 */
data class ContainsExactlyContext<T>(
    val collectionUnderTest: Collection<T>,
    val expectedElements: Collection<T>,
)

/**
 * Adjectives that are expected to additionally apply to a [Collection].
 * @since 2.0.0
 * @see containsExactly
 * @see and
 */
enum class ContainsExactlyAssertionAdjective {
    /**
     * @since 2.0.0
     * @sample io.github.ccjhr.samples.collection.containsExactlyAndInTheSameOrder
     */
    InTheSameOrder,
}