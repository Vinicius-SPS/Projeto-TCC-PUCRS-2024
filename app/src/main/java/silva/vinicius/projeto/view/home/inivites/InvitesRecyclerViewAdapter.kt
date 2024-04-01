package silva.vinicius.projeto.view.home.inivites

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import silva.vinicius.projeto.databinding.FragmentItemInviteBinding
import silva.vinicius.projeto.firebase.get.FirebaseGetProfile
import silva.vinicius.projeto.firebase.operations.invite.FirebaseAcceptInvite
import silva.vinicius.projeto.firebase.operations.invite.FirebaseDenyInvite
import silva.vinicius.projeto.model.Users
import silva.vinicius.projeto.view.UserProfileActivity

class InvitesRecyclerViewAdapter(
    private val context: Context,
    private val values: ArrayList<Users>?
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
        if (values != null) {
            val item = values[position]
            val itemId: String = item.id.toString()
            FirebaseGetProfile().getProfile(itemId) { result, profile, message ->
                if (result && profile != null) {
                    viewHolder.userName.text = profile.userName

                    viewHolder.btnAccept.setOnClickListener {
                        viewHolder.btnAccept.isClickable = false //Evitar o spam de clicks
                        FirebaseAcceptInvite().acceptInvite(itemId) { result, message ->
                            if (result) {
                                removeFromList(viewHolder.bindingAdapterPosition)
                            } else {
                                Log.d("InvitesRecyclerViewAdapter", message)
                            }

                        }

                    }
                    viewHolder.btnDeny.setOnClickListener {
                        viewHolder.btnAccept.isClickable = false //Evitar o spam de clicks
                        FirebaseDenyInvite().denyInvite(itemId) { result, message ->
                            if (result) {
                                removeFromList(viewHolder.bindingAdapterPosition)
                            } else {
                                Log.d("InvitesRecyclerViewAdapter", message)
                            }

                        }

                    }

                    viewHolder.itemView.setOnClickListener {
                        val intent = Intent(context, UserProfileActivity::class.java)
                        intent.putExtra("user_id", item.id)
                        context.startActivity(intent)
                    }

                }
            }
        }


    }

    override fun getItemCount(): Int {
        return if (values == null) 0
        else values.size
    }

    inner class ViewHolder(binding: FragmentItemInviteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val userName: TextView = binding.userName
        val btnAccept: TextView = binding.btnAccept
        val btnDeny: TextView = binding.btnDeny


    }
    
    private fun removeFromList(position: Int) {
        if (values != null) {
            values.removeAt(position)
            notifyItemRemoved(position)
        }

    }
}



