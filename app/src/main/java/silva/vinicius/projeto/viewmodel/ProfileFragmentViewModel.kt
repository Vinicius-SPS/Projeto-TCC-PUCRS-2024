package silva.vinicius.projeto.viewmodel

import silva.vinicius.projeto.firebase.get.FirebaseGetPersonalProfile
import silva.vinicius.projeto.firebase.operations.FirebaseSignOut
import silva.vinicius.projeto.firebase.update.singleupdates.FirebaseUpdateDescription
import silva.vinicius.projeto.model.PersonalProfile


class ProfileFragmentViewModel {

    fun getProfile(callback: (Boolean, PersonalProfile?, String?) -> Unit){
        FirebaseGetPersonalProfile().getPersonalProfile(callback)
    }

    fun updateDescription(text: String, callback: (Boolean, String?) -> Unit){
        FirebaseUpdateDescription().updateProfile(text, callback)
    }

    fun signOut(){
        FirebaseSignOut().doLogOff()
    }




}