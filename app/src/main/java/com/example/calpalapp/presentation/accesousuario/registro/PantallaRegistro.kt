package com.example.calpalapp.presentation.accesousuario.registro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.calpalapp.R
import com.example.calpalapp.presentation.utils.navigation.PantallaInicioSesion
import com.example.calpalapp.ui.theme.CalPalAppTheme

@Composable
fun Registro(navController: NavController) {

    var mostrarPass by remember { mutableStateOf(false) }
    mostrarPass = false
    var pass by remember { mutableStateOf("ejemplo123") }
    var passconfirmada by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(5.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Image(
                (painterResource(id = R.drawable.ic_launcher_foreground)),
                contentDescription = "imagen",
                modifier = Modifier.background(Color.Blue)
            )
        }
        Column(
            modifier = Modifier.padding(5.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(5.dp)
            ) {
                TextField(value = "Email", onValueChange = {})
            }
            Row(
                modifier = Modifier.padding(5.dp)
            ) {
                TextField(value = pass, onValueChange = {}, label = { Text("Contraseña") },
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
                modifier = Modifier.padding(5.dp)
            ) {
                Button(onClick = {}) {
                    Text(text = "Registrarme")
                }
            }
        }
        Row {
            val annotatedString = buildAnnotatedString {
                append("¿Ya estás registrado? ")
                val start = length
                append("Inicia sesión")
                val end = length
                addStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline
                    ),
                    start = start,
                    end = end
                )
                addStringAnnotation(
                    tag = "NAVIGATION",
                    annotation = "PantallaInicioSesion",
                    start = start,
                    end = end
                )
            }
            Text(
                text = annotatedString,
                modifier = Modifier.clickable {
                    navController.navigate(PantallaInicioSesion)
                }
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun RegistroPreview() {
    CalPalAppTheme {
        val navController = rememberNavController()
        Registro(navController)
    }
}