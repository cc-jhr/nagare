package io.github.ccjhr.string

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import org.testng.annotations.Test
import kotlin.test.assertEquals

internal class MatchesKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: String? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it matches Regex("[a-z]+-string-\\d+")
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val obj = "test"

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it matches Regex("[a-z]+-string-\\d+")
            }
        }

        // then
        assertEquals("Expecting <test> to match <[a-z]+-string-\\d+>, but it doesn't.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = "test-string-14"

        // when
        obj mustSatisfy {
            it matches Regex("[a-z]+-string-\\d+")
        }
    }
}