package silva.vinicius.projeto.firebase.operations

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FirebaseSendMessage {

    fun sendMessage(chatId: String, message: String, callback: (Boolean, String) -> Unit) {
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid

        if (userId != null) {
            val time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"))
            val key = time + userId

            val messageSending: MutableMap<String, Any> = HashMap()
            messageSending["sender_id"] = userId
            messageSending["message_id"] = key
            messageSending["message"] = message

            firebaseFirestore.collection("chat")
                .document(chatId)
                .collection("messages")
                .document(key)
                .set(messageSending)
                .addOnCompleteListener() {
                    if (it.isSuccessful) {
                        Log.d("FirebaseSendMessage", "mensagem enviada")
                        callback(true, "sucesso")
                    } else {
                        Log.d("FirebaseSendMessage", "erro")
                        callback(false, "Erro em acessar o Banco de Dados")
                    }
                }

        }

    }
}