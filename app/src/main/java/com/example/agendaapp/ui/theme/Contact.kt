package com.example.agendaapp.ui.theme


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agendaapp.Navigation.AppScreen
import com.example.agendaapp.R

//@Preview
@Composable
fun Contacts(navController: NavController) {
    ContactsBody(navController)

}

@Composable
fun ContactsBody(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
    ) {
        TextButton(onClick = {
            navController.navigate(AppScreen.Register.route)
        }) {
            Text(
                text = "Agregar un contacto +",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )

        }
        Spacer(modifier = Modifier.size(20.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            item {
                ContactInfo()
            }
        }
    }
}
@Composable
fun ContactInfo(){
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                Toast
                    .makeText(context, "diste Click", Toast.LENGTH_SHORT)
                    .show()
            },
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Image(
            painter = painterResource(id = R.drawable.laura_flores),
            contentDescription = "Imagen foto",
            modifier = Modifier
                .size(75.dp, 75.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),

            ) {
            Text(
                text = "Juan Torres Torres",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 3.dp, start = 5.dp)
            )
            Text(
                text = "7712121212",
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 3.dp, start = 5.dp)
            )
            Text(
                text = "JuanTorres@gmail.com",
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 3.dp, start = 5.dp)
            )
        }
    }
    Divider(
        modifier=Modifier.padding(3.dp),
        color = Color.LightGray
    )
}

/*@Preview(showBackground = true)
@Composable
fun ContactsPreview(){
    Contacts()

}*/