package school.cactus.succulentshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.databinding.ActivityLoginBinding
import school.cactus.succulentshop.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    private val identifierValidator = IdentifierValidator()
    private val usernameValidator = UsernameValidator()
    private val passwordValidator = PasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.sign_up)

        binding.apply {
            signUpButton.setOnClickListener(){
                emailInputLayout.validate()
                usernameInputLayout.validate()
                passwordInputLayout.validate()
            }
            createAccountButton.setOnClickListener(){
                validateToLogInActivity()
            }
        }
    }
    private fun TextInputLayout.validate() {
        val errorMessage = validator().validateSignUp(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null
    }

    private fun Int.resolveAsString() = getString(this)

    private fun TextInputLayout.validator() = when (this) {
        binding.emailInputLayout -> identifierValidator
        binding.usernameInputLayout->usernameValidator
        binding.passwordInputLayout -> passwordValidator
        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")
    }
    fun validateToLogInActivity(){
        var intent=Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}