package silva.vinicius.projeto.view.chat


import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import silva.vinicius.projeto.databinding.ItemMessageBinding
import silva.vinicius.projeto.model.Message


class ChatRecyclerViewAdapter(
    private val friedUserId: String,
    private val messages: MutableList<Message>?
) :
    RecyclerView.Adapter<ChatRecyclerViewAdapter.ViewHolder>() {

    private val listRecivedMessages: ArrayList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("ChatRecyclerViewAdapter", "Mensagen: " + "Abrindo view holder")
        return ViewHolder(
            ItemMessageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d("ChatRecyclerViewAdapter", "Mensagen: " + "Acessando mensagens")
        if (messages != null) {

            val item = messages[position]
            Log.d("ChatRecyclerViewAdapter", "Mensagen: " + item.message!!)
            if (item.senderId != friedUserId) {
                viewHolder.userMessage.visibility = View.VISIBLE
                viewHolder.userMessage.text = item.message
            } else {
                viewHolder.friendMessage.visibility = View.VISIBLE
                viewHolder.friendMessage.text = item.message
            }


        }
    }


    fun setListMessages(messagesList: MutableList<Message>?) {
        if (messagesList != null) {
            for (message in messagesList) {
                messages!!.add(message)
                notifyItemInserted(messages.size - 1)
            }
        }
    }


    fun addNewMessage(newMessage: Message?) {
        if (newMessage != null) {
            if (!listRecivedMessages.contains(newMessage.messageId)) {
                messages!!.add(newMessage)
                notifyItemInserted(messages.size - 1)
                listRecivedMessages.add(newMessage.messageId!!)
            }

        }
    }

    override fun getItemCount(): Int {
        return if (messages == null) 0
        else messages.size
    }


    inner class ViewHolder(binding: ItemMessageBinding) : RecyclerView.ViewHolder(binding.root) {
        val userMessage: TextView = binding.userMessage
        val friendMessage: TextView = binding.friendMessage
    }

}