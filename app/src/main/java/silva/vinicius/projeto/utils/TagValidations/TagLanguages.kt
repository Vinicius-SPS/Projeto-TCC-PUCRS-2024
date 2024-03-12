package silva.vinicius.projeto.utils.TagValidations

class TagLanguages {
    private var isPortugueseSelected: Boolean = false
    private var isEnglishSelected: Boolean = false
    private var totalSelected: Int = 0

    fun setStatePortuguese(){
        if(!isPortugueseSelected){
            isPortugueseSelected = true
            totalSelected ++
        }
        else{
            isPortugueseSelected = false
            totalSelected --
        }
    }

    fun setStateEnglish(){
        if(!isEnglishSelected){
            isEnglishSelected = true
            totalSelected ++
        }
        else{
            isEnglishSelected = false
            totalSelected --
        }
    }

    fun getStatePortuguese(): Boolean{
        return isPortugueseSelected
    }

    fun getStateEnglish(): Boolean{
        return isEnglishSelected
    }

    fun getTotalTagsSelected(): Int{
        return totalSelected
    }
}