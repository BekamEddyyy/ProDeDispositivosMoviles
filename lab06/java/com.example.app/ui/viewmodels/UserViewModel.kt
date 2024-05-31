package com.example.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.app.model.User

// ViewModel para manejar la lógica de negocio y los datos de la lista de usuarios
class UserViewModel : ViewModel() {

    // Lista mutable que almacena los usuarios
    private val users = mutableListOf<User>()

    // Retorna la lista de usuarios
    fun getUsers() = users

    // Retorna un usuario específico por su ID
    fun getUserById(id: Int) = users.find { it.id == id }

    // Agrega un nuevo usuario a la lista
    fun addUser(user: User) {
        users.add(user)
    }

    // Actualiza un usuario existente en la lista
    fun updateUser(updatedUser: User) {
        users.replaceAll { if (it.id == updatedUser.id) updatedUser else it }
    }

    // Elimina un usuario de la lista
    fun deleteUser(user: User) {
        users.remove(user)
    }
}
