// Clase abstracta Empleado
abstract class Empleado(
    val nombre: String,
    val apellido: String,
    val edad: Int,
    val salario: Double
) {
    abstract fun calcularPago(): Double
}

// Subclase de Empleado para empleados a tiempo completo
class E_TiempoCompleto(
    nombre: String,
    apellido: String,
    edad: Int,
    salario: Double,
    val horasTrabajadas: Int,
    val horaTarifa: Double
) : Empleado(nombre, apellido, edad, salario){
    // Método para calcular el pago para empleados a tiempo completo
    override fun calcularPago(): Double{
        return horasTrabajadas * horaTarifa
    }
}

// Subclase de Empleado para empleados a medio tiempo
class E_MedioTiempo(
    nombre: String,
    apellido: String,
    edad: Int,
    salario: Double,
    val horasTrabajadas: Int,
    val tarifaHora: Double,
    val diasTrabajados: Int
) : Empleado(nombre, apellido, edad, salario) {

    // Método para calcular el pago para empleados a medio tiempo
    override fun calcularPago(): Double {
        return horasTrabajadas * tarifaHora * diasTrabajados
    }
}

fun main() {
    // Crear instancias de las subclases
    val empleadoTiempoCompleto = E_TiempoCompleto("Mario", "Isola", 30, 0.0, 40, 15.0)
    val empleadoMedioTiempo = E_MedioTiempo("Jose", "Peña", 25, 0.0, 20, 12.0, 5)

    // Calcular el pago para cada empleado
    val pagoEmpleadoTiempoCompleto = empleadoTiempoCompleto.calcularPago()
    val pagoEmpleadoMedioTiempo = empleadoMedioTiempo.calcularPago()

    // Mostrar los pagos
    println("Pago del empleado a tiempo completo: $pagoEmpleadoTiempoCompleto")
    println("Pago del empleado a medio tiempo: $pagoEmpleadoMedioTiempo")
