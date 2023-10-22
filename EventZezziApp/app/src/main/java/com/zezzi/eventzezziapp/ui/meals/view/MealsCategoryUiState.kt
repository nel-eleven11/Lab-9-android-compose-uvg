package com.zezzi.eventzezziapp.ui.meals.view

import com.zezzi.eventzezziapp.data.networking.response.MealsResponse

data class MealsCategoryUiState(
    val categories: List<MealsResponse> = emptyList(),
    val loading: Boolean = false
)