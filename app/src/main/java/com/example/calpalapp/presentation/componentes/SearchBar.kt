package com.example.calpalapp.presentation.componentes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calpalapp.ui.theme.CalPalAppTheme

@Composable
fun SearchBar(texto: String) {
    Row {
        TextField(value = texto,
            onValueChange = {},
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Boton de busqueda"
                    )
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    val texto: String = "Kiwi"
    CalPalAppTheme { SearchBar(texto) }
}