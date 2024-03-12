package silva.vinicius.projeto.utils.TagValidations

class TagGameStyle {
    private var isCasualSelected: Boolean = false
    private var isCompetitiveSelected: Boolean = false
    private var totalSelected: Int = 0

    fun setStateCasual(){
        if(!isCasualSelected){
            isCasualSelected = true
            totalSelected ++
        }
        else{
            isCasualSelected = false
            totalSelected --
        }
    }

    fun setStateCompetitive(){
        if(!isCompetitiveSelected){
            isCompetitiveSelected = true
            totalSelected ++
        }
        else{
            isCompetitiveSelected = false
            totalSelected --
        }
    }

    fun getStateCasual(): Boolean{
        return isCasualSelected
    }

    fun getStateCompetitive(): Boolean{
        return isCompetitiveSelected
    }

    fun getTotalTagsSelected(): Int{
        return totalSelected
    }
}