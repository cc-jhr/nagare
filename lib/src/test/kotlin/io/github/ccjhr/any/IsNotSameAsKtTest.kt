package io.github.ccjhr.any

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class IsNotSameAsKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Pair<Int, String>? = null

        // when
        val result = expectsException<IllegalArgumentException> {
            obj mustSatisfy {
                it isSameAs "test"
            }
        }

        // then
        assertEquals("Object for assertion is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val obj = 12 to "test"

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isNotSameAs obj
            }
        }

        // then
        assertTrue(result.message!!.contains("to point to different objects, but they don't."))
    }

    @Test
    fun `mustNotBeSameAs fails for different instantiation of Int`() {
        // given
        val a = "12".toInt()
        val b = 12

        // when
        val result = expectsException<AssertionError> {
            a mustSatisfy {
                it isNotSameAs b
            }
        }

        // then
        assertTrue(result.message!!.contains("to point to different objects, but they don't."))
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12 to "content"

        // when
        obj mustSatisfy {
            it isNotSameAs 12 to "content"
        }
    }
}