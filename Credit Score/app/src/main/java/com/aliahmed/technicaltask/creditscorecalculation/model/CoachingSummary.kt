package com.aliahmed.technicaltask.creditscorecalculation.model

import com.google.gson.annotations.SerializedName

data class CoachingSummary (

	@SerializedName("activeTodo") val activeTodo : Boolean,
	@SerializedName("activeChat") val activeChat : Boolean,
	@SerializedName("numberOfTodoItems") val numberOfTodoItems : Int,
	@SerializedName("numberOfCompletedTodoItems") val numberOfCompletedTodoItems : Int,
	@SerializedName("selected") val selected : Boolean
)