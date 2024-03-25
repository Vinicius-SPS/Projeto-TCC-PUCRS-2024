package silva.vinicius.projeto.viewmodel

import silva.vinicius.projeto.firebase.get.FirebaseGetProfile
import silva.vinicius.projeto.model.Profile

class UserProfileViewModel {

    fun getUserProfile(uid: String?, callback: (Boolean, Profile?, String)-> Unit){
        FirebaseGetProfile().getProfile(uid, callback)
    }
}