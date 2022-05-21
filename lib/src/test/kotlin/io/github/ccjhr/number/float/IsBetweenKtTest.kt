package io.github.ccjhr.number.float

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsBetweenKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Float? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10f..12f
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails because lower boundary is violated by smaller value`() {
        // given
        val obj = 9f

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10f..20f
            }
        }

        // then
        assertEquals("Expecting <9.0> to be greater than <10.0> and less than <20.0>", result.message)
    }

    @Test
    fun `fails because lower boundary is violated by equal value`() {
        // given
        val obj = 10f

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10f..20f
            }
        }

        // then
        assertEquals("Expecting <10.0> to be greater than <10.0> and less than <20.0>", result.message)
    }

    @Test
    fun `fails because upper boundary is violated by smaller value`() {
        // given
        val obj = 21f

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10f..20f
            }
        }

        // then
        assertEquals("Expecting <21.0> to be greater than <10.0> and less than <20.0>", result.message)
    }

    @Test
    fun `fails because upper boundary is violated by equal value`() {
        // given
        val obj = 20f

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10f..20f
            }
        }

        // then
        assertEquals("Expecting <20.0> to be greater than <10.0> and less than <20.0>", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12f

        // when
        obj mustSatisfy {
            it isBetween 10f..20f
        }
    }
}