package com.example.prueba1 // Declaración del paquete

import android.os.Bundle // Importación de clases necesarias
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // Método llamado cuando se crea la actividad
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout) // Establece el diseño de la actividad
        val imageView: ImageView = findViewById(R.id.imageView) // Inicializa la ImageView
    }

    fun showToast(view: android.view.View) { // Función para mostrar un Toast
        // Muestra un Toast con el mensaje "Hello World" al hacer clic en la ImageView
        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
    }
}
