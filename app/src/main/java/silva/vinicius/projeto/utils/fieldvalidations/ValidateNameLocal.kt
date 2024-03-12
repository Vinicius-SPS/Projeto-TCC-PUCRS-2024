package silva.vinicius.projeto.utils.fieldvalidations

import android.text.Editable

class ValidateNameLocal {
    private var errorMessage: String = ""
    private var isValid: Boolean = false

    fun verifyIsNameEmpty(field: Editable?): Boolean {
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



    fun verifyIsNameValid(field: Editable?): Boolean{
        if(field.toString().length < 3){
            errorMessage = "Nome Inválido, é preciso ter ao menos 3 caractéres"
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

    fun getIsNameValid():Boolean{
        return isValid
    }
}