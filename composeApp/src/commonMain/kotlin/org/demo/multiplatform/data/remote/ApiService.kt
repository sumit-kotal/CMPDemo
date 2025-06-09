package org.demo.multiplatform.data.remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.demo.multiplatform.domain.model.Product
import org.demo.multiplatform.domain.model.UserProfile

class ApiService {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    private val localIP = "192.168.0.196"

    private val baseUrl = "http://$localIP:2727"

    suspend fun getProducts(): List<Product> {
        return try {
            val response: HttpResponse = httpClient.get("$baseUrl/products")
            val body: List<Product> = response.body()
            println("API Response: $body")
            body
        } catch (e: Exception) {
            println("API error: ${e.message}")
            emptyList()
        }
    }

    suspend fun getUserProfile(): UserProfile {
        val response: HttpResponse = httpClient.get("$baseUrl/profile")
        return response.body()
    }

}