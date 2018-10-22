import Narrador

class NarradorItaliano: Narrador {
    override fun narrar (tipoEvento: String): String {
        when(tipoEvento) {
            "bienvenida" -> {
                return "Benvenuto a Dota 2"
            }

            "empezarJuego" -> {
                return "Che il gioco cominci"
            }

            "unKill" -> {
                return "Hanno ucciso un eroe della tua squadra"
            }

            "masKills" -> {
                return "Hanno ucciso diversi eroi della tua squadra"
            }

            "cincoKills" -> {
                return " 'Multi-kill' Hanno ucciso  5 eroi della tua squadra"
            }

            "Torre" -> {
                return "Hanno ucciso una torre della tua squadra"
            }

            "dire" -> {
                return "Dire vince il gioco!"
            }

            "radiant" -> {
                return "Radian vince il gioco!"
            }

            else -> {
                return "Quello che ha inserito non fa parte dei comandi del gioco, l'opzione non è valida"
            }
        }
    }
}