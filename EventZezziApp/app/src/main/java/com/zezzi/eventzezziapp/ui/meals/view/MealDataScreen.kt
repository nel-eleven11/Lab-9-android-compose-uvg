package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
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
import androidx.compose.material3.MaterialTheme
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
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.navigation.NavigationState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealDataScreen(
    navController: NavController,
    id: String,
    viewModel: MealDataViewModel = viewModel()
){
    if (viewModel.categoryUiState.meals.isEmpty()) {
        viewModel.getMealData(id)
    }

    Scaffold(
        topBar = {
            AppBar(title = "Recipe #$id", navController = navController)
        }
    ){
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
        } else{
            LazyColumn(
                contentPadding = it,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                items(viewModel.categoryUiState.meals) { meal ->

                    val ingredients = mutableListOf<String>()
                    val measurements = mutableListOf<String>()

                    ingredients.add(meal.ingredient1)
                    ingredients.add(meal.ingredient2)
                    ingredients.add(meal.ingredient3)
                    ingredients.add(meal.ingredient4)
                    ingredients.add(meal.ingredient5)
                    ingredients.add(meal.ingredient6)
                    ingredients.add(meal.ingredient7)
                    ingredients.add(meal.ingredient8)
                    ingredients.add(meal.ingredient9)
                    ingredients.add(meal.ingredient10)
                    ingredients.add(meal.ingredient11)
                    ingredients.add(meal.ingredient12)
                    ingredients.add(meal.ingredient13)
                    ingredients.add(meal.ingredient14)
                    ingredients.add(meal.ingredient15)
                    ingredients.add(meal.ingredient16)
                    ingredients.add(meal.ingredient17)
                    ingredients.add(meal.ingredient18)
                    ingredients.add(meal.ingredient19)
                    ingredients.add(meal.ingredient20)

                    measurements.add(meal.measure1)
                    measurements.add(meal.measure2)
                    measurements.add(meal.measure3)
                    measurements.add(meal.measure4)
                    measurements.add(meal.measure5)
                    measurements.add(meal.measure6)
                    measurements.add(meal.measure7)
                    measurements.add(meal.measure8)
                    measurements.add(meal.measure9)
                    measurements.add(meal.measure10)
                    measurements.add(meal.measure11)
                    measurements.add(meal.measure12)
                    measurements.add(meal.measure13)
                    measurements.add(meal.measure14)
                    measurements.add(meal.measure15)
                    measurements.add(meal.measure16)
                    measurements.add(meal.measure17)
                    measurements.add(meal.measure18)
                    measurements.add(meal.measure19)
                    measurements.add(meal.measure20)

                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxSize()
                            .clip(RoundedCornerShape(10))
                            .background(Color.LightGray)
                    ) {
                        Column(
                            modifier = Modifier.padding(2.dp),
                            verticalArrangement = Arrangement.SpaceAround,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(
                                text = "\n Recipe for "+meal.name+"\n",
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
                            Text(
                                text = "\n Ingredients: \n",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                            for (i in 0..19) {
                                if (ingredients[i] != "") {
                                    Text(
                                        text = ingredients[i] + " - " + measurements[i],
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.Left
                                    )
                                }
                            }
                            Text(
                                text = "\n Instructions \n",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Left
                            )
                            Text(
                                text = meal.instructions+"\n",
                                fontSize = 20.sp,
                                textAlign = TextAlign.Left
                            )
                        }
                    }
                }
            }
        }
    }
}