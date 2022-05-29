package io.github.ccjhr.number.ulong

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsGreaterThanKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: ULong? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 12uL
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails for equal value`() {
        // given
        val obj = 12uL

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 12uL
            }
        }

        // then
        assertEquals("Expecting <12> to be greater than <12>, but it's not.", result.message)
    }

    @Test
    fun `fails for greater value`() {
        // given
        val obj = 12uL

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 13uL
            }
        }

        // then
        assertEquals("Expecting <12> to be greater than <13>, but it's not.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12uL

        // when
        obj mustSatisfy {
            it isGreaterThan 11uL
        }
    }
}