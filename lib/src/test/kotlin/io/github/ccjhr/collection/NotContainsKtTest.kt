package io.github.ccjhr.collection

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class NotContainsKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Collection<String>? = null

        // when
        val result = expectsException<IllegalArgumentException> {
            obj mustSatisfy {
                it notContains "test"
            }
        }

        // then
        assertEquals("Object for assertion is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val list = listOf("List", "of", "words.")

        // when
        val result = expectsException<AssertionError> {
            list mustSatisfy {
                it notContains "of"
            }
        }

        // then
        assertEquals("Expecting <[List, of, words.]> to not contain <of>, but it does.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val list = listOf("List", "of", "words.")

        // when
        list mustSatisfy {
            it notContains "world"
        }
    }
}