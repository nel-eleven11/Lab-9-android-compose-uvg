package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.zezzi.eventzezziapp.data.repository.MealDataRepository

class MealDataViewModel(private val repository: MealDataRepository = MealDataRepository()): ViewModel() {
    var categoryUiState by mutableStateOf(MealDataUiState(emptyList()))
        private set
    fun getMealData(id: String) {
        categoryUiState = MealDataUiState(emptyList(), loading = true)

        viewModelScope.launch {
            categoryUiState = MealDataUiState(
                   meals = repository.getMealData(id).meals,
            )
        }
    }
}