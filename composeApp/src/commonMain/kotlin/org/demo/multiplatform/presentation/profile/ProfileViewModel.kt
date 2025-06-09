package org.demo.multiplatform.presentation.profile

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.demo.multiplatform.domain.repository.ProfileRepository

/**
 * ViewModel for the Profile screen.
 *
 * This ViewModel is responsible for fetching and managing the user's profile data.
 * It exposes the profile data as a [StateFlow] of [ProfileUiState], which can be observed
 * by the UI to update itself.
 *
 * @param repository The [ProfileRepository] used to fetch the user's profile data.
 */
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