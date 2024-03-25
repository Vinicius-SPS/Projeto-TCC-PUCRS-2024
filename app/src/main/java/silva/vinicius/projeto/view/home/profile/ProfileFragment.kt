package silva.vinicius.projeto.view.home.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import silva.vinicius.projeto.databinding.FragmentProfileBinding
import silva.vinicius.projeto.view.EditProfileTagActivity
import silva.vinicius.projeto.view.WelcomeActivity
import silva.vinicius.projeto.viewmodel.ProfileFragmentViewModel


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ProfileFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel = ProfileFragmentViewModel()

        setData()
        setButton()

        return root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getProfile(){ result, profile, message ->
            if(result){
                if(profile != null){
                    binding.tagsText.text = profile.tags.toString().replace("[","").replace("]","")
                }

            }

        }

    }
    private fun setData(){
        viewModel.getProfile(){ result, profile, message ->
            if(result){
                if(profile != null){
                    binding.userName.text = profile.userName
                    binding.descriptionText.setText(profile.description)
                    binding.tagsText.text = profile.tags.toString().replace("[","").replace("]","")
                    binding.descriptionText.addTextChangedListener {
                        if(binding.descriptionText.text.toString() != profile.description){
                            binding.btnEdtDescription.alpha = 1f
                            binding.btnEdtDescription.isActivated = true
                        }
                        else{
                            binding.btnEdtDescription.alpha = 0.5f
                            binding.btnEdtDescription.isActivated = false
                        }

                    }
                }

            }

        }
    }

    private fun setButton(){

        binding.btnLogoff.setOnClickListener {
            viewModel.signOut()
            startActivity(Intent(activity, WelcomeActivity::class.java))
            activity?.finish()
        }

        binding.btnEdtTags.setOnClickListener {
            startActivity(Intent(activity, EditProfileTagActivity::class.java))
        }
        binding.btnEdtDescription.alpha = 0.5f
        binding.btnEdtDescription.isActivated = false
        binding.btnEdtDescription.setOnClickListener{

            viewModel.updateDescription(binding.descriptionText.text.toString()){ result, message ->
                if(result){
                    binding.btnEdtDescription.alpha = 0.5f
                    binding.btnEdtDescription.isActivated = false
                }
                else{
                    Log.d("ProfileFragment",message!!)
                }
            }
        }

    }



}