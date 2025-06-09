package org.demo.multiplatform.data.repository

import org.demo.multiplatform.domain.model.Product
import org.demo.multiplatform.domain.repository.ProductRepository
import org.demo.multiplatform.data.remote.ApiService

/**
 * Implementation of the [ProductRepository] interface.
 *
 * This class is responsible for fetching product data from the [ApiService].
 *
 * @property apiService The [ApiService] instance used to make network requests.
 */
class ProductRepositoryImpl(
    private val apiService: ApiService
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return try {
            apiService.getProducts()
        } catch (e: Exception) {
            emptyList()
        }
    }

}