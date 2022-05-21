package io.github.ccjhr.collection

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals


internal class ContainsNoneOfKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Collection<String>? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it containsNoneOf setOf("test")
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val list = listOf("List", "of", "words.")

        // when
        val result = expectsException<AssertionError> {
            list mustSatisfy {
                it containsNoneOf listOf("hello", "List")
            }
        }

        // then
        assertEquals("Expecting <[List, of, words.]> to contain none of the following items <[hello, List]>, but these items were found: <[List]>.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val list = listOf("List", "of", "words.")

        // when
        list mustSatisfy {
            it containsNoneOf mutableListOf("hello", "world")
        }
    }
}