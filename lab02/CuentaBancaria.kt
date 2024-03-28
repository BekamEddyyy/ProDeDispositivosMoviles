class CuentaBancaria(private var saldo: Double, private val limiteRetiro: Double) {
    fun setSaldo(nuevoSaldo: Double) { //establecer saldo y verificar saldo
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
        } else {
            println("El saldo no puede ser negativo.")
        }
    }

    fun getSaldo(): Double {  //obtener saldo
        return saldo
    }

    fun realizarRetiro(cantidad: Double) {
        if (cantidad > saldo) {
            println("No hay suficiente saldo para realizar este retiro.")
        } else if (cantidad > limiteRetiro) {
            println("La cantidad a retirar supera el límite de retiro diario.")
        } else {
            saldo -= cantidad
            println("Retiro exitoso. Saldo restante: $saldo")
        }
    }
}


fun main() {
    // Crear una instancia de CuentaBancaria
    val cuenta = CuentaBancaria(1000.0, 900.0)

    // Obtener y mostrar el saldo inicial
    println("Saldo inicial: ${cuenta.getSaldo()}")

    // Realizar un retiro que excede el límite diario
    cuenta.realizarRetiro(600.0)

    // Realizar un retiro que excede el saldo disponible
    cuenta.realizarRetiro(900.0)

    // Obtener y mostrar el saldo actual
    println("Saldo actual: ${cuenta.getSaldo()}")

    // Establecer un nuevo saldo
    cuenta.setSaldo(1500.0)

    // Realizar un retiro dentro del límite y mostrar el saldo restante
    cuenta.realizarRetiro(200.0)

    // Obtener y mostrar el saldo actual
    println("Saldo actual: ${cuenta.getSaldo()}")
}