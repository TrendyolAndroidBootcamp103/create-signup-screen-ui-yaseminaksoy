package school.cactus.succulentshop

interface Validator {
    fun validateLogIn(field: String): Int?
    fun validateSignUp(field:String): Int?
}