package com.example.agendaapp.Navigation


sealed class AppScreen(val route: String) {
    object Register:AppScreen(route="register")
    object Contact:AppScreen(route="contact")
    object SplashScreen:AppScreen(route="splash")
}