package io.github.ccjhr.number.uint

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.number.UnsignedNumberAssertionAdjectives.*
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsNotKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: UInt? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isNot Odd
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    internal class OddTests {

        @Test
        fun `fails for odd value`() {
            // given
            val obj = 11U

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it isNot Odd
                }
            }

            // then
            assertEquals("Expecting <11> not to be odd, but it is.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = 12U

            // when
            obj mustSatisfy {
                it isNot Odd
            }
        }
    }

    internal class EvenTests {

        @Test
        fun `fails for even value`() {
            // given
            val obj = 12U

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it isNot Even
                }
            }

            // then
            assertEquals("Expecting <12> not to be even, but it is.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = 11U

            // when
            obj mustSatisfy {
                it isNot Even
            }
        }
    }
}