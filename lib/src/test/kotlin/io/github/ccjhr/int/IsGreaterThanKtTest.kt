package io.github.ccjhr.int

import io.github.ccjhr.throwable.expectsException
import io.github.ccjhr.mustSatisfy
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsGreaterThanKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Int? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 12
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails for equal value`() {
        // given
        val obj = 12

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 12
            }
        }

        // then
        assertEquals("Expecting <12> to be greater than <12>, but it's not.", result.message)
    }

    @Test
    fun `fails for greater value`() {
        // given
        val obj = 12

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 13
            }
        }

        // then
        assertEquals("Expecting <12> to be greater than <13>, but it's not.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12

        // when
        obj mustSatisfy {
            it isGreaterThan 11
        }
    }
}