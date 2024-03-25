package silva.vinicius.projeto.view.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import silva.vinicius.projeto.R
import silva.vinicius.projeto.databinding.ActivityChatBinding
import silva.vinicius.projeto.model.Message
import silva.vinicius.projeto.viewmodel.ChatViewModel

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    private lateinit var viewModel: ChatViewModel
    private lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ChatViewModel()
        getInfo()
        getChat()
        setButtons()


    }

    private fun getInfo() {
        bundle = intent.extras!!

        if (bundle.getString("user_id") != null) {
            viewModel.getProfile(bundle.getString("user_id")!!) { result, profile, message ->
                if (result) {
                    binding.title.text = profile!!.userName
                }
            }
        }
    }

    private fun getChat() {
        if (bundle.getString("chat_id") != null) {

            binding.messageList.layoutManager = LinearLayoutManager(this)
            val adapter = ChatRecyclerViewAdapter(bundle.getString("user_id")!!, mutableListOf())
            binding.messageList.adapter = adapter


            viewModel.getChatList(bundle.getString("chat_id")!!) { resultNewMessage, newMessage, messageNewMessage ->
                if (resultNewMessage) {
                    Log.d("ChatActivity", "Chat: " + "Nova mensagem recebida")
                    adapter.addNewMessage(newMessage)
                }
                else{
                    Log.d("ChatActivity", "Chat: " + "Menuma mensagem recebida")
                }
            }
        }

    }


    private fun setButtons() {
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.btnSend.alpha = 0.5f
        binding.btnSend.isActivated = false

        binding.edtMessage.addTextChangedListener {
            if(binding.edtMessage.text.isNotBlank() ){
                binding.btnSend.alpha = 1f
                binding.btnSend.isActivated = true
            }
        }
        binding.btnSend.setOnClickListener {
            binding.btnSend.alpha = 0.5f
            binding.btnSend.isActivated = false
            if (bundle.getString("chat_id") != null) {
                viewModel.sendMessage(
                    bundle.getString("chat_id")!!, binding.edtMessage.text.toString()
                ) { result, message ->
                    if (result) {
                        binding.edtMessage.text.clear()
                        Log.d("ChatActivity", message)
                    } else {
                        Log.d("ChatActivity", message)
                    }
                }

            }



        }
    }

}