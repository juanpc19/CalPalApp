package com.example.calpalapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComidaRegistro(
    @SerialName("id_comida") val idComida: String,
    @SerialName("id_reg") val idReg: String,
    val orden: Int,
    val nombre: String,
    @SerialName("cantidad_gramos") val cantidadGramos: Int,
    val calorias: Float,
    val proteinas: Float,
    val carbohidratos: Float,
    val grasas: Float,
)

