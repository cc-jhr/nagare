package io.github.ccjhr.number.double

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsGreaterThanKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Double? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 12.0
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails for equal value`() {
        // given
        val obj = 12.0

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 12.0
            }
        }

        // then
        assertEquals("Expecting <12.0> to be greater than <12.0>, but it's not.", result.message)
    }

    @Test
    fun `fails for greater value`() {
        // given
        val obj = 12.0

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isGreaterThan 13.0
            }
        }

        // then
        assertEquals("Expecting <12.0> to be greater than <13.0>, but it's not.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12.0

        // when
        obj mustSatisfy {
            it isGreaterThan 11.0
        }
    }
}