package com.example.reproductormusic // Declaración del paquete

import android.os.Bundle // Importación de clases necesarias
import android.widget.Toast
import android.media.MediaPlayer
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    // Variables miembro de la clase
    private lateinit var play_pause: Button
    private lateinit var btn_repetir: Button
    private lateinit var iv: ImageView
    private lateinit var mp: MediaPlayer
    private var repetir = 2
    private var posicion = 0

    private val vectormp = arrayOfNulls<MediaPlayer>(3)

    override fun onCreate(savedInstanceState: Bundle?) { // Método llamado cuando se crea la actividad
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Establece el diseño de la actividad

        // Inicialización de las vistas y el vector de MediaPlayer
        play_pause = findViewById(R.id.btn_play)
        btn_repetir = findViewById(R.id.btn_repetir)
        iv = findViewById(R.id.imageView3)

        vectormp[0] = MediaPlayer.create(this, R.raw.race)
        vectormp[1] = MediaPlayer.create(this, R.raw.sound)
        vectormp[2] = MediaPlayer.create(this, R.raw.tea)
    }

    // Función de reproducción/pausa
    fun PlayPause(view: View) {
        // Controla la reproducción y pausa del MediaPlayer y actualiza la vista del botón
        if (vectormp[posicion] != null && vectormp[posicion]!!.isPlaying) {
            vectormp[posicion]!!.pause()
            play_pause.setBackgroundResource(R.drawable.reproducir)
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show()
        } else if (vectormp[posicion] != null) {
            vectormp[posicion]!!.start()
            play_pause.setBackgroundResource(R.drawable.pausa)
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show()
        }
    }

    // Función de parada
    fun Stop(view: View) {
        // Detiene el MediaPlayer actual y libera recursos
        if (vectormp[posicion] != null) {
            vectormp[posicion]!!.stop()
            vectormp[posicion]!!.release()
            vectormp[posicion] = null
            vectormp[0] = MediaPlayer.create(this, R.raw.race)
            vectormp[1] = MediaPlayer.create(this, R.raw.sound)
            vectormp[2] = MediaPlayer.create(this, R.raw.tea)
            posicion = 0
            play_pause.setBackgroundResource(R.drawable.reproducir)
            iv.setImageResource(R.drawable.portada1)
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show()
        }
    }

    // Función de repetición
    fun Repetir(view: View) {
        // Controla la repetición de la canción actual y actualiza la vista del botón
        if (repetir == 1) {
            btn_repetir.setBackgroundResource(R.drawable.no_repetir)
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show()
            if (vectormp[posicion] != null)
                vectormp[posicion]!!.isLooping = false
            repetir = 2
        } else {
            btn_repetir.setBackgroundResource(R.drawable.repetir)
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show()
            if (vectormp[posicion] != null)
                vectormp[posicion]!!.isLooping = true
            repetir = 1
        }
    }

    // Función para reproducir la siguiente canción
    fun Siguiente(view: View) {
        // Reproduce la siguiente canción en el vector de MediaPlayer y actualiza la vista de la portada
        if (posicion < vectormp.size - 1) {
            if (vectormp[posicion] != null && vectormp[posicion]!!.isPlaying) {
                vectormp[posicion]!!.stop()
                posicion++
                if (vectormp[posicion] != null)
                    vectormp[posicion]!!.start()
                else
                    Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show()

                val imageResource = resources.getIdentifier("portada" + (posicion + 1), "drawable", packageName)
                iv.setImageResource(imageResource)
            } else {
                posicion++
                if (vectormp[posicion] == null) {
                    Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show()
                    return
                }
                val imageResource = resources.getIdentifier("portada" + (posicion + 1), "drawable", packageName)
                iv.setImageResource(imageResource)
            }
        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show()
        }
    }

    // Función para reproducir la canción anterior
    fun Anterior(view: View) {
        // Reproduce la canción anterior en el vector de MediaPlayer y actualiza la vista de la portada
        if (posicion >= 1) {
            if (vectormp[posicion] != null && vectormp[posicion]!!.isPlaying) {
                vectormp[posicion]!!.stop()
                vectormp[posicion]!!.release()
                vectormp[posicion] = null
                vectormp[0] = MediaPlayer.create(this, R.raw.race)
                vectormp[1] = MediaPlayer.create(this, R.raw.sound)
                vectormp[2] = MediaPlayer.create(this, R.raw.tea)
                posicion--

                val imageResource = resources.getIdentifier("portada" + (posicion + 1), "drawable", packageName)
                iv.setImageResource(imageResource)

                if (vectormp[posicion] != null)
                    vectormp[posicion]!!.start()
            } else {
                posicion--
                if (vectormp[posicion] == null) {
                    Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show()
                    return
                }
                val imageResource = resources.getIdentifier("portada" + (posicion + 1), "drawable", packageName)
                iv.setImageResource(imageResource)
            }
        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show()
        }
    }
}

