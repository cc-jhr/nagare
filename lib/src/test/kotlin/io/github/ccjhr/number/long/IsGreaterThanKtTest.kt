package io.github.ccjhr.number.long

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsGreaterThanKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Long? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 12L
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails for equal value`() {
        // given
        val obj = 12L

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 12L
            }
        }

        // then
        assertEquals("Expecting <12> to be greater than <12>, but it's not.", result.message)
    }

    @Test
    fun `fails for greater value`() {
        // given
        val obj = 12L

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 13L
            }
        }

        // then
        assertEquals("Expecting <12> to be greater than <13>, but it's not.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12L

        // when
        obj mustSatisfy {
            it isGreaterThan 11L
        }
    }
}