import java.util.*

class Equipo(val heroes: ArrayList<Heroe> = arrayListOf(), val torres: ArrayList<Torre> = arrayListOf(Torre(), Torre(), Torre(), Torre(), Torre(), Torre()), val ancient: Ancient = Ancient()) {
    fun agregarHeroe(heroe:Heroe){
        //Se agreagan los heroes al array para conformar el equipo
        heroes.add(heroe)
    }

    //Funcion para cuando matan a un Ancient en el equipo
    fun ancientMuerto(): Boolean {
        //Simple ciclo for que retorna falso al matarla
        for (torre in torres) {
            if (torre.estaViva) {
                return false
            }
        }
        ancient.matarAncient()
        return true
    }

    //Funcion para cuando matan una torre del equipo
    //Se importa la funcion random para que elimine una torre random de las 6
    fun torreMuerta(): Boolean {
        //Array que almacena las torres restantes o vivas
        val torresRestantes = arrayListOf<Torre>()
        for (torre in torres) {
            if (torre.estaViva) { torresRestantes.add(torre) }
        }
        if (torresRestantes.size >= 1) {
            var cont = true
            do {
                val randomID = Random().nextInt((torres.size-1))
                if (torres[randomID].estaViva) {
                    torres[randomID].matarTorre()
                    cont = false
                }
            } while (cont)
            if (torresRestantes.size == 1) {
                //Si retorna falso es porque ya no hay torres vivas y se puede matar al ancient
                return false
            }
            return true
        }
        //Si retorna falso es porque ya no hay torres vivas y se puede matar al ancient
        return false
    }
}