package com.halitakca.jetpackcomposetasarim.sayitahminapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TahminEkrani(navController: NavController){
    val tfTahmin = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Kalan Hak : 4", fontSize = 35.sp, color = Color.Red)
        Text(text = "Yardım: Arttır")
        TextField(value = tfTahmin.value,
            onValueChange = {tfTahmin.value = it},
            label = { Text(text = "Tahmin") }
        )

        Button(onClick = {
            navController.navigate("sonuc_ekrani/false"){
                popUpTo("tahmin_ekrani"){ inclusive = true}
            }

        }, modifier = Modifier.size(250.dp,50.dp)) {
            Text(text = "TAHMİN ET")
        }
    }
}
