// Clase abstracta
abstract class Dulce (val nombre: String, val cantidadAzucar: Int) {
    var estaAbierto: Boolean = false
    fun abrir() {
        estaAbierto = true
    }
}