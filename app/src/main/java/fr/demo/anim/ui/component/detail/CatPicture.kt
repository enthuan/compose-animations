package fr.demo.anim.ui.component.detail

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import fr.demo.anim.model.Cat
import fr.demo.anim.model.Gender
import fr.demo.anim.model.catList
import fr.demo.anim.ui.component.anim.BounceState
import fr.demo.anim.ui.theme.DemoTheme
import fr.demo.anim.R

@Composable
fun CatPicture(cat: Cat) {
    val painter = painterResource(id = cat.photoAsset)

    var currentState: BounceState by remember { mutableStateOf(BounceState.Released) }
    val transition = updateTransition(targetState = currentState, label = "animation")

    val scale: Float by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 500, easing = CubicBezierEasing(0.18f,1.66f,0.25f,0.77f)) },
        label = ""
    ) { state ->
        if (state == BounceState.Pressed) {
            0.85f
        } else {
            1f
        }
    }

    Image(
        painter = painter,
        contentDescription = "$cat.name, $cat.title",
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .scale(scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        currentState = BounceState.Pressed
                        tryAwaitRelease()
                        currentState = BounceState.Released
                    }
                )
            },
        contentScale = ContentScale.Crop
    )
}

@Preview()
@Composable
fun CatPicturePreview() {
    DemoTheme() {
        CatPicture(cat = catList[0])
    }
}