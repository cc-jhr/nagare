package io.github.ccjhr.any

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsNotEqualToKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Int? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isNotEqualTo 12
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val obj = 12

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isNotEqualTo 12
            }
        }

        // then
        assertEquals("Expecting objects not to be equal, but they are.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12

        // when
        obj mustSatisfy {
            it isNotEqualTo 13
        }
    }
}