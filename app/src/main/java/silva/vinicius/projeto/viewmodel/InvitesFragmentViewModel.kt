package silva.vinicius.projeto.viewmodel

class InvitesFragmentViewModel {

    private val invitesMock = silva.vinicius.projeto.data.placeholder.InvitesMock()
    private val chatsMock = silva.vinicius.projeto.data.placeholder.ChatsMock()
//    private lateinit var friendsContent: FriendsContent

    fun getInvitesListMock(): ArrayList<silva.vinicius.projeto.model.Users>{
        return invitesMock.generateInvitesMock()
    }

    fun getChatsListMock(): ArrayList<silva.vinicius.projeto.model.Users>{
        return chatsMock.getChatListMock()
    }
}