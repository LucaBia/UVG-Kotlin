package trabajo


class Menu(){
    var Admin: Boolean = true

    fun getMenu(option: Int): String{
        if (option == 2){
            Admin = false
            return """
            Menu:
                1. Ingresar placa
                2. Salir
        """.trimIndent()
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

    fun isAdmin():Boolean{
        return Admin
    }
}

