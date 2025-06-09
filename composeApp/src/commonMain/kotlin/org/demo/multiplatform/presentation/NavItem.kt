package org.demo.multiplatform.presentation

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
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.core.screen.Screen
import compose.icons.FeatherIcons
import compose.icons.feathericons.Home
import compose.icons.feathericons.UserX
import org.demo.multiplatform.presentation.home.HomeScreen
import org.demo.multiplatform.presentation.profile.ProfileScreen

data class NavItem(val label: String, val icon: ImageVector, val screen: Screen)

object RootScreen : Screen {

    private val navItems = listOf(
        NavItem("Home", FeatherIcons.Home, HomeScreen),
        NavItem("Profile", FeatherIcons.UserX, ProfileScreen)
    )

    @Composable
    override fun Content() {
        var selectedIndex by remember { mutableStateOf(0) }

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
            when (val screen = navItems[selectedIndex].screen) {
                is HomeScreen -> screen.Content()
                is ProfileScreen -> screen.Content()
            }
        }
    }
}