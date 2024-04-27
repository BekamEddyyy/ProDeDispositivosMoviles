import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba1.R

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
        // Aquí puedes mostrar la imagen en el fragmento de visualización de imágenes
        // Puedes pasar la imagen al fragmento de visualización como argumento
    }
}
