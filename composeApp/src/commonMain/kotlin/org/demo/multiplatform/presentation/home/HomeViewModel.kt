package org.demo.multiplatform.presentation.home

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.demo.multiplatform.domain.repository.ProductRepository

class HomeViewModel(
    private val repository: ProductRepository
) {

    private val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)

            try {
                val products = repository.getProducts()
                _uiState.value = _uiState.value.copy(isLoading = false, products = products)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message ?: "Unknown Error")
            }
        }
    }
}