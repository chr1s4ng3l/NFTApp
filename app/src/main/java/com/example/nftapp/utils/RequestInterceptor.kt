package com.example.nftapp.utils

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        chain.request().newBuilder().apply {
            addHeader("X-RapidAPI-Key", "5cfe19f2d6msha310eacbd77b904p16c66ejsn90767d3986a0")
            .addHeader("X-RapidAPI-Host", "opensea13.p.rapidapi.com")
        }.build().also { return chain.proceed(it) }
    }
}