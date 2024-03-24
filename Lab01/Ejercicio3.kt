import kotlin.math.max
import kotlin.math.min

fun main() {
    println("Ingrese la cantidad de alumnos en el salón:")
    val cantidadAlumnos = readLine()?.toInt()

    if (cantidadAlumnos == null || cantidadAlumnos <= 0) {
        println("Cantidad de alumnos no válida. Por favor, ingrese un número entero positivo.")
        return
    }

    var edadMaxima = Int.MIN_VALUE
    var edadMinima = Int.MAX_VALUE
    var todasLasEdades = ""

    println("Ingrese la edad de cada alumno:")

    for (i in 1..cantidadAlumnos) {
        print("Edad del alumno $i: ")
        val edad = readLine()?.toIntOrNull()

        if (edad == null) {
            println("Edad no válida. Por favor, ingrese un número entero.")
            return
        }

        if (edad > edadMaxima) {
            edadMaxima = edad
        }

        if (edad < edadMinima) {
            edadMinima = edad
        }

        todasLasEdades += "$edad"
        if (i < cantidadAlumnos) {
            todasLasEdades += ", "
        }
    }

    println("=== Edades ===")
    println("Máximo = $edadMaxima")
    println("Mínimo = $edadMinima")
    println("Todos = $todasLasEdades")
}
