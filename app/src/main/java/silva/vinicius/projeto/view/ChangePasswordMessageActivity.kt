package silva.vinicius.projeto.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import silva.vinicius.projeto.databinding.ActivityChangePasswordMessageBinding

class ChangePasswordMessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChangePasswordMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this@ChangePasswordMessageActivity, ForgotPasswordActivity::class.java))
        }


        binding.btnConfirm.setOnClickListener{
            startActivity(Intent(this@ChangePasswordMessageActivity, WelcomeActivity::class.java))
        }
    }
}