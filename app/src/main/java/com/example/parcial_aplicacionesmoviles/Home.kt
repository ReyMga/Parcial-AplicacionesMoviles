package com.example.parcial_aplicacionesmoviles

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    navController: NavController,
) {
    var saldo by remember { mutableStateOf(5000000.0) }
    var inputMonto by remember { mutableStateOf("") }
    var invalido by remember { mutableStateOf(false) }


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
                    title = { Text("Billetera Express Istea", color = MaterialTheme.colorScheme.onBackground) }
                )
            },
            containerColor = MaterialTheme.colorScheme.background
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    "Saldo actual: $%.2f".format(saldo),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                OutlinedTextField(
                    value = inputMonto,
                    onValueChange = {
                        inputMonto = it
                        invalido = false
                    },
                    label = { Text("Monto a retirar") },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = MaterialTheme.typography.bodyLarge,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                        focusedLabelColor = MaterialTheme.colorScheme.primary,
                        unfocusedLabelColor = MaterialTheme.colorScheme.onSurface,
                        cursorColor = MaterialTheme.colorScheme.primary
                    )
                )

                Button(
                    onClick = {
                        val monto = inputMonto.toDoubleOrNull()
                        if (monto != null && monto > 0 && monto <= saldo) {
                            saldo -= monto
                            navController.navigate("comprobante/$monto/$saldo")
                            inputMonto = ""
                        } else {
                            invalido = true
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text("Retirar")
                }

                if (invalido) {
                    Text("Monto inválido", color = MaterialTheme.colorScheme.error)
                }
            }
        }
    }
}
