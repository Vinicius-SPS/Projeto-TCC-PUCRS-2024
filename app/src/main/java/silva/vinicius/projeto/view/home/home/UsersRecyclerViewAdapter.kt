package silva.vinicius.projeto.view.home.home

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import silva.vinicius.projeto.databinding.FragmentItemUsersBinding
import silva.vinicius.projeto.firebase.operations.invite.FirebaseSendInvite
import silva.vinicius.projeto.model.Users
import silva.vinicius.projeto.view.UserProfileActivity


class UsersRecyclerViewAdapter(private val context: Context,
                               private val users: ArrayList<Users>?,
                               private val acceptsList: ArrayList<String>?,
                               private val invitesList: ArrayList<String>?) :
    RecyclerView.Adapter<UsersRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemUsersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if(users != null && invitesList != null && acceptsList != null){

            val item = users[position]
            viewHolder.userName.text = item.userName
            val userId = item.id.toString()

            viewHolder.itemView.setOnClickListener{
                val intent = Intent(context, UserProfileActivity::class.java)
                intent.putExtra("user_id", userId)
                Log.d("UsersRecyclerViewAdapter", "id: " + userId)
                context.startActivity(intent)
            }

            if(invitesList.contains(userId) || acceptsList.contains(userId)){
                viewHolder.btnInvite.isClickable = false //Evitar o spam de clicks
                viewHolder.btnInvite.isActivated = false
                viewHolder.btnInvite.alpha = 0.5f
                viewHolder.btnInvite.text = "Convite já enviado ou recebido"
            }

            viewHolder.btnInvite.setOnClickListener {
                viewHolder.btnInvite.isClickable = false //Evitar o spam de clicks
                viewHolder.btnInvite.isActivated = false
                viewHolder.btnInvite.alpha = 0.5f

                FirebaseSendInvite().sendInvite(item.id.toString()){ result, message ->
                    if(result){
                        viewHolder.btnInvite.isActivated = false
                        viewHolder.btnInvite.isClickable = false
                        viewHolder.btnInvite.alpha = 0.5f
                        viewHolder.btnInvite.text = "Convite enviado"
                        Log.d("UsersRecyclerViewAdapter", message)
                    }
                    else{
                        viewHolder.btnInvite.isActivated = true
                        viewHolder.btnInvite.isClickable = true
                        viewHolder.btnInvite.alpha = 1f
                    }

                }


            }
        }
    }

    override fun getItemCount(): Int {
        return if (users == null) 0
        else users.size
    }


    inner class ViewHolder(binding: FragmentItemUsersBinding) : RecyclerView.ViewHolder(binding.root) {
        val userName: TextView = binding.userName
        val btnInvite: TextView = binding.btnInvite
    }


}



