package io.github.ccjhr.number.uint

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.number.UnsignedNumberAssertionAdjectives.*
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: UInt? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it mustBe Odd
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    internal class OddTests {

        @Test
        fun `fails for even value`() {
            // given
            val obj = 12U

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it mustBe Odd
                }
            }

            // then
            assertEquals("Expecting <12> to be odd, but it's even.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = 11U

            // when
            obj mustSatisfy {
                it mustBe Odd
            }
        }
    }

    internal class EvenTests {

        @Test
        fun `fails for odd value`() {
            // given
            val obj = 11U

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it mustBe Even
                }
            }

            // then
            assertEquals("Expecting <11> to be even, but it's odd.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = 12U

            // when
            obj mustSatisfy {
                it mustBe Even
            }
        }
    }
}