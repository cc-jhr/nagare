package io.github.ccjhr.map

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals


internal class ContainsKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Map<Int, String>? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it contains (1 to "hello")
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun `fails for same key different value`() {
        // given
        val map = mapOf(
            1 to "Hello",
            2 to "of",
            3 to "words.",
        )

        // when
        val result = expectsException<AssertionError> {
            map mustSatisfy {
                it contains (2 to "test")
            }
        }

        // then
        assertEquals("Expecting Map to contain <(2, test)>, but it doesn't.", result.message)
    }

    @Test
    fun `fails for non existing key and existing value`() {
        // given
        val map = mapOf(
            1 to "Hello",
            2 to "of",
            3 to "words.",
        )

        // when
        val result = expectsException<AssertionError> {
            map mustSatisfy {
                it contains (4 to "of")
            }
        }

        // then
        assertEquals("Expecting Map to contain <(4, of)>, but it doesn't.", result.message)
    }

    @Test
    fun `fails for both key and value being different`() {
        // given
        val map = mapOf(
            1 to "Hello",
            2 to "of",
            3 to "words.",
        )

        // when
        val result = expectsException<AssertionError> {
            map mustSatisfy {
                it contains (4 to "test")
            }
        }

        // then
        assertEquals("Expecting Map to contain <(4, test)>, but it doesn't.", result.message)
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
            it contains (2 to "of")
        }
    }
}