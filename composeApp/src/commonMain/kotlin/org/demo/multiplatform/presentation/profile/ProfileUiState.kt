package org.demo.multiplatform.presentation.profile

import org.demo.multiplatform.domain.model.UserProfile

data class ProfileUiState(
    val isLoading: Boolean = false,
    val profile: UserProfile? = null,
    val error: String? = null
)