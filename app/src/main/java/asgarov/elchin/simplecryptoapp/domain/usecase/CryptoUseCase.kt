package asgarov.elchin.simplecryptoapp.domain.usecase

import asgarov.elchin.simplecryptoapp.domain.model.Crypto
import asgarov.elchin.simplecryptoapp.domain.repository.CryptoRepository
import asgarov.elchin.simplecryptoapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class CryptoUseCase @Inject constructor(
    private val cryptoRepository: CryptoRepository
) {

    fun getCrypto(): Flow<Resource<List<Crypto>>> = flow {

        try {
            emit(Resource.Loading())

            val crypto = cryptoRepository.getCrypto()

            emit(Resource.Success(crypto))
        }catch (e:HttpException){
            emit(Resource.Error("${e.localizedMessage}"))

        }catch (e:IOException){
            emit(Resource.Error("${e.localizedMessage}"))

        }
    }
}
