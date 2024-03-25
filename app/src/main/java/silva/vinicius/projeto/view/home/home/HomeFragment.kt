package silva.vinicius.projeto.view.home.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import silva.vinicius.projeto.R
import silva.vinicius.projeto.databinding.FragmentHomeBinding
import silva.vinicius.projeto.model.Users
import silva.vinicius.projeto.viewmodel.HomeFragmentViewModel

class HomeFragment : Fragment() {
    private var columnCount = 1
    private var _binding: FragmentHomeBinding? = null
    private lateinit var viewModel: HomeFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        viewModel = HomeFragmentViewModel()

        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                viewModel.getUserList(){userListResult, usersList, messageUsersList ->
                    if (userListResult){
                        viewModel.getInvitesInfoList(){inviteListResult, invitesList, messageInvitesList ->
                            if (inviteListResult){
                                viewModel.getInvitesAcceptInfoList(){acceptListResult, acceptList, messageAcceptList ->
                                    if(acceptListResult){
                                        adapter = UsersRecyclerViewAdapter(context, usersList,invitesList, acceptList)
                                    }
                                    else{
                                        adapter = UsersRecyclerViewAdapter(context, usersList,invitesList, ArrayList<String>())

                                    }
                                }
                            }
                            else{
                                viewModel.getInvitesAcceptInfoList(){acceptListResult, acceptList, messageAcceptList ->
                                    if(acceptListResult){
                                        adapter = UsersRecyclerViewAdapter(context, usersList,ArrayList<String>(), acceptList)
                                    }
                                    else{
                                        adapter = UsersRecyclerViewAdapter(context, usersList,ArrayList<String>(), ArrayList<String>())

                                    }
                                }
                            }
                        }

                    }
                    else{
                        adapter = UsersRecyclerViewAdapter(context, ArrayList<Users>(), ArrayList<String>(), ArrayList<String>())
                    }

                }


            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}