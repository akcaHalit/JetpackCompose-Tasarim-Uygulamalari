package com.halitakca.jetpackcomposetasarim.sayitahminapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.halitakca.jetpackcomposetasarim.R

@Composable
fun SonucEkrani(navController: NavController,sonuc: Boolean){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(sonuc){
            Text(text = "Kazandınız", fontSize = 36.sp)
            Image(painter = painterResource(id = R.drawable.baseline_mood_24), contentDescription = "" )
        }else{
            Text(text = "Kaybettiniz", fontSize = 36.sp)
            Image(painter = painterResource(id = R.drawable.moodbad_image), contentDescription = "" )
        }

    }
}