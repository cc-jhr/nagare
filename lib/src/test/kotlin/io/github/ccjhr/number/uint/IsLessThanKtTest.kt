package io.github.ccjhr.number.uint

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsLessThanKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: UInt? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isLessThan 12U
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails for equal value`() {
        // given
        val obj = 12U

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isLessThan 12U
            }
        }

        // then
        assertEquals("Expecting <12> to be less than <12>, but it's not.", result.message)
    }

    @Test
    fun `fails for greater value`() {
        // given
        val obj = 12U

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isLessThan 11U
            }
        }

        // then
        assertEquals("Expecting <12> to be less than <11>, but it's not.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 11U

        // when
        obj mustSatisfy {
            it isLessThan 12U
        }
    }
}