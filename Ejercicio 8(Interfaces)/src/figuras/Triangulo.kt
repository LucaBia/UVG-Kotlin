package figuras

import acciones.Describible
import acciones.Dibujable

//Solicitar altura


//Clase que implementa las interfaces Describible y Dibujable
class Triangulo: Describible, Dibujable{
    override var altura: Int
    override var base: Int

    constructor(_altura: Int=0, _base:Int=0){
        altura = _altura
        base = _base

    }

    override fun datos(){
        println("Ingrese el alto del triangulo")
        val altoTriangulo = readLine()!!.toInt()
        altura = altoTriangulo
        base = altura

    }

    //Metodo que funciona por medio de un for para colocar asteriscos y dibujar
    override fun dibujar(){
        var resolucion = ""
        var a = 1
        for (i in 1..altura){
            for (j in 1..altura-a){
                resolucion += " "
            }
            for (k in 1..a){
                resolucion += " *"
            }
            resolucion += "\n"
            a += 1
        }
        println(resolucion)
    }
}