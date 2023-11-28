package com.example.front

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.front.chatlist.ChatListFragment
import com.example.front.databinding.ActivityMainBinding
import com.example.front.home.HomeFragment
import com.example.front.userinfo.UserInfoFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val chatListFragment = ChatListFragment()
        val userInfoFragment = UserInfoFragment()

        replaceFragment(homeFragment)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(homeFragment)
                R.id.chatList -> replaceFragment(chatListFragment)
                R.id.userInfo -> replaceFragment(userInfoFragment)
            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragmentContainer, fragment)
                commit()
            }
    }

//    override fun onStart() {
//        super.onStart()
//        startActivity(Intent(this, LogInActivity::class.java))
//    }
}