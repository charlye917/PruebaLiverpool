package com.charlye934.shoppinliverpool.di

import com.charlye934.shoppinliverpool.BuildConfig
import com.charlye934.shoppinliverpool.home.data.service.HomeService
import com.charlye934.shoppinliverpool.util.ConstantsServices.BUILD_TYPE_DEBUG
import com.charlye934.shoppinliverpool.util.ConstantsServices.TIME_OUT
import com.charlye934.shoppinliverpool.util.ConstantsServices.USER_AGENT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpLoginInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            if(BuildConfig.BUILD_TYPE == BUILD_TYPE_DEBUG)
                level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .readTimeout(TIME_OUT, TimeUnit.MINUTES)
            .connectTimeout(TIME_OUT, TimeUnit.MINUTES)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor{ chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header(USER_AGENT, original.url.host)
                    .method(original.method, original.body)
                val request = requestBuilder.build()
                return@addInterceptor chain.proceed(request)
            }
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun providesHomeData(retrofit: Retrofit) =
        retrofit.create(HomeService::class.java)
}