package com.application.booksearchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.application.booksearchapp.databinding.ActivityMainBinding
import com.application.booksearchapp.ui.view.FavoriteFragment
import com.application.booksearchapp.ui.view.SearchFragment
import com.application.booksearchapp.ui.view.SettingFragment

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupBottomNavigationView()
        if (savedInstanceState == null) {
            binding.bottomNavigationView.selectedItemId = R.id.fragment_search
        }
    }


    private fun setupBottomNavigationView() {
        binding.bottomNavigationView.setOnClickListener { item ->
            when (item.id) {
                R.id.fragment_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, SearchFragment())
                        .commit()
                    true
                }

                R.id.fragment_favorite -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, FavoriteFragment())
                        .commit()
                    true
                }

                R.id.fragment_settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, SettingFragment())
                        .commit()
                    true
                }

                else -> false


            }
        }

    }

} 