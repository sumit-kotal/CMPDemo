package org.demo.multiplatform.di

import org.demo.multiplatform.data.remote.ApiService
import org.demo.multiplatform.data.repository.ProductRepositoryImpl
import org.demo.multiplatform.domain.repository.ProductRepository
import org.demo.multiplatform.presentation.home.HomeViewModel
import org.demo.multiplatform.presentation.login.LoginViewModel
import org.demo.multiplatform.presentation.detail.ProductDetailViewModel
import org.demo.multiplatform.presentation.profile.ProfileViewModel
import org.koin.dsl.module

fun appModule() = module {

    // API service - Ktor
    single { ApiService() }

    // Repositories
    single<ProductRepository> { ProductRepositoryImpl(get()) }

    // ViewModels
    factory { LoginViewModel() }
    factory { HomeViewModel(get()) }
    factory { ProductDetailViewModel() }
    factory { ProfileViewModel(get()) }
}