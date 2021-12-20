package com.aliahmed.technicaltask.creditscorecalculation.util

object CreditScoreUtil {


    /**
     * Check whether the data is correct or not
     * */
    fun validateCreditScore(creditScore: String): Boolean {
        if (creditScore == "...") {
            return false
        } else if (creditScore == "0" || creditScore == "0.0") {
            return false
        }
        return true
    }

    /**
     * Take input as creditScore and maxCreditScore and calculate the progress for the donut.
     * .. Check the progress value is correct or not
     * */
    fun calculateProgress(creditScore: Int, maxCreditScore: Int): Float {
        return (creditScore.toFloat() / maxCreditScore.toFloat()) * 100
    }
}