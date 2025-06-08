package org.demo.multiplatform.domain.repository

import org.demo.multiplatform.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}