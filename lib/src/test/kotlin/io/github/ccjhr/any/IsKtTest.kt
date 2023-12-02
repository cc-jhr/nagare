package io.github.ccjhr.any

import io.github.ccjhr.any.AnyAssertionAdjective.*
import io.github.ccjhr.mustSatisfy
import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsKtTest {

    @Test
    fun `fails for Null`() {
        // given
        val obj = "test"

        // when
        val result = expectsException<AssertionError> {
            obj mustSatisfy {
                it mustBe Null
            }
        }

        // then
        assertEquals("Expecting object to be null, but it's not.", result.message)
    }

    @Test
    fun `succeeds for Null`() {
        // given
        val obj: String? = null

        // when
        obj mustSatisfy {
            it mustBe Null
        }
    }
}