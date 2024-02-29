package com.example.proyectococktail.Cocktails.ui.State

/**
 * Esta clase de datos representa el estado de un cóctel para un usuario específico.
 * @param emailUser el correo electrónico del usuario.
 * @param idDrink el ID del cóctel.
 * @param strDrink el nombre del cóctel.
 * @param strAlcoholic el tipo de alcohol del cóctel.
 * @param strInstructions las instrucciones para preparar el cóctel.
 * @param strDrinkThumb la URL de la imagen del cóctel.
 * @param strList una lista mutable de los ingredientes del cóctel.
 */
data class CocktailUserState(
    val emailUser: String = "",
    val idDrink: String = "",
    val strDrink: String = "",
    val strAlcoholic: String = "",
    val strInstructions: String = "",
    val strDrinkThumb: String = "",
    val strList: MutableList<String> = mutableListOf()
)
