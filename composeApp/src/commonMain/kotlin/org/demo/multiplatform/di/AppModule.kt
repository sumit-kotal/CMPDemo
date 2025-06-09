package org.demo.multiplatform.di

import com.russhwolf.settings.Settings
import org.demo.multiplatform.data.remote.ApiService
import org.demo.multiplatform.data.repository.ProductRepositoryImpl
import org.demo.multiplatform.data.repository.ProfileRepositoryImpl
import org.demo.multiplatform.domain.repository.ProductRepository
import org.demo.multiplatform.domain.repository.ProfileRepository
import org.demo.multiplatform.presentation.home.HomeViewModel
import org.demo.multiplatform.presentation.login.LoginViewModel
import org.demo.multiplatform.presentation.detail.ProductDetailViewModel
import org.demo.multiplatform.presentation.profile.ProfileViewModel
import org.koin.dsl.module

fun appModule() = listOf(
    networkModule,
    viewModelModule,
    repositoryModule,
    settingsModule
)

/**
 * Module providing settings-related dependencies.
 */
val settingsModule = module {
    single { Settings() }
}

/**
 * Network module for providing API service. - Ktor
 */
val networkModule = module {
    single { ApiService() }
}

/**
 * Koin module for providing repository dependencies.
 *
 * This module defines how repository interfaces are implemented and provided
 * to other parts of the application.
 */
val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get()) }
    single<ProfileRepository> { ProfileRepositoryImpl(get(),get()) }
}

/**
 * Koin module for providing ViewModel instances.
 * This module defines how ViewModels are created and injected throughout the application.
 *
 * - `LoginViewModel`: Provided as a factory, meaning a new instance is created each time it's requested.
 * - `HomeViewModel`: Provided as a factory, depends on a `ProductRepository` (obtained via `get()`).
 * - `ProductDetailViewModel`: Provided as a factory.
 * - `ProfileViewModel`: Provided as a factory, depends on a `ProfileRepository` (obtained via `get()`).
 */
val viewModelModule = module {
    factory { LoginViewModel() }
    factory { HomeViewModel(get()) }
    factory { ProductDetailViewModel() }
    factory { ProfileViewModel(get()) }
}