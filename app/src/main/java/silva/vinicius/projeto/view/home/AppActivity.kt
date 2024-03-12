package silva.vinicius.projeto.view.home

import android.os.Bundle
import android.view.Menu
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import silva.vinicius.projeto.R
import silva.vinicius.projeto.databinding.ActivityAppBinding
import silva.vinicius.projeto.view.home.chat.ChatsFragment
import silva.vinicius.projeto.view.home.inivites.InvitesFragment
import silva.vinicius.projeto.view.home.profile.ProfileFragment
import silva.vinicius.projeto.view.home.home.HomeFragment

class AppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fragmentTitle.text = "Página Inicial"
        loadFragment(HomeFragment())

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation_bar)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.profile -> {
                    binding.fragmentTitle.text = "Perfil"
                    loadFragment(ProfileFragment())
                    return@setOnItemSelectedListener true
                }

                R.id.home -> {
                    binding.fragmentTitle.text = "Página Inicial"
                    loadFragment(HomeFragment())
                    return@setOnItemSelectedListener true
                }

                R.id.notifications -> {
                    binding.fragmentTitle.text = "Convites"
                    loadFragment(InvitesFragment())
                    return@setOnItemSelectedListener true

                }

                R.id.chats -> {
                    binding.fragmentTitle.text = "Conversas"
                    loadFragment(ChatsFragment())
                    return@setOnItemSelectedListener true

                }

                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_nav_menu, menu)
        return true
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_home, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}


