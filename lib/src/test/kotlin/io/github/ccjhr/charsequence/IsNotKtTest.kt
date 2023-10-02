package io.github.ccjhr.charsequence

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.charsequence.CharSequenceAssertionAdjective.Blank
import io.github.ccjhr.charsequence.CharSequenceAssertionAdjective.Empty
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsNotKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: String? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it mustNotBe Blank
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    internal class BlankTests {

        @Test
        fun `fails for Blank`() {
            // given
            val obj = "    "

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it mustNotBe Blank
                }
            }

            // then
            assertEquals("Expecting CharSequence not to be <blank>, but it was.", result.message)
        }

        @Test
        fun `succeeds for Blank`() {
            // given
            val obj = "test"

            // when
            obj mustSatisfy {
                it mustNotBe Blank
            }
        }
    }

    internal class EmptyTests {

        @Test
        fun `fails for Empty`() {
            // given
            val obj = ""

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it mustNotBe Empty
                }
            }

            // then
            assertEquals("Expecting CharSequence not to be <empty>, but it was.", result.message)
        }

        @Test
        fun `succeeds for Empty`() {
            // given
            val obj = "test"

            // when
            obj mustSatisfy {
                it mustNotBe Empty
            }
        }
    }
}