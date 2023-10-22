package com.zezzi.eventzezziapp.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.zezzi.eventzezziapp.data.networking.MealDataWebService
import com.zezzi.eventzezziapp.data.networking.response.MealDataCatResponse

class MealDataRepository(private val webService: MealDataWebService = MealDataWebService()) {

    suspend fun getMealData(data: String): MealDataCatResponse {
        return withContext(Dispatchers.IO) {
            webService.getMealData(data)
        }
    }
}