package io.github.ccjhr.number.float

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsGreaterThanKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Float? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 12f
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails for equal value`() {
        // given
        val obj = 12f

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 12f
            }
        }

        // then
        assertEquals("Expecting <12.0> to be greater than <12.0>, but it's not.", result.message)
    }

    @Test
    fun `fails for greater value`() {
        // given
        val obj = 12f

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 13f
            }
        }

        // then
        assertEquals("Expecting <12.0> to be greater than <13.0>, but it's not.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12f

        // when
        obj mustSatisfy {
            it isGreaterThan 11f
        }
    }
}