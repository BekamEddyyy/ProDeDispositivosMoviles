// Función para calcular el nivel de rendimiento basado en la puntuación
fun calcularNivelRendimiento(puntuacion: Int): String {
    return when (puntuacion) {
        in 0..3 -> "Nivel de Rendimiento Bajo"
        in 4..6 -> "Nivel de Rendimiento Aceptable"
        in 7..8 -> "Nivel de Rendimiento Bueno"
        9 -> "Nivel de Rendimiento Excelente"
        10 -> "Nivel de Rendimiento Sobresaliente"
        else -> "Puntuación inválida"
    }
}

// Función para calcular el dinero recibido basado en la puntuación y el salario mensual
fun calcularDineroRecibido(puntuacion: Int, salarioMensual: Int): Int {
    val dinero = salarioMensual * (puntuacion.toDouble() / 10)
    return dinero.toInt()
}

fun main() {
    // Arrays de nombres, salarios mensuales y puntuaciones
    val usuarios = arrayOf("Juan", "María", "Pedro", "Camila", "Carlos") // Nombres de los usuarios
    val salariosMensuales = intArrayOf(10000, 12000, 9000, 8500, 7800) // Salarios mensuales de los usuarios
    val puntuaciones = intArrayOf(8, 7, 9, 7, 6) // Puntuaciones de los usuarios

    println("Resultados:")
    // Iteración sobre los usuarios
    for (i in usuarios.indices) {
        // Calcular el nivel de rendimiento y el dinero recibido para cada usuario
        val nivelRendimiento = calcularNivelRendimiento(puntuaciones[i])
        val dineroRecibido = calcularDineroRecibido(puntuaciones[i], salariosMensuales[i])

        println("${usuarios[i]} - Nivel de Rendimiento: $nivelRendimiento, Cantidad de Dinero Recibido: $$dineroRecibido")
    }
}
