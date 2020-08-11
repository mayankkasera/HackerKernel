package com.rightbuy.hackerkerneltask.di.module



import com.rightbuy.hackerkerneltask.network.authentication.AuthenticationRepository
import com.rightbuy.hackerkerneltask.network.authentication.AuthenticationRepositoryI
import com.rightbuy.hackerkerneltask.network.authentication.AuthenticationRequests
import com.rightbuy.hackerkerneltask.network.photo.PhotoRepository
import com.rightbuy.hackerkerneltask.network.photo.PhotoRepositoryI
import com.rightbuy.hackerkerneltask.network.photo.PhotoRequests
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [NetworkModule::class]
)
class DataModule {
    @Provides
    @Singleton
    fun provideAuthenticatioinRepository(authenticationRequests: AuthenticationRequests) : AuthenticationRepositoryI {
        return AuthenticationRepository(authenticationRequests)
    }

    @Provides
    @Singleton
    fun providePhotoRepository(photoRequests: PhotoRequests) : PhotoRepositoryI {
        return PhotoRepository(photoRequests)
    }
}