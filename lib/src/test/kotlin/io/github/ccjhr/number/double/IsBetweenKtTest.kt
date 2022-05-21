package io.github.ccjhr.number.double

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsBetweenKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Double? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10.0..12.0
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails because lower boundary is violated by smaller value`() {
        // given
        val obj = 9.0

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10.0..20.0
            }
        }

        // then
        assertEquals("Expecting <9.0> to be greater than <10.0> and less than <20.0>", result.message)
    }

    @Test
    fun `fails because lower boundary is violated by equal value`() {
        // given
        val obj = 10.0

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10.0..20.0
            }
        }

        // then
        assertEquals("Expecting <10.0> to be greater than <10.0> and less than <20.0>", result.message)
    }

    @Test
    fun `fails because upper boundary is violated by smaller value`() {
        // given
        val obj = 21.0

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10.0..20.0
            }
        }

        // then
        assertEquals("Expecting <21.0> to be greater than <10.0> and less than <20.0>", result.message)
    }

    @Test
    fun `fails because upper boundary is violated by equal value`() {
        // given
        val obj = 20.0

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10.0..20.0
            }
        }

        // then
        assertEquals("Expecting <20.0> to be greater than <10.0> and less than <20.0>", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12.0

        // when
        obj mustSatisfy {
            it isBetween 10.0..20.0
        }
    }
}