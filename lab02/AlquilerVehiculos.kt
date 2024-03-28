// Interfaz para vehículos alquilables
interface VehiculoAlquilable {
    fun alquilar()
    fun devolver()
}

// Clase concreta Coche
class Coche : VehiculoAlquilable {
    override fun alquilar() {
        println("Coche alquilado")
    }

    override fun devolver() {
        println("Coche devuelto")
    }
}

// Clase concreta Moto
class Moto : VehiculoAlquilable {
    override fun alquilar() {
        println("Moto alquilada")
    }

    override fun devolver() {
        println("Moto devuelta")
    }
}

// Clase de delegación para la interfaz VehiculoAlquilable
class AlquilerVehiculo(private val vehiculo: VehiculoAlquilable) : VehiculoAlquilable by vehiculo

fun main() {
    // Crear instancia de Coche y Moto
    val coche = Coche()
    val moto = Moto()

    // Crear instancia de alquiler para Coche y Moto
    val alquilerCoche = AlquilerVehiculo(coche)
    val alquilerMoto = AlquilerVehiculo(moto)

    // Alquilar y devolver el Coche
    alquilerCoche.alquilar()
    alquilerCoche.devolver()

    alquilerMoto.alquilar()
    alquilerMoto.devolver()
}
