package com.dewarder.messenger.domain.login

data class CheckEmailResult(
        val exist: Boolean,
        val email: String
)