package com.example.calpalapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Usuario(
    @SerialName("id_usuario") val idUsuario: String,  // Mapeo de _id a idUsuario en Kotlin
    @SerialName("hashed_password") val hashedPassword: String,
    val email: String,
    @SerialName("email_verificado") val emailVerificado: Boolean,
    val objetivos: Map<String, Float>,  // Usamos Map en lugar de Dict
    val comidas: Map<String, Int>,
    val sexo: String,
    val altura: Int,
    val peso: Float,
    val edad: Int,
    @SerialName("nivel_actividad") val nivelActividad: Int
)