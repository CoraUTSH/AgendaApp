package com.example.agendaapp.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.agendaapp.R

//@Preview
@Composable
fun Contacts(){
    ContactsBody()

}
@Composable
fun ContactsBody(){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .border(1.dp, color = Color.Gray)
                .padding(5.dp)

        ){
            Image(
                painter = painterResource(id = R.drawable.logoutshtransparente),
                contentDescription = "Imagen foto",
                modifier = Modifier.size(52.dp,52.dp)

            )
            Column(
                modifier =Modifier.fillMaxWidth()
                    .padding(2.dp)
            ) {
                Text(text = "Juan Torres Torres")
                Text(text = "7712121212")
                Text(text = "JuanTorres@gmail.com")
                
            }


        }


    }
}

@Preview(showBackground = true)
@Composable
fun ContactsPreview(){
    Contacts()

}