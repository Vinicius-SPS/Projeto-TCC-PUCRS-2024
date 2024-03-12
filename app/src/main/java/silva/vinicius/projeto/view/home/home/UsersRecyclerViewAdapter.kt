package silva.vinicius.projeto.view.home.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import silva.vinicius.projeto.databinding.FragmentItemUsersBinding
import silva.vinicius.projeto.view.UserProfileActivity


class UsersRecyclerViewAdapter(private val context: Context, private val values: ArrayList<silva.vinicius.projeto.model.Users>) :
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
        val item = values[position]
        viewHolder.userName.text = item.userName

        viewHolder.itemView.setOnClickListener{
            val intent = Intent(context, UserProfileActivity::class.java)
            intent.putExtra("user_name",item.userName)
            intent.putExtra("description",item.description)
            intent.putExtra("online_status", "Online")
            intent.putExtra("tags", item.tags.toString().replace("[","").replace("]",""))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemUsersBinding) : RecyclerView.ViewHolder(binding.root) {
        val userName: TextView = binding.userName
    }


}



