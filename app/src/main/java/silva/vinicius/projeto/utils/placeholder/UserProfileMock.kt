package silva.vinicius.projeto.utils.placeholder

class UserProfileMock {

    fun mockUserInformations(): silva.vinicius.projeto.model.Profile {
        return silva.vinicius.projeto.model.Profile(
            "Vinícius",
            "Estou em busca de alguém para jogar junto",
            0,
            generateMockTag().toString()
        )
    }
    private fun generateMockTag(): ArrayList<String>{
        var arrayListMock: ArrayList<String> =  ArrayList<String>()
        arrayListMock.add("Casual")
        arrayListMock.add("Inglês")
        arrayListMock.add("APEX")
        arrayListMock.add("Minecraft")

        return arrayListMock
    }
}