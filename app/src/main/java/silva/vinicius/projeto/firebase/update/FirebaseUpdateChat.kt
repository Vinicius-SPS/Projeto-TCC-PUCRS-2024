package silva.vinicius.projeto.firebase.update

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import silva.vinicius.projeto.model.Message

class FirebaseUpdateChat {
    fun updateMessagesList(chatId: String, callback: (Boolean, Message?, String) -> Unit) {
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        if (userId != null) {
            firebaseFirestore.collection("chat")
                .document(chatId)
                .collection("messages")
                .addSnapshotListener { snapshot, exception ->
                    Log.d("FirebaseUpdateChat", "Passou")

                    ///*
                    if (exception == null) {
                        if (snapshot != null){
                            for(newMessage in snapshot.documents){
                                Log.d("FirebaseUpdateChat", newMessage.toString())
                                callback(true,
                                    Message(
                                        newMessage.getString("sender_id"),
                                        newMessage.getString("message_id"),
                                        newMessage.getString("message"))
                                    , "sucesso")
                            }
                        }


                    } else {

                        Log.d("FirebaseUpdateChat", "Erro ao conectar com o servico de recuperaao de novas mensagens. Ecessao: " + exception.toString())
                        callback(false, null, "Erro ao conectar com o servico de recuperaao de novas mensagens. Excessao"  + exception.toString())
                    }

                    // */
                }
        }

    }
}