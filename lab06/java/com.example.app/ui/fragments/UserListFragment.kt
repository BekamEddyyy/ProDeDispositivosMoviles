package com.example.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.R
import com.example.app.adapter.UserAdapter
import com.example.app.ui.viewmodels.UserViewModel
import kotlinx.android.synthetic.main.fragment_user_list.*

class UserListFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    // Inflar el layout para este fragmento
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    // Configurar la vista una vez que ha sido creada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar el ViewModel
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // Configurar el adaptador del RecyclerView con la lista de usuarios
        val adapter = UserAdapter(userViewModel.getUsers()) { user ->
            // Navegar al fragmento de edición cuando se hace clic en un usuario
            val action = UserListFragmentDirections.actionUserListFragmentToAddEditUserFragment(user.id)
            findNavController().navigate(action)
        }
        // Configurar el RecyclerView con un LinearLayoutManager y el adaptador
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Configurar el FloatingActionButton para agregar un nuevo usuario
        fabAddUser.setOnClickListener {
            findNavController().navigate(R.id.action_userListFragment_to_addEditUserFragment)
        }
    }
}
