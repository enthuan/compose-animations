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

    val infiniteTransition = rememberInfiniteTransition()
    val assRotation by infiniteTransition.animateFloat(
        initialValue = -20f,
        targetValue = -20f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1200
                -20.0f at 0 with LinearOutSlowInEasing
                20f at 600 with LinearOutSlowInEasing
                -20f at 1200 with LinearOutSlowInEasing
            },
            repeatMode = RepeatMode.Restart
        )
    )

    val rotationValue = assRotation
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.cat_layer_back),
            contentDescription = "Twerking cat",
            modifier = Modifier.fillMaxSize()
                .graphicsLayer {
                    rotationZ = rotationValue
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