package com.route.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForgotPasswordRequest(

    @SerialName("email")
    val email: String
)
