package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.navigation.Navigation
import com.zezzi.eventzezziapp.ui.theme.EventZezziAppTheme
import kotlinx.coroutines.runBlocking
import androidx.compose.material3.MaterialTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel()
){
    if (viewModel.categoryUiState.categories.isEmpty()) {
        viewModel.getMeals()
    }
    Scaffold(
        topBar = {
            AppBar(title = "Categories", navController = navController)
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
            LazyColumn(contentPadding = it) {
                items(viewModel.categoryUiState.categories) { meal ->
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxSize()
                            .clip(RoundedCornerShape(10))
                            .background(Color.LightGray)
                    ) {
                        Column(
                            modifier = Modifier.padding(2.dp),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(){
                                AsyncImage(
                                    model = meal.imageUrl,
                                    contentDescription = meal.description
                                )
                                Column(
                                    modifier = Modifier.padding(2.dp)
                                ) {
                                    Text(
                                        text = "Category: ",
                                        modifier = Modifier
                                            .padding(2.dp),
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = meal.name,
                                        modifier = Modifier
                                            .padding(2.dp),
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Text(
                                        text = "Date: 10 Month 8 Day ",
                                        modifier = Modifier
                                            .padding(2.dp),
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            Row() {
                                Column(
                                    modifier = Modifier.padding(2.dp)
                                ) {
                                    Text(
                                        text = "Description: ",
                                        modifier = Modifier
                                            .padding(2.dp),
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = meal.description+"\n",
                                        modifier = Modifier
                                            .padding(2.dp),
                                        color = Color.Black,
                                        fontSize = 15.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

