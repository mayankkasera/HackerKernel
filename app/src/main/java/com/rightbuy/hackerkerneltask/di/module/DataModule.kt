package com.rightbuy.hackerkerneltask.di.module



import com.rightbuy.hackerkerneltask.network.api.authentication.AuthenticationRepository
import com.rightbuy.hackerkerneltask.network.api.authentication.AuthenticationRepositoryI
import com.rightbuy.hackerkerneltask.network.api.authentication.AuthenticationRequests
import com.rightbuy.hackerkerneltask.network.api.photo.PhotoRepository
import com.rightbuy.hackerkerneltask.network.api.photo.PhotoRepositoryI
import com.rightbuy.hackerkerneltask.network.api.photo.PhotoRequests
import com.rightbuy.hackerkerneltask.network.api.post.PostRepository
import com.rightbuy.hackerkerneltask.network.api.post.PostRepositoryI
import com.rightbuy.hackerkerneltask.network.api.post.PostRequests
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
        return AuthenticationRepository(
            authenticationRequests
        )
    }

    @Provides
    @Singleton
    fun providePhotoRepository(photoRequests: PhotoRequests) : PhotoRepositoryI {
        return PhotoRepository(
            photoRequests
        )
    }

    @Provides
    @Singleton
    fun providePostRepository(postRequests: PostRequests) : PostRepositoryI {
        return PostRepository(
            postRequests
        )
    }

}