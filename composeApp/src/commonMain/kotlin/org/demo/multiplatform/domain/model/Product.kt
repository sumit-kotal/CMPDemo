package org.demo.multiplatform.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: String,
    val title: String,
    val subtitle: String,
    val imageUrl: String,
    val description: String
)