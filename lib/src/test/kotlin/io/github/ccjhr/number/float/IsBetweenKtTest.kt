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
                it isBetween 10f and 12f
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails because lower boundary is violates by smaller value`() {
        // given
        val obj = 12f

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 15f
            }
        }

        // then
        assertEquals("Value <12.0> violates lower boundary. It must be greater than <15.0>", result.message)
    }

    @Test
    fun `fails because lower boundary is violates by equal value`() {
        // given
        val obj = 12f

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 12f
            }
        }

        // then
        assertEquals("Value <12.0> violates lower boundary. It must be greater than <12.0>", result.message)
    }

    @Test
    fun `fails because upper boundary is violates by smaller value`() {
        // given
        val obj = 21f

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10f and 20f
            }
        }

        // then
        assertEquals("Value <21.0> violates upper boundary. It must be less than <20.0>", result.message)
    }

    @Test
    fun `fails because upper boundary is violates by equal value`() {
        // given
        val obj = 12f

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10f and 12f
            }
        }

        // then
        assertEquals("Value <12.0> violates upper boundary. It must be less than <12.0>", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12f

        // when
        obj mustSatisfy {
            it isBetween 10f and 20f
        }
    }
}