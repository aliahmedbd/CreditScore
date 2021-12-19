package com.aliahmed.technicaltask.creditscorecalculation.model

class ErrorMsg : Throwable() {
    var code : Int? = null
    var errorMessage: String? = null
}