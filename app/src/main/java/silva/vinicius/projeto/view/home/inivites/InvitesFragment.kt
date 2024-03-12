package silva.vinicius.projeto.view.home.inivites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import silva.vinicius.projeto.R
import silva.vinicius.projeto.view.home.listsPlaceholder.ChatsContentPlaceholder
import silva.vinicius.projeto.view.home.listsPlaceholder.InvitesContentPlaceholder
import silva.vinicius.projeto.viewmodel.InvitesFragmentViewModel

class InvitesFragment : Fragment() {
    private var columnCount = 1
    private lateinit var viewModel: InvitesFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_invites, container, false)
        viewModel = InvitesFragmentViewModel()
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = InvitesRecyclerViewAdapter(context, InvitesContentPlaceholder.USERS, ChatsContentPlaceholder.USERS)
            }
        }
        return view
    }

}