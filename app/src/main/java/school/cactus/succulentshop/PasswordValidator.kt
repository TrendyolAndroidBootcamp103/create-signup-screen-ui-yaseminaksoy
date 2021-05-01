package school.cactus.succulentshop

class PasswordValidator : Validator {
    override fun validateLogIn(field: String) = when {
        field.isEmpty() -> R.string.this_field_is_required
        else -> null
    }

    override fun validateSignUp(field: String)=when {
        field.isEmpty()->R.string.this_field_is_required
        field.length<7 ->R.string.password_is_too_short
        field.length>40 ->R.string.password_is_too_long
        !field.any { it.isLowerCase() } -> R.string.password_is_invalid
        !field.any { it.isUpperCase() } -> R.string.password_is_invalid
        !field.any { it.isDigit() } -> R.string.password_is_invalid
        !field.any{!it.isLetterOrDigit()}->R.string.password_is_invalid
        else -> null
    }

}