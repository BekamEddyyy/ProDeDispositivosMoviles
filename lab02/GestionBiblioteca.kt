// Clase abstracta Material
abstract class Material(
    val titulo: String,
    val autor: String,
    val añoPublicacion: Int
) {
    // Método abstracto para mostrar detalles del material
    abstract fun mostrarDetalles()
}

// Subclase Libro
class Libro(
    titulo: String,
    autor: String,
    añoPublicacion: Int,
    val genero: String,
    val numPaginas: Int
) : Material(titulo, autor, añoPublicacion) {
    // Implementación del método para mostrar detalles del libro
    override fun mostrarDetalles() {
        println("Título: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $añoPublicacion")
        println("Género: $genero")
        println("Número de Páginas: $numPaginas")
    }
}

// Subclase Revista
class Revista(
    titulo: String,
    autor: String,
    añoPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, añoPublicacion) {
    // Implementación del método para mostrar detalles de la revista
    override fun mostrarDetalles() {
        println("Título: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $añoPublicacion")
        println("ISSN: $issn")
        println("Volumen: $volumen")
        println("Número: $numero")
        println("Editorial: $editorial")
    }
}

// Clase Usuario
class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int
) {
    // Método para reservar material
    fun reservarMaterial(material: Material) {
        println("El usuario $nombre $apellido ha reservado el material ${material.titulo}.")
    }

    // Método para devolver material
    fun devolverMaterial(material: Material) {
        println("El usuario $nombre $apellido ha devuelto el material ${material.titulo}.")
    }
}

// Clase Biblioteca
class Biblioteca {
    val materialesDisponibles = mutableListOf<Material>()
    val usuariosRegistrados = mutableListOf<Usuario>()

    // Método para agregar material a la biblioteca
    fun agregarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    // Método para agregar usuario a la biblioteca
    fun agregarUsuario(usuario: Usuario) {
        usuariosRegistrados.add(usuario)
    }

    // Método para préstamo de material
    fun prestarMaterial(material: Material, usuario: Usuario) {
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)
            usuario.reservarMaterial(material)
        } else {
            println("El material ${material.titulo} no está disponible.")
        }
    }

    // Método para devolución de material
    fun devolverMaterial(material: Material, usuario: Usuario) {
        materialesDisponibles.add(material)
        usuario.devolverMaterial(material)
    }
}

// Función principal
fun main() {
    // Crear instancias de materiales
    val libro1 = Libro("1984", "George Orwell", 1949, "Ciencia Ficción", 328)
    val libro2 = Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo Mágico", 417)
    val revista1 = Revista("Time", "Varios", 2022, "ISSN87654321", 50, 4, "Time Inc.")

    // Mostrar detalles de los materiales
    println("Detalles del Libro 1:")
    libro1.mostrarDetalles()

    println("\nDetalles del Libro 2:")
    libro2.mostrarDetalles()

    println("\nDetalles de la Revista 1:")
    revista1.mostrarDetalles()

    // Crear instancias de usuarios
    val usuario1 = Usuario("Ana", "Gómez", 25)
    val usuario2 = Usuario("Carlos", "Martínez", 40)

    // Crear instancia de biblioteca
    val biblioteca = Biblioteca()

    // Agregar material a la biblioteca
    biblioteca.agregarMaterial(libro1)
    biblioteca.agregarMaterial(libro2)
    biblioteca.agregarMaterial(revista1)

    // Agregar usuarios a la biblioteca
    biblioteca.agregarUsuario(usuario1)
    biblioteca.agregarUsuario(usuario2)

    // Realizar préstamo de material
    biblioteca.prestarMaterial(libro1, usuario1)
    biblioteca.prestarMaterial(libro2, usuario2)
    biblioteca.prestarMaterial(revista1, usuario1)

    // Devolver material
    biblioteca.devolverMaterial(libro1, usuario1)
    biblioteca.devolverMaterial(libro2, usuario2)
    biblioteca.devolverMaterial(revista1, usuario1)
}
