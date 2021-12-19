package com.aliahmed.technicaltask.creditscorecalculation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import com.aliahmed.technicaltask.creditscorecalculation.R
import com.aliahmed.technicaltask.creditscorecalculation.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loadSplashScreen()
    }

    private fun loadSplashScreen() {
        binding.motionLayout.setTransitionListener(
            object : MotionLayout.TransitionListener {
                override fun onTransitionStarted(motionLayout: MotionLayout, i: Int, i1: Int) {}
                override fun onTransitionChange(
                    motionLayout: MotionLayout,
                    i: Int,
                    i1: Int,
                    v: Float
                ) {
                }

                override fun onTransitionCompleted(motionLayout: MotionLayout, i: Int) {
                    val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
                    this@SplashActivity.startActivity(mainIntent)
                    finish()

                }

                override fun onTransitionTrigger(
                    motionLayout: MotionLayout,
                    i: Int,
                    b: Boolean,
                    v: Float
                ) {
                }
            })
    }
}