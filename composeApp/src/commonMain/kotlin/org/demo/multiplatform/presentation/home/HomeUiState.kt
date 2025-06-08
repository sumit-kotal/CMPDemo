package org.demo.multiplatform.presentation.home

import org.demo.multiplatform.domain.model.Product

data class HomeUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)