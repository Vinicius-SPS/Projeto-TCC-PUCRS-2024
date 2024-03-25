package silva.vinicius.projeto.firebase.operations.invite

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseAcceptInvite {
    fun acceptInvite(senderId: String, callback: (Boolean, String) -> Unit) {
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid

        if (userId != null) {
            //Atualiza o próprio perfil
            firebaseFirestore.collection("user_profile")
                .document(userId)
                .collection("invites")
                .document(senderId)
                .update("open_status",true)
                .addOnCompleteListener { updateResult ->
                    if(updateResult.isSuccessful) {
                        //recuperando o Perfil
                        firebaseFirestore.collection("user_profile")
                            .document(userId)
                            .collection("invites")
                            .document(senderId)
                            .get()
                            .addOnCompleteListener { getInfoResults ->
                                if (getInfoResults.isSuccessful) {
                                    firebaseFirestore.collection("user_profile")
                                        .document(userId)
                                        .collection("invites_accept")
                                        .document(senderId)
                                        .set(getInfoResults.result.data!!)
                                        .addOnCompleteListener { changeResult ->
                                            if (changeResult.isSuccessful) {
                                                //Atualizando o outro usuário
                                                firebaseFirestore.collection("user_profile")
                                                    .document(getInfoResults.result.getString("host_chat_id")!!)
                                                    .collection("invites_accept")
                                                    .document(getInfoResults.result.getString("invited_id")!!)
                                                    .update("open_status",true)

                                                //Deletando o convite
                                                firebaseFirestore.collection("user_profile")
                                                    .document(userId)
                                                    .collection("invites")
                                                    .document(senderId).delete()


                                                callback(true, "Sucesso")
                                            } else {
                                                callback(false, "Erro ao aceitar o convite")
                                            }
                                        }


                                } else {
                                    callback(false, "Erro ao conectar com o Firebase")
                                }
                            }
                        }
                    //Movendo o invite para a lista de convites aceitos

                }
        }
    }

}