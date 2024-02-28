package com.example.proyectococktail.Cocktails.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectococktail.Cocktails.Model.Routes
import com.example.proyectococktail.home.Home
import com.example.proyectococktail.logito.Logito
import com.example.proyectococktail.lupa.Lupa
import com.example.proyectococktail.seefaoritespie.SeefaoritesPie


@Composable
fun ScreenHome(navController: NavController, viewModel: Viewmodel){
    LaunchedEffect(Unit){

    }

    Scaffold (
        topBar = {Cabecera(navController, viewModel)},
        bottomBar = {Pie()}
    ){innerPadding ->
        Home(Modifier.padding(innerPadding))
    }
}


@Composable
fun Cabecera(navController: NavController, viewModel: Viewmodel) {
    Box(
        Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF45413C))
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Logito(Modifier.padding(5.dp))
            TextField(
                value = viewModel.cocktailName,
                onValueChange = { viewModel.changeNameCocktail(it) },
                label = { Text(text = "Busqueda por nombre") },
                modifier = Modifier
                    .padding(5.dp)
                    .background(color = Color.White)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF00F5D4)
                    ),
                shape = RoundedCornerShape(100.dp)
            )

            Lupa(Modifier.padding(5.dp).size(30.dp, 30.dp)) {
                viewModel.getName(viewModel.cocktailName)
                navController.navigate(Routes.screen3.Route)
                viewModel.changeNameCocktail("")
            }
        }
    }
}

@Composable
fun Pie(){
    Box(
        Modifier
            .fillMaxWidth()
            .height(75.dp)
    ) {
        SeefaoritesPie(Modifier.fillMaxWidth()) {}
    }
}