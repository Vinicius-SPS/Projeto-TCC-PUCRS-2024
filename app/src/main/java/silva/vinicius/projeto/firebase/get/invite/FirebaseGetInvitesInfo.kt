package silva.vinicius.projeto.firebase.get.invite

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseGetInvitesInfo {

    fun getInvitesList(callback: (Boolean, ArrayList<String>?, String) -> Unit) {
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid

        val listOfUsers: ArrayList<String> = ArrayList()

        if (userId != null) {
            firebaseFirestore.collection("user_profile")
                .document(userId).collection("invites")
                .get().addOnCompleteListener { invitesResult ->

                    if (invitesResult.isSuccessful) {
                        val size: Int = invitesResult.result.size() - 1
                        if (size >= 0) {
                            for (index: Int in 0..size) {
                                val invites = invitesResult.result.documents[index]
                                listOfUsers.add(invites.getString("host_chat_id")!!)
                            }
                        }

                        callback(true, listOfUsers, "sucesso")

                    } else {
                        callback(true, listOfUsers, "Erro ao conectar com o servidor")
                    }
                }
        }
    }
}