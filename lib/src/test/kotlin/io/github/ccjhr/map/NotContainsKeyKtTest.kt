package io.github.ccjhr.map

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class NotContainsKeyKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Map<Int, String>? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it notContainsKey 1
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
                it notContainsKey 2
            }
        }

        // then
        assertEquals("Expecting Map to not contain key <2>, but it does.", result.message)
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
            it notContainsKey 4
        }
    }
}