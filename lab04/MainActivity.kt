import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba1.R

class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var nextButton: Button
    private var selectedImage: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner_images)
        nextButton = findViewById(R.id.btn_next)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.image_names,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedImage = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        nextButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ImageActivity::class.java)
            intent.putExtra("selectedImage", selectedImage)
            startActivity(intent)
        }
    }
}
