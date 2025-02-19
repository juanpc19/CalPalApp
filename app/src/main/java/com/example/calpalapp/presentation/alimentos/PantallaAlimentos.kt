package com.example.calpalapp.presentation.alimentos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.calpalapp.R
import com.example.calpalapp.presentation.utils.navigation.PantallaDetallesAlimento
import com.example.calpalapp.presentation.utils.components.BottomBar
import com.example.calpalapp.presentation.utils.components.SearchBar
import com.example.calpalapp.ui.theme.CalPalAppTheme




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Alimentos(navController: NavController) {

    var mostrarPass by remember { mutableStateOf(false) }
    mostrarPass = false
    var pass by remember { mutableStateOf("ejemplo123") }
    var passconfirmada by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) } // Estado del menú desplegable
    data class Alimento(val id: String, val titulo: String, val descripcion: String) {

    }
    val dummyData = List(50) { index ->
        Alimento(id = index.toString(), titulo = "Título $index", descripcion = "Descripción del elemento $index")
    }
    val alimentos = remember { mutableStateListOf(*dummyData.toTypedArray()) }

    //si opcion 1 seleciconada no se despliega menu de o contrario lo despliego y permito acciones extras
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Alimentos") },
                actions = {
                    IconButton(onClick = { expanded = !expanded }) { // Alterna el estado del menú
                        Icon(Icons.Default.MoreVert, contentDescription = "Más opciones")
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Detalles") },
                            onClick = {
                                expanded = false
                                // Acción para la opción 1
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Editar") },
                            onClick = {
                                expanded = false
                                // Acción para la opción 2
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Eliminar") },
                            onClick = {
                                expanded = false
                                // Acción para la opción 3
                            }
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = "Add rutina")
            }
        },
        bottomBar = { BottomBar(navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.1f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable { }
                            .background(Color.LightGray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Alimentos", color = Color.Black)
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable { }
                            .background(Color.Gray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Mis alimentos", color = Color.White)
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.1f)
                ) {
                    SearchBar(texto = "...")
                }
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp) // Espacio entre elementos
                ) {
                    items(alimentos, key = { it.id }) { item ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .background(Color.LightGray) // Color de fondo mientras carga
                                .clip(RoundedCornerShape(12.dp))
                                .clickable { navController.navigate(PantallaDetallesAlimento(item.id)) }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground), // Cambia por tu imagen
                                contentDescription = "Imagen de fondo",
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp)
                                    .background(Color.Black.copy(alpha = 0.4f)) // Oscurece para mejor lectura
                            ) {
                                Text(
                                    text = item.titulo,
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = item.descripcion, color = Color.White, fontSize = 14.sp)
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
fun AlimentosPreview() {
    CalPalAppTheme {
        val navController = rememberNavController()
        Alimentos(navController)
    }
}