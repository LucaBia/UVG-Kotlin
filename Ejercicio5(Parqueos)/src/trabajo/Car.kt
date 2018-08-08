package trabajo

class Car(
        val licensePlate: String
){

    override fun toString(): String {
        return """
            Placa: $licensePlate
        """.trimIndent()
    }
}