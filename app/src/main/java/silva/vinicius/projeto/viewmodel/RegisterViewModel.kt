package silva.vinicius.projeto.viewmodel

import android.text.Editable
import android.util.Log
import silva.vinicius.projeto.firebase.operations.profilecreation.FirebaseCreateProfile
import silva.vinicius.projeto.firebase.operations.FirebaseRegister
import silva.vinicius.projeto.utils.fieldvalidations.ValidateConfirmPasswordLocal
import silva.vinicius.projeto.utils.fieldvalidations.ValidateEmailLocal
import silva.vinicius.projeto.utils.fieldvalidations.ValidatePasswordLocal

class RegisterViewModel {
    private var validateEmailLocal : ValidateEmailLocal = ValidateEmailLocal()
    private var validatePasswordLocal: ValidatePasswordLocal = ValidatePasswordLocal()
    private var validateConfirmPasswordLocal: ValidateConfirmPasswordLocal = ValidateConfirmPasswordLocal()

    fun doRegister(email: Editable?, password: Editable?, callback: (Boolean, String?) -> Unit){
        FirebaseRegister().doRegister(email.toString(), password.toString(), callback)
    }

    fun verifyRegister(email: Editable?, password: Editable?, confirmPassword: Editable?): Boolean {
        verifyEmail(email)
        verifyPassword(password)
        verifyConfirmPassword(password, confirmPassword)

        return (validateEmailLocal.getIsEmailValid()
                && validatePasswordLocal.getIsPasswordValid()
                && validateConfirmPasswordLocal.getIsPasswordValid())
    }

    fun createProfile(): Boolean{
        return FirebaseCreateProfile().createProfile()
    }

    private fun verifyEmail(email: Editable?): Boolean{
        if(validateEmailLocal.verifyIsEmailEmpty(email)) {
            Log.d("registerViewModel","email: " + validateEmailLocal.getErrorMessage())
            return false
        }
        if(validateEmailLocal.verifyIsEmailValid(email)){
            Log.d("registerViewModel","email: " + validateEmailLocal.getErrorMessage())
            return false
        }

        return true
    }

    private fun verifyPassword(password: Editable?): Boolean{
        if (validatePasswordLocal.verifyIsPasswordEmpty(password)) {
            Log.d("registerViewModel","password:" + validatePasswordLocal.getErrorMessage())
            return false
        }
        if (validatePasswordLocal.verifyIsPasswordValid(password)){
            Log.d("registerViewModel","password:" + validatePasswordLocal.getErrorMessage())
            return false
        }

        return true
    }

    private fun verifyConfirmPassword(password: Editable?, confirmPassword: Editable?): Boolean{
        if (validateConfirmPasswordLocal.verifyIsPasswordEmpty(confirmPassword)) {
            Log.d("registerViewModel","confirm password:" + validatePasswordLocal.getErrorMessage())
            return false
        }
        if (!validateConfirmPasswordLocal.verifyArePasswordsEqual(password, confirmPassword)){
            Log.d("registerViewModel","confirm password:" + validatePasswordLocal.getErrorMessage())
            return false
        }

        return true
    }

    fun getEmailError(): String{
        return validateEmailLocal.getErrorMessage()
    }

    fun getIsEmailValid(): Boolean{
        return validateEmailLocal.getIsEmailValid()
    }


    fun getPasswordError(): String{
        return validatePasswordLocal.getErrorMessage()
    }

    fun getIsPasswordValid(): Boolean{
        return validatePasswordLocal.getIsPasswordValid()
    }

    fun getConfirmPasswordError(): String{
        return validateConfirmPasswordLocal.getErrorMessage()
    }

    fun getIsConfirmPasswordValid(): Boolean{
        return validateConfirmPasswordLocal.getIsPasswordValid()
    }
}