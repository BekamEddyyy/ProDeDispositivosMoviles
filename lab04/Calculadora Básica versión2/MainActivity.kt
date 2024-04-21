package com.example.tareita // Declaración del paquete

import android.os.Bundle // Importación de clases necesarias
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tareita.ui.theme.TareitaTheme

class MainActivity : ComponentActivity() { // Declaración de la clase principal

    // Variables miembro de la clase
    var oper: Int = 0 // Almacena el tipo de operación
    var numero1: Double = 0.0 // Almacena el primer número
    lateinit var tv_num1: TextView // Referencia a la vista del primer número
    lateinit var tv_num2: TextView // Referencia a la vista del segundo número

    override fun onCreate(savedInstanceState: Bundle?) { // Método llamado cuando se crea la actividad
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Establece el diseño de la actividad

        // Inicialización de las vistas
        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val C_E: Button = findViewById(R.id.C_E)
        val b_igual: Button = findViewById(R.id.b_igual)

        // Configuración de escuchadores de clic
        b_igual.setOnClickListener {
            // Realiza la operación según el tipo de operación almacenado
            // Actualiza la vista del resultado y borra la vista del primer número
            var numero2: Double = tv_num2.text.toString().toDouble()
            var resp: Double = 0.0

            when (oper) {
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> resp = numero1 / numero2
            }

            tv_num2.setText(resp.toString())
            tv_num1.setText("")
        }
        C_E.setOnClickListener{
            // Borra las vistas de los números, reinicia 'numero1' y 'oper'
            tv_num1.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            oper = 0
        }
    }

    // Función llamada cuando se presiona un dígito
    fun presionarDigito(view: View){
        // Concatena el dígito presionado al segundo número en la vista de texto
        var num2: String = tv_num2.text.toString()

        when(view.id){
            R.id.b_num0 -> tv_num2.setText(num2 + "0")
            R.id.b_num1 -> tv_num2.setText(num2 + "1")
            R.id.b_num2 -> tv_num2.setText(num2 + "2")
            R.id.b_num3 -> tv_num2.setText(num2 + "3")
            R.id.b_num4 -> tv_num2.setText(num2 + "4")
            R.id.b_num5 -> tv_num2.setText(num2 + "5")
            R.id.b_num6 -> tv_num2.setText(num2 + "6")
            R.id.b_num7 -> tv_num2.setText(num2 + "7")
            R.id.b_num8 -> tv_num2.setText(num2 + "8")
            R.id.b_num9 -> tv_num2.setText(num2 + "9")
            R.id.b_punto -> tv_num2.setText(num2 + "0")
        }
    }

    // Función llamada cuando se presiona un botón de operación
    fun clicOperaciones(view: View){
        // Obtiene el primer número de la vista de texto, establece la operación correspondiente y actualiza la vista del primer número
        numero1 = tv_num2.text.toString().toDouble()
        var num2_text: String = tv_num2.text.toString()
        tv_num2.setText("")
        when(view.id) {
            R.id.bop_suma ->{
                tv_num1.setText(num2_text + "+")
                oper = 1
            }
            R.id.bop_resta ->{
                tv_num1.setText(num2_text + "-")
                oper = 2
            }
            R.id.bop_mult ->{
                tv_num1.setText(num2_text + "*")
                oper = 3
            }
            R.id.bop_div ->{
                tv_num1.setText(num2_text + "/")
                oper = 4
            }
        }
    }
}
