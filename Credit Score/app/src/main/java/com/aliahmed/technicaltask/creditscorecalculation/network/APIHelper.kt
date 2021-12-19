package com.aliahmed.technicaltask.creditscorecalculation.network

import com.aliahmed.technicaltask.creditscorecalculation.model.BaseResponse
import retrofit2.Call

/**
 * Created by Ali Ahmed, mail: aliahmedaiub@gmail.com
 */
interface APIHelper {
    fun getCreditScore(): Call<BaseResponse>
}