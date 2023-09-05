package com.example.myapplication.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.composables.NavBar
import com.example.myapplication.navigation.Routes
import com.example.myapplication.navigation.Routes.*
import com.example.myapplication.paging.PagingViewData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: PagingViewData) {
    val navController = rememberNavController()
    val navigationsItems = listOf(
        Home,
        Register,
        List
    )
    Scaffold(
        bottomBar = { NavBar(navController = navController, items = navigationsItems) }
    ) {
        NavigationHost(navController, viewModel)
    }
}


@Composable
fun NavigationHost(navController: NavHostController, viewModel: PagingViewData){

    NavHost(
        navController = navController,
        startDestination = Home.route
    ) {
        composable(Home.route){
            HomeScreen()
        }
        composable(Register.route){
            RegisterScreen(viewModel)
        }
        composable(Routes.List.route){
            ListScreen()
        }
    }
}