package com.halitakca.jetpackcomposetasarim

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.halitakca.jetpackcomposetasarim.entity.Foods
import com.halitakca.jetpackcomposetasarim.sayitahminapp.SonucEkrani
import com.halitakca.jetpackcomposetasarim.sayitahminapp.TahminEkrani
import com.halitakca.jetpackcomposetasarim.ui.theme.JetpackComposeTasarimTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTasarimTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    SayfaGecisleri()
                }
            }
        }
    }
}

@Composable
fun SayfaGecisleri(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa"){
        composable("anasayfa"){
            AnaSayfa(navController = navController)
        }
        composable("tahmin_ekrani"){
            TahminEkrani(navController = navController)
        }
        composable("sonuc_ekrani/{sonuc}", arguments = listOf(
            navArgument("sonuc"){type = NavType.BoolType}
        )){
            val sonuc = it.arguments?.getBoolean("sonuc")!!
            SonucEkrani(navController = navController, sonuc = sonuc)

        }
    }
}
@Composable
fun AnaSayfa(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "TAHMİN ET", fontSize = 36.sp)
        Image(painter = painterResource(id = R.drawable.zar_resim), contentDescription = "")
        Button(onClick = {
            navController.navigate("tahmin_ekrani")
        }, modifier = Modifier.size(250.dp,50.dp)) {
            Text(text = "OYUNA BAŞLA")
        }
    }
}






/*
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TestPage(){

    Scaffold(
        topBar = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .size(50.dp)
                .background(color = Color.LightGray),
            horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "Halit AKCA",modifier = Modifier.padding(5.dp), color = Color.Black)
                Text(text = "AAAAAAAAA", modifier = Modifier.padding(5.dp), color = Color.Black)
                Text(text = "BBBBBBBBB",modifier = Modifier.padding(5.dp), color = Color.Black)
            }
        },
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Magenta)
            ) {
                Spacer(modifier = Modifier.fillMaxWidth().size(10.dp))
                Image(painter = painterResource(id = R.drawable.logo), contentDescription = "", modifier = Modifier.fillMaxWidth())
            }
        }
    )
}
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomePage(){
    val foodList = remember { mutableStateListOf<Foods>() }
    
    LaunchedEffect(key1 = true){
        val y1 = Foods(1,"Köfte","kofte",15)
        val y2 = Foods(2,"Ayran","ayran",2)
        val y3 = Foods(3,"Fanta","fanta",3)
        val y4 = Foods(4,"Makarna","makarna",14)
        val y5 = Foods(5,"Kadayıf","kafayıf",8)
        val y6 = Foods(6,"Baklava","baklava",15)

        foodList.add(y1)
        foodList.add(y2)
        foodList.add(y3)
        foodList.add(y4)
        foodList.add(y5)
        foodList.add(y6)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Foods")},
                backgroundColor = colorResource(id = R.color.anaRenkTuruncu),
                contentColor = Color.White
            )
        },
        content = {
            LazyColumn{
                items(
                    count = foodList.count(),
                    itemContent = {
                        val food = foodList[it]
                        Card(modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()) {
                            Row(modifier = Modifier.clickable {

                            }) {
                                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()) {
                                    val activity = (LocalContext.current as Activity)
                                    Image(bitmap = ImageBitmap.imageResource(id = activity.resources.getIdentifier(
                                        food.food_image_name,"drawable",activity.packageName
                                    ) ), contentDescription = "", modifier = Modifier.size(100.dp))
                                }
                            }
                        }
                    }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTasarimTheme {
        SayfaGecisleri()
    }
}


/*          Contacts App

package com.halitakca.jetpackcomposetasarim

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.halitakca.jetpackcomposetasarim.entity.Contacts
import com.halitakca.jetpackcomposetasarim.ui.theme.JetpackComposeTasarimTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTasarimTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    SayfaGecisleri()
                }
            }
        }
    }
}


@Composable
fun SayfaGecisleri(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homepage"){
        composable("homepage"){
            HomePage(navController)
        }
        composable("contact_detail_page/{contact}",
            arguments = listOf(
            navArgument("contact"){type = NavType.StringType},
            )
        ){
            val json = it.arguments?.getString("contact")
            val obj = Gson().fromJson(json,Contacts::class.java)
            ContactDetailPage(navController = navController, contact = obj)
        }
        composable("contact_entry_page"){
            ContactEntryPage(navController = navController)
        }
    }
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomePage(navController:NavController){
    val isSearching = remember { mutableStateOf(false) }
    val tf = remember { mutableStateOf("") }
    val contactList = remember { mutableStateListOf<Contacts>() }

    LaunchedEffect(key1 = true) {
        val k1 = Contacts(1, "Halit", "2002")
        val k2 = Contacts(2, "Osman", "1997")

        contactList.add(k1)
        contactList.add(k2)

    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (isSearching.value){
                        TextField(
                            value = tf.value,
                            onValueChange = {
                                tf.value = it
                                Log.e("Contact Searching",it)
                                            },
                            label = { Text(text = "Search")},
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.Transparent,
                                focusedLabelColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                unfocusedIndicatorColor = Color.White,
                                unfocusedLabelColor = Color.White
                            )
                        )

                    }else{
                        Text(text = "Contacts")
                    }
                        },
                actions = {
                    if (isSearching.value){
                        IconButton(onClick = {
                            isSearching.value = false
                            tf.value = ""
                        }) {
                            Icon(painter = painterResource(id = R.drawable.search_image), tint = Color.White, contentDescription = "")
                        }
                    }else{
                        IconButton(onClick = {
                            isSearching.value = true
                        }) {
                            Icon(painter = painterResource(id = R.drawable.search_image), tint = Color.White, contentDescription = "")
                        }
                    }

                }
            )
        },
        content = {
            LazyColumn{
                items(
                    count = contactList.count(),
                    itemContent = {
                        val contact = contactList[it]
                        println("Contact: ${contact.contact_name}")
                        Card(modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()){
                            Row(modifier = Modifier.clickable {
                                val contactJson = Gson().toJson(contact)
                                navController.navigate("contact_detail_page/$contactJson")
                            }) {
                                Row(modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                                    Text(text = "${contact.contact_name} - ${contact.contact_phone}")
                                    Icon(painter = painterResource(id = R.drawable.delete_image), contentDescription = "", tint = Color.Gray)
                                }
                            }
                        }
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("contact_entry_page") },
            backgroundColor = colorResource(id = R.color.teal_200),
            content = {
                Icon(painter = painterResource(id = R.drawable.add_image), contentDescription = "desc", tint = Color.White)
            })
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTasarimTheme {
        SayfaGecisleri()
    }
}

 */


/*
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Sayfa(){
    Scaffold(
        topBar = {
            TopAppBar(title ={
                Text(text = "Yemek Tarifi") },
                backgroundColor = colorResource(id = R.color.anaRenkTuruncu),
                contentColor = colorResource(id = R.color.black)
            )
        },
        content = {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
                Image(painter = painterResource(id = R.drawable.yemekresim), contentDescription = "")
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { Log.e("Beğen Button", "Beğen Butonu tıklandı") },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.anaRenkTuruncu),
                        ),
                        modifier = Modifier.weight(50f)
                    ) {
                        Text("BEĞEN")
                    }
                    Button(onClick = { Log.e("Yorum Yap Button", "Yorum Butonu tıklandı") },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.alternatifRenk),
                        ),
                        modifier = Modifier.weight(50f)
                    ) {
                        Text("YORUM YAP")
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)) {
                    Text(text = "Köfte", color = colorResource(id = R.color.alternatifRenk), fontSize = 18.sp)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Izgaraya Uygun")
                        Text(text = "7 Haziran")
                    }
                }
                Text(text = "Köfte harcını hazırlamak için, soğanları rendeleyin ve maydonozları ince ince kıyın. İsterseniz bir diş sarımsak da ekleyebilirsiniz.",
                    modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Center)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTasarimTheme {
        Sayfa()
    }
}
 */
/*          Login Uygulaması

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

*/

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