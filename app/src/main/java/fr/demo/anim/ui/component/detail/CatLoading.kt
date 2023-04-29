package fr.demo.anim.ui.component.detail

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import fr.demo.anim.R
import fr.demo.anim.ui.theme.DemoTheme
import kotlinx.coroutines.delay

@Composable
fun CatLoading(modifier: Modifier) {
    Row(
        modifier = modifier.wrapContentWidth(align = Alignment.CenterHorizontally),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat((0..2).count()) { index ->
            CatLoadingItem(index = index, circleSize = 42.dp)
        }
    }
}

@Composable
fun CatLoadingItem(
    index: Int = 0,
    circleSize: Dp = 25.dp,
    circleColor: Color = MaterialTheme.colorScheme.primary,
    travelDistance: Dp = 20.dp
) {
    val animatable = remember { Animatable(initialValue = 0f) }

    LaunchedEffect(key1 = animatable) {
        delay(index * 100L)
        animatable.animateTo(
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = keyframes {
                    durationMillis = 1200
                    0.0f at 0 with LinearOutSlowInEasing
                    1.0f at 300 with LinearOutSlowInEasing
                    0.0f at 600 with LinearOutSlowInEasing
                    0.0f at 1200 with LinearOutSlowInEasing
                },
                repeatMode = RepeatMode.Restart
            )
        )
    }

    val circleValue = animatable.value
    val distance = with(LocalDensity.current) { travelDistance.toPx() }

    Image(
        modifier = Modifier
            .size(circleSize)
            .graphicsLayer {
                translationY = -circleValue * distance
            },
        painter = painterResource(id = R.drawable.cat_icon),
        contentDescription = null,
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
    )

}

@Preview
@Composable
fun CatLoadingPreview() {
    DemoTheme {
        CatLoading(Modifier)
    }
}