package com.example.proyectococktail.Cocktails.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Button

import com.example.proyectococktail.Cocktails.Model.Routes

@Composable
fun ScreenHome(navController: NavController, viewModel: Viewmodel){
    LaunchedEffect(Unit){

    }


    Column {
        OutlinedTextField(
            value = viewModel.cocktailName,
            onValueChange = { viewModel.changeNameCocktail(it) },
            label = { Text(text = "Busqueda por nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            shape = RoundedCornerShape(50.dp)
        )

        Button(onClick = {
            viewModel.getName(viewModel.cocktailName)
            navController.navigate(Routes.screen3.Route)
        }) {
            Text(text = "Margarita",
                modifier = Modifier.width(200.dp))

        }

        Button(onClick = {
            /*navController.navigate(Routes.ViewConktailUser.Route)*/
        },
            modifier = Modifier.width(200.dp)) {
            Text(text = "UserCocktail")

        }

        Button(onClick = {
            viewModel.getRandom()
            /*navController.navigate(Routes.Random.Route)*/
        },
            modifier = Modifier.width(200.dp)) {
            Text(text = "Random")

        }
    }
}