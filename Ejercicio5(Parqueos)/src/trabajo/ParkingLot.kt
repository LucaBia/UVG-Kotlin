package trabajo

class ParkingLot(
        //val name: String,
        var levels: ArrayList<Level> = ArrayList()
){

    fun findLevel(searchName: String): Level? {
        val filteredLevels = levels.filter { it.name == searchName }
        if (filteredLevels.count() > 0){
            return filteredLevels[0]
        }
        return null
    }

    fun findId(searchId: Int): Level? {
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

    fun removeLevel(id: Int): Boolean {
        if(findId(id) != null) {
            levels.remove(findId(id))
            return true
        }
        return false
    }

    override fun toString(): String {
        val levelNames = levels.map { it.name }.joinToString().split(", ")
        levelNames.forEach { it }
        var hola = levels.forEach{ it.name }
        for (item in levelNames){
            println(item)
        }
        //val levelNames = levels.joinToString()
        return """
            Nivel:
                Nombre: $levelNames
        """.trimIndent()
    }



}

