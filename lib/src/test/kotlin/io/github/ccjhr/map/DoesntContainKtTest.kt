package io.github.ccjhr.map

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class DoesntContainKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Map<Int, String>? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it doesntContain (1 to "hello")
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
                it doesntContain (2 to "of")
            }
        }

        // then
        assertEquals("Expecting Map to not contain <(2, of)>, but it does.", result.message)
    }

    @Test
    fun `succeeds for same key but different value`() {
        // given
        val map = mapOf(
            1 to "Hello",
            2 to "of",
            3 to "words.",
        )

        // when
        map mustSatisfy {
            it doesntContain (2 to "test")
        }
    }

    @Test
    fun `succeeds for non-existing key but existing value`() {
        // given
        val map = mapOf(
            1 to "Hello",
            2 to "of",
            3 to "words.",
        )

        // when
        map mustSatisfy {
            it doesntContain (4 to "of")
        }
    }

    @Test
    fun `succeeds for both non-existing key and non-existing value`() {
        // given
        val map = mapOf(
            1 to "Hello",
            2 to "of",
            3 to "words.",
        )

        // when
        map mustSatisfy {
            it doesntContain (4 to "test")
        }
    }
}