package asgarov.elchin.simplecryptoapp.presentation.crpyto

import asgarov.elchin.simplecryptoapp.domain.model.Crypto

data class CryptoState(
    val isLoading:Boolean = false,
    val crypto:List<Crypto> = emptyList(),
    val error:String = ""
)
