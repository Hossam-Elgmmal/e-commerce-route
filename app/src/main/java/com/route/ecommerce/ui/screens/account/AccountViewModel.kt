package com.route.ecommerce.ui.screens.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.datastore.UserPreferencesRepository
import com.route.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository,
) : ViewModel() {
    val accountUiState: StateFlow<AccountUiState> =
        userPreferencesRepository.userData
            .map {
                AccountUiState.Ready(
                    userData = it
                )
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = AccountUiState.Loading
            )
}

sealed interface AccountUiState {
    data object Loading : AccountUiState
    data class Ready(val userData: UserData) : AccountUiState
}