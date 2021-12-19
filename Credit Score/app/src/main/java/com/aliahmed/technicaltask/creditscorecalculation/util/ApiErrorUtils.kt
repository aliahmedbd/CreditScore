package com.aliahmed.technicaltask.creditscorecalculation.util

import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.aliahmed.technicaltask.creditscorecalculation.R
import com.aliahmed.technicaltask.creditscorecalculation.model.ErrorMsg
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun FragmentActivity.showError(code: Int?, msg: String? = null) {
    var errTitle: Int = R.string.not_responding
    var errMsg: String = getString(R.string.error_something_went_wrong)

    when (code) {
        401 -> {
            errTitle = R.string.request_not_found
            errMsg = getString(R.string.request_not_found)
        }
        404 -> {
            errTitle = R.string.request_not_found
            errMsg = getString(R.string.request_not_found)
        }
        429 -> {
            errTitle = R.string.too_many_request
            errMsg = getString(R.string.please_try_again_later)
        }
        500 -> {
            errTitle = R.string.not_responding
            errMsg = getString(R.string.error_something_went_wrong)
        }
    }
    showToast(msg = (msg ?: errMsg))
}

fun FragmentActivity.showError(error: Throwable?) {
    var errTitle: Int = R.string.not_responding
    var msg: Int = R.string.error_something_went_wrong

    when (error) {
        is HttpException -> {
            val errCode = error.code()
            showError(code = errCode, msg = error.message())
        }
        is ErrorMsg -> {
            showError(code = error.code, msg = error.errorMessage)
        }
        is SocketTimeoutException -> {
            errTitle = R.string.request_time_out
            msg = R.string.please_try_again_later
            showToast(msg = getString(msg))
        }
        is ConnectException -> {
            errTitle = R.string.no_internet_connection
            msg = R.string.check_internet_connection
            showToast(msg = getString(msg))
        }
        is UnknownHostException -> {
            errTitle = R.string.no_internet_connection
            msg = R.string.check_internet_connection
            showToast(msg = getString(msg))
        }
    }
}


fun Context.showToast(msg: String?) {
    msg?.let {
        val toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 40)
        toast.show()
    }
}