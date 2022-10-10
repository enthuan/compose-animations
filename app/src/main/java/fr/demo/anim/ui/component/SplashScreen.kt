package fr.demo.anim.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.demo.anim.ui.theme.DemoTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onLoadingComplete: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(3000)
        onLoadingComplete()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .wrapContentWidth(align = Alignment.CenterHorizontally)
    ) {
        TwerkingCatView(
            Modifier.fillMaxWidth(.4f)
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    DemoTheme {
        SplashScreen(
            onLoadingComplete = {}
        )
    }
}