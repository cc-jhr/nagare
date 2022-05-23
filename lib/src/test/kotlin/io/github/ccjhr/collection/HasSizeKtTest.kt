package io.github.ccjhr.collection

import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class HasSizeKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Collection<String>? = null

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
        val list = listOf("List", "of", "words.")

        // when
        val result = expectsException<AssertionError> {
            list mustSatisfy {
                it hasSize 2
            }
        }

        // then
        assertEquals("Expecting collection to be of size <2>, but has size <3>.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val list = listOf("List", "of", "words.")

        // when
        list mustSatisfy {
            it hasSize 3
        }
    }
}