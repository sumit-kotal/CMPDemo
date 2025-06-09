package org.demo.multiplatform.domain.model

import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.core.screen.Screen

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val screen: Screen
)
