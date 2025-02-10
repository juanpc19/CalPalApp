package com.example.calpalapp.presentation.componentes

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.calpalapp.core.navigation.RutasPantallas
import com.example.calpalapp.ui.theme.CalPalAppTheme

//Barra inferior de navegacion, contiene iconos con clickeables que haran navegacion
@Composable
fun BottomBar(navController: NavController) {

    BottomAppBar() {
        Spacer(modifier = Modifier.weight(0.5f))
        IconButton(onClick = { navController.navigate(RutasPantallas.PantallaRegistroDiario.route) }) {
            Icon(Icons.Default.Home, contentDescription = "Boton navegacion carga registro diario")
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { navController.navigate(RutasPantallas.PantallaMisAlimentos.route) }) {
            Icon(Icons.Default.FormatListNumbered, contentDescription = "Boton navegacion mis alimentos")
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { navController.navigate(RutasPantallas.PantallaCalculadora.route) }) {
            Icon(Icons.Default.Lock, contentDescription = "Boton navegacion calculadora")
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { navController.navigate(RutasPantallas.PantallaHistorialRegistros.route) }) {
            Icon(Icons.Default.DateRange, contentDescription = "Boton navegacion historial registros")
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { navController.navigate(RutasPantallas.PantallaPerfil.route) }) {
            Icon(Icons.Default.AccountCircle, contentDescription = "Boton navegacion perfil")
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}

@Preview()
@Composable
fun BottomBarPreview() {
    CalPalAppTheme {
        val navController = rememberNavController()
        BottomBar(navController)
    }
}