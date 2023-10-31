package com.zezzi.eventzezziapp.data.networking.response

import com.google.gson.annotations.SerializedName

data class MealCatResponse(val meals: List<MealResponseCat>)

data class MealResponseCat(
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String,
    @SerializedName("idMeal") val id: String
)