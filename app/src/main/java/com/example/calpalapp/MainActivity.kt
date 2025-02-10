package com.example.calpalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calpalapp.core.navigation.RutasPantallas
import com.example.calpalapp.presentation.accesousuario.iniciosesion.InicioSesion
import com.example.calpalapp.presentation.accesousuario.registro.Registro
import com.example.calpalapp.ui.theme.CalPalAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalPalAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = RutasPantallas.PantallaInicioSesion.route
                    ) {
                        composable(route = RutasPantallas.PantallaInicioSesion.route) {
                            InicioSesion(navController = navController)
                        }
                        composable(route = RutasPantallas.PantallaRegistro.route) {
                            Registro(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
