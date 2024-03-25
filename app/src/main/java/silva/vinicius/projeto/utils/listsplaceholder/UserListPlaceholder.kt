package silva.vinicius.projeto.utils.listsplaceholder

import silva.vinicius.projeto.utils.placeholder.UsersMock
import java.util.ArrayList

object UserListPlaceholder {
    var USERS: ArrayList<silva.vinicius.projeto.model.Users> = ArrayList()
    private val usersMock = UsersMock()


    init {
        for (item: silva.vinicius.projeto.model.Users in usersMock.generateInvitesMock()) {
            USERS.add(item)
        }
    }
}