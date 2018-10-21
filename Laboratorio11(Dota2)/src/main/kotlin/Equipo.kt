class Equipo(val heroes: ArrayList<Heroe> = arrayListOf(), val torres: ArrayList<Torre> = arrayListOf(Torre(), Torre(), Torre(), Torre(), Torre(), Torre()), val ancient: Ancient = Ancient()) {
    fun agregarHeroe(heroe:Heroe){
        //Se agreagan los heroes al array para conformar el equipo
        heroes.add(heroe)
    }
}