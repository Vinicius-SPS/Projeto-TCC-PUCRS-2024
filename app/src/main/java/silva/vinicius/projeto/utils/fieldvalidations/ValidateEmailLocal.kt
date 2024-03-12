package silva.vinicius.projeto.utils.fieldvalidations

import android.text.Editable
import android.util.Patterns

class ValidateEmailLocal {
    private var errorMessage: String = ""
    private var isValid: Boolean = false

    fun verifyIsEmailEmpty(field: Editable?): Boolean {
        if(field.isNullOrEmpty()){
            errorMessage = "Campo Obrigatório."
            isValid = false
            return true
        }
        else{
            isValid = false
        }

        return false
    }

    fun verifyIsEmailValid(field: Editable?): Boolean{
        if(!Patterns.EMAIL_ADDRESS.matcher(field.toString()).matches()){
            errorMessage = "Email inválido."
            isValid = false
            return true
        }
        errorMessage = ""
        isValid = true
        return false
    }

    fun getErrorMessage():String {
        return errorMessage
    }

    fun getIsEmailValid():Boolean{
        return isValid
    }
}