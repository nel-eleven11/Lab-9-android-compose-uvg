package com.zezzi.eventzezziapp.data.networking

import retrofit2.http.GET
import com.zezzi.eventzezziapp.data.networking.response.MealDataCatResponse
import retrofit2.http.Query

interface MealDataApi {

    @GET("lookup.php")
    suspend fun getMealData(@Query  ("i") id: String): MealDataCatResponse
}