package com.aliahmed.technicaltask.creditscorecalculation.model

data class APIResponse <out T>(val status: Status, val data: T?, val errorMsg: Throwable?){
    companion object{
        fun <T> loading(data: T? = null): APIResponse<T> {
            return APIResponse(Status.LOADING, data, null)
        }

        fun <T> success(data: T?): APIResponse<T> {
            return APIResponse(Status.SUCCESS, data, null)
        }

        fun <T> error(data: T? = null, errorMsg: Throwable? = null): APIResponse<T> {
            return APIResponse(Status.ERROR,data, errorMsg)
        }
    }
}