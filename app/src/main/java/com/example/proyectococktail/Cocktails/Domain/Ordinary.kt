package com.example.proyectococktail.Cocktails.Domain

import com.example.proyectococktail.Cocktails.Model.Repository
import com.example.proyectococktail.Cocktails.ui.State.CocktailState
import javax.inject.Inject

class Ordinary @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): CocktailState {
        return repository.vCocktailOrdinary()
    }
}