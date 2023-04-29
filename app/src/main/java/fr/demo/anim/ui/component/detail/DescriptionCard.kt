package fr.demo.anim.ui.component.detail

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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

            // TODO 4 BCR Tempérament (animateFloatAsState & tween) / (rotation)

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
                        // TODO 4 BCR Tempérament / Rotation (rotate)
                    ,
                    imageVector = Icons.Filled.KeyboardArrowUp,
                    contentDescription = "Back"
                )
            }

            if (expandState) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    text = cat.temper
                )
            }
            // TODO 5 BCR Tempérament / Expanded v1

        }
    }
}
