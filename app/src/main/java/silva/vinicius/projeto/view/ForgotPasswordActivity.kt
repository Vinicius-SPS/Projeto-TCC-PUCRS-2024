package silva.vinicius.projeto.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import silva.vinicius.projeto.databinding.ActivityForgotPasswordBinding
import silva.vinicius.projeto.view.home.AppActivity
import silva.vinicius.projeto.viewmodel.ForgotPasswordViewModel

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding
    private lateinit var viewModel: ForgotPasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ForgotPasswordViewModel()
        setButtons()
    }

    private fun setButtons() {
        binding.btnSend.setOnClickListener {
            binding.btnSend.isActivated = false
            if (viewModel.doVerifyPasswordRecovery(binding.textInputEmail.text)) {
                viewModel.doSendEmail(binding.textInputEmail.text.toString()){ success, error ->
                    if(success){
                        binding.fieldTextInputEmail.error = viewModel.getEmailError()
                        viewModel.doSendEmail(binding.textInputEmail.text.toString()){result, message ->
                            if (result){
                                startActivity(Intent(this@ForgotPasswordActivity, ChangePasswordMessageActivity::class.java))
                                finish()
                            }
                            else{
                                binding.fieldTextInputEmail.error = message
                                binding.btnSend.isActivated = true
                            }


                        }
                    }
                    else{
                        binding.fieldTextInputEmail.error = error
                        binding.btnSend.isActivated = true

                    }
                }
            }
            else{
                if(!viewModel.getIsEmailValid()) {
                    binding.fieldTextInputEmail.error = viewModel.getEmailError()
                    binding.btnSend.isActivated = true

                }
                else{
                    binding.fieldTextInputEmail.error = null
                    binding.btnSend.isActivated = true

                }
            }
        }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this@ForgotPasswordActivity, LoginActivity::class.java))
            finish()
        }



    }
}