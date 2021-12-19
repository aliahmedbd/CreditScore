package com.aliahmed.technicaltask.creditscorecalculation.network

import com.aliahmed.technicaltask.creditscorecalculation.model.BaseResponse
import retrofit2.Call
import javax.inject.Inject

/**
 * Created by Ali Ahmed, mail: aliahmedaiub@gmail.com
 */
class ApiHelperImpl @Inject constructor(private val apiService: ApiInterface) : APIHelper {

    override suspend fun getCreditScore(): Call<BaseResponse> {
        return apiService.getCreditScore()
    }

}