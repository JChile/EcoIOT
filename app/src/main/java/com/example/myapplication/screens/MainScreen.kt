package com.example.myapplication.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.composables.NavBar
import com.example.myapplication.navigation.Routes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navigationsItems = listOf(
        Routes.Home,
        Routes.Register,
    )
    Scaffold(
        bottomBar = { NavBar(navController = navController, items = navigationsItems) }
    ) {
        NavigationHost(navController = navController)
    }
}


@Composable
fun NavigationHost(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route){

        }
        composable(Routes.Register.route){
            
        }
    }
}