import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class Heroe (val nombre:String, val tipo:String, val id: Int, val localized_name: String) {
    class HeroeArrayDeserializer: ResponseDeserializable<Array<Heroe>>{
        override fun deserialize(content: String): Array<Heroe>? {
            return Gson().fromJson(content, Array<Heroe>::class.java)
        }
    }
}