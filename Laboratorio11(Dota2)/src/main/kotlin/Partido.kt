
class Partido<T>(val equipoRadiant: Equipo, val equipoDire: Equipo, val narrador: T) where T: Narrador{

    //Funcion que narra los eventos del partido
    fun narracion(narrador: Narrador, evento: String): String {
        return narrador.narrar(evento)
    }

    //Funcion que narra la bienvenida del juego
    fun bienvenida(): String {
        return narracion(narrador, "bienvenida")
    }

    //Funcion que narra el inicio del juego
    fun empezarJuego(): String {
        return narracion(narrador, "empezarJuego")
    }

    //Funcion que nara una muerte de heroes
    fun juego_UnKill(matonRadiant: Boolean): String {
        if (matonRadiant) {
            return if (equipoDire.kill(1)) {
                narracion(narrador, "unKill")
            } else {
                "false"
            }
        } else {
            return if (equipoRadiant.kill(1)) {
                narracion(narrador, "unKill")
            } else {
                "false"
            }
        }
    }

    //Función que narra dos o mas muertes de heroes
    fun juego_masKills(matonRadiant: Boolean, cantidadMuertes: Int): String {
        if (matonRadiant) {
            return if (equipoDire.kill(cantidadMuertes)) {
                narracion(narrador, "masKills")
            } else {
                "false"
            }
        } else {
            return if (equipoRadiant.kill(cantidadMuertes)) {
                narracion(narrador, "masKills")
            } else {
                "false"
            }
        }
    }

    //Funcion para cinco muertes de heroes
    fun juego_cincoKills(matonRadiant: Boolean): String {
        if (matonRadiant) {
            return if (equipoDire.kill(5)) {
                narracion(narrador, "cincoKills")
            } else {
                "false"
            }
        } else {
            return if (equipoRadiant.kill(5)) {
                narracion(narrador, "cincoKills")
            } else {
                "false"
            }
        }
    }

    //Funcion cuando muere una torre
    fun juego_torre(matonRadiant: Boolean): String {
        if (matonRadiant) {
            return if (equipoDire.torreMuerta()) {
                narracion(narrador, "Torre")
            } else {
                "false"
            }
        } else {
            return if (equipoRadiant.torreMuerta()) {
                narracion(narrador, "Torre")
            } else {
                "false"
            }
        }
    }

    //Funcion cuando gana el equipo de Radiant
    fun radiantGana(): String {
        //GANA EL EQUIPO RADIANT
        equipoDire.ancientMuerto()
        return narracion(narrador, "radiant")
    }

    //Funcion cuando gana el equipo de Dire
    fun direGana(): String {
        equipoRadiant.ancientMuerto()
        return narracion(narrador, "dire")
    }

}