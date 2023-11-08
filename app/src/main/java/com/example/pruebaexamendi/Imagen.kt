package com.example.pruebaexamendi

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pruebaexamendi.ui.theme.Purple40

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Imagen(navControllerName:String, navControllerImagen: Int, navController: NavHostController){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val textContacto = navBackStackEntry?.arguments?.getString("textoContacto") ?: ""
    val imagenContacto = navBackStackEntry?.arguments?.getInt("imagenContacto") ?: 0
    Box (Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd){
        FloatingActionButton(
            onClick = {
                navController.navigate("Contacto")
            },
            shape = CircleShape,
            containerColor = Purple40,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
                .height(50.dp)
                .width(50.dp))
        {

            Icon(imageVector = Icons.Filled.Check, contentDescription = "check" )
        }

    }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 60.dp),horizontalArrangement = Arrangement.Center)
    {
        Text(
            text = textContacto,
            fontSize = 32.sp,
            color = Color.Black,
        )
       /* Image(
            painter = painterResource(id = imagenContacto),
            contentDescription = null
        )*/
    }
}