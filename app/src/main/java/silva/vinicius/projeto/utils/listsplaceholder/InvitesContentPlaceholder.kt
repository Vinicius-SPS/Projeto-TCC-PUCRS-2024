package silva.vinicius.projeto.utils.listsplaceholder

import silva.vinicius.projeto.utils.placeholder.InvitesMock
import java.util.ArrayList

object InvitesContentPlaceholder {

    var USERS: ArrayList<silva.vinicius.projeto.model.Users> = ArrayList()
    private val invitesMock = InvitesMock()


    init {
        for (item: silva.vinicius.projeto.model.Users in invitesMock.generateInvitesMock()) {
            USERS.add(item)
        }
    }


}