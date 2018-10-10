import java.util.*

//Puede recibir un cualquier cosa
class BoxOfChocolate <cualquierCosa> (var chocolates: ArrayList<cualquierCosa>) {
    //Clase con generador random de la lista de chocolates
    fun pickOne(): cualquierCosa?{
        if (chocolates.size > 0){
            return chocolates.removeAt(Random().nextInt(chocolates.size))
        }
        return null
    }
}