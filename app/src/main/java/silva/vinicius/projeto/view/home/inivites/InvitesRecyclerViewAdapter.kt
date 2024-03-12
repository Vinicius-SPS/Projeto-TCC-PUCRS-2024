package silva.vinicius.projeto.view.home.inivites

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import silva.vinicius.projeto.databinding.FragmentItemInviteBinding
import silva.vinicius.projeto.view.UserProfileActivity

class InvitesRecyclerViewAdapter(private val context: Context,
                                 private val userInvite: ArrayList<silva.vinicius.projeto.model.Users>,
                                 private val userFriend: ArrayList<silva.vinicius.projeto.model.Users>
) :
    RecyclerView.Adapter<InvitesRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemInviteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = userInvite[position]
        viewHolder.userName.text = item.userName
        viewHolder.btnAccept.setOnClickListener{
            viewHolder.btnAccept.isClickable = false //Evitar o spam de clicks
            Log.d("invite", "posicao: ${viewHolder.bindingAdapterPosition}")
            Log.d("invite","Aceito")
            Log.d("invite", "Removido posicao: ${viewHolder.bindingAdapterPosition}")
            Log.d("invite", "Tamanho lista: ${userInvite.size}")
            acceptInvite(viewHolder.bindingAdapterPosition)

        }

        viewHolder.btnDeny.setOnClickListener{
            viewHolder.btnAccept.isClickable = false //Evitar o spam de clicks
            Log.d("invite", "posicao: ${viewHolder.bindingAdapterPosition}")
            Log.d("invite","Negado")
            Log.d("invite", "Removido posicao: ${viewHolder.bindingAdapterPosition}")
            Log.d("invite", "Tamanho lista: ${userInvite.size}")
            denyInvite(viewHolder.bindingAdapterPosition)




        }
        viewHolder.itemView.setOnClickListener{
            val intent = Intent(context, UserProfileActivity::class.java)
            intent.putExtra("user_name",item.userName)
            intent.putExtra("description",item.description)
            intent.putExtra("online_status", "Online")
            intent.putExtra("tags", item.tags.toString().replace("[","").replace("]",""))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = userInvite.size

    inner class ViewHolder(binding: FragmentItemInviteBinding) : RecyclerView.ViewHolder(binding.root) {
        val userName: TextView = binding.userName
        val btnAccept: TextView = binding.btnAccept
        val btnDeny: TextView = binding.btnDeny


    }

    private fun denyInvite(position: Int) {
        userInvite.removeAt(position)
        notifyItemRemoved(position)
    }

    private fun acceptInvite(position: Int){
        userFriend.add(userInvite[position])
        userInvite.removeAt(position)
        notifyItemRemoved(position)
    }
}



