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
                it isBetween 10.0 and 12.0
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails because lower boundary is violates by smaller value`() {
        // given
        val obj = 12.0

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 15.0
            }
        }

        // then
        assertEquals("Value <12.0> violates lower boundary. It must be greater than <15.0>", result.message)
    }

    @Test
    fun `fails because lower boundary is violates by equal value`() {
        // given
        val obj = 12.0

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 12.0
            }
        }

        // then
        assertEquals("Value <12.0> violates lower boundary. It must be greater than <12.0>", result.message)
    }

    @Test
    fun `fails because upper boundary is violates by smaller value`() {
        // given
        val obj = 21.0

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10.0 and 20.0
            }
        }

        // then
        assertEquals("Value <21.0> violates upper boundary. It must be less than <20.0>", result.message)
    }

    @Test
    fun `fails because upper boundary is violates by equal value`() {
        // given
        val obj = 12.0

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10.0 and 12.0
            }
        }

        // then
        assertEquals("Value <12.0> violates upper boundary. It must be less than <12.0>", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12.0

        // when
        obj mustSatisfy {
            it isBetween 10.0 and 20.0
        }
    }
}