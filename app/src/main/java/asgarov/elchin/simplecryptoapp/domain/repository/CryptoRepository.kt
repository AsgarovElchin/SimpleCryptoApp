package asgarov.elchin.simplecryptoapp.domain.repository

import asgarov.elchin.simplecryptoapp.domain.model.Crypto


interface CryptoRepository {

    suspend fun getCrypto():List<Crypto>

}