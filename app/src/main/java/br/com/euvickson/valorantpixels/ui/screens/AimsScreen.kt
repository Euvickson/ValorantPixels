package br.com.euvickson.valorantpixels.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.euvickson.valorantpixels.samples.aimDescriptionSample1
import br.com.euvickson.valorantpixels.samples.aimDescriptionSample2
import br.com.euvickson.valorantpixels.samples.aimListSample
import br.com.euvickson.valorantpixels.samples.aimTitleSample
import br.com.euvickson.valorantpixels.ui.screens.components.AimItem

@Composable
fun AimScreen(innerPadding: PaddingValues) {

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            item {
                Text(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    text = aimTitleSample
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(textAlign = TextAlign.Justify, text = aimDescriptionSample1)
                Text(textAlign = TextAlign.Justify, text = aimDescriptionSample2)
            }
            items(aimListSample.size) {
                AimItem(aimListSample[it])
            }
        }
    )
}