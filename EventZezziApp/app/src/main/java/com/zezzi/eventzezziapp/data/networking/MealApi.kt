package com.zezzi.eventzezziapp.data.networking

import retrofit2.http.GET
import com.zezzi.eventzezziapp.data.networking.response.MealCatResponse
import retrofit2.http.Query

interface MealApi {
    @GET("filter.php")
    suspend fun getMeals(@Query  ("c") category: String): MealCatResponse
}