import kotlin.random.Random

fun main() {
    val numeroAleatorio = Random.nextInt(1, 31)
    var intentos = 0

    println("¡Bienvenido al juego de Adivina el Número!")
    println("Tienes 5 intentos para adivinar un número entre 1 y 30.")

    while (intentos < 5) {
        print("Intento ${intentos + 1}: Ingresa tu número: ")
        val numeroUsuario = readLine()?.toIntOrNull()

        if (numeroUsuario == null) {
            println("Entrada inválida. Por favor, ingresa un número entero.")
            continue
        }

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
