package com.example.agendaapp.Navigation

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.agendaapp.ui.theme.Contacts
import com.example.agendaapp.ui.theme.Register
import com.example.agendaapp.ui.theme.SplashScreen

@Composable
fun AppNavigation(){
    var navController= rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.SplashScreen.route,){
        composable(route=AppScreen.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(route = AppScreen.Contact.route){
            Contacts(navController)
        }
        composable(route=AppScreen.Register.route){
            Register(navController)
        }

    }
}