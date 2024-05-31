// UserAdapter.kt
package com.example.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.model.User

// Adapter para el RecyclerView que maneja una lista de usuarios
class UserAdapter(
    private val users: List<User>, // Lista de usuarios que se mostrarán
    private val onUserClick: (User) -> Unit // Callback para manejar los clics en los usuarios
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    // ViewHolder que representa los elementos individuales de la lista
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Referencias a los elementos de la UI dentro del ViewHolder
        val userImageView: ImageView = itemView.findViewById(R.id.imageViewUser)
        val userNameTextView: TextView = itemView.findViewById(R.id.textViewUserName)
        val userEmailTextView: TextView = itemView.findViewById(R.id.textViewUserEmail)

        // Método para enlazar los datos del usuario a las vistas
        fun bind(user: User, onUserClick: (User) -> Unit) {
            userNameTextView.text = user.name
            userEmailTextView.text = user.email
            userImageView.setImageResource(user.imageResourceId)

            // Establecer el listener para el clic en el item
            itemView.setOnClickListener {
                onUserClick(user)
            }
        }
    }

    // Método que infla la vista de cada item de la lista y crea un ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    // Método que enlaza los datos del usuario actual a través del ViewHolder
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position], onUserClick)
    }

    // Método que retorna el tamaño de la lista de usuarios
    override fun getItemCount(): Int = users.size
}
