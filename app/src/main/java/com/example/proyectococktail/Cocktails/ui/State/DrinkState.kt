package com.example.proyectococktail.Cocktails.ui.State

/**
 * Esta clase de datos representa el estado de un cóctel.
 * @param idDrink el ID del cóctel.
 * @param strDrink el nombre del cóctel.
 * @param strAlcoholic el tipo de alcohol del cóctel.
 * @param strInstructions las instrucciones para preparar el cóctel.
 * @param strDrinkThumb la URL de la imagen del cóctel.
 * @param strIngredient1 el primer ingrediente del cóctel.
 * @param strIngredient2 el segundo ingrediente del cóctel.
 * @param strIngredient3 el tercer ingrediente del cóctel.
 * @param strIngredient4 el cuarto ingrediente del cóctel.
 * @param strIngredient5 el quinto ingrediente del cóctel.
 * @param strIngredient6 el sexto ingrediente del cóctel.
 * @param strIngredient7 el séptimo ingrediente del cóctel.
 * @param strIngredient8 el octavo ingrediente del cóctel.
 * @param strIngredient9 el noveno ingrediente del cóctel.
 * @param strIngredient10 el décimo ingrediente del cóctel.
 * @param strIngredient11 el undécimo ingrediente del cóctel.
 * @param strIngredient12 el duodécimo ingrediente del cóctel.
 * @param strIngredient13 el decimotercer ingrediente del cóctel.
 * @param strIngredient14 el decimocuarto ingrediente del cóctel.
 * @param strIngredient15 el decimoquinto ingrediente del cóctel.
 */
data class drinkState(
    val idDrink: String = "",
    val strDrink: String = "",
    val strAlcoholic: String,
    val strInstructions: String? = "",
    val strDrinkThumb: String? = "",
    val strIngredient1: String? = "",
    val strIngredient2: String? = "",
    val strIngredient3: String? = "",
    val strIngredient4: String? = "",
    val strIngredient5: String? = "",
    val strIngredient6: String? = "",
    val strIngredient7: String? = "",
    val strIngredient8: String? = "",
    val strIngredient9: String? = "",
    val strIngredient10: String? = "",
    val strIngredient11: String? = "",
    val strIngredient12: String? = "",
    val strIngredient13: String? = "",
    val strIngredient14: String? = "",
    val strIngredient15: String? = ""
)
