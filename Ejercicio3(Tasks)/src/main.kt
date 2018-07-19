package main

import toDo.*

var listas: ArrayList<Lista> = ArrayList()

fun getMenu(tieneLista: Boolean): String{
        if(!tieneLista){
            return """
                1. Crear lista de tareas
                2. Salir
            """.trimIndent()
        }
    return """
        1. Crear lista de tareas
        2. Ver todas las listas de tareas
        3. Seleccionar una lista de tareas
        4. Salir
    """.trimIndent()
}

fun findLista(nombre: String): Lista?{
    val filteredLista = listas.filter { it.nombreLista == nombre }
    if(filteredLista.count() > 0){
        return filteredLista[0]
    }
    return null
}

fun addLista(lista: Lista): Boolean {
    if (findLista(lista.nombreLista) == null) {
        listas.add(lista)
        return true
    }

    return false
}

fun toString(): String {
    val nombresLista = listas.map { it.nombreLista }.joinToString()
    return """
            Lista: $nombresLista \n
        """.trimIndent()
}



fun main(args: Array<String>){

    var wantsToContinue = true
    val lista = Lista("miLista")
    do{
        println(getMenu(lista.tieneLista()))
        println("Ingrese una opcion del menu: ")
        val opcion = readLine()!!.toInt()
        if(lista.tieneLista()){
            when (opcion){
                1 -> {
                    println("Ingrese el nombre de su nueva lista de tareas: ")
                    val nombreListaNueva = readLine()!!
                    if(lista.findTarea(nombreListaNueva) != null){
                        println("Esta lista ya ha sido registrada anteriormente")
                    }else{
                        val listaNueva = Lista(nombreListaNueva)
                        addLista(listaNueva)
                        println("Nueva lista agregada exitosamente!")
                    }
                }
                2 -> {
                    println(toString())

                }
                3 -> {

                }
                4 -> {

                }
            }
        }else{
            when (opcion){
                1 -> {
                    lista.siLista()
                }

                2 ->{
                     wantsToContinue = false
                }
            }
        }
    }while (wantsToContinue)


}

