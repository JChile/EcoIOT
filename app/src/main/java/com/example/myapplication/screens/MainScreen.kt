package com.example.myapplication.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.R
import com.example.myapplication.composables.NavBar
import com.example.myapplication.container.ContainerViewData
import com.example.myapplication.navigation.Routes
import com.example.myapplication.navigation.Routes.*
import com.example.myapplication.paging.PagingViewData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: PagingViewData, viewModel2: ContainerViewData) {
    val navController = rememberNavController()
    val navigationsItems = listOf(
        Home,
        Register,
        List
    )
    Scaffold(
        bottomBar = { NavBar(navController = navController, items = navigationsItems) }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.bg_iot),
                contentDescription = "Background",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            NavigationHost(navController, viewModel, viewModel2)

        }
    }
}


@Composable
fun NavigationHost(navController: NavHostController, viewModel: PagingViewData, viewModel2: ContainerViewData){

    NavHost(
        navController = navController,
        startDestination = Home.route
    ) {
        composable(Home.route){
            HomeScreen(navController)
        }
        composable(Register.route){
            RegisterScreen(viewModel, navController)
        }
        composable(Routes.List.route){
            ListScreen()
        }
        composable(
            route = Routes.Detail.route,
            arguments = listOf(
                navArgument("deviceId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val deviceId = backStackEntry.arguments?.getString("deviceId")
            deviceId?.let {
                DetailScreen(deviceId, viewModel2)
            }
        }
        composable(Routes.Create.route){
            CreateContainer()
        }
    }
}