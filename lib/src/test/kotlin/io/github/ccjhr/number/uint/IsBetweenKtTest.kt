package io.github.ccjhr.number.uint

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsBetweenKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: UInt? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10U and 12U
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails because lower boundary is violates by smaller value`() {
        // given
        val obj = 12U

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 15U
            }
        }

        // then
        assertEquals("Value <12> violates lower boundary. It must be greater than <15>", result.message)
    }

    @Test
    fun `fails because lower boundary is violates by equal value`() {
        // given
        val obj = 12U

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 12U
            }
        }

        // then
        assertEquals("Value <12> violates lower boundary. It must be greater than <12>", result.message)
    }

    @Test
    fun `fails because upper boundary is violates by smaller value`() {
        // given
        val obj = 21U

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10U and 20U
            }
        }

        // then
        assertEquals("Value <21> violates upper boundary. It must be less than <20>", result.message)
    }

    @Test
    fun `fails because upper boundary is violates by equal value`() {
        // given
        val obj = 12U

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10U and 12U
            }
        }

        // then
        assertEquals("Value <12> violates upper boundary. It must be less than <12>", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12U

        // when
        obj mustSatisfy {
            it isBetween 10U and 20U
        }
    }
}