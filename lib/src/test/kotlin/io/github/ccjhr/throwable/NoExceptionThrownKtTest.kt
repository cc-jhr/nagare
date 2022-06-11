package io.github.ccjhr.throwable

import io.github.ccjhr.Experimental
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Experimental
internal class NoExceptionThrownKtTest {

    @Test
    fun `returns true if no exception is thrown`() {
        // when
        val result = noExceptionThrown {
            "test"
        }

        // then
        assertTrue(result)
    }

    @Test
    fun `returns false if an exception is thrown`() {
        // when
        val result = noExceptionThrown {
            throw IllegalArgumentException()
        }

        // then
        assertFalse(result)
    }
}