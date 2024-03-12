package silva.vinicius.projeto.utils.fieldvalidations

import android.text.Editable

class ValidateConfirmPasswordLocal {
    private var errorMessage: String = ""
    private var isValid: Boolean = false

    fun verifyIsPasswordEmpty(field: Editable?): Boolean {
        if(field.isNullOrEmpty()){
            errorMessage = "Campo Obrigatório."
            isValid = false
            return true
        }
        else{
            isValid = true
        }


        return false
    }



    fun verifyArePasswordsEqual(field: Editable?, field2: Editable?): Boolean{
        if(field.toString() != field2.toString()){
            errorMessage = "As Senhas tem que ser iguais!"
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

    fun getIsPasswordValid():Boolean{
        return isValid
    }
}