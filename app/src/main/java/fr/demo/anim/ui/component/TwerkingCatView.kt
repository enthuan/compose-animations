package fr.demo.anim.ui.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.demo.anim.R

@Composable
fun TwerkingCatView(modifier: Modifier = Modifier) {

    val rotationValue = 0f

    // TODO 1 ARO Ass rotation

    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.cat_layer_back),
            contentDescription = "Twerking cat",
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    rotationZ = rotationValue
                    // TODO 2 ARO Ass rotation
                },
            contentScale = ContentScale.Fit
        )
        Image(
            painter = painterResource(id = R.drawable.cat_layer_front),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview
@Composable
fun TwerkingCatPreview() {
    TwerkingCatView(
        modifier = Modifier.size(180.dp)
    )
}