package com.vector.onBoardViews.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vector.onBoardViews.OnBoardViews.MainOnBoarding
import com.vector.onBoardViews.dataStore.StoreBoarding
import com.vector.onBoardViews.ui.components.HomeView
import com.vector.onBoardViews.ui.components.SplashScreen

@Composable
fun NavManager() {
    val navController = rememberNavController()
    val dataStore = StoreBoarding(context = LocalContext.current)
    val store = dataStore.getStoreBoarding.collectAsState(initial = false)
    NavHost(navController = navController, startDestination = if(store.value == true) "home" else "Splash" ){
        composable("Splash"){
            SplashScreen(navController = navController, store = store.value)
        }
        composable("onBoarding"){
            MainOnBoarding(navController = navController, storeBoarding = dataStore)
        }
        composable("home"){
            HomeView(navController = navController)
        }
    }
    
}