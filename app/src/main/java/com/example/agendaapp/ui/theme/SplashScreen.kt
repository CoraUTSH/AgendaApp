package com.example.agendaapp.ui.theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agendaapp.Navigation.AppScreen
import com.example.agendaapp.R
import kotlinx.coroutines.delay
@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(key1 = true,){
        delay(3000)
        navController.popBackStack()
        navController.navigate(AppScreen.Contact.route)
    }
    SplashBody()
}
@Composable
fun SplashBody(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logoutshtransparente) ,
            contentDescription ="Logo UTSH",
            modifier = Modifier.size(200.dp,200.dp)
        )
        Spacer(
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = "Bienvenid@\nUTSH",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

}
/*@Preview(showBackground = true)
@Composable
fun SplashPreview(){
    SplashScreen()

}*/