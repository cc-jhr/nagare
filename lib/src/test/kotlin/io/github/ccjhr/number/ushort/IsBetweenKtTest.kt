package io.github.ccjhr.number.ushort

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.number.ushort.and
import io.github.ccjhr.number.ushort.isBetween
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsBetweenKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: UShort? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10u and 12u
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails because lower boundary is violates by smaller value`() {
        // given
        val obj: UShort = 12u

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 15u
            }
        }

        // then
        assertEquals("Value <12> violates lower boundary. It must be greater than <15>", result.message)
    }

    @Test
    fun `fails because lower boundary is violates by equal value`() {
        // given
        val obj: UShort = 12u

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 12u
            }
        }

        // then
        assertEquals("Value <12> violates lower boundary. It must be greater than <12>", result.message)
    }

    @Test
    fun `fails because upper boundary is violates by smaller value`() {
        // given
        val obj: UShort = 21u

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10u and 20u
            }
        }

        // then
        assertEquals("Value <21> violates upper boundary. It must be less than <20>", result.message)
    }

    @Test
    fun `fails because upper boundary is violates by equal value`() {
        // given
        val obj: UShort = 12u

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10u and 12u
            }
        }

        // then
        assertEquals("Value <12> violates upper boundary. It must be less than <12>", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj: UShort = 12u

        // when
        obj mustSatisfy {
            it isBetween 10u and 20u
        }
    }
}