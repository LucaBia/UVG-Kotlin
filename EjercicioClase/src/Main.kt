import java.util.*

fun main(args: Array<String>) {
    val cajaChocolates = BoxOfChocolate<Chocolate>(arrayListOf<Chocolate>(
            Chocolate("Hershey", 250, "Chocolate de Leche"),
            Chocolate("Snicker", 270, "Caramelo-manias"),
            Chocolate("Reeses", 210, "Mantequilla de maní"),
            Chocolate("m&m", 230, "Original"),
            Chocolate("Kinder", 112, "Leche")
    ))

    val forrest = ForrestGump<Chocolate>(cajaChocolates)
    println(forrest.def())
    println()
    println(forrest.def())
    println()
    println(forrest.def())
    println()
    println(forrest.def())
    println()
    println(forrest.def())
    println()
    println(forrest.def())
    println()
    println(forrest.def())
}