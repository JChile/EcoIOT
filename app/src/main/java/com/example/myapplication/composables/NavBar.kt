package com.example.myapplication.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.myapplication.navigation.Routes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun CurrentRoute(navController: NavController):String?{
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route

}

@Composable
fun NavBar(
    navController: NavController,
    items: List<Routes>
) {
    val currentRoute = CurrentRoute(navController)
    BottomNavigation(

    ) {
        items.forEach{screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
                label = { Text(screen.title!!) },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon!!),
                        contentDescription = "a"
                    )
                },
                unselectedContentColor = Color.White,
                selectedContentColor = Color.Green,

                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}



