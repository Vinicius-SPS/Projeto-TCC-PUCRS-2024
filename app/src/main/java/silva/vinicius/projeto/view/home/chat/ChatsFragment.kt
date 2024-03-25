package silva.vinicius.projeto.view.home.chat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import silva.vinicius.projeto.R
import silva.vinicius.projeto.viewmodel.ChatFragmentViewModel


class ChatsFragment : Fragment() {
    private var columnCount = 1
    private lateinit var viewModel: ChatFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_chats_list, container, false)
        viewModel = ChatFragmentViewModel()

        viewModel.getChatList(){result, chatList, message ->
            if(result){
                // Set the adapter
                if (view is RecyclerView) {
                    with(view) {
                        layoutManager = when {
                            columnCount <= 1 -> LinearLayoutManager(context)
                            else -> GridLayoutManager(context, columnCount)
                        }
                        adapter = ChatsRecyclerViewAdapter(context, chatList)
                    }
                }
            }
            else{
                Log.d("ChatsFragment", message)
            }

        }

        return view
    }

}