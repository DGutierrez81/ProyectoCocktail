package com.example.proyectococktail.Cocktails.Model.Response

/**
 * Esta clase de datos representa información sobre una bebida, como un cóctel.
 * @param idDrink el ID de la bebida.
 * @param strDrink el nombre de la bebida.
 * @param strAlcoholic la indicación de si la bebida es alcohólica.
 * @param strInstructions las instrucciones para preparar la bebida.
 * @param strDrinkThumb la URL de la imagen de la bebida.
 * @param strIngredient1 el primer ingrediente de la bebida.
 * @param strIngredient2 el segundo ingrediente de la bebida.
 * @param strIngredient3 el tercer ingrediente de la bebida.
 * @param strIngredient4 el cuarto ingrediente de la bebida.
 * @param strIngredient5 el quinto ingrediente de la bebida.
 * @param strIngredient6 el sexto ingrediente de la bebida.
 * @param strIngredient7 el séptimo ingrediente de la bebida.
 * @param strIngredient8 el octavo ingrediente de la bebida.
 * @param strIngredient9 el noveno ingrediente de la bebida.
 * @param strIngredient10 el décimo ingrediente de la bebida.
 * @param strIngredient11 el undécimo ingrediente de la bebida.
 * @param strIngredient12 el duodécimo ingrediente de la bebida.
 * @param strIngredient13 el decimotercer ingrediente de la bebida.
 * @param strIngredient14 el decimocuarto ingrediente de la bebida.
 * @param strIngredient15 el decimoquinto ingrediente de la bebida.
 */
data class DrinksInfo(
    val idDrink: String?,
    val strDrink: String?,
    val strAlcoholic: String?,
    val strInstructions: String?,
    val strDrinkThumb: String?,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?
)

