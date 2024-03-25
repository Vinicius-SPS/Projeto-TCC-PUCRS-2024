package silva.vinicius.projeto.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import silva.vinicius.projeto.databinding.ActivityCreateProfileNameBinding
import silva.vinicius.projeto.viewmodel.CreateProfileNameViewModel

class CreateProfileNameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateProfileNameBinding
    private lateinit var viewModel: CreateProfileNameViewModel
    private lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateProfileNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundle()

        viewModel = CreateProfileNameViewModel()

        setButtons()
    }

    private fun setButtons() {
        binding.btnNext.setOnClickListener {
            if (viewModel.doVerifyName(binding.textInputName.text)) {
//            if (true) {
                val intent = Intent(this@CreateProfileNameActivity, CreateProfileTagsActivity::class.java)
                Log.d("CreateProfileNameActivity", "nome: " +  binding.textInputName.text.toString())
                intent.putExtra ("user_name",  binding.textInputName.text.toString())
                if(bundle.getString("tags", " ") != null){
                    intent.putExtra ("tags", bundle.getString("tags"))
                }
                startActivity(intent)
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

    private fun getBundle() {
        bundle = intent.extras!!

        if(bundle.getString("user_name", ).toString().length >= 3 ) {
            binding.textInputName.setText(bundle.getString("user_name", " "))
        }
        if(bundle.getString("tags", " ") != null){

        }


    }
}