package com.edwin.mobilecomputing.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.edwin.mobilecomputing.ui.home.Home
import com.edwin.mobilecomputing.ui.login.Login
import com.edwin.mobilecomputing.ui.maps.PaymentLocationMap
import com.edwin.mobilecomputing.ui.payment.Payment

@Composable
fun MobileComputingApp(
    appState: MobileComputingAppState = rememberMobileComputingAppState()
) {
    NavHost(
        navController = appState.navController,
        startDestination = "login"
    ) {
        composable(route = "login") {
            Login(navController = appState.navController)
        }
        composable("home") {
            Home(navController = appState.navController)
        }
        composable(route = "payment") {
            Payment(
                onBackPress = appState::navigateBack,
                navController = appState.navController
            )
        }

        composable(route = "map") {
            PaymentLocationMap(navController = appState.navController)
        }
    }
}