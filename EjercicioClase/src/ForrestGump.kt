class ForrestGump<cualquierCosa>(val life: BoxOfChocolate<cualquierCosa>){
    fun def(): String{
        val picked = life.pickOne()
        //Validación chocolates
        if(picked == null){
            return "LA VIDA APESTA"
        }
        return "LA VIDA ES COMO UNA CAJA DE CHOCOLATES \n${picked}"
    }
}