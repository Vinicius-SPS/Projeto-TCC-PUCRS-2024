package silva.vinicius.projeto.firebase.get.chat

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import silva.vinicius.projeto.model.Chat
import silva.vinicius.projeto.model.Users

class FirebaseGetChatList {

    fun getChatsList(callback: (Boolean, ArrayList<Chat>?, String) -> Unit) {
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid

        if (userId != null) {
            firebaseFirestore.collection("user_profile")
                .document(userId).collection("invites_accept")
                .get().addOnCompleteListener {
                    if (it.isSuccessful) {

                        val chatsList: ArrayList<Chat> = ArrayList()

                        val size: Int = it.result.size() - 1
                        if (size >= 0) {
                            for (index: Int in 0..size) {

                                val chat = it.result.documents[index]
                                if(chat.getBoolean("open_status")!!) {
                                    chatsList.add(
                                        Chat(
                                            chat.getString("chat_id"),
                                            chat.getString("host_chat_id"),
                                            chat.getString("invited_id"),
                                            chat.getBoolean("open_status")
                                        )
                                    )
                                }
                            }
                        }

                        callback(true, chatsList, "Sucesso")

                    } else
                        callback(false, null, "Erro ao conectar com o servidor")
                }
        }

    }
}