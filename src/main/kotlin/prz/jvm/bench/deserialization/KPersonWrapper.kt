package prz.jvm.bench.deserialization

import com.dslplatform.json.CompiledJson
import kotlinx.serialization.Serializable

@CompiledJson
@Serializable
data class KPersonWrapper(
    val persons: List<KPerson>
) {
    @CompiledJson
    @Serializable
    data class KPerson(
        val _id: String,
        val index: Int,
        val guid: String,
        val isActive: Boolean,
        val balance: String,
        val picture: String,
        val age: Int,
        val eyeColor: String,
        val name: String,
        val gender: String,
        val company: String,
        val email: String,
        val phone: String,
        val address: String,
        val about: String,
        val registered: String,
        val latitude: Double,
        val longitude: Double,
        val tags: List<String>,
        val friends: List<KFriend>
    ) {
        @CompiledJson
        @Serializable
        data class KFriend(
            val id: Int,
            val name: String
        )
    }
}
