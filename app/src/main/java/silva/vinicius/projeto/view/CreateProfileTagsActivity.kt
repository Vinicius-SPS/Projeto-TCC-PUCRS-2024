package silva.vinicius.projeto.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import silva.vinicius.projeto.R
import silva.vinicius.projeto.databinding.ActivityCreateProfileTagsBinding
import silva.vinicius.projeto.view.home.AppActivity

import silva.vinicius.projeto.viewmodel.CreateProfileTagViewModel

class CreateProfileTagsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateProfileTagsBinding
    private lateinit var viewModel: CreateProfileTagViewModel
    private lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateProfileTagsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = CreateProfileTagViewModel()

        getBundle()
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

        //PLATFORMS
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

    private fun setButtons() {
        binding.btnBack.setOnClickListener {
            val intent = Intent(this@CreateProfileTagsActivity, CreateProfileNameActivity::class.java)
            intent.putExtra ("user_name", bundle.getString("user_name", " "))
            if(bundle.getString("tags", " ") != null){
                intent.putExtra ("tags", viewModel.getTags())
            }
            startActivity(intent)
            finish()

        }

        binding.btnFinish.setOnClickListener {
            if (viewModel.getIsListSize() >= 4) {
                viewModel.updateProfile(bundle.getString("user_name")!!, viewModel.getTags()){ success, message ->
                    if (success){
                        startActivity(Intent(this@CreateProfileTagsActivity, AppActivity::class.java))
                        finish()
                    }
                    else{
                        Log.d("CreateProfileTagsActivity", message.toString())
                    }

                }
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

    private fun getBundle() {
        bundle = intent.extras!!
        Log.d("CreateProfileTagsActivity", "Recuperando Bundle")
        Log.d("CreateProfileTagsActivity", "nome: " +  bundle.getString("user_name", " "))
        bundle.getString("user_name", " ")

        if(bundle.getString("tags") != null) {
            val listTags = bundle.getString("tags")!!
                .replace("[", "")
                .replace("]", "")
                .trim()
                .splitToSequence(",")
                .toList()

            for (item in listTags) {
                when (item.trim()) {
                    "Casual" -> selectTag(binding.tagCasual, viewModel.tagStateCasual())
                    "Competitivo" -> selectTag(
                        binding.tagCompetitive,
                        viewModel.tagStateCompetitive()
                    )

                    "Português" -> selectTag(binding.tagPortuguese, viewModel.tagStatePortuguese())
                    "Inglês" -> selectTag(binding.tagEnglish, viewModel.tagStateEnglish())

                    "PC" -> selectTag(binding.tagPc, viewModel.tagStatePc())
                    "Mobile" -> selectTag(binding.tagMobile, viewModel.tagStateMobile())
                    "Xbox" -> selectTag(binding.tagXbox, viewModel.tagStateXbox())
                    "PlayStation" -> selectTag(
                        binding.tagPlaystation,
                        viewModel.tagStatePlayStation()
                    )

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