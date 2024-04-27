import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.prueba1.R
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class ReproductorFragment : Fragment() {
    private lateinit var songTitleTextView: TextView
    private lateinit var artistTextView: TextView
    private lateinit var albumImageView: ImageView
    private var song: Song? = null
    private var exoPlayer: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reproductor, container, false)

        songTitleTextView = view.findViewById(R.id.song_title_text_view)
        artistTextView = view.findViewById(R.id.artist_text_view)
        albumImageView = view.findViewById(R.id.album_image_view)

        // Retrieve song data from arguments
        song = arguments?.getParcelable("song")

        if (song != null) {
            songTitleTextView.text = song!!.title
            artistTextView.text = song!!.artist
            albumImageView.setImageResource(song!!.albumImage)

            // Initialize ExoPlayer
            exoPlayer = ExoPlayerFactory.newSimpleInstance(requireContext())
            val dataSourceFactory = DefaultDataSourceFactory(
                requireContext(),
                Util.getUserAgent(requireContext(), "prueba1")
            )
            val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(song!!.audioUrl))
            exoPlayer!!.prepare(mediaSource)

            // Start playback
            exoPlayer!!.play()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Release ExoPlayer resources
        exoPlayer?.release()
        exoPlayer = null
    }
}
