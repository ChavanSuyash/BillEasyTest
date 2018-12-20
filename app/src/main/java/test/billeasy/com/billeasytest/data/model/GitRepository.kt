package test.billeasy.com.billeasytest.data.model
import java.io.Serializable

data class GitRepository (
    val id : Int,
    val name : String,
    val owner : Owner,
    val full_name : String,
    val description : String
) : Serializable

data class Owner (
    val login : String,
    val avatar_url : String
) : Serializable