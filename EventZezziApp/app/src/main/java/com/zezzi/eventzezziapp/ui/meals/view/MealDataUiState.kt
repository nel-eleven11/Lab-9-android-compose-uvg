package com.zezzi.eventzezziapp.ui.meals.view

import com.zezzi.eventzezziapp.data.networking.response.MealDataResponse

class MealDataUiState (
    val meals: List<MealDataResponse>,
    val loading: Boolean = false
)