package com.zezzi.eventzezziapp.ui.meals.view

import com.zezzi.eventzezziapp.data.networking.response.MealsResponse



data class MealsCategoryUiState(
    val categories: List<MealsResponse>,
    val loading: Boolean = false
)