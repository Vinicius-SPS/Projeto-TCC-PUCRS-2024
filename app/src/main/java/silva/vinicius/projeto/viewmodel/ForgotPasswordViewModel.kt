package silva.vinicius.projeto.viewmodel

import android.text.Editable
import android.util.Log
import silva.vinicius.projeto.firebase.operations.FirebaseChangePassword
import silva.vinicius.projeto.utils.fieldvalidations.ValidateEmailLocal

class ForgotPasswordViewModel {
    private var validateEmailLocal : ValidateEmailLocal = ValidateEmailLocal()

    fun doVerifyPasswordRecovery(email: Editable?): Boolean {
        verifyEmail(email)

        return validateEmailLocal.getIsEmailValid()
    }

    fun doSendEmail(email: String?, callback: (Boolean, String?) -> Unit){
        FirebaseChangePassword().changePassword(email.toString(), callback)
    }

    private fun verifyEmail(email: Editable?): Boolean{
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


    fun getEmailError(): String{
        return validateEmailLocal.getErrorMessage()
    }

    fun getIsEmailValid(): Boolean{
        return validateEmailLocal.getIsEmailValid()
    }

}