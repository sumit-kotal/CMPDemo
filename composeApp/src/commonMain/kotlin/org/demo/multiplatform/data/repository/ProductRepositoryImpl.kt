package org.demo.multiplatform.data.repository

import org.demo.multiplatform.domain.model.Product
import org.demo.multiplatform.domain.repository.ProductRepository
import org.demo.multiplatform.data.remote.ApiService

class ProductRepositoryImpl(
    private val apiService: ApiService
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return try {
            apiService.getProducts()
        } catch (e: Exception) {
            // You can later expand this with Result wrapper
            emptyList()
        }
    }

}