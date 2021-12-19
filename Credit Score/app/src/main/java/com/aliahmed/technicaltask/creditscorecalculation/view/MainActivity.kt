package com.aliahmed.technicaltask.creditscorecalculation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.aliahmed.technicaltask.creditscorecalculation.R
import com.aliahmed.technicaltask.creditscorecalculation.databinding.ActivityMainBinding
import com.aliahmed.technicaltask.creditscorecalculation.viewmodel.CreditScoreViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var creditScoreViewModel: CreditScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initialize()
    }

    private fun initialize() {
        creditScoreViewModel = ViewModelProvider(this).get(CreditScoreViewModel::class.java)
        lifecycleScope.launchWhenStarted {
            creditScoreViewModel.getCreditScore()
        }

    }
}