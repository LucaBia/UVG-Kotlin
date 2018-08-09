package trabajo


class Menu {
    var admin: Boolean = true

    fun getMenu(option: Int): String{
        if (option == 2){
            admin = false
            return """
            Menu:
                1. Ingresar placa
                2. Salir
        """.trimIndent()
        }else if (option >= 3){
            return "Esta opcion no se encuentra en el menu"
        }
        return """
        Menu:
            1. Crear nivel
            2. Eliminar nivel
            3. Ver todos los niveles
            4. Salir
    """.trimIndent()
    }

    //TODO: revisar que despues de 3 no imprima el menu admin
}

