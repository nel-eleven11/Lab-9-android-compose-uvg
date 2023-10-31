package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import kotlinx.coroutines.launch

class MealCatViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {

    var categoryUiState by mutableStateOf(MealCatUiState(emptyList()))
        private set

    fun getMeals(data: String) {
        categoryUiState = MealCatUiState(emptyList(), loading = true)

        viewModelScope.launch {
            categoryUiState = MealCatUiState(
                   meals = repository.getMealsCat(data).meals
            )
        }
    }
}