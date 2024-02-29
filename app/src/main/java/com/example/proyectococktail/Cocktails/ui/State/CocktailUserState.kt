package com.example.proyectococktail.Cocktails.ui.State

data class CocktailUserState(
    val emailUser: String = "",
    val idDrink: String = "",
    val strDrink: String = "",
    val strAlcoholic: String = "",
    val strInstructions: String = "",
    val strDrinkThumb: String = "",
    val strList: MutableList<String> = mutableListOf()
)