import com.github.kittinunf.fuel.Fuel
import dbmodels.Cancion
import models.LecturaCancion
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    val url = "https://next.json-generator.com/api/json/get/EkeSgmXycS"

    Fuel.get(url).responseObject(LecturaCancion.LecturaCancionArrayDeserializer()){ request, response, result ->
        val (canciones, err) = result
        canciones?.forEach{ println(it) }
    }

    Database.connect(
            "jdbc:postgresql:musica",
            "org.postgresql.Driver",
            "postgres",
            "postgres"
    )

    transaction {
        SchemaUtils.create(Cancion)

        println("Estas son las canciones: ")
        for(cancion in Cancion.selectAll()) {
            println("${cancion[Cancion.song]}: ${cancion[Cancion.year]}")
        }

    }

    Thread.sleep(5000)

}