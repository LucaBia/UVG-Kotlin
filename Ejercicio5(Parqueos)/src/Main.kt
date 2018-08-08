import trabajo.*
import java.io.File
import java.io.InputStream
import javax.swing.text.StyledEditorKit


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

        if (miMenu.Admin.equals(true)) {
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
                        val id = readLine()!!.toInt()
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
                                //Leer archivo
                                val inputStream: InputStream = File(file).inputStream()
                                val inputString = inputStream.bufferedReader().use { it.readText() }
                                println(inputString)

                                val level = Level(name, id, color)
                                myParkingLot.addLevel(level)
                                println("Nivel agregado exitosamente")

                            }

                        }
                    }

                }
                2 -> {
                    println("Ingrese el identificador del nivel para eliminarlo: ")
                    val deleteLevel = readLine()!!.toInt()
                    if (myParkingLot.findId(deleteLevel) != null){
                        myParkingLot.removeLevel(deleteLevel)
                    }
                }
                3 ->{
                    myParkingLot.levels.forEach { level -> println("""
                        Nombre: ${level.name}
                        ID: ${level.id}
                        Color: ${ level.color}

                    """.trimIndent()) }

                }
                4 -> {
                    //wantsToContinue = false
                    miMenu.Admin = false
                }
            }
        } else {
            var haveLicensePlate: Boolean = false
            println("Ingrese una opcion del menu (1-2)")
            val driverOption = readLine()!!.toInt()
            when (driverOption) {
                1 -> {
                    print("Ingrese el numero de placa de su vehiculo: ")
                    var licensePlate = readLine()!!
                    for (item in myParkingLot.levels){
                        if (item.findLicensePlate(licensePlate)){
                            haveLicensePlate = true
                        }
                    }

                    if (haveLicensePlate){
                        println("Esta placa ya ha sido registrada.")
                        //TODO 5puntos extra
                    }else {
                        var avaibleSpaces: Boolean = true
                        for (item in myParkingLot.levels){

                        }
                    }
                }

                2 -> {
                    miMenu.Admin = true
                }
            }
        }
    }while (wantsToContinue)
}