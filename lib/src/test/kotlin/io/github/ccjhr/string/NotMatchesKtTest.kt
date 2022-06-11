package io.github.ccjhr.string

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals


internal class NotMatchesKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: String? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it notMatches Regex("[a-z]+-string-\\d+")
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val obj = "test-string-14"

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it notMatches Regex("[a-z]+-string-\\d+")
            }
        }

        // then
        assertEquals("Expecting <test-string-14> not to match <[a-z]+-string-\\d+>, but it does.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = "test"

        // when
        obj mustSatisfy {
            it notMatches Regex("[a-z]+-string-\\d+")
        }
    }
}