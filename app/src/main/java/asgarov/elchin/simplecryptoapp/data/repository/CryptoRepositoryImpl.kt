package asgarov.elchin.simplecryptoapp.data.repository

import asgarov.elchin.simplecryptoapp.data.mapper.toCrypto
import asgarov.elchin.simplecryptoapp.data.remote.CryptoAPI
import asgarov.elchin.simplecryptoapp.domain.model.Crypto
import asgarov.elchin.simplecryptoapp.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val cryptoAPI: CryptoAPI
):CryptoRepository {
    override suspend fun getCrypto(): List<Crypto> {

        val cryptoDto = cryptoAPI.getCrypto()

        if(cryptoDto.success){
            return cryptoDto.toCrypto()
        }
        else{
            throw Exception("API call failed: success = false")
        }


    }
}