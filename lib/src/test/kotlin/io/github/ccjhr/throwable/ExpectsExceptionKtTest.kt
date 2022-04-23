package io.github.ccjhr.throwable

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


internal class ExpectsExceptionKtTest {

    @Test
    fun `returns the exception whoich was thrown if it was of expected type`() {
        // when
        val result: IllegalArgumentException = expectsException {
            throw IllegalArgumentException("message here")
        }

        // then
        assertEquals("message here", result.message)
    }

    @Test
    fun `throws exception if another exception was thrown`() {
        // when
        val result = try {
            expectsException<IllegalArgumentException> {
                throw NullPointerException()
            }
        } catch (e: Throwable) {
            e
        }

        // then
        assertTrue(result is RuntimeException)
        assertEquals("Expected [java.lang.IllegalArgumentException] to be thrown, but [java.lang.NullPointerException] was thrown.", result.message)
    }

    @Test
    fun `throws exception if no exception was thrown`() {
        // when
        val result = try {
            expectsException<IllegalArgumentException> {
            }
        } catch (e: Throwable) {
            e
        }

        // then
        assertTrue(result is RuntimeException)
        assertEquals("Expected exception of type [java.lang.IllegalArgumentException], but nothing was thrown.", result.message)
    }
}