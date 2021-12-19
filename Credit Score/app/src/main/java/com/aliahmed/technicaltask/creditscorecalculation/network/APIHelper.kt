package com.aliahmed.technicaltask.creditscorecalculation.network

import com.aliahmed.technicaltask.creditscorecalculation.model.BaseResponse

/**
 * Created by Ali Ahmed, mail: aliahmedaiub@gmail.com
 */
interface APIHelper {
    suspend fun getCreditScore(): BaseResponse
}