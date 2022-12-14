package fr.demo.anim.ui.component.detail

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.demo.anim.ui.theme.NoRippleTheme

@Composable
fun FavButton(modifier : Modifier = Modifier) {

    var isFav by remember { mutableStateOf(false) }
    val onFav = { isFav = !isFav }

    val animationSpec = tween<Color>(400)
    val contentColor = animateColorAsState(
        targetValue = if (isFav) {
            MaterialTheme.colorScheme.onPrimary
        } else {
            MaterialTheme.colorScheme.onSurface
        },
        animationSpec = animationSpec
    )
    val containerColor = animateColorAsState(
        targetValue = if (isFav) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.surface
        },
        animationSpec = animationSpec
    )

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Button(
            modifier = modifier.height(60.dp),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = containerColor.value,
                contentColor = contentColor.value,
            ),
            onClick = onFav
        )
        {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                tint = contentColor.value
            )
        }
    }
}
