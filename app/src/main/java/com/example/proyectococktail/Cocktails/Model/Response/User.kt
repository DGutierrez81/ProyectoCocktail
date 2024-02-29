package com.example.proyectococktail.Cocktails.Model.Response

/**
 * Esta clase de datos representa un usuario.
 * @param id el ID del usuario.
 * @param email el correo electrónico del usuario.
 * @param name el nombre del usuario.
 */
data class User(
    val id: String,
    val email: String,
    val name: String
)

