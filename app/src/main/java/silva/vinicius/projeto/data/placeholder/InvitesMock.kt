package silva.vinicius.projeto.data.placeholder

class InvitesMock {

    fun generateInvitesMock(): ArrayList<silva.vinicius.projeto.model.Users> {
        var arrayListMock: ArrayList<silva.vinicius.projeto.model.Users> = ArrayList()
        arrayListMock.add(
            silva.vinicius.projeto.model.Users(
                "",
                "Carlos",
                "Estou em busca de algúem para jogar junto!",
                1,
                generateMockTag(),
                false,
                false
            )
        )

        arrayListMock.add(
            silva.vinicius.projeto.model.Users(
                "",
                "André",
                "Estou em busca de algúem para jogar junto!",
                1,
                generateMockTag(),
                false,
                false
            )
        )

        arrayListMock.add(
            silva.vinicius.projeto.model.Users(
                "",
                "José",
                "Estou em busca de algúem para jogar junto!",
                1,
                generateMockTag(),
                false,
                false
            )
        )

        arrayListMock.add(
            silva.vinicius.projeto.model.Users(
                "",
                "Carol",
                "Estou em busca de algúem para jogar junto!",
                1,
                generateMockTag(),
                false,
                false
            )
        )

        arrayListMock.add(
            silva.vinicius.projeto.model.Users(
                "",
                "Ana",
                "Estou em busca de algúem para jogar junto!",
                1,
                generateMockTag(),
                false,
                false
            )
        )

        arrayListMock.add(
            silva.vinicius.projeto.model.Users(
                "",
                "Pedro",
                "Estou em busca de algúem para jogar junto!",
                1,
                generateMockTag(),
                false,
                false
            )
        )

        arrayListMock.add(
            silva.vinicius.projeto.model.Users(
                "",
                "Cesar",
                "Estou em busca de algúem para jogar junto!",
                1,
                generateMockTag(),
                false,
                false
            )
        )

        arrayListMock.add(
            silva.vinicius.projeto.model.Users(
                "",
                "Maria",
                "Estou em busca de algúem para jogar junto!",
                1,
                generateMockTag(),
                false,
                false
            )
        )

        arrayListMock.add(
            silva.vinicius.projeto.model.Users(
                "",
                "Carla",
                "Estou em busca de algúem para jogar junto!",
                1,
                generateMockTag(),
                false,
                false
            )
        )

        arrayListMock.add(
            silva.vinicius.projeto.model.Users(
                "",
                "TesteNome!",
                "Estou em busca de algúem para jogar junto!",
                1,
                generateMockTag(),
                false,
                false
            )
        )




        return arrayListMock
    }

    private fun generateMockTag(): ArrayList<String>{
        var arrayListMockTag: ArrayList<String> =  ArrayList<String>()
        arrayListMockTag.add("Casual")
        arrayListMockTag.add("Inglês")
        arrayListMockTag.add("APEX")
        arrayListMockTag.add("Minecraft")

        return arrayListMockTag
    }
}