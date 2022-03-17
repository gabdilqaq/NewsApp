package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityNewsBinding
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.repository.NewsRepository

class NewsActivity : AppCompatActivity() {
    lateinit var viewModel: NewsViewModel

    private var _binding: ActivityNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        _binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.bottomNavigationView.setupWithNavController(Navigation.findNavController(this, R.id.newsNavHostFragment))


    }
}