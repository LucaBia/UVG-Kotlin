package toDo

class Lista(val nombreLista: String,
            private var tareas: ArrayList<Tarea> = ArrayList()){
    var tieneLista: Boolean = false



    fun findTarea(nombre: String): Tarea?{
        val filteredTarea = tareas.filter { it.nombreTarea == nombre }
        if(filteredTarea.count() > 0){
            return filteredTarea[0]
        }
        return null
    }

    fun addTarea(tarea: Tarea): Boolean {
        if (findTarea(tarea.nombreTarea) == null) {
            tareas.add(tarea)
            return true
        }

        return false
    }

    fun tieneLista(): Boolean {
        return this.tieneLista
    }

    fun siLista(){
        tieneLista = true
    }

    fun noLista(){
        tieneLista = false
    }

    fun getTareas(){

    }

    /*override fun toString(): String {
        return """
            Lista:
                tieneLista: $tieneLista
        """.trimIndent()
    }*/



}

