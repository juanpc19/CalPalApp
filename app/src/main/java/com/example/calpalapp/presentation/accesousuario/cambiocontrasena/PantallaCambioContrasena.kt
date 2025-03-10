package com.example.calpalapp.presentation.accesousuario.cambiocontrasena

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.calpalapp.ui.theme.CalPalAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CambioContrasena(navController: NavController) {

    var mostrarPass by remember { mutableStateOf(false) }
    mostrarPass = false
    var pass by remember { mutableStateOf("ejemplo123") }
    var passconfirmada by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cambio de Contraseña") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth(0.9f)
                        .border(1.dp, Color.Black, shape = RoundedCornerShape(16.dp))
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Establece tu nueva contraseña. Asegúrate de que contenga entre X y X caracteres," +
                                        " al menos un carácter especial, una mayúscula y una minúscula.",
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        Row(
                            modifier = Modifier.padding(5.dp)
                        ) {
                            TextField(value = pass,
                                onValueChange = {},
                                label = { Text("Contraseña") },
                                visualTransformation = if (mostrarPass) VisualTransformation.None else PasswordVisualTransformation(),
                                trailingIcon = {
                                    val icon =
                                        if (mostrarPass) Icons.Default.VisibilityOff else Icons.Default.Visibility
                                    IconButton(onClick = { mostrarPass = !mostrarPass }) {
                                        Icon(
                                            imageVector = icon,
                                            contentDescription = "Mostrar/ocultar contraseña"
                                        )
                                    }
                                }
                            )
                        }
                        Row(
                            modifier = Modifier.padding(5.dp)
                        ) {
                            TextField(value = pass,
                                onValueChange = {},
                                label = { Text("Confirmar contraseña") },
                                visualTransformation = if (mostrarPass) VisualTransformation.None else PasswordVisualTransformation(),
                                trailingIcon = {
                                    val icon =
                                        if (mostrarPass) Icons.Default.VisibilityOff else Icons.Default.Visibility
                                    IconButton(onClick = { mostrarPass = !mostrarPass }) {
                                        Icon(
                                            imageVector = icon,
                                            contentDescription = "Mostrar/ocultar contraseña"
                                        )
                                    }
                                }
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Button(onClick = { }) {
                                Text(text = "Cambiar contraseña")
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CambioContrasenaPreview() {
    CalPalAppTheme {
        val navController = rememberNavController()
        CambioContrasena(navController)
    }
}