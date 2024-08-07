package com.route.ecommerce.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.route.ecommerce.ui.EcomAppState
import com.route.ecommerce.ui.auth.forgotPasswordScreen
import com.route.ecommerce.ui.auth.loginScreen
import com.route.ecommerce.ui.auth.signupScreen

@Composable
fun EcomNavHost(
    appState: EcomAppState,
    onBackPressed: () -> Unit,
    cartItems: Map<String, Int>,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = appState.navController,
        startDestination = TopLevelDestination.HOME.name,
        contentAlignment = Alignment.TopCenter,
        modifier = modifier,
        enterTransition = { fadeIn(animationSpec = tween(300)) },
        exitTransition = { fadeOut(animationSpec = tween(300)) },
        popEnterTransition = { fadeIn(animationSpec = tween(300)) },
        popExitTransition = { fadeOut(animationSpec = tween(300)) },
    ) {
        homeScreen(
            appState = appState
        )
        menuScreen(
            appState = appState,
            onBackPressed = onBackPressed
        )
        cartScreen(
            appState = appState,
            onBackPressed = onBackPressed
        )
        accountScreen(
            appState = appState,
            onBackPressed = onBackPressed
        )
        loginScreen(appState)
        signupScreen(appState)
        forgotPasswordScreen(appState)
        productsScreen(appState)
        productDetailsScreen(appState)
        searchScreen(
            appState = appState,
            cartItems = cartItems
        )
        wishlistScreen(appState)
        checkoutScreen(appState)
    }
}