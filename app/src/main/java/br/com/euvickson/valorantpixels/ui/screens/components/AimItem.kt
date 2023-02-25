package br.com.euvickson.valorantpixels.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import br.com.euvickson.valorantpixels.model.AimModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AimItem(aim: AimModel) {
    Column() {
        GlideImage(model = aim.aimImage, contentDescription = "Aim image")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Copiar")
        }
    }
}