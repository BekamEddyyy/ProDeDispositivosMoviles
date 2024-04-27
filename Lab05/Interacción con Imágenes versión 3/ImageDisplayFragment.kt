import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.prueba1.R // Replace with your package name

class ImageDisplayFragment : Fragment() {

    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image_display, container, false)
        imageView = view.findViewById(R.id.image_view)
        return view
    }

    fun displayImage(bitmap: Bitmap) {
        imageView.setImageBitmap(bitmap)
    }
}
