package com.example.parcial_aplicacionesmoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.parcial_aplicacionesmoviles.ui.theme.ParcialAplicacionesMovilesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            Surface(color = MaterialTheme.colorScheme.background) {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeView(navController)
                    }
                    composable("comprobante/{monto}/{saldo}") { backStack ->
                        val monto = backStack.arguments?.getString("monto")?.toDoubleOrNull() ?: 0.0
                        val saldo = backStack.arguments?.getString("saldo")?.toDoubleOrNull() ?: 0.0
                        ComprobanteView(monto, saldo)
                    }
                }
            }
        }
    }
}