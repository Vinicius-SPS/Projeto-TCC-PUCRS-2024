package silva.vinicius.projeto.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import silva.vinicius.projeto.R
import silva.vinicius.projeto.databinding.ActivityEditProfileTagBinding
import silva.vinicius.projeto.viewmodel.EditProfileTagViewModel

class EditProfileTagActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileTagBinding
    private lateinit var viewModel: EditProfileTagViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileTagBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = EditProfileTagViewModel()
        getInfo()
        setTags()
        setButtons()
    }

    private fun setTags() {
        //GAME STYLE
        binding.tagCasual.setOnClickListener {
            selectTag(binding.tagCasual, viewModel.tagStateCasual())
        }

        binding.tagCompetitive.setOnClickListener {
            selectTag(binding.tagCompetitive, viewModel.tagStateCompetitive())
        }
        //LANGUAGES
        binding.tagPortuguese.setOnClickListener {
            selectTag(binding.tagPortuguese, viewModel.tagStatePortuguese())
        }

        binding.tagEnglish.setOnClickListener {
            selectTag(binding.tagEnglish, viewModel.tagStateEnglish())
        }

        //PLATAFORMS
        binding.tagPc.setOnClickListener {
            selectTag(binding.tagPc, viewModel.tagStatePc())
        }
        binding.tagXbox.setOnClickListener {
            selectTag(binding.tagXbox, viewModel.tagStateXbox())
        }
        binding.tagPlaystation.setOnClickListener {
            selectTag(binding.tagPlaystation, viewModel.tagStatePlayStation())
        }
        binding.tagMobile.setOnClickListener {
            selectTag(binding.tagMobile, viewModel.tagStateMobile())
        }

        //GAMES
        binding.tagLol.setOnClickListener {
            selectTag(binding.tagLol, viewModel.tagStateLol())
        }
        binding.tagMinecraft.setOnClickListener {
            selectTag(binding.tagMinecraft, viewModel.tagStateMinecraft())
        }
        binding.tagApex.setOnClickListener {
            selectTag(binding.tagApex, viewModel.tagStateApex())
        }
        binding.tagCs.setOnClickListener {
            selectTag(binding.tagCs, viewModel.tagStateCs())
        }
        binding.tagFreefire.setOnClickListener {
            selectTag(binding.tagFreefire, viewModel.tagStateFreeFire())
        }
    }

    fun setButtons() {
        binding.btnBack.setOnClickListener {
            finish()

        }

        binding.btnSave.setOnClickListener {
//            if (true) {
            if (viewModel.getIsListSize() >= 4) {
                viewModel.updateTags(viewModel.getTags()){result, message ->
                    if(!result){
                        Log.d("EditProfileTagActivity", message!!)
                    }
                }
                finish()
            }
            else{
                binding.errorMessage.setText("Selecione mais " + (4 - viewModel.getIsListSize()) + " tags")
            }
        }
    }

    private fun selectTag(tag: Button, isSelected: Boolean) {
        if (isSelected) {
            if (!viewModel.getIsListFull()) {
                viewModel.addItemList(tag.text.toString())
                tag.setBackgroundResource(R.drawable.tag_selected)
                tag.setTextColor(Color.parseColor("#EDEEEA"))
            }
        } else {
            viewModel.removeItemList(tag.text.toString())
            tag.setBackgroundResource(R.drawable.tag_not_selected)
            tag.setTextColor(Color.parseColor("#2E4057"))

        }
    }

    private fun getInfo() {
       viewModel.getPersonalProfile(){result, profile, message ->
            if(result){
                val listTags = profile!!
                    .tags!!
                    .replace("[","")
                    .replace("]","")
                    .trim()
                    .splitToSequence(",")
                    .toList()

                for(item in listTags){
                    when(item.trim()) {
                        "Casual" -> selectTag(binding.tagCasual, viewModel.tagStateCasual())
                        "Competitivo" -> selectTag(binding.tagCompetitive, viewModel.tagStateCompetitive())

                        "Português" -> selectTag(binding.tagPortuguese, viewModel.tagStatePortuguese())
                        "Inglês" -> selectTag(binding.tagEnglish, viewModel.tagStateEnglish())

                        "PC" -> selectTag(binding.tagPc, viewModel.tagStatePc())
                        "Mobile" -> selectTag(binding.tagMobile, viewModel.tagStateMobile())
                        "Xbox" -> selectTag(binding.tagXbox, viewModel.tagStateXbox())
                        "PlayStation" -> selectTag(binding.tagPlaystation, viewModel.tagStatePlayStation())

                        "LoL" -> selectTag(binding.tagLol, viewModel.tagStateLol())
                        "Minecraft" -> selectTag(binding.tagMinecraft, viewModel.tagStateMinecraft())
                        "APEX" -> selectTag(binding.tagApex, viewModel.tagStateApex())
                        "CS" -> selectTag(binding.tagCs, viewModel.tagStateCs())
                        "Free Fire" -> selectTag(binding.tagFreefire, viewModel.tagStateFreeFire())

                    }
                }


            }

        }
    }
}