package com.zezzi.eventzezziapp.data.repository

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.zezzi.eventzezziapp.data.networking.response.MealCatResponse
import com.zezzi.eventzezziapp.data.networking.response.MealResponseCat
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class MealsRepository2 {

    val db = Firebase.firestore
    suspend fun getMeals(): MealsCategoriesResponse {
        return withContext(Dispatchers.IO) {
            val documents = db.collection("Meals").get().await().documents

            MealsCategoriesResponse(
                documents.map{
                    MealsResponse(
                        it.id,
                        it.getString("strCategory") ?: "",
                        it.getString("strCategoryDescription") ?: "",
                        it.getString("strCategoryThumb") ?: ""
                    )
                }
            )
        }
    }

    suspend fun getMealsCat(data: String): MealCatResponse {
        return withContext(Dispatchers.IO) {
            val documents = db.collection("Meals").document(data).collection("CatMeals").get().await().documents

            MealCatResponse(
                documents.map{
                    MealResponseCat(
                        it.id,
                        it.getString("strMeal") ?: "",
                        it.getString("strMealThumb") ?: "",
                    )
                }
            )
        }
    }
}