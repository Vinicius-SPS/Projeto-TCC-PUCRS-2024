package silva.vinicius.projeto.model

data class Users(
    val id: String,
    val userName: String,
    val description: String,
    val profileImage: Int,
    val tags: ArrayList<String>,
    val isFriend: Boolean,
    var wasInviteSent: Boolean

    ) {
//    override fun toString(): String = name
}