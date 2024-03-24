import kotlin.random.Random
fun main() {
    // Array de opciones para el juego
    val opciones = arrayOf("Piedra", "Papel", "Tijera")
    // La computadora elige una opción aleatoria del array
    val opcionComputadora = opciones[Random.nextInt(opciones.size)]

    println("¡Bienvenido al juego de Piedra, Papel o Tijera!")
    println("La computadora ha elegido su opción.")

    var opcionUsuario = "" // Inicializar la variable opcionUsuario con una cadena vacía

    for (i in 0 until 3) {
        println("Ingrese su elección (Piedra, Papel o Tijera): ")
        opcionUsuario = readLine() ?: "" // Asignar la entrada del usuario a opcionUsuario
        if (opcionUsuario in opciones) {
            break
        } else {
            println("Opción inválida. Por favor, ingrese Piedra, Papel o Tijera.")
        }
    }

    println("La computadora eligió: $opcionComputadora")
    println("Usted eligió: $opcionUsuario")

    // Determinar el resultado del juego
    if (opcionUsuario == opcionComputadora) {
        println("¡Es un empate!")
    } else if ((opcionUsuario == "Piedra" && opcionComputadora == "Tijera") ||
        (opcionUsuario == "Papel" && opcionComputadora == "Piedra") ||
        (opcionUsuario == "Tijera" && opcionComputadora == "Papel")
    ) {
        println("¡Felicidades! ¡Usted ha ganado!")
    } else {
        println("¡Lo siento! ¡Usted ha perdido!")
    }
}
