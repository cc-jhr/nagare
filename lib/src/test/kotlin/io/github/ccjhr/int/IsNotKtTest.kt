package io.github.ccjhr.int

import io.github.ccjhr.int.IntAssertionAdjectives.Even
import io.github.ccjhr.int.IntAssertionAdjectives.Odd
import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsNotKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Int? = null

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
            val obj = 11

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
            val obj = 12

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
            val obj = 12

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
            val obj = 11

            // when
            obj mustSatisfy {
                it isNot Even
            }
        }
    }
}