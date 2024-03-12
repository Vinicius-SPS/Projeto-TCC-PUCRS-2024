package silva.vinicius.projeto.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import silva.vinicius.projeto.databinding.ActivityCreateProfileNameBinding
import silva.vinicius.projeto.viewmodel.CreateProfileNameViewModel

class CreateProfileNameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateProfileNameBinding
    private lateinit var viewModel: CreateProfileNameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateProfileNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = CreateProfileNameViewModel()
        setButtons()
    }

    private fun setButtons() {
        binding.btnNext.setOnClickListener {
            if (viewModel.doVerifyName(binding.textInputName.text)) {
//            if (true) {
                startActivity(Intent(this@CreateProfileNameActivity, CreateProfileTagsActivity::class.java))
                finish()
            }
            else{
                if(!viewModel.getIsNameValid()) {
                    binding.fieldTextInputName.error = viewModel.getNameError()
                }
                else{
                    binding.fieldTextInputName.error = null
                }
            }
        }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this@CreateProfileNameActivity, WelcomeActivity::class.java))
            finish()
        }
    }
}