package silva.vinicius.projeto.data.placeholder

class ChatsMock {
    private val chatList: ArrayList<silva.vinicius.projeto.model.Users> = ArrayList()

    fun getChatListMock(): ArrayList<silva.vinicius.projeto.model.Users>{
        return chatList
    }

    fun addUserToChatList(user: silva.vinicius.projeto.model.Users){
        chatList.add(user)
    }
}