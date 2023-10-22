package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.MealDataCatResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealDataWebService {
    private val api: MealDataApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealDataApi::class.java)
    }

    suspend fun getMealData(data: String): MealDataCatResponse {
        return api.getMealData(data)
    }
}