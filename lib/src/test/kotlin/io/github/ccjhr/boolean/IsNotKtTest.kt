package io.github.ccjhr.boolean

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsNotKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Boolean? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it mustNotBe false
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val obj = false

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it mustNotBe false
            }
        }

        // then
        assertEquals("Expecting value not to be <false>, but it was.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = false

        // when
        obj mustSatisfy {
            it mustNotBe true
        }
    }
}