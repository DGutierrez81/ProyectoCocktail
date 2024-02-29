package com.example.proyectococktail.Cocktails.Core

import com.example.proyectococktail.Cocktails.Model.CocktailsView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Este objeto proporciona módulos de Dagger para la inyección de dependencias.
 * Está instalado en el componente SingletonComponent.
 */
@Module
 @InstallIn(SingletonComponent::class)
object Module {

    /**
     * Este método proporciona una instancia de Retrofit para realizar llamadas a la API de Cocktails.
     * @return una instancia de Retrofit configurada con la base URL y el convertidor Gson.
     */
    @Singleton
    @Provides
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    /**
     * Este método proporciona una instancia de CocktailsView, que representa la interfaz de la API de Cocktails.
     * @param retrofit el objeto Retrofit utilizado para crear instancias de servicios API.
     * @return una instancia de CocktailsView.
     */
    @Singleton
    @Provides
    fun provideCocktailsApiService(retrofit: Retrofit): CocktailsView {
        return retrofit.create(CocktailsView::class.java )
    }
}