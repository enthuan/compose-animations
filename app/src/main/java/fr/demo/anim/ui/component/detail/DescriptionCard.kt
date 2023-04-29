package fr.demo.anim.ui.component.detail

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import fr.demo.anim.model.Cat

@Composable
fun DescriptionCard(cat: Cat) {
    Card {
        Column {
            var expandState by rememberSaveable { mutableStateOf(true) }
            val arrowRotation by animateFloatAsState(
                targetValue = (if (expandState) {
                    -180f
                } else {
                    0f
                }),
                animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
            )
            val onClick = { expandState = !expandState }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    style = MaterialTheme.typography.titleMedium,
                    text = "Tempérament"
                )
                Icon(
                    modifier = Modifier
                        .padding(16.dp)
                        .rotate(arrowRotation),
                    imageVector = Icons.Filled.KeyboardArrowUp,
                    contentDescription = "Back"
                )
            }

            AnimatedVisibility(
                visible = expandState,
                enter = slideInVertically(
                    initialOffsetY = { fullHeight -> fullHeight * -1 },
                    animationSpec = tween(durationMillis = 150, easing = LinearOutSlowInEasing)
                ),
                exit = slideOutVertically(
                    targetOffsetY = { fullHeight -> (fullHeight * -1) },
                    animationSpec = tween(durationMillis = 150, easing = FastOutLinearInEasing)
                )
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    text = cat.temper
                )
            }

        }
    }
}
