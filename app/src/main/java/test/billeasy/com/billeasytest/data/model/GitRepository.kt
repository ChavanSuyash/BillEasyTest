package test.billeasy.com.billeasytest.data.model

data class GitRepository (
    val id : Int,
    val name : String,
    val owner : Owner,
    val full_name : String
)

data class Owner (
    val login : String,
    val avatar_url : String
)