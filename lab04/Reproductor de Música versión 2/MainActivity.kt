import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val audios = arrayOf("Audio 1", "Audio 2", "Audio 3", "Audio 4", "Audio 5")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, audios)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        audioSpinner.adapter = adapter

        selectButton.setOnClickListener {
            val selectedAudio = audioSpinner.selectedItem.toString()
            val intent = Intent(this, PlayerActivity::class.java)
            intent.putExtra("audioName", selectedAudio)
            startActivity(intent)
        }
    }
}

class PlayerActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val audioName = intent.getStringExtra("audioName") ?: "Nombre del Audio"
        audioNameTextView.text = audioName

        mediaPlayer = MediaPlayer.create(this, R.raw.audio_file) // Reemplaza "audio_file" con el nombre de tu archivo de audio en res/raw

        playButton.setOnClickListener {
            mediaPlayer.start()
        }

        pauseButton.setOnClickListener {
            mediaPlayer.pause()
        }

        stopButton.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.prepare()
            mediaPlayer.seekTo(0)
        }
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer.release()
    }
}
