package com.example.calpalapp.presentation.utils.navigation

import kotlinx.serialization.Serializable

@Serializable
object PantallaInicioSesion
@Serializable
object PantallaRegistro
@Serializable
object PantallaAlimentos
@Serializable
object PantallaPedirCambioContrasena
@Serializable
object PantallaCambioContrasena
@Serializable
object PantallaRegistroDiario
@Serializable
object PantallaCalculadora
@Serializable
object PantallaHistorialRegistros
@Serializable
object PantallaPerfil

@Serializable
data class PantallaDetallesAlimento(val id: String)
//data class PantallaDetallesAlimento2(val id: Int?)