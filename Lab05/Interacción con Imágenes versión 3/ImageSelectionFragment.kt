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

    interface OnImageSelectedListener {
        fun onImageSelected(imageName: String)
    }

    private lateinit var spinner: Spinner
    private var listener: OnImageSelectedListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
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
                listener?.onImageSelected(parent.getItemAtPosition(position).toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        return view
    }

    fun setOnImageSelectedListener(listener: OnImageSelectedListener) {
        this.listener = listener
    }
}

