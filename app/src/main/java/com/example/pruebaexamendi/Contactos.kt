package com.example.pruebaexamendi

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contactos(navHostController: NavHostController){
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        topBar = { MyTopAppBar(navHostController = navHostController) },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ){
        Box(modifier = Modifier.padding(top = it.calculateTopPadding())) {
            LazyColumn {
                items(getContacto()) { lazy ->
                    ItemContacto(contacto = lazy, navHostController)
                }
            }
        }

    }



}

data class Contacto(
    var name:String,
    var image :Int
)

fun getContacto(): List<Contacto> {
    return listOf(
        Contacto(
            "Maria Mata",
            R.drawable.image1
        ),
        Contacto(
            "Antonio Sanz",
            R.drawable.image2
        ),
        Contacto(
            "Carlos Pérez",
            R.drawable.image3
        ),
        Contacto(
            "Beatriz Martos",
            R.drawable.image4
        ),
        Contacto(
            "Rodrigo Gimernez",
            R.drawable.image5
        ),
        Contacto(
            "Pedro García",
            R.drawable.image6
        ),
        Contacto(
            "Ramon Dopico",
            R.drawable.image7
        ),
        Contacto(
            "Gimena Roto",
            R.drawable.image8
        ),
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemContacto(contacto: Contacto,navHostController: NavHostController) {
    val peso = 1f
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                navHostController.navigate("Imagen/${contacto.name}/${contacto.image}")
            }
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row (modifier = Modifier
            .weight(peso)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Image(
                painter = painterResource(id = contacto.image),
                contentDescription = "Game Image",
                //modifier = Modifier.size(170.dp)
            )
        }

        Column (modifier = Modifier
            .weight(peso)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = contacto.name)
        }
    }


}