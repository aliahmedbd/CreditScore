package com.aliahmed.technicaltask.creditscorecalculation.model

import com.google.gson.annotations.SerializedName

data class BaseResponse (
	@SerializedName("accountIDVStatus") val accountIDVStatus : String,
	@SerializedName("creditReportInfo") val creditReportInfo : CreditReportInfo,
	@SerializedName("dashboardStatus") val dashboardStatus : String,
	@SerializedName("personaType") val personaType : String,
	@SerializedName("coachingSummary") val coachingSummary : CoachingSummary,
	@SerializedName("augmentedCreditScore") val augmentedCreditScore : String
)