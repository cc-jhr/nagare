package io.github.ccjhr.collection

import io.github.ccjhr.AssertionContext
import io.github.ccjhr.Experimental
import io.github.ccjhr.collection.ContainsExactlyAssertionAdjective.InTheSameOrder
import io.github.ccjhr.expectNotNull
import kotlin.test.fail

@Experimental
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

@Experimental
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

@Experimental
data class ContainsExactlyContext<T>(
    val collectionUnderTest: Collection<T>,
    val expectedElements: Collection<T>,
)

@Experimental
enum class ContainsExactlyAssertionAdjective {
    InTheSameOrder,
}