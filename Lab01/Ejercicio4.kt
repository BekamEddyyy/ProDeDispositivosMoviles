fun main() {
    var opcion: Int
    var continuar = true

    // Bucle principal del programa
    while (continuar) {
        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        println("Ingrese una opción:")

        // Leer la opción del usuario y manejar las excepciones
        try {
            opcion = readLine()?.toInt() ?: 0
        } catch (e: NumberFormatException) {
            println("Opción inválida. Por favor, ingrese un número.")
            continue
        }

        // Ejecutar la opción seleccionada por el usuario
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

// Función para ingresar un número, maneja la entrada del usuario y retorna un Double
fun ingresarNumero(mensaje: String): Double {
    println(mensaje)
    return readLine()?.toDoubleOrNull() ?: run {
        println("Número inválido. Inténtelo de nuevo.")
        ingresarNumero(mensaje) // Llamada recursiva si la entrada es inválida
    }
}

// Función para realizar la suma de varios números ingresados por el usuario
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

// Función para realizar la resta de varios números ingresados por el usuario
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

// Función para realizar la multiplicación de varios números ingresados por el usuario
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

// Función para realizar la división de dos números ingresados por el usuario
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
