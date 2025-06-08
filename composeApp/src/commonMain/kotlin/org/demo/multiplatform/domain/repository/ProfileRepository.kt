package org.demo.multiplatform.domain.repository

import org.demo.multiplatform.domain.model.UserProfile

interface ProfileRepository {
    suspend fun getUserProfile(): UserProfile
}