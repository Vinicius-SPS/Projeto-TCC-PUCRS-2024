package silva.vinicius.projeto.viewmodel

import androidx.lifecycle.ViewModel
import silva.vinicius.projeto.firebase.get.FirebaseGetUsersList
import silva.vinicius.projeto.firebase.get.invite.FirebaseGetInvitesAcceptInfo
import silva.vinicius.projeto.firebase.get.invite.FirebaseGetInvitesInfo
import silva.vinicius.projeto.firebase.get.invite.FirebaseGetInvitesList
import silva.vinicius.projeto.model.Users

class HomeFragmentViewModel : ViewModel() {

    fun getUserList(callback: (Boolean, ArrayList<Users>?, String) -> Unit){
        FirebaseGetUsersList().getUserList(callback)
    }

    fun getInvitesInfoList(callback: (Boolean, ArrayList<String>?, String) -> Unit){
        FirebaseGetInvitesInfo().getInvitesList(callback)
    }

    fun getInvitesAcceptInfoList(callback: (Boolean, ArrayList<String>?, String) -> Unit){
        FirebaseGetInvitesAcceptInfo().getInvitesAcceptList(callback)
    }
}