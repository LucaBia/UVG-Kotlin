import trabajo.*

fun main(args: Array<String>){
    val miMenu = Menu()
    val myParkingLot = ParkingLot()
    var wantsToContinue = true
    do {
        println("""
            Menu:
                1. Administrador
                2. Conductor
                3. Salir
        """.trimIndent())
        val option = readLine()!!.toInt()
        println(miMenu.getMenu(option))

        if (miMenu.admin) {
            println("Ingrese una opcion del menu (1 - 4): ")
            val adminOption = readLine()!!.toInt()
            when (adminOption) {
                1 -> {
                    print("Nombre: ")
                    val name = readLine()!!


                    if (myParkingLot.findLevel(name) != null){
                        println("Este Nivel ya ha sido registrado anteriormente")
                    }else{
                        print("Identificador: ")
                        val id = readLine()!!
                        if (myParkingLot.findId(id) != null){
                            println("Este Id ya ha sido utilizado anteriormente")
                        }else{
                            print("Color: ")
                            val color = readLine()!!
                            if (myParkingLot.findColor(color) != null){
                                println("Este color ya ha sido registrado anteriormente")
                            }else{
                                println("Archivo de estructura: ")
                                val file = readLine()!!
                                val newLevel = myParkingLot.createLevel(file, name, id, color)
                                if(myParkingLot.addLevel(newLevel)){
                                    println(file)
                                    println("Nivel agregado exitosamente")
                                }else{
                                    println("Este nivel ya ha sido creado anteriormente")
                                }



                            }

                        }
                    }

                }
                2 -> {
                    println("Ingrese el identificador del nivel para eliminarlo: ")
                    val deleteLevel = readLine()!!
                    if (myParkingLot.findId(deleteLevel) != null){
                        myParkingLot.removeLevel(deleteLevel)
                    }
                }
                3 ->{
                    myParkingLot.levels.forEach { level -> println("""
                        Nombre: ${level.name}
                        ID: ${level.id}
                        Color: ${level.color}
                        Estructura: ${level.file}

                    """.trimIndent()) }

                }
                4 -> {
                    //wantsToContinue = false
                    miMenu.admin = false
                }
            }
        } else {
            println("Ingrese una opcion del menu (1-2)")
            val driverOption = readLine()!!.toInt()
            when (driverOption) {
                1 -> {
                    var havelicensePLate = false
                    print("Ingrese el numero de placa de su vehiculo: ")
                    val licensePlate = readLine()!!
                    for (i in myParkingLot.levels){
                        if (i.findLicensePlate(licensePlate)){
                            havelicensePLate = true
                        }
                    }
                    if (havelicensePLate){
                        println("Este numero de placa ya ha sido registrada anteriormente")
                        //TODO Extra 5 puntos
                        /*for (i in myParkingLot.levels){
                            if (i.findLicensePlate(licensePlate)){
                                val levelofLicense = myParkingLot.levels.indexOf(i)
                                println("La placa tiene los siguientes datos: ")
                                println(myParkingLot.levels[levelofLicense])
                            }
                        }*/
                    }else {
                        var blankSpaces = false
                        var levelsAvaible = "Niveles con estacionamiento disponible: \n"
                        for (i in myParkingLot.levels){
                            i.checkSpaces()
                            if (i.checkSpaces()){
                                levelsAvaible += i.id + "\n"
                                blankSpaces = true
                            }
                        }
                        if (blankSpaces) {
                            println(levelsAvaible)
                            print("Ingrese el identificador del nivel: ")
                            val nivel = readLine()!!
                            if (nivel in levelsAvaible) {
                                println(myParkingLot.levels[myParkingLot.findLevelBool(nivel)!!])
                                print("Ingrese el numero o letra del estacionamiento donde desea estacionarse: ")
                                val place = readLine()!!
                                if (place!="@") {
                                    if(myParkingLot.levels[myParkingLot.findLevelBool(nivel)!!].checkParking(place)) {
                                        val newPlaca = Car(licensePlate)
                                        myParkingLot.levels[myParkingLot.findLevelBool(nivel)!!].addLicensePlate(newPlaca)
                                    }else{
                                        println("El numero de estacionamiento ingresado no se encuentra en este nivel")
                                    }
                                }else{
                                    println("el '@' significa que el estacionamiento esta ocupado")
                                }
                            }
                        }
                    }
                }

                2 -> {
                    miMenu.admin = true
                }
            }
        }
    }while (wantsToContinue)
}