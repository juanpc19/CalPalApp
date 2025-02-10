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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.calpalapp.R
import com.example.calpalapp.core.navigation.RutasPantallas
import com.example.calpalapp.ui.theme.CalPalAppTheme

@Composable
fun Registro(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(5.dp),
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
            modifier = Modifier
                .padding(5.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(5.dp)
            ) {
                TextField(value = "Email", onValueChange = {})
            }

            Row(
                modifier = Modifier
                    .padding(5.dp)
            ) {
                TextField(value = "Contraseña", onValueChange = {})
                Icon(imageVector = Icons.Filled.Visibility, contentDescription = "a" )
                //Icon(imageVector = Icons.Filled.VisibilityOff, contentDescription = "a" )
            }
            Row(
                modifier = Modifier
                    .padding(5.dp).background(color = Color.Gray)
            ) {
                TextField(value = "Confirmar contraseña", onValueChange = {}, )
                Icon(imageVector = Icons.Filled.Visibility, contentDescription = "a" )
                //Icon(imageVector = Icons.Filled.VisibilityOff, contentDescription = "a" )
            }
            Row(
                modifier = Modifier
                    .padding(5.dp)
            ) {
                Button(onClick = {}) {
                    Text(text = "Registrar")
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
                    annotation = RutasPantallas.PantallaRegistro.route,
                    start = start,
                    end = end
                )
            }
            Text(
                text = annotatedString,
                modifier = Modifier.clickable {
                    navController.navigate(RutasPantallas.PantallaRegistro.route)
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