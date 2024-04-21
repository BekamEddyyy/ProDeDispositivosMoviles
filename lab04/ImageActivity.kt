import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba1.R

class ImageActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        imageView = findViewById(R.id.image_view)
        backButton = findViewById(R.id.btn_back)

        val selectedImage = intent.getStringExtra("Image01")
        selectedImage?.let {
            val imageResource = resources.getIdentifier(it, "drawable", packageName)
            imageView.setImageResource(imageResource)
        }

        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}
