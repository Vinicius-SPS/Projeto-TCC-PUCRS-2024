package silva.vinicius.projeto.view.home.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import silva.vinicius.projeto.databinding.FragmentProfileBinding
import silva.vinicius.projeto.view.EditProfileTagActivity
import silva.vinicius.projeto.view.WelcomeActivity
import silva.vinicius.projeto.viewmodel.ProfileFragmentViewModel


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewMode: ProfileFragmentViewModel
    private lateinit var profile: silva.vinicius.projeto.model.Profile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    //O IMPORTANTE
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewMode = ProfileFragmentViewModel()

        setData()
        setButton()

        return root
    }
    private fun setData(){
        profile = viewMode.getUserInformationMock()
        binding.userName.text = profile.userName
        binding.descriptionText.setText(profile.description)
        binding.tagsText.text = profile.tags.toString().replace("[","").replace("]","")
    }

    private fun setButton(){
        binding.btnLogoff.setOnClickListener {
            startActivity(Intent(activity, WelcomeActivity::class.java))
            activity?.finish()
        }

        binding.btnEdtTags.setOnClickListener {
            startActivity(Intent(activity, EditProfileTagActivity::class.java))
        }
    }


}