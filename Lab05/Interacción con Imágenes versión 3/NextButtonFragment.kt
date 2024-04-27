import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.prueba1.R

class NextButtonFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_next_button, container, false)

        val nextButton = view.findViewById<Button>(R.id.btn_next)
        nextButton.setOnClickListener {
            (activity as MainActivity).onNextButtonClicked()
        }

        return view
    }
}
