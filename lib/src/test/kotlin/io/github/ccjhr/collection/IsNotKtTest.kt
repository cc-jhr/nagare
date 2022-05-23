package io.github.ccjhr.collection

import io.github.ccjhr.collection.CollectionAssertionAdjective.Empty
import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsNotKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Collection<String>? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isNot Empty
            }
        }

        // then
        assertEquals("Object under test is null.", result.message)
    }

    @Test
    fun fails() {
        // given
        val list = emptyList<Int>()

        // when
        val result = expectsException<AssertionError> {
            list mustSatisfy {
                it isNot Empty
            }
        }

        // then
        assertEquals("Expecting Collection not to be <empty>, but it was.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val list = listOf("List", "of", "words.")

        // when
        list mustSatisfy {
            it isNot Empty
        }
    }
}