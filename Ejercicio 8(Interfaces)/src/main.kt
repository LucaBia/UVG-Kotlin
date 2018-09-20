import acciones.Describible
import acciones.Dibujable
import figuras.Cuadrado
import figuras.Rectangulo
import figuras.Triangulo

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
                do {
                    println("""
                    1. Dibujar un Cuadrado
                    2. Dibujar un Rectangulo
                    3. Dibujar un Triangulo
                    4. Salir
                """.trimIndent())
                    val opcion2 = readLine()!!.toInt()
                    var continuar2 =true
                    when(opcion2){
                        1 -> {
                            val cuadrado = Cuadrado()
                            interfazDescribir(cuadrado)
                            interfazDibujar(cuadrado)
                        }

                        2 -> {
                            val rectangulo = Rectangulo()
                            interfazDescribir(rectangulo)
                            interfazDibujar(rectangulo)
                        }

                        3 -> {
                            val triangulo = Triangulo()
                            interfazDescribir(triangulo)
                            interfazDibujar(triangulo)
                        }

                        4 ->{
                            continuar2 = false
                        }
                    }
                }while (continuar2)

            }

            2 -> {
                continuar = false
            }
        }

    }while(continuar)

}

fun interfazDescribir (describible: Describible){
    describible.datos()
}

fun interfazDibujar (dibujable: Dibujable){
    dibujable.dibujar()
}

