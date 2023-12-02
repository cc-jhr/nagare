package io.github.ccjhr.collection

import io.github.ccjhr.collection.CollectionAssertionAdjective.Empty
import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsKtTest {

    @Test
    fun `throws exception if the object is null`() {
        // given
        val obj: Collection<String>? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it mustBe Empty
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
                it mustBe Empty
            }
        }

        // then
        assertEquals("Expecting Collection to be <empty>, but it was not.", result.message)
    }

    @Test
    fun succeeds() {
        // given
        val list = emptyList<Int>()

        // when
        list mustSatisfy {
            it mustBe Empty
        }
    }
}