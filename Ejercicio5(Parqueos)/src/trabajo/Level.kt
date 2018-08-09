package trabajo

class Level(
        val name: String,
        val id: String,
        val color: String,
        val file: String,
        val height: Int,
        val width: Int,
        private var cars: ArrayList<Car> = ArrayList(),
        private var parkings: ArrayList<Parking> = ArrayList(),
        private var walls: ArrayList<Wall> = ArrayList()
){

    /*fun findLicensePlate(number: String): Car?{
        val filteredLicensePlates = cars.filter { it.licensePlate == number}
        if(filteredLicensePlates.count() > 0){
            return filteredLicensePlates[0]
        }
        return null
    }*/

    fun findLicensePlate(number: String): Boolean{
        val filteredLicensePlates = cars.filter { it.licensePlate == number}
        if(filteredLicensePlates.count() > 0){
            return true
        }
        return false
    }

    fun addLicensePlate(car: Car): Boolean{
        if(findLicensePlate(car.licensePlate) == null){
            cars.add(car)
            return true
        }
        return false
    }

    fun addWall(wall: Wall){
        walls.add(wall)
    }

    fun addParking(parking: Parking){
        parkings.add(parking)
    }

    fun checkSpaces():Boolean{
        for (i in 0 until height){
            for (j in 0 until width){
                for (k in parkings) {
                    if (k.character != "@") {
                        return true
                    }
                }
            }
        }
        return false
    }

    fun checkParking(character:String):Boolean{
        for (i in parkings){
            if (i.character == character){
                i.character="@"
                return true
            }
        }
        return false
    }

    private fun ifWall(x: Int, y: Int): Boolean {
        for (i in walls){
            if (i.xPosition == x && i.yPosition == y){
                return true
            }
        }
        return false
    }
    private fun ifParking(x: Int, y: Int):Boolean {
        for (i in parkings){
            if (i.xPosition == x && i.yPosition == y){
                return true
            }
        }
        return false
    }
    private fun getParking(x: Int, y: Int):Parking? {
        for (i in parkings){
            if (i.xPosition == x && i.yPosition == y){
                return i
            }
        }
        return null
    }

    override fun toString(): String {
        var map = ""
        for (i in 0 until height){
            for (j in 0 until width) {
                if (ifWall(i, j)){
                    map+="*"
                }else if (ifParking(i, j)){
                    val character = getParking(i, j)
                    map+= character
                }else{
                    map+=" "
                }
            }
            map+="\n"
        }
        return """
            Mapa:

$map
        """.trimIndent()
    }

}

