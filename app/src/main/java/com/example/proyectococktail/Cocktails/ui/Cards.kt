package com.example.proyectococktail.Cocktails.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.proyectococktail.Cocktails.Model.Routes

@Composable
fun Cards(navController: NavController, viewModel: Viewmodel){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Card(
            border = BorderStroke(2.dp, Color.Red),
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)

        ){
            Image(
                painter = rememberImagePainter(viewModel.drink.strDrinkThumb),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )

            LazyColumn(
                modifier = Modifier.background(Color.White)
            ){
                item{
                    viewModel.drink.strDrink?.let {
                        Text(text = it,
                            modifier = Modifier.fillMaxWidth()
                                .padding(5.dp),
                            textAlign = TextAlign.Center)
                    }
                    viewModel.drink.strInstructions?.let {
                        Text(text = it,
                            modifier = Modifier.fillMaxWidth()
                                .padding(5.dp),
                            textAlign = TextAlign.Center)
                    }
                    Text(text = "Ingredients:\n${viewModel._ingredient}",
                        modifier = Modifier.fillMaxWidth()
                            .padding(5.dp),
                        textAlign = TextAlign.Center)
                }
            }
        }

        Button(onClick = { navController.navigate(Routes.ScreenHome.Route)
            viewModel.mostrar()}) {
            Text(text = "volver")
        }
    }
}