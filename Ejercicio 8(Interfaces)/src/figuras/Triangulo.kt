package figuras

import acciones.Describible
import acciones.Dibujable

//Solicitar altura


//Clase que implementa las interfaces Describible y Dibujable
class Triangulo: Describible, Dibujable{
    override var altura: Int
    var base: Int

    constructor(_altura: Int=0, _base:Int=0){
        altura = _altura
        base = _base

    }

    override fun datos(){
        println("Ingrese el alto del triangulo")
        val altoTriangulo = readLine()!!.toInt()
        altura = altoTriangulo
    }

    //Metodo que funciona por medio de un for para colocar asteriscos y dibujar
    override fun dibujar(){
        for (i in 1..altura){
            for (j in 1..altura){
                print("i")
            }
            print("\n")
        }
    }
}