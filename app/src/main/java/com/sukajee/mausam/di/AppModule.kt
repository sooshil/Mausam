package com.sukajee.mausam.di

import com.sukajee.mausam.data.api.WeatherApi
import com.sukajee.mausam.data.repository.BaseRepository
import com.sukajee.mausam.data.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.open-meteo.com/v1/")
            .client(
                OkHttpClient().newBuilder()
                    .addInterceptor(
                        HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BASIC)
                    )
                    .connectTimeout(100000L, TimeUnit.MILLISECONDS)
                    .readTimeout(100000L, TimeUnit.MILLISECONDS)
                    .writeTimeout(100000L, TimeUnit.MILLISECONDS).build()
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideWeatherApi(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

    @Singleton
    @Provides
    fun provideWeatherRepository(weatherApi: WeatherApi): BaseRepository {
        return WeatherRepository(weatherApi)
    }
}