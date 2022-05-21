package io.github.ccjhr.number.ushort

import io.github.ccjhr.mustSatisfy
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
                it isBetween 10u..12u
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails because lower boundary is violated by smaller value`() {
        // given
        val obj: UShort = 9u

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10u..20u
            }
        }

        // then
        assertEquals("Expecting <9> to be greater than <10> and less than <20>", result.message)
    }

    @Test
    fun `fails because lower boundary is violated by equal value`() {
        // given
        val obj: UShort = 10u

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10u..20u
            }
        }

        // then
        assertEquals("Expecting <10> to be greater than <10> and less than <20>", result.message)
    }

    @Test
    fun `fails because upper boundary is violated by smaller value`() {
        // given
        val obj: UShort = 21u

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10u..20u
            }
        }

        // then
        assertEquals("Expecting <21> to be greater than <10> and less than <20>", result.message)
    }

    @Test
    fun `fails because upper boundary is violated by equal value`() {
        // given
        val obj: UShort = 20u

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10u..20u
            }
        }

        // then
        assertEquals("Expecting <20> to be greater than <10> and less than <20>", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj: UShort = 12u

        // when
        obj mustSatisfy {
            it isBetween 10u..20u
        }
    }
}