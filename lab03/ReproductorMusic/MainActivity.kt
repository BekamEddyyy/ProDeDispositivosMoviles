package com.example.reproductormusic

import android.os.Bundle
import android.widget.Toast
import android.media.MediaPlayer
import android.widget.Button
import android.widget.ImageView
/*import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.reproductormusic.ui.theme.ReproductorMusicThem
*/
import androidx.appcompat.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var play_pause: Button
    private lateinit var btn_repetir: Button
    private lateinit var iv: ImageView
    private lateinit var mp: MediaPlayer
    private var repetir = 2
    private var posicion = 0

    private val vectormp = arrayOfNulls<MediaPlayer>(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play_pause = findViewById(R.id.btn_play)
        btn_repetir = findViewById(R.id.btn_repetir)
        iv = findViewById(R.id.imageView3)

        vectormp[0] = MediaPlayer.create(this, R.raw.race)
        vectormp[1] = MediaPlayer.create(this, R.raw.sound)
        vectormp[2] = MediaPlayer.create(this, R.raw.tea)
    }

    fun PlayPause(view: View) {
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

    fun Stop(view: View) {
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

    fun Repetir(view: View) {
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

    fun Siguiente(view: View) {
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

    fun Anterior(view: View) {
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


