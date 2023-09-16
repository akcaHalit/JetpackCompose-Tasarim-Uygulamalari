package com.halitakca.jetpackcomposetasarim

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailPage(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Köfte") },
                backgroundColor = colorResource(id = R.color.anaRenkTuruncu),
                contentColor = Color.White
            )
        },
        content = {

        }
    )
}