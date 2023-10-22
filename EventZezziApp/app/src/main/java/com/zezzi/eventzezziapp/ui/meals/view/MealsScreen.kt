package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.navigation.NavigationState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsScreen(
    navController: NavController,
    category: String,
    viewModel: MealCatViewModel = viewModel()
) {
    if (viewModel.categoryUiState.meals.isEmpty()) {
        viewModel.getMeals(category)
    }
    Scaffold(
        topBar = {
            AppBar(title = "Meals for $category", navController = navController)
        }
    ) {
        if (viewModel.categoryUiState.loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        } else {
            LazyColumn(
                contentPadding = it,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                items(viewModel.categoryUiState.meals) { meal ->
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxSize()
                            .clip(RoundedCornerShape(10))
                            .background(Color.LightGray)
                    ){
                        Column(
                            modifier = Modifier.padding(2.dp),
                            verticalArrangement = Arrangement.SpaceAround,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(
                                text = meal.name,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                            AsyncImage(
                                model = meal.imageUrl,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(2.dp)
                                    .fillMaxSize()
                            )
                            Button(
                                onClick = { navController.navigate("${NavigationState.MealData.route}/${meal.id}") },
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(10),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                            ) {
                                Text(
                                    text = "Recipe",
                                    modifier = Modifier
                                        .padding(7.dp)
                                        .fillMaxWidth(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}