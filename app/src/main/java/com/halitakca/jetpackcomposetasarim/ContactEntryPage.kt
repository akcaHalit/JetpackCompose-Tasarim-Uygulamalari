package com.halitakca.jetpackcomposetasarim

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ContactEntryPage(navController: NavController){
    val tfContactName = remember { mutableStateOf("") }
    val tfContactPhone = remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current

    
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Contacts Entry") })
        },
        content = {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
                TextField(
                    value = tfContactName.value,
                    onValueChange = {tfContactName.value = it},
                    label = { Text(text = "Contact Name")})
                TextField(
                    value = tfContactPhone.value,
                    onValueChange = {tfContactPhone.value = it},
                    label = { Text(text = "Contact Phone")})
                
                Button(onClick = {
                    val contactName = tfContactName.value
                    val contactPhone = tfContactPhone.value
                    Log.e("Contact Entry","$contactName - $contactPhone")

                    localFocusManager.clearFocus()
                }, modifier = Modifier.size(250.dp,50.dp)){
                    Text(text = "SAVE")
                }
            }
        }
    )
}