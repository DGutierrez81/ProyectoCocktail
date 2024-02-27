package com.example.proyectococktail.Cocktails.Domain

import com.example.proyectococktail.Cocktails.Model.Repository
import com.example.proyectococktail.Cocktails.ui.State.CocktailState
import javax.inject.Inject

class NameUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(nombre: String): CocktailState {
        return repository.vCocktail(nombre)
    }
}