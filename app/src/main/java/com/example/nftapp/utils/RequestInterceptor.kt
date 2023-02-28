package com.example.nftapp.utils

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        chain.request().newBuilder().apply {
            addHeader("Authorization", "Bearer " +
                    "5cfe19f2d6msha310eacbd77b904p16c66ejsn90767d3986a0")
        }.build().also { return chain.proceed(it) }
    }
}