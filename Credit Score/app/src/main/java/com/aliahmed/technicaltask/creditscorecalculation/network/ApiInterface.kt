package com.aliahmed.technicaltask.creditscorecalculation.network

import com.aliahmed.technicaltask.creditscorecalculation.model.BaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET(URL.GET_CREDIT_SCORE)
    fun getCreditScore(): Call<BaseResponse>
}