package silva.vinicius.projeto.firebase.operations.invite

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseDenyInvite {
    fun denyInvite(senderId: String, callback: (Boolean, String) -> Unit) {
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid

        if (userId != null) {
            //Recuperando o perfil
            firebaseFirestore.collection("user_profile")
                .document(userId)
                .collection("invites")
                .document(senderId)
                .get()
                .addOnCompleteListener { inviteResult ->
                    if (inviteResult.isSuccessful) {
                        firebaseFirestore.collection("user_profile")
                            .document(senderId)
                            .collection("invites_accept")
                            .document(userId)
                            .delete()
                            .addOnCompleteListener { deleteInviteSender ->
                                if (deleteInviteSender.isSuccessful) {
                                    //Deletando o convite
                                    firebaseFirestore.collection("user_profile")
                                        .document(userId)
                                        .collection("invites")
                                        .document(senderId).delete().addOnCompleteListener{ deleteInviteUser ->
                                            if(deleteInviteUser.isSuccessful){
                                                callback(true, "Sucesso")
                                            }
                                            else{
                                                callback(false, "Erro ao deletar o convite")
                                            }
                                        }



                                } else {
                                    callback(false, "Erro ao deletar o convite")
                                }
                            }


                    } else {
                        callback(false, "Erro ao conectar com o Firebase")
                    }
                }
        }
    }
}