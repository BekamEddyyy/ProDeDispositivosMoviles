class Producto(private var price: Double, private var descuento: Double) {
    // Método para establecer el precio del producto
    fun setPrecio(nuevoPrice: Double) {
        // Verificar que el nuevo precio sea no negativo
        if (nuevoPrice >= 0) {
            price = nuevoPrice
        } else {
            println("no puede ser negativo el precio.")
        }
    }

    fun getPrecio(): Double {
        return price
    }

    // Método para establecer el descuento del producto
    fun setDescuento(newDescuento: Double) {
        if (newDescuento > 0 && newDescuento <= 100) {
            descuento = newDescuento
        } else {
            println("el despuesto debe de estar entre el rango entre 1 a 100")
        }
    }

    fun getDescuento(): Double {
        return descuento
    }
    // Método para calcular el precio final del producto después de aplicar el descuento
    fun calcularPrecioFinal(): Double {
        val priceFinal = price * (1 - descuento / 100)
        return priceFinal
    }
}

fun main() {
    //Creando objeto producto con un descuento inicial
    val producto = Producto(100.0, 10.0)

    println("Precio original: ${producto.getPrecio()}")
    println("Descuento aplicable: ${producto.getDescuento()}%")
    println("Precio final después de aplicar el descuento: ${producto.calcularPrecioFinal()}")

    // Modificar el precio y el descuento
    producto.setPrecio(120.0)
    producto.setDescuento(20.0)

    println("Precio original: ${producto.getPrecio()}")
    println("Descuento aplicable: ${producto.getDescuento()}%")
    println("Precio final después de aplicar el descuento: ${producto.calcularPrecioFinal()}")
}
