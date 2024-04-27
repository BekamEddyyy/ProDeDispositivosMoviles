import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.prueba1.R
import com.google.android.exoplayer2.ExoPlayer

class ControlesFragment : Fragment() {

    private var playButton: Button? = null
    private var pauseButton: Button? = null
    private var exoPlayer: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_controles, container, false)

        playButton = view.findViewById(R.id.playButton)
        pauseButton = view.findViewById(R.id.pauseButton)

        playButton?.setOnClickListener {
            exoPlayer?.play()
            playButton?.isEnabled = false
            pauseButton?.isEnabled = true
        }

        pauseButton?.setOnClickListener {
            exoPlayer?.pause()
            playButton?.isEnabled = true
            pauseButton?.isEnabled = false
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        playButton = null
        pauseButton = null
    }

    fun setExoPlayer(player: ExoPlayer?) {
        exoPlayer = player
        // Update button states based on initial player state (optional)
        if (exoPlayer?.isPlaying == true) {
            playButton?.isEnabled = false
            pauseButton?.isEnabled = true
        } else {
            playButton?.isEnabled = true
            pauseButton?.isEnabled = false
        }
    }
}
