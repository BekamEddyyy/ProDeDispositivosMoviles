import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba1.R

class ListaCancionesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var songAdapter: SongAdapter

    // Replace with your data source (e.g., list of songs)
    private val songs = listOf(
        Song("Bohemian Rhapsody", "Queen"),
        Song("Imagine", "John Lennon"),
        Song("What a Wonderful World", "Louis Armstrong"),
        Song("Hey Jude", "The Beatles"),
        Song("Hallelujah", "Leonard Cohen"),
        Song("Respect", "Aretha Franklin"),
        Song("I Will Always Love You", "Whitney Houston"),
        Song("Stairway to Heaven", "Led Zeppelin"),
        Song("Smells Like Teen Spirit", "Nirvana"),
        Song("Like a Virgin", "Madonna"),
        // Add more songs as desired
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lista_canciones, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        songAdapter = SongAdapter(songs) { song ->
            // Handle song selection (e.g., send song information to other fragments)
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            val reproductorFragment = ReproductorFragment.newInstance(song)
            fragmentTransaction.replace(R.id.viewPager, reproductorFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = songAdapter

        return view
    }
}

// Data class to represent a song (optional, modify if needed)
data class Song(val title: String, val artist: String)

// Adapter class for RecyclerView (optional, modify if needed)
class SongAdapter(
    private val songs: List<Song>,
    private val onSongClickListener: (Song) -> Unit
) : RecyclerView.Adapter<SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_item_layout, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.bind(song, onSongClickListener)
    }

    override fun getItemCount(): Int = songs.size
}

// ViewHolder class for song items (optional, modify if needed)
class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val artistTextView: TextView = itemView.findViewById(R.id.artistTextView)

    fun bind(song: Song, onSongClickListener: (Song) -> Unit) {
        titleTextView.text = song.title
        artistTextView.text = song.artist
        itemView.setOnClickListener {
            onSongClickListener(song)
        }
    }
}
