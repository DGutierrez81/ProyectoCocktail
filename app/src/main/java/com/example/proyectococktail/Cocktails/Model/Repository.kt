package com.example.proyectococktail.Cocktails.Model

import com.example.proyectococktail.Cocktails.Model.Response.Cocktail
import com.example.proyectococktail.Cocktails.Model.Response.DrinksInfo
import com.example.proyectococktail.Cocktails.ui.State.CocktailState
import com.example.proyectococktail.Cocktails.ui.State.drinkState
import javax.inject.Inject

class Repository @Inject constructor(private val api: CocktailsView) {
    suspend fun vCocktail(name: String): CocktailState {
        //return api.vCocktail()
        val response = api.getCocktail(name)
        return if(response.isSuccessful){
            response.body()?.getDrink() ?: CocktailState()
        }else {
            CocktailState()
        }
    }

    suspend fun vCocktailRandom(): CocktailState{
        //return api.vCocktail()
        val response = api.getRandom()
        return if(response.isSuccessful){
            response.body()?.getDrink() ?: CocktailState()
        }else {
            CocktailState()
        }
    }

    suspend fun vCocktailAlcoholic(): CocktailState{
        //return api.vCocktail()
        val response = api.getAlcoholics()
        return if(response.isSuccessful){
            response.body()?.getDrink() ?: CocktailState()
        }else {
            CocktailState()
        }
    }

    suspend fun vCocktailNoAlcoholic(): CocktailState{
        //return api.vCocktail()
        val response = api.getNoAlcoholics()
        return if(response.isSuccessful){
            response.body()?.getDrink() ?: CocktailState()
        }else {
            CocktailState()
        }
    }

    suspend fun vCocktailOrdinary(): CocktailState{
        //return api.vCocktail()
        val response = api.getOrdinary()
        return if(response.isSuccessful){
            response.body()?.getDrink() ?: CocktailState()
        }else {
            CocktailState()
        }
    }

    suspend fun vCocktailChampagne(): CocktailState{
        //return api.vCocktail()
        val response = api.getGlassChampagne()
        return if(response.isSuccessful){
            response.body()?.getDrink() ?: CocktailState()
        }else {
            CocktailState()
        }
    }

    suspend fun vCocktailGlass(): CocktailState{
        //return api.vCocktail()
        val response = api.getGlassCocktail()
        return if(response.isSuccessful){
            response.body()?.getDrink() ?: CocktailState()
        }else {
            CocktailState()
        }
    }



    private fun Cocktail.getDrink(): CocktailState{
        return CocktailState(
            drinks = this.drinks.map { it.getDrinkState() }
        )
    }

    private fun DrinksInfo.getDrinkState(): drinkState {
        return drinkState(
            idDrink = this.idDrink ?: "vacio",
            strDrink = this.strDrink ?: "vacio",
            strAlcoholic =this.strAlcoholic ?: "vacio",
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
            strIngredient11= this.strIngredient11 ?: "vacio",
            strIngredient12 = this.strIngredient12 ?: "vacio",
            strIngredient13 = this.strIngredient13 ?: "vacio",
            strIngredient14 = this.strIngredient14 ?: "vacio",
            strIngredient15 = this.strIngredient15 ?: "vacio",
        )
    }
}