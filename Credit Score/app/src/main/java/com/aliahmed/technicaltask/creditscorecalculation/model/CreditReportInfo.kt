package com.aliahmed.technicaltask.creditscorecalculation.model

import com.google.gson.annotations.SerializedName

data class CreditReportInfo (
	@SerializedName("score") val score : Int,
	@SerializedName("scoreBand") val scoreBand : Int,
	@SerializedName("clientRef") val clientRef : String,
	@SerializedName("status") val status : String,
	@SerializedName("maxScoreValue") val maxScoreValue : Int,
	@SerializedName("minScoreValue") val minScoreValue : Int,
	@SerializedName("monthsSinceLastDefaulted") val monthsSinceLastDefaulted : Int,
	@SerializedName("hasEverDefaulted") val hasEverDefaulted : Boolean,
	@SerializedName("monthsSinceLastDelinquent") val monthsSinceLastDelinquent : Int,
	@SerializedName("hasEverBeenDelinquent") val hasEverBeenDelinquent : Boolean,
	@SerializedName("percentageCreditUsed") val percentageCreditUsed : Int,
	@SerializedName("percentageCreditUsedDirectionFlag") val percentageCreditUsedDirectionFlag : Int,
	@SerializedName("changedScore") val changedScore : Int,
	@SerializedName("currentShortTermDebt") val currentShortTermDebt : Int,
	@SerializedName("currentShortTermNonPromotionalDebt") val currentShortTermNonPromotionalDebt : Int,
	@SerializedName("currentShortTermCreditLimit") val currentShortTermCreditLimit : Int,
	@SerializedName("currentShortTermCreditUtilisation") val currentShortTermCreditUtilisation : Int,
	@SerializedName("changeInShortTermDebt") val changeInShortTermDebt : Int,
	@SerializedName("currentLongTermDebt") val currentLongTermDebt : Int,
	@SerializedName("currentLongTermNonPromotionalDebt") val currentLongTermNonPromotionalDebt : Int,
	@SerializedName("currentLongTermCreditLimit") val currentLongTermCreditLimit : String,
	@SerializedName("currentLongTermCreditUtilisation") val currentLongTermCreditUtilisation : String,
	@SerializedName("changeInLongTermDebt") val changeInLongTermDebt : Int,
	@SerializedName("numPositiveScoreFactors") val numPositiveScoreFactors : Int,
	@SerializedName("numNegativeScoreFactors") val numNegativeScoreFactors : Int,
	@SerializedName("equifaxScoreBand") val equifaxScoreBand : Int,
	@SerializedName("equifaxScoreBandDescription") val equifaxScoreBandDescription : String,
	@SerializedName("daysUntilNextReport") val daysUntilNextReport : Int
)