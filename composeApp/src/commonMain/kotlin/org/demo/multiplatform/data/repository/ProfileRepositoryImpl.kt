package org.demo.multiplatform.data.repository

import com.russhwolf.settings.Settings
import kotlinx.serialization.json.Json
import org.demo.multiplatform.data.remote.ApiService
import org.demo.multiplatform.domain.model.UserProfile
import org.demo.multiplatform.domain.repository.ProfileRepository
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

/**
 * Implementation of [ProfileRepository] that retrieves user profile data.
 *
 * This repository first attempts to load the user profile from local settings (cache).
 * If the cached data is older than 24 hours or not available, it fetches the profile
 * from the [apiService] and then updates the cache.
 *
 * @param apiService The service responsible for making network requests to fetch user profile data.
 * @param settings The [Settings] instance used for storing and retrieving cached user profile data.
 */
class ProfileRepositoryImpl(
    private val apiService: ApiService,
    private val settings: Settings
) : ProfileRepository {

    private val profileKey = "user_profile"
    private val profileTimestampKey = "user_profile_timestamp"

    @OptIn(ExperimentalTime::class)
    override suspend fun getUserProfile(): UserProfile {
        val currentTime = Clock.System.now()
        val cachedTime = settings.getLong(profileTimestampKey, 0L)

        return if ((currentTime.toEpochMilliseconds() - cachedTime) < 24 * 60 * 60 * 1000 && settings.hasKey(profileKey)) {
            Json.decodeFromString(UserProfile.serializer(), settings.getString(profileKey, ""))
        } else {
            val profile = apiService.getUserProfile()
            settings.putString(profileKey, Json.encodeToString(UserProfile.serializer(), profile))
            settings.putLong(profileTimestampKey, currentTime.toEpochMilliseconds())
            profile
        }
    }
}