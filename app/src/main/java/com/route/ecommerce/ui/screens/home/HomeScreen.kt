package com.route.ecommerce.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.route.ecommerce.ui.EcomAppState

@Composable
fun HomeScreen(
    appState: EcomAppState,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = "welcome home")
        Button(onClick = appState::navigateToProducts) {
            Text(text = "products")
        }
        Button(onClick = { appState.navigateToProductDetails("123") }) {
            Text(text = "product details")
        }
    }
}