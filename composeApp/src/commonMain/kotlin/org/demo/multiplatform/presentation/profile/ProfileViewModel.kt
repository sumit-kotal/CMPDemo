package org.demo.multiplatform.presentation.profile

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.demo.multiplatform.domain.repository.ProfileRepository

class ProfileViewModel(
    private val repository: ProfileRepository
) {

    private val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState

    init {
        fetchProfile()
    }

    fun fetchProfile() {
        viewModelScope.launch {
            _uiState.value = ProfileUiState(isLoading = true)
            try {
                val profile = repository.getUserProfile()
                _uiState.value = ProfileUiState(profile = profile)
            } catch (e: Exception) {
                _uiState.value = ProfileUiState(error = e.message)
            }
        }
    }
}