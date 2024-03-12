package silva.vinicius.projeto.viewmodel

import android.util.Log

class CreateProfileTagViewModel {
    private var tagGames: silva.vinicius.projeto.utils.TagValidations.TagGames =
        silva.vinicius.projeto.utils.TagValidations.TagGames()
    private var tagGameStyle: silva.vinicius.projeto.utils.TagValidations.TagGameStyle =
        silva.vinicius.projeto.utils.TagValidations.TagGameStyle()
    private var tagLanguages: silva.vinicius.projeto.utils.TagValidations.TagLanguages =
        silva.vinicius.projeto.utils.TagValidations.TagLanguages()
    private var tagPlataforms: silva.vinicius.projeto.utils.TagValidations.TagPlataforms =
        silva.vinicius.projeto.utils.TagValidations.TagPlataforms()
    private var tagManager: silva.vinicius.projeto.utils.TagValidations.TagManager =
        silva.vinicius.projeto.utils.TagValidations.TagManager()

    fun getIsListFull(): Boolean{
        return tagManager.isListFull()
    }

    fun getIsListSize(): Int{
        Log.d("CreateProfileTagViewModel","Tamanho da Lista: " + tagManager.getSize().toString())
        return tagManager.getSize()
    }

    fun addItemList(item: String){
        tagManager.addItem(item)
        Log.d("CreateProfileTagViewModel","Adicionado: " + tagManager.getList())
    }

    fun removeItemList(item: String){
        tagManager.removeItem(item)
        Log.d("CreateProfileTagViewModel","Removido: " + tagManager.getList())
    }

    fun tagStateCasual(): Boolean{
        Log.d("CreateProfileTagViewModel","antes: " + tagGameStyle.getStateCasual())
        tagGameStyle.setStateCasual()
        Log.d("CreateProfileTagViewModel","depois: " + tagGameStyle.getStateCasual())
        return tagGameStyle.getStateCasual()
    }

    fun tagStateCompetitive(): Boolean{
        tagGameStyle.setStateCompetitive()
        return tagGameStyle.getStateCompetitive()
    }

    fun tagStatePortuguese(): Boolean{
        tagLanguages.setStatePortuguese()
        return tagLanguages.getStatePortuguese()
    }

    fun tagStateEnglish(): Boolean{
        tagLanguages.setStateEnglish()
        return tagLanguages.getStateEnglish()
    }

    fun tagStatePc(): Boolean{
        tagPlataforms.setStatePc()
        return tagPlataforms.getStatePc()
    }

    fun tagStateXbox(): Boolean{
        tagPlataforms.setStateXbox()
        return  tagPlataforms.getStateXbox()
    }

    fun tagStatePlayStation(): Boolean{
        tagPlataforms.setStatePlayStation()
        return  tagPlataforms.getStatePlayStation()
    }

    fun tagStateMobile(): Boolean{
        tagPlataforms.setStateMobile()
        return tagPlataforms.getStateMobile()
    }

    fun tagStateLol(): Boolean{
        tagGames.setStateLoL()
        return tagGames.getStateLoL()
    }

    fun tagStateMinecraft(): Boolean{
        tagGames.setStateMinecraft()
        return tagGames.getStateMinecraft()
    }

    fun tagStateCs(): Boolean{
        tagGames.setStateCs()
        return tagGames.getStateCs()
    }

    fun tagStateApex(): Boolean{
        tagGames.setStateApex()
        return tagGames.getStateApex()
    }

    fun tagStateFreeFire(): Boolean{
        tagGames.setStateFreeFire()
        return tagGames.getStateFreeFire()
    }
}