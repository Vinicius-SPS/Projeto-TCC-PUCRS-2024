package silva.vinicius.projeto.view

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import silva.vinicius.projeto.databinding.ActivityRegisterBinding
import silva.vinicius.projeto.view.home.AppActivity
import silva.vinicius.projeto.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    private lateinit var viewModel : RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.layoutTextInputEmail.setErrorTextColor(ColorStateList.valueOf(Color.RED))
        binding.layoutTextInputPassword.setErrorTextColor(ColorStateList.valueOf(Color.RED))
        binding.layoutTextInputConfirmPassword.setErrorTextColor(ColorStateList.valueOf(Color.RED))

        viewModel = RegisterViewModel()
        setButtons()
    }

    private fun setButtons() {
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            finish()
        }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, WelcomeActivity::class.java))
            finish()
        }

        binding.btnRegister.setOnClickListener {
            if (viewModel.verifyRegister(binding.textInputEmail.text,
                    binding.textInputPassword.text,
                    binding.textInputConfirmPassword.text)){


                    viewModel.doRegister(binding.textInputEmail.text, binding.textInputPassword.text){ success, error ->
                        if(success){
                            viewModel.createProfile()
                            val intent =  Intent(this@RegisterActivity, CreateProfileNameActivity::class.java)
                            intent.putExtra("user_name"," ")
                            startActivity(intent)
                            finish()

                        }
                        else{
                            binding.layoutTextInputEmail.error = "Endereço de e-mail já utilizaod"
                            binding.layoutTextInputPassword.error = null
                            binding.layoutTextInputConfirmPassword.error = null
                        }
                    }
                }
                else{
                    if(!viewModel.getIsEmailValid()) {
                        binding.layoutTextInputEmail.error = viewModel.getEmailError()
                    }
                    else{
                        binding.layoutTextInputEmail.error = null
                    }


                    if (!viewModel.getIsPasswordValid()) {
                        binding.layoutTextInputPassword.error = viewModel.getPasswordError()
                    }
                    else{
                        binding.layoutTextInputPassword.error = null
                    }

                    if (!viewModel.getIsConfirmPasswordValid()) {
                        binding.layoutTextInputConfirmPassword.error = viewModel.getConfirmPasswordError()
                    }
                    else{
                        binding.layoutTextInputConfirmPassword.error = null
                    }

                }
            }

        }
//    }
}