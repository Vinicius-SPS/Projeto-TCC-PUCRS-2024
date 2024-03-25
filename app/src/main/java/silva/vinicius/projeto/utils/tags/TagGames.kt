package silva.vinicius.projeto.utils.tags

class TagGames {
    private var isLoLSelected: Boolean = false
    private var isMinecraftSelected: Boolean = false
    private var isApexSelected: Boolean = false
    private var isCsSelected: Boolean = false
    private var isFreeFireSelected: Boolean = false
    private var totalSelected: Int = 0

    fun setStateLoL(){
        if(!isLoLSelected){
            isLoLSelected = true
            totalSelected ++
        }
        else{
            isLoLSelected = false
            totalSelected --
        }
    }

    fun setStateMinecraft(){
        if(!isMinecraftSelected){
            isMinecraftSelected = true
            totalSelected ++
        }
        else{
            isMinecraftSelected = false
            totalSelected --
        }
    }

    fun setStateApex(){
        if(!isApexSelected){
            isApexSelected = true
            totalSelected ++
        }
        else{
            isApexSelected = false
            totalSelected --
        }
    }

    fun setStateCs(){
        if(!isCsSelected){
            isCsSelected = true
            totalSelected ++
        }
        else{
            isCsSelected = false
            totalSelected --
        }
    }

    fun setStateFreeFire(){
        if(!isFreeFireSelected){
            isFreeFireSelected = true
            totalSelected ++
        }
        else{
            isFreeFireSelected = false
            totalSelected --
        }
    }

    fun getStateLoL(): Boolean{
        return isLoLSelected
    }

    fun getStateMinecraft(): Boolean{
        return isMinecraftSelected
    }

    fun getStateApex(): Boolean{
        return isApexSelected
    }

    fun getStateCs(): Boolean{
        return isCsSelected
    }

    fun getStateFreeFire(): Boolean{
        return isFreeFireSelected
    }
    fun getTotalTagsSelected(): Int{
        return totalSelected
    }
}