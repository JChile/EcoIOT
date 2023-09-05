package com.example.myapplication.navigation

sealed class Routes (val route: String) {
    object Home: Routes("home")
    object Options: Routes("options")
    object ListRegisters: Routes("list_registers")
}