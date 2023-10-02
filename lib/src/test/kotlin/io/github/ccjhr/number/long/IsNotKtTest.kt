package io.github.ccjhr.number.long

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.number.NumberAssertionAdjectives.*
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsNotKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Long? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it mustNotBe Odd
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    internal class OddTests {

        @Test
        fun `fails for odd value`() {
            // given
            val obj = 11L

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it mustNotBe Odd
                }
            }

            // then
            assertEquals("Expecting <11> not to be odd, but it is.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = 12L

            // when
            obj mustSatisfy {
                it mustNotBe Odd
            }
        }
    }

    internal class EvenTests {

        @Test
        fun `fails for even value`() {
            // given
            val obj = 12L

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it mustNotBe Even
                }
            }

            // then
            assertEquals("Expecting <12> not to be even, but it is.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = 11L

            // when
            obj mustSatisfy {
                it mustNotBe Even
            }
        }
    }

    internal class PositiveTests {

        @Test
        fun `fails for positive value`() {
            // given
            val obj = 12L

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it mustNotBe Positive
                }
            }

            // then
            assertEquals("Expecting <12> not to be positive, but it is.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = -12L

            // when
            obj mustSatisfy {
                it mustNotBe Positive
            }
        }
    }

    internal class NegativeTests {

        @Test
        fun `fails for negative value`() {
            // given
            val obj = -12L

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it mustNotBe Negative
                }
            }

            // then
            assertEquals("Expecting <-12> not to be negative, but it is.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = 12L

            // when
            obj mustSatisfy {
                it mustNotBe Negative
            }
        }
    }
}