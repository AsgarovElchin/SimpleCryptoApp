package asgarov.elchin.simplecryptoapp.presentation.crpyto

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import asgarov.elchin.simplecryptoapp.presentation.crpyto.components.CryptoItem

@Composable
fun CryptoScreen(
    cryptoViewModel: CryptoViewModel = hiltViewModel()
){
    val state = cryptoViewModel.cryptoState.value

    Box(modifier = Modifier.fillMaxSize().padding(top = 32.dp)){
        LazyColumn {
            items(state.crypto){crypto->
                CryptoItem(crypto)
                HorizontalDivider()
            }
        }

        if(state.error.isNotBlank()){
            Text(text = state.error, color = MaterialTheme.colorScheme.error,
                modifier = Modifier.fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.Center))
        }


        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}