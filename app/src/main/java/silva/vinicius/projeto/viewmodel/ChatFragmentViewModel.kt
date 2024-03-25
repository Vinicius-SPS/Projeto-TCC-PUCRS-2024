package silva.vinicius.projeto.viewmodel

import silva.vinicius.projeto.firebase.get.chat.FirebaseGetChatList
import silva.vinicius.projeto.model.Chat

class ChatFragmentViewModel {

    fun getChatList(callback: (Boolean, ArrayList<Chat>?, String) -> Unit){
        FirebaseGetChatList().getChatsList(callback)
    }
}