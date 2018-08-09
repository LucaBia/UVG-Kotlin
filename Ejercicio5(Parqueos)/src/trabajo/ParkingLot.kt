package trabajo

import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

class ParkingLot(
        //val name: String,
        var levels: ArrayList<Level> = ArrayList()
){

    fun createLevel(file:String, name:String, id:String, color:String):Level{
        val map :ArrayList<Array<String>> = ArrayList()
        try {
            val lines = Files.lines(
                    Paths.get("/Users/gianlucariverabiagioni/Desktop/UVG-Kotlin/Ejercicio5(Parqueos)/$file"),
                    StandardCharsets.UTF_8
            )
            lines.forEach { a -> map.add(a.split("").toTypedArray()) }
        } catch (e: IOException) {
            println("Error al encontrar el archivo")
        }
        val newNivel = Level(name, id, color, file, map.size, map[0].size)
        for (i in 0 until newNivel.height){
            for (j in 0 until newNivel.width){
                val character= map[i][j]
                when (character){
                    " "-> {
                        val emptySpace = ""
                    }
                    "*"->{
                        val newWall = Wall(i,j)
                        newNivel.addWall(newWall)
                    }
                    else->{
                        val newParking = Parking(i, j, character)
                        newNivel.addParking(newParking)
                    }
                }
            }
        }

        return newNivel


    }

    fun findLevel(searchName: String): Level? {
        val filteredLevels = levels.filter { it.name == searchName }
        if (filteredLevels.count() > 0) return filteredLevels[0]
        return null
    }

    fun findId(searchId: String): Level? {
        val filteredLevels = levels.filter { it.id == searchId }
        if (filteredLevels.count() > 0){
            return filteredLevels[0]
        }
        return null
    }


    fun findColor(searchColor: String): Level? {
        val filteredLevels = levels.filter { it.color == searchColor }
        if (filteredLevels.count() > 0){
            return filteredLevels[0]
        }
        return null
    }

    fun addLevel(level: Level): Boolean {
        if (findLevel(level.name) == null) {
            levels.add(level)
            return true
        }
        return false
    }

    fun removeLevel(id: String): Boolean {
        if(findId(id) != null) {
            levels.remove(findId(id))
            return true
        }
        return false
    }

    fun findLevelBool(level: String): Int? {
        val filtrateLevels = levels.filter { it.id == level }
        if (filtrateLevels.count() > 0 ){
            return levels.indexOf(filtrateLevels[0])
        }
        return null
    }

    override fun toString(): String {
        val levelNames = levels.map { it.name }.joinToString().split("\n ")
        val levelId = levels.map { it.id }.joinToString().split("\n ")
        val levelColors = levels.map { it.color }.joinToString().split("\n ")
        //var hola = levels.forEach{ it.name }
        for (item in levelNames){
            for (item2 in levelId){
                for (item3 in levelColors){
                    println(item + "\n" + item2 + "\n" + item3)
                }
            }
        }
        //val levelNames = levels.joinToString()
        return """
            Nivel:
                Nombre: $levelNames
        """.trimIndent()


        /*var map = ""

        levels.forEach {
            map += it
        }

        return map*/


    }



}

