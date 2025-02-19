package com.example.calpalapp.presentation.alimentos

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.calpalapp.ui.theme.CalPalAppTheme

@Composable
fun DetallesAlimento(navController: NavController, id: String) {

    Text(text = id.toString())

}


@Preview(showBackground = true)
@Composable
fun DetallesAlimentoPreview() {
    CalPalAppTheme {
        val navController = rememberNavController()
        DetallesAlimento(navController, "5")
    }
}