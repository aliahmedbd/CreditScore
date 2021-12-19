package com.aliahmed.technicaltask.creditscorecalculation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aliahmed.technicaltask.creditscorecalculation.model.APIResponse
import com.aliahmed.technicaltask.creditscorecalculation.model.BaseResponse
import com.aliahmed.technicaltask.creditscorecalculation.model.ErrorMsg
import com.aliahmed.technicaltask.creditscorecalculation.network.APIHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CreditScoreViewModel @Inject constructor(private val apiHelper: APIHelper): ViewModel() {

    private val _response = MutableLiveData<APIResponse<BaseResponse>>()
    val response: LiveData<APIResponse<BaseResponse>> = _response

    suspend fun getCreditScore() {
        _response.postValue(APIResponse.loading())
        apiHelper.getCreditScore()
            .enqueue(object : Callback<BaseResponse> {
                override fun onResponse(
                    call: Call<BaseResponse>,
                    response: Response<BaseResponse>
                ) {
                    response.body()?.let {
                        if (response.code() == 200 && response.isSuccessful) {
                            _response.postValue(APIResponse.success(it))
                        } else if (response.code() == 401) {
                            val error = ErrorMsg()
                            error.code = 401
                            error.errorMessage = response.message()
                            _response.postValue(APIResponse.error(errorMsg = error))
                        } else {
                            val error = ErrorMsg()
                            error.code = 500
                            error.errorMessage = response.message()
                            _response.postValue(APIResponse.error(errorMsg = error))
                        }
                    } ?: kotlin.run {
                        _response.postValue(APIResponse.error(null))
                    }
                }

                override fun onFailure(call: Call<BaseResponse>?, t: Throwable) {
                    val error = ErrorMsg()
                    error.code = 401
                    error.errorMessage = t.message
                    _response.postValue(APIResponse.error(errorMsg = error))
                }
            })
    }

}