package silva.vinicius.projeto.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import silva.vinicius.projeto.R
import silva.vinicius.projeto.databinding.ActivityCreateProfileTagsBinding
import silva.vinicius.projeto.view.home.AppActivity

import silva.vinicius.projeto.viewmodel.CreateProfileTagViewModel

class CreateProfileTagsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateProfileTagsBinding
    private lateinit var viewModel: CreateProfileTagViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateProfileTagsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = CreateProfileTagViewModel()

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
            startActivity(
                Intent(
                    this@CreateProfileTagsActivity,
                    CreateProfileNameActivity::class.java
                )
            )
            finish()

        }

        binding.btnFinish.setOnClickListener {
            if (viewModel.getIsListSize() > 0) {
                startActivity(Intent(this@CreateProfileTagsActivity, AppActivity::class.java))
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