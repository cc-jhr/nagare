package io.github.ccjhr.number.int

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.number.NumberAssertionAdjectives.*
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Int? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it `is` Odd
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    internal class OddTests {

        @Test
        fun `fails for even value`() {
            // given
            val obj = 12

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it `is` Odd
                }
            }

            // then
            assertEquals("Expecting <12> to be odd, but it's even.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = 11

            // when
            obj mustSatisfy {
                it `is` Odd
            }
        }
    }

    internal class EvenTests {

        @Test
        fun `fails for odd value`() {
            // given
            val obj = 11

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it `is` Even
                }
            }

            // then
            assertEquals("Expecting <11> to be even, but it's odd.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = 12

            // when
            obj mustSatisfy {
                it `is` Even
            }
        }
    }

    internal class PositiveTests {

        @Test
        fun `fails for negative value`() {
            // given
            val obj = -12

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it `is` Positive
                }
            }

            // then
            assertEquals("Expecting <-12> to be positive, but it's negative.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = 12

            // when
            obj mustSatisfy {
                it `is` Positive
            }
        }
    }

    internal class NegativeTests {

        @Test
        fun `fails for positive value`() {
            // given
            val obj = 12

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it `is` Negative
                }
            }

            // then
            assertEquals("Expecting <12> to be negative, but it's positive.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = -12

            // when
            obj mustSatisfy {
                it `is` Negative
            }
        }
    }
}