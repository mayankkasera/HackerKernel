package com.rightbuy.hackerkerneltask.di.module



import com.rightbuy.hackerkerneltask.network.authentication.AuthenticationRepository
import com.rightbuy.hackerkerneltask.network.authentication.AuthenticationRepositoryI
import com.rightbuy.hackerkerneltask.network.authentication.AuthenticationRequests
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
}