package com.zezzi.eventzezziapp.ui.meals.view

import com.zezzi.eventzezziapp.data.networking.response.MealResponseCat

data class MealCatUiState(
    val meals: List<MealResponseCat>,
    val loading: Boolean = false
)


