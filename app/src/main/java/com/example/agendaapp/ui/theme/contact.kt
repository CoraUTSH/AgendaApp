package com.example.agendaapp.ui.theme


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

//@Preview
@Composable
fun Contacts(body:String){
    Column() {
       // Image(painter = , contentDescription = )
        Row(
            modifier = Modifier.fillMaxWidth()
        ){


        }
        Text(text = "Soy un TExto")
        Text(text = "Body: $body")
        
    }
}