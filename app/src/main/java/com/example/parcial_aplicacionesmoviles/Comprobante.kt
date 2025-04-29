package com.example.parcial_aplicacionesmoviles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComprobanteView(monto: Double, saldo: Double) {

    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Color(0xFFBB86FC),
            onPrimary = Color.Black,
            background = Color(0xFF121212),
            onBackground = Color.White,
            surface = Color(0xFF1F1B24),
            onSurface = Color.White,
            error = Color.Red
        )
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Comprobante", color = MaterialTheme.colorScheme.onBackground) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                )
            },
            containerColor = MaterialTheme.colorScheme.background
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    "✅ Retiro exitoso",
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onBackground)
                )
                Text(
                    "Monto retirado: $%.2f".format(monto),
                    style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onBackground)
                )
                Text(
                    "Saldo actual: $%.2f".format(saldo),
                    style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onBackground)
                )
            }
        }
    }
}