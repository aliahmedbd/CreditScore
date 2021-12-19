package com.aliahmed.technicaltask.creditscorecalculation.view

import android.app.ProgressDialog
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.aliahmed.technicaltask.creditscorecalculation.R
import com.aliahmed.technicaltask.creditscorecalculation.databinding.ActivityMainBinding
import com.aliahmed.technicaltask.creditscorecalculation.model.Status
import com.aliahmed.technicaltask.creditscorecalculation.util.showError
import com.aliahmed.technicaltask.creditscorecalculation.viewmodel.CreditScoreViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import com.facebook.shimmer.ShimmerFrameLayout


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
            creditScoreViewModel.response.observe(this@MainActivity) {
                it?.let { response ->
                    when (response.status) {
                        Status.LOADING -> {
                            binding.shimmerViewContainer.stopShimmer()
                            binding.shimmerViewContainer.visibility = View.GONE
                        }
                        Status.SUCCESS -> {
                            it.data?.let { data ->
                                binding.txtCreditScore.text = data.creditReportInfo.score.toString()
                                binding.txtCreditScoreBottom.text =
                                    "Out of ${data.creditReportInfo.maxScoreValue}"
                                val creditScore = data.creditReportInfo.score
                                val max = data.creditReportInfo.maxScoreValue
                                val progress = creditScore.toFloat() / max.toFloat()
                                binding.circularProgressBar.progress = progress.toFloat() * 100
                                binding.txtStatus.text = "Status : ${data.accountIDVStatus}"
                                binding.txtScoreDescription.text =
                                    data.creditReportInfo.equifaxScoreBandDescription
                                binding.txtLongTermDebt.text =
                                    data.creditReportInfo.currentLongTermDebt.toString()
                                binding.txtNonPromotionalDebt.text =
                                    data.creditReportInfo.currentLongTermNonPromotionalDebt.toString()
                                binding.txtPersonaType.text = data.personaType

                            } ?: kotlin.run {
                                binding.shimmerViewContainer.stopShimmer()
                                binding.shimmerViewContainer.visibility = View.GONE
                            }
                        }
                        Status.ERROR -> {
                            showError(it.errorMsg)
                            binding.shimmerViewContainer.stopShimmer()
                            binding.shimmerViewContainer.visibility = View.GONE
                        }
                    }
                }
            }
        }

    }

    /** Show an exit dialog to user confirmation */
    private fun showExitDialog() {
        val myQuittingDialogBox: AlertDialog = AlertDialog.Builder(this)
            .setTitle("Exit")
            .setIcon(R.mipmap.app_icon)
            .setMessage("Are you sure you want to exit the application?")
            .setPositiveButton(
                "Exit"
            ) { dialog: DialogInterface, _: Int ->
                moveTaskToBack(true)
                dialog.dismiss()
            }
            .setNegativeButton(
                "No"
            ) { dialog: DialogInterface, which: Int -> dialog.dismiss() }
            .create()
        myQuittingDialogBox.setOnShowListener {
            myQuittingDialogBox.getButton(AlertDialog.BUTTON_NEGATIVE)
                .setTextColor(Color.parseColor("#2f6699"))
            myQuittingDialogBox.getButton(AlertDialog.BUTTON_POSITIVE)
                .setTextColor(Color.parseColor("#90FF4500"))
        }
        myQuittingDialogBox.show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        showExitDialog();
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerViewContainer.startShimmer()
    }

    override fun onPause() {
        binding.shimmerViewContainer.stopShimmer()
        super.onPause()
    }

    override fun onDestroy() {
        binding.shimmerViewContainer.stopShimmer()
        super.onDestroy()
    }
}