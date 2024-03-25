package silva.vinicius.projeto.firebase.operations.invite

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.UUID

class FirebaseSendInvite {

    fun sendInvite(userInvitedId: String, callback: (Boolean, String) -> Unit) {
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid


        if (userId != null) {

            val key: String = UUID.randomUUID().toString().replace("-","")
            val chatId: String = key + userId

            val inviteInfo: MutableMap<String, Any> = HashMap()
            inviteInfo["host_chat_id"] = userId
            inviteInfo["chat_id"] = chatId
            inviteInfo["invited_id"] = userInvitedId
            inviteInfo["open_status"] = false

            val chatInfo: MutableMap<String, Any> = HashMap()
            chatInfo["host_chat_id"] = userId
            chatInfo["invited_id"] = userInvitedId
            chatInfo["chat_id"] = chatId

            //Salvando o Chat para quem enviou o convite
            firebaseFirestore.collection("user_profile")
                .document(userId)
                .collection("invites_accept")
                .document(userInvitedId)
                .set(inviteInfo)
                .addOnCompleteListener { statusSave ->
                    if (statusSave.isSuccessful) {
                        //Gerando o chat
                        Log.d("FirebaseSendInvite","Funcionou 1")
                        firebaseFirestore.collection("chat")
                            .document(chatId)
                            .collection("chat_info")
                            .document("info")
                            .set(chatInfo)
                            .addOnCompleteListener { statusChat ->
                                if (statusChat.isSuccessful) {
                                    Log.d("FirebaseSendInvite","Funcionou 2")
                                    //Enviando o convite para o outro usuário
                                    firebaseFirestore.collection("user_profile")
                                        .document(userInvitedId)
                                        .collection("invites")
                                        .document(userId)
                                        .set(inviteInfo)
                                        .addOnCompleteListener { statusInvite ->
                                            Log.d("FirebaseSendInvite","Funcionou 3")
                                            if (statusInvite.isSuccessful) {
                                                callback(true, "sucesso")
                                            }
                                            else{
//                                                firebaseFirestore.collection("user_profile")
//                                                    .document(userId).collection("invites_send")
//                                                    .document(chatId).delete()
//
//                                                firebaseFirestore.collection("chat")
//                                                    .document(chatId).delete()
//                                                callback(false, "Erro ao enviar o convite")
                                            }
                                        }
                                }
                                else{
//                                    firebaseFirestore.collection("user_profile")
//                                        .document(userId).collection("invites_sent")
//                                        .document(chatId).delete()

                                    callback(false, "Erro ao Criar o Chat")
                                }


                            }

                    } else {

                        callback(false, "Erro ao salvar o convite")
                    }
                }

        }
    }
}