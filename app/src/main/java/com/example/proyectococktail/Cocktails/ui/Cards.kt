package com.example.proyectococktail.Cocktails.ui

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.proyectococktail.Cocktails.Model.Routes
import com.example.proyectococktail.home.jollyLodger

@Composable
fun Cards(navController: NavController, viewModel: Viewmodel){
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Scaffold (
            topBar = {
                Column {
                    Cabecera(navController, viewModel)
                    viewModel.Head(viewModel.number)
                }
            },
            bottomBar = { Box(
                Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .background(color = Color(0xFF45413C)),
                contentAlignment = Alignment.Center) {
                Text(text = "Add favorites", fontFamily = jollyLodger, color = Color(0xFFFF01FB), fontSize = 36.sp, modifier = Modifier.clickable { viewModel.saveNewCocktail() { Toast.makeText(context, "Cocktail guardado correctamente", Toast.LENGTH_SHORT).show()
                    navController.popBackStack() }  })
            }
            }
        ){innerPadding ->
            Box(Modifier.fillMaxSize().background(color = Color(0xFF45413C))) {
                Card(
                    border = BorderStroke(10.dp, Color(0xFF00F5D4)),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    shape = RoundedCornerShape(50.dp)

                ){
                    Image(
                        painter = rememberImagePainter(viewModel.drink.strDrinkThumb),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )

                    LazyColumn(
                        modifier = Modifier.background(Color.White)
                    ){
                        item{
                            viewModel.drink.strDrink?.let {
                                Text(text = it,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    textAlign = TextAlign.Center)
                            }
                            viewModel.drink.strInstructions?.let {
                                Text(text = it,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    textAlign = TextAlign.Center)
                            }
                            Text(text = "Ingredients:\n${viewModel._ingredient2}",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp),
                                textAlign = TextAlign.Center)
                        }
                    }
                }
            }

        }
/*

Modifier.background(color = Color(0xFF45413C))
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

 */

        Button(onClick = { navController.navigate(Routes.ScreenHome.Route)
            viewModel.mostrar()}) {
            Text(text = "volver")
        }
    }
}