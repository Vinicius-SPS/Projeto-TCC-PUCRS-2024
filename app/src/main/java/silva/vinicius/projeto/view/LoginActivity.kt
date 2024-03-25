package silva.vinicius.projeto.view

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import silva.vinicius.projeto.databinding.ActivityLoginBinding
import silva.vinicius.projeto.model.PersonalProfile
import silva.vinicius.projeto.view.home.AppActivity
import silva.vinicius.projeto.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = LoginViewModel()
        binding.layoutTextInputEmail.setErrorTextColor(ColorStateList.valueOf(Color.RED))
        binding.layoutTextInputPassword.setErrorTextColor(ColorStateList.valueOf(Color.RED))
        setButtons()
    }

    private fun setButtons() {
        binding.btnLogin.setOnClickListener {
            if (viewModel.verifyLogin(binding.textInputEmail.text, binding.textInputPassword.text)) {
                viewModel.doLogin(binding.textInputEmail.text, binding.textInputPassword.text){ success, error ->
                    if(success){
                        viewModel.getProfile{successProfile, profileInfo ->
                            if (successProfile) {
                                if (profileInfo != null) {
                                    if (profileInfo) {
                                        startActivity(
                                            Intent(
                                                this@LoginActivity,
                                                AppActivity::class.java
                                            )
                                        )
                                        finish()
                                    } else {

                                        val intent = Intent(this@LoginActivity, CreateProfileNameActivity::class.java)
                                        intent.putExtra("user_name", " ")
                                        startActivity(intent)
                                        finish()
                                    }
                                }
                            }
                        }

                    }
                    else{
                        binding.layoutTextInputEmail.error = "Endereço de e-mail ou senha inválida"
                        binding.layoutTextInputPassword.error = "Endereço de e-mail ou senha inválida"
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
            }
        }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this@LoginActivity, WelcomeActivity::class.java))
            finish()
        }

        binding.btnRegister.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
                finish()
        }

        binding.btnForgotPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
            finish()
        }
    }

}