package fr.demo.anim.ui.component.detail

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.demo.anim.model.Cat
import fr.demo.anim.ui.theme.DemoTheme
import kotlinx.coroutines.delay

@Composable
fun AbilitiesView(cat: Cat, modifier: Modifier = Modifier) {

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(10.dp)) {
        AbilityRow("Câlin", cat.abilities.first)
        AbilityRow("Malin", cat.abilities.second)
        AbilityRow("Indépendant", cat.abilities.third)
    }

}

@Composable
private fun AbilityRow(
    label: String,
    value: Float = 0f,
    color: Color = MaterialTheme.colorScheme.secondary
) {
    val animatable = remember { Animatable(value) }

    // TODO BCR LaunchedEffect progressbar (launch)
    


    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            text = label
        )
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            progress = animatable.value,
            color = color,
            trackColor = color.copy(alpha = 0.4f)
        )
    }
}

@Preview()
@Composable
fun AbilityRowPreview() {
    DemoTheme {
        AbilityRow("Label", 0.5f)
    }
}