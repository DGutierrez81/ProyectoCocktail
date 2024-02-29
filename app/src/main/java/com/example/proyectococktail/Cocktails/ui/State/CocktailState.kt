package com.example.proyectococktail.Cocktails.ui.State

/**
 * Esta clase de datos representa el estado de una lista de cócteles.
 * @param drinks una lista de objetos drinkState que representan los cócteles.
 */
data class CocktailState(
    val drinks: List<drinkState>? = emptyList()
)

