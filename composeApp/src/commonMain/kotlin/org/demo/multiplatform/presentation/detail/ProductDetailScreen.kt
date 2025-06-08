package org.demo.multiplatform.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import org.demo.multiplatform.domain.model.Product
import androidx.compose.ui.layout.ContentScale
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

data class ProductDetailScreen(val product: Product) : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(product.title) })
            }
        ) { padding ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(padding)) {
                KamelImage(
                    resource = asyncPainterResource(data = product.imageUrl),
                    contentDescription = product.title,
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    contentScale = ContentScale.Crop,
                    onLoading = { progress -> /* Optional: Show a progress indicator */ },
                    onFailure = { exception -> /* Optional: Show an error placeholder */ }
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(text = product.subtitle, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = product.description, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}