package io.github.ccjhr

import io.github.ccjhr.throwable.expectsException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class UtilityFunctionsKtTest {

    internal class ExpectNotNullTests {

        @Test
        fun `throw exception if object is null`() {
            // given
            val obj: Int? = null

            // when
            val result = expectsException<AssertionError> {
                expectNotNull(obj)
            }

            // then
            assertEquals("Object under test is null.", result.message)
        }

        @Test
        fun `returns the object if it is not null`() {
            // given
            val obj = 4

            // when
            val result = expectNotNull(obj)

            // then
            assertEquals(result, 4)
        }
    }

    internal class InstanceStringTests {

        @Test
        fun `correctly generate a string referencing an object instance`() {
            // given
            val obj = "test"

            // when
            val result = instanceString(obj)

            // then
            assertTrue(Regex("kotlin\\.String@\\d+").matches(result))
        }
    }
}