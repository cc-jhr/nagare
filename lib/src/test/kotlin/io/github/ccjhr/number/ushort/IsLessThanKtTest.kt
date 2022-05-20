package io.github.ccjhr.number.ushort

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.number.ushort.isLessThan
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsLessThanKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: UShort? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isLessThan 12u
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails for equal value`() {
        // given
        val obj: UShort = 12u

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isLessThan 12u
            }
        }

        // then
        assertEquals("Expecting <12> to be less than <12>, but it's not.", result.message)
    }

    @Test
    fun `fails for greater value`() {
        // given
        val obj: UShort = 12u

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isLessThan 11u
            }
        }

        // then
        assertEquals("Expecting <12> to be less than <11>, but it's not.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj: UShort = 11u

        // when
        obj mustSatisfy {
            it isLessThan 12u
        }
    }
}