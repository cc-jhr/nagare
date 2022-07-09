package io.github.ccjhr.string

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.assertEquals
import kotlin.test.Test


internal class DoesntContainKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: String? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it doesntContain "test"
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val obj = "hello world"

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it doesntContain "world"
            }
        }

        // then
        assertEquals("Expecting <hello world> not to contain <world>, but it does.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = "this is a test"

        // when
        obj mustSatisfy {
            it doesntContain "hello"
        }
    }
}