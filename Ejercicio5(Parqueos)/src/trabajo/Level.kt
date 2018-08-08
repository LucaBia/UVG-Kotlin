package trabajo

class Level(
        val name: String,
        val id: Int,
        val color: String,
        //val width: Int,
        //val height: Int,
        private var cars: ArrayList<Car> = ArrayList()
){

    fun findLicensePlate(number: String):Boolean{
        val filteredLicensePlates = cars.filter { it.licensePlate == number}
        if(filteredLicensePlates.count() > 0){
            return true
        }
        return false
    }

    fun addLicensePlate(numberPLate: Car): Boolean{
        if(!findLicensePlate(numberPLate.licensePlate)){
            cars.add(numberPLate)
            return true
        }
        return false
    }
    /*override fun toString(): String {
        var nivel = """
            $name
            $id
            $color

        """.trimIndent()

        for (//alto) {
            for (//ancho) {
                if ()
            }
        }

        return nivel
    }*/
}

