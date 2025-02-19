package com.example.calpalapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegistroDiario(
    @SerialName("id_registro") val idRegistro: String,
    @SerialName("id_usu") val idUsu: String,
    val fecha: String,
    val peso: Float,
    val calorias: Float,
    val proteinas: Float,
    val carbohidratos: Float,
    val grasas: Float
)

