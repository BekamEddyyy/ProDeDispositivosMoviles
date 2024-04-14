package com.example.prueba1

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        val imageView: ImageView = findViewById(R.id.imageView)
    }

    fun showToast(view: android.view.View) {
        // Muestra un Toast con el mensaje "Hello World" al hacer clic en la ImageView
        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
    }
}
