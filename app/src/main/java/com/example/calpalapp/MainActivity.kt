package com.example.calpalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.calpalapp.core.navigation.PantallaAlimentos
import com.example.calpalapp.core.navigation.PantallaCalculadora
import com.example.calpalapp.core.navigation.PantallaCambioContrasena
import com.example.calpalapp.core.navigation.PantallaDetallesAlimento
import com.example.calpalapp.core.navigation.PantallaHistorialRegistros
import com.example.calpalapp.core.navigation.PantallaInicioSesion
import com.example.calpalapp.core.navigation.PantallaPedirCambioContrasena
import com.example.calpalapp.core.navigation.PantallaPerfil
import com.example.calpalapp.core.navigation.PantallaRegistro
import com.example.calpalapp.core.navigation.PantallaRegistroDiario
import com.example.calpalapp.presentation.accesousuario.cambiocontrasena.CambioContrasena
import com.example.calpalapp.presentation.accesousuario.cambiocontrasena.PedirCambioContrasena
import com.example.calpalapp.presentation.accesousuario.iniciosesion.InicioSesion
import com.example.calpalapp.presentation.accesousuario.registro.Registro
import com.example.calpalapp.presentation.alimentos.Alimentos
import com.example.calpalapp.presentation.alimentos.DetallesAlimento
import com.example.calpalapp.ui.theme.CalPalAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalPalAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val context = LocalContext.current
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = PantallaInicioSesion,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<PantallaInicioSesion> {
                            InicioSesion(navController = navController)
                        }
                        composable<PantallaRegistro> {
                            Registro(navController = navController)
                        }
                        composable<PantallaAlimentos> {
                            Alimentos(navController = navController)
                        }
                        composable<PantallaDetallesAlimento> { backStackEntry ->
                            val pantallaDetallesAlimento = backStackEntry.toRoute<PantallaDetallesAlimento>()
                            DetallesAlimento(navController = navController, pantallaDetallesAlimento.id)
                        }
                        composable<PantallaPedirCambioContrasena> {
                            PedirCambioContrasena(navController = navController)
                        }
                        composable<PantallaCambioContrasena> {
                            CambioContrasena(navController = navController)
                        }
                        composable<PantallaRegistroDiario> {
                            PedirCambioContrasena(navController = navController)
                        }
                        composable<PantallaCalculadora> {
                            CambioContrasena(navController = navController)
                        }
                        composable<PantallaHistorialRegistros> {
                            PedirCambioContrasena(navController = navController)
                        }
                        composable<PantallaPerfil> {
                            CambioContrasena(navController = navController)
                        }


                    }
                }
            }
        }
    }
}
