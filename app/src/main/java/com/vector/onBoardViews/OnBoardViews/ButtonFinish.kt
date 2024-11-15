package com.vector.onBoardViews.OnBoardViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vector.onBoardViews.dataStore.StoreBoarding
import kotlinx.coroutines.launch

@Composable
fun ButtonFinish(
    modifier: Modifier = Modifier,
    currentPage: Int,
    navController: NavController,
    storeBoarding: StoreBoarding
) {
    val corroutineScope = rememberCoroutineScope()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalArrangement = if (currentPage != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {

        if (currentPage == 2) {
            OutlinedButton(onClick = {
                navController.navigate("home"){popUpTo(0)}
                corroutineScope.launch {
                    storeBoarding.saveBoarding(true)
                }
            }) {
                Text(
                    text = "Entrar", modifier = Modifier
                        .padding(
                            horizontal = 40.dp,
                            vertical = 8.dp
                        )
                )
            }
        }

    }
}