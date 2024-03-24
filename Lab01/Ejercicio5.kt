import kotlin.random.Random

fun main() {
    //uso de la libreria random para imprimir un valor entre el 1 al 31
    val numeroAleatorio = Random.nextInt(1, 31)
    var intentos = 0

    println("¡Bienvenido al juego de Adivina el Número!")
    println("Tienes 5 intentos para adivinar un número entre 1 y 30.")

    //los 5 intentos que tiene el usuario
    while (intentos < 5) {
        print("Intento ${intentos + 1}: Ingresa tu número: ")
        val numeroUsuario = readLine()?.toIntOrNull()

        // Verificar si la entrada es válida
        if (numeroUsuario == null) {
            println("Entrada inválida. Por favor, ingresa un número entero.")
            continue
        }

        // Verificar si el número del usuario es igual al número aleatorio
        if (numeroUsuario == numeroAleatorio) {
            println("¡Felicidades! ¡Has adivinado el número correctamente!")
            return
        } else if (numeroUsuario < numeroAleatorio) {
            println("El número a adivinar es mayor que $numeroUsuario.")
        } else {
            println("El número a adivinar es menor que $numeroUsuario.")
        }

        intentos++
    }

    println("Game over. El número a adivinar era: $numeroAleatorio")
}
