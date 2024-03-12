package silva.vinicius.projeto.view.home.listsPlaceholder

import java.util.ArrayList

object UserListPlaceholder {
    var USERS: ArrayList<silva.vinicius.projeto.model.Users> = ArrayList()
    private val usersMock = silva.vinicius.projeto.data.placeholder.UsersMock()


    init {
        for (item: silva.vinicius.projeto.model.Users in usersMock.generateInvitesMock()) {
            USERS.add(item)
        }
    }
}