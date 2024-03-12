package silva.vinicius.projeto.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        viewModel =  EditProfileTagViewModel()

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
            if (true) {
//            if (viewModel.getIsListSize() > 0) {

                finish()
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
}