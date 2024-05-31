// User.kt
package com.example.app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Clase de datos User que representa a un usuario en la aplicación
@Parcelize
data class User(
    val id: Int, // ID único del usuario
    var name: String, // Nombre del usuario
    var email: String, // Correo electrónico del usuario
    var imageResourceId: Int // ID del recurso de imagen del usuario
) : Parcelable // Implementa Parcelable para permitir pasar objetos User entre componentes de Android
