package fr.demo.anim.ui.component.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CatInfoBloc(modifier: Modifier = Modifier, content: String, label: String) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.tertiaryContainer, RoundedCornerShape(8.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.onTertiaryContainer,
            text = label
        )
        Text(
            style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.align(Alignment.CenterHorizontally),
        color = MaterialTheme.colorScheme.onBackground,
        text = content
        )
    }
}
