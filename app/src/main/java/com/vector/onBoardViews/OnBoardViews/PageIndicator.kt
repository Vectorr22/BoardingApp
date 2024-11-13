package com.vector.onBoardViews.OnBoardViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(modifier: Modifier = Modifier, size: Int, currentPage: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.padding(top = 60.dp)

    ) {

        repeat(size){
            Indicator(isSelect = it==currentPage)
        }

    }
}

@Composable
fun Indicator(modifier: Modifier = Modifier, isSelect: Boolean) {
    Box(modifier = modifier
        .padding(5.dp)
        .height(10.dp)
        .width(25.dp)
        .clip(CircleShape)
        .background(if (isSelect) Color.Red else Color.Gray))
}