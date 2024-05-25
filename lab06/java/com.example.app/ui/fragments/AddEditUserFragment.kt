package com.example.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.app.R
import com.example.app.model.User
import com.example.app.ui.viewmodels.UserViewModel
import kotlinx.android.synthetic.main.fragment_add_edit_user.*

class AddEditUserFragment : Fragment() {

    private val args: AddEditUserFragmentArgs by navArgs()
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_edit_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val userId = args.userId
        if (userId != -1) {
            // Cargar datos del usuario para editar
            val user = userViewModel.getUserById(userId)
            user?.let {
                editTextName.setText(it.name)
                editTextEmail.setText(it.email)
                // Cargar la imagen del usuario
            }
        }

        buttonSave.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()
            if (name.isNotEmpty() && email.isNotEmpty()) {
                if (userId == -1) {
                    // Agregar nuevo usuario
                    userViewModel.addUser(User(0, name, email, R.drawable.ic_user_placeholder))
                } else {
                    // Editar usuario existente
                    userViewModel.updateUser(User(userId, name, email, R.drawable.ic_user_placeholder))
                }
                findNavController().popBackStack()
            } else {
                Toast.makeText(requireContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
