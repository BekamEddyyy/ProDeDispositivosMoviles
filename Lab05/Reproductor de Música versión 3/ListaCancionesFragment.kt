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
        holder.titleTextView.text = song.title
        holder.artistTextView.text = song.artist
        holder.itemView.setOnClickListener {
            onSongClickListener(song)
        }
    }

    override fun getItemCount(): Int = songs.size
}

// ViewHolder class for song items (optional, modify if needed)
class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    val artistTextView: TextView = itemView.findViewById(R.id.artistTextView)
}
