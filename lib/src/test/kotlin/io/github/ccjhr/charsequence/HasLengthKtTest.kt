package io.github.ccjhr.charsequence

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals


internal class HasLengthKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: String? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it hasLength 5
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
                it hasLength 3
            }
        }

        // then
        assertEquals("Expecting CharSequence <test> to be of length <3>, but the actual length is <4>", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = "test"

        // when
        obj mustSatisfy {
            it hasLength 4
        }
    }
}