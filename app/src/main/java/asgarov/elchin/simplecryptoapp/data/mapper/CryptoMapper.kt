package asgarov.elchin.simplecryptoapp.data.mapper

import asgarov.elchin.simplecryptoapp.data.remote.dto.CryptoDto
import asgarov.elchin.simplecryptoapp.domain.model.Crypto

fun CryptoDto.toCrypto():List<Crypto>{
    return result.map {
        Crypto(
            code = it.code,
            currency = it.currency,
            pricestr = it.pricestr
        )
    }

}

