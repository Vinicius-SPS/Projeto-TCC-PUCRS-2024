package silva.vinicius.projeto.viewmodel

import android.text.Editable
import android.util.Log
import silva.vinicius.projeto.utils.fieldvalidations.ValidateNameLocal

class CreateProfileNameViewModel {
    private var validateNameLocal : ValidateNameLocal = ValidateNameLocal()

    fun doVerifyName(name: Editable?): Boolean {
        verifyName(name)

        return validateNameLocal.getIsNameValid()
    }

    fun verifyName(name: Editable?): Boolean{
        if(validateNameLocal.verifyIsNameEmpty(name)) {
            Log.d("CreateProfileViewModel","name: " + validateNameLocal.getErrorMessage())
            return false
        }
        if(validateNameLocal.verifyIsNameValid(name)){
            Log.d("CreateProfileViewModel","name: " + validateNameLocal.getErrorMessage())
            return false
        }

        return true
    }


    fun getNameError(): String{
        return validateNameLocal.getErrorMessage()
    }

    fun getIsNameValid(): Boolean{
        return validateNameLocal.getIsNameValid()
    }

}