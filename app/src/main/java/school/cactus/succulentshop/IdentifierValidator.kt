package school.cactus.succulentshop


class IdentifierValidator : Validator {
    override fun validateLogIn(field: String) = when {
        field.isEmpty() -> R.string.this_field_is_required
        field.length < 5 -> R.string.identifier_is_too_short
        else -> null
    }

    override fun validateSignUp(field: String)= when {
        !field.contains('@') -> R.string.email_is_invalid
        !field.contains('.') -> R.string.email_is_invalid
        field.substringBefore('@').length < 5 -> R.string.identifier_is_too_short
        field.length > 50 -> R.string.identifier_is_too_long
        else->null
    }

}