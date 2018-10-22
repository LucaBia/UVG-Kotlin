import Narrador

class NarradorEspanol: Narrador {
    override fun narrar (tipoEvento: String): String {
        when(tipoEvento) {
            "bienvenida" -> {
                return "Bienvenido a Dota 2"
            }

            "empezarJuego" -> {
                return "Que el juego comience"
            }

            "unKill" -> {
                return "Han matado a un heroe de tu equipo"
            }

            "masKills" -> {
                return "Han matado a varios heroes de tu equipo"
            }

            "cincoKills" -> {
                return " 'Multi-kill' Han matado a 5 heroes de tu equipo"
            }

            "Torre" -> {
                return "Han matado una torre de tu equipo"
            }

            "dire" -> {
                return "Dire gana el juego!"
            }

            "radiant" -> {
                return "Radian dana el juego!"
            }

            else -> {
                return "Lo que ha ingresado no hace parte de los comandos del juego, la opción no es valida"
            }
        }
    }
}