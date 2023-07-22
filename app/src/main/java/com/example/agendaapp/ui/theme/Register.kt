package com.example.agendaapp.ui.theme
import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agendaapp.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Registrar Contactos",
                        modifier = Modifier.fillMaxWidth(),
                        color = colorResource(id = R.color.TextWhite),
                        fontWeight = FontWeight.Bold,
                        fontSize = 23.sp,
                        letterSpacing = 2.sp,
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colorResource(id = R.color.verdeUT))
            )
        },
    ) {
        RegisterBody(navController)
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterBody(navController: NavController)
//  onButtonClick:(String)->Unit
{
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Inicia-Formulario
        var nombre by remember { mutableStateOf("") }
        var apellidos by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var matricula by remember { mutableStateOf("") }
        val espacio = 20.dp
        val context = LocalContext.current
        val db = Firebase.firestore

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
                .background(color = Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                "Registro UTSH", fontSize = 28.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(espacio))
            TextField(
                value = matricula, onValueChange = { matricula = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                ),
                label = { Text(text = "Matricula") },
                // modifier = Modifier.fillMaxWidth(),
                singleLine = true,
            )


            Spacer(modifier = Modifier.height(espacio))
            TextField(
                value = nombre, onValueChange = { nombre = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                ),
                label = { Text(text = "Nombre") },
                // modifier = Modifier.fillMaxWidth(),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(espacio))
            TextField(
                value = apellidos, onValueChange = { apellidos = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                ),
                label = { Text(text = "Apellidos") },
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(espacio))
            TextField(
                value = email, onValueChange = { email = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                ),
                label = { Text(text = "Email") },
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(25.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    modifier = Modifier.padding(),
                    onClick = {
                       // val datos =matricula + " " + nombre + " " + apellidos + " Tu email es " + email
                        Toast.makeText(context, "Contacto registrado", Toast.LENGTH_SHORT).show()
                        //onButtonClick(datos)
                        // Create a new user with a first and last name
                        val user = hashMapOf(
                            "Matricula" to matricula,
                            "Nombre" to nombre,
                            "Apellidos" to apellidos,
                            "Email" to email
                        )
// Add a new document with a generated ID
                        db.collection("Contactos")
                            .add(user)
                            .addOnSuccessListener { documentReference ->
                                Log.d(
                                    ContentValues.TAG,
                                    "DocumentSnapshot added with ID: ${documentReference.id}"
                                )
                            }
                            .addOnFailureListener { e ->
                                Log.w(ContentValues.TAG, "Error adding document", e)
                            }
                    })
                {
                    Text(text = "Enviar")

                }
                Spacer(modifier = Modifier.height(25.dp))
                Button(onClick = {
                    db.collection("users")
                        .get()
                        .addOnSuccessListener { result ->
                            for (document in result) {
                                Log.d(ContentValues.TAG, "${document.id} => ${document.data}")
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(ContentValues.TAG, "Error getting documents.", exception)
                        }
                    // onButtonClick("Datos")

                }) {
                    Text(text = "Ver Contactos")
                }
            }
        }
    }
}
/*
@Preview
@Composable
fun RegisterPreview() {
    Register()
}*/