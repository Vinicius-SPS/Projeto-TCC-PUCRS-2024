package silva.vinicius.projeto.viewmodel

class ProfileFragmentViewModel {
    private val userProfileMock: silva.vinicius.projeto.data.placeholder.UserProfileMock =
        silva.vinicius.projeto.data.placeholder.UserProfileMock()

    fun getUserInformationMock(): silva.vinicius.projeto.model.Profile {
        return userProfileMock.mockUserInformations()
    }

    fun getUserInformationFirebase(){

    }




}