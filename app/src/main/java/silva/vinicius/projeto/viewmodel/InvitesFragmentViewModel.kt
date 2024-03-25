package silva.vinicius.projeto.viewmodel

import silva.vinicius.projeto.firebase.get.invite.FirebaseGetInvitesList
import silva.vinicius.projeto.model.Users

class InvitesFragmentViewModel {

    fun getInvitesList(callback: (Boolean, ArrayList<Users>?, String) -> Unit){
        FirebaseGetInvitesList().getInvitesList(callback)
    }
}