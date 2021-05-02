package school.cactus.succulentshop

class UsernameValidator:Validator {
    override fun validateLogIn(field: String) = when{
        field.isEmpty()->R.string.this_field_is_required
        else->null
    }

    override fun validateSignUp(field: String)= when{
        field.isEmpty()->R.string.this_field_is_required
        field.length<=2->R.string.username_is_too_short
        field.length>20->R.string.username_is_too_long
        !field.matches("^[a-z0-9_]+\$".toRegex()) -> R.string.username_is_invalid
        else->null
    }
}