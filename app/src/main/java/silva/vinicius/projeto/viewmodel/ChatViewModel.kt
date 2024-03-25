package silva.vinicius.projeto.viewmodel

import silva.vinicius.projeto.firebase.get.FirebaseGetProfile
import silva.vinicius.projeto.firebase.operations.FirebaseSendMessage
import silva.vinicius.projeto.firebase.update.FirebaseUpdateChat
import silva.vinicius.projeto.model.Message
import silva.vinicius.projeto.model.Profile

class ChatViewModel {

    fun getProfile(userId: String, callback: (Boolean, Profile?, String) -> Unit){
        FirebaseGetProfile().getProfile(userId, callback)
    }


    fun sendMessage(chatId: String, message:String, callback: (Boolean, String) -> Unit){
        FirebaseSendMessage().sendMessage(chatId, message, callback)
    }

    fun getChatList(chatId: String, callback: (Boolean, Message?, String) -> Unit){
        FirebaseUpdateChat().updateMessagesList(chatId, callback)
    }
}