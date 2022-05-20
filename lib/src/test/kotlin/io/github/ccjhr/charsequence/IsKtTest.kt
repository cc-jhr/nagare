package io.github.ccjhr.charsequence

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.charsequence.CharSequenceAssertionAdjective.*
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: String? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it `is` Blank
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    internal class BlankTests {

        @Test
        fun `fails for Blank`() {
            // given
            val obj = "test"

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it `is` Blank
                }
            }

            // then
            assertEquals("Expecting CharSequence to be <blank>, but it was not.", result.message)
        }

        @Test
        fun `succeeds for Blank`() {
            // given
            val obj = "    "

            // when
            obj mustSatisfy {
                it `is` Blank
            }
        }
    }

    internal class EmptyTests {

        @Test
        fun `fails for Empty`() {
            // given
            val obj = "test"

            // when
            val result = expectsException<AssertionError> {
                obj mustSatisfy {
                    it `is` Empty
                }
            }

            // then
            assertEquals("Expecting CharSequence to be <empty>, but it was not.", result.message)
        }

        @Test
        fun `succeeds for Empty`() {
            // given
            val obj = ""

            // when
            obj mustSatisfy {
                it `is` Empty
            }
        }
    }
}