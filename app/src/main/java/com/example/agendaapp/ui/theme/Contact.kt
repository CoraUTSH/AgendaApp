package com.example.agendaapp.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agendaapp.R

//@Preview
@Composable
fun Contacts(navController: NavController){
    ContactsBody(navController)

}
@Composable
fun ContactsBody(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(5.dp),


    ) {
        Text(text = "Agregar un contacto +",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(top=10.dp)
        )
        Spacer(modifier=Modifier.size(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .border(1.dp, color = Color.Gray)
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically

        ){
            Image(
                painter = painterResource(id = R.drawable.laura_flores),
                contentDescription = "Imagen foto",
                modifier = Modifier.size(75.dp,75.dp)

            )
            Column(
                modifier =Modifier.fillMaxWidth()
                    .padding(2.dp),

            ) {
                Text(text = "Juan Torres Torres",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 3.dp, start = 5.dp)

                )
                Text(text = "7712121212",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(bottom = 3.dp, start = 5.dp))
                Text(text = "JuanTorres@gmail.com",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(bottom = 3.dp, start = 5.dp)
                    )
                
            }


        }


    }
}

/*@Preview(showBackground = true)
@Composable
fun ContactsPreview(){
    Contacts()

}*/