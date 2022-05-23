package io.github.ccjhr.collection

import io.github.ccjhr.collection.ContainsExactlyAssertionAdjective.InTheSameOrder
import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class ContainsExactlyKtTest {

    internal class ContainsExactlyTests {

        @Test
        fun `throws exception if the object is null`() {
            // given
            val obj: Collection<String>? = null

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it containsExactly setOf("test")
                }
            }

            // then
            assertEquals("Object under test is null.", result.message)
        }

        @Test
        fun `fails - containing one differing element each`() {
            // given
            val list = listOf("List", "of", "words.")

            // when
            val result = expectsException<AssertionError> {
                list mustSatisfy {
                    it containsExactly listOf("List", "other", "words.")
                }
            }

            // then
            assertEquals("""
            Expecting <[List, of, words.]>
            to contain <[List, other, words.]>
            
            Elements which exist in collection under test, but not in expected elements: <[of]>
            Elements which exist in expected elements, but not in collection under test: <[other]>
        """.trimIndent(), result.message)
        }

        @Test
        fun `fails - collection under test containing a differing element`() {
            // given
            val list = listOf("List", "of", "test", "words.")

            // when
            val result = expectsException<AssertionError> {
                list mustSatisfy {
                    it containsExactly listOf("List", "of", "words.")
                }
            }

            // then
            assertEquals("""
            Expecting <[List, of, test, words.]>
            to contain <[List, of, words.]>
            
            Elements which exist in collection under test, but not in expected elements: <[test]>
            Elements which exist in expected elements, but not in collection under test: <[]>
        """.trimIndent(), result.message)
        }

        @Test
        fun `fails - expected elements containing a differing element`() {
            // given
            val list = listOf("List", "of", "words.")

            // when
            val result = expectsException<AssertionError> {
                list mustSatisfy {
                    it containsExactly listOf("List", "of", "test", "words.")
                }
            }

            // then
            assertEquals("""
            Expecting <[List, of, words.]>
            to contain <[List, of, test, words.]>
            
            Elements which exist in collection under test, but not in expected elements: <[]>
            Elements which exist in expected elements, but not in collection under test: <[test]>
        """.trimIndent(), result.message)
        }

        @Test
        fun `fails - both contain same elements, but with duplicates in collection under test`() {
            // given
            val list = listOf("List", "of", "of", "words.")

            // when
            val result = expectsException<AssertionError> {
                list mustSatisfy {
                    it containsExactly listOf("List", "of", "words.")
                }
            }

            // then
            assertEquals("""
            Expecting <[List, of, of, words.]>
            to contain <[List, of, words.]>
            
            Elements which exist in collection under test, but not in expected elements: <[of]>
            Elements which exist in expected elements, but not in collection under test: <[]>
        """.trimIndent(), result.message)
        }

        @Test
        fun `fails - both contain same elements, but with duplicates in expected elements`() {
            // given
            val list = listOf("List", "of", "words.")

            // when
            val result = expectsException<AssertionError> {
                list mustSatisfy {
                    it containsExactly listOf("List", "of", "of", "words.")
                }
            }

            // then
            assertEquals("""
            Expecting <[List, of, words.]>
            to contain <[List, of, of, words.]>
            
            Elements which exist in collection under test, but not in expected elements: <[]>
            Elements which exist in expected elements, but not in collection under test: <[of]>
        """.trimIndent(), result.message)
        }

        @Test
        fun succeeds() {
            // given
            val list = listOf("List", "of", "words.")

            // when
            list mustSatisfy {
                it containsExactly listOf("of", "words.", "List")
            }
        }
    }

    internal class ContainsExactlyInTheSameOrderTests {

        @Test
        fun `fails for a different order`() {
            // given
            val list = listOf("List", "of", "words.")

            // when
            val result = expectsException<AssertionError> {
                list mustSatisfy {
                    it containsExactly listOf("of", "words.", "List") and InTheSameOrder
                }
            }

            assertEquals("""
                Expecting <[List, of, words.]>
                to contain <[of, words., List]>
        
                Diff on index [0]: Expecting <List> to be <of>
                Diff on index [1]: Expecting <of> to be <words.>
                Diff on index [2]: Expecting <words.> to be <List>
            """.trimIndent(), result.message)
        }

        @Test
        fun succeeds() {
            // given
            val list = listOf("List", "of", "words.")

            // when
            list mustSatisfy {
                it containsExactly listOf("List", "of", "words.") and InTheSameOrder
            }
        }
    }
}