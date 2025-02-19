package com.example.calpalapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Token(
@SerialName("id_token") val idToken: String,
@SerialName("id_usu") val idUsu: String,
@SerialName("token_jwt") val tokenJwt: String,
)
