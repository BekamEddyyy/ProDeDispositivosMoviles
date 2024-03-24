fun main() {
    var opcion: Int
    var continuar = true

    while (continuar) {
        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        println("Ingrese una opción:")

        try {
            opcion = readLine()?.toInt() ?: 0
        } catch (e: NumberFormatException) {
            println("Opción inválida. Por favor, ingrese un número.")
            continue
        }

        when (opcion) {
            1 -> suma()
            2 -> resta()
            3 -> multiplicacion()
            4 -> division()
            5 -> {
                println("Saliendo de la calculadora.")
                continuar = false
            }
            else -> println("Opción no válida. Por favor, seleccione una opción del menú.")
        }
    }
}

fun ingresarNumero(mensaje: String): Double {
    println(mensaje)
    return readLine()?.toDoubleOrNull() ?: run {
        println("Número inválido. Inténtelo de nuevo.")
        ingresarNumero(mensaje) // Llamada recursiva si la entrada es inválida
    }
}

fun suma() {
    println("¿Cuántos números desea sumar?")
    val cantidadNumeros = readLine()?.toIntOrNull()

    if (cantidadNumeros == null || cantidadNumeros <= 0) {
        println("Cantidad inválida. Por favor, ingrese un número entero positivo.")
        return
    }

    var sumaTotal = 0.0

    for (i in 1..cantidadNumeros) {
        val numero = ingresarNumero("Ingrese el número $i para sumar:")
        sumaTotal += numero
    }

    println("Resultado de la suma: $sumaTotal")
}

fun resta() {
    println("¿Cuántos números desea restar?")
    val cantidadNumeros = readLine()?.toIntOrNull()

    if (cantidadNumeros == null || cantidadNumeros <= 0) {
        println("Cantidad inválida. Por favor, ingrese un número entero positivo.")
        return
    }

    println("Ingrese el primer número:")
    val num1 = ingresarNumero("Ingrese el primer número para restar:")
    var resultado = num1

    for (i in 2..cantidadNumeros) {
        val numero = ingresarNumero("Ingrese el número $i para restar:")
        resultado -= numero
    }

    println("Resultado de la resta: $resultado")
}

fun multiplicacion() {
    println("¿Cuántos números desea multiplicar?")
    val cantidadNumeros = readLine()?.toIntOrNull()

    if (cantidadNumeros == null || cantidadNumeros <= 0) {
        println("Cantidad inválida. Por favor, ingrese un número entero positivo.")
        return
    }

    var productoTotal = 1.0

    for (i in 1..cantidadNumeros) {
        val numero = ingresarNumero("Ingrese el número $i para multiplicar:")
        productoTotal *= numero
    }

    println("Resultado de la multiplicación: $productoTotal")
}

fun division() {
    val dividendo = ingresarNumero("Ingrese el dividendo:")
    val divisor = ingresarNumero("Ingrese el divisor:")

    if (divisor == 0.0) {
        println("No se puede dividir por cero.")
        return
    }

    val resultado = dividendo / divisor
    println("Resultado de la división: $resultado")
}