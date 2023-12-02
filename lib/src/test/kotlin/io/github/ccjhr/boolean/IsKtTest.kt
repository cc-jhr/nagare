package io.github.ccjhr.boolean

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Boolean? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it mustBe false
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val obj = true

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it mustBe false
            }
        }

        // then
        assertEquals("Expecting value to be <false>, but it wasn't.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = true

        // when
        obj mustSatisfy {
            it mustBe true
        }
    }
}