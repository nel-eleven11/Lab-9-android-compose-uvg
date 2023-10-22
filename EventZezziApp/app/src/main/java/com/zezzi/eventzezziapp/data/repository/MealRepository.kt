package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.MealWebService
import com.zezzi.eventzezziapp.data.networking.response.MealCatResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MealRepository(private val webService: MealWebService = MealWebService()) {

    suspend fun getMeals(data: String): MealCatResponse {
        return withContext(Dispatchers.IO) {
            webService.getMeals(data)
        }
    }
}