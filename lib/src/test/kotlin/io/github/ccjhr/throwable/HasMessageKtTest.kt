package io.github.ccjhr.throwable

import io.github.ccjhr.mustSatisfy
import kotlin.test.Test
import kotlin.test.assertEquals

internal class HasMessageKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Throwable? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it hasMessage "message"
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails for differing values`() {
        // given
        val obj = NullPointerException("different message here")

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it hasMessage "message here"
            }
        }

        // then
        assertEquals("Expecting <different message here> to be equal to <message here>, but it's not.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = NullPointerException("message here")

        // when
        obj mustSatisfy {
            it hasMessage "message here"
        }
    }
}