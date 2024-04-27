import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import android.os.Bundle

class MusicaActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var fragmentAdapter: FragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_musica)

        viewPager = findViewById(R.id.viewPager) // Make sure your layout has a ViewPager
        fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(ListaCancionesFragment()) // Add your ListaCancionesFragment
        fragmentAdapter.addFragment(ReproductorFragment())  // Add your ReproductorFragment (optional)
        viewPager.adapter = fragmentAdapter
    }

    private class FragmentAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        private val fragments = mutableListOf<Fragment>()

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        fun addFragment(fragment: Fragment) {
            fragments.add(fragment)
        }
    }
}
