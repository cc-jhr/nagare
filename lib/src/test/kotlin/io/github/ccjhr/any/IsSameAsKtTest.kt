package io.github.ccjhr.any

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class IsSameAsKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Pair<Int, String>? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isSameAs "test"
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val obj = 12 to "test"

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isSameAs 12 to "test"
            }
        }

        // then
        assertTrue(result.message!!.contains("to point to the same object, but they don't"))
    }

    @Test
    fun `succeeds for different instantiations of Int`() {
        // given
        val a = "12".toInt()
        val b = 12

        // when
        a mustSatisfy {
            it isSameAs b
        }
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12 to "content"

        // when
        obj mustSatisfy {
            it isSameAs obj
        }
    }
}