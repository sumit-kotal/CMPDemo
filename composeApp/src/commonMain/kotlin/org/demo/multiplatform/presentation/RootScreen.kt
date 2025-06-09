package org.demo.multiplatform.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import compose.icons.FeatherIcons
import compose.icons.feathericons.Home
import compose.icons.feathericons.User
import org.demo.multiplatform.domain.model.NavItem
import org.demo.multiplatform.presentation.home.HomeScreen
import org.demo.multiplatform.presentation.profile.ProfileScreen
import org.demo.multiplatform.theme.AppTheme

/**
 * Represents the root screen of the application, managing navigation between different sections.
 *
 * This screen utilizes a bottom navigation bar to switch between [HomeScreen] and [ProfileScreen].
 * It maintains the state of the currently selected navigation item and displays the corresponding
 * screen's content.
 */
object RootScreen : Screen {

    private val navItems = listOf(
        NavItem("Home", FeatherIcons.Home, HomeScreen),
        NavItem("Profile", FeatherIcons.User, ProfileScreen)
    )

    @Composable
    override fun Content() {
        var selectedIndex by remember { mutableStateOf(0) }

        AppTheme {
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        navItems.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedIndex == index,
                                onClick = { selectedIndex = index },
                                icon = { Icon(item.icon, contentDescription = item.label) },
                                label = { Text(item.label) }
                            )
                        }
                    }
                }
            ) { padding ->
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                ) {
                    when (val screen = navItems[selectedIndex].screen) {
                        is HomeScreen -> screen.Content()
                        is ProfileScreen -> screen.Content()
                    }
                }
            }
        }

    }
}