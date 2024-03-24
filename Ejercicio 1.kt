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

fun calcularDineroRecibido(puntuacion: Int, salarioMensual: Int): Int {
    val dinero = salarioMensual * (puntuacion.toDouble() / 10)
    return dinero.toInt()
}

fun main() {
    val usuarios = arrayOf("Juan", "María", "Pedro", "Camila", "Carlos") // Nombres de los usuarios
    val salariosMensuales = intArrayOf(10000, 12000, 9000, 8500, 7800) // Salarios mensuales de los usuarios
    val puntuaciones = intArrayOf(8, 7, 9, 7, 6) // Puntuaciones de los usuarios

    println("Resultados:")
    for (i in usuarios.indices) {
        val nivelRendimiento = calcularNivelRendimiento(puntuaciones[i])
        val dineroRecibido = calcularDineroRecibido(puntuaciones[i], salariosMensuales[i])

        println("${usuarios[i]} - Nivel de Rendimiento: $nivelRendimiento, Cantidad de Dinero Recibido: $$dineroRecibido")
    }
}

