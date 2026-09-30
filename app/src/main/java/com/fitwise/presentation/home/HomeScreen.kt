package com.fitwise.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fitwise.ui.theme.GreenPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = { FitWiseBottomNavigation(selectedTab) { selectedTab = it } }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item { Spacer(modifier = Modifier.height(10.dp)) }

            // Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "¡Hola, Víctor! 👋",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Listo para tu mejor versión hoy.",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notificaciones")
                    }
                }
            }

            // Resumen diario
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = GreenPrimary)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Resumen diario", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            MetricItem("🔥 1.850", "Calorías objetivo")
                            MetricItem("🏋️ 1/6", "Entrenamientos")
                            MetricItem("🎯 70%", "Meta semanal")
                        }
                    }
                }
            }

            // Rutina del día
            item {
                Column {
                    Text("Rutina del día", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    ElevatedCard(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Pecho y Tríceps", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                            Text("Gimnasio • 6 ejercicios", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 14.sp)
                            Spacer(modifier = Modifier.height(12.dp))
                            Button(
                                onClick = { },
                                colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text("Ver rutina", color = Color.Black, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            // Accesos rápidos
            item {
                Column {
                    Text("Accesos rápidos", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        QuickAccessItem("Entrenamiento", Icons.Default.PlayArrow)
                        QuickAccessItem("Nutrición", Icons.Default.ShoppingCart)
                        QuickAccessItem("Ejercicios", Icons.Default.List)
                        QuickAccessItem("Progreso", Icons.Default.DateRange)
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(10.dp)) }
        }
    }
}

@Composable
fun MetricItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(label, fontSize = 11.sp, color = Color.DarkGray)
    }
}

@Composable
fun QuickAccessItem(title: String, icon: ImageVector) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(75.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.size(56.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(icon, contentDescription = title, tint = Color.Black)
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(title, fontSize = 11.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun FitWiseBottomNavigation(selectedIndex: Int, onSelect: (Int) -> Unit) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
        NavigationBarItem(
            selected = selectedIndex == 0,
            onClick = { onSelect(0) },
            icon = { Icon(Icons.Default.Home, "Inicio") },
            label = { Text("Inicio") }
        )
        NavigationBarItem(
            selected = selectedIndex == 1,
            onClick = { onSelect(1) },
            icon = { Icon(Icons.Default.PlayArrow, "Entrenar") },
            label = { Text("Entrenar") }
        )
        NavigationBarItem(
            selected = selectedIndex == 2,
            onClick = { onSelect(2) },
            icon = { Icon(Icons.Default.ShoppingCart, "Nutrición") },
            label = { Text("Nutrición") }
        )
        NavigationBarItem(
            selected = selectedIndex == 3,
            onClick = { onSelect(3) },
            icon = { Icon(Icons.Default.DateRange, "Progreso") },
            label = { Text("Progreso") }
        )
        NavigationBarItem(
            selected = selectedIndex == 4,
            onClick = { onSelect(4) },
            icon = { Icon(Icons.Default.Person, "Perfil") },
            label = { Text("Perfil") }
        )
    }
}
