import com.github.kittinunf.fuel.Fuel
import java.util.*


fun menuNarrador(): String{
    return """
            ***************************
                      DOTA 2
            ***************************

            Seleccióna al narrador:
            1. Español
            2. Inglés
            3. Italiano
            4. Salir

        """.trimIndent()
    }

    fun menuInicioJuego(): String{
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
        println("Cargando Dota 2...")
        //Conexion api
        val url = "https://next.json-generator.com/api/json/get/EkvuqxSir"
        val (request, response, result) = Fuel.get(url).responseObject(Heroe.HeroeArrayDeserializer())
        val (apiHeroes, err) = result
        Thread.sleep(5000)

        //Variable para el do-while
        var quiereContinuar = true
        //Variable para readline
        var opcion: String
        var narradorDePartida: Narrador

        do {
            //Se imprime el primer menu para saber en que idioma desea la narracion
            println(menuNarrador())
            opcion = readLine()!!

            when(opcion) {
                "1", "2", "3" -> {
                    //Se asigna el idioma del narrador segun lo ingresado por el usuario
                    narradorDePartida = if (opcion == "1") {
                        NarradorEspanol()
                    }else if(opcion == "2"){
                        NarradorIngles()
                    }else{
                        NarradorItaliano()
                    }

                    //Se obtienen para guardar loe heroes del api
                    val heroes = arrayListOf<Heroe>()
                    apiHeroes?.forEach{ heroes.add(it) }

                    //Se definen los equipos
                    val equipoRadiant = Equipo()
                    val equipoDire = Equipo()
                    //Se define un partido
                    val partida = Partido<Narrador>(equipoRadiant, equipoDire, narradorDePartida)
                    println(partida.bienvenida())

                    //se coloca la restriccion de heroes por usuario
                    var maximoDeHeroes = 5
                    var eleccion: Int
                    //Array de los heroes que estan disponibles
                    val heroesPorElegir = arrayListOf<Heroe>()
                    //Ciclo for para seleccionar a 25 heroes del api pero al azar, por lo que los numeros no an en orden
                    for (i in 1..20) {
                        val id = Random().nextInt((heroes.size-1))
                        heroesPorElegir.add(heroes[id])
                        heroes.remove(heroes[id])
                    }

                    var eleccion2: Boolean
                    while(maximoDeHeroes > 0) {
                        println("\n")
                        eleccion2 = true

                        //Ciclo do-while para la seleccion de heroes para Radiant
                        do {
                            heroesPorElegir.forEach { println("${it.id}. ${it.localized_name} (${it.tipo})") }
                            println("Seleccion de Héroes Radiant:")
                            eleccion = readLine()!!.toInt()

                            for(heroe in heroesPorElegir) {
                                //If para agregar al heroe al equipo Radiant
                                if (heroe.id == eleccion) {
                                    partida.equipoRadiant.agregarHeroe(heroe)
                                    println("${heroe.localized_name} se ha agregado a Radiant.")
                                    //Se elimina el heroe que acaba de seleccionar
                                    heroesPorElegir.remove(heroe)
                                    eleccion2 = false
                                    //Se sale del ciclo
                                    break
                                }
                            }
                        } while (eleccion2)

                        eleccion2 = true
                        println()
                        //Ciclo do-while para la seleccion de heroes para Dire
                        do {
                            heroesPorElegir.forEach { println("${it.id}. ${it.localized_name} (${it.tipo})") }
                            println("Selección de Héroes Dire:")
                            eleccion = readLine()!!.toInt()

                            for(heroe in heroesPorElegir) {
                                //If para agregar al heroe al equipo Dire
                                if (heroe.id == eleccion) {
                                    partida.equipoDire.agregarHeroe(heroe)
                                    //Comprobacion
                                    println("${heroe.localized_name} se ha agregado a Dire.")
                                    //Se elimina el heroe ya seleccionado
                                    heroesPorElegir.remove(heroe)
                                    eleccion2 = false
                                    break
                                }
                            }
                        } while (eleccion2)

                        //Restador a la cantidad maxima de heroes por equipo
                        maximoDeHeroes -= 1
                    }

                    //-------------------------Inicio del Juego----------------------------------
                    println(partida.empezarJuego())

                    //Variable para el ciclo do-while
                    var sinGanador = true
                    var opcionInicioJuego: String
                    //Variable para saber el matador
                    var matoRadiant: Boolean

                    do {
                        //Se imprime el segundo menu
                        println(menuInicioJuego())
                        opcionInicioJuego = readLine()!!

                        when(opcionInicioJuego) {
                            "1" -> {
                                var r_o_d = false
                                do {
                                    println("Fue Radiant quien mato? si/no")
                                    val fueRadiant = readLine()!!
                                    when(fueRadiant) {
                                        "si", "Si", "SI", "no", "No", "NO" -> {
                                            r_o_d = true
                                            matoRadiant = fueRadiant == "si"

                                            var validacionCantidad = false
                                            //Se pregunta la cantidad de muertes y segun eso se realiza la operacion
                                            do {
                                                println("Cuantas muertes? 0 - 5")
                                                val cantidadMuertes = readLine()!!
                                                when(cantidadMuertes) {
                                                    "0" -> {
                                                        validacionCantidad = true
                                                    }
                                                    "1" -> {
                                                        if (partida.juego_UnKill(matoRadiant) == "false") {
                                                            validacionCantidad = false
                                                        } else {
                                                            validacionCantidad = true
                                                            println(partida.juego_UnKill(matoRadiant))
                                                        }
                                                    }
                                                    "2", "3", "4" -> {
                                                        val cantMuertesInt = cantidadMuertes.toInt()
                                                        if (partida.juego_masKills(matoRadiant, cantMuertesInt) == "false") {
                                                            validacionCantidad = false
                                                        } else {
                                                            validacionCantidad = true
                                                            println(partida.juego_masKills(matoRadiant, cantMuertesInt))
                                                        }
                                                    }
                                                    "5" -> {
                                                        if (partida.juego_cincoKills(matoRadiant) == "false") {
                                                            validacionCantidad = false
                                                        } else {
                                                            validacionCantidad= true
                                                            println(partida.juego_cincoKills(matoRadiant))
                                                        }
                                                    }
                                                    else -> println("La opcion no es valida")
                                                }
                                            } while (!validacionCantidad)
                                        }
                                        else -> println("La opcion no es valida")
                                    }
                                } while (!r_o_d)

                            }
                            "2" -> {

                                var radiantODire = false
                                do {
                                    println("Fue Radiant quien mato? si/no")
                                    val fueRadiantLec = readLine()!!
                                    when(fueRadiantLec) {
                                        "si", "no" -> {
                                            radiantODire = true
                                            matoRadiant = fueRadiantLec == "si"

                                            //Se valida si se puede matar un ancint
                                            if (partida.juego_torre(matoRadiant) == "false") {
                                                println(menuFinal())
                                                val opcion3 = readLine()!!




                                            } else {
                                                println(partida.juego_torre(matoRadiant))
                                            }
                                        }
                                        else -> println("Opcion no valida")
                                    }
                                } while (!radiantODire)
                            }
                            else -> println("Opcion no valida")
                        }

                    } while (sinGanador)

                }
                "4" -> quiereContinuar = false
                else -> println("Opcion no valida")
            }

        } while (quiereContinuar)
    }
