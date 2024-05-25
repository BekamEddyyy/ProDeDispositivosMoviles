package com.example.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.app.model.User

class UserViewModel : ViewModel() {

    private val users = mutableListOf<User>()

    fun getUsers() = users

    fun getUserById(id: Int) = users.find { it.id == id }

    fun addUser(user: User) {
        users.add(user)
    }

    fun updateUser(updatedUser: User) {
        users.replaceAll { if (it.id == updatedUser.id) updatedUser else it }
    }

    fun deleteUser(user: User) {
        users.remove(user)
    }
}
