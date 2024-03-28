// Clase abstracta Shape
abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double
}

// Subclase Cuadrado
class Cuadrado(val lado: Double) : Shape() {
    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}

// Subclase Círculo
class Circulo(val radio: Double) : Shape() {
    override fun calcularArea(): Double {
        return Math.PI * radio * radio
    }

    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * radio
    }
}

// Subclase Rectángulo
class Rectangulo(val base: Double, val altura: Double) : Shape() {
    override fun calcularArea(): Double {
        return base * altura
    }

    override fun calcularPerimetro(): Double {
        return 2 * (base + altura)
    }
}

// Función principal
fun main() {
    // Crear instancias de las subclases
    val cuadrado = Cuadrado(8.0)
    val circulo = Circulo(2.0)
    val rectangulo = Rectangulo(5.0, 8.0)

    // Calcular área y perímetro para cada instancia
    val areaCuadrado = cuadrado.calcularArea()
    val perimetroCuadrado = cuadrado.calcularPerimetro()

    val areaCirculo = circulo.calcularArea()
    val perimetroCirculo = circulo.calcularPerimetro()

    val areaRectangulo = rectangulo.calcularArea()
    val perimetroRectangulo = rectangulo.calcularPerimetro()

    // Mostrar resultados
    println("Cuadrado:")
    println(" - Área = $areaCuadrado")
    println(" - Perímetro = $perimetroCuadrado")

    println("Círculo:")
    println(" - Área = $areaCirculo")
    println(" - Perímetro = $perimetroCirculo")

    println("Rectángulo:")
    println(" - Área = $areaRectangulo")
    println(" - Perímetro = $perimetroRectangulo")
}