package silva.vinicius.projeto.utils.placeholder

class ChatsMock {
    private val chatList: ArrayList<silva.vinicius.projeto.model.Users> = ArrayList()

    fun getChatListMock(): ArrayList<silva.vinicius.projeto.model.Users>{
        return chatList
    }

    fun addUserToChatList(user: silva.vinicius.projeto.model.Users){
        chatList.add(user)
    }
}