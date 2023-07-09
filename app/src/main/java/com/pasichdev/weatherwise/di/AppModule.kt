package com.pasichdev.weatherwise.di

import android.app.Application
import androidx.room.Room
import com.pasichdev.weatherwise.data.LocalDatabase
import com.pasichdev.weatherwise.data.network.ApiService
import com.pasichdev.weatherwise.data.repository.AppRepository
import com.pasichdev.weatherwise.data.repository.AppRepositoryImpl
import com.pasichdev.weatherwise.utils.API_URL
import com.pasichdev.weatherwise.utils.NAME_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModules {
    @Provides
    fun provideRetrofit(): Retrofit {
        val client = OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        ).build()
        return Retrofit.Builder().baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(client).build()
    }

    @Provides
    fun provideNetworkService(
        retrofit: Retrofit
    ): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideAppRepository(
        apiService: ApiService,
        localDatabase: LocalDatabase
    ): AppRepository = AppRepositoryImpl(
        apiService = apiService,
        localDatabase = localDatabase
    )

    @Provides
    @Singleton
    fun provideDb(application: Application): LocalDatabase {
        return Room.databaseBuilder(
            application,
            LocalDatabase::class.java,
            NAME_DB
        ).build()
    }



}