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

        if(intent.extras != null){
            setInfo()
        }

        binding.btnBack.setOnClickListener{
            finish()
        }
    }

    private fun setInfo(){
        bundle = intent.extras!!

//        binding.userName.text = bundle.getString("user_name")
        binding.descriptionText.text = bundle.getString("description")
        binding.title.text = bundle.getString("user_name")
//        binding.userOnline.text = bundle.getString("online_status")
        binding.tagsText.text = bundle.getString("tags")

    }
}