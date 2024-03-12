package silva.vinicius.projeto.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import silva.vinicius.projeto.databinding.ActivityWelcomeBinding


class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater())
        setContentView(binding.getRoot())

        setButtons()
    }

    private fun setButtons() {
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this@WelcomeActivity, LoginActivity::class.java))
            finish()
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this@WelcomeActivity, RegisterActivity::class.java))
            finish()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
    }
}