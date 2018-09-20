
fun main (args: Array<String>){
    var continuar = true
    do{
        println("""
                Menu Principal
            ---------------------
            1. Dibujar una figura
            2. Salir
        """.trimIndent())
        val opcion = readLine()!!.toInt()
        when(opcion){
            1 -> {
                println("""
                    1. Dibujar un Cuadrado
                    2. Dibujar un Rectangulo
                    3. Dibujar un Triangulo
                    4. Salir
                """.trimIndent())
                val opcion2 = readLine()!!.toInt()

                when(opcion2){
                    1 -> {

                    }
                }
            }

            2 -> {
                continuar = false
            }
        }

    }while(continuar)
}