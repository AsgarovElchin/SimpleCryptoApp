package asgarov.elchin.simplecryptoapp.presentation.crpyto.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import asgarov.elchin.simplecryptoapp.domain.model.Crypto

@Composable
fun CryptoItem(
    crypto: Crypto
){
    Row(modifier = Modifier.fillMaxWidth().padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = crypto.code, fontSize = 20.sp,
            fontStyle = FontStyle.Normal)

        Text(text = crypto.pricestr + " " +crypto.currency,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic
        )
    }
}