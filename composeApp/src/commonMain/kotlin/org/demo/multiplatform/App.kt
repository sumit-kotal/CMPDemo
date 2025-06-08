package org.demo.multiplatform

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.demo.multiplatform.di.appModule
import org.demo.multiplatform.presentation.login.LoginScreen
import org.koin.core.context.startKoin

@Composable
fun App() {
    startKoin {
        modules(appModule())
    }
    Navigator(LoginScreen)
}
