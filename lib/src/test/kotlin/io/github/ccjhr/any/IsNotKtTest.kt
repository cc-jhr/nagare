package io.github.ccjhr.any

import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsNotKtTest {

    @Test
    fun `fails for Null`() {
        // given
        val obj: String? = null

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it isNot Null
            }
        }

        // then
        assertEquals("Expecting object not to be null, but it is.", result.message)
    }

    @Test
    fun `succeeds for Null`() {
        // given
        val obj = "test"

        // when
        obj mustSatisfy {
            it isNot Null
        }
    }
}