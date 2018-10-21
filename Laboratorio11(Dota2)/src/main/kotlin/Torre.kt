data class Torre(var estaViva: Boolean = true ) {
    fun matarTorre(){
        estaViva = false
    }
}