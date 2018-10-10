class Chocolate (nombre: String, cantidadAzucar: Int, val sabor: String): Dulce(nombre, cantidadAzucar){

    override fun toString(): String {
        return """
            Nombre: ${nombre}
            Contenido de azucar (Cantidad): ${cantidadAzucar}
            Sabor: ${sabor}
        """.trimIndent()

    }
}