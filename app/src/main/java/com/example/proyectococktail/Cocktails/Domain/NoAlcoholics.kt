package com.example.proyectococktail.Cocktails.Domain

import com.example.proyectococktail.Cocktails.Model.Repository
import com.example.proyectococktail.Cocktails.ui.State.CocktailState
import javax.inject.Inject

/**
 * Esta clase representa un caso de uso para obtener un cóctel sin alcohol.
 * @param repository el repositorio que proporciona la funcionalidad para obtener el cóctel aleatorio.
 */
class NoAlcoholics @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): CocktailState {
        return repository.vCocktailAlcoholic()
    }
}