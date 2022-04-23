package io.github.ccjhr.any

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsEqualToKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Int? = null

        // when
        val result = expectsException<IllegalArgumentException> {
            obj mustSatisfy {
                it isEqualTo 12
            }
        }

        // then
        assertEquals("Object for assertion is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val obj = 12

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isEqualTo 14
            }
        }

        // then
        assertEquals("Expecting <12> to be equal to <14>, but it's not.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12

        // when
        obj mustSatisfy {
            it isEqualTo 12
        }
    }
}