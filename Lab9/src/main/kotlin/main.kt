import com.github.kittinunf.fuel.Fuel
import dbmodels.Cancion
import models.LecturaCancion
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    val url = "https://next.json-generator.com/api/json/get/EkeSgmXycS"

    val (request, response, result) = Fuel.get(url).responseObject(LecturaCancion.LecturaCancionArrayDeserializer())
    val (canciones, err) = result

    Database.connect(
            "jdbc:postgresql:musica",
            "org.postgresql.Driver",
            "postgres",
            "giulietta"
    )

    transaction {
        SchemaUtils.create(Cancion)


        if (canciones != null){
            for (cancion in canciones){
                Cancion.insert {
                    it[isFavourite] = cancion.isFavourite
                    it[year] = cancion.year
                    it[country] = cancion.country
                    it[region] = cancion.region
                    it[artistName] = cancion.artistName
                    it[song] = cancion.song
                }
            }
        }
    }

    Thread.sleep(5000)

}