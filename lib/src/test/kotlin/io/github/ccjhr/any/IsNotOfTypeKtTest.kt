package io.github.ccjhr.any

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsNotOfTypeKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Int? = null

        // when
        val result = expectsException<IllegalArgumentException> {
            obj mustSatisfy {
                it isNotOfType Int::class
            }
        }

        // then
        assertEquals("Object for assertion is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val obj = 12

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isNotOfType Int::class
            }
        }

        // then
        assertEquals("Expecting object not to be of type <kotlin.Int>, but it was.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val obj = 12

        // when
        obj mustSatisfy {
            it isNotOfType String::class
        }
    }
}