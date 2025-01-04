package asgarov.elchin.simplecryptoapp.di

import asgarov.elchin.simplecryptoapp.data.remote.CryptoAPI
import asgarov.elchin.simplecryptoapp.data.repository.CryptoRepositoryImpl
import asgarov.elchin.simplecryptoapp.domain.repository.CryptoRepository
import asgarov.elchin.simplecryptoapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CryptoModule {

    @Provides
    @Singleton
    fun provideApi():CryptoAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(cryptoAPI: CryptoAPI):CryptoRepository{
        return CryptoRepositoryImpl(cryptoAPI)
    }
}