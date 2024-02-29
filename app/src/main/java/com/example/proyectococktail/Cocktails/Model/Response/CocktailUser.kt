package com.example.proyectococktail.Cocktails.Model.Response

/**
 * Esta clase de datos representa un cóctel asociado a un usuario.
 * @param emailUser el correo electrónico del usuario asociado al cóctel.
 * @param idDrink el ID del cóctel.
 * @param strDrink el nombre del cóctel.
 * @param strAlcoholic la indicación de si el cóctel es alcohólico.
 * @param strInstructions las instrucciones para preparar el cóctel.
 * @param strDrinkThumb la URL de la imagen del cóctel.
 * @param strList una lista mutable de ingredientes del cóctel.
 */
data class CocktailUser(
    val emailUser: String,
    val idDrink: String,
    val strDrink: String,
    val strAlcoholic: String,
    val strInstructions: String,
    val strDrinkThumb: String,
    val strList: MutableList<String>
)

