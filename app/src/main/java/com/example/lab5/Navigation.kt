package com.example.lab5

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab5.calculateDamages.DamagesView
import com.example.lab5.compareReliability.ReliabilityView

@Composable
fun NavigationApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main"){
        composable("main") { HomeView(navController = navController) }
        composable("compareReliability") { ReliabilityView() }
        composable("calculateDamages") { DamagesView() }
    }
}