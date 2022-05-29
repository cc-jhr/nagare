package io.github.ccjhr.map

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class HasSizeKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Map<Int, String>? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it hasSize 1
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val map = mapOf(
            1 to "Hello",
            2 to "of",
            3 to "words.",
        )

        // when
        val result = expectsException<AssertionError> {
            map mustSatisfy {
                it hasSize 2
            }
        }

        // then
        assertEquals("Expecting Map to be of size <2>, but has size <3>.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val map = mapOf(
            1 to "Hello",
            2 to "of",
            3 to "words.",
        )

        // when
        map mustSatisfy {
            it hasSize 3
        }
    }
}