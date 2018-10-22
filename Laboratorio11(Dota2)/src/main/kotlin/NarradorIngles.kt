import Narrador

class NarradorIngles:Narrador {
    override fun narrar (tipoEvento: String): String {
        when(tipoEvento) {
            "bienvenida" -> {
                return "Welcome to Dota 2"
            }

            "empezarJuego" -> {
                return "Let the game begin"
            }

            "unKill" -> {
                return "A hero of your team has been killed"
            }

            "masKills" -> {
                return "Several heroes of your team have been killed"
            }

            "cincoKills" -> {
                return " 'Multi-kill' 5 heroes of your team have been killed"
            }

            "Torre" -> {
                return "a tower of your team has been killed"
            }

            "dire" -> {
                return "Dire wins the game!"
            }

            "radiant" -> {
                return "Radian wins the game!"
            }

            else -> {
                return "What you have entered is not part of the game's commands, the option is not valid"
            }
        }
    }
}