import com.github.kittinunf.fuel.Fuel


fun menuBienvenida(): String{
    return """
            ***************************
                      DOTA 2
            ***************************

            Selección de Héroes Radiant
           -----------------------------

        """.trimIndent()
    }

    fun meniInicioJuego(): String{
        return """
            Menú:
            1. Ocurrieron muertes
            2. Matan Torres
        """.trimIndent()
    }

    fun menuFinal(): String{
        return """
            Menu:
            1. Ocurrieron muertes
            2. Matan torres
            3. Matan ancient
        """.trimIndent()
    }
    fun main(args: Array<String>){
        val url = "https://next.json-generator.com/api/json/get/EkvuqxSir"
        val (request, response, result) = Fuel.get(url).responseObject(Heroe.HeroeArrayDeserializer())
        val (heroes, err) = result
        //heroes?.forEach { println(it) }
        Thread.sleep(5000)
    }
