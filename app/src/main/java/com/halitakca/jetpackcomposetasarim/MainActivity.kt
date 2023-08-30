package com.halitakca.jetpackcomposetasarim

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.halitakca.jetpackcomposetasarim.ui.theme.JetpackComposeTasarimTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTasarimTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Sayfa()
                }
            }
        }
    }
}

@Composable
fun Sayfa(){
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.primary) {

        val tfKullaniciAdi = remember { mutableStateOf("") }
        val tfSifre = remember { mutableStateOf("") }

        Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
            TextField(
                value = tfKullaniciAdi.value,
                onValueChange = {tfKullaniciAdi.value = it},
                label = { Text(text = "Kullanıcı Adı: ")},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    focusedIndicatorColor = Color.Red
                )
            )

            TextField(
                value = tfSifre.value,
                onValueChange = {tfSifre.value = it},
                label = { Text(text = "Şifre: ")},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    focusedIndicatorColor = Color.Red
                )
            )
            
            Button(onClick = { Log.e("Giriş", "${tfKullaniciAdi.value}-${tfSifre.value} giriş yaptı") },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            ),
            modifier = Modifier.size(250.dp,50.dp)) {
                Text(text = "Giriş Yap")
            }

        }
    }
}

/*          İLHAM VER
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Sayfa(){
    Scaffold(
        topBar ={
                TopAppBar(title ={
                    Text(text = "İlham Ver") },
                    backgroundColor = colorResource(id = R.color.anaRenk),
                    contentColor = colorResource(id = R.color.white)
                )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(id = R.drawable.stevejobs),
                        contentDescription = "")
                    Text(text = "Steve Jobs", color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }
                Text(text = "Dünyayı değiştirecek insanlar, onu değiştirebileceklerini düşünecek kadar çılgın olanlardır.",
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Center)

                Button(onClick = { Log.e("Button","İlham verildi")},
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Red,
                    contentColor = Color.White
                )) {
                    Text(text = "İLHAM VER")
                }
            }
        }
    )
}
 */
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTasarimTheme {
        Sayfa()
    }
}

/*
package com.halitakca.jetpackcomposetasarim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.halitakca.jetpackcomposetasarim.ui.theme.JetpackComposeTasarimTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTasarimTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTasarimTheme {
        Greeting("Android")
    }
}
 */