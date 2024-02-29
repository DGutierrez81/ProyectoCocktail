package com.example.proyectococktail.Cocktails.Model

import com.example.proyectococktail.Cocktails.Model.Response.Cocktail
import com.example.proyectococktail.Cocktails.Model.Response.DrinksInfo
import com.example.proyectococktail.Cocktails.ui.State.CocktailState
import com.example.proyectococktail.Cocktails.ui.State.drinkState
import javax.inject.Inject

/**
 * Esta clase representa un repositorio que se encarga de interactuar con la API de CocktailsView.
 * @param api la interfaz de la API de CocktailsView.
 */
class Repository @Inject constructor(private val api: CocktailsView) {
    /**
     * Esta función suspendida obtiene y devuelve el estado de un cóctel específico por su nombre.
     * @param name el nombre del cóctel a buscar.
     * @return el estado del cóctel específico.
     */
    suspend fun vCocktail(name: String): CocktailState {
        // Se realiza la llamada a la API para obtener el cóctel específico por su nombre.
        val response = api.getCocktail(name)
        return if (response.isSuccessful) { // Si la respuesta es exitosa:
            response.body()?.getDrink() ?: CocktailState() // Se convierte el cuerpo de la respuesta en un estado de cóctel, o se devuelve un estado vacío si es nulo.
        } else { // Si la respuesta no es exitosa:
            CocktailState() // Se devuelve un estado de cóctel vacío.
        }
    }


    /**
     * Esta función suspendida obtiene y devuelve el estado de un cóctel aleatorio.
     * @return el estado de un cóctel aleatorio.
     */
    suspend fun vCocktailRandom(): CocktailState {
        // Se realiza la llamada a la API para obtener un cóctel aleatorio.
        val response = api.getRandom()
        return if (response.isSuccessful) { // Si la respuesta es exitosa:
            response.body()?.getDrink() ?: CocktailState() // Se convierte el cuerpo de la respuesta en un estado de cóctel, o se devuelve un estado vacío si es nulo.
        } else { // Si la respuesta no es exitosa:
            CocktailState() // Se devuelve un estado de cóctel vacío.
        }
    }


    /**
     * Esta función suspendida obtiene y devuelve el estado de los cócteles alcohólicos.
     * @return el estado de los cócteles alcohólicos.
     */
    suspend fun vCocktailAlcoholic(): CocktailState {
        // Se realiza la llamada a la API para obtener los cócteles alcohólicos.
        val response = api.getAlcoholics()
        return if (response.isSuccessful) { // Si la respuesta es exitosa:
            response.body()?.getDrink() ?: CocktailState() // Se convierte el cuerpo de la respuesta en un estado de cóctel, o se devuelve un estado vacío si es nulo.
        } else { // Si la respuesta no es exitosa:
            CocktailState() // Se devuelve un estado de cóctel vacío.
        }
    }


    /**
     * Esta función suspendida obtiene y devuelve el estado de los cócteles sin alcohol.
     * @return el estado de los cócteles sin alcohol.
     */
    suspend fun vCocktailNoAlcoholic(): CocktailState {
        // Se realiza la llamada a la API para obtener los cócteles sin alcohol.
        val response = api.getNoAlcoholics()
        return if (response.isSuccessful) { // Si la respuesta es exitosa:
            response.body()?.getDrink() ?: CocktailState() // Se convierte el cuerpo de la respuesta en un estado de cóctel, o se devuelve un estado vacío si es nulo.
        } else { // Si la respuesta no es exitosa:
            CocktailState() // Se devuelve un estado de cóctel vacío.
        }
    }


    /**
     * Esta función suspendida obtiene y devuelve el estado de los cócteles ordinarios.
     * @return el estado de los cócteles ordinarios.
     */
    suspend fun vCocktailOrdinary(): CocktailState {
        // Se realiza la llamada a la API para obtener los cócteles ordinarios.
        val response = api.getOrdinary()
        return if (response.isSuccessful) { // Si la respuesta es exitosa:
            response.body()?.getDrink() ?: CocktailState() // Se convierte el cuerpo de la respuesta en un estado de cóctel, o se devuelve un estado vacío si es nulo.
        } else { // Si la respuesta no es exitosa:
            CocktailState() // Se devuelve un estado de cóctel vacío.
        }
    }


    /**
     * Esta función suspendida obtiene y devuelve el estado de los cócteles filtrados por tipo de vaso (champán).
     * @return el estado de los cócteles filtrados por tipo de vaso (champán).
     */
    suspend fun vCocktailChampagne(): CocktailState {
        // Se realiza la llamada a la API para obtener los cócteles filtrados por tipo de vaso (champán).
        val response = api.getGlassChampagne()
        return if (response.isSuccessful) { // Si la respuesta es exitosa:
            response.body()?.getDrink() ?: CocktailState() // Se convierte el cuerpo de la respuesta en un estado de cóctel, o se devuelve un estado vacío si es nulo.
        } else { // Si la respuesta no es exitosa:
            CocktailState() // Se devuelve un estado de cóctel vacío.
        }
    }


    /**
     * Esta función suspendida obtiene y devuelve el estado de los cócteles filtrados por tipo de vaso.
     * @return el estado de los cócteles filtrados por tipo de vaso.
     */
    suspend fun vCocktailGlass(): CocktailState {
        // Se realiza la llamada a la API para obtener los cócteles filtrados por tipo de vaso.
        val response = api.getGlassCocktail()
        return if (response.isSuccessful) { // Si la respuesta es exitosa:
            response.body()?.getDrink() ?: CocktailState() // Se convierte el cuerpo de la respuesta en un estado de cóctel, o se devuelve un estado vacío si es nulo.
        } else { // Si la respuesta no es exitosa:
            CocktailState() // Se devuelve un estado de cóctel vacío.
        }
    }



    /**
     * Esta función convierte un objeto de tipo `Cocktail` en un estado de cóctel (`CocktailState`).
     * @return el estado de cóctel generado a partir del objeto `Cocktail`.
     */
    private fun Cocktail.getDrink(): CocktailState {
        return CocktailState(
            drinks = this.drinks?.map { it.getDrinkState() } // Se mapean los cócteles del objeto Cocktail a estados individuales de cóctel.
        )
    }

    /**
     * Esta función convierte un objeto de tipo `DrinksInfo` en un estado de bebida (`drinkState`).
     * @return el estado de bebida generado a partir del objeto `DrinksInfo`.
     */
    private fun DrinksInfo.getDrinkState(): drinkState {
        return drinkState(
            idDrink = this.idDrink ?: "vacio",
            strDrink = this.strDrink ?: "vacio",
            strAlcoholic = this.strAlcoholic ?: "vacio",
            strInstructions = this.strInstructions ?: "vacio",
            strDrinkThumb = this.strDrinkThumb ?: "vacio",
            strIngredient1 = this.strIngredient1 ?: "vacio",
            strIngredient2 = this.strIngredient2 ?: "vacio",
            strIngredient3 = this.strIngredient3 ?: "vacio",
            strIngredient4 = this.strIngredient4 ?: "vacio",
            strIngredient5 = this.strIngredient5 ?: "vacio",
            strIngredient6 = this.strIngredient6 ?: "vacio",
            strIngredient7 = this.strIngredient7 ?: "vacio",
            strIngredient8 = this.strIngredient8 ?: "vacio",
            strIngredient9 = this.strIngredient9 ?: "vacio",
            strIngredient10 = this.strIngredient10 ?: "vacio",
            strIngredient11 = this.strIngredient11 ?: "vacio",
            strIngredient12 = this.strIngredient12 ?: "vacio",
            strIngredient13 = this.strIngredient13 ?: "vacio",
            strIngredient14 = this.strIngredient14 ?: "vacio",
            strIngredient15 = this.strIngredient15 ?: "vacio"
        )
    }
}