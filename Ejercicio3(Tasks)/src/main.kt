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

fun getListasMenu(): String{
    var resultado = ""

    for(i in listas.indices){
        resultado += "${i + 1} ${listas[i].nombreLista}\n "
    }
    return resultado
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
                    if(findLista(nombreListaNueva) != null){
                        println("Esta lista ya ha sido registrada anteriormente")
                    }else{
                        val listaNueva = Lista(nombreListaNueva)
                        addLista(listaNueva)
                        println("Nueva lista agregada exitosamente!")
                    }
                }
                2 -> {
                    println(getListasMenu())

                }
                3 -> {
                    println(getListasMenu())
                    println("")
                    print("Ingrese el numero de la lista a seleccionar: ")
                    val opcionlista = readLine()!!.toInt()
                    println("Lista Seleccionada exitosamente ($opcionlista)")
                    println("")
                    println("""
                        1. Deseleccionar lista actual
                        2. Agregar una tarea
                        3. Completar una tarea
                        4. Ver todas las tareas en esta lista
                        5. Salir
                    """.trimIndent())

                    when (opcionlista){
                        1 -> {
                            println(getMenu(lista.tieneLista()))
                        }
                        2 -> {
                            println("Ingrese el titulo de la nueva tarea: ")
                            val nombreTareaNueva = readLine()!!
                            if(lista.findTarea(nombreTareaNueva) != null){
                                println("Esta tarea ya ha sido registrada anteriormente")
                            }else{
                                val tareaNueva = Lista(nombreTareaNueva)
                                //lista.addTarea(tareaNueva)
                                println("Nueva tarea agregada exitosamente!")
                            }
                        }
                    }

                }
                4 -> {
                    wantsToContinue = false
                    println("Has salido del programa, gracias por utilizarlo")
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

