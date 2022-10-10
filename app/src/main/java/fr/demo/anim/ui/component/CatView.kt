package fr.demo.anim.ui.component

import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import android.util.Log
import fr.demo.anim.R
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import fr.demo.anim.model.Cat
import fr.demo.anim.model.catList
import fr.demo.anim.ui.theme.DemoTheme

@Composable
fun CatView(
    cat: Cat,
    modifier: Modifier = Modifier
) {
    CatView(
        modifier,
        cat.name,
        cat.title,
        cat.photoAsset
    )
}

@Composable
private fun CatView(
    modifier: Modifier = Modifier,
    name: String,
    title: String,
    @DrawableRes imagePath: Int,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surface
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        val model = ImageRequest.Builder(LocalContext.current)
            .data(imagePath)
            .crossfade(true)
            .build()
        AsyncImage(
            model = model,
            contentDescription = "$name, $title",
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.cat_01)
        )
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.57f)
            )
        }
    }
}

@Preview(
    name = "",
    group = "Preview",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "",
    group = "Preview",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun CatViewPreview() {
    val cat = catList[2]
    DemoTheme {
        CatView(cat = cat)
    }
}
