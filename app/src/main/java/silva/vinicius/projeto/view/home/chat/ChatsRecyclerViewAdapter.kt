package silva.vinicius.projeto.view.home.chat

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import silva.vinicius.projeto.databinding.FragmentItemChatBinding
import silva.vinicius.projeto.view.UserProfileActivity


class ChatsRecyclerViewAdapter(private val context: Context, private val values: List<silva.vinicius.projeto.model.Users>) :
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
        val item = values[position]
        viewHolder.userName.text = item.userName
        viewHolder.userMessage.text = ""

        viewHolder.itemView.setOnClickListener{
            val intent = Intent(context, UserProfileActivity::class.java)
            intent.putExtra("user_name","João")
            intent.putExtra("description","Estou em busca de alguém para jogar!")
            intent.putExtra("online_status", "Online")
            intent.putExtra("tags", "Casual, Minecraft")
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemChatBinding) : RecyclerView.ViewHolder(binding.root) {
        val userName: TextView = binding.userName
        val userMessage: TextView = binding.message

        override fun toString(): String {
            return super.toString() + " '" + userMessage.text + "'"
        }
    }
}



