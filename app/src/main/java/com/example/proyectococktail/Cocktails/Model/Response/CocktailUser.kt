package com.example.proyectococktail.Cocktails.Model.Response

data class CocktailUser(
    val emailUser: String,
    val idDrink: String,
    val strDrink: String,
    val strAlcoholic: String,
    val strInstructions: String,
    val strDrinkThumb: String,
    val strList: MutableList<String>
)
