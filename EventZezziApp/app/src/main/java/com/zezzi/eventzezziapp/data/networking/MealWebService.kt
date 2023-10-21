package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.MealCatResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealWebService{

    private val api: MealApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealApi::class.java)
    }

    suspend fun getMeals(data: String): MealCatResponse {
        return api.getMeals(data)
    }

}
