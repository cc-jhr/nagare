package io.github.ccjhr.number.short

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsBetweenKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Short? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10.toShort()..12.toShort()
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails because lower boundary is violated by smaller value`() {
        // given
        val obj = 9.toShort()

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10.toShort()..20.toShort()
            }
        }

        // then
        assertEquals("Expecting <9> to be greater than <10> and less than <20>", result.message)
    }

    @Test
    fun `fails because lower boundary is violated by equal value`() {
        // given
        val obj = 10.toShort()

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10.toShort()..20.toShort()
            }
        }

        // then
        assertEquals("Expecting <10> to be greater than <10> and less than <20>", result.message)
    }

    @Test
    fun `fails because upper boundary is violated by smaller value`() {
        // given
        val obj = 21.toShort()

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10.toShort()..20.toShort()
            }
        }

        // then
        assertEquals("Expecting <21> to be greater than <10> and less than <20>", result.message)
    }

    @Test
    fun `fails because upper boundary is violated by equal value`() {
        // given
        val obj = 20.toShort()

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isBetween 10.toShort()..20.toShort()
            }
        }

        // then
        assertEquals("Expecting <20> to be greater than <10> and less than <20>", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12.toShort()

        // when
        obj mustSatisfy {
            it isBetween 10.toShort()..20.toShort()
        }
    }
}