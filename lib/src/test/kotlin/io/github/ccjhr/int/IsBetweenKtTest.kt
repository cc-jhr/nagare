package io.github.ccjhr.int

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsBetweenKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Int? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10 and 12
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails because lower boundary is violates by smaller value`() {
        // given
        val obj = 12

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 15
            }
        }

        // then
        assertEquals("Value <12> violates lower boundary. It must be greater than <15>", result.message)
    }

    @Test
    fun `fails because lower boundary is violates by equal value`() {
        // given
        val obj = 12

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 12
            }
        }

        // then
        assertEquals("Value <12> violates lower boundary. It must be greater than <12>", result.message)
    }

    @Test
    fun `fails because upper boundary is violates by smaller value`() {
        // given
        val obj = 21

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10 and 20
            }
        }

        // then
        assertEquals("Value <21> violates upper boundary. It must be less than <20>", result.message)
    }

    @Test
    fun `fails because upper boundary is violates by equal value`() {
        // given
        val obj = 12

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10 and 12
            }
        }

        // then
        assertEquals("Value <12> violates upper boundary. It must be less than <12>", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12

        // when
        obj mustSatisfy {
            it isBetween 10 and 20
        }
    }
}