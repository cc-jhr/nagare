package io.github.ccjhr

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.test.fail

/**
 * Checks if an object is `null`. If the object is not `null` then kotlin contract implies that the object is not.
 * @since 2.0.0
 * @param obj Object being checked for `null`.
 * @return The unmodified object.
 * @throws AssertionError in case the object is `null`.
 */
@OptIn(ExperimentalContracts::class)
fun <T : Any> expectNotNull(obj: T?): T {
    contract {
        returns() implies (obj != null)
    }

    if (obj == null) {
        fail("Object under test is null.")
    } else {
        return obj
    }
}

/**
 * Creates [String] showing the instance.
 * @since 2.0.0
 * @param obj Object for which the instance string should be created.
 * @return A [String] representing the instance.
 */
fun <T : Any> instanceString(obj: T): String = "${obj::class.qualifiedName}@${System.identityHashCode(obj)}"