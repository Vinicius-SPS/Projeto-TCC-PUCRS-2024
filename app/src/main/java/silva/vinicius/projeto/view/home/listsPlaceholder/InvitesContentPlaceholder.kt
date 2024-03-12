package silva.vinicius.projeto.view.home.listsPlaceholder

import java.util.ArrayList

object InvitesContentPlaceholder {

    var USERS: ArrayList<silva.vinicius.projeto.model.Users> = ArrayList()
    private val invitesMock = silva.vinicius.projeto.data.placeholder.InvitesMock()


    init {
        for (item: silva.vinicius.projeto.model.Users in invitesMock.generateInvitesMock()) {
            USERS.add(item)
        }
    }


}