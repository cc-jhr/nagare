package io.github.ccjhr.samples.throwable

import java.lang.NullPointerException

private fun expectsException() {
    // given
    val obj: String? = null

    // then
    val result = expectsException<NullPointerException> {
        obj!!.length
    }
}

private fun hasMessage() {
    // then
    val result = expectsException<NullPointerException> {
        throw NullPointerException("message here")
    }

    // then
    result mustSatisfy {
        it hasMessage "message here"
    }
}