package silva.vinicius.projeto.viewmodel

import android.util.Log
import silva.vinicius.projeto.firebase.get.FirebaseGetPersonalProfile
import silva.vinicius.projeto.firebase.update.singleupdates.FirebaseUpdateTags
import silva.vinicius.projeto.model.PersonalProfile
import silva.vinicius.projeto.utils.tags.TagGameStyle
import silva.vinicius.projeto.utils.tags.TagGames
import silva.vinicius.projeto.utils.tags.TagLanguages
import silva.vinicius.projeto.utils.tags.TagManager
import silva.vinicius.projeto.utils.tags.TagPlatforms

class EditProfileTagViewModel {
    private var tagGames: TagGames =
        TagGames()
    private var tagGameStyle: TagGameStyle =
        TagGameStyle()
    private var tagLanguages: TagLanguages =
        TagLanguages()
    private var tagPlatforms: TagPlatforms =
        TagPlatforms()
    private var tagManager: TagManager =
        TagManager()


    fun getPersonalProfile(callback: (Boolean, PersonalProfile?, String) -> Unit){
        FirebaseGetPersonalProfile().getPersonalProfile(callback)
    }

    fun updateTags(tags: String, callback: (Boolean, String?) -> Unit){
        FirebaseUpdateTags().updateProfile(tags, callback)
    }

    fun getTags(): String{
        return tagManager.getList()
    }

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
        tagPlatforms.setStatePc()
        return tagPlatforms.getStatePc()
    }

    fun tagStateXbox(): Boolean{
        tagPlatforms.setStateXbox()
        return  tagPlatforms.getStateXbox()
    }

    fun tagStatePlayStation(): Boolean{
        tagPlatforms.setStatePlayStation()
        return  tagPlatforms.getStatePlayStation()
    }

    fun tagStateMobile(): Boolean{
        tagPlatforms.setStateMobile()
        return tagPlatforms.getStateMobile()
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