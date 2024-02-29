package com.example.proyectococktail.Cocktails.Model.Response

/**
 * Esta clase de datos representa un objeto de cóctel, que contiene una lista de información sobre bebidas.
 * @param drinks la lista de información sobre bebidas.
 */
data class Cocktail(
    val drinks: List<DrinksInfo>?
)

