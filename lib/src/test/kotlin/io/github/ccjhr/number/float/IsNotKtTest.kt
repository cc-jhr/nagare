package io.github.ccjhr.number.float

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.number.NumberAssertionAdjectives.*
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsNotKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Float? = null

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
            val obj = 11f

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it isNot Odd
                }
            }

            // then
            assertEquals("Expecting <11.0> not to be odd, but it is.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = 12f

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
            val obj = 12f

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it isNot Even
                }
            }

            // then
            assertEquals("Expecting <12.0> not to be even, but it is.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = 11f

            // when
            obj mustSatisfy {
                it isNot Even
            }
        }
    }

    internal class PositiveTests {

        @Test
        fun `fails for positive value`() {
            // given
            val obj = 12f

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it isNot Positive
                }
            }

            // then
            assertEquals("Expecting <12.0> not to be positive, but it is.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = -12f

            // when
            obj mustSatisfy {
                it isNot Positive
            }
        }
    }

    internal class NegativeTests {

        @Test
        fun `fails for negative value`() {
            // given
            val obj = -12f

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it isNot Negative
                }
            }

            // then
            assertEquals("Expecting <-12.0> not to be negative, but it is.", result.message)
        }

        @Test
        fun succeeds() {
            // given
            val obj = 12f

            // when
            obj mustSatisfy {
                it isNot Negative
            }
        }
    }
}