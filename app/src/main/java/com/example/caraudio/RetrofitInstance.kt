package com.example.caraudio

import com.example.caraudio.home.model.Products
import com.example.caraudio.home.network.ProductService
import com.example.caraudio.intropage.network.LoginService
import com.example.caraudio.register.network.RegisterService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://real-gray-cheetah-fez.cyclic.app/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val loginService: LoginService by lazy {
        retrofit.create(LoginService::class.java)

    }
    val registerService: RegisterService by lazy {
        retrofit.create(RegisterService::class.java)

    }
    val productsService: ProductService by lazy {
        retrofit.create(ProductService::class.java)
    }
}
