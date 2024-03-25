package silva.vinicius.projeto.view.home.chat

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import silva.vinicius.projeto.databinding.FragmentItemChatBinding
import silva.vinicius.projeto.firebase.get.FirebaseGetProfile
import silva.vinicius.projeto.model.Chat
import silva.vinicius.projeto.view.chat.ChatActivity


class ChatsRecyclerViewAdapter(private val context: Context, private val values: ArrayList<Chat>?) :
    RecyclerView.Adapter<ChatsRecyclerViewAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemChatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if(values != null){
            val item = values[position]
            val intent = Intent(context, ChatActivity::class.java)
            if(FirebaseAuth.getInstance().currentUser?.uid == item.invitedId){
                FirebaseGetProfile().getProfile(item.hostId){result, profile, message ->
                    if(result){
                        viewHolder.userName.text = profile!!.userName
                        intent.putExtra("user_id",item.hostId)
                        intent.putExtra("chat_id",item.chatId)
                    }


                }
            }
            else if(FirebaseAuth.getInstance().currentUser?.uid == item.hostId){
                FirebaseGetProfile().getProfile(item.invitedId){result, profile, message ->
                    if (result) {
                        viewHolder.userName.text = profile!!.userName
                        intent.putExtra("user_id", item.invitedId)
                        intent.putExtra("chat_id", item.chatId)
                    }
                }
            }

//            viewHolder.userName.text = item.userName
            viewHolder.userMessage.text = ""

            viewHolder.itemView.setOnClickListener{
//                intent.putExtra("tags", item.tags.toString().replace("[","").replace("]",""))
                context.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int {
        return if (values == null) 0
        else values.size
    }

    inner class ViewHolder(binding: FragmentItemChatBinding) : RecyclerView.ViewHolder(binding.root) {
        val userName: TextView = binding.userName
        val userMessage: TextView = binding.message

        override fun toString(): String {
            return super.toString() + " '" + userMessage.text + "'"
        }
    }
}



