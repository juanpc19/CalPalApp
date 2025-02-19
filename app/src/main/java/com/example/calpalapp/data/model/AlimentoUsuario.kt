package com.example.calpalapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlimentoUsuario(
    @SerialName("id_alimento") val idAlimento: String,
    @SerialName("id_usu") val idUsu: String,
    val nombre: String,
    val tipo: String,
    @SerialName("cantidad_gramos") val cantidadGramos: Int,
    val calorias: Float,
    val proteinas: Float,
    val carbohidratos: Float,
    val grasas: Float,
    @SerialName("info_adicional") val infoAdicional: String
)
