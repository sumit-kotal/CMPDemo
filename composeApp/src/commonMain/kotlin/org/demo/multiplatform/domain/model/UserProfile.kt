package org.demo.multiplatform.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserProfile(
    val name: String,
    val email: String,
    val phone: String
)