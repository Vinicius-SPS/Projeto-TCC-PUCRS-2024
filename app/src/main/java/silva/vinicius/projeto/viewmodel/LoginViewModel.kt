package silva.vinicius.projeto.viewmodel

import android.text.Editable
import android.util.Log
import silva.vinicius.projeto.utils.fieldvalidations.ValidateEmailLocal
import silva.vinicius.projeto.utils.fieldvalidations.ValidatePasswordLocal

class LoginViewModel {
    private var validateEmailLocal : ValidateEmailLocal = ValidateEmailLocal()
    private var validatePasswordLocal: ValidatePasswordLocal = ValidatePasswordLocal()

    fun doLogin(email: Editable?, password: Editable?): Boolean {
        verifyEmail(email)
        verifyPassword(password)

        return validateEmailLocal.getIsEmailValid() && validatePasswordLocal.getIsPasswordValid()
    }

    fun verifyEmail(email: Editable?): Boolean{
        if(validateEmailLocal.verifyIsEmailEmpty(email)) {
            Log.d("loginViewModel","email: " + validateEmailLocal.getErrorMessage())
            return false
        }
        if(validateEmailLocal.verifyIsEmailValid(email)){
            Log.d("loginViewModel","email: " + validateEmailLocal.getErrorMessage())
            return false
        }

        return true
    }

    fun verifyPassword(password: Editable?): Boolean{
        if (validatePasswordLocal.verifyIsPasswordEmpty(password)) {
            Log.d("loginViewModel","password:" + validatePasswordLocal.getErrorMessage())
            return false
        }
        if (validatePasswordLocal.verifyIsPasswordValid(password)){
            Log.d("loginViewModel","password:" + validatePasswordLocal.getErrorMessage())
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

}