package com.example.myapplication.navigation

import com.example.myapplication.R

sealed class Routes (
    val route: String,
    val title: String,
    val icon: Int? = null
    ) {
    object Home: Routes(route = "home", title = "Home", icon = R.drawable.baseline_home)
    object Register: Routes("register", title = "Registros", icon = R.drawable.baseline_location)
    object List: Routes("list", title = "Lista", icon = R.drawable.baseline_view)

    object Detail: Routes("detail/{deviceId}", title = "Detalle")
    object Create: Routes("create", title = "Crear")


}