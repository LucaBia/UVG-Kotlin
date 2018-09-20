package figuras

import acciones.Describible
import acciones.Dibujable

//Solicitar longitud


//Clase que implementa las interfaces Describible y Dibujable
class Cuadrado: Describible, Dibujable {
    //Variables
    override var base: Int
    override var altura: Int

    //Constructor
    constructor(_longitud: Int = 0){
        base = _longitud
        altura = _longitud
    }

    //Metodo que pide los datos del cuadrado es decir para saber la dimension que va a tener el cuadrado
    override fun datos(){
        println("Ingrese la base del cuadrado")
        var baseCuadrado = readLine()!!.toInt()
        base = baseCuadrado
        altura = base
    }

    //Metodo que funciona por medio de un for para colocar asteriscos y dibujar
    override fun dibujar(){
        for (i in 1..altura){
            for (j in 1..base){
                print("* ")
            }
            print("\n")
        }

    }
}