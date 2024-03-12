package silva.vinicius.projeto.utils.TagValidations

class TagPlataforms {
    private var isPcSelected: Boolean = false
    private var isXboxSelected: Boolean = false
    private var isPlayStatioSelected: Boolean = false
    private var isMobileSelected: Boolean = false
    private var totalSelected: Int = 0

    fun setStatePc(){
        if(!isPcSelected){
            isPcSelected = true
            totalSelected ++
        }
        else{
            isPcSelected = false
            totalSelected --
        }
    }

    fun setStateXbox(){
        if(!isXboxSelected){
            isXboxSelected = true
            totalSelected ++
        }
        else{
            isXboxSelected = false
            totalSelected --
        }
    }

    fun setStatePlayStation(){
        if(!isPlayStatioSelected){
            isPlayStatioSelected = true
            totalSelected ++
        }
        else{
            isPlayStatioSelected = false
            totalSelected --
        }
    }

    fun setStateMobile(){
        if(!isMobileSelected){
            isMobileSelected = true
            totalSelected ++
        }
        else{
            isMobileSelected = false
            totalSelected --
        }
    }

    fun getStatePc(): Boolean{
        return isPcSelected
    }

    fun getStateXbox(): Boolean{
        return isXboxSelected
    }

    fun getStatePlayStation(): Boolean{
        return isPlayStatioSelected
    }

    fun getStateMobile(): Boolean{
        return isMobileSelected
    }

    fun getTotalTagsSelected(): Int{
        return totalSelected
    }
}