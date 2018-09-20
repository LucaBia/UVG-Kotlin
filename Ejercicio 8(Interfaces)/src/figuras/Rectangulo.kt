package figuras

import acciones.Describible
import acciones.Dibujable

//Solicitar largo y ancho


//Clase que implementa las interfaces Describible y Dibujable
class Rectangulo: Describible, Dibujable {
    override var altura: Int
    override var base: Int

    constructor(_largo: Int=0, _ancho: Int=0){
        altura = _largo
        base = _ancho
    }

    //Metodo que pide los datos del rectangulo es decir para saber la dimension que va a tener el cuadrado
    override fun datos(){
        println("Ingrese la base del rectangulo")
        val baseRectangulo = readLine()!!.toInt()
        base = baseRectangulo
        println("Ingrese el alto del rectangulo")
        val altoRectangulo = readLine()!!.toInt()
        altura = altoRectangulo
    }

    //Metodo que funciona por medio de un for para colocar asteriscos y dibujar
    override fun dibujar(){
        for (i in 1..altura){
            for (j in 1..base){
                print("*")
            }
            print("\n")
        }
    }

}