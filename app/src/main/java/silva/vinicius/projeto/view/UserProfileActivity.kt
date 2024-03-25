package silva.vinicius.projeto.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import silva.vinicius.projeto.databinding.ActivityUserProfileBinding
import silva.vinicius.projeto.viewmodel.UserProfileViewModel

class UserProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserProfileBinding
    private lateinit var viewModel: UserProfileViewModel
    private lateinit var bundle: Bundle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = UserProfileViewModel()
        getInfo()
        if(intent.extras != null){
            viewModel.getUserProfile(bundle.getString("user_id")){result, profile, message ->
                if (result && profile != null){
                    binding.title.text = profile.userName
                    binding.descriptionText.text = profile.description
                    binding.tagsText.text = profile.tags
                }

            }
        }

        binding.btnBack.setOnClickListener{
            finish()
        }
    }

    private fun getInfo(){
        bundle = intent.extras!!
    }
}