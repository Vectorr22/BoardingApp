package com.vector.onBoardViews.OnBoardViews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.vector.onBoardViews.data.PageData
import com.vector.onBoardViews.dataStore.StoreBoarding

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    modifier: Modifier = Modifier,
    item: List<PageData>,
    pagerState: PagerState,
    navController: NavController,
    storeBoarding: StoreBoarding
) {
    Box(modifier = modifier){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .padding(60.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    
                    LoaderData(image = item[page].image, modifier = Modifier
                        .size(200.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                    )
                    Text(text = item[page].title,
                        modifier = Modifier
                            .padding(top = 50.dp),
                        color = Color.Black,
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp)
                }

                
            }
            PageIndicator(size = item.size, currentPage = pagerState.currentPage)
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)){
            ButtonFinish(currentPage = pagerState.currentPage, navController = navController, storeBoarding = storeBoarding)
        }
        
    }

}