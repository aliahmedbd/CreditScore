package com.aliahmed.technicaltask.creditscorecalculation.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CreditScoreUtilTest {

    @Test
    fun `valid credit score`() {
        val result = CreditScoreUtil.validateCreditScore("...")
        assertThat(result).isFalse()
    }

    @Test
    fun `valid progress calculation`() {
        val result = CreditScoreUtil.calculateProgress(creditScore = 350, maxCreditScore = 700)
        assertThat(result).isEqualTo(50)
    }

}