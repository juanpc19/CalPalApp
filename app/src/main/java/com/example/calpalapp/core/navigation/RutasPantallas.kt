package com.example.calpalapp.core.navigation

sealed class RutasPantallas (val route: String){
    object PantallaRegistro : RutasPantallas("pantallaregistro")
    object PantallaInicioSesion : RutasPantallas("pantallainiciosesion")
    object PantallaCambioContrasena : RutasPantallas("pantallacambiocontrasena")
    object PantallaRegistroDiario : RutasPantallas("pantallaregistrodiario")
    object PantallaInsercionAlimentoRegistro: RutasPantallas("pantallainsercionalimentoRegistro")
    object PantallaMisAlimentos : RutasPantallas("pantallamisalimentos")
    object PantallaCalculadora : RutasPantallas("pantallacalculadora")
    object PantallaHistorialRegistros : RutasPantallas("pantallahistorialregistros")
    object PantallaPerfil : RutasPantallas("pantallaperfil")
}