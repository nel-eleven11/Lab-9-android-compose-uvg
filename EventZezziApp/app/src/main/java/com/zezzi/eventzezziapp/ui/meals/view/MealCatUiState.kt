package com.zezzi.eventzezziapp.ui.meals.view

import com.zezzi.eventzezziapp.data.networking.response.MealResponse

data class MealCatUiState(
    val meals: List<MealResponse>,
    val loading: Boolean = false
)


