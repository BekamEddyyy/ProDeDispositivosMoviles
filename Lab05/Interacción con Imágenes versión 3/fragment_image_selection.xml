import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.prueba1.R

class ImageSelectionFragment : Fragment() {
    private lateinit var spinner: Spinner
    private var selectedImage: String = ""
    private lateinit var listener: OnImageSelectedListener

    interface OnImageSelectedListener {
        fun onImageSelected(imageName: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image_selection, container, false)

        spinner = view.findViewById(R.id.spinner_images)

        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.image_names,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedImage = parent.getItemAtPosition(position).toString()
                listener.onImageSelected(selectedImage)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnImageSelectedListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnImageSelectedListener")
        }
    }
}
