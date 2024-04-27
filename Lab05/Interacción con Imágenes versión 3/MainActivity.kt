package com.example.prueba1

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.prueba1.R
import java.io.File

class MainActivity : AppCompatActivity(), ImageSelectionFragment.OnImageSelectedListener {

    private lateinit var imageDisplayFragment: ImageDisplayFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageDisplayFragment = supportFragmentManager.findFragmentById(R.id.fragment_image_display) as ImageDisplayFragment

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_image_selection, ImageSelectionFragment())
                .commit()
        }
    }

    override fun onImageSelected(imageName: String) {
        // Check if the image file exists
        val imageFile = File(filesDir, imageName)
        if (imageFile.exists()) {
            // Image file found, display it in the fragment
            val bitmap = BitmapFactory.decodeFile(imageFile.absolutePath)
            imageDisplayFragment.displayImage(bitmap)
        } else {
            // Image file not found, show error message
            Toast.makeText(this, "Imagen no encontrada: $imageName", Toast.LENGTH_SHORT).show()
        }
    }
}
