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

class UserAdapter(
    private val users: List<User>,
    private val onUserClick: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImageView: ImageView = itemView.findViewById(R.id.imageViewUser)
        val userNameTextView: TextView = itemView.findViewById(R.id.textViewUserName)
        val userEmailTextView: TextView = itemView.findViewById(R.id.textViewUserEmail)

        fun bind(user: User, onUserClick: (User) -> Unit) {
            userNameTextView.text = user.name
            userEmailTextView.text = user.email
            userImageView.setImageResource(user.imageResourceId)

            itemView.setOnClickListener {
                onUserClick(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position], onUserClick)
    }

    override fun getItemCount(): Int = users.size
}
